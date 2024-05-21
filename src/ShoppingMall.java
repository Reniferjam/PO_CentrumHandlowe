public class ShoppingMall
{
    private  int numberOfClients, numberOfRounds;
    private Shop[] ShopList;

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

}
