import java.util.ArrayList;
import java.util.List;

public class ShoppingMall implements IShoppingMall
{
    private  int numberOfClients, numberOfRounds;

    private int chanceOfRandomClient;
    private int minQuality, maxQuality;
    private double minPrice, maxPrice;

    private static int numberOfShopsStatic;
    private int numberOfShops;


    public Shop[] shopList;
    public ShoppingMall( int chanceOfRandomClient, int minQuality, int maxQuality, int minPrice, int maxPrice)
    {
        this.chanceOfRandomClient = chanceOfRandomClient;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minQuality = minQuality;
        this.maxQuality = maxQuality;
        this.numberOfClients = 0;
        this.numberOfRounds = 0;
        this.numberOfShops = 0;
        this.numberOfShopsStatic = numberOfShops;
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

    public int getNumberOfShops(){
        return numberOfShops;
    }

    private void resetCapacity()
    {
        for (int i = 0; i < numberOfShops; i++)
        {
            shopList[i].setShopCapacity(0);
        }
    }

    public void initShops(Shop shop)
    {
//        System.out.println("Shopping Mall: initShops");
//        System.out.println();

        while (numberOfShops >= shopList.length)
        {
            increaseShopArraySize();
        }
        shopList[numberOfShops++] = shop;
    }

    private void increaseShopArraySize()
    {
            Shop[] newShops = new Shop[shopList.length*2];
            System.arraycopy(shopList, 0, newShops, 0, shopList.length);
            shopList = newShops;
    }

    public void nextRound()
    {

        for (int i = 0; i <(int)(Math.random()*(20)); i++)
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

        //System.out.println("ShopList length: " + shopList.length);
//        for (int i = 0; i < shopList.length-1; i++)
//        {
//            System.out.println("Shop " + i);
//            shopList[i].printShop();
//        }
        System.out.println();
        printShops(shopList,numberOfRounds);
        numberOfRounds++;
    }

    public static void printShops(Shop[] shopList, int numberOfRounds)
    {
        System.out.printf("Tura  %2d |  income  |  profit  | prof/cli | currentCap | capacity |" ,numberOfRounds+1);
        System.out.println("\n-------------------------------------------------------------------");
        for (int i = 0; i < shopList.length-1; i++)
        {
            System.out.printf("Sklep %2d | %8.2f | %8.2f | %8.2f | %10d | %8d |", i+1, shopList[i].getShopIncome(), shopList[i].getShopProfit(), shopList[i].getShopProfit(), shopList[i].getCurrentCapacity(), shopList[i].getShopCapacity());
            System.out.println();
        }
        System.out.println();
//        System.out.printf("%8d %8d %8d %8d %d");
    }

    public void roundForRandom()
    {
        Random rand = new Random(randomizeVariables(), numberOfShops);

        //znalezione id sklepu

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

    public void roundForMinMax()
    {
        MinMax minmax = new MinMax(randomizeVariables());
        //Item.printItem(minmax.getItem());
        minmax.setBestShopID(shopList);
        if(minmax.getBestShopID() == -1)
        {
//            System.out.println();
//            System.out.println("There is no shop that have MinMax Client item!");
//            System.out.println();
            return;
        }
        shopList[minmax.getBestShopID()].sellProduct(minmax.getItem().getItemID(),minmax,minmax.getBestShopID()); // Czy dodajemy wiele produktów do jednego klienta;
        System.out.println();
    }

    public Item randomizeVariables()
    {
        int quality = (int)(Math.random() * (maxQuality - minQuality + 1) + minQuality);

        double price = (double)(Math.random() * (maxPrice - minPrice + 1) + minPrice);

        int id = (int)(Math.random() * (2/*wpisac ilosc przedmiotow + 1*/));

        return new Item("xD", id, 1, quality, price);
    }

}
