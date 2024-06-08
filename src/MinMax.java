public class MinMax extends Client
{
    private int bestShopID;
    private double bestShopPrice;
    private double bestShopQuality;

    private int bestItemID;
    MinMax(Item item)
    {
        super(item);
        this.bestShopID = -1;
        this.bestShopQuality = 0;
        this.bestShopPrice = 0;
        this.bestItemID = -1;
    }

    public void findBestShop(Shop[] shop)
    {
        for (int j = 0; j < 3; j++) // pętla dla każdego sklepu
        {
            for (int i = 0; i < shop[j].getItemList().size(); i++) // pętla dla każdego przedmiotu
            {
                if(getItem().getItemID() != shop[j].getItemList().get(i).getItemID())
                {
                    continue;
                }

                if( getItem().getItemQuantity() >= shop[j].getItemList().get(i).getItemQuantity() )
                {
                    continue;
                }

                if( getItem().getItemPrice() > shop[j].getItemList().get(i).getItemPrice() )
                {
                    continue;
                }

                if(getItem().getItemQuality() > shop[j].getItemList().get(i).getItemQuality())
                {
                    continue;
                }

                double tempPrice = shop[j].getItemList().get(i).getItemPrice();
                double tempQuality = shop[j].getItemList().get(i).getItemQuality();

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

    public int getBestShopID()
    {
        return bestShopID;
    }

    public int getBestItemID()
    {
        return bestItemID;
    }
}