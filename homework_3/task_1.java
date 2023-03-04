package homework_3;

import java.util.Arrays;

public class task_1 {
    public static void main(String[] args) {
        int[] myArr = { 4, 2, 7, 5, 9, 8, 3, 32, 1, 0, 45, 9, 12 };
        System.out.println(Arrays.toString(myArr));
        mergeSort(myArr, 0, myArr.length - 1);

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }

    }

}
