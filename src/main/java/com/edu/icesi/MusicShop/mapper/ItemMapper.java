package com.edu.icesi.MusicShop.mapper;

import com.edu.icesi.MusicShop.dto.ItemDTO;
import com.edu.icesi.MusicShop.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item fromDTO(ItemDTO itemDTO);

    ItemDTO fromItem(Item item);

}
