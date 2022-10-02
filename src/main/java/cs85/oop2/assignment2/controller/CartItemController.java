package cs85.oop2.assignment2.controller;

import cs85.oop2.assignment2.model.SaleItem;
import cs85.oop2.assignment2.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/cart")
public class CartItemController {
    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }


    @GetMapping(path = "all")
    public ResponseEntity<List<SaleItem>> getAllCartItems() {
        return new ResponseEntity(cartItemService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "all/total")
    public float getCartTotal() {
        return cartItemService.getTotalCartPrice();
    }
}
