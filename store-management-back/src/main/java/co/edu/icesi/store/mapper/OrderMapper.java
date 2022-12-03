package co.edu.icesi.store.mapper;

import co.edu.icesi.store.dto.OrderCreateDTO;
import co.edu.icesi.store.dto.OrderDTO;
import co.edu.icesi.store.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    Order fromDTO(OrderCreateDTO order);
    OrderDTO fromOrder(Order order);
}
