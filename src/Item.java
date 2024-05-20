public class Item
{
    private String itemName;
    private int itemID, itemQuantity, itemQuality;
    private double itemPrice;

    private Item(String itemName, int itemID, int itemQuantity, int itemQuality, int itemPrice)
    {
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
        this.itemQuality = itemQuality;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public int getItemQuality() {
        return itemQuality;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

}
