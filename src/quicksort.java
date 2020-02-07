//狄克斯特拉算法 基于《啊哈，算法》
public class quicksort {
    public static void Quicksort(int[] array, int left ,int right){
        //基线递归结束
        if (left>=right){
            return;
        }
        //选取基准线
        int i = left;
        int j = right;
        int pivot = array[left];
        //双指针法将左右归类
        while (i<j){
            while (pivot<=array[j]&&i<j){
                j--;
            }
            while (pivot>=array[i]&&i<j){
                i++;
            }
            if (i<j) {
                //交换
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        //交换
        array[left] = array[i];
        array[i] = pivot;
        //递归
        Quicksort(array,left,i-1);
        Quicksort(array,i+1,right);
    }

    public static void main(String[] args) {
        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        Quicksort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
