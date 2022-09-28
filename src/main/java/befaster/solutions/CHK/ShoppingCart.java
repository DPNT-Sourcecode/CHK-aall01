package befaster.solutions.CHK;

public class ShoppingCart {
    private int[] itemsArray;
    private int total=0;

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
    public void getOneFreeOfferSameItem(int itemId, int numberOfItemsForDiscount,int price){
        if (itemsArray[itemId]>=numberOfItemsForDiscount){
            int pairs_of_prod=itemsArray[itemId] /numberOfItemsForDiscount;
            total += numberOfItemsForDiscount * price *pairs_of_prod;
            itemsArray[itemId] -= pairs_of_prod* numberOfItemsForDiscount;
            itemsArray[itemId] -= pairs_of_prod;
            if (itemsArray[itemId]<0) itemsArray[itemId]=0;
        }
    }
    public void getXForLowerPriceOffer(int itemId, int offerPrice, int noItemsToGetDiscount){
        if (itemsArray[itemId]>=noItemsToGetDiscount) {
            total += (itemsArray[itemId]/noItemsToGetDiscount)*offerPrice;
            int removedProducts = itemsArray[itemId]/noItemsToGetDiscount;
            itemsArray[itemId] = itemsArray[offerPrice] - removedProducts*noItemsToGetDiscount;
        }
    }
    public void buyNoOffer(int itemId, int price){
        total+= price * itemsArray[itemId];
    }
}

