public class Random extends Client
{
    public int randomShopID;


    Random()
    {
        super();
        this.randomShopID = 0;
    }
    public int findRandomShop(int numberOfShops)
    {
        randomShopID = (int)(Math.random() * (numberOfShops));  //znalezc ilosc sklepow (max)
        return randomShopID;
    }

    public int getRandomShopID()
    {
        return randomShopID;
    }

    public static void main(String[] args)
    {

    }
}