import java.util.ArrayList;
import java.util.List;

public class ShoppingMall implements IShoppingMall
{
    private  int numberOfClients, numberOfRounds;
    private int chanceOfRandomClient;
    private int minQuality, maxQuality;
    private double minPrice, maxPrice;
    private int numberOfShops;
    public Shop[] shopList;
    public ShoppingMall(int numberOfClients, int chanceOfRandomClient, int minQuality, int maxQuality, int minPrice, int maxPrice)
    {
        this.chanceOfRandomClient = chanceOfRandomClient;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minQuality = minQuality;
        this.maxQuality = maxQuality;
        this.numberOfClients = numberOfClients;
        this.numberOfRounds = 0;
        this.numberOfShops = 0;
        this.shopList = new Shop[1];
    }
    public int getNumberOfClients()
    {
        return numberOfClients;
    }
    public int getNumberOfRounds()
    {
        return numberOfRounds;
    }
    public void setNumberOfClients(int n)
    {
        numberOfClients=n;
    }
    public int getNumberOfShops()
    {
        return numberOfShops;
    }
    private void resetCapacity()
    {
        for (int i = 0; i < shopList.length; i++)
        {
            shopList[i].setCurrentCapacity(0);
        }
    }
    public void initShops(Shop shop)
    {
        if (numberOfShops >= shopList.length)
        {
            increaseShopArraySize();
        }
        shopList[numberOfShops++] = shop;
    }
    private void increaseShopArraySize()
    {
            Shop[] newShops = new Shop[shopList.length+1];
            System.arraycopy(shopList, 0, newShops, 0, shopList.length);
            shopList = newShops;
    }
    public void nextRound()
    {
        resetCapacity();
        for (int i = 0; i <(int)(Math.random()*(numberOfClients)); i++)
        {
            int x = (int)(Math.random() * (101)); // losuje liczbe od 0 do 100
            if (x < chanceOfRandomClient)
            {
                roundForRandom();
            } else
            {
                roundForMinMax();
            }
        }
        System.out.println(shopList.length);
        Shop.printShops(shopList,numberOfRounds);
        numberOfRounds++;
    }
    public void roundForMinMax()
    {
        MinMax minmax = new MinMax(randomizeVariables());
        minmax.findBestShop(shopList);
        if(minmax.getBestShopID() == -1)
        {
            return;
        }
        shopList[minmax.getBestShopID()].sellProduct(minmax.getItem().getItemID(),minmax,minmax.getBestShopID());
    }
    public void roundForRandom()
    {
        Random rand = new Random(randomizeVariables(), numberOfShops);
        for (int i = 0; i < shopList[rand.getRandomShopID()].getNumberOfProducts(); i++)
        {
            if (rand.checkProduct(shopList[0].getItem(i)))
            {
                shopList[0].sellProduct(i,rand,1);
            }
        }
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
    public Item randomizeVariables()
    {
        int quality = (int)(Math.random() * (maxQuality - minQuality + 1) + minQuality);
        double price = (double)(Math.random() * (maxPrice - minPrice + 1) + minPrice);
        int id = (int)(Math.random() * (2/*wpisac ilosc przedmiotow + 1*/));
        return new Item("xD", id, 1, quality, price);
    }
}