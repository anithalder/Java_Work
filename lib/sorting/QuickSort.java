package sorting;

public class QuickSort {
    public static int[] sort(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int pivot = partition(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }
    public static int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i = low-1,j,tmp;
        for(j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }   
        tmp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = tmp;
        return i+1;
    }
}
