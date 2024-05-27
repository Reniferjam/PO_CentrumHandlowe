import java.util.Scanner;

public class Shop implements IShop
{
    private int shopCapacity;
    private double shopIncome;
    private int shopTax;
    private double shopProfit;
    private int currentCapacity = 0;
    private int itemID;

    private int numberOfProducts;

    Item[] itemList;

    private Shop(int shopTax, Item[] itemList, int shopCapacity, int numberOfProducts)
    {
        this.shopIncome = 0;
        this.shopTax = shopTax;
        this.shopProfit = 0;
        this.itemList = itemList;
        this.shopCapacity = shopCapacity;
        this.currentCapacity = 0;
        this.itemID = 0;
        this.numberOfProducts = numberOfProducts;
    }


    public double sellProduct(Client client)
    {
        System.out.println("Shop: sellProduct");
        System.out.println();

        shopIncome += client.getItem().getItemPrice();
        shopProfit = shopIncome + shopIncome*shopTax*0.01;
        currentCapacity++;

        while (client.getItem().getItemQuantity() > 0)
        {
            client.getItem().setItemQuantity(client.getItem().getItemQuantity()-1);
            System.out.println("Sold one item. Remaining quantity: " + client.getItem().getItemQuantity());
        }
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

    public Item[] getItemList() {
        return itemList;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public static  Shop createShop()
    {
        System.out.println("Shop: createShop");
        System.out.println();


        Scanner scan = new Scanner(System.in);
        int Tax;
        do
        {
            System.out.println("Set Shop Tax 1-100 [%]: ");
            Tax = scan.nextInt();
            scan.nextLine();
            if (Tax < 1 || Tax > 100)
            {
                System.out.println("Wrong data");
            }
        } while (Tax < 1 || Tax > 100);

        int Capacity;
        do
        {
            System.out.println("Set Shop Capacity [>0]: ");
            Capacity = scan.nextInt();
            scan.nextLine();
            if (Capacity <= 0)
            {
                System.out.println("Wrong data");
            }
        } while (Capacity <= 0);


        System.out.println("Set number of Shop products: ");        //mozna ustawic bramke na ilosc produktow
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
