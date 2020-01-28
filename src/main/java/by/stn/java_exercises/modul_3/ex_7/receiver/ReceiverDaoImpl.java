package by.stn.java_exercises.modul_3.ex_7.receiver;

import by.stn.java_exercises.modul_3.ex_7.entity.AbstractEntityDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiverDaoImpl extends AbstractEntityDao<ReceiverInfo> {

	public ReceiverDaoImpl() throws ClassNotFoundException {
		super((Class<ReceiverInfo>) Class.forName(ReceiverInfo.class.getName()));
	}

	@Override
	protected ReceiverInfo getEntityFromResultSet(ResultSet resultSet) throws SQLException {
		ReceiverInfo receiverInfo = new ReceiverInfo(resultSet.getInt("num"));
		receiverInfo.setReceiver(resultSet.getString("receiver"));
		return receiverInfo;
	}

	@Override
	protected void setUpdateQueryArguments(PreparedStatement preparedStatement, ReceiverInfo receiverInfo) throws SQLException {
		setInsertQueryArguments(preparedStatement, receiverInfo);
		preparedStatement.setLong(1, receiverInfo.getNum());
	}

	@Override
	protected void setInsertQueryArguments(PreparedStatement preparedStatement, ReceiverInfo receiverInfo) throws SQLException {
		preparedStatement.setString(2, receiverInfo.getReceiver());
	}
}