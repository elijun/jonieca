public class task16 {

    interface Animal {
        boolean feed(boolean timeToEat);
        void groom();
        void pet();
    }

    static class Gorilla implements Animal {

        public boolean feed(boolean timeToEat) {
            if (timeToEat) {
                for (int i = 0; i < 1; i++) {
                    System.out.println("put gorilla food into cage");
                }
                return true;
            } else {
                return false;
            }
        }

        public void groom() {
            for (int i = 0; i < 1; i++) {
                System.out.println("lather, rinse, repeat");
            }
        }

        public void pet() {
            for (int i = 0; i < 1; i++) {
                System.out.println("pet at your own risk");
            }
        }
    }

    public static void main(String[] args) {
        Gorilla g = new Gorilla();
        g.feed(true);
        g.groom();
        g.pet();
    }
}
