package by.stn.callslogproject.ui;

import by.stn.callslogproject.callslog.CallsLogDao;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.TableModel;
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
    private CallsLogDao callsLogDao;
    private TableModel model;
    private JTable table = new JTable();

    public void create() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame(APP_NAME);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(700, 300);
                frame.setResizable(true);
                frame.setVisible(true);

                JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
                frame.setContentPane(contents);

                JButton addButton = new JButton(ADD_BUTTON_TEXT);
                contents.add(addButton);
                JButton editButton = new JButton(EDIT_BUTTON_TEXT);
                contents.add(editButton);
                JButton deleteButton = new JButton(DELETE_BUTTON_TEXT);
                contents.add(deleteButton);

                contents.add(new JScrollPane(table));
                configTable();



                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("row" + table.getSelectedRow() + " real " + table.convertRowIndexToModel(table.getSelectedRow()));
                        System.out.println(model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), model.getColumnCount() - 1));
                        try {
                            callsLogDao.delete((long) model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), model.getColumnCount() - 1));
                            configTable();
                            table.repaint();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                    }
                });

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });

                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });
            }
        });
    }

    public TableModel getModel() {
        try {
            model = new CallsLogTableModel(callsLogDao.getAll());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return model;
    }

    public void configTable () {
        table.setModel(getModel());
        table.setAutoCreateRowSorter(true);
        table.getRowSorter().toggleSortOrder(5);
    }
}