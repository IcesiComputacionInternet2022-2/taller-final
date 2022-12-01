package co.edu.icesi.VirtualStore.service;

import co.edu.icesi.VirtualStore.model.BasketItem;
import co.edu.icesi.VirtualStore.model.Item;
import co.edu.icesi.VirtualStore.model.User;

import java.util.List;
import java.util.UUID;

public interface BasketService {

    void addItemToBasket(UUID userId, Item item, int quantity);

    void removeItemFromBasket(UUID basketItemId);

    void createBasket(User user);

    List<BasketItem> getBasketItems(UUID userId);

    void clearBasket(UUID userId);

}
