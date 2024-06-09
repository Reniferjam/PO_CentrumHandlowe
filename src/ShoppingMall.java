import java.util.ArrayList;

public class ShoppingMall implements IShoppingMall
{
    private  int numberOfClients, numberOfRounds;
    private int chanceOfRandomClient;
    private int minQuality, maxQuality;
    private double minPrice, maxPrice;
    public ArrayList<Shop> shopList;
    public ShoppingMall(int numberOfClients, int chanceOfRandomClient, int minQuality, int maxQuality, int minPrice, int maxPrice)
    {
        this.chanceOfRandomClient = chanceOfRandomClient;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minQuality = minQuality;
        this.maxQuality = maxQuality;
        this.numberOfClients = numberOfClients;
        this.numberOfRounds = 0;
        this.shopList = new ArrayList<Shop>();
    }
    public void nextRound()
    {
        resetCapacity();
        for (int i = 0; i <(int)(Math.random()*(numberOfClients)); i++)
        {
            int x = (int)(Math.random() * (101)); // losuje liczbe od 0 do 100
            if (x < chanceOfRandomClient)
            {
                Random client = new Random(randomizeVariables(), shopList.size());
                roundForRandom();
            } else
            {

                MinMax client = new MinMax(randomizeVariables());
                roundForMinMax();
            }

        }
        Shop.printShops(shopList,numberOfRounds);
        numberOfRounds++;
    }
    public void roundForRandom()
    {
        Random rand = new Random(randomizeVariables(), shopList.size());
        for (int i = 0; i <  5 /*shopList.get(rand.getRandomShopID()).getNumberOfProducts()*/; i++)
        {
            if (rand.checkProduct(shopList.get(0).getItem(i)))
            {
                shopList.get(0).sellProduct(i,rand,1);
            }
        }
    }
    public void roundForMinMax()
    {
        MinMax minmax = new MinMax(randomizeVariables());
        minmax.findShop(shopList);
        if(minmax.getBestShopID() == -1)
        {
            return;
        }
        shopList.get(minmax.getBestShopID()).sellProduct(minmax.getItem().getItemID(),minmax,minmax.getBestShopID());
    }
    private void resetCapacity()
    {
        for (Shop shop : shopList) {
            shop.setCurrentCapacity(0);
        }
    }
    public Item randomizeVariables()
    {
        int quality = (int)(Math.random() * (maxQuality - minQuality + 1) + minQuality);
        double price = (double)(Math.random() * (maxPrice - minPrice + 1) + minPrice);
        int id = (int)(Math.random() * (2/*wpisac ilosc przedmiotow + 1*/));
        return new Item("xD", id, 1, quality, price);
    }
    //    public String collectData()
    //    {
    //        StringBuilder data = new StringBuilder();
    //        for (Shop shop : shops) {
    //            if (shop != null) {
    //                data.append(shop.getCustomers())
    //                        .append(",")
    //                        .append(shop.getSales())
    //                        .append("\n");
    //            }
    //        }
    //        return data.toString();
    //    }
}