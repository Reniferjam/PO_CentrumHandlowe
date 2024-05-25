public class Random extends Client
{
    public int randomShopID;

    public int findRandomShop(int numberOfShops)
    {
        randomShopID = (int)(Math.random() * (numberOfShops));  //znalezc ilosc sklepow (max)
        return randomShopID;
    }

    public int getRandomShopID()
    {
        return randomShopID;
    }
}