package cs85.oop2.assignment2.config;

import cs85.oop2.assignment2.model.SaleItem;
import cs85.oop2.assignment2.repository.SaleItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/*
* The price structures are as follows:
- The rare product "Penguin-ears" is 20 units per carton. A carton is 175,-
- The product "Horseshoe" is 5 units per carton, a carton is 825,-
- If you purchase single units, the price is acquired using the carton price multiplied by an increase of
        30% (1.3). (to compensate for manual labor)
- If you purchase 3 cartons or more, you will receive a 10% discount off the carton price
*
* */

@Configuration
public class SaleItemConfig {
    @Bean
    CommandLineRunner commandLineRunner(SaleItemRepository repository){
        return args -> {
            repository.saveAll(
                    List.of(
                            new SaleItem("i001","Penguin-ears",20,175D,true),
                            new SaleItem("i002","Horseshoe",5,825D,true)
                    )
            );
        };
    }
}
