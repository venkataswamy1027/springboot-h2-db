package com.restapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Item;
import com.restapi.repository.ItemRepository;

@Service
public class ItemService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);
	@Autowired
	private ItemRepository itemRepository;

	public List<Item> list() {
		LOGGER.info("list method executed");
		return itemRepository.findAll();
	}

	public Item getItemById(int itemId) {
		LOGGER.info("getItemById method executed");
		return itemRepository.findById(itemId).get();
	}

	public Item createItem(Item item) {
		LOGGER.info("createItem method executed");
		return itemRepository.save(item);
	}

	public Item update(Item item, int itemId) {
		LOGGER.info("update method executed");
		item.setId(itemId);
		return itemRepository.save(item);
	}

	public void delete(int itemId) {
		LOGGER.info("update method executed");
		itemRepository.deleteById(itemId);
	}
}
