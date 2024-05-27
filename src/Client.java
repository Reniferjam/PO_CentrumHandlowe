public class Client implements IClient
{
    private int currentShopID, currentProductID;
    public Item item;

    public Client(Item item)
    {
        this.currentProductID = 0;
        this.currentShopID = 0;
        this.item = item;
    }


    public void buyProduct ()
    {
        System.out.println("Client: buyProduct");
        System.out.println();

        while (item.getItemQuantity() > 0)
        {
            item.setItemQuantity(item.getItemQuantity()-1);
            System.out.println("Bought one item. Remaining quantity: " + item.getItemQuantity());
        }
    }

    public boolean checkProduct(Item ShopItem, int numberOfProducts)
    {
        System.out.println("Client: checkProduct");
        System.out.println();

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

        public int getCurrentProductID ()
        {
            return currentProductID;
        }

        public int getCurrentShopID ()
        {
            return currentShopID;
        }

        public Item getItem () {
            return item;
        }

        public void setCurrentShopID ( int currentShopID){
            this.currentShopID = currentShopID;
        }


//    public int findRandomShop(int n)
//    {
//        //currentShopID = (int) (Math.random() * (shoppingMall.));
//    }

    public int decreaseQuantity(Item[] ItemList){
        return 0;
    }

    public static Client createExampleClient1()
    {
        Item item = Item.createExampleItemClient1();
        return new Client(item);
    }

    public static Client createExampleClient2()
    {
        Item item = Item.createExampleItemClient2();
        return new Client(item);
    }

}
