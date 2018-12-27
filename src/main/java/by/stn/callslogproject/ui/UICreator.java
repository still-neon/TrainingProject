package by.stn.callslogproject.ui;

import by.stn.callslogproject.callslog.CallsLogTableManager;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UICreator {
    private static final String APP_NAME = "CallsLog";
    private static final String ADD_BUTTON_TEXT = "Add Call";
    private static final String SAVE_BUTTON_TEXT = "Save";
    private static final String REFRESH_BUTTON_TEXT = "Refresh";
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
                frame.setLayout(new BorderLayout());

                JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
                frame.add(contents, BorderLayout.NORTH);

                JButton addButton = new JButton(ADD_BUTTON_TEXT);
                JButton deleteButton = new JButton(DELETE_BUTTON_TEXT);
                JButton saveButton = new JButton(SAVE_BUTTON_TEXT);
                JButton refreshButton = new JButton(REFRESH_BUTTON_TEXT);
                contents.add(addButton);
                contents.add(deleteButton);
                contents.add(saveButton);
                contents.add(refreshButton);

                frame.add(new JScrollPane(callsLogTableManager.getTable()), BorderLayout.CENTER);//создавать таблицу здесь и передавать

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        callsLogTableManager.addRow();

                    }
                });

                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        callsLogTableManager.deleteRow();
                    }
                });

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        callsLogTableManager.save();
                    }
                });

                refreshButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        callsLogTableManager.refresh();
                    }
                });
            }
        });
    }
}