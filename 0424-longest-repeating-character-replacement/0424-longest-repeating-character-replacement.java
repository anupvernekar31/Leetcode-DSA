class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, ans = 0;
        char nums[] = s.toCharArray();
        int maxFreq = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        while(r<nums.length){
            hm.put(nums[r], hm.getOrDefault(nums[r], 0)+1);
            maxFreq = Math.max(maxFreq, hm.get(nums[r]));

            if(r-l+1 - maxFreq <= k){
                ans = Math.max(r-l+1, ans);
                r++;
            }
            else {
                while(r-l+1 - maxFreq > k){
                    hm.put(nums[l], hm.get(nums[l]) - 1);
                    l++;
                }
                r++;

            }
        }
        return ans;
    }
}