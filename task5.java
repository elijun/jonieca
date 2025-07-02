import java.util.*;

public class task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("First number: ");
        int num1 =  scan.nextInt();
        System.out.print("Second number: ");
        int num2 =  scan.nextInt();
        System.out.print("Third number: ");
        int num3 =  scan.nextInt();

        List list = Arrays.asList(num1, num2, num3);
        System.out.println(list);
        //Collections.sort(list);
        System.out.println("Largest Number: "+list.getLast());
    }
}
