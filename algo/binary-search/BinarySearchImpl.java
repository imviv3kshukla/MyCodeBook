import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


enum SearchType {
    FIRST, 
    LAST
}

class BinarySearchImpl {

    public int binarySearch(List<Integer> arr, int val, SearchType type) {
        int result = -1;
        int low = 0;
        int high = arr.size();
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(arr.get(mid) == val) {
                result = mid;
                if(type.equals(SearchType.FIRST)) {
                    result = mid;
                    high = mid-1;
                } else {
                    result = mid;
                    low = mid+1;
                }
            }
            else if (arr.get(mid) > val) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public int binarySearchRotated(List<Integer> arr, int val) {
        int low = 0;
        int high = arr.size();
        while(low <= high) {
            int mid = (low + high) >> 1;
            if (arr.get(mid) == val) return mid;
            if(arr.get(mid) <= arr.get(high)) {
                if(val > arr.get(mid) && val <= arr.get(high)) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else if (arr.get(mid) >= arr.get(low)) {
                if(val > arr.get(low) && val <= arr.get(mid)) {
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Integer> data = Arrays.asList(input.split(" "))
                                            .stream()
                                            .map(x -> Integer.parseInt(x))
                                            .collect(Collectors.toList());
        System.out.println(data);
        BinarySearchImpl solution = new BinarySearchImpl();
        input = br.readLine();
        int q = Integer.parseInt(input);
        while (q-- > 0) {
            input = br.readLine();
            int answer = solution.binarySearch(data, Integer.parseInt(input), SearchType.FIRST);
            System.out.println("answer " + answer);
        }
    }
}