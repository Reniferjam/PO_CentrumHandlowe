import java.util.ArrayList;

/**
 * Specific type of client, he is looking for the best product in a shopping mall.
 */
public class MinMax extends Client implements IClient
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

    /**
     * Method for checking the various conditions for client to buy product.
     * It finds a shop that  has the best item the client can buy.
     *
     * @param shopList list of shops client can buy items from
     */
    public void findShop(ArrayList<Shop> shopList)
    {
        for (int j = 0; j < shopList.size(); j++) //Loop for every shop
        {
            for (int i = 0; i < shopList.get(j).getItemList().size(); i++) // pętla dla każdego przedmiotu
            {
                // sprawdzenie warunków kupienia przedmiotu
                if(getItem().getItemID() != shopList.get(j).getItemList().get(i).getItemID())
                {
                    continue;
                }

                if( getItem().getItemQuantity() >= shopList.get(j).getItemList().get(i).getItemQuantity() )
                {
                    continue;
                }

                if( getItem().getItemPrice() > shopList.get(j).getItemList().get(i).getItemPrice() )
                {
                    continue;
                }

                if(getItem().getItemQuality() > shopList.get(j).getItemList().get(i).getItemQuality())
                {
                    continue;
                }

                double tempPrice = shopList.get(j).getItemList().get(i).getItemPrice();
                double tempQuality = shopList.get(j).getItemList().get(i).getItemQuality();
                //if a better item is found, it will be overwritten
                if (tempQuality > bestShopQuality)
                {
                    bestShopQuality = tempQuality;
                    bestShopPrice = tempPrice;
                    bestShopID = j;
                    bestItemID = i;
                }

                if (tempQuality == bestShopQuality && tempPrice < bestShopPrice)
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
}