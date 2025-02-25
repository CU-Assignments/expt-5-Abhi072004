import java.util.ArrayList;
import java.util.List;

public class Exp5_EasyProblem {
    public static int calculateSum(List<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(11);
        al.add(22);
        al.add(33);
        al.add(44);

        int sum = calculateSum(al);
        System.out.println("Sum of numbers: " + sum);

        String numStr = "231";
        Integer parsedNumber = Integer.parseInt(numStr);
        System.out.println("Parsed Number: " + parsedNumber);
    }
}
