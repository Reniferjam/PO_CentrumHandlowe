import java.util.ArrayList;
import java.util.List;

public class ShoppingMall implements IShoppingMall
{
    private  int numberOfClients, numberOfRounds;

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
        for (int i = 0; i < numberOfShops; i++) {
            shopList[i].setShopCapacity(0);
        }
    }

    private Client generateClients()
    {
        Client client = new Client(Item.createItem());
        return client;
    }


    public void initShops()
    {
        System.out.println("Shopping Mall: initShops");
        System.out.println();

        for (int i = 0; i < numberOfShops; i++) {
            addShop(i);
        }
    }

    public void addShop(int n)
    {
        System.out.println("Shopping Mall: addShop");
        System.out.println();
        Shop shop = Shop.createShop();
        shopList[n] = shop;
    }

    public void nextRound()
    {
        System.out.println("Shopping Mall: nextRound");
        System.out.println();

        for (int i = 0; i < numberOfClients; i++)
        {

        }
        numberOfRounds++;
    }
    public void initExampleShops()
    {
        System.out.println("Shopping Mall: initExampleShops");
        System.out.println();

        addExampleShopA(0);
        addExampleShopB(1);
    }

    public void addExampleShopA(int n)
    {
        System.out.println("Shopping Mall: addExampleShopA");
        System.out.println();
        Shop shop = Shop.createExampleShopA();
        shopList[n] = shop;
    }

    public void addExampleShopB(int n)
    {
        System.out.println("Shopping Mall: addExampleShopB");
        System.out.println();
        Shop shop = Shop.createExampleShopB();
        shopList[n] = shop;
    }

    public void nextExampleRound()
    {
        Client client1 = Client.createExampleClient1();
        Client client2 = Client.createExampleClient2();
        for (int i = 0; i < shopList[0].getNumberOfProducts(); i++)
        {  // Client 1 i Shop A
            if (client1.checkProduct(shopList[0].getItem(i), shopList[0].getNumberOfProducts()))
            {
                System.out.println("Shop A");
                shopList[0].sellProduct(i,client1);
            }
        }

        for (int i = 0; i < shopList[1].getNumberOfProducts(); i++)
        { // Client 1 i Shop ^(1 + B2)^
            if (client1.checkProduct(shopList[1].getItem(i), shopList[1].getNumberOfProducts()))
            {
                System.out.println("Shop B");
                shopList[1].sellProduct(i,client1);
            }
        }

        for (int i = 0; i < shopList[0].getNumberOfProducts(); i++)
        { // Client 2 i Shop A
            if (client2.checkProduct(shopList[0].getItem(i), shopList[0].getNumberOfProducts()))
            {
                System.out.println("Shop A");
                shopList[0].sellProduct(i,client2);
            }
        }


        for (int i = 0; i < shopList[1].getNumberOfProducts(); i++)
        { // Client 2 i Shop B (should work)
            if (client2.checkProduct(shopList[1].getItem(i), shopList[1].getNumberOfProducts()))
            {
                System.out.println("Shop B");
                shopList[1].sellProduct(i,client2);
            }
        }

        System.out.println();
        System.out.println("Client1 Item");
        Item.printItem(client1.getItem());

        System.out.println();

        System.out.println("Client2 Item");
        Item.printItem(client2.getItem());

        System.out.println();
        System.out.println("ShopA");
        shopList[0].printShop();
        System.out.println();
        for (int i = 0; i < shopList[0].getNumberOfProducts(); i++) {
            System.out.println("ShopA Product: " +i);
            Item.printItem(shopList[0].getItem(i));
            System.out.println();
        }

        System.out.println("ShopB");
        shopList[1].printShop();
        System.out.println();
        for (int i = 0; i < shopList[1].getNumberOfProducts(); i++) {
            System.out.println("ShopB Product: " +i);
            Item.printItem(shopList[1].getItem(i));
            System.out.println();
        }
    }
}
