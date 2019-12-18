package gui.panel;

import DAO.reportDao;
import entity.report;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.*;

import util.ChartUtil;
import util.GUIUtil;

public class ReportPanel extends WorkingPanel{
    public static ReportPanel instance = new ReportPanel();

    public JLabel l = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());
        List<report> rs = new reportDao().list();
        Image i = ChartUtil.getImage(rs,780, 570);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);

        addListener();
    }

    public void updateData() {
        List<report> rs = new reportDao().list();
        Image i = ChartUtil.getImage(rs, 780, 570);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }

    public void addListener() {

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance,0.75);
    }
}
