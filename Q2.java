import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[] arr={49, 1, 3, 200, 2, 4, 70, 5};
        Arrays.sort(arr);
        int consecutiveLen=1,maxLen=1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]==arr[i]+1)
                consecutiveLen++;
            else{
                maxLen=Math.max(maxLen, consecutiveLen);
                consecutiveLen=1;
            }
        }
        System.out.println(maxLen);
    }
}
