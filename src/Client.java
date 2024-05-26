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
        while (item.getItemQuantity() > 0){
            item.setItemQuantity(item.getItemQuantity()-1);
            System.out.println("Bought one item. Remaining quantity: " + item.getItemQuantity());
        }
    }

    public boolean checkProduct()
    {

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
