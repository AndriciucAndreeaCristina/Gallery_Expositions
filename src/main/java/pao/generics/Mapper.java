package pao.generics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Mapper<T> {
    public Optional<T> mapToClass(ResultSet resultSet) throws SQLException;
    public List<T> mapToClassList(ResultSet resultSet) throws SQLException;
}
