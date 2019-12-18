package gui.model;

import DAO.reportDao;
import entity.report;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class ReportTableModel implements TableModel {

    String columnNames[] = new String[]{"订单号","车次","出发站","到达站","月","日","票数"};

    public List<report> cs = new reportDao().listID();

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
        return report.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        report t = cs.get(rowIndex);
        if (0 == columnIndex)
            return t.id;
        if (1 == columnIndex)
            return t.GNo;
        if (2 == columnIndex)
            return t.City1;
        if (3 == columnIndex)
            return t.City2;
        if (4 == columnIndex)
            return t.month;
        if (5 == columnIndex)
            return t.day;
        if (6 == columnIndex)
            return t.num;
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
