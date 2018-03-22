package by.stn.callslogproject.ui;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePicker extends AbstractCellEditor implements TableCellEditor {
    private Date date;
    private JSpinner spinner;

    public DatePicker() {
        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -100);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 200);
        Date latestDate = calendar.getTime();

        SpinnerModel dateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR);

        spinner = new JSpinner(dateModel);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));//главный пункт чтобы по в моделе был мой формат отображения даты, без конфертации
    }

    @Override
    public Object getCellEditorValue() {
        return toStringValue(((SpinnerDateModel) spinner.getModel()).getDate());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        spinner.setValue(toDateValue(String.valueOf(value)));
        return spinner;
    }

    private Date toDateValue(String stringValue) {
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(stringValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private String toStringValue(Date dateValue) {
        return new SimpleDateFormat("yyyy-MM-dd").format(dateValue);
    }
}