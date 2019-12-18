package gui.model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class DayModel implements ComboBoxModel<String> {
    public List<String> day = new ArrayList<>();
    String d;

    public DayModel(){
        day.add("01");
        day.add("02");
        day.add("03");
        day.add("04");
        day.add("05");
        day.add("06");
        day.add("07");
        day.add("08");
        day.add("09");
        day.add("10");
        day.add("11");
        day.add("12");
        day.add("13");
        day.add("14");
        day.add("15");
        day.add("16");
        day.add("17");
        day.add("18");
        day.add("19");
        day.add("20");
        day.add("21");
        day.add("22");
        day.add("23");
        day.add("24");
        day.add("25");
        day.add("26");
        day.add("27");
        day.add("28");
        day.add("29");
        day.add("30");
        day.add("31");
        d = day.get(0);
    }


    @Override
    public void setSelectedItem(Object anItem) {
        d = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return d;
    }

    @Override
    public int getSize() {
        return day.size();
    }

    @Override
    public String getElementAt(int index) {
        return day.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
