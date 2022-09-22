package befaster.solutions.FIZ;

import befaster.runner.SolutionNotImplementedException;

public class FizzBuzzSolution {

    public String fizzBuzz(Integer number) {
        String temp = new String();
        temp = number.toString();
        if((number % 3 ==0 || temp.contains("3")) && (number % 5 ==0 || temp.contains("5"))&&(number>10 &&allDigitsSame(number)&&number%2!=0)) return  "fizz buzz fake deluxe";
        else if ((number % 3 ==0 || temp.contains("3"))&&(number>10 &&allDigitsSame(number)&&number%2!=0)) return "fizz fake deluxe";
        else if ((number % 5 ==0 || temp.contains("5"))&&(number>10 &&allDigitsSame(number)&&number%2!=0)) return "buzz fake deluxe";
        else if ((number>10 &&allDigitsSame(number)&&number%2!=0)) return "fake deluxe";
        else if((number % 3 ==0 || temp.contains("3")) && (number % 5 ==0 || temp.contains("5"))&&(number>10 &&allDigitsSame(number))) return  "fizz buzz deluxe";
        else if ((number % 3 ==0 || temp.contains("3"))&&(number>10 &&allDigitsSame(number))) return "fizz deluxe";
        else if ((number % 5 ==0 || temp.contains("5"))&&(number>10 &&allDigitsSame(number))) return "buzz deluxe";
        else if ((number>10 &&allDigitsSame(number))) return "deluxe";
        else if((number % 3 ==0 || temp.contains("3")) && (number % 5 ==0 || temp.contains("5"))) return  "fizz buzz";
        else if (number % 3 ==0 || temp.contains("3")) return "fizz";
        else if (number % 5 ==0 || temp.contains("5") ) return  "buzz";
        else return  number.toString();
    }
    public boolean allDigitsSame(Integer number){
        int t = number % 10;
        while (number !=0){
            if (number %10 !=t) return false;
            number = number / 10;
        }
        return true;
    }
}
