package gui.model;

import DAO.BuyDao;
import entity.Buy;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class TrainsTableModel implements TableModel {

    String[] columnNames = new String[]{"车次","开点","价格","余票","总票数"};

    public List<Buy> cs = new BuyDao().list();

    @Override
    public int getRowCount() {
        return cs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Buy.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Buy b = cs.get(rowIndex);
        if (0==columnIndex)
            return b.GNo;
        if (1==columnIndex)
            return b.goTime;
        if (2==columnIndex)
            return b.price;
        if (3==columnIndex)
            return b.remaining;
        if (4 == columnIndex)
            return b.counts;
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
