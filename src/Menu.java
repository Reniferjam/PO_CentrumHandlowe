import java.util.Scanner;

public class Menu
{
    private int NumberOfShops = 3;
    private ShoppingMall shoppingMall;

    public  void startSimulation()
    {
        System.out.println("Menu: startSimulation");
        System.out.println();

        ShoppingMall shoppingMall = new ShoppingMall(NumberOfShops,30,20,80,100,300);
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
            /////////////////////////
            shoppingMall.nextRound();
            /////////////////////////
            System.out.println("Czy chcesz kontynuować symulacje? 1 to tak");
        }
    }

    public void createShops()
    {
        Item[] listA = new Item[2];

        listA[0] = Item.createExampleItemA1();
        listA[1] = Item.createExampleItemA2();

        shoppingMall.initShops(new Shop(40,listA,10,2)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow

        Item[] listB = new Item[2];

        listB[0] = Item.createExampleItemB1();
        listB[1] = Item.createExampleItemB2();

        shoppingMall.initShops(new Shop(40,listB,10,2)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow

        //new Shop(20,list2,10,2);
        //new Shop(15,list3,10,2);
    }
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.startSimulation();
    }
}