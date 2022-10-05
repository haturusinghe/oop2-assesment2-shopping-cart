package cs85.oop2.assignment2.controller;

import cs85.oop2.assignment2.model.SaleItem;
import cs85.oop2.assignment2.service.SaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SalesItemViewController {
    private final SaleItemService saleItemService;

    @Autowired
    public SalesItemViewController(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    @GetMapping
    public String itemList(Model model){
        model.addAttribute("items",saleItemService.getSaleItems());
        return "list";
    }

    @GetMapping("/add")
    public String addItem(Model model) {
        SaleItem saleItem = new SaleItem();
        model.addAttribute("saleItem", saleItem);
        return "add_item";

    }

    @PostMapping("/add")
    public String saveItem(@ModelAttribute("saleItem") SaleItem saleItem) {
        saleItemService.addNewSaleItem(saleItem);
        return "redirect:/";
    }

    @GetMapping("/item/{id}")
    public String editSaleItem(@PathVariable Long id, Model model) {
        model.addAttribute("saleItem", saleItemService.getSaleItem(id).get());
        return "edit_item";
    }

    @PostMapping("/item/{id}")
    public String updateSaleItem(@PathVariable Long id,@ModelAttribute("saleItem") SaleItem saleItem ,Model model) {
        saleItemService.addNewSaleItem(saleItem);
        return "redirect:/";
    }

    @GetMapping("/item/delete/{id}")
    public String deleteSaleItem(@PathVariable Long id) {
        saleItemService.deleteSaleItem(id);
        return "redirect:/";
    }
}
