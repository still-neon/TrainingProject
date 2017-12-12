package by.stn.callslogproject;

import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by EugenKrasotkin on 12/11/2017.
 */
public abstract class AbstractEntityDao<E, K> {
    private Connection connection;
    private ConnectionPool connectionPool;

    public AbstractEntityDao() throws SQLException {
        //connectionPool = ConnectionPool.getConnectionPool();
        connection = connectionPool.getConnection();
    }

    public abstract E getEntityById(K id);

    // Возвращения экземпляра Connection в пул соединений
    public void returnConnectionInPool() {
        ///connectionPool.returnConnection(connection);
    }

    // Получение экземпляра PrepareStatement
    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    // Закрытие PrepareStatement
    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}