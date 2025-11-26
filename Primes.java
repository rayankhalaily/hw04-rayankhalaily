public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] arr = new boolean[n + 1];
        System.out.println("Prime numbers up to " + n + ":");

        //Filling the array
        for (int i = 0; i < arr.length; i++){
            if (i == 0 || i == 1)
                arr [i] = false;
            else arr[i] = true;
        }        

        int p = 2;

        //Sorting the array
        for (int i = 3; i < arr.length && p < Math.sqrt(n); i++){
            for (int j = p + 1; j < arr.length; j++){
                if (arr[j] == true && j % p == 0)
                    arr[j] = false;
            }

            boolean flag = false;

            p ++;
            while (p < arr.length){
                if (arr[p] == true){
                    flag = true;
                    break;
                }
                p ++;
            }
            if (p == Math.sqrt(n) && !flag)
                break;
        }

        int counter = 0;
        for (int i = 2; i < arr.length; i++){
            if (arr[i] == true){
                System.out.println(i);
                counter ++;
            }
        }

        System.out.println("There are " + counter + " primes between 2 and " + n + " (" + (int)(((double)counter / n) * 100) + "% are primes)");
    }
}