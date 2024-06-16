import java.util.ArrayList;

/**
 * Client is checking if a product that he wants to buy meets all his requirements.
 */
public class Client implements IClient
{
    private Item item;
    Client(Item item)
    {
        this.item = item;
    }

    /**
     * This method is checking a few conditions for a client to buy a certain product.
     * It checks an ID, price, quality and quantity of an item.
     * If it returns true, that means the item can be bought
     *
     * @param ShopItem
     * @return true if item can be bought, and false if item cannot be bought
     */
    public boolean checkProduct(Item ShopItem)
    {
        //checking if conditions to buy a product are true
        if (ShopItem.getItemQuantity() < 0)
        {
            return false;
        }

        if(ShopItem.getItemID() != item.getItemID())
        {
            return false;
        }

        if (item.getItemPrice() < ShopItem.getItemPrice())
        {
            return false;
        }

        if (item.getItemQuality() > ShopItem.getItemQuality())
        {
            return false;
        }

        return true;
    }
    public Item getItem ()
    {
        return item;
    }
    public void findShop(ArrayList<Shop> shopList)
    {
    }
}
