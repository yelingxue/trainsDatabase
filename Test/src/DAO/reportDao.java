package DAO;

import  entity.report;
import util.DBUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class reportDao {
    int id, totalPrice, num;
    String month, day, SNo, City1, City2, GNo;

    public List<report> list() {
        List<report> reports = new ArrayList<>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            readSNo();
            String sql ="exec incomeProc '"+SNo+"'";
            ResultSet rs = s.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                report report = new report();
                day = rs.getString(1);
                int temp = Integer.valueOf(day);
                while (i < temp) {
                    report report1 = new report();
                    day = String.valueOf(i);
                    report1.day = day;
                    report1.totalPrice = 0;
                    reports.add(report1);
                    i++;
                }
                totalPrice = rs.getInt(2);
                report.day = day;
                report.totalPrice = totalPrice;
                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public List<report> listID() {
        List<report> reports = new ArrayList<>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            readID();
            String sql ="select ID,GNo,City1,City2,Month,Day,num from report where ID = "+id+"";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                report report = new report();
                id = rs.getInt(1);
                GNo = rs.getString(2);
                City1 = rs.getString(3);
                City2 = rs.getString(4);
                month = rs.getString(5);
                day = rs.getString(6);
                num = rs.getInt(7);
                report.id = id;
                report.GNo = GNo;
                report.City1 = City1;
                report.City2 = City2;
                report.month = month;
                report.day = day;
                report.num = num;
                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public void refundTicket() {
        List<report> reports = new ArrayList<>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            readID();
            String sql ="delete from report where id = "+id+"";
            s.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void readSNo(){
        String filePath = "G:\\learn\\数据库大作业\\SNo.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            SNo = buffReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readID(){
        String filePath = "G:\\learn\\数据库大作业\\refund\\ID.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            id = Integer.valueOf(buffReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
