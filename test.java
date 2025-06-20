
public class test {
    public static void main(String[] args) {
        int x = 1;
        testing t1 = new testing();
        t1.name = "Diane";
        while (x < 10){
            System.out.println(x + t1.name);
            x++;
        }
    }
}

class testing{
    String name;
    int age;
}