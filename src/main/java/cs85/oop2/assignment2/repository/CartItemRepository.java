package cs85.oop2.assignment2.repository;

import cs85.oop2.assignment2.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    @Query("SELECT SUM(c.price) FROM CartItem c")
    float getTotalPrice();
}
