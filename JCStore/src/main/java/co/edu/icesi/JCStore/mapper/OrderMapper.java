package co.edu.icesi.JCStore.mapper;

import co.edu.icesi.JCStore.dto.OrderDTO;
import co.edu.icesi.JCStore.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    public OrderDTO fromOrder(Order order);

    public Order fromDTO(OrderDTO orderDTO);
}
