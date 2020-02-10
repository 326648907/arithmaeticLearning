//冒泡排序 基于《啊哈，算法》
public class bubblesort {
    public static void Bubblesort(int[] array){
        boolean flag = true;//指内层循环的上次循环是否有交换，没有则结束算法
        for (int end = array.length-1;end > 1 && flag;end--){
            flag = false;//本次循环开始，此时本次循环无交换
            for (int i = 0; i < end; i++){
                if(array[i]>array[i+1]){
                    //交换
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,7,442,32,41,2,13,8,9,19};
        Bubblesort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
