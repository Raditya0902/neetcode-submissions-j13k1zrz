class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> st = new Stack<>();
        for(String p: parts){
            if(p.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else if(!p.equals("") && !p.equals(".")){
                st.push(p);
            }
        }
        return "/" + String.join("/", st);
    }
}