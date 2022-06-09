

class MaximumSubarray {

    // basic kadane algorithm

    public int maximumSubarraySum(int [] nums) {
        int result = nums[0];       // if you have to take atleast 1 element else keep it 0
        int start = 0;
        int tempstart = 0;
        int end = 0;
        int sum = 0;
        for(int i=0;i < nums.length;i++) {
            sum += nums[i];
            if(sum > result) {
                result = sum;
                end = i;
                start = tempstart;
            }
            if(sum <= 0) {
                sum = 0;
                tempstart = i+1;
            }
        }
        return result;
    }


    public static void main(String args[]) {

    }
}