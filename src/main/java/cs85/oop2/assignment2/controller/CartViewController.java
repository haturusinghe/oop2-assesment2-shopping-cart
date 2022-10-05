package cs85.oop2.assignment2.controller;

import cs85.oop2.assignment2.model.CartItem;
import cs85.oop2.assignment2.model.SaleItem;
import cs85.oop2.assignment2.service.CartItemService;
import cs85.oop2.assignment2.service.SaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "cart")
public class CartViewController {
    private final CartItemService cartItemService;
    private final SaleItemService saleItemService;

    @Autowired
    public CartViewController(CartItemService cartItemService, SaleItemService saleItemService) {
        this.cartItemService = cartItemService;
        this.saleItemService = saleItemService;
    }



    @GetMapping
    public String viewCart(Model model){
        CartMeta cartMeta = new CartMeta(cartItemService.getTotalCartPrice(),cartItemService.getTotalItems());
        model.addAttribute("citems",cartItemService.getAll());
        model.addAttribute("cmeta",cartMeta);
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addItemToCart(Model model,@PathVariable Long id){
        CartItem itemToAdd = new CartItem();
        itemToAdd.setItem(saleItemService.getSaleItem(id).get());
        model.addAttribute("itemToAdd", itemToAdd);
        return "add_cart";
    }

    @PostMapping("/add/{id}")
    public String addItemToCart(@ModelAttribute("itemToAdd") CartItem cartItem , Model model, @PathVariable Long id){
        SaleItem saleItem = saleItemService.getSaleItem(id).get();
        CartItem itemToAdd = new CartItem(saleItem,cartItem.getCartons(),cartItem.getSingleItems());
        cartItemService.addItemToCart(itemToAdd);
        return "redirect:/cart";
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
