package period1;

public class SolutionReversWords {
	public static String reverseWords(String s) {
        String[] sT=s.split(" ");
        StringBuilder stringB=new StringBuilder();
        for(int i=sT.length-1;i>=0;i--){
        	if(sT[i].equals("")){
        		;
        	}
        	else if(i!=sT.length-1){
        		stringB.append(" ");
        	}
        	stringB.append(sT[i]);
        }
        return stringB.toString();
    }
	public static void main(String[] args){
		String s = " 1";
		System.out.println("!!"+reverseWords(s)+"!!");
	}
}
