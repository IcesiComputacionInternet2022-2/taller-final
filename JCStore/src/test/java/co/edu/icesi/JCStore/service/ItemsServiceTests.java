package co.edu.icesi.JCStore.service;

import co.edu.icesi.JCStore.dto.ItemDTO;
import co.edu.icesi.JCStore.mapper.ItemMapper;
import co.edu.icesi.JCStore.mapper.ItemMapperImpl;
import co.edu.icesi.JCStore.model.Item;
import co.edu.icesi.JCStore.repository.ItemRepository;
import co.edu.icesi.JCStore.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class ItemsServiceTests {

    private ItemRepository itemRepository;
    private ItemService itemService;
    private ItemMapper itemMapper;
    private Item dummyItem;
    private UUID uuid;

    public void setUpScenary1(){
        uuid = UUID.randomUUID();
        dummyItem = new Item(uuid, "Macbook", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",1000.0, "https://firebasestorage.googleapis.com/v0/b/jc-store-9e701.appspot.com/o/default.jpeg?alt=media&token=2acf5f7f-9755-4e92-8c54-f76ed9024c82");
    }

    @BeforeEach
    public void init(){
        itemMapper = new ItemMapperImpl();
        itemRepository = mock(ItemRepository.class);
        itemService = new ItemServiceImpl(itemRepository);
    }

    @Test
    public void createItemTest(){
        setUpScenary1();
        itemService.createItem(dummyItem);
        verify(itemRepository, times(1)).save(dummyItem);
    }

    @Test
    public void getItemsTest(){
        itemService.getItems();
        verify(itemRepository, times(1)).findAll();
    }

    @Test
    public void getItemTest(){
        setUpScenary1();
        itemService.getItem(dummyItem.getItemId());
        verify(itemRepository, times(1)).findById(dummyItem.getItemId());
    }

    @Test
    public void updateItemTest(){
        setUpScenary1();
        itemService.updateItem(dummyItem.getItemId(), dummyItem);
        verify(itemRepository, times(1)).findById(dummyItem.getItemId());
    }


}
