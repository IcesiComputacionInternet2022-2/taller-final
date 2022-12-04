package icesi.VirtualStore.serviceUnitTest;

import icesi.VirtualStore.model.Item;
import icesi.VirtualStore.model.ItemType;
import icesi.VirtualStore.repository.ItemRepository;
import icesi.VirtualStore.repository.ItemTypeRepository;
import icesi.VirtualStore.service.ItemService;
import icesi.VirtualStore.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ItemTypeRepository itemTypeRepository;

    private ItemType itemType;


    private ItemService itemService;

    private Item item;

    @BeforeEach
    public void  Init(){
        itemType = new ItemType(UUID.fromString("d0f350b6-7381-11ed-a1eb-0242ac120002"),"Ajedrez","descripcion",5000.0,null);
        item =  new Item(UUID.fromString("d0f350b6-7381-11ed-a1eb-0242ac120002"),true,itemType);
        itemService = new ItemServiceImpl(itemRepository,itemTypeRepository);
    }

    @Test
    public void testGetItem(){
        when(itemTypeRepository.findById(itemType.getItemTypeId())).thenReturn(Optional.of(itemType));
        itemService.getItem(itemType.getItemTypeId());
        verify(itemTypeRepository, times(1)).findById(itemType.getItemTypeId());
    }

    @Test
    public void testGetAllItems(){
        itemService.getAllItemTypes();
        verify(itemTypeRepository,times(1)).findAll();
    }

    @Test
    public void testUpdateItem(){

        when(itemTypeRepository.updateNameAndDescriptionAndPriceAndImageByItemTypeId(itemType.getName(),itemType.getDescription(),itemType.getPrice(),itemType.getImage(),
                itemType.getItemTypeId())).thenReturn(1);
        itemService.updateItem(itemType,itemType.getItemTypeId());
        verify(itemTypeRepository,times(1)).updateNameAndDescriptionAndPriceAndImageByItemTypeId(itemType.getName()
                , itemType.getDescription(),itemType.getPrice(),itemType.getImage(), itemType.getItemTypeId());
    }

    @Test
    public void testCreateItem(){
        when(itemTypeRepository.save(itemType)).thenReturn(itemType);
        itemService.createItem(itemType);
        verify(itemTypeRepository,times(1)).save(itemType);
    }

    @Test
    public void testAddItemToStock(){
        when(itemTypeRepository.findById(itemType.getItemTypeId())).thenReturn(Optional.of(itemType));
        itemService.addItemToStock(itemType.getItemTypeId(),10);
        verify(itemTypeRepository,times(1)).findById(itemType.getItemTypeId());
        verify(itemRepository,times(10)).save(any());
    }

}
