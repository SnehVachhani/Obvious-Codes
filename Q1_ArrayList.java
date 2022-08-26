import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1_ArrayList {
    public static void main(String[] args) {
        List<Integer> arrL=new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12));


        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i:arrL){
            max=Math.max(i, max);
            min=Math.min(i,min);
        }

            // or can also do it without methods and go old school
            // to try that comment above for loop and uncomment the on bellow


            // for(int i:arrL){
            //     if(min>i)
            //         min=i;
            //     else if(max<i)
            //         max=i;
            // }


            // System.out.println("Largest= "+max+" Smallest= "+min );

            System.out.println("Difference between the largest and smallest values in an array is "+Math.abs(max-min));

        }
}
