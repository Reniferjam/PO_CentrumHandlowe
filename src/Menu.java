import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Menu
{
    private ShoppingMall shoppingMall;
    Menu()
    {
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
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item("Shoes",1,5,70,499.99));
        list.add(new Item("Trousers",2,10,65,175.99));
        shoppingMall.shopList.add(new Shop(40,list,10)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow

        list = new ArrayList<Item>();
        list.add(new Item("Shoes",1,3,40,250.99));
        list.add( new Item("Trousers",2,7,50,160.99));
        shoppingMall.shopList.add(new Shop(10,list,30)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow

        list = new ArrayList<Item>();
        list.add(new Item("Gloves",4,20,50,120));
        list.add(new Item("Hat",3,8,90,120));
        shoppingMall.shopList.add(new Shop(20,list,20)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow
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