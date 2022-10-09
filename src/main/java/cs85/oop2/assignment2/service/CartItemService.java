package cs85.oop2.assignment2.service;

import cs85.oop2.assignment2.model.CartItem;
import cs85.oop2.assignment2.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if(cartItemRepository.findAll().size() > 0){
            return cartItemRepository.getTotalPrice();
        }else{
            return 0;
        }

    }

    public int getTotalItems() {
        if(cartItemRepository.findAll().size() > 0){
            return cartItemRepository.getItemCount();
        }else{
            return 0;
        }
    }

    public void addItemToCart(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    public Optional<CartItem> getCartItem(Long id) {
        return cartItemRepository.findById(id);
    }

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}
