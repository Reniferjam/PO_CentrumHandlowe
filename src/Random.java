public class Random extends Client
{
    public boolean[] RandomShopList;
    private int randomShopID;

    public Random(Item item)
    {
        super(item);
    }

    public void randomShop()
    {
        randomShopID = (int)(Math.random()*1); //1 - zamienic na liczbe sklepow
    }

    public int getRandomShopID()
    {
        return randomShopID;
    }
}