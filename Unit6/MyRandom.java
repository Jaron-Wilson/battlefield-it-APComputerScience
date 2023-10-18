public class MyRandom {
    public static void main(String[] args) {
        if (args.length == 0) {
            // Default array size is 10
            int size = 10;
            int[] x = new int[size];

            // Initialize and print default element values
            for (int i = 0; i < size; i++) {
                x[i] = (int) (Math.random() * 11); // Generates random numbers from 0 to 10
                System.out.println(x[i]);
            }
        } else if (args.length == 3) {
            int size = Integer.parseInt(args[0]);
            int min = Integer.parseInt(args[1]);
            int max = Integer.parseInt(args[2]);

            if (size <= 0 || min > max) {
                System.out.println("Invalid argument list");
            } else {
                int[] x = new int[size];

                for (int i = 0; i < size; i++) {
                    x[i] = (int) (Math.random() * (max - min + 1) + min);
                    System.out.println(x[i]);
                }
            }
        } else {
            System.out.println("Invalid argument list");
        }
    }
}
