public class StraightInsertionSort {
    //直接插入排序
    public static void straightInsertionSort(int[] array){
        int temp ; //每次循环取出的牌
        for (int i = 1; i < array.length; i++) {//以第一个数为基准进行排序,从第二个数开始比较
            if (array[i] < array[i-1]){//若比左边的小
                temp = array[i];//把这个数拿出来，为手牌
                int j = i-1;//依次和左边的比较
                for ( ; j >= 0 ; j--) {
                    if (array[j] > temp){//手牌小，则与之比较的数右移，直至不小
                        array[j+1]=array[j];
                    }else {
                        break;
                    }
                }
                array[j+1] = temp;//将手牌放入数组，此时为其正确位置
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,7,442,32,41,2,13,8,9,19};
        straightInsertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
