package gui.model;

import DAO.TrainsDao;
import entity.Trains;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class TrainsModel implements ComboBoxModel {
    public List<Trains> cs = new TrainsDao().list();
    public Trains c;
    public String s;

    public TrainsModel() {
        c =  cs.get(0);
        s = c.GNo;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        s = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        if(!cs.isEmpty())
            return s;
        else
            return null;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public Object getElementAt(int index) {
        return cs.get(index).GNo;
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

}
