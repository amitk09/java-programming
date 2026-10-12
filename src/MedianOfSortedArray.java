import java.util.Arrays;

public class MedianOfSortedArray {

    public static int findMedian(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n= nums2.length;

        int[] merged = new int[m+n];

        System.arraycopy(nums1,0,merged,0,m);
        System.arraycopy(nums2,0,merged,m,n);

        Arrays.sort(merged);

        int totalLength = merged.length;
        if(totalLength%2==1){
            return merged[totalLength/2];
        }
        else{
            return (merged[(totalLength/2)-1]+merged[totalLength/2])/2;
        }
    }

    static void main(String[] args) {
        int[] nums1= {1,3};
        int[] nums2= {2};
        System.out.println(findMedian(nums1,nums2));
    }
}
