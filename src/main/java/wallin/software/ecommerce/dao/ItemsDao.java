package wallin.software.ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import wallin.software.ecommerce.mapper.ItemsMapper;
import wallin.software.ecommerce.model.Item;

@Repository
public class ItemsDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private ItemsMapper itemsMapper;
	private String ITEM_RETRIEVE_SQL = "SELECT \"ID\", \"Name\", \"Description\", \"Price\" FROM \"Commerce\".\"Items\" WHERE \"ID\" = :id";
	private String ALL_ITEM_RETRIEVE_SQL = "SELECT \"ID\", \"Name\", \"Description\", \"Price\" FROM \"Commerce\".\"Items\"";
	private String INSERT_SQL = "INSERT INTO \"Commerce\".\"Items\" (\"Name\", \"Description\", \"Price\") VALUES (:name, :description, :price)";
	
	public Item retrieveItem(int id) {
		return namedParameterJdbcTemplate.query(ITEM_RETRIEVE_SQL, new MapSqlParameterSource().addValue("id", id), itemsMapper).get(0);
	}
	
	public List<Item> retrieveAllItems() {
		return namedParameterJdbcTemplate.query(ALL_ITEM_RETRIEVE_SQL, itemsMapper);
	}

	public Item insertItem(String name, String description, String price) {
		Item item = new Item();
		item.setName(name);
		item.setDescription(description);
		item.setPrice(price);
		namedParameterJdbcTemplate.update(INSERT_SQL, new MapSqlParameterSource()
				.addValue("name", item.getName())
				.addValue("description", item.getDescription())
				.addValue("price", item.getPrice()));
		return item;
	}
}
