class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> nge = new HashMap<>();
        int[] stack = new int[nums2.length];
        int top = -1;
        for(int i = nums2.length-1; i >= 0; i--){
            while(top != -1 && nums2[i] >= stack[top]){
              top--;
            }
            if(top == -1){
                nge.put(nums2[i], -1);
            }
            else{
                nge.put(nums2[i], stack[top]);
            }
            stack[++top] = nums2[i];
        }

        for(int i = 0; i< nums1.length; i++){
            res[i] = nge.get(nums1[i]);
        }

        return res;
    }
} 