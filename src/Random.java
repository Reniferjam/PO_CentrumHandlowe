import java.util.ArrayList;

public class Random extends Client implements IClient
{
    private boolean[] RandomShopList;
    private int randomShopID;
    private int visitedShops;
    Random(Item item, int numberOfShops)
    {
        super(item);
        this.RandomShopList = new boolean[numberOfShops];
        this.randomShopID = 0;
        this.visitedShops = 0;
    }
    public void findShop(ArrayList<Shop> shopList) // +1 modulo numberOfShops do dokonczenia
    {

        randomShopID = (int)(Math.random()*( shopList.size() ));
        this.visitedShops++; //1 - zamienic na liczbe sklepow
    }
    public int getRandomShopID()
    {
        return randomShopID;
    }
    public boolean[] getRandomShopList() {
        return RandomShopList;
    }
}