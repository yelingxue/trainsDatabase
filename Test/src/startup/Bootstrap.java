package startup;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.LoginPanel;
import gui.panel.MainPanel;

public class Bootstrap {
    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeAndWait(() -> {
            MainFrame.instance.setVisible(true);
            MainPanel.instance.workingPanel.show(LoginPanel.instance);
        });
    }
}