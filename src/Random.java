import java.util.ArrayList;

public class Random extends Client implements IClient
{
    private int randomShopID;
    Random(Item item, int numberOfShops)
    {
        super(item);
        this.randomShopID = -1;
    }
    public void findShop(ArrayList<Shop> shopList)
    {
        randomShopID = (int)(Math.random()*( shopList.size() ));
    }

    public int getRandomShopID() {
        return randomShopID;
    }
}