package DAO;

import entity.Buy;
import util.DBUtil;

import java.io.*;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class BuyDao {
    String City1, City2, Month, Day, Num, GNo, SNo;
    int Prices,id;

    public List<Buy> list() {
        List<Buy> trains = new ArrayList<>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            readCity1();
            readCity2();
            readMonth();
            readDay();
            String sql ="select trains.GNo,GNo_City_Time.goTime,CC_price.price,remaining"+Day+",remaining\n" +
                    "from GNo_City_Time,CC_price,CityCode,trains\n" +
                    "where (\n" +
                    "trains.City like '%"+City1+"%"+City2+"%' and\n" +
                    "trains.GNo = GNo_City_Time.GNo and\n" +
                    "CityCode.CityNo = GNo_City_Time.CityNo and\n" +
                    "CityCode.CityName = '"+City1+"' and\n" +
                    "CC_price.City1 = '"+City1+"' and\n" +
                    "CC_price.City2 = '"+City2+"'\n" +
                    ")order by GNo_City_Time.goTime";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                Buy train = new Buy();
                String GNo = rs.getString(1);
                String goTime = rs.getString(2);
                int price = rs.getInt(3);
                int remaining = rs.getInt(4);
                int counts = rs.getInt(5);
                train.GNo = GNo;
                train.goTime = goTime;
                train.remaining = remaining;
                train.price = price;
                train.counts = counts;
                trains.add(train);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trains;
    }

    public void buyTicket() {
        readMonth();
        readDay();
        readNum();
        readGNo();
        readPrice();
        readSNo();
        readCity1();
        readCity2();
        //insert into report values ('G1702','01','01',100,2440,201901);
        String sql = "insert into report values ('"+GNo+"','"+Month+"','"+Day+"',"+Num+","+Integer.valueOf(Num)*Prices+","+SNo+",'"+City1+"','"+City2+"')";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getID() {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            String sql = "select MAX(ID)'ID' from report";
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
            writeID(String.valueOf(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void writeID(String ID) {
        try {
            File f = new File("G:\\learn\\数据库大作业\\buy\\ID.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(ID);
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readCity1(){
        String filePath = "G:\\learn\\数据库大作业\\buy\\City1.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            City1 = buffReader.readLine();
            replace(City1);
        } catch (IOException e) {
            e.printStackTrace();
}
    }

    private void readCity2(){
        String filePath = "G:\\learn\\数据库大作业\\buy\\City2.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            City2 = buffReader.readLine();
            replace(City2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMonth(){
        String filePath = "G:\\learn\\数据库大作业\\buy\\Month.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            Month = buffReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readDay(){
        String filePath = "G:\\learn\\数据库大作业\\buy\\Day.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            Day = buffReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readNum() {
        String filePath = "G:\\learn\\数据库大作业\\buy\\Num.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            Num = buffReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readGNo(){
        String filePath = "G:\\learn\\数据库大作业\\buy\\GNoBuy.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            GNo = buffReader.readLine();
            replace(GNo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readPrice(){
        String filePath = "G:\\learn\\数据库大作业\\buy\\Price.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            Prices = Integer.valueOf(buffReader.readLine());
        } catch (IOException e) {
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

    private void replace(String City) {
        City.replaceAll("北京","1100");
        City.replaceAll("天津","1200");
        City.replaceAll("石家庄","1301");
        City.replaceAll("唐山","1302");
        City.replaceAll("秦皇岛","1303");
        City.replaceAll("邯郸","1304");
        City.replaceAll("邢台","1305");
        City.replaceAll("保定","1306");
        City.replaceAll("张家口","1307");
        City.replaceAll("承德","1308");
        City.replaceAll("沧州","1309");
        City.replaceAll("廊坊","1310");
        City.replaceAll("衡水","1311");
    }
}
