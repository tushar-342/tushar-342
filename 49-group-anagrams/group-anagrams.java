class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> map = new HashMap<>();
      List<List<String>> res = new ArrayList<List<String>>();
      
      for(String str : strs){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String key = new String(ch);
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<String>());
        }
        map.get(key).add(str);
      }

      for(HashMap.Entry<String,List<String>> e : map.entrySet()){
        res.add(e.getValue());
      }
      return res;
    }
}