import java.util.Scanner;

public class Menu
{
    private int NumberOfShops;
    private Menu()
    {
        this.NumberOfShops = SetNumberOfShops();
    }
    public  void startSimulation()
    {
        System.out.println("Menu: startSimulation");
        System.out.println();

        ShoppingMall shoppingMall = new ShoppingMall(NumberOfShops);
        /////////////////////////
        shoppingMall.initShops();
        shoppingMall.nextRound();
        /////////////////////////
        System.out.println("Czy chcesz kontynuować symulacje? 1 to tak");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println("Czy chcesz kontynuować symulacje? 1 to tak");
            System.out.println();
            shoppingMall.nextRound();

        } while (scan.nextInt() == 1);

    }

    public void customizeClients()
    {

    }

    public void customizeShoppingMall()
    {

    }

    public int SetNumberOfShops()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Set number of shops: (2)");
        return  scan.nextInt();
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
         menu.ExampleSimulation();
     }

    public void ExampleSimulation()
    {
        System.out.println("Menu: ExampleSimulation");
        System.out.println();

        ShoppingMall shoppingMall = new ShoppingMall(NumberOfShops);
        /////////////////////////
        shoppingMall.initExampleShops();
        shoppingMall.nextRound();
        /////////////////////////

    }

}
