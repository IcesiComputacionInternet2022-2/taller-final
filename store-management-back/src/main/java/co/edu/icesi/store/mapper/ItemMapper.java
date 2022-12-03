package co.edu.icesi.store.mapper;

import co.edu.icesi.store.dto.ItemDTO;
import co.edu.icesi.store.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDTO fromItem(Item item);

    Item fromDTO(ItemDTO itemDTO);
}
