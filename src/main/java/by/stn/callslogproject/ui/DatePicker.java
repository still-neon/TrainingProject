package by.stn.callslogproject.ui;

import lombok.Getter;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePicker extends AbstractCellEditor implements TableCellEditor {
	@Getter
	private static final String DATE_FORMAT_PATTERN = "dd/MM/yyyy";
	private JSpinner spinner;
	private SimpleDateFormat simpleDateFormat;

	public DatePicker() {
		Calendar calendar = Calendar.getInstance();
		Date initDate = calendar.getTime();
		calendar.add(Calendar.YEAR, -100);
		Date earliestDate = calendar.getTime();
		calendar.add(Calendar.YEAR, 200);
		Date latestDate = calendar.getTime();
		SpinnerModel dateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR);

		simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);//TODO:getdateformat
		spinner = new JSpinner(dateModel);
		spinner.setEditor(new JSpinner.DateEditor(spinner, DATE_FORMAT_PATTERN));
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
			spinner.setValue(new Date());
		}
		return spinner;
	}
}