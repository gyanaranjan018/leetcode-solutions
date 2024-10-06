class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if(s1.length() < s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        String[] s1arr = s1.split(" ");
        String[] s2arr = s2.split(" ");

        int i = 0, j = s1arr.length - 1; // s1
        int k = 0, l = s2arr.length - 1; // s2

        while(k < s2arr.length && i < s1arr.length && s2arr[k].equals(s1arr[i])){
            k++;
            i++;
        }

        while(l >= k && s2arr[l].equals(s1arr[j])){
            l--;
            j--;
        }

        return l < k;




        /*
        
        // Ensure s1 is the longer string
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        // Split the strings into Deques
        Deque<String> deq1 = new LinkedList<>(Arrays.asList(s1.split(" ")));
        Deque<String> deq2 = new LinkedList<>(Arrays.asList(s2.split(" ")));

        // Remove matching words from the front
        while (!deq1.isEmpty() && !deq2.isEmpty() && deq1.peekFirst().equals(deq2.peekFirst())) {
            deq1.pollFirst();
            deq2.pollFirst();
        }

        // Remove matching words from the back
        while (!deq1.isEmpty() && !deq2.isEmpty() && deq1.peekLast().equals(deq2.peekLast())) {
            deq1.pollLast();
            deq2.pollLast();
        }

        // If deq2 is empty, then s2 is a sub-sequence of s1
        return deq2.isEmpty();
        
        */

        /*


        if(s1.length() < s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        List<String> vec1 = new ArrayList<>();
        List<String> vec2 = new ArrayList<>();

        // Splitting strings by spaces
        vec1 = Arrays.asList(s1.split(" "));
        vec2 = Arrays.asList(s2.split(" "));

        int i = 0, j = vec1.size() - 1; // s1 (vec1)
        int k = 0, l = vec2.size() - 1; // s2 (vec2)

        // Check for matching prefix
        while (k < vec2.size() && i < vec1.size() && vec2.get(k).equals(vec1.get(i))) {
            k++;
            i++;
        }

        // Check for matching suffix
        while (l >= k && vec2.get(l).equals(vec1.get(j))) {
            j--;
            l--;
        }

        return l < k;
        
        */
    }
}