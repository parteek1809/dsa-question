class Pair{
    String first;
    int second;
    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for(String s : wordList){
            hs.add(s);
        }
        if(!hs.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair (beginWord,1));
        if(hs.contains(beginWord)) hs.remove(beginWord);
        while(!q.isEmpty()){
            Pair p = q.poll();
            String curr = p.first;
            int steps = p.second;
            if(curr.equals(endWord)) return steps;
            for(int i=0; i<curr.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char charArray[] = curr.toCharArray();
                    charArray[i] = ch;
                    String replaceWord = new String(charArray);
                    if(hs.contains(replaceWord)){
                        hs.remove(replaceWord);
                        q.add(new Pair(replaceWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}