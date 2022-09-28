package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        if(checkString(skus)!=true)
            return -1;
        ShoppingCart shoppingCart = new ShoppingCart(skus);

        // first we should handle the get One Free Offer
        // as those interact with other items as well
        shoppingCart.getOneFreeOffer(letterToCode('E'),2,letterToCode('B'));
        shoppingCart.getOneFreeOffer(letterToCode('N'),3,letterToCode('M'));
        shoppingCart.getOneFreeOffer(letterToCode('R'),3,letterToCode('Q'));

        // for F and U we need a special method which should handle the price as well
        // because the same item is affected
        shoppingCart.getOneFreeOfferSameItem(letterToCode('F'),2,10);
        shoppingCart.getOneFreeOfferSameItem(letterToCode('U'),3,40);

        // now handling the get X for lower price offers
        shoppingCart.getXForLowerPriceOffer(letterToCode('A'),200,5);
        shoppingCart.getXForLowerPriceOffer(letterToCode('A'),130,3);
        shoppingCart.getXForLowerPriceOffer(letterToCode('B'),45,2);
        shoppingCart.getXForLowerPriceOffer(letterToCode('H'),80,10);
        shoppingCart.getXForLowerPriceOffer(letterToCode('H'),45,5);
        shoppingCart.getXForLowerPriceOffer(letterToCode('K'),150,2);
        shoppingCart.getXForLowerPriceOffer(letterToCode('P'),200,5);
        shoppingCart.getXForLowerPriceOffer(letterToCode('Q'),80,3);
        shoppingCart.getXForLowerPriceOffer(letterToCode('V'),130,3);
        shoppingCart.getXForLowerPriceOffer(letterToCode('V'),90,2);

        // processing the rest of the shopping cart
        shoppingCart.buyNoOffer(letterToCode('A'),50);
        shoppingCart.buyNoOffer(letterToCode('B'),30);
        shoppingCart.buyNoOffer(letterToCode('C'),20);
        shoppingCart.buyNoOffer(letterToCode('D'),15);
        shoppingCart.buyNoOffer(letterToCode('E'),40);
        shoppingCart.buyNoOffer(letterToCode('F'),10);
        shoppingCart.buyNoOffer(letterToCode('G'),20);
        shoppingCart.buyNoOffer(letterToCode('H'),10);
        shoppingCart.buyNoOffer(letterToCode('I'),35);
        shoppingCart.buyNoOffer(letterToCode('J'),60);
        shoppingCart.buyNoOffer(letterToCode('K'),80);
        shoppingCart.buyNoOffer(letterToCode('L'),90);
        shoppingCart.buyNoOffer(letterToCode('M'),15);
        shoppingCart.buyNoOffer(letterToCode('N'),40);
        shoppingCart.buyNoOffer(letterToCode('O'),10);
        shoppingCart.buyNoOffer(letterToCode('P'),50);
        shoppingCart.buyNoOffer(letterToCode('Q'),30);
        shoppingCart.buyNoOffer(letterToCode('R'),50);
        shoppingCart.buyNoOffer(letterToCode('S'),30);
        shoppingCart.buyNoOffer(letterToCode('T'),20);
        shoppingCart.buyNoOffer(letterToCode('U'),40);
        shoppingCart.buyNoOffer(letterToCode('V'),50);
        shoppingCart.buyNoOffer(letterToCode('W'),20);
        shoppingCart.buyNoOffer(letterToCode('X'),90);
        shoppingCart.buyNoOffer(letterToCode('Y'),10);
        shoppingCart.buyNoOffer(letterToCode('Z'),50);

        return shoppingCart.getTotal();
    }

    //function for checking if the input string is valid.
    public static boolean checkString(String skus){
        for (char letter:skus.toCharArray()) {
            if(letterToCode(letter)<0 || letterToCode(letter) >25)
                return false;
        }
        return true;
    }
    // converts from letter to its code in the numbering system
    // used by the system. Example: A - 0, B - 1,...
    public static int letterToCode(char letter){
        return (int)letter - 65;
    }
}
