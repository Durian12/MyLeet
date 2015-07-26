package period1;

public class SolutionMaxProduct {
	public static int maxProduct(int[] a,int i,int j){
		int negativeCount=0;
		if(i>=j){
			if(j<0){
				return a[i];
			}
			return a[j];
		}
		int firstNegative=0;
		int lastNegative=0;
		for(int k=i;k<=j;k++){
			if(a[k]<0){
				negativeCount++;
				lastNegative=k;
				if(negativeCount==1){
					firstNegative=k;
				}
			}
			if(a[k]==0){
				int p1=maxProduct(a,i,k-1);
				int p2=maxProduct(a,k+1,j);
				if(p1<0&&p2<0){
					return 0;
				}
				else{
					return p1>p2?p1:p2;
				}
			}
		}
		if(negativeCount%2==0){
			int product=1;
			for(int k=i;k<=j;k++){
				product*=a[k];
			}
			return product;
		}
		else{
			int[] temp=new int[4];
			temp[0]=maxProduct(a,i,firstNegative-1);
			temp[1]=maxProduct(a,firstNegative+1,j);
			temp[2]=maxProduct(a,i,lastNegative-1);
			temp[3]=maxProduct(a,lastNegative+1,j);
			int max=temp[0];
			for(int m=0;m<temp.length;m++){
				if(temp[m]>max){
					max=temp[m];
				}
			}
			return max;
		}
	}
	public static int maxProduct(int[] a) {
		return maxProduct(a,0,a.length-1);
    }
	public static void main(String[] args){
		int[] a={-4,-3,-2};
		System.out.println(maxProduct(a));
	}
}
