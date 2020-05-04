package bd_spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class RowManager implements RowMapper {
    
    @Override
    public Object mapRow(ResultSet rs, int line) throws SQLException {
        PersonResultSetExtractor extractor = new PersonResultSetExtractor();
        return extractor.extractData(rs);
    }

    class PersonResultSetExtractor implements ResultSetExtractor {
        @Override
        public Object extractData(ResultSet rs) throws SQLException {
            Shops shops = new Shops();
            shops.setId(rs.getInt(1));
            shops.setName(rs.getString(2));
            shops.setAddress(rs.getString(3));
            shops.setPhone(rs.getString(4));
            return shops;
        }
    }
}
