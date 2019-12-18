package DAO;

import java.io.*;
import java.sql.*;

import entity.G;
import util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class GDao {

    String GNo;

    public List<G> list() {
        List<G> trains = new ArrayList<>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            read();
            String sql = "select CityCode.CityName,goTime\n" +
                    "from GNo_City_Time,CityCode\n" +
                    "where GNo_City_Time.CityNo = CityCode.CityNo and\n" +
                    "GNo_City_Time.GNo = '"+ GNo +"'\n" +
                    "order by goTime";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                G train = new G();
                String CityName = rs.getString(1);
                String goTime = rs.getString("goTime");
                train.CityName = CityName;
                train.goTime = goTime;
                trains.add(train);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trains;
    }

    private void read(){
        String filePath = "G:\\learn\\数据库大作业\\GNo.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader);) {
            GNo = buffReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
