package by.stn.callslogproject.ui;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePicker extends AbstractCellEditor implements TableCellEditor {
	JSpinner spinner;
	SimpleDateFormat simpleDateFormat;

	public DatePicker() {
		Calendar calendar = Calendar.getInstance();
		Date initDate = calendar.getTime();
		calendar.add(Calendar.YEAR, -100);
		Date earliestDate = calendar.getTime();
		calendar.add(Calendar.YEAR, 200);
		Date latestDate = calendar.getTime();
		SpinnerModel dateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR);

		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		spinner = new JSpinner(dateModel);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "dd/MM/yyyy"));
	}

	@Override
	public Object getCellEditorValue() {
		return ((SpinnerDateModel) spinner.getModel()).getDate();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (value != null) {
			spinner.setValue(value);
		} else {
			try {
				Date dt = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
				spinner.setValue(dt);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return spinner;
	}
}