package kz.bitlab.springboot.restapi.controllers;


import kz.bitlab.springboot.restapi.dto.ItemDto;
import kz.bitlab.springboot.restapi.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<ItemDto> getAllItems(){
        return itemService.getAllItems();
    }
    @GetMapping(value="/{id}")
    public ItemDto getItem(@PathVariable("id") Long id){
        return itemService.getItem(id);
    }
    @PostMapping
    public ItemDto addItem(@RequestBody ItemDto itemDto){
        return itemService.addItem(itemDto);
    }
    @PutMapping
    public ItemDto updateItem(@RequestBody ItemDto itemDto){
        return itemService.updateItem(itemDto);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);
    }
}
