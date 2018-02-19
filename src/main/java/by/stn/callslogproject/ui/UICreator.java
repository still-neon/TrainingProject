package by.stn.callslogproject.ui;

import by.stn.callslogproject.callslog.CallsLogDao;
import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.personsinfo.PersonsInfo;
import by.stn.callslogproject.ui.CallsLogTableModel;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;


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
    private JTable table = new JTable();
    private CallsLogTableModel model;

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

                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                contents.add(new JScrollPane(table));
                configTable();

                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("row" + table.getSelectedRow() + " real " + table.convertRowIndexToModel(table.getSelectedRow()));
                        System.out.println(model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), model.getColumnCount() - 1));
                        try {
                            callsLogDao.delete((long) model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), model.getColumnCount() - 1));
                            configTable();//изменять модель а не создавать новую, проверка на удаление
                            table.updateUI();
                            //table.repaint();//выяснить EDT или нет, если нет сделать
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.addRow(new Vector());
                        /*
                        CallsLogEntry cl = new CallsLogEntry(null);
                        cl.setAddressee(new PersonsInfo(2L));
                        cl.setCaller(new PersonsInfo(1L));
                        cl.setCallType(1);
                        cl.setEndDate(new Date(System.currentTimeMillis()));
                        cl.setEndDate(new Date(System.currentTimeMillis()));
                        try {
                            callsLogDao.saveOrUpdate(cl);
                            configTable();
                            table.updateUI();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }*/
                    }
                });

                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //

                    }
                });
            }
        });
    }

    private TableModel getModel() {
        try {
            model = new CallsLogTableModel(callsLogDao.getAll());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return model;
    }

    private void configTable() {//возможно нужен отдельный класс для table
        table.setModel(getModel());
        table.setAutoCreateRowSorter(true);
        table.getRowSorter().toggleSortOrder(5);
    }
}