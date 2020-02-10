public class HeapSort {
    //堆排序 属于选择排序
    public static void heapSort(int[] array){
        for (int i = array.length/2-1; i >= 0 ; i--) {
            heapAdjust(array, i,array.length);
        }
        for (int j = array.length-1; j > 0 ; j--) {//从最后一个开始做交换
            swap(array,0,j);
            heapAdjust(array,0,j);
        }
    }
    public static void heapAdjust(int[] array,int s,int length){
        int temp = array[s];
        for (int j = 2*s+1; j <= length-1; j = j*2+1){
            if ( j < length-1 && array[j] < array[j+1]){//比较二叉树的左右子节点并将j指向大的那个//大小堆的转换：将这的大于小于号转变
                j++;
            }
            if (temp > array[j]){//大小堆的转换：将这的大于小于号转变
                break;
            }
            array[s]=array[j];
            s = j;
        }
        array[s] = temp;

    }
    public static void swap(int[] array,int i,int j){//交换数组中值的静态方法
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,7,442,32,41,13,8,9,19};
        heapSort(array);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}
