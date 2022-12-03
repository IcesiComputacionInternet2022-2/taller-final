package co.edu.icesi.JCStore.mapper;

import co.edu.icesi.JCStore.dto.ItemDTO;
import co.edu.icesi.JCStore.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item fromDTO(ItemDTO itemDTO);
    ItemDTO fromItem(Item item);


}
