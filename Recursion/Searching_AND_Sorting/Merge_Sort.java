package Recursion.Searching_AND_Sorting;

public class Merge_Sort extends Array_Class
{
    //Doing Merging on two sorted arrays. without using recursion.
    public static int[] merge(int[] arr1, int[] arr2)
    {
        //If one of the array is sorted than I will simply return the arrays as it is.
        if (arr1.length==0) return arr2;
        if (arr2.length==0) return arr1;

        int[] arr=new int[arr1.length+arr2.length];
        int ind1=0, ind2=0, ind=0;

        //Now Comparing and arranging the numbers in array.
        while(ind1<arr1.length && ind2<arr2.length){
            if(arr1[ind1]<=arr2[ind2]){
                arr[ind]=arr1[ind1];
                ind++;
                ind1++;
            }else{
                arr[ind]=arr2[ind2];
                ind2++;
                ind++;
            }
        }

        //If the value are remained in array 1 or 2 then;
        while(ind1<arr1.length){
            arr[ind]=arr1[ind1];
            ind++;
            ind1++;
        }
        while(ind2<arr2.length){
            arr[ind]=arr2[ind2];
            ind++;
            ind2++;
        }
        return arr;
    }

    //Doing Merge sort on unsorted array using recursion.
    public static int[] mergeSort(int[] arr)
    {
        if (arr.length<=1) return arr;

        int mI=arr.length/2;

        //Converting the arr into two new arrays(arr1 and arr2).
        int[] arr1=new int[mI];
        for (int i=0; i<mI; i++){
            arr1[i]=arr[i];
        }

        int[] arr2=new int[arr.length-mI];
        for (int i=0; i<arr2.length; i++){
            arr2[i]=arr[i+mI];
        }

        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);

        arr=merge(arr1, arr2);
        return arr;
    }




    //Doing Merge sort using recursion and without creating any new array.
    public static void mergeSortB(int[] arr)
    {
        if (arr.length<=1) return;
        mergeSortB(arr, 0, arr.length-1);
    }
    public static void mergeSortB(int[] arr, int sI, int eI)
    {
        if (sI>=eI) return;

        int mI=(sI+eI)/2;


        mergeSortB(arr, sI, mI);
        mergeSortB(arr, mI+1, eI);
        mergeB(arr, sI, eI);
    }
    //Function which will arrange the sorted part of the array into an order.
    public static void mergeB(int[] arr, int sI, int eI)
    {
        int[] newArr=new int[eI-sI+1];
        int ind=0;

        int mid=(sI+eI)/2;
        int i=sI, j=mid+1;
        while(i<=mid && j<=eI){
            if (arr[i]<arr[j]){
                newArr[ind]=arr[i];
                ind++;
                i++;
            }else{
                newArr[ind]=arr[j];
                ind++;
                j++;
            }
        }

        //Arranging remaining elements.
        while(i<=mid){
            newArr[ind]=arr[i];
            i++;
            ind++;
        }
        while(j<=eI){
            newArr[ind]=arr[j];
            j++;
            ind++;
        }

        //Copying the sorted elements to original array.
        ind=0;
        for (int ele=sI; ele<=eI; ele++){
            arr[ele]=newArr[ind];
            ind++;
        }
    }



    public static void main(String[] args)
    {
        //Both the arrays should be sorted for the function which is done without recursion.
//        int[] arr0= Array_Class();
//        int[] arr1=Array_Class();
//        printArray(arr0);
//        printArray(arr1);

//        int[] sortedArray=merge(arr0, arr1);
//        printArray(sortedArray);

//        arr0=mergeSort(arr0);
//        arr1=mergeSort(arr1);
//        int[] sorted=merge(arr0, arr1);
//        printArray(sorted);

        int[] arr={5, 0, 1, 4, 3, 2};
        printArray(arr);
        mergeSortB(arr);
        printArray(arr);
    }




    //Practice Section Again.
    //Creating Array
    public static void mergeSort_CA(int arr[])
    {
        if (arr.length<=1) return;

        int mid=arr.length/2;

        int[] arr1=new int[mid];
        for(int i=0; i<mid; i++){
            arr1[i]=arr[i];
        }

        int[] arr2=new int[arr.length-mid];
        for(int i=0; i<arr2.length; i++){
            arr2[i]=arr[i+mid];
        }

        mergeSort_CA(arr1);
        mergeSort_CA(arr2);
        merge(arr, arr1, arr2);
    }
    public static void merge(int arr[], int[] arr1, int[] arr2)
    {
        int ind1=0, ind2=0;

        int ind=0;
        while(ind1<arr1.length && ind2<arr2.length){
            if (arr1[ind1]<arr[ind2]){
                arr[ind]=arr1[ind1];
                ind++;
                ind1++;
            }else{
                arr[ind]=arr2[ind2];
                ind++;
                ind2++;
            }
        }

        while(ind1<arr1.length){
            arr[ind]=arr1[ind1];
            ind++;
            ind1++;
        }
        while(ind2<arr2.length){
            arr[ind]=arr2[ind2];
            ind++;
            ind2++;
        }
    }

    //Without creating an Array.
    public static void mergeSort_WCA(int[] arr)
    {
        if (arr.length<=1) return;
        mergeSort_WCA(arr, 0, arr.length-1);
    }
    private static void mergeSort_WCA(int[] arr, int si, int ei)
    {
        if (si>=ei) return;

        int midInd=(si+ei)/2;
        mergeSort_WCA(arr, si, midInd);
        mergeSort_WCA(arr, midInd+1, ei);
        merge_WCA(arr, si, midInd, ei);
    }
    public static void merge_WCA(int[] arr, int si, int midI, int ei)
    {
        int leftP_Index=si, rightP_Index=midI+1;

        int[] arr1=new int[ei-si+1];
        int ind=0;
        while(leftP_Index<=midI && rightP_Index<=ei){
            if (arr[leftP_Index] < arr[rightP_Index]) {
                arr1[ind]=arr[leftP_Index];
                leftP_Index++;
                ind++;
            }else{
                arr1[ind]=arr[rightP_Index];
                rightP_Index++;
                ind++;
            }
        }

        while(leftP_Index<=midI){
            arr1[ind]=arr[leftP_Index];
            leftP_Index++;
            ind++;
        }
        while(rightP_Index<=ei){
            arr1[ind]=arr[rightP_Index];
            rightP_Index++;
            ind++;
        }

        for (int index=0; index<arr1.length; index++){
            arr[index+si]=arr1[index];
        }
    }
}
