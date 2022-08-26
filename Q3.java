import java.util.ArrayList;
import java.util.List;


public class Q3 {
    public static void main(String[] args) {
        int[] arr = { 1, 3, -7, 3, 2, 3, 1, -3, -2};
        // int[] arr ={ 1, 2, -3, 4, 5, 6 };
        // int[] arr={ 1, 2, -2, 3, 4, 5, 6 };
        
        List<List<Integer>> tre = new ArrayList<>();

        // Brute Force method
        // for(int i=0;i<arr.length;i++){
        //     for(int j=i;j<arr.length;j++){
        //         int sum=0;
        //         for(int k=j;k<arr.length;k++){
        //             sum+=arr[k];
        //             if(sum==0){
        //                 int lo=j,hi=k;
        //                 List<Integer> temp = new ArrayList<>();
        //                 while(lo<=hi){
        //                     temp.add(arr[lo]);
        //                     lo++;
        //                 }
        //                 if(!tre.contains(temp))
        //                     tre.add(temp);
        //             }
        //         }
        //     }
        // }System.out.println(tre);

        //Optimized
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==0){
                    int lo=i,hi=j;
                    List<Integer> temp = new ArrayList<>();
                    while(lo<=hi){
                        temp.add(arr[lo]);
                        lo++;
                    }
                    if(!tre.contains(temp))
                        tre.add(temp);
                }
            }
        }System.out.println(tre);
    }
}
