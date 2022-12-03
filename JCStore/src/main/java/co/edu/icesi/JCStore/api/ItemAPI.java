package co.edu.icesi.JCStore.api;

import co.edu.icesi.JCStore.dto.ItemDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RequestMapping("/items")
public interface
ItemAPI {

    @PostMapping
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO);

    @GetMapping
    public List<ItemDTO> getItems();

    @GetMapping("/{itemId}")
    public ItemDTO getItem(@PathVariable UUID itemId);

    @PutMapping("/{itemId}")
    public ItemDTO updateItem(@PathVariable UUID itemId, @RequestBody ItemDTO itemDTO);

}
