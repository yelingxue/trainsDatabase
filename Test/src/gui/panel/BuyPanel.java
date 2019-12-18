package gui.panel;

import DAO.BuyDao;
import entity.Trains;
import gui.listener.BuyListener;
import gui.model.CodeComboBoxModel;
import gui.model.DayModel;
import gui.model.MonthModel;
import gui.model.TrainsTableModel;
import util.GUIUtil;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyPanel extends JPanel{
    public static BuyPanel instance = new BuyPanel();

    String id;

    public CodeComboBoxModel c1Model = new CodeComboBoxModel();
    public JComboBox<String> city1 = new JComboBox<>(c1Model);
    public CodeComboBoxModel c2Model = new CodeComboBoxModel();
    public JComboBox<String> city2 = new JComboBox<>(c2Model);
    public JLabel c1 = new JLabel("出发地:");
    public JLabel c2 = new JLabel("目的地:");
    public JLabel date = new JLabel("日期");
    public DayModel dayModel = new DayModel();
    public JComboBox<String> day = new JComboBox<>(dayModel);
    public MonthModel monthModel = new MonthModel();
    public JComboBox<String> month = new JComboBox<>(monthModel);
    public JButton bQuery = new JButton("查询");
    public JButton bBuy = new JButton("购买");
    public JLabel lmonth = new JLabel("月");
    public JLabel lday = new JLabel("日");


    String columnNames[] = new String[]{"车次","开点","价格","余票","总票数"};
    public TrainsTableModel tm = new TrainsTableModel();
    public JTable t = new JTable(tm);


    public BuyPanel(){
        JScrollPane sp = new JScrollPane(t);
        JPanel submit = new JPanel();

        t.getTableHeader().setFont(new Font("黑体", Font.BOLD, 24));
        t.setFont(new Font("楷体", Font.BOLD, 24));
        t.setRowHeight(40);

        submit.setPreferredSize(new Dimension(0,60));
        submit.setLayout(null);

        c1.setBounds(0,0,75,60);
        c1.setFont(new Font("楷体", Font.BOLD, 20));
        city1.setBounds(75,13,88,36);
        city1.setFont(new Font("楷体", Font.BOLD, 20));
        c2.setBounds(165,0,75,60);
        c2.setFont(new Font("楷体", Font.BOLD, 20));
        city2.setBounds(240,13,90,36);
        city2.setFont(new Font("楷体", Font.BOLD, 20));
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
        bBuy.setBounds(635,13,80,36);
        bBuy.setFont(new Font("楷体", Font.BOLD, 20));

        submit.add(c1);
        submit.add(city1);
        submit.add(c2);
        submit.add(city2);
        submit.add(month);
        submit.add(lmonth);
        submit.add(day);
        submit.add(lday);
        submit.add(bQuery);
        submit.add(bBuy);

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(submit,BorderLayout.SOUTH);

        addListener();
    }

    private void addListener(){
        BuyListener listener = new BuyListener();
        this.bQuery.addActionListener(listener);
        this.bBuy.addActionListener(listener);
    }

    public void updateDataQ() {
        tm.cs = new BuyDao().list();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        if (0 == tm.cs.size())
            bBuy.setEnabled(false);
        else
            bBuy.setEnabled(true);
    }

    public void updateDataB() {
        new BuyDao().buyTicket();
        new BuyDao().getID();
        tm.cs = new BuyDao().list();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);
        readID();
        JOptionPane.showMessageDialog(null,"订单号:"+id);
    }

    public String getSelectedGNo() {
        int index = t.getSelectedRow();
        return  tm.cs.get(index).GNo;
    }

    public int getSelectedRemaining() {
        int index = t.getSelectedRow();
        return tm.cs.get(index).remaining;
    }

    public int getSelectedPrice() {
        int index = t.getSelectedRow();
        return  tm.cs.get(index).price;
    }

    private void readID(){
        String filePath = "G:\\learn\\数据库大作业\\buy\\ID.txt";
        try (FileInputStream fin = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fin);
             BufferedReader buffReader = new BufferedReader(reader)) {
            id = buffReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BuyPanel.instance,0.75);
    }
}