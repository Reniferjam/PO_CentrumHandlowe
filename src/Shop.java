import java.util.ArrayList;
import java.util.Scanner;

/**
 * It represents a shop with certain variables.
 * It belongs to the shopping mall.
 */
public class Shop
{
    private int shopCapacity;
    private double shopIncome;
    private int shopTax;
    private double shopProfit;
    private int currentCapacity = 0;
    private double profitOnClient; //average profit on one client
    private int soldProducts=0;
    private ArrayList<Item> itemList = new ArrayList<Item>(); // ArrayList of items
    Shop(int shopTax, ArrayList<Item> itemList, int shopCapacity) //constructor of a shop
    {
        this.shopIncome = 0;
        this.shopTax = shopTax;
        this.shopProfit = 0;
        this.itemList = itemList;
        this.shopCapacity = shopCapacity;
        this.currentCapacity = 0;
        this.profitOnClient = 0;
    }
    Shop() //default constructor of a shop
    {
        this.shopIncome = -1;
        this.shopTax = -1;
        this.shopProfit = -1;
        this.itemList = new ArrayList<Item>();
        this.shopCapacity = -1;
        this.currentCapacity = -1;
        this.profitOnClient = 0;
    }
    /**
     * This method is making an operation of selling a product.
     * It has a specified itemID, Client and ShopID, for the Item it is selling.
     * It increases a current capacity of a shop and a number of sold products.
     *
     * @param itemID id of a selling item
     * @param client client who is buying an item
     * @param ShopID id of a shop that is selling an item
     */
    public void sellProduct(int itemID,Client client,int ShopID)
    {
        for (int n = 0; n < itemList.size(); n++)
        {
            if(itemList.get(n).getItemID() == itemID)
            {
                System.out.println("Sold " + client.getItem().getItemQuantity() + " " + itemList.get(n).getItemName() + " at " + (ShopID+1) + " shop");
                System.out.println();

                shopIncome+=  ( itemList.get(n).getItemPrice() ) *  client.getItem().getItemQuantity();
                itemList.get(n).setItemQuantity(itemList.get(n).getItemQuantity() - client.getItem().getItemQuantity());
                client.getItem().setItemQuantity(0);
                currentCapacity++;
                shopProfit=shopIncome * (100 - shopTax) / 100;
                soldProducts++;
                return;
            }
        }
    }
    public int getShopCapacity()
    {
        return shopCapacity;
    }
    public double getShopIncome()
    {
        return shopIncome;
    }
    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }
    public double getShopProfit()
    {
        return shopProfit;
    }
    public int getCurrentCapacity()
    {
        return currentCapacity;
    }
    public ArrayList<Item> getItemList() {
        return itemList;
    }
    public Item getItem(int n)
    {
        return itemList.get(n);
    }
    public double getProfitOnClient() {
        return profitOnClient;
    }
    public void setProfitOnClient(double profitOnClient) {
        this.profitOnClient = profitOnClient;
    }
    public int getSoldProducts() {
        return soldProducts;
    }

    /**
     * Method that is printing a table with store statistics data.
     *
     * @param shopList list of shops in shopping mall
     * @param numberOfRounds number of current round
     */
    public static void printShops(ArrayList<Shop> shopList, int numberOfRounds)
    {
        System.out.printf("Round %2d |  income  |  profit  | prof/cli | currentCap | capacity |" ,numberOfRounds+1);
        System.out.println("\n-------------------------------------------------------------------");
        for (int i = 0; i < shopList.size(); i++)
        {
            shopList.get(i).setProfitOnClient(shopList.get(i).getShopProfit()/shopList.get(i).getSoldProducts());
            System.out.printf("Shop  %2d | %8.2f | %8.2f | %8.2f | %10d | %8d |", i+1, shopList.get(i).getShopIncome(), shopList.get(i).getShopProfit(), shopList.get(i).getProfitOnClient(), shopList.get(i).getCurrentCapacity(), shopList.get(i).getShopCapacity());
            System.out.println();
        }
        System.out.println();

        System.out.println(shopList.get(0).getCurrentCapacity());
    }
}
