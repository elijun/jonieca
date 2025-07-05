public class task7 {
    public static void main(String[] args) {
        System.out.println(sum(10,20));
        System.out.println(diff(40,20));
        System.out.println(product(16,3));
        System.out.println(quotient(60,2));
    }

    static int sum(int a, int b){
        int result = a + b;
        return result;
    }

    static int diff(int a, int b){
        int result = a - b;
        return result;
    }

    static int product(int a, int b){
        int result = a * b;
        return result;
    }

    static int quotient(float a, float b){
        float result = a / b;
        return (int) result;
    }

}

