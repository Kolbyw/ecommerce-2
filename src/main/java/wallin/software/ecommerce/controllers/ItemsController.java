package wallin.software.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wallin.software.ecommerce.dao.ItemsDao;
import wallin.software.ecommerce.model.Item;

@RestController
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsDao itemsDao;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Item> getItem(@PathVariable int id){
		
		return new ResponseEntity<Item>(itemsDao.retrieveItem(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Item>> getAllItems(){
		
		return new ResponseEntity<List<Item>>(itemsDao.retrieveAllItems(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Item> insertItem(@RequestParam String name, @RequestParam String description, @RequestParam String price){
		
		return new ResponseEntity<Item>(itemsDao.insertItem(name, description, price), HttpStatus.OK);
	}
}
