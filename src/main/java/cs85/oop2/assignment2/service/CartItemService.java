package cs85.oop2.assignment2.service;

import cs85.oop2.assignment2.model.CartItem;
import cs85.oop2.assignment2.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getAll() {
        return cartItemRepository.findAll();
    }

    public float getTotalCartPrice(){
        return cartItemRepository.getTotalPrice();
    }
}
