package by.stn.java_exercises.modul_3.ex_7.expense;

import by.stn.java_exercises.modul_3.ex_7.entity.AbstractEntityDao;
import by.stn.java_exercises.modul_3.ex_7.receiver.ReceiverDaoImpl;
import lombok.Getter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseDaoImpl extends AbstractEntityDao<ExpenseEntry> {
	@Getter
	private ReceiverDaoImpl receiverDaoImpl = new ReceiverDaoImpl();

	public ExpenseDaoImpl() throws ClassNotFoundException {
		super((Class<ExpenseEntry>) Class.forName(ExpenseEntry.class.getName()));
	}

	@Override
	protected ExpenseEntry getEntityFromResultSet(ResultSet resultSet) throws SQLException {
		ExpenseEntry expenseEntry = new ExpenseEntry(resultSet.getInt("num"));
		expenseEntry.setPaydate(resultSet.getDate("paydate"));
		expenseEntry.setReceiver(receiverDaoImpl.get(resultSet.getInt("receiver")));
		expenseEntry.setValue(resultSet.getDouble("value"));
		return expenseEntry;
	}

	@Override
	protected void setUpdateQueryArguments(PreparedStatement preparedStatement, ExpenseEntry expenseEntry) throws SQLException {
		setInsertQueryArguments(preparedStatement, expenseEntry);
		preparedStatement.setLong(4, expenseEntry.getNum());

	}

	@Override
	protected void setInsertQueryArguments(PreparedStatement preparedStatement, ExpenseEntry expenseEntry) throws SQLException {
		preparedStatement.setDate(1, new Date(expenseEntry.getPaydate().getTime()));
		preparedStatement.setLong(2, expenseEntry.getReceiver().getNum());
		preparedStatement.setDouble(3, expenseEntry.getValue());
	}
}