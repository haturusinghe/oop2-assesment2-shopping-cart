package cs85.oop2.assignment2.service;

import cs85.oop2.assignment2.model.SaleItem;
import cs85.oop2.assignment2.repository.SaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleItemService {
    private final SaleItemRepository saleItemRepository;

    @Autowired
    public SaleItemService(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    public List<SaleItem> getSaleItems() {
        return saleItemRepository.findAll();
    }

    public void addNewSaleItem(SaleItem saleItem) {
        saleItemRepository.save(saleItem);
    }

    public Optional<SaleItem> getSaleItem(Long id) {
        return saleItemRepository.findById(id);
    }

    public void deleteSaleItem(Long id) {
        saleItemRepository.deleteById(id);
    }
}
