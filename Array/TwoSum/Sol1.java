package Array.TwoSum;

public class Sol1 {

    public int[] main(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = j + i; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        
        return null;
    }
    
}
