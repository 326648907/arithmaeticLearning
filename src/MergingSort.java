public class MergingSort {
    //二路归并排序 递归的形式
    //这个算法，恶心了我半天，反思一下，还是例子没有理解透彻，另一方面参考给的源码写的繁琐，至于，自己的思路很乱
    public static void mergingSort(int[] array){
        int k = 1;//代表一轮开始时的一组k个数，即每次归并1、2、4...
        while (k < array.length){
            mergePass(array,k,array.length-1);//
            k = k*2;
        }
    }
    public static void mergePass(int[] array,int k,int n){
        int i = 0;
        while (i+2*k-1 <= n){//表示若有完整的一对小组则将其排序合并，
            merge(array,i,i+k-1,i+2*k-1);
            i = i+2*k;
        }
        if (i+k-1 < n){//表示若剩出来一组，且有剩下的不完整的一组，则将剩下的一组和不完整的另一组合并
            merge(array,i,i+k-1,n);
        }
    }
    public static void merge(int[] array,int i,int m,int n){//合并
        int j = m+1;
        int k = i;
        int[] temp = new int[array.length];
        //这里拷贝数组很蠢，但暂时不知道有什么好的方法
        for (int l = 0; l < temp.length; l++) {
             temp[l] = array[l];
        }
        for (;i<=m && j<=n;k++){
            if (array[i]<array[j]){
                temp[k] = array[i];
                i++;
            }else{
                temp[k] = array[j];
                j++;
            }
        }
        if (i<=m){
            for (int l = 0; l <= m-i ; l++) {
                temp[k+l] = array[i+l];
            }
        }
        if (j<=n){
            for (int l = 0; l <= n-j ; l++) {
                temp[k+l] = array[j+l];
            }
        }
        for (int l = 0; l < temp.length; l++) {
            array[l] = temp[l];
        }
    }
    public static void main(String[] args) {
        int[] array = {1,3,2,7,4,11,13,41,12,18,25,21,19};
        mergingSort(array);
//        merge(array,0,7,11);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}
