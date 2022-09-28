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

    public void handleGroupOffer(char []itemsAcceptedInGroup, int[] pricesOfTheItemsInGroup,
                                 int numberOfRequiredItems,int offerPrice){
        // function designed to handle the case when there's a group offer in place.
        // example: buy any 3 of (S,T,X,Y,Z) for 45
        //
        // 1st part: converting the char array to an int array
        int[] itemsIdAcceptedInGroup = new int[pricesOfTheItemsInGroup.length];
        for (int i=0;i<pricesOfTheItemsInGroup.length;i++)
            itemsIdAcceptedInGroup[i] =letterToCode(itemsAcceptedInGroup[i]);
        // 2nd part: sorting both the arrays(price and itemId) in descending order
        // after the price, so the customer would get the best offer in place
        // simple bubble sort
        int n=pricesOfTheItemsInGroup.length;
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                if (pricesOfTheItemsInGroup[j]<pricesOfTheItemsInGroup[j+1]){
                    // for the price
                    int t = pricesOfTheItemsInGroup[j+1];
                    pricesOfTheItemsInGroup[j+1] =pricesOfTheItemsInGroup[j];
                    pricesOfTheItemsInGroup[j]=t;
                    // for the ids
                    t = itemsIdAcceptedInGroup[j+1];
                    itemsIdAcceptedInGroup[j+1] =itemsIdAcceptedInGroup[j];
                    itemsIdAcceptedInGroup[j]=t;
                }
            }
        }
        // executing the loop below until(and if) the number of the items
        // from the group is lower than the number of items required to meet
        // offer's condition
        while(getTotalNumberOfItemsInGroup(itemsIdAcceptedInGroup)>=numberOfRequiredItems){
            int numberOfDiscountedItems=1;
            // iterating through ids of the items that are accepted in the group discount
            for (int i:itemsIdAcceptedInGroup) {
                // calculating the number of the current items available for the
                // group offer
                int numberOfTheItemToBeRemovedAvailable = itemsArray[itemsIdAcceptedInGroup[i]];
                // deleting one item from the itemsArray
                itemsArray[itemsIdAcceptedInGroup[i]]--;
                //marking one item as added
                numberOfDiscountedItems++;
                // if we still have available items to be discounted,
                // we decrement i, so the loop will be executed again for the same
                // product until there are no products left
                if (numberOfTheItemToBeRemovedAvailable-1!=0)
                    i--;
                // as soon as we have enought discounted items for this deal,
                // we add to the total price the offerPrice and we exit from the for loop.
                if (numberOfDiscountedItems==numberOfRequiredItems) {
                    total+=offerPrice;
                    break;
                }
            }
        }
    }

    private int getTotalNumberOfItemsInGroup(int[] itemsIdAcceptedInGroup) {
        int sum=0,i;
        for (i=0;i<itemsIdAcceptedInGroup.length;i++){
            sum += itemsArray[itemsIdAcceptedInGroup[i]];
        }
        return sum;
    }

    public void buyNoOffer(int itemId, int price){
        // simple function used to add to the total the number of some items that
        // have no deal/discount
        total+= price * itemsArray[itemId];
    }
    public static int letterToCode(char letter){
        return (int)letter - 65;
    }
}

