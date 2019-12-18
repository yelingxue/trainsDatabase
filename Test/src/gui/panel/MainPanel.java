package gui.panel;

import java.awt.*;
import javax.swing.*;
import util.CenterPanel;
import util.GUIUtil;

import gui.listener.ToolBarListener;

public class MainPanel extends JPanel {
    public static MainPanel instance = new MainPanel();
    public JToolBar tb = new JToolBar();
    public JButton bLogin = new JButton("登录");
    public JButton bTrain = new JButton("火车信息");
    public JButton bBuy = new JButton("查询/购票");
    public JButton bTotal = new JButton("车票销售情况");
    public JButton bRefund = new JButton("退票");
    public JButton bTurnover = new JButton("我的营业额");

    public CenterPanel workingPanel;

    private MainPanel() {
        tb.setPreferredSize(new Dimension(0, 60));
        bLogin.setBounds(0, 0, 166, 60);
        bLogin.setFont(new Font("楷体", Font.BOLD, 24));
        bTrain.setBounds(166, 0, 166, 60);
        bTrain.setFont(new Font("楷体", Font.BOLD, 24));
        bBuy.setBounds(166*2, 0, 166, 60);
        bBuy.setFont(new Font("楷体", Font.BOLD, 24));
        bTotal.setBounds(166*3, 0, 166, 60);
        bTotal.setFont(new Font("楷体", Font.BOLD, 24));
        bRefund.setBounds(166*4, 0, 166, 60);
        bRefund.setFont(new Font("楷体", Font.BOLD, 24));
        bTurnover.setBounds(166*5, 0, 166, 60);
        bTurnover.setFont(new Font("楷体", Font.BOLD, 24));
        tb.setLayout(null);

        tb.add(bLogin);
        tb.add(bTrain);
        tb.add(bBuy);
        tb.add(bTotal);
        tb.add(bRefund);
        tb.add(bTurnover);
        tb.setFloatable(false);

        workingPanel = new CenterPanel(0.85);
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        addListener();
    }

    private void addListener() {
        ToolBarListener listener = new ToolBarListener();
        bLogin.addActionListener(listener);
        bTrain.addActionListener(listener);
        bBuy.addActionListener(listener);
        bRefund.addActionListener(listener);
        bTurnover.addActionListener(listener);
        bTotal.addActionListener(listener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.instance, 1);
    }
}
