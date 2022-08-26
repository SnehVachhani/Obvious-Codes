public class bubble {
    public static void main(String[] args) {
        int a[] = { 69, 69, 5, 8, 74, 21, 35, 9, 45 };
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted array is :");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}