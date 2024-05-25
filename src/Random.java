public class Random extends Client
{
    public int randomShopID;

    private int findRandomShop()
    {
        //randomShopID = (int)(Math.random() * (max-1+1)) + 1;  znalezc ilosc sklepow (max)
        return randomShopID;
    }

    public int getRandomShopID()
    {
        return randomShopID;
    }
}