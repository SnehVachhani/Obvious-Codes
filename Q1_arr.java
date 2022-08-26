public class Q1_arr{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,8,9,10,11};
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;


        for(int i:arr){
            max=Math.max(i, max);
            min=Math.min(i,min);
        }

        // or can also do it without methods and go old school
        // to try that comment above for loop and uncomment the on bellow


        // for(int i:arr){
        //     if(min>i)
        //         min=i;
        //     else if(max<i)
        //         max=i;
        // }


        // System.out.println("Largest= "+max+" Smallest= "+min);

        System.out.println("Difference between the largest and smallest values in an array is "+Math.abs(max-min));
    }
}