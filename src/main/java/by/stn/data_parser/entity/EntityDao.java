package by.stn.data_parser.entity;

import java.sql.SQLException;
import java.util.List;

public interface EntityDao<T extends Entity> {//TODO: clarify why deleting of <T extends Entity> causes getDataRecords() error

	Entity get(long id) throws Exception;

	List<Entity> getAll() throws Exception;

	long saveOrUpdate(Entity entity) throws SQLException;

	boolean delete(long id) throws SQLException;
}