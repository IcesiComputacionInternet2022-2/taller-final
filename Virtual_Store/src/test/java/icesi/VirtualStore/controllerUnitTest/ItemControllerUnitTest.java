package icesi.VirtualStore.controllerUnitTest;

import icesi.VirtualStore.controller.ItemController;
import icesi.VirtualStore.dto.ItemTypeDTO;
import icesi.VirtualStore.mapper.ItemTypeMapper;
import icesi.VirtualStore.mapper.ItemTypeMapperImpl;
import icesi.VirtualStore.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ItemControllerUnitTest {

    @Mock
    private ItemService itemService;

    private ItemTypeMapper itemTypeMapper;


    private ItemController itemController;

    private ItemTypeDTO itemTypeDTO;

    @BeforeEach
    public void init(){

         itemTypeDTO =  new ItemTypeDTO(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"),
                "Juego de rol","Juego de Rol",5000,null);
        itemTypeMapper = new ItemTypeMapperImpl();

        itemController =  new ItemController(itemService,itemTypeMapper);

    }

    /*
    1 get all items
    2 add item type
    3 get item
    4 update item
    5 add item to stock
     */

    @Test
    public void testGetAllItems(){
        itemController.getAllItemTypes();
        verify(itemService,times(1)).getAllItemTypes();
    }

    @Test
    public void testGetItemType(){
        itemController.getItem(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
        verify(itemService,times(1)).getItem(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
    }


    @Test
    public void testAddItemType(){

        itemController.addItemType(itemTypeDTO);

        verify(itemService,times(1)).createItem(itemTypeMapper.fromDTO(itemTypeDTO));
    }

    @Test
    public void testAddItemToStock(){
        itemController.addItemToStock(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"),10);
        verify(itemService,times(1)).addItemToStock(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"),10);
    }

    @Test
    public void testUpdateItem(){
        itemController.updateItem(itemTypeDTO,UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
        verify(itemService,times(1)).updateItem(itemTypeMapper.fromDTO(itemTypeDTO),UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
    }
}
