package befaster.solutions.FIZ;

import befaster.runner.SolutionNotImplementedException;

public class FizzBuzzSolution {

    public String fizzBuzz(Integer number) {
        String temp = new String();
        temp = number.toString();
        if((number % 3 ==0 || temp.contains("3")) && (number % 5 ==0 || temp.contains("5"))) return "fizz buzz";
        else if (number % 3 ==0 || temp.contains("3")) return "fizz";
        else if (number % 5 ==0 || temp.contains("5") ) return "buzz";
        else return number.toString();
    }

}
