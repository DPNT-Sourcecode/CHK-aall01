package befaster.solutions.FIZ;

import befaster.runner.SolutionNotImplementedException;

public class FizzBuzzSolution {

    public String fizzBuzz(Integer number) {
        String temp = new String();
        temp = number.toString();
        if((number % 3 ==0 || temp.contains("3")) && (number % 5 ==0 || temp.contains("5"))) return  "fizz buzz";
        else if (number % 3 ==0 || temp.contains("3")) return "fizz";
        else if (number % 5 ==0 || temp.contains("5") ) return  "buzz";
        // deluxe
        if((number % 3 ==0 || temp.contains("3")) && (number % 5 ==0 || temp.contains("5"))&&(number>10 &&allDigitsSame(number))) return  "fizz buzz deluxe";
        else if ((number % 3 ==0 || temp.contains("3"))&&(number>10 &&allDigitsSame(number))) return "fizz deluxe";
        else if ((number % 5 ==0 || temp.contains("5"))&&(number>10 &&allDigitsSame(number))) return "buzz deluxe";
        else if ((number>10 &&allDigitsSame(number))) return "deluxe";
        else return  number.toString();
    }
    public boolean allDigitsSame(Integer number){
        int t = number % 10;
        while (number !=0){
            if (number %10 !=t) return false;
        }
        return true;
    }
}

