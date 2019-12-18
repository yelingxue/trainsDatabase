package gui.panel;

import gui.listener.LoginListener;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    public static LoginPanel instance = new LoginPanel();
    public JLabel Laccount = new JLabel("账号:");
    public JTextField Taccount = new JTextField();
    public JLabel Lpassword = new JLabel("密码:");
    public JPasswordField Tpassword = new JPasswordField();
    public JButton bLogin = new JButton("登录");

    public LoginPanel() {
        JPanel p = new JPanel();

        p.setPreferredSize(new Dimension(0,60));
        p.setLayout(null);

        Laccount.setBounds(220,150,80,60);
        Laccount.setFont(new Font("楷体", Font.BOLD, 26));
        Taccount.setBounds(300,160,200,48);
        Taccount.setFont(new Font("楷体", Font.BOLD, 26));

        Lpassword.setBounds(220,230,80,60);
        Lpassword.setFont(new Font("楷体", Font.BOLD, 26));
        Tpassword.setBounds(300,240,200,48);
        Tpassword.setFont(new Font("", Font.BOLD, 26));

        bLogin.setBounds(310,325,120,48);
        bLogin.setFont(new Font("楷体", Font.BOLD, 26));

        p.add(Laccount);
        p.add(Taccount);
        p.add(Lpassword);
        p.add(Tpassword);
        p.add(bLogin);

        this.setLayout(new BorderLayout());
        this.add(p,BorderLayout.CENTER);

        addListener();
    }

    private void addListener(){
        LoginListener listener = new LoginListener();
        this.bLogin.addActionListener(listener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(LoginPanel.instance,0.85);
    }
}
