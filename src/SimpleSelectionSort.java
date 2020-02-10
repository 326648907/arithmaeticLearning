public class SimpleSelectionSort {
    //快速选择排序
    public static void simpleSelectionSort(int[] array){
        for (int i = 0; i < array.length-2; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[min] > array[j]){
                    min = j;
                }
            }
            if (min != i){
                swap(array,min,i);
            }
        }
    }
    public static void swap(int[] array,int i,int j){//交换数组中值的静态方法
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,7,442,32,41,2,13,8,9,19};
        simpleSelectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
