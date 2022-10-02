package cs85.oop2.assignment2.controller;

import cs85.oop2.assignment2.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "cart")
public class CartViewController {
    private final CartItemService cartItemService;

    @Autowired
    public CartViewController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public String viewCart(Model model){
        CartMeta cartMeta = new CartMeta(cartItemService.getTotalCartPrice(),cartItemService.getTotalItems());
        model.addAttribute("citems",cartItemService.getAll());
        model.addAttribute("cmeta",cartMeta);
        return "cart";
    }

    private class CartMeta {
        float totalCartPrice;
        int totalItems;

        public CartMeta(float totalCartPrice, int totalItems) {
            this.totalCartPrice = totalCartPrice;
            this.totalItems = totalItems;
        }

        public float getTotalCartPrice() {
            return totalCartPrice;
        }

        public void setTotalCartPrice(float totalCartPrice) {
            this.totalCartPrice = totalCartPrice;
        }

        public int getTotalItems() {
            return totalItems;
        }

        public void setTotalItems(int totalItems) {
            this.totalItems = totalItems;
        }
    }
}
