import java.util.*;
public class Rotation {

	public static void reverse(int[] arr, int a, int b){
		while(b > a){
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
			a++;
			b--;
		}
	}
	public static void print(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}
//	public static void SortedPairSum(int[] arr, int n){
//		int[] ans = new int[2];
//	int min = Integer.MAX_VALUE;
//	int pos = 0;
//	for(int i=0; i<arr.length; i++){
//		if(arr[i] < min){
//			min = arr[i];
//			pos = i;
//		}
//	}
//	int max = arr[pos-1];
//	while(max != min){
//		if(max + min > n){
//			max = max-1;
//		}
//	}
//		
//		
//	}
	public static double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        long max = Long.MIN_VALUE;
        
        for(int i = 0; i<=nums.length - k; i++){
            sum = 0;
            
            for(int j=i; j<k; j++){
              sum = sum + nums[j];  
            }
            
            max = Math.max(max, sum);
        }
        return (double)max/(double)k;
    }
//	public static int minElement(int[] arr, int a, int b){
//		int min = 0;
//		int mid = (b-a)/2;
//		if(a == b){
//			 min = arr[a];
//		}
//		
//		else if(arr[mid] < arr[a]){
//			min = minElement(arr,a,mid);
//		}else{
//			 min = minElement(arr,a+1+mid,b);
//		}
//		
//		return min;
//	}
	
	public static int[] reArrange(int[] arr){
		int n = arr.length;
		int j = 0;
		int pivot = 0;
		for(int i=0; i<n;i++){
			if(arr[i] < pivot){
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j++;
			}
			
		}
		
		for(int k=0; k<j & arr[k]<0; k=k+2){
			int temp = arr[j];
			arr[j] = arr[k];
			arr[k] = temp;
			j++;
		}
		
		
		return arr;
	}
	public static int[] sortInWave(int[] arr){
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length-1; i=i+2){
			int temp = arr[i+1];
			arr[i+1] = arr[i];
			arr[i] = temp;
			
		}
		
		return arr;
	}
	public static void reArrange(int[] arr, int x){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<arr.length; i++){
			map.put(arr[i], Math.abs(arr[i] - x));
		}
		
	}
	public static void arrangeFrom(int[] arr, int start, int end){
		int j = 0;
		int k = arr.length-1;
		for(int i=0; i< arr.length; i++){
			if(arr[i] <= start){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
			else if(arr[i] >= end){
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
				k--;
			}
		}
	}
	// new concept ****** check
	public static void sortedSequenceOf3(int[] arr){
		int[] smaller = new int[arr.length];
		int[] larger = new int[arr.length];
		int min = 0;
		int max = arr.length - 1;
		smaller[0] = -1;
		for(int i=1; i<arr.length; i++){
			if(arr[i] < arr[min]){
				min = i;
				smaller[i] = -1;
			}else{
				smaller[i] = min;
			}
		}
		larger[arr.length-1] = -1;
		for(int i=arr.length-2; i >=0; i--){
			if(arr[i] > arr[max]){
				max = i;
				larger[i] = -1;
			}
			else{
				larger[i] = max;
			}
		}
		for(int i=0; i<arr.length; i++){
			if(smaller[i] != -1 && larger[i] != -1){
				System.out.println(smaller[i] + ", "+ arr[i] + ", "+ larger[i]);
				break;
			}
		}
		
		
	}
	
	public static int maxSumOfDiff(int[] arr){
		int sum = 0;
		int n = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < n/2; i++)
        {
            sum -= (2 * arr[i]);
            sum += (2 * arr[n - i - 1]);
        }
		
		return sum;
	}
	
	public static void maxSubArrayOf01(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int maxLen = 0;
		int endIndex = -1;
		
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 0){
				arr[i] = -1;
			}else{
				arr[i] = 1;
			}
		}
		
		for(int i=0; i<arr.length; i++){
			sum = sum + arr[i];
			
			if(sum == 0){
				
				maxLen = i+1;
				endIndex = i;
				
			}
			
			if(map.containsKey(sum)){
				if(maxLen < i - map.get(sum + arr.length)){
					maxLen = i - map.get(sum + arr.length);
					endIndex = i;
				}
				
			}else{
				map.put(sum + arr.length,i); //here we add arr length as sum can be 0 or -1 which can be initially assigned or default values of hash table
			}
		}
		for (int i = 0; i < arr.length; i++) 
        {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

		int start = endIndex - maxLen + 1;
		System.out.println("Max sub array is from "+start+" to "+endIndex);
		
		
	}
	
	public static int[] nextGreatest(int[] arr){
		
		int[] ans = new int[arr.length];
		ans[ans.length-1] = -1;
		int max = arr[arr.length-1];
		for(int i = arr.length-2; i>=0; i--){
			max = Math.max(max, arr[i+1]);
			ans[i] = max;
		}
		return ans;
	}
	
	public static int MaxArray(int[] arr){
		int sum = 0;
		int max = 0;
		for(int i=1; i<arr.length; i++){
			sum = sum + arr[i];
			if(sum < 0){
				sum = 0;
			}
			if(sum > max){
				max = sum;
			}
		}
		return max;
	}
	public static int MaxProduct(int[] arr){
		int product = 1;
		int max = 1;
		int product2 = 1;
		for(int i=0; i<arr.length; i++){
			max = Math.max(max, product);
			if(arr[i] < 0){
				product2 = product2 * arr[i];
				product = 1;
			}
			else{	
			product = product * arr[i];
		}}
		
		
		return product;
	}
	
	public static void freqSort(int[] arr){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int count = 1;
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
			 map.put(arr[i], map.get(arr[i]) + 1);
			}else{
				map.put(arr[i], count);
			}
		}
		// Have to comlete --- read about entryset
	}
	public static void modify(int[] arr){
		int prev = arr[0];
		arr[0] = arr[0] * arr[1];
		for(int i=1; i<arr.length-1; i++){
			int x = prev * arr[i+1];
			prev = arr[i];
			arr[i] = x;
		}
		arr[arr.length-1] = prev * arr[arr.length-1];
	}
	
	public static int maxSumonRot(int[] arr){
		int sum = 0;
		int max = 0;
		int maxSum = 0;
		for(int i=0; i<arr.length; i++){
			sum = sum + arr[i];
			max = max + arr[i]*i;
		}
		maxSum = Math.max(max, maxSum);
		for(int i=arr.length-1; i>=0; i--){
			max = max + sum - (arr[i]*arr.length);
			maxSum = Math.max(maxSum, max);
		}
		return maxSum;
	}
	public static void main(String[] args){
	int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	reverse(arr,0,arr.length-n-1);
	reverse(arr,arr.length-n,arr.length-1);
	reverse(arr,0,arr.length-1);
	print(arr);
	double x = findMaxAverage(arr, 4);
	System.out.println(x);
//	int min = minElement(arr,0,arr.length-1);
//	System.out.println("\n" + min);
	int[] res = reArrange(arr);
	print(res);
	int[] res1 = sortInWave(arr);
	print(res1);
	int[] arr1 = {7,4,8,2,6,1,9,4,2,2,5,10,15,14,18};
	arrangeFrom(arr1,5,10);
	print(arr1);
	sortedSequenceOf3(arr1);
	int[] arr2 = {10,12,15};
	System.out.println(maxSumOfDiff(arr2));
	int[] arr3 = {1,0,1,0,1,1,0};
	maxSubArrayOf01(arr3);
	int[] arr4 = {16, 17, 4, 3, 5, 2};
	print(nextGreatest(arr4));
	int[] arr5 = {-3,-5,-1,-2};
	System.out.println(MaxArray(arr5));
	int[] arr6 = {2, 3, 4, 5, 6};
	modify(arr6);
	print(arr6);
	int[] arr7 = {8,3,1,2};
	System.out.println(maxSumonRot(arr7));
}
}
