package edu.icet.controller;

import edu.icet.dto.Item;
import edu.icet.service.impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {
//http://localhost:8080/customer/add

    @Autowired
    final ItemServiceImpl service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody Item item){
        service.addItem(item);
    }

    @GetMapping("/get-all")
    public List<Item> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteItem(@PathVariable String code){
        service.deleteItem(code);
    }

    @PutMapping("/update-item")
    public void updateItem(@RequestBody Item item){
        service.updateItem(item);
    }

    @GetMapping("/search-by-code/{code}")
    public Item searchByCode(@PathVariable String code){
        return service.searchByCode(code);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Item> searchByName(@PathVariable String name){
        return service.searchByName(name);
    }

}
