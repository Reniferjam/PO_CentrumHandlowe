public class Client implements IClient
{
    private int currentShopID, currentProductID;
    private Item item;

    public Client(){
        this.currentProductID = 0;
        this.currentShopID = 0;
        this.item = Item.createItem();
    }

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

    public Item getItem() {
        return item;
    }

    public static void main(String[] args)
    {
        Client klient = new Client();

    }
}
