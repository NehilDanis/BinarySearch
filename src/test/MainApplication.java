package test;

import java.util.List;
import java.util.ArrayList;

public class MainApplication {

	public static void main(String[] args) {
		String [] a={"Michelle","Jaime","Rachael","Jon","Jesse","Joe","Raquel"
				,"Jennifer","Lorraine","Lora","Tony","Melissa","Rachel","Tom"};
		List<String> alist=new ArrayList<String>();
		for(int i=0;i<a.length;i++){
			alist.add(a[i]);
		}
		System.out.println("------------");
		sort(alist, 0, alist.size()-1);
		for(int i=0;i<a.length;i++){
			System.out.print(alist.get(i)+"  ");
		}
		
//		System.out.println(BinarySearch(alist, "To"));
		int mid=BinarySearch(alist, "To");
		linearSearch(alist, "To", mid);
		
	}
	
	private static int BinarySearch(List<String> a,String cmp){
		int lo = 0;
        int hi = a.size() - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            String array=a.get(mid);
            array=array.substring(0, cmp.length());
            if      (compareTo(cmp, array)<0) hi = mid - 1;
            else if (compareTo(cmp, array)>0) lo = mid + 1;
            else return mid;
        }
        return -1;
	}
	
	private static void linearSearch(List<String> a,String cmp,int index){
		if(index-1<0 || index+1>a.size()){
			System.out.println(a.get(index));
			return;
		}
		else{
			String array=a.get(index-1);
	        array=array.substring(0, cmp.length());
	        
	        String array1=a.get(index+1);
	        array1=array1.substring(0, cmp.length());
	        
	        if(array.equalsIgnoreCase(cmp)){
	        	while(index>=0){
	        		String a1=a.get(index);
	        		a1=a1.substring(0, cmp.length());
	        		if(!a1.equalsIgnoreCase(cmp)){
	        			break;
	        		}
	        		System.out.println(a.get(index));
	        		index--;
	        	}
	        	
	        }
	        else if(array1.equalsIgnoreCase(cmp)){
	        	while(index<a.size()){
	        		String a1=a.get(index);
	        		a1=a1.substring(0, cmp.length());
	        		if(!a1.equalsIgnoreCase(cmp)){
	        			break;
	        		}
	        		System.out.println(a.get(index));
	        		index++;
	        	}
	        	
	        }
			
		}
	}


	private static int compareTo(String cmp, String array){
		if(cmp.compareToIgnoreCase(array)<0)return -1;
		else if(cmp.compareToIgnoreCase(array)>0)return 1;
		return 0;
		
	}
	
	private static void sort(List<String> a, int lo, int hi)
	{
	 if (hi <= lo) return;
	 int lt = lo, gt = hi;
	 String v = a.get(lo);
	 int i = lo;
	 while (i <= gt)
	 {
	 int cmp = a.get(i).compareTo(v);
	 if (cmp < 0) exch(a, lt++, i++);
	 else if (cmp > 0) exch(a, i, gt--);
	 else i++;
	 }
	 sort(a, lo, lt - 1);
	 sort(a, gt + 1, hi);
	} 

	private static void exch(List<String> a, int i, int j){
		
		String x=a.get(i);
		String y=a.get(j);
		a.set(i, y);
		a.set(j, x);
		
	}
}
