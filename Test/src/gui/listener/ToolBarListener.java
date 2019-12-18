package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import gui.panel.*;

public class ToolBarListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.bLogin)
            p.workingPanel.show(LoginPanel.instance);
        if (b == p.bTrain)
            p.workingPanel.show(TrainTimePanel.instance);
        if (b == p.bBuy)
            p.workingPanel.show(BuyPanel.instance);
        if (b == p.bTotal)
            p.workingPanel.show(TotalPanel.instance);
        if (b == p.bRefund)
            p.workingPanel.show(RefundPanel.instance);
        if (b == p.bTurnover)
            p.workingPanel.show(ReportPanel.instance);
    }
}
