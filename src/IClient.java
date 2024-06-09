import java.util.ArrayList;

public interface IClient
{
    public boolean checkProduct(Item ShopItem);

    public void findShop(ArrayList<Shop> shopList);
    public void buyProduct(Shop shop);
}
