public class ShellSort {
    //希尔排序  属于插入排序 源于对直接插入排序的增强，打破了排序算法时间复杂度n^2的魔咒
    /*增量序列的 最后一个增量值必须等于 1 才行。*/
    public static void shellSort(int[] array){
        int increment = array.length;//增量
        do {
            increment = increment/3 + 1;//如此设定增量则为进行三轮,最后一轮为1
            for (int i = increment; i < array.length; i++) {//对increment+1此后的进行遍历
                if (array[i] < array[i-increment]){
                    int temp = array[i];//取出来
                    int j;
                    for (j = i-increment; j >= 0 && temp < array[j]; j-=increment) {
                        array[j+increment] = array[j];
                    }
                    array[j+increment] = temp;
                }
            }
        }while (increment > 1);
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,7,442,32,41,2,13,8,9,19};
        shellSort(array);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}

