package gui.model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class CodeComboBoxModel implements ComboBoxModel<String> {

    public List<String> cs = new ArrayList<>();
    String c;
    public CodeComboBoxModel() {
        cs.add("北京");
        cs.add("天津");
        cs.add("石家庄");
        cs.add("唐山");
        cs.add("秦皇岛");
        cs.add("邯郸");
        cs.add("邢台");
        cs.add("保定");
        cs.add("张家口");
        cs.add("承德");
        cs.add("沧州");
        cs.add("廊坊");
        cs.add("衡水");
        c = cs.get(0);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        c = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return c;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public String getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
