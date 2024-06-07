import java.util.ArrayList;
import java.util.List;

public class ShoppingMall implements IShoppingMall
{
    private  int numberOfClients, numberOfRounds;

    private int chanceOfRandomClient;
    private int minQuality, maxQuality;
    private double minPrice, maxPrice;

    public static int numberOfShops;

    public Shop[] shopList;
    public ShoppingMall(int numberOfShops, int chanceOfRandomClient, int minQuality, int maxQuality, int minPrice, int maxPrice)
    {
        this.chanceOfRandomClient = chanceOfRandomClient;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minQuality = minQuality;
        this.maxQuality = maxQuality;
        this.numberOfClients = 0;
        this.numberOfRounds = 0;
        this.numberOfShops = numberOfShops;
        this.shopList = new Shop[numberOfShops];
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
        System.out.println("Shopping Mall: initShops");
        System.out.println();

        for (int i = 0; i < getNumberOfShops(); i++) {
            addShop(shop, i);
        }
    }

    public void addShop(Shop shop, int currentShop)
    {
        System.out.println("Shopping Mall: addShop");
        System.out.println();
        //shopList[currentShop] = new Shop(shop);    //jakosc dodac sklep do shoplisty
    }

    public void nextRound()
    {
        System.out.println("Shopping Mall: nextRound");
        System.out.println();

        for (int i = 0; i < getNumberOfClients(); i++)
        {
            int x = (int)(Math.random() * (101)); // losuje liczbe od 0 do 100
            if (x < chanceOfRandomClient)
            {
                roundForRandom();
            } else
            {
                roundForMinMax();
            }


            //sprawdzamy czy checkproduct daje prawde jesli tak to buyproduct
        }
        numberOfRounds++;
    }

    public void roundForRandom()
    {
        Random rand = new Random(randomizeVariables(maxQuality, minQuality, maxPrice, minPrice),numberOfShops);

        //znalezione id sklepu

        for (int i = 0; i < shopList[rand.getRandomShopID()].getNumberOfProducts(); i++)
        {
            if (rand.checkProduct(shopList[0].getItem(i)))
            {
                shopList[0].sellProduct(i,rand);
            }
        }
    }

    public void roundForMinMax()
    {
        MinMax minmax = new MinMax(randomizeVariables(maxQuality, minQuality, maxPrice, minPrice));
        minmax.setBestShopID(shopList);
        if(minmax.getBestShopID() == -1)
        {
            System.out.println("There is no shop that have MinMax Client item!");
            return;
        }
        shopList[minmax.getBestShopID()].sellProduct(minmax.getBestItemID(),minmax); // Czy dodajemy wiele produktów do jednego klienta;
    }


    public Item randomizeVariables(int maxQuality, int minQuality, double minPrice, double maxPrice)
    {
        int quality = (int)(Math.random() * (maxQuality - minQuality + 1) + minQuality);

        double price = (double)(Math.random() * (maxPrice - minPrice + 1) + minPrice);

        int id = (int)(Math.random() * (0/*wpisac ilosc przedmiotow + 1*/));

        return new Item("xD", id, 1, quality, price);
    }

//    public void nextExampleRound()
//    {
//        Client client1 = Client.createExampleClient1();
//        Client client2 = Client.createExampleClient2();
//        for (int i = 0; i < shopList[0].getNumberOfProducts(); i++)
//        {  // Client 1 i Shop A
//            if (client1.checkProduct(shopList[0].getItem(i), shopList[0].getNumberOfProducts()))
//            {
//                System.out.println("Shop A");
//                shopList[0].sellProduct(i,client1);
//            }
//        }
//
//        for (int i = 0; i < shopList[1].getNumberOfProducts(); i++)
//        { // Client 1 i Shop ^(1 + B2)^
//            if (client1.checkProduct(shopList[1].getItem(i), shopList[1].getNumberOfProducts()))
//            {
//                System.out.println("Shop B");
//                shopList[1].sellProduct(i,client1);
//            }
//        }
//
//        for (int i = 0; i < shopList[0].getNumberOfProducts(); i++)
//        { // Client 2 i Shop A
//            if (client2.checkProduct(shopList[0].getItem(i), shopList[0].getNumberOfProducts()))
//            {
//                System.out.println("Shop A");
//                shopList[0].sellProduct(i,client2);
//            }
//        }
//
//
//        for (int i = 0; i < shopList[1].getNumberOfProducts(); i++)
//        { // Client 2 i Shop B (should work)
//            if (client2.checkProduct(shopList[1].getItem(i), shopList[1].getNumberOfProducts()))
//            {
//                System.out.println("Shop B");
//                shopList[1].sellProduct(i,client2);
//            }
//        }
//
//        System.out.println();
//        System.out.println("Client1 Item");
//        Item.printItem(client1.getItem());
//
//        System.out.println();
//
//        System.out.println("Client2 Item");
//        Item.printItem(client2.getItem());
//
//        System.out.println();
//        System.out.println("ShopA");
//        shopList[0].printShop();
//        System.out.println();
//        for (int i = 0; i < shopList[0].getNumberOfProducts(); i++) {
//            System.out.println("ShopA Product: " +i);
//            Item.printItem(shopList[0].getItem(i));
//            System.out.println();
//        }
//
//        System.out.println("ShopB");
//        shopList[1].printShop();
//        System.out.println();
//        for (int i = 0; i < shopList[1].getNumberOfProducts(); i++) {
//            System.out.println("ShopB Product: " +i);
//            Item.printItem(shopList[1].getItem(i));
//            System.out.println();
//        }
//    }
}
