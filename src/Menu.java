import java.util.Scanner;

public class Menu
{
    private int NumberOfShops = 3;
    private ShoppingMall shoppingMall;
    //zmienne do klienta
    private int chanceOfRandomClient = 30;
    private int minQuality = 20, maxQuality = 80;
    private double minPrice = 100, maxPrice = 300;

//    private Menu()
//    {
//        this.NumberOfShops = NumberOfShops;
//        this.shoppingMall = shoppingMall;
//        this.chanceOfRandomClient = chanceOfRandomClient;
//    }

    public  void startSimulation()
    {
        System.out.println("Menu: startSimulation");
        System.out.println();

        ShoppingMall shoppingMall = new ShoppingMall(NumberOfShops);
        createShops();
        /////////////////////////
        shoppingMall.nextRound();
        /////////////////////////
        System.out.println("Czy chcesz kontynuować symulacje? 1 to tak");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        while (scan.nextInt() == 1)
        {
            System.out.println();
            shoppingMall.nextRound();
            System.out.println("Czy chcesz kontynuować symulacje? 1 to tak");
        }
    }

    public void customizeClients()
    {

    }

    public void customizeShoppingMall()
    {

    }

    public void setNumberOfShops(int numberOfShops)
    {
        NumberOfShops = numberOfShops;
    }

    public int getNumberOfShops()
    {
        return NumberOfShops;
    }

    public static void main(String[] args)
     {
         Menu menu = new Menu();
         menu.startSimulation();
     }

    public static void createShops()
    {
        Item[] list1 = new Item[2];

        list1[0] = Item.createExampleItemB1();
        list1[1] = Item.createExampleItemB2();

        //ShoppingMall.initShops(new Shop(40,list1,10,2)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow


        //new Shop(20,list2,10,2);
        //new Shop(15,list3,10,2);

    }

}