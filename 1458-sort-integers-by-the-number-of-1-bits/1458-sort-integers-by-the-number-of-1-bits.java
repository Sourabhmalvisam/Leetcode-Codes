class Solution {
   	public int[] sortByBits(int[] arr) {
        int n = arr.length, res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = countBitOne(arr[i])*10002 + arr[i];
        }
        
        Arrays.sort(res);
        for (int i = 0; i < n; i++) {
            res[i] %= 10002;
        }
        
        return res;
    }
    
    private int countBitOne(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }
}