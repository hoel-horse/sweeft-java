import java.util.Arrays;

public class Functions {
    public static int singleNumber(int[] nums){
        int result = 0;
        // XOR all elements
        for (int i = 0; i < nums.length; ++i){
            result ^= nums[i];
        }
        return result;
    }

    public static int minSplit(int amount){
        int[] coins = {50, 20, 10, 5, 1};
        int result = 0;
        for (int i = 0; i < coins.length; ++i){
            result += amount / coins[i];
            amount %= coins[i];
        }
        return result;
    }

    public static int notContains(int[] array){
        int[] sorted = array.clone();
        Arrays.sort(sorted);
        if (sorted[0] > 1) return 1;
        for (int i = 0; i < sorted.length-1; ++i){
            if (sorted[i+1] > 1 && sorted[i]+1 != sorted[i+1])
                return Math.max(1, sorted[i] + 1);
        }
        return sorted[sorted.length-1] + 1;
    }

    public static String binarySum(String a, String b){
        int na = a.length(), nb = b.length();
        int nmax = Math.max(na, nb);
        int carry = 0;
        StringBuilder sum = new StringBuilder(nmax+1);
        for (int i = 0; i < nmax; ++i){
            int ca = i < na ? a.charAt(na-i-1) - '0' : 0;
            int cb = i < nb ? b.charAt(nb-i-1) - '0' : 0;
            int csum = ca + cb + carry;
            carry = csum / 2;
            csum = csum % 2;
            sum.append((char)(csum + '0'));
        }
        if (carry > 0) sum.append('1');
        sum.reverse();
        return sum.toString();
    }

    public static int countVariants(int stairsCount){
        if (stairsCount == 1) return 1;
        // answer for n = answer for (n-1) + answer for (n-2)
        int ansprev = 1;  // answer for stairsCount = 1
        int ans = 2; // answer for stairsCount = 2
        for (int i = 2; i < stairsCount; ++i){
            int temp = ansprev;
            ansprev = ans;
            ans += temp;
        }
        return ans;
    }

    public static void main(String[] args){
        // int[] nums = {1, 3, 3, 4, 1, 5, 5};
        // System.out.println(singleNumber(nums));

        // System.out.println(minSplit(100));
        // System.out.println(minSplit(122));
        // System.out.println(minSplit(27));

        // int[] nums1 = {2, 3, 4, 5};
        // System.out.println(notContains(nums1));
        // int[] nums2 = {2, 4, 5, -6};
        // System.out.println(notContains(nums2));
        // int[] nums3 = {5, 1, 3, 2, 7, 10, -3};
        // System.out.println(notContains(nums3));

        // System.out.println(binarySum("101", "111"));
        // System.out.println(binarySum("1", "111111"));
        // System.out.println(binarySum("110", "1011110"));
        // System.out.println(binarySum("1011110", "110"));

        // System.out.println(countVariants(1));
        // System.out.println(countVariants(2));
        // System.out.println(countVariants(3));
        // System.out.println(countVariants(10));
    }
}