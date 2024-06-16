import java.util.Locale;
import java.util.Scanner;

/**
 * Item is a product in a shop, which client can buy.
 */
public class Item
{
    private String itemName;
    private int itemID, itemQuantity, itemQuality;
    private double itemPrice;
    Item(String itemName, int itemID, int itemQuantity, int itemQuality, double itemPrice) // konstruktor Itemu
    {
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
        this.itemQuality = itemQuality;
        this.itemPrice = itemPrice;
    }
    private Item() //default constructor of Item
    {
        this.itemName = "ERROR";
        this.itemID = -1;
        this.itemQuantity = -1;
        this.itemQuality = -1;
        this.itemPrice = -1;
    }
    public String getItemName()
    {
        return itemName;
    }
    public int getItemID()
    {
        return itemID;
    }
    public int getItemQuality()
    {
        return itemQuality;
    }
    public double getItemPrice()
    {
        return itemPrice;
    }
    public int getItemQuantity()
    {
        return itemQuantity;
    }
    public void setItemQuantity(int itemQuantity)
    {
        this.itemQuantity = itemQuantity;
    }
}
