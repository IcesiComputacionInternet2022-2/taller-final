package co.edu.icesi.store.api;

import co.edu.icesi.store.dto.ItemDTO;
import co.edu.icesi.store.dto.OrderCreateDTO;
import co.edu.icesi.store.dto.OrderDTO;
import co.edu.icesi.store.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/store")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public interface StoreAPI {

    @PostMapping("/item")
    ItemDTO item(@RequestBody Item item);

    @GetMapping("/item")
    List<ItemDTO> item();

    @PostMapping("/order")
    OrderDTO order(@RequestBody OrderCreateDTO order);
}
