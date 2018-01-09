package by.stn.callslogproject;


import by.stn.callslogproject.callslog.CallsLogDaoImpl;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Created by EugenKrasotkin on 1/8/2018.
 */
public class UICreator {

    private static final String APP_NAME = "CallsLog";
    private static final String BUTTON_TEXT = "Show CallsLog";

    private JFrame frame;
    private JButton button;

    public UICreator() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    private void createUI() {
        frame = new JFrame(APP_NAME);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 300);
        frame.setResizable(true);
        frame.setVisible(true);

        final JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.setContentPane(contents);

        button = new JButton(BUTTON_TEXT);
        contents.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setVisible(false);
                TableModel model = null;
                try {
                    model = new CallsLogTableModel(CallsLogDaoImpl.getInstance().getAll());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                JTable table = new JTable(model);
                contents.add(new JScrollPane(table));
            }
        });
    }
}