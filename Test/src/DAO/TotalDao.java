package DAO;

import entity.Total;
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

public class TotalDao {
    String Day, GNo, Month, City1, City2;

    public List<Total> list() {
        List<Total> totals = new ArrayList<>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            readDay();
            readGNo();
            readMonth();

            String sql ="exec totalProc '"+Day+"','"+GNo+"'";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                Total total = new Total();
                String GNo = rs.getString(1);
                int num = rs.getInt(2);
                int totalPrice = rs.getInt(3);
                total.GNo = GNo;
                total.num = num;
                total.totalPrice = totalPrice;
                total.City1 = City1;
                total.City2 = City2;
                totals.add(total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totals;
    }

    private void readMonth(){
        String filePath = "G:\\learn\\数据库大作业\\total\\Month.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            Month = buffReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readDay(){
        String filePath = "G:\\learn\\数据库大作业\\total\\Day.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            Day = buffReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readGNo(){
        String filePath = "G:\\learn\\数据库大作业\\total\\GNo.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            GNo = buffReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
