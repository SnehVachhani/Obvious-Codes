public class Q4 {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 1,0,1};
        // int arr[]={ 0, 1, 1, 0, 1, 1, 0, 1, 0, 0 };
        // int newArr[] =new int[arr.length];
        // int i=0,lo=0,hi=arr.length-1;
        // while(lo<hi){
        //     if(arr[i++]==0)
        //         newArr[lo++]=0;
        //     else
        //         newArr[hi--]=1;
        // }
        // for(int val:newArr){
        //     System.out.print(val+" ");
        // }

        int i=0,len=arr.length,ones=0;
        while(i<len){
            if(arr[i]==1){
                ones++;
                arr[i]=0;
            }
            i++;
        }
        int temp=len-ones;
        while(temp<len){
            arr[temp++]=1;
        }
        for(int val:arr){
            System.out.print(val+" ");
        }
    }
}
