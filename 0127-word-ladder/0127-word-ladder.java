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

--------------------------------------------------------------------------------------------------------------------

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);

        if (!st.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        st.remove(beginWord);
        int level=1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();

                if(curr.equals(endWord)){
                    return level;
                }

                for(int j=0;j<curr.length();j++){
                    char[] word = curr.toCharArray();
                    char original = word[j];

                    for(char c = 'a';c<='z';c++){
                        if(c==original)continue;
                        word[j]=c;
                        String newWord=new String(word);
                        if(st.contains(newWord)){
                            q.offer(newWord);
                            st.remove(newWord);
                        }
                        
                    }
                }
            }
            level++;
        }

        return 0;


    }
}
