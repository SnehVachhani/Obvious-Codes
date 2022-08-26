public class Q5 {
    public static void main(String[] args) {

        // O(n^2) time complexity
        // int[] arr= { 4, 5, 9, 5, 6, 10, 11, 9, 6, 4, 5};
        // int lo=0,hi=0,max=0;
        // int loIndex=0,hiIndex=0;

        // for(int i=0;i<arr.length;i++){
        // int val=arr[i];
        // boolean flag=true;
        // boolean loAllow=false;
        // for(int j=i+1;j<arr.length;j++){
        // if(val<arr[j]&&flag){
        // lo=i;
        // hi=j;
        // val=arr[j];
        // if(hi-lo+1>max){
        // max=hi-lo+1;
        // loIndex=lo;
        // hiIndex=hi;
        // }
        // loAllow=true;
        // }else if(val>arr[j]&&loAllow){
        // flag=false;
        // hi++;
        // val=arr[j];
        // if(hi-lo+1>max){
        // max=hi-lo+1;
        // loIndex=lo;
        // hiIndex=hi;
        // }
        // }else{
        // break;
        // }
        // }
        // }
        // System.out.println("The longest bitonic subarray is
        // ["+loIndex+","+hiIndex+"]");
        // System.out.print("Elements of the said sub-array:");
        // while(loIndex<=hiIndex){
        // System.out.print(arr[loIndex++]+" ");
        // }
        // System.out.println();
        // System.out.println("The length of longest bitonic subarray is "+max);

        
        // O(n) time complexity
        int[] arr = { 4, 5, 9, 5, 6, 10, 11, 9, 6, 4, 3 };
        int[] forward = new int[arr.length];
        int[] backward = new int[arr.length];
        int count = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1])
                forward[i] = count++;
            else {
                forward[i] = count++;
                count = 1;
            }
        }
        forward[arr.length-1]=count;
        count=1;
        for (int i =arr.length - 1; i >0 ; i--) {
            if (arr[i] < arr[i - 1])
            backward[i] = count++;
            else {
                backward[i] = count++;
                count = 1;
            }
        }
        backward[0]=count;
        int max=0,lo=0,hi=0;
        for(int i=0;i<arr.length;i++){
            if(forward[i]+backward[i]-1>max){
                max=forward[i]+backward[i]-1;
                lo=i-forward[i]+1;
                hi=i+backward[i]-1;
            }
        }
        System.out.print("Elements of the said sub-array:");
        while(lo<=hi){
        System.out.print(arr[lo++]+" ");
        }
        System.out.println();
        System.out.println("The length of longest bitonic subarray is "+max);
    }
}
