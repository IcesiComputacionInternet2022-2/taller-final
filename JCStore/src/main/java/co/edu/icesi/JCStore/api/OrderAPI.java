package co.edu.icesi.JCStore.api;

import co.edu.icesi.JCStore.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RequestMapping("/orders")
public interface OrderAPI {

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO);

    @GetMapping
    public List<OrderDTO> getOrders();

    @GetMapping("/{orderId}")
    public OrderDTO getOrderDTO(@PathVariable UUID orderId);

    @PatchMapping("/{orderId}")
    public OrderDTO updateOrderStatus(@PathVariable UUID orderId, @RequestBody OrderDTO orderDTO);

    @GetMapping("/users/{userId}")
    public List<OrderDTO> getOrdersMadeByUser(@PathVariable UUID userId);

    @PatchMapping("/cancel/{orderId}")
    public OrderDTO cancelOrder(@PathVariable UUID orderId);
}
