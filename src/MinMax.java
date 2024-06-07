public class MinMax extends Client
{
    private int bestShopID;
    private double bestShopPrice;
    private double bestShopQuality;

    private int bestItemID;
    public MinMax(Item item)
    {
        super(item);
        this.bestShopID = -1;
        this.bestShopQuality = 0;
        this.bestShopPrice = 0;
        this.bestItemID = -1;
    }

    private void findBestShop(Shop[] shop)
    {
        for (int j = 0; j < 3; j++) // pętla dla każdego sklepu
        {
            for (int i = 0; i < shop[j].itemList.length; i++) // pętla dla każdego przedmiotu
            {
                if(item.getItemID() != shop[j].itemList[i].getItemID())
                {
                    continue;
                }

                if( item.getItemQuantity() >= shop[j].itemList[i].getItemQuantity() )
                {
                    continue;
                }

                if( item.getItemPrice() > shop[j].itemList[i].getItemPrice() )
                {
                    continue;
                }

                if(item.getItemQuality() > shop[j].itemList[i].getItemQuality())
                {
                    continue;
                }

                double tempPrice = shop[j].itemList[i].getItemPrice();
                double tempQuality = shop[j].itemList[i].getItemQuality();

                if (tempQuality > bestShopQuality)
                {
                    bestShopQuality = tempQuality;
                    bestShopPrice = tempPrice;
                    bestShopID = j;
                    bestItemID = i;
                }

                if (tempQuality == bestShopQuality && tempPrice < bestShopQuality)
                {
                    bestShopQuality = tempQuality;
                    bestShopPrice = tempPrice;
                    bestShopID = j;
                    bestItemID = i;
                }
            }
        }
    }

    public void setBestShopID(Shop[] shop)
    {
         findBestShop(shop);
    }

    public int getBestShopID()
    {
        return bestShopID;
    }

    public int getBestItemID()
    {
        return bestItemID;
    }
}