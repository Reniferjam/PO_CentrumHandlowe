public class Client implements IClient
{
    private  Item[] shopList;
    private  int currentShopID, currentProductID;

    public boolean checkProduct()
    {
        return true;
    }

    public void buyProduct()
    {

    }

    public int getCurrentProductID()
    {
        return currentProductID;
    }

    public int getCurrentShopID()
    {
        return currentShopID;
    }
}
