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

    private JFrame frame;
    private JButton button;

    public void create() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame(APP_NAME);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(700, 300);
                frame.setResizable(true);
                frame.setVisible(true);

                final JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
                frame.setContentPane(contents);

                JButton addButton = new JButton(ADD_BUTTON_TEXT);
                contents.add(addButton);
                JButton editButton = new JButton(EDIT_BUTTON_TEXT);
                contents.add(editButton);
                JButton deleteButton = new JButton(DELETE_BUTTON_TEXT);
                contents.add(deleteButton);

                TableModel model = null;
                try {
                    model = new CallsLogTableModel(callsLogDao.getAll());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                final JTable table = new JTable(model);
                contents.add(new JScrollPane(table));
                table.setAutoCreateRowSorter(true);
                table.getRowSorter().toggleSortOrder(3);



                final TableModel finalModel = model;
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("row" + table.getSelectedRow() + "column" + (finalModel.getRowCount()-1));
                        System.out.println(finalModel.getValueAt(table.getSelectedRow(), finalModel.getRowCount()-1));
                        /*try {
                            callsLogDao.delete(table.getSelectedRow());
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }*/

                    }
                });
            }
        });
    }
}