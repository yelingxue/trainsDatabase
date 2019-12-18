package gui.listener;

import gui.panel.MainPanel;
import gui.panel.RefundPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class RefundListener implements ActionListener {

    String id;

    @Override
    public void actionPerformed(ActionEvent e) {
        RefundPanel p = RefundPanel.instance;
        JButton b = (JButton) e.getSource();

        if (b == p.bQuery) {
            this.id = p.tID.getText();
            write(id);
            p.updateDataQuery();
        }
        if (b == p.bRefund) {
            p.updateDataB();
        }
        MainPanel.instance.workingPanel.show(RefundPanel.instance);
    }

    private void write(String City1){
        try {
            File f = new File("G:\\learn\\数据库大作业\\refund\\ID.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(City1);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
