package gui.listener;

import gui.panel.LoginPanel;
import gui.panel.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class LoginListener implements ActionListener {

    String SNo;

    @Override
    public void actionPerformed(ActionEvent e) {
        LoginPanel loginPanel = LoginPanel.instance;
        this.SNo = loginPanel.Taccount.getText();
        JOptionPane.showMessageDialog(loginPanel,"登陆成功");
        write(SNo);
        MainPanel.instance.workingPanel.show(LoginPanel.instance);
    }

    private void write(String SNo){
        try {
            File f = new File("G:\\learn\\数据库大作业\\SNo.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(SNo);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
