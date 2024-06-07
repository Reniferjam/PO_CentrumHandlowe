public class Random extends Client
{
    public boolean[] RandomShopList;
    private int randomShopID;

    private int visitedShops;

    public Random(Item item,int numberOfShops)
    {
        super(item);
        this.RandomShopList = new boolean[numberOfShops];
        this.randomShopID = randomShop(numberOfShops);
        this.visitedShops = 0;
    }

    public int randomShop(int numberOfShops) // +1 modulo numberOfShops do dokonczenia
    {

        randomShopID = (int)(Math.random()*( numberOfShops ));
        this.visitedShops++;
        return randomShopID; //1 - zamienic na liczbe sklepow
    }

    public int getRandomShopID()
    {
        return randomShopID;
    }
}