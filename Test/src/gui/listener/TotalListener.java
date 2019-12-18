package gui.listener;

import gui.panel.TotalPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class TotalListener implements ActionListener {
    String GNo, Month, Day;

    @Override
    public void actionPerformed(ActionEvent e) {
        TotalPanel totalPanel = TotalPanel.instance;
        this.GNo = (String) totalPanel.tTrain.getSelectedItem();
        this.Month = (String) totalPanel.month.getSelectedItem();
        this.Day = (String) totalPanel.day.getSelectedItem();
        writeGNo(GNo);
        writeMonth(Month);
        writeDay(Day);

        totalPanel.updateData();
    }

    private void writeMonth(String Month){
        try {
            File f = new File("G:\\learn\\数据库大作业\\total\\Month.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(Month);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void writeDay(String Day){
        try {
            File f = new File("G:\\learn\\数据库大作业\\total\\Day.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(Day);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void writeGNo(String GNo) {
        try {
            File f = new File("G:\\learn\\数据库大作业\\total\\GNo.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(GNo);
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
