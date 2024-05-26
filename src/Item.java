import java.util.Locale;
import java.util.Scanner;

public class Item
{
    private String itemName;
    private int itemID, itemQuantity, itemQuality;
    private double itemPrice;

    private Item(String itemName, int itemID, int itemQuantity, int itemQuality, double itemPrice)
    {
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
        this.itemQuality = itemQuality;
        this.itemPrice = itemPrice;
    }

    private Item()
    {
        this.itemName = "ERROR";
        this.itemID = -1;
        this.itemQuantity = -1;
        this.itemQuality = -1;
        this.itemPrice = -1;
    }

    public String getItemName()
    {
        return itemName;
    }

    public int getItemID()
    {
        return itemID;
    }

    public int getItemQuality()
    {
        return itemQuality;
    }

    public double getItemPrice()
    {
        return itemPrice;
    }

    public int getItemQuantity()
    {
        return itemQuantity;
    }

    public int giveID(Item[] shopList)
    {
        return itemID; // do poprawki
    }

    public void setItemQuantity(int itemQuantity)
    {
        this.itemQuantity = itemQuantity;
    }

    public static Item createItem()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwę produktu: ");
        String name = scan.nextLine();
        name = name.toLowerCase();
        int ID =  0; // giveID();

        int quantity;
        do
        {
            System.out.println("Podaj ilość produktów [>0] : ");
            quantity = scan.nextInt();
            scan.nextLine();
            if (quantity <= 0)
            {
                System.out.println("Podano złą wartość");
            }

        } while (quantity <= 0);

        int quality;                    //dodac exception zeby nie wywalalo ulamkow
        do {
            System.out.println("Podaj jakość produktu [1;100] : ");
            quality = scan.nextInt();
            scan.nextLine();
            if (quality < 1 || quality > 100)
            {
                System.out.println("Podano złą wartość");
            }

        } while (quality < 1 || quality > 100);

        double price;
        do {
            System.out.println("Podaj cene produktu [>0] : ");
            price = scan.nextDouble();
            scan.nextLine();
            if (price <= 0)
            {
                System.out.println("Podano złą wartość");
            }

        } while (price <= 0);

        Item item1 = new Item(name,ID,quantity,quality,price);
        ID++;
        return item1;
    }

    public static void printItem(Item item)
    {
        System.out.println("Name:  " + item.itemName);
        System.out.println("ID:  " + item.itemID);
        System.out.println("Quantity:  " + item.itemQuantity);
        System.out.println("Quality:  " + item.itemQuality);
        System.out.println("Price:  " + item.itemPrice);

    }
    public static Item createExampleItemA1()
    {
        System.out.println("Item: createExampleItemA1");
        System.out.println();

        String name = "Buty";
        int ID = 1;
        int quantity = 5;
        int quality = 70;
        double price = 499.99;
        return new Item(name,ID,quantity,quality,price);
    }

    public static Item createExampleItemA2()
    {
        System.out.println("Item: createExampleItemA2");
        System.out.println();

        String name = "Spodnie";
        int ID = 2;
        int quantity = 10;
        int quality = 65;
        double price = 175.99;
        return new Item(name,ID,quantity,quality,price);
    }

    public static Item createExampleItemB1()
    {
        System.out.println("Item: createExampleItemB1");
        System.out.println();

        String name = "Buty";
        int ID = 1;
        int quantity = 3;
        int quality = 40;
        double price = 250.99;
        return new Item(name,ID,quantity,quality,price);
    }

    public static Item createExampleItemB2()
    {
        System.out.println("Item: createExampleItemB2");
        System.out.println();

        String name = "Spodnie";
        int ID = 2;
        int quantity = 5;
        int quality = 40;
        double price = 99.99;
        return new Item(name, ID, quantity, quality, price);
    }

    public static Item createExampleItemClient1()
    {
        System.out.println("Item: createExampleItemClient1");
        System.out.println();

        String name = "Spodnie";
        int ID = 2;
        int quantity = 3;
        int quality = 30;
        double price = 120;
        return new Item(name, ID, quantity, quality, price);
    }
    public static Item createExampleItemClient2()
    {
        System.out.println("Item: createExampleItemClient2");
        System.out.println();

        String name = "Buty";
        int ID = 1;
        int quantity = 2;
        int quality = 65;
        double price = 400;
        return new Item(name, ID, quantity, quality, price);
    }
}
