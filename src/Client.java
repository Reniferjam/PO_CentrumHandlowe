import java.util.ArrayList;

public class Client implements IClient
{
    private Item item;
    Client(Item item)
    {
        this.item = item;
    }
    public void buyProduct()
    {
        System.out.println("Client: buyProduct");
        System.out.println();

        while (item.getItemQuantity() > 0)
        {
            item.setItemQuantity(item.getItemQuantity()-1);
            System.out.println("Bought one item. Remaining quantity: " + item.getItemQuantity());
        }
    }
    public boolean checkProduct(Item ShopItem)
    {
        // sprawdzenie warunków zakupu przedmiotu
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

    public void buyProduct(Shop shop)
    {

    }

    public void findShop(ArrayList<Shop> shopList)
    {
    }
}
