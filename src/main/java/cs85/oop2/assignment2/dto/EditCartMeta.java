package cs85.oop2.assignment2.dto;

public class EditCartMeta {
    private long id;
    private String itemName;
    private int cartons;
    private int singleItems;

    public EditCartMeta(long id, String itemName, int cartons, int singleItems) {
        this.id = id;
        this.itemName = itemName;
        this.cartons = cartons;
        this.singleItems = singleItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
}
