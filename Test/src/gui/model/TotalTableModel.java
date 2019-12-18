package gui.model;

import DAO.TotalDao;
import entity.Total;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class TotalTableModel implements TableModel {

    String columnNames[] = new String[]{"车次","卖出票数","总销售额"};

    public List<Total> cs = new TotalDao().list();

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
        return Total.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Total t = cs.get(rowIndex);
        if (0 == columnIndex)
            return t.GNo;
        if (1 == columnIndex)
            return t.num;
        if (2 == columnIndex)
            return t.totalPrice;
        if (3 == columnIndex)
            return t.City1;
        if (4 == columnIndex)
            return t.City2;
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
