public class Random extends Client
{
    public boolean[] RandomShopList;


    public Random(Item item)
    {
        super(item);
    }

    //funkcja losujaca numer sklepu

    public int randomShop()
    {
        return (int)(Math.random()*1); //1 - zamienic na liczbe sklepow
    }
}