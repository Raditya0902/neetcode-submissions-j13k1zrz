class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0, j = 0;
        List<String> ls = new ArrayList<>();
        while(j < str.length()){
            while(str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;            
            j += len;
            ls.add(str.substring(i,j+1));
            j++;
            i = j;
        }
        return ls;
    }
}
