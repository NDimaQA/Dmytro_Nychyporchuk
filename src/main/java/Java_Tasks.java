import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Java_Tasks {

    //First task
    public static List<Integer> getIntegersFromList(List<Object> list) {
        var res = new ArrayList<Integer>();
        if(list == null) return null;
        for(Object item: list) {
            if(item instanceof Integer)
                res.add((Integer) item);
        }
        return res;
    }

    public static String firstNonRepeatingLetter(String s) {
        var lower = s.toLowerCase();
        for(int i = 0; i < lower.length(); i++) {
            if(lower.indexOf(lower.charAt(i), lower.indexOf(lower.charAt(i))+1) == -1)
                return String.valueOf(s.charAt(i));
        }
        return "";
    }

    public static int digitalRoot(int n) {
        var res = 10;
        while (res >= 10){
            res = 0;
            while(n != 0) {
                res += n % 10;
                n /= 10;
            }
            n = res;
        }
        return res;
    }

    public static int countNumberOfPairs(int[] a, int target, boolean isStream) {
        var count = 0;
        if(isStream){
            count = ((int)Arrays.stream(a)
                    .flatMap(i -> Arrays.stream(a).map(j -> i + j)).filter(i -> i == target).count()
                    - (int)Arrays.stream(a).map(i -> 2*i).filter(i -> i == target).count())/2;
        } else {
            for(int i = 0; i < a.length-1; i++)
                for(int j = i+1; j < a.length; j++)
                    if(a[i]+a[j] == target) count++;
        }

        return count;
    }

    public static String friends(String s) {
        s = s.toUpperCase();
        var names = s.split(";");
        return Arrays.stream(names).map(str -> str.substring(str.indexOf(":")+1)+", "+ str.substring(0, str.indexOf(":")))
                .sorted().reduce("", (accum, next) -> accum +"("+next+")");
    }

    public static void main(String[] args) {
        System.out.print("Run code (enter go)?: ");
        Scanner sc = new Scanner(System.in);
        if(!sc.nextLine().equals("go")) {
            //FIRST TASK
            System.out.print("getIntegersFromList test\n");
            var inputArr = sc.nextLine().split(" ");
            var list1Task = new ArrayList<Object>();

            for (String s : inputArr) {
                try {
                    list1Task.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    list1Task.add(s.trim());
                }
            }
            System.out.println("Result: " + getIntegersFromList(list1Task)+"\n---------------------------");

            //SECOND TASK
            System.out.print("firstNonRepeatingLetter test\nEnter string: ");
            //sc.nextLine(); //Consumes newline character
            System.out.println("Result: " + firstNonRepeatingLetter(sc.nextLine())+"\n---------------------------");

            //THIRD TASK
            System.out.print("digitalRoot test\nEnter positive integer: ");
            System.out.println("Result: " + digitalRoot(Integer.parseInt(sc.nextLine()))+"\n---------------------------");

            //FOURTH TASK
            System.out.print("countNumberOfPairs test\nEnter integers separeted by space: ");
            inputArr = sc.nextLine().split(" ");
            var list4Task = Arrays.stream(inputArr).mapToInt(Integer::parseInt).toArray();
            System.out.print("Enter target sum: ");
            var target = Integer.parseInt(sc.nextLine());
            System.out.println("Result(for loop): " + countNumberOfPairs(list4Task, target, false));
            System.out.println("Result(stream): " + countNumberOfPairs(list4Task, target, true)+"\n---------------------------");

            //FIFTH TASK
            System.out.print("meeting test\nEnter names in format 'Name1:Surname1;Name2:Surname2;...': ");
            //sc.nextLine(); //Consumes newline character
            System.out.println("Result: " + friends(sc.nextLine())+"\n---------------------------");

        } else {
            //FIRST TASK
            System.out.println("getIntegersFromList default test: 2, 6, \"d\", \"n\", 0, 7");
            System.out.println("Result: " + getIntegersFromList(Arrays.asList(2,6,"d","n",0,7))+"\n---------------------------");

            //SECOND TASK
            System.out.println("firstNonRepeatingLetter default test: succes");
            System.out.println("Result: " + firstNonRepeatingLetter("succes")+"\n---------------------------");

            //THIRD TASK
            System.out.println("digitalRoot default test: 2983745");
            System.out.println("Result: " + digitalRoot(2983745)+"\n---------------------------");

            //FOURTH TASK
            System.out.println("countNumberOfPairs default test: 2, 5, 0, 8, 7, 6, 3, 5, 8");
            System.out.println("Result(for loop): " + countNumberOfPairs(new int[]{2, 5, 0, 8, 7, 6, 3, 5, 8}, 9, false));
            System.out.println("Result(stream): " + countNumberOfPairs(new int[]{2, 5, 0, 8, 7, 6, 3, 5, 8}, 9, true)+"\n---------------------------");

            //FIFTH TASK
            System.out.println("meeting default test: Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill");
            System.out.println("Result: " + friends("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill")+"\n---------------------------");

        }
        sc.close();
    }
}
