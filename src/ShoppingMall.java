import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Shopping mall is a collection of different shops.
 */
public class ShoppingMall {
    private  int maxClients, numberOfRounds;
    private int chanceOfRandomClient;
    private int minQuality, maxQuality;
    private double minPrice, maxPrice;
    public ArrayList<Shop> shopList;
    private int itemCount;

    public ShoppingMall(int maxClients, int chanceOfRandomClient, int minQuality, int maxQuality, double minPrice, double maxPrice, int itemCount)
    {
        this.chanceOfRandomClient = chanceOfRandomClient;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minQuality = minQuality;
        this.maxQuality = maxQuality;
        this.maxClients = maxClients;
        this.numberOfRounds = 0;
        this.shopList = new ArrayList<Shop>();
        this.itemCount = itemCount;
    }
    /**
     * Method is randomizing if it create a random or minmax client.
     * Then it simulates a round for that client.
     * It also increase a number of rounds simulated.
     */
    public void nextRound()
    {
        resetCapacity();
        for (int i = 0; i <maxClients; i++)
        {
            int x = (int)(Math.random() * (101));
            if (x < chanceOfRandomClient)
            {
                roundForRandom();
            } else
            {
                roundForMinMax();
            }

        }
        Shop.printShops(shopList,numberOfRounds);
        numberOfRounds++;
    }

    /**
     * It simulates a round for a client that is choosing a random shop to buy his product.
     */
    public void roundForRandom()
    {
        Random rand = new Random(randomizeVariables(), shopList.size());
        rand.findShop(shopList);
        int x = rand.getRandomShopID();
        for (int i = 0; i < shopList.get(x).getItemList().size(); i++)
        {
            if (rand.checkProduct(shopList.get(x).getItem(i)))
            {
                if(shopList.get(x).getCurrentCapacity() >= shopList.get(x).getShopCapacity())
                {
                    return;
                }
                else
                {
                    shopList.get(x).sellProduct(i,rand,x);
                    return;
                }
            }
        }
    }

    /**
     * It simulates a round for a client that is choosing the best shop to buy his product.
     */
    public void roundForMinMax()
    {
        MinMax minmax = new MinMax(randomizeVariables());
        minmax.findShop(shopList);
        int x = minmax.getBestShopID();
        if(x == -1)
        {
            return;
        }
        if(shopList.get(x).getCurrentCapacity() >= shopList.get(x).getShopCapacity())
        {
            return;
        }
        else
        {
            shopList.get(x).sellProduct(minmax.getItem().getItemID(),minmax,x);
        }
    }
    private void resetCapacity()
    {
        for (Shop shop : shopList) {
            shop.setCurrentCapacity(0);
        }
    }

    /**
     * Method is randomizing attributes of an item, which depends on variables set earlier.
     *
     * @return it returns new item with randomized variables
     */
    public Item randomizeVariables()
    {
        int quality = (int)(Math.random() * (maxQuality - minQuality + 1) + minQuality);
        double price = (double)(Math.random() * (maxPrice - minPrice + 1) + minPrice);
        int id = (int)((Math.random() * (itemCount))+1);
        return new Item(" ", id, 1, quality, price);
    }
    /**
     * Method for collecting data.
     * It stores it later in a .csv file.
     */
        public void collectData()
        {
            try
            {
                FileWriter fw = new FileWriter("Wyniki.csv");
                fw.write("Round" + (numberOfRounds+1) + ";income;profit;prof/cli;capacity");
                final DecimalFormat decfor = new DecimalFormat("0.00");
                for (int i = 0; i < shopList.size(); i++)
                {
                    fw.write("\nShop" +(i+1) + ";" + decfor.format(shopList.get(i).getShopIncome()) +";" + decfor.format(shopList.get(i).getShopProfit()) +";" + decfor.format(shopList.get(i).getProfitOnClient()) + ";" + shopList.get(i).getShopCapacity());
                    System.out.println();
                }
                System.out.println();
                fw.close();
            }
            catch (InputMismatchException e)
            {
                e.getStackTrace();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
}