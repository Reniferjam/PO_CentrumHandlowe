import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Menu
{
    private int NumberOfShops;
    private ShoppingMall shoppingMall;
    Menu()
    {
        this.NumberOfShops = 0;
        this.shoppingMall = new ShoppingMall(20,30,20,80,100,300);
    }
    public  void startSimulation()
    {
        createShops();
        //writeDataToCSV("data_simulation.csv", "1," + shoppingMall.collectData());
        shoppingMall.nextRound();
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            try {
                System.out.println("Do you want to continue? [press 1 to continue, press 2 to end simulation]");
                int x = scan.nextInt();
                if (x == 1)
                {
                    System.out.println();
                    shoppingMall.nextRound();
                }
                else if (x == 2)
                {
                    System.out.println("End of simulation");
                    return;
                }
                else
                {
                    System.out.println("Wrong input! Try again.");
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Wrong input! Try again.");
                scan.nextLine();
            }
        }
    }
    public void createShops()
    {
        Item[] listA = new Item[2];
        listA[0] = Item.createExampleItemA1();
        listA[1] = Item.createExampleItemA2();
        NumberOfShops++;
        shoppingMall.initShops(new Shop(40,listA,10,2)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow

        Item[] listB = new Item[2];
        listB[0] = Item.createExampleItemB1();
        listB[1] = Item.createExampleItemB2();
        NumberOfShops++;
        shoppingMall.initShops(new Shop(10,listB,30,2)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow

        Item[] listC = new Item[2];
        listC[0] = Item.createExampleItemA1();
        listC[1] = Item.createExampleItemA2();
        NumberOfShops++;
        shoppingMall.initShops(new Shop(20,listC,20,2));

    }
//    public void writeToCSV()
//    {
//        FileWriter csv = new FileWriter("simulation_data");
//
//    }
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.startSimulation();
    }
}