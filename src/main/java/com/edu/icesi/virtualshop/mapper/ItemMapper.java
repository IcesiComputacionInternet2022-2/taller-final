package com.edu.icesi.virtualshop.mapper;

import com.edu.icesi.virtualshop.dto.ItemDTO;
import com.edu.icesi.virtualshop.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
        Item fromDTO(ItemDTO itemDTO);
        ItemDTO fromItem(Item item);
}
