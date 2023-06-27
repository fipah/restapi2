package kz.bitlab.springboot.restapi.services.impl;


import kz.bitlab.springboot.restapi.dto.ItemDto;
import kz.bitlab.springboot.restapi.entities.Item;
import kz.bitlab.springboot.restapi.repositories.ItemRepository;
import kz.bitlab.springboot.restapi.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        return mapToDto(itemRepository.save(mapToEntity(itemDto)));
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemDto> itemsDto = new ArrayList<>();
        for(int i = 0; i < items.size(); i++){
            itemsDto.add(mapToDto(items.get(i)));
        }
        return itemsDto;
    }

    @Override
    public ItemDto updateItem(ItemDto updItemDto) {
        ItemDto itemDto = mapToDto(itemRepository.findAllById(mapToEntity(updItemDto).getId()));
        itemDto.setName(updItemDto.getName());
        itemDto.setPrice(updItemDto.getPrice());
        itemDto.setAmount(updItemDto.getAmount());
        return mapToDto(itemRepository.save(mapToEntity(itemDto)));
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemDto getItem(Long id) {
        return mapToDto(itemRepository.findAllById(id));
    }


    public ItemDto mapToDto(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setPrice(item.getPrice());
        itemDto.setAmount(item.getAmount());
        return itemDto;
    }
    public Item mapToEntity(ItemDto itemDto){
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setAmount(itemDto.getAmount());
        item.setPromocode(UUID.randomUUID().toString());
        return item;
    }
}
