package cs85.oop2.assignment2.controller;

import cs85.oop2.assignment2.service.SaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "item_list";
    }
}
