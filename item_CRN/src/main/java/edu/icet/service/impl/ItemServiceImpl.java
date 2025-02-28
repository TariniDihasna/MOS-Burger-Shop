package edu.icet.service.impl;

import edu.icet.dto.Item;
import edu.icet.entity.ItemEntity;
import edu.icet.repository.ItemRepository;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    final ItemRepository repository;
    final ModelMapper mapper;

    @Override
    public void addItem(Item item) {
        repository.save(mapper.map(item, ItemEntity.class));
    }

    @Override
    public List<Item> getAll() {
        List<Item> itemList = new ArrayList<>();
        List<ItemEntity> all = repository.findAll();

        all.forEach(itemEntity ->{
            itemList.add(mapper.map(itemEntity , Item.class));
        });
        return itemList;
    }

    @Override
    public void deleteItem(String code) {
        repository.deleteById(Integer.valueOf(code));
    }

    @Override
    public void updateItem(Item item) {

        repository.save(mapper.map(item , ItemEntity.class));
    }

    @Override
    public Item searchByCode(String code) {

        return mapper.map(repository.findById(Integer.valueOf(code)) , Item.class);
    }

    @Override
    public List<Item> searchByName(String name) {
        List<Item> itemList = new ArrayList<>();
        List<ItemEntity> byName = repository.findByName(name);

        byName.forEach(itemEntity -> {
            itemList.add(mapper.map(itemEntity, Item.class));
        });

        return itemList;
    }
}