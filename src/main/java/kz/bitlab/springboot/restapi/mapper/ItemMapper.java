package kz.bitlab.springboot.restapi.mapper;

import kz.bitlab.springboot.restapi.dto.ItemDto;
import kz.bitlab.springboot.restapi.entities.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto mapToDto(Item item);
    Item mapToEntity(ItemDto itemDto);
    List<ItemDto> mapToDtoList(List<Item>items);
    List<Item> mapToEntityList(List<ItemDto>itemsDto);
}
