package cs85.oop2.assignment2.model;

import javax.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private SaleItem item;

    private int cartons;
    private int singleItems;

    private float price;

    public CartItem() {
    }

    public CartItem(SaleItem item, int cartons, int singleItems) {
        this.item = item;
        this.cartons = cartons;
        this.singleItems = singleItems;

        double sum = 0;
        int unitsInCarton = this.item.getUnitsInCarton();
        double cartonPrice = this.item.getCartonPrice();

        if(singleItems > unitsInCarton){
            this.cartons += this.singleItems / unitsInCarton;
            this.singleItems = this.singleItems % unitsInCarton;
        }

        this.price = (float) calculatePrice(cartonPrice);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SaleItem getItem() {
        return item;
    }

    public void setItem(SaleItem item) {
        this.item = item;
    }

    public int getCartons() {
        return cartons;
    }

    public void setCartons(int cartons) {
        this.cartons = cartons;
    }

    public int getSingleItems() {
        return singleItems;
    }

    public void setSingleItems(int singleItems) {
        this.singleItems = singleItems;
    }


    private double calculatePrice(double cartonPrice) {
        double cartonTotalPrice;
        if(this.cartons > 2){
            cartonTotalPrice = this.cartons * cartonPrice * 0.9; //10% discount
        }else{
            cartonTotalPrice = this.cartons * cartonPrice;
        }
        double singlesTotalPrice = this.singleItems * cartonPrice * 1.3;
        return (singlesTotalPrice + cartonTotalPrice);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
