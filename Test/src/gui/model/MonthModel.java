package gui.model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class MonthModel implements ComboBoxModel<String> {
    public List<String> month = new ArrayList<>();
    String m;

    public MonthModel(){
        month.add("01");
        month.add("02");
        month.add("03");
        month.add("04");
        month.add("05");
        month.add("06");
        month.add("07");
        month.add("08");
        month.add("09");
        month.add("10");
        month.add("11");
        month.add("12");
        m = month.get(0);
    }


    @Override
    public void setSelectedItem(Object anItem) {
        m = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return m;
    }

    @Override
    public int getSize() {
        return month.size();
    }

    @Override
    public String getElementAt(int index) {
        return month.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
