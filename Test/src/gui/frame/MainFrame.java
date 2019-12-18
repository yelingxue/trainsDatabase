package gui.frame;
import javax.swing.*;

import gui.panel.MainPanel;

public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    private MainFrame(){
        this.setSize(1000,800);
        this.setTitle("火车售票系统（售票员端）");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}
