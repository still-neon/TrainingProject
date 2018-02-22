package by.stn.callslogproject.ui;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Created by EugenKrasotkin on 1/8/2018.
 */
public class UICreator {
    private static final String APP_NAME = "CallsLog";
    private static final String ADD_BUTTON_TEXT = "Add Call";
    private static final String EDIT_BUTTON_TEXT = "Edit Call";
    private static final String DELETE_BUTTON_TEXT = "Delete Call";
    @Setter
    private CallsLogTableManager callsLogTableManager;

    public void create() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame(APP_NAME);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(700, 600);
                frame.setResizable(true);
                frame.setVisible(true);

                JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
                frame.setContentPane(contents);

                JButton addButton = new JButton(ADD_BUTTON_TEXT);
                JButton editButton = new JButton(EDIT_BUTTON_TEXT);
                JButton deleteButton = new JButton(DELETE_BUTTON_TEXT);
                contents.add(addButton);
                contents.add(editButton);
                contents.add(deleteButton);

                contents.add(new JScrollPane(callsLogTableManager.createTable()));

                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            callsLogTableManager.deleteRow();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        callsLogTableManager.addRow();

                    }
                });

                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        callsLogTableManager.editRow();

                    }
                });
            }
        });
    }
}