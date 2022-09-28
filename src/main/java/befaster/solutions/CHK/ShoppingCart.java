package befaster.solutions.CHK;

public class ShoppingCart {
    int[] itemsArray;
    int total=0;

    public ShoppingCart(String skus){
        itemsArray = new int[26];
        for (char sku:skus.toCharArray()) {
            int ascii = (int) sku;
            ascii = ascii-65;
            itemsArray[ascii]++;
        }
    }

    public int getTotal() {
        return total;
    }

    public void getOneFreeOffer(int sourceItem, int numberOfItemsForDiscount, int discountedItem){
        if (itemsArray[sourceItem]>=numberOfItemsForDiscount){
            int pairs_of_prod=itemsArray[sourceItem] /numberOfItemsForDiscount;
            itemsArray[discountedItem] =itemsArray[discountedItem] - pairs_of_prod;
            if(itemsArray[discountedItem]<0)itemsArray[discountedItem]=0;
        }
    }
    public void getXForLowerPriceOffer(int itemId, int offerPrice, int noItemsToGetDiscount){
        if (itemsArray[itemId]>=noItemsToGetDiscount) {
            total += (itemsArray[itemId]/noItemsToGetDiscount)*offerPrice;
            int removedProducts = itemsArray[itemId]/noItemsToGetDiscount;
            itemsArray[itemId] = itemsArray[offerPrice] - removedProducts*noItemsToGetDiscount;
        }
    }
}
