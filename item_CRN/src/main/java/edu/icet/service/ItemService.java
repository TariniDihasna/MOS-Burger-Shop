package edu.icet.service;

import edu.icet.dto.Item;

import java.util.List;

public interface ItemService {
    void addItem(Item item);

    List<Item> getAll();

    void deleteItem(String code);

    void updateItem(Item item);

    Item searchByCode(String code);

    List<Item> searchByName(String name);
}
