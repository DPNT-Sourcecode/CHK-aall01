package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        if(checkString(skus)!=true)
            return -1;

    }

    //function for checking if the input string is valid.
    public static boolean checkString(String skus){
        for (char letter:skus.toCharArray()) {
            if(letter<'A' && letter >'Z')
                return false;
        }
        return true;
    }
}
