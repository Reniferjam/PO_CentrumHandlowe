import java.util.ArrayList;
import java.util.List;

public abstract class Shop implements IShop
{
    private int shopCapacity;
    private double shopIncome;
    private int shopTax;
    private double shopProfit;
    private int currentCapacity = 0;
    private int itemID;

    List<Item> itemList = new ArrayList<Item>();

    private Shop(int shopTax, double shopProfit, List<Item> itemList, int shopCapacity)
    {
        this.shopIncome = 0;
        this.shopTax = shopTax;
        this.shopProfit = 0;
        this.itemList = itemList;
        this.shopCapacity = shopCapacity;
        this.currentCapacity = 0;
        this.itemID = 0;
    }

    public void addItem()
    {
        Item item = Item.createItem();
        itemList.add(item);
    }

    public double sellProduct(Client client)
    {
        shopIncome+=client.getItem().getItemPrice();
        shopProfit = shopIncome*shopTax*0.01;
        Item item = itemList.get(itemID);
        item.decreaseQuantity();
        itemList.remove(itemID);
        itemList.add(item);
        currentCapacity++;

        return 0;
    }

//    private boolean checkCapacity(int current, int max)
//    {
//        if (shopCapacity < currentCapacity){
//
//        }
//        return true;
//    }

    public int getShopCapacity()
    {
        return shopCapacity;
    }

    public void setShopCapacity(int n)
    {

    }

    public double getShopIncome()
    {
        return shopIncome;
    }

    public void setShopTax(double n)
    {

    }

    public double getShopTax()
    {
        return shopTax;
    }

    public double getShopProfit()
    {
        return shopProfit;
    }

    public int getCurrentCapacity()
    {
        return currentCapacity;
    }

    public static void main(String[] args)
    {
        //Shop Shop1 = new Shop(0, 20, 0, itemList[0], 0);
    }
}
