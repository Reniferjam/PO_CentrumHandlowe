import java.util.ArrayList;
import java.util.List;

public class ShoppingMall implements IShoppingMall
{
    private  int numberOfClients, numberOfRounds;

    private int chanceOfRandomClient = 30;
    private int minQuality = 20, maxQuality = 80;
    private double minPrice = 100, maxPrice = 300;

    public int numberOfShops;

    public Shop[] shopList;
    public ShoppingMall(int numberOfShops)
    {
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


    private int randNumberOfClients()
     {
        int n=1; // Do zmiany: Napisanie funkcji wylosowania liczby klientów
        return n;
    }

    private void resetCapacity()
    {
        for (int i = 0; i < numberOfShops; i++)
        {
            shopList[i].setShopCapacity(0);
        }
    }

//    private void randomORminmax(int chanceOfRandomClient)
//    {
//        int x = (int)(Math.random() * (101));
//
//        if (x < chanceOfRandomClient)
//        {
//            generateRandom(); //returnuje randoma
//        } else {
//            generateMinMax(); //returnuje minmaxa
//        }
//    }

    private MinMax generateMinMax()
    {
        return new MinMax(randomizeVariables(maxQuality, minQuality, maxPrice, minPrice));
    }

    private Random generateRandom()
    {
        return new Random(randomizeVariables(maxQuality, minQuality, maxPrice, minPrice));
    }

    public void initShops(Shop shop)
    {
        System.out.println("Shopping Mall: initShops");
        System.out.println();

        for (int i = 0; i < numberOfShops; i++) {
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

        for (int i = 0; i < numberOfClients; i++)
        {
            int x = (int)(Math.random() * (101));
            if (x < chanceOfRandomClient)
            {
                generateRandom(); //returnuje randoma
                Random rand = new Random(randomizeVariables(maxQuality, minQuality, maxPrice, minPrice));


//
//                for (int i = 0; i < shopList[0].getNumberOfProducts(); i++)
//                {  // Client 1 i Shop A
//                    if (rand.checkProduct(shopList[0].getItem(i)))
//                    {
//                        System.out.println("Shop A");
//                        shopList[0].sellProduct(i,rand);
//                    }
//                }



            } else {
                generateMinMax(); //returnuje minmaxa
                MinMax minmax = new MinMax(randomizeVariables(maxQuality, minQuality, maxPrice, minPrice));
            }


            //sprawdzamy czy checkproduct daje prawde jesli tak to buyproduct
        }
        numberOfRounds++;
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
