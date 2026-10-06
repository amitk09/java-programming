public class MinimumCommonValue {
    public static int getCommon(int[] nums1, int[] nums2) {

        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Found the minimum common value!
            } else if (nums1[i] < nums2[j]) {
                i++; // nums1[i] is too small, move forward
            } else {
                j++; // nums2[j] is too small, move forward
            }
        }

        return -1; // No common value found
    }

    static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4};

        // 2. Call the method and pass the arrays as arguments
        int result = getCommon(nums1, nums2);

        // 3. Print out the result
        System.out.println("The minimum common value is: " + result);

        // Another example:
        int[] numsA = {1, 2, 3, 6};
        int[] numsB = { 3, 4, 5};
        System.out.println("The minimum common value is: " + getCommon(numsA, numsB));
    }
}
