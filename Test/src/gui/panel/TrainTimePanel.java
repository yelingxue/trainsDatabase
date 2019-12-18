package gui.panel;

import DAO.GDao;
import entity.Trains;
import gui.model.TrainTimeTableModel;
import gui.model.TrainsModel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

import gui.listener.TrainTimeListener;

public class TrainTimePanel extends JPanel {
    public static TrainTimePanel instance = new TrainTimePanel();

    public JButton bQuery = new JButton("查询");
    public JLabel lInput = new JLabel("请选择车次:");
    public TrainsModel trainsModel = new TrainsModel();
    public JComboBox<String> tTrain = new JComboBox(this.trainsModel);
    String columNames[] = new String[]{"站台","到达/发车时间"};
    public TrainTimeTableModel ttm = new TrainTimeTableModel();
    public JTable t = new JTable(ttm);

    public TrainTimePanel() {

        JScrollPane sp = new JScrollPane(t);
        JPanel submit = new JPanel();

        t.getTableHeader().setFont(new Font("黑体", Font.BOLD, 24));
        t.setFont(new Font("楷体", Font.BOLD, 24));
        t.setRowHeight(40);

        submit.setPreferredSize(new Dimension(0,60));
        lInput.setBounds(175,0,150,60);
        lInput.setFont(new Font("楷体", Font.BOLD, 24));
        tTrain.setBounds(325,12,155,36);
        tTrain.setFont(new Font("黑体", Font.BOLD, 24));
        bQuery.setBounds(525,11,150,38);
        bQuery.setFont(new Font("楷体", Font.BOLD, 24));
        submit.add(lInput);
        submit.add(tTrain);
        submit.add(bQuery);
        submit.setLayout(null);

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(submit,BorderLayout.SOUTH);

        addListener();
    }

    public void updateData() {
        ttm.cs = new GDao().list();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);
    }

    private void addListener() {
        TrainTimeListener listener = new TrainTimeListener();
        this.bQuery.addActionListener(listener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(TrainTimePanel.instance,0.8);
    }
}
