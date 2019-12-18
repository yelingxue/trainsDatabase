package util;

import gui.panel.TrainTimePanel;

import javax.swing.*;

public class GUIUtil {
    public static boolean checkEmpty(JTextField tf, String input){
        String text = tf.getText().trim();
        if (0 == text.length()) {
            JOptionPane.showMessageDialog(null,input+"输入不能为空");
            tf.grabFocus();
            return false;
        }else
            return true;
    }

    public static boolean checkNumber(JTextField tf, String input){
        if(!checkEmpty(tf,input))
            return false;
        String text = tf.getText().trim();
        try{
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,input+"请输入整数");
            tf.grabFocus();
            return false;
        }
    }

    public static boolean checkZero(JTextField tf, String input) {
        if (!checkEmpty(tf,input))
            return false;
        String text = tf.getText().trim();
        if (0 == Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null,input+"不能为0");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    /**
    * @param p
    * @param strech 拉伸比例
    * */
    public static void showPanel(JPanel p, double strech) {
        JFrame f = new JFrame();
        f.setTitle("火车售票系统（售票员端）");
        f.setSize(1000,800);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strech);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }
}