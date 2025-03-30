public class GCDtest {
    public static int gcd(int m, int n) {
        if (m == n) {
            return m;
        }

        int smaller = (m < n) ? m : n;
        int greater = (m > n) ? m : n;

        int maxDivisor = greater / 2 < smaller ? greater / 2 : smaller;

        for (int i = maxDivisor; i >= 2; i--) {
            if (m % i == 0 && n % i== 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        System.out.println("GCD of " + m + " and " + n + " is " + gcd(m, n));
    }
}
