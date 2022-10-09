package cs85.oop2.assignment2.dto;

public class CartMeta {
    float totalCartPrice;
    int totalItems;

    public CartMeta(float totalCartPrice, int totalItems) {
        this.totalCartPrice = totalCartPrice;
        this.totalItems = totalItems;
    }

    public float getTotalCartPrice() {
        return totalCartPrice;
    }

    public void setTotalCartPrice(float totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}

