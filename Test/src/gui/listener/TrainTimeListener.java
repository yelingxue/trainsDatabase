package gui.listener;

import gui.panel.MainPanel;
import gui.panel.TrainTimePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class TrainTimeListener implements ActionListener {

    private String GNoTable;

    @Override
    public void actionPerformed(ActionEvent e) {
        TrainTimePanel t = TrainTimePanel.instance;
        this.GNoTable = (String) t.tTrain.getSelectedItem();
        write(GNoTable);
        t.updateData();
        MainPanel.instance.workingPanel.show(TrainTimePanel.instance);
    }

    private void write(String gno){
        try {
            File f = new File("G:\\learn\\数据库大作业\\GNo.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(gno);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
