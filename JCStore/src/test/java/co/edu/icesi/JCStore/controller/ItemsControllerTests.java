package co.edu.icesi.JCStore.controller;

import co.edu.icesi.JCStore.dto.ItemDTO;
import co.edu.icesi.JCStore.mapper.ItemMapper;
import co.edu.icesi.JCStore.mapper.ItemMapperImpl;
import co.edu.icesi.JCStore.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ItemsControllerTests {

    private ItemController itemController;
    private ItemMapper itemMapper;
    private ItemService itemService;

    private ItemDTO dummyItem;
    private UUID uuid;

    public void setUpScenary1(){
        uuid = UUID.randomUUID();
        dummyItem = new ItemDTO(uuid, "Macbook", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",1000.0, "https://firebasestorage.googleapis.com/v0/b/jc-store-9e701.appspot.com/o/default.jpeg?alt=media&token=2acf5f7f-9755-4e92-8c54-f76ed9024c82");
    }

    @BeforeEach
    public void init(){
        itemMapper = new ItemMapperImpl();
        itemService = mock(ItemService.class);
        itemController = new ItemController(itemService, itemMapper);
    }

    @Test
    public void createAnimalTest(){
        setUpScenary1();
        try{
            itemController.createItem(dummyItem);
            verify(itemService, times(1)).createItem(any());
        }catch(Exception e){
            fail();
        }
    }

    @Test
    public void getItemsTest(){

        itemController.getItems();
        verify(itemService, times(1)).getItems();

    }

    @Test
    public void getItemTest(){
        setUpScenary1();
        itemController.getItem(dummyItem.getItemId());
        verify(itemService, times(1)).getItem(dummyItem.getItemId());
    }

    @Test
    public void updateItemTest(){
        setUpScenary1();
        itemController.updateItem(dummyItem.getItemId(), dummyItem);
        verify(itemService, times(1)).updateItem(any(), any());
    }

}

