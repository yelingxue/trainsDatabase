package gui.panel;

import DAO.TotalDao;
import gui.listener.TotalListener;
import gui.model.*;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class TotalPanel extends JPanel {
    public static TotalPanel instance = new TotalPanel();

    public JLabel lGNo = new JLabel("请选择车次:");
    public TrainsModel trainsModel = new TrainsModel();
    public JComboBox<String> tTrain = new JComboBox(this.trainsModel);
    public JLabel lmonth = new JLabel("月");
    public JLabel lday = new JLabel("日");
    public DayModel dayModel = new DayModel();
    public JComboBox<String> day = new JComboBox<>(dayModel);
    public MonthModel monthModel = new MonthModel();
    public JComboBox<String> month = new JComboBox<>(monthModel);
    public JButton bQuery = new JButton("查询");

    String columnNames[] = new String[]{"车次","卖出票数","总销售额","出发站","到达站"};
    public TotalTableModel tm = new TotalTableModel();
    public JTable t = new JTable(tm);

    public TotalPanel() {

        JScrollPane sp = new JScrollPane(t);
        JPanel submit = new JPanel();

        t.getTableHeader().setFont(new Font("黑体", Font.BOLD, 24));
        t.setFont(new Font("楷体", Font.BOLD, 24));
        t.setRowHeight(40);

        submit.setPreferredSize(new Dimension(0,60));
        submit.setLayout(null);

        lGNo.setBounds(25,0,150,60);
        lGNo.setFont(new Font("楷体", Font.BOLD, 24));
        tTrain.setBounds(175,12,155,36);
        tTrain.setFont(new Font("黑体", Font.BOLD, 24));
        month.setBounds(355,13,55,36);
        month.setFont(new Font("楷体", Font.BOLD, 20));
        lmonth.setBounds(410,13,30,36);
        lmonth.setFont(new Font("楷体", Font.BOLD, 20));
        day.setBounds(440,13,55,36);
        day.setFont(new Font("楷体", Font.BOLD, 18));
        lday.setBounds(495,13,30,36);
        lday.setFont(new Font("楷体", Font.BOLD, 18));
        bQuery.setBounds(530,13,80,36);
        bQuery.setFont(new Font("楷体", Font.BOLD, 20));

        submit.add(lGNo);
        submit.add(tTrain);
        submit.add(month);
        submit.add(lmonth);
        submit.add(day);
        submit.add(lday);
        submit.add(bQuery);

        submit.setLayout(null);

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(submit,BorderLayout.SOUTH);

        addListener();
    }

    public void updateData() {
        tm.cs = new TotalDao().list();
        t.updateUI();
    }

    private void addListener() {
        TotalListener listener = new TotalListener();
        this.bQuery.addActionListener(listener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(TotalPanel.instance,0.8);
    }
}
