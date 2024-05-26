import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop implements IShop
{
    private int shopCapacity;
    private double shopIncome;
    private int shopTax;
    private double shopProfit;
    private int currentCapacity = 0;
    private int itemID;

    private int itemNumber;

    Item[] itemList;

    private Shop(int shopTax, Item[] itemList, int shopCapacity, int itemNumber)
    {
        this.shopIncome = 0;
        this.shopTax = shopTax;
        this.shopProfit = 0;
        this.itemList = itemList;
        this.shopCapacity = shopCapacity;
        this.currentCapacity = 0;
        this.itemID = 0;
        this.itemNumber = itemNumber;
    }


    public double sellProduct(Client client)
    {
        shopIncome+=client.getItem().getItemPrice();
        shopProfit = shopIncome*0.01; // ogarnij
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

    public double sellProduct()
    {
        return 0;
    }

    public static  Shop createShop()
    {
        System.out.println("Shop: createShop");
        System.out.println();


        Scanner scan = new Scanner(System.in);
        System.out.println("Set Shop Tax 1-100 [%]: ");
        int Tax = scan.nextInt();

        System.out.println("Set Shop Capacity >0: ");
        int Capacity = scan.nextInt();



        System.out.println("Set number of Shop products: ");
        int numberOfProducts = scan.nextInt();
        Item[] list = new Item[numberOfProducts];
        for (int i = 0; i < numberOfProducts; i++)
        {
            list[i] = Item.createItem();
        }
        return new Shop(Tax,list,Capacity,numberOfProducts);
    }

    public static Shop createExampleShopA()
    {
        Item[] list = new Item[2];

        list[0] = Item.createExampleItemA1();
        list[1] = Item.createExampleItemA2();

        return new Shop(20,list,5,2);
    }

    public static Shop createExampleShopB()
    {
        Item[] list = new Item[2];

        list[0] = Item.createExampleItemB1();
        list[1] = Item.createExampleItemB2();

        return new Shop(40,list,10,2);
    }
}
