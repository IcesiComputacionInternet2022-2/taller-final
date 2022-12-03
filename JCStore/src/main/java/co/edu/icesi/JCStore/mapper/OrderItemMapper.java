package co.edu.icesi.JCStore.mapper;

import co.edu.icesi.JCStore.dto.OrderItemDTO;
import co.edu.icesi.JCStore.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDTO fromOrderItem(OrderItem orderItem);

    OrderItem fromDTO(OrderItemDTO orderItemDTO);
}
