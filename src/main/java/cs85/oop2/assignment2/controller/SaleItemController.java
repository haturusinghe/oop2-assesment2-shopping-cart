package cs85.oop2.assignment2.controller;

import cs85.oop2.assignment2.model.SaleItem;
import cs85.oop2.assignment2.service.SaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/item")
public class SaleItemController {
    private final SaleItemService saleItemService;

    @Autowired
    public SaleItemController(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    @GetMapping(path = "list")
    public ResponseEntity<List<SaleItem>> getSaleItemList(){
        return new ResponseEntity<>(saleItemService.getSaleItems(), HttpStatus.OK);
    }
}
