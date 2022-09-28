package befaster.solutions.CHK;

public class ShoppingCart {
    private int[] itemsArray;
    private int total=0;

    public ShoppingCart(String skus){
        // constructor that is using the skus String in order to generate
        // an arrray containing the number of (each) kind of items
        // added to the shopping cart
        // example: for "AAA" - the array will be (3,0,..,0)
        itemsArray = new int[26];// empty array
        // iterating through the letters in the skus string
        for (char sku:skus.toCharArray()) {
            // extracting the ascii code
            int ascii = (int) sku;
            // subtracting 65 so A will become 0 instead of 65
            ascii = ascii-65;
            // incrementing the location in the array
            itemsArray[ascii]++;
        }
    }

    public int getTotal() {
        //returns the total price of the shopping cart
        // nothing fancy
        return total;
    }

    public void getOneFreeOffer(int sourceItem, int numberOfItemsForDiscount, int discountedItem){
        // function used in the scenario where you get one discountedItem free item when you buy
        // discountedItem*numberOfItemsForDiscount.

        // checking if there are enought items to apply the discount
        if (itemsArray[sourceItem]>=numberOfItemsForDiscount){
            // calculating the number of "pairs" (i.e. how many times the discount is applied).
            int pairs_of_prod=itemsArray[sourceItem] /numberOfItemsForDiscount;
            // removing the discountedItem(s) so those will not be paid.
            itemsArray[discountedItem] =itemsArray[discountedItem] - pairs_of_prod;
            // ensuring that the number of discountedItem(
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


