class Pair{
    String first;
    int second;
    Pair(String _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }

        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord) == true) return steps;

            for(int i = 0; i< word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    //if it exists in the set then remove it
                    if(set.contains(replacedWord)== true){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}