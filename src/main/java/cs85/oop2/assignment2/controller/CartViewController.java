package cs85.oop2.assignment2.controller;

import cs85.oop2.assignment2.model.CartItem;
import cs85.oop2.assignment2.dto.CartMeta;
import cs85.oop2.assignment2.dto.EditCartMeta;
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
        EditCartMeta itemToAdd = new EditCartMeta(id,saleItemService.getSaleItem(id).get().getItemName(), 0, 0);
        model.addAttribute("itemToAdd", itemToAdd);
        return "add_cart";
    }

    @PostMapping("/add/{id}")
    public String addItemToCart(@ModelAttribute("itemToAdd") EditCartMeta cartItem , Model model, @PathVariable Long id){

        SaleItem saleItem = saleItemService.getSaleItem(id).get();
        CartItem newCartItem = new CartItem(saleItem, cartItem.getCartons(), cartItem.getSingleItems());
        cartItemService.addItemToCart(newCartItem);

        return "redirect:/cart";
    }

    @GetMapping("/edit/{id}")
    public String editItemToCart(Model model,@PathVariable Long id){
        CartItem current = cartItemService.getCartItem(id).get();
        EditCartMeta itemToEdit = new EditCartMeta(current.getId(),current.getItem().getItemName(), current.getCartons(), current.getSingleItems());
        model.addAttribute("itemToEdit", itemToEdit);
        return "edit_cart";
    }

    @PostMapping("/edit/{id}")
    public String editItemToCart(@ModelAttribute("itemToEdit") EditCartMeta cartItem , Model model, @PathVariable Long id){
        CartItem itemToEdit = cartItemService.getCartItem(id).get();
        itemToEdit.setCartons(cartItem.getCartons());
        itemToEdit.setSingleItems(cartItem.getSingleItems());
        cartItemService.addItemToCart(itemToEdit);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String deleteItemFromCart(Model model,@PathVariable Long id){
        cartItemService.deleteCartItem(id);
        return "redirect:/cart";
    }



}
