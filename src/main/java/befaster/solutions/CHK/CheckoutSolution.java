package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Integer[] productsNumber =  {0,0,0,0,0};
        int sum = 0;
        for (char sku:skus.toCharArray()) {
            switch (sku){
                case 'A':
                    productsNumber[0]++;
                    break;
                case 'B':
                    productsNumber[1]++;
                    break;
                case 'C':
                    productsNumber[2]++;
                    break;
                case 'D':
                    productsNumber[3]++;
                    break;
                case  'E':
                    productsNumber[4]++;
                    break;
                default:
                    return -1;
            }
        }
        // adding the prices for the A product
        // and removing the producs from the array
        sum += (productsNumber[0]/5)*200;
        if (productsNumber[0]>=5) {
            int removedProducts = productsNumber[0]/5;
            productsNumber[0] = productsNumber[0] - removedProducts;
        }
        sum += (productsNumber[0]/3)*130;
        if (productsNumber[0]>=3) {
            int removedProducts = productsNumber[0]/3;
            productsNumber[0] = productsNumber[0] - removedProducts;
        }
        sum+= 50 * productsNumber[0];

        // adding the prices for the E product because we need to process them
        // before the B product as 2Es will remove one B (or at least that's
        // what i'm understanding from the info provided)
        if (productsNumber[4]>=2){
            int pairs_of_e_prod=productsNumber[4] /2;
            productsNumber[1] =productsNumber[1] - pairs_of_e_prod;
        }
        sum+= 40 * productsNumber[4];

        // adding the prices for the B product
        sum += (productsNumber[1]/2)*45 +(productsNumber[1]%2)*30;

        // C/D product
        sum += 20 * productsNumber[2];
        sum += 15 * productsNumber[3];

        return sum;
    }
}

