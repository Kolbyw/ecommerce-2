package wallin.software.ecommerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import wallin.software.ecommerce.model.Item;

@Component
public class ItemsMapper implements RowMapper<Item> {

	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		item.setId(rs.getInt("ID"));
		item.setDescription(rs.getString("Description"));
		item.setName(rs.getString("Name"));
		item.setPrice(rs.getString("Price"));
		return item;
	}

}
