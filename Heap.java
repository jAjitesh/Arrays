
public class Heap {

	public static void maxHeapify(int[] arr, int i){
		int left = 2*i;
		int right = 2*i+1;
		int largest = 0;
		if(left < arr.length && arr[left] > arr[i]){
			largest = left;
		}else{
			largest = i;
		}
		if(right < arr.length && arr[right] > arr[largest]){
			largest = right;
		}
		if(largest != i){
		int temp = arr[largest];
		arr[largest] = arr[i];
		arr[i] = temp;
		maxHeapify(arr,largest);
		}
	}
	
	public static void buildHeap(int[] arr){
		for(int i=arr.length/2; i >= 0 ; i--){
			maxHeapify(arr,i);
		}
	}
	public static int getMax(int[] arr){
		buildHeap(arr);
		return arr[0];
	}
	
	public static int getMaxAndUpdate(int[] arr){
		buildHeap(arr);
		int max = arr[0];
		int temp = arr[0];
		arr[0] = arr[arr.length-1];
		arr[arr.length-1] = temp;
		arr[arr.length-1] = 0;
		maxHeapify(arr,0);
		return max;
	}
	
	public static int[] heapSort(int[] arr){
		buildHeap(arr);
		int[] res = new int[arr.length];
		int j=0;
		for(int i=0; i<arr.length; i++){
			res[j] = getMaxAndUpdate(arr);
			j++;
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] arr = {5,3,4,7,1,2,9};
//		buildHeap(arr);
//		getMaxAndUpdate(arr);
//		getMaxAndUpdate(arr);
//		getMaxAndUpdate(arr);
		int[] res = heapSort(arr);
		for(int i=0; i<res.length; i++){
			System.out.print(res[i]+" ");
		}
	}
}
