package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Integer[] productsNumber =  {0,0,0,0};
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
                default:
                    return -1;
            }
        }
        // adding the prices for the A product
        sum += (productsNumber[0]/3)*130 +(productsNumber[0]%3)*50;

        // adding the prices for the B product
        sum += (productsNumber[1]/2)*45 +(productsNumber[1]%2)*30;

        // C/D product
        sum += 20 * productsNumber[2];
        sum += 15 * productsNumber[3];

        return sum;
    }
}
