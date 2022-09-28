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
            // ensuring that the number of discountedItem(s) won't become negative
            // in the scenario where the number of initial discounted items is lower than the number of how
            // many times the discount is applied).
            if(itemsArray[discountedItem]<0)itemsArray[discountedItem]=0;
        }
    }
    public void getOneFreeOfferSameItem(int itemId, int numberOfItemsForDiscount,int price){
        // the purpose is similar to the function above but this is used when the same item is given free,
        // for example, get 3H get 1H free. The logic is a bit different
        while (itemsArray[itemId]>=numberOfItemsForDiscount){
            // handling one pair at a time, otherwise 2 pairs might be handled at the same time and no discount
            // item provided
            total += numberOfItemsForDiscount * price;
            // substracting the number of items whose price was already calculated above
            itemsArray[itemId] -= numberOfItemsForDiscount;
            // substracting the discounted item
            itemsArray[itemId] --;
            // ensuring that the final number of items is not negative
            if (itemsArray[itemId]<0) itemsArray[itemId]=0;
        }
    }
    public void getXForLowerPriceOffer(int itemId, int offerPrice, int noItemsToGetDiscount){
        // function to handle the case when the scenario where you can buy multiple products
        // for a lower price, example: 2V for 90
        //
        // checking if the deal is applicable
        if (itemsArray[itemId]>=noItemsToGetDiscount) {
            // calculating the number of pairs the customer intends to buy
            int pairsOfProducts= itemsArray[itemId]/noItemsToGetDiscount;
            // adding the price to the total price of the shopping cart
            total += pairsOfProducts*offerPrice;
            // removing the number of items that were already calculated
            itemsArray[itemId] = itemsArray[itemId] - pairsOfProducts*noItemsToGetDiscount;
        }
    }
    public void buyNoOffer(int itemId, int price){
        // simple function used to add to the total the number of some items that
        // have no deal/discount
        total+= price * itemsArray[itemId];
    }
}
