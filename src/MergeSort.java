import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        // Check for proper command-line arguments
        if (args.length < 3) {
            System.out.println("Usage: java MergeSort <start_index> <end_index> <list_of_words>");
            return;
        }

        try {
            // Parse the start and end indices
            int start = Integer.parseInt(args[0]);
            int end = Integer.parseInt(args[1]);

            // Extract the subarray
            String[] array = Arrays.copyOfRange(args, 2, args.length);

            // Validate indices
            if (start < 0 || end >= array.length || start > end) {
                System.out.println("Invalid indices.");
                return;
            }

            // Sort the subarray
            mergeSort(array, start, end);

            // Print the result
            System.out.println(String.join(" ", array));

        } catch (NumberFormatException e) {
            System.out.println("Invalid index format.");
        }
    }

    // Merge sort method
    public static void mergeSort(String[] array, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        // Sort left and right subarrays
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);

        // Merge the sorted subarrays
        merge(array, start, mid, end);
    }

    // Merge method
    public static void merge(String[] array, int start, int mid, int end) {
        String[] temp = new String[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (array[i].compareTo(array[j]) <= 0) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) temp[k++] = array[i++];
        while (j <= end) temp[k++] = array[j++];

        // Copy sorted values back to the array
        System.arraycopy(temp, 0, array, start, temp.length);
    }
}