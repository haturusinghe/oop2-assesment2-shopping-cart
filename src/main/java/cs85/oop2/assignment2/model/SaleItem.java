package cs85.oop2.assignment2.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String itemNumber;

    @NotBlank
    private String itemName;

    private int unitsInCarton = 0;

    private double cartonPrice = 0;

    private boolean isRare = false;

    public SaleItem() {
    }

    public SaleItem(String itemNumber, String itemName, int unitsInCarton, double cartonPrice, boolean isRare) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.unitsInCarton = unitsInCarton;
        this.cartonPrice = cartonPrice;
        this.isRare = isRare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getUnitsInCarton() {
        return unitsInCarton;
    }

    public void setUnitsInCarton(int unitsInCarton) {
        this.unitsInCarton = unitsInCarton;
    }

    public double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public boolean isRare() {
        return isRare;
    }

    public void setRare(boolean rare) {
        isRare = rare;
    }
}
