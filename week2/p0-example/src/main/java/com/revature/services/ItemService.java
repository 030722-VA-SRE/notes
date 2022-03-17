package com.revature.services;

import com.revature.daos.ItemDao;
import com.revature.daos.ItemPostgres;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.Item;

public class ItemService {

	private ItemDao iDao;
	
	public ItemService() {
		iDao = new ItemPostgres();
	}
	
	public Item getById(int id) throws ItemNotFoundException {
		Item item = iDao.getItemById(id);
		/*-
		 * if item retrieved from Dao is null, throw exception
		 */
		if(item == null) {
			throw new ItemNotFoundException();
		}
		
		return item;
	}
}
