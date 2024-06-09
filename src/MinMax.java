import java.util.ArrayList;

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
    public void findShop(ArrayList<Shop> shopList)
    {
        for (int j = 0; j < shopList.size(); j++) // pętla dla każdego sklepu
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
                // nadpisanie przedmiotu jeśli znajdzie się lepszy
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
    public int getBestItemID()
    {
        return bestItemID;
    }
}