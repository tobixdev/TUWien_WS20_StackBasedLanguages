public class prime_sieve {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] primes = sieve(n);

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i <= n; i++) {
            builder.append(primes[i]);
            if (i != n) {
                builder.append(" ");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static int[] sieve(int n) {
        int i = 0;
        int j = 0;
        int[] primes = new int[n + 1];

        // initialization of prime number field
        // at the beginning, every number is assumed to be a prime number
        for (i = 2; i <= n; i++) {
            primes[i] = i;
        }

        // Sieve with all (prime) numbers, where i is the smallest prime factor of
        // a number j = i * k. The smallest prime factor of a number j cannot be
        // greater than square root sqrt(j) <= n.
        int upperBound = 0;
        float guess = n / 2;

        float pctDiff = Float.MAX_VALUE;
        float lastGuess = guess;

        while (pctDiff >= 0.01f || pctDiff <= -0.01f)
        {                        
            float r = n / guess;
            guess = (guess + r) / 2;
            pctDiff = ((guess-lastGuess)/lastGuess);
            lastGuess = guess;
        }
        upperBound = (int) guess;

        for (i = 2; i <= upperBound; i++) {
            // i == primes[i] is prime
            if (primes[i] != 0) {
                // "cross out" all multiples of i == primes[i], starting at i*i
                // (since k*i with k < i was already crossed out as a multiple of k)
                for (j = i * i; j <= n; j += i) {
                    primes[j] = 0;
                }
            }
        }

        return primes;
    }
}
