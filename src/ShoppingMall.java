import java.util.ArrayList;
import java.util.List;

public class ShoppingMall implements IShoppingMall
{
    private  int numberOfClients, numberOfRounds;

    List<Shop> shopList = new ArrayList<Shop>();

    private int randNumberOfClients()
    {
        int n=1; // Do zmiany: Napisanie funkcji wylosowania liczby klientów
        return n;
    }

    private void resetCapacity()
    {
     // Napisanie funkcji która ustawi currentCapacity każdego sklepu na 0
    }

   /* private Client generateClients()
    {
    }   */

    public int getNumberOfClients()
    {
        return numberOfClients;
    }

    public int getNumberOfRounds()
    {
        return numberOfRounds;
    }

    public void setNumberOfClients(int n)
    {
        numberOfClients=n;
    }

    public int getNumberOfShops(){
        return shopList.size();
    }

    public void nextRound(){

    }

    public static void main(String[] args)
    {

    }
}
