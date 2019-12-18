package DAO;

import entity.Trains;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrainsDao {
    String GNo;

    public List<Trains> list() {
        List<Trains> trains = new ArrayList<>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            String sql ="select GNo from trains";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                Trains train = new Trains();
                String GNo = rs.getString(1);
                train.GNo = GNo;
                trains.add(train);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return trains;
    }
}
