public class Shop implements IShop
{
    private int shopCapacity;
    private double shopIncome;
    private double shopTax;
    private double shopProfit;
    private Item[] itemList;
    private int currentCapacity;

    public double sellProduct()
    {
        return 0;
    }

    private boolean checkCapacity(int current, int max)
    {
        return true;
    }

    public int getShopCapacity()
    {
        return shopCapacity;
    }

    public void setShopCapacity(int n)
    {

    }

    public double getShopIncome()
    {
        return shopIncome;
    }

    public void setShopTax(double n)
    {

    }

    public double getShopTax()
    {
        return shopTax;
    }

    public double getShopProfit()
    {
        return shopProfit;
    }

    public int getCurrentCapacity()
    {
        return currentCapacity;
    }
}
