package cs85.oop2.assignment2.repository;

import cs85.oop2.assignment2.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem,Long> {
//    Optional<SaleItem> findByEmailContains(String email);

    Optional<SaleItem> findOneByItemNumber(String itemNumber);
}
