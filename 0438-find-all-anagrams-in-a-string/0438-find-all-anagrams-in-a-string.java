class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int start=0, end = 0;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int count =0;
        int ans = 0;
        List<Integer> sol = new ArrayList<Integer>();
        
        for(Character c: p.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        count = hm.size();
        
        while(end<s.length()){
            char ch = s.charAt(end);
            
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) - 1);
                if(hm.get(ch) == 0){
                    count--;
                }
            }
            
            if(end-start+1 < p.length()){
                end++;
                
            } else if(end-start+1 == p.length()){
                if(count ==0){
                    ans++;
                    sol.add(start);
                }
                Character leftchar = s.charAt(start);
                if(hm.containsKey(leftchar)){
                    hm.put(leftchar, hm.get(leftchar) + 1);
                    if(hm.get(leftchar) == 1){
                        count++;
                    }
                }
                start++;
                end++;
                    
            }
        }
        return sol;
    }
}