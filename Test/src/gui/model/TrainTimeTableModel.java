package gui.model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import java.util.List;

import entity.G;
import DAO.GDao;

public class TrainTimeTableModel implements TableModel {

    String[] columnNames = new String[]{"站台","到达/发车时间"};

    public List<G> cs = new GDao().list();

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
        return G.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        G t = cs.get(rowIndex);
        if (0 == columnIndex) {
            return t.CityName;
        }
        if (1 == columnIndex) {
            return t.goTime;
        }
        return null;
    }


    public static void main(String[] args){
        GDao g = new GDao();
        List<G> cs = g.list();
        G t = cs.get(1);
        System.out.println(t.CityNo);
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
