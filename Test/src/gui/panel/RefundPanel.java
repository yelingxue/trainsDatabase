package gui.panel;

import DAO.reportDao;
import gui.listener.RefundListener;
import gui.model.*;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class RefundPanel extends JPanel{
    public static RefundPanel instance = new RefundPanel();


    public JLabel id = new JLabel("输入订单号:");
    public JTextField tID = new JTextField();
    public JButton bQuery = new JButton("查询");
    public JButton bRefund = new JButton("退票");


    String columNames[] = new String[]{"订单号","车次","出发站","到达站","月","日","票数"};
    public ReportTableModel tm = new ReportTableModel();
    public JTable t = new JTable(tm);

    public RefundPanel(){
        JScrollPane sp = new JScrollPane(t);
        JPanel submit = new JPanel();

        t.getTableHeader().setFont(new Font("黑体", Font.BOLD, 24));
        t.setFont(new Font("楷体", Font.BOLD, 24));
        t.setRowHeight(40);

        submit.setPreferredSize(new Dimension(0,60));
        submit.setLayout(null);

        id.setBounds(150,0,120,60);
        id.setFont(new Font("楷体", Font.BOLD, 20));
        tID.setBounds(270,13,100,36);
        tID.setFont(new Font("楷体", Font.BOLD, 20));
        bQuery.setBounds(400,13,80,36);
        bQuery.setFont(new Font("楷体", Font.BOLD, 20));
        bRefund.setBounds(500,13,80,36);
        bRefund.setFont(new Font("楷体", Font.BOLD, 20));

        submit.add(id);
        submit.add(tID);
        submit.add(bQuery);
        submit.add(bRefund);

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(submit,BorderLayout.SOUTH);
        addListener();
    }

    private void addListener(){
        RefundListener listener = new RefundListener();
        this.bQuery.addActionListener(listener);
        this.bRefund.addActionListener(listener);
    }

    public void updateDataQuery() {
        tm.cs = new reportDao().listID();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        if (0 == tm.cs.size())
            bRefund.setEnabled(false);
        else
            bRefund.setEnabled(true);
    }

    public void updateDataB() {
        new reportDao().refundTicket();
        tm.cs = new reportDao().list();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RefundPanel.instance,0.8);
    }
}
