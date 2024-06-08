import java.util.ArrayList;
import java.util.Scanner;

public class Shop implements IShop
{
    private int shopCapacity;
    private double shopIncome;
    private int shopTax;
    private double shopProfit;
    private int currentCapacity = 0;
    private int numberOfProducts;
    private double profitOnClient;
    private ArrayList<Item> itemList = new ArrayList<Item>();
    Shop(int shopTax, ArrayList<Item> itemList, int shopCapacity, int numberOfProducts)
    {
        this.shopIncome = 0;
        this.shopTax = shopTax;
        this.shopProfit = 0;
        this.itemList = itemList;
        this.shopCapacity = shopCapacity;
        this.currentCapacity = 0;
        this.numberOfProducts = numberOfProducts;
        this.profitOnClient = 0;
    }
    Shop()
    {
        this.shopIncome = -1;
        this.shopTax = -1;
        this.shopProfit = -1;
        this.itemList = new ArrayList<Item>();
        this.shopCapacity = -1;
        this.currentCapacity = -1;
        this.numberOfProducts = -1;
        this.profitOnClient = 0;
    }
    public void sellProduct(int itemID,Client client,int ShopID) // do poprawienia
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
    public ArrayList<Item> getItemList() {
        return itemList;
    }
    public Item getItem(int n)
    {
        return itemList.get(n);
    }
    public int getNumberOfProducts() {
        return numberOfProducts;
    }
    public double getProfitOnClient() {
        return profitOnClient;
    }

    public void setProfitOnClient(double profitOnClient) {
        this.profitOnClient = profitOnClient;
    }

    public static void printShops(Shop[] shopList, int numberOfRounds)
    {
        System.out.printf("Round %2d |  income  |  profit  | prof/cli | currentCap | capacity |" ,numberOfRounds+1);
        System.out.println("\n-------------------------------------------------------------------");
        for (int i = 0; i < shopList.length; i++)
        {
            System.out.printf("Shop  %2d | %8.2f | %8.2f | %8.2f | %10d | %8d |", i+1, shopList[i].getShopIncome(), shopList[i].getShopProfit(), shopList[i].getShopProfit(), shopList[i].getCurrentCapacity(), shopList[i].getShopCapacity());
            System.out.println();
        }
        System.out.println();
//        System.out.printf("%8d %8d %8d %8d %d");
    }

}
