//冒泡排序
public class bubblesort {
    public static void Bubblesort(int[] array){
        for (int end = array.length-1;end > 1;end--){
            for (int i = 0; i < end; i++){
                if(array[i]>array[i+1]){
                    //交换
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        Bubblesort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}