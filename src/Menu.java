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
            this.shoppingMall = new ShoppingMall(400,70,20,80,40,600,4);
    }
    public  void startSimulation()
    {
        createShops();
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

                    shoppingMall.collectData();
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
        list.add(new Item("Shoes",1,13,70,399.99));
        list.add(new Item("Trousers",2,37,65,175.99));
        list.add(new Item("Gloves",4,17,90,100));
        shoppingMall.shopList.add(new Shop(40,list,50)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow

        list = new ArrayList<Item>();
        list.add(new Item("Shoes",1,30,60,180.99));
        list.add( new Item("Trousers",2,20,50,160.99));
        list.add(new Item("Hat",3,25,30, 50));
        shoppingMall.shopList.add(new Shop(10,list,15)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow

        list = new ArrayList<Item>();
        list.add(new Item("Gloves",4,27,50,117.75));
        list.add(new Item("Hat",3,50,90,320.21));
        list.add(new Item("Shoes",1,15,40,250.99));
        shoppingMall.shopList.add(new Shop(20,list,1)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow

        list = new ArrayList<Item>();
        list.add(new Item("Gloves",4,27,20,57.39));
        list.add(new Item("Trousers",2,37,80,250.23));
        list.add(new Item("Hat",3,30,30,50));
        shoppingMall.shopList.add(new Shop(20,list,1)); //inicjalizacja sklepow + dodawanie przedmiotow do sklepow
    }
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.startSimulation();
    }
}