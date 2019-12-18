package gui.listener;

import entity.Trains;
import gui.panel.BuyPanel;
import gui.panel.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class BuyListener implements ActionListener {

    String City1, City2, Month, Day, GNo;

    @Override
    public void actionPerformed(ActionEvent e) {
        BuyPanel buyPanel = BuyPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == buyPanel.bQuery) {
            this.City1 = (String) buyPanel.city1.getSelectedItem();
            this.City2 = (String) buyPanel.city2.getSelectedItem();
            this.Month = (String) buyPanel.month.getSelectedItem();
            this.Day = (String) buyPanel.day.getSelectedItem();
            writeCity1(City1);
            writeCity2(City2);
            writeMonth(Month);
            writeDay(Day);
            buyPanel.updateDataQ();
        }
        if (b == buyPanel.bBuy) {
            this.GNo = buyPanel.getSelectedGNo();
            int Price = buyPanel.getSelectedPrice();
            writePrice(String.valueOf(Price));
            writeGNo(GNo);
            int remaining = buyPanel.getSelectedRemaining();
            String num = JOptionPane.showInputDialog("输入购买车票数量");
            writeNum(num);
            if (0 == num.length() || Integer.valueOf(num) <= 0) {
                JOptionPane.showMessageDialog(buyPanel,"请输入有效数据");//关于有效数据修改Util内方法，此处仅做测试12.13
                return;
            }
            if (remaining - Integer.valueOf(num) < 0) {
                JOptionPane.showMessageDialog(buyPanel,"余票不足");
                return;
            }
            buyPanel.updateDataB();
        }
        MainPanel.instance.workingPanel.show(BuyPanel.instance);
    }

    private void writeCity1(String City1){
        try {
            File f = new File("G:\\learn\\数据库大作业\\buy\\City1.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(City1);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void writeCity2(String City2){
        try {
            File f = new File("G:\\learn\\数据库大作业\\buy\\City2.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(City2);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void writeMonth(String Month){
        try {
            File f = new File("G:\\learn\\数据库大作业\\buy\\Month.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(Month);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void writeDay(String Day){
        try {
            File f = new File("G:\\learn\\数据库大作业\\buy\\Day.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(Day);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void writeNum(String Num) {
        try {
            File f = new File("G:\\learn\\数据库大作业\\buy\\Num.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(Num);
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeGNo(String Gno){
        try {
            File f = new File("G:\\learn\\数据库大作业\\buy\\GNoBuy.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(Gno);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void writePrice(String Price){
        try {
            File f = new File("G:\\learn\\数据库大作业\\buy\\Price.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(Price);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}