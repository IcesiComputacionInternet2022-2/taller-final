package co.edu.icesi.VirtualStore.service.impl;

import co.edu.icesi.VirtualStore.model.Basket;
import co.edu.icesi.VirtualStore.model.BasketItem;
import co.edu.icesi.VirtualStore.model.Item;
import co.edu.icesi.VirtualStore.model.User;
import co.edu.icesi.VirtualStore.repository.BasketItemRepository;
import co.edu.icesi.VirtualStore.repository.BasketRepository;
import co.edu.icesi.VirtualStore.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    private final BasketItemRepository basketItemRepository;

    @Override
    public void addItemToBasket(UUID userId, Item item, int quantity) {
        Basket basket = basketRepository.getBasket(userId);

        BasketItem basketItem = BasketItem.builder().basket(basket).item(item).quantity(quantity).build();
        basketItem.generateId();

        basketItemRepository.save(basketItem);
    }

    @Override
    public void removeItemFromBasket(UUID basketItemId) {
        basketItemRepository.deleteById(basketItemId);
    }

    @Override
    public void createBasket(User user) {
        if(basketRepository.getBasket(user.getId()) != null) return;

        Basket newBasket = Basket.builder().user(user).build();
        newBasket.generateId();

        basketRepository.save(newBasket);
    }

    @Override
    public List<BasketItem> getBasketItems(UUID userId) {
        UUID basketId = basketRepository.getBasket(userId).getId();
        return basketItemRepository.getBasketItems(basketId);
    }

    @Override
    public void clearBasket(UUID userId) {
        List<BasketItem> items = getBasketItems(userId);
        basketItemRepository.deleteAll(items);
    }
}
