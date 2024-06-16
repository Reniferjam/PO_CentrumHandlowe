import java.util.ArrayList;

/**
 * Specific type of client, he is randomly going into the shop in a shopping mall.
 */
public class Random extends Client implements IClient
{
    private int randomShopID;
    Random(Item item, int numberOfShops)
    {
        super(item);
        this.randomShopID = -1;
    }

    /**
     * Method for randomizing a shop, that the client buys an item from.
     *
     * @param shopList list of shops in a shopping mall
     */
    public void findShop(ArrayList<Shop> shopList)
    {
        randomShopID = (int)(Math.random()*( shopList.size() ));
    }

    public int getRandomShopID() {
        return randomShopID;
    }
}