import java.util.*;

public class OrderSatistics {
	
	public static int partition(int[] arr,int p, int r){
		int j = p;
		int pivot = arr[p];
		for(int i=p+1; i<=r; i++){
		if(arr[i] < pivot){
			j++;
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
		}
		int temp = arr[p];
		arr[p] = arr[j];
		arr[j] = temp;
		return j;
	
	}
	public static int randomPartition(int[] arr, int p, int r){
		int n = r-p+1;
		int pivot = (int)(Math.random())%n;
		int temp = arr[p+pivot];
		arr[p+pivot] = arr[p];
		arr[p] = temp;
		int q = partition(arr,p,r);
		return q;
	}
	
	public static int kthSmallest(int[] arr, int k, int p, int r){
		int q = randomPartition(arr,p,r);
		if(q+1 == k){
			return arr[q];
		}else if(q+1 > k){
			return kthSmallest( arr, k, 0, q-1);
		}else{
			return kthSmallest( arr, k, q+1, r);
		}
	}
	
	public static int largestPairSum(int[] arr){
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for(int i = 0; i< arr.length; i++){
			if(arr[i] >= max1){
				max2 = max1;
				max1 = arr[i];
			}
			else if(arr[i] > max2){
				max2 = arr[i];
			}
		}
		return max1+max2;
	}
	
	public static void kMostOccurances(int[] arr, int k){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}else{
				map.put(arr[i], 1);
			}
		}
		int[] arr1 = new int[arr.length];
		int i=0;
		for(int key: map.values()){
			arr1[i] = key;
			i++;
		}
		Arrays.sort(arr1);
		for(int j=0; j<k; j++){
			System.out.println(map.get(arr1[j]));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,6,1,2,5,3,8};
//		partition(arr,0,6);
//		for(int i=0; i<arr.length; i++){
//			System.out.print(arr[i]+" ");
//		}
		
//		System.out.println("\n"+kthSmallest(arr,5,0,arr.length-1));
//		System.out.println(largestPairSum(arr));
		int[] arr2 = {3, 1, 4, 4, 5, 2, 6, 1};
		kMostOccurances(arr2, 2);
		
	}

}
