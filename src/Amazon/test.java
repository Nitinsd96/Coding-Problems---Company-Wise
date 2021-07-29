package Amazon;

public class test {
    public static void main(String[] args) {
        String s1 = "3175";
        String s2 = "11373";
        int l = s1.length();

        System.out.print(countPrimeStrings(s1, l)+"\n");
        System.out.println(countPrimeStrings(s2, s2.length()));
    }
        static final int MOD =1000000007;
        static boolean isPrime(String number)
        {
            int num = Integer.valueOf(number);

            for(int i = 2; i * i <= num; i++)
            {
                if ((num % i) == 0)
                    return false;
            }
            return num > 1 ? true : false;
        }
        static int countPrimeStrings(String number,
                                     int i) {
            if (i == 0)
                return 1;
            int cnt = 0;
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0 &&
                        number.charAt(i - j) != '0' &&
                        isPrime(number.substring(i - j, i))) {
                    cnt += countPrimeStrings(number,
                            i - j);
                    cnt %= MOD;
                }
            }
            return cnt;
        }
}
