public class Sort {




    public static void main(String[] args) {

        int[] arrayI = {1,2,5,6,8,2,3,8878,453,11};
        //quickSortInteger(arrayI,0, arrayI.length-1);

        System.out.println(" ");
        char[] arrayC = {'a','f','c','d'};
        //quickSortChar(arrayC,0, arrayC.length-1);


        insertionSort(arrayI);

        for(int number : arrayI){
            System.out.print(number + " ");
        }
    }

    public static void quickSortChar(char[] arr, int low, int high){
        // Dizinin elemanları sıralandıktan sonra çıkış
        if (low >= high) {
            return;
        }

        // Pivot noktasını belirle
        int pivotIndex = (low + high) / 2;
        char pivot = arr[pivotIndex];

        // Dizinin sol ve sağ taraflarını ayır
        int i = low;
        int j = high;

        // Dizinin sol ve sağ taraflarını karşılaştır ve sırala
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // Sol tarafı tekrar sırala
        quickSortChar(arr, low, j);
        // Sağ tarafı tekrar sırala
        quickSortChar(arr, i, high);
    }
    public static void quickSortInteger(int[] array, int low, int high){
        if (low < high){
            int pivotIndex = partition(array, low, high);
            quickSortInteger(array,low,pivotIndex-1);
            quickSortInteger(array, pivotIndex+1, high);
        }

    }
    public static int partition(int[] array, int low, int high){

        int pivot = array[high];
        int i = low -1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i+1;
    }

    public static void bubbleSort(int[] arr){

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]){

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

    public static void insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > current){
                arr[j+1] = arr[j];
                j--;

            }
            arr[j+1] = current;
        }
    }




}
