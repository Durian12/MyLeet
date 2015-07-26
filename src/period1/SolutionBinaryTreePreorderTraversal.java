package period1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class SolutionBinaryTreePreorderTraversal {
	public static TreeNode buildTree(String[] a){
		TreeNode[] arrTn=new TreeNode[a.length];
		for(int i=0;i<a.length;i++){
			if(a[i]=="#"){
				arrTn[i]=null;
			}
			else{
				arrTn[i]=new TreeNode(Integer.parseInt(a[i]));
			}
		}
		for(int i=0;i<arrTn.length;i++){
			if(arrTn[i]!=null){
				if((2*i+1)<arrTn.length){
					arrTn[i].left=arrTn[i+1];
				}
				if((2*i+2)<arrTn.length){
					arrTn[i].right=arrTn[i+2];
				}
			}
		}
		return arrTn[0];
	}
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result=new LinkedList<Integer>();
		if(root==null){
			;
		}
		else if(root.left==null&&root.right==null){
			result.add(root.val);
		}
		else{
			result.add(root.val);
			result.addAll(preorderTraversal(root.left));
			result.addAll(preorderTraversal(root.right));
		}
		return result;
		/*
		Stack<TreeNode> nodeStack=new Stack<TreeNode>();
		TreeNode nodeTemp=root;
		while(nodeTemp!=null){
			result.add(nodeTemp.val);
			nodeStack.push(nodeTemp);
			if(nodeTemp.left!=null){
				nodeTemp=nodeTemp.left;
			}
			else if(nodeTemp.right!=null){
				nodeTemp=nodeTemp.right;
			}
			else{
				
			}
		}
		*/
	}
	public static void main(String[] args){
		String[] sa={"1","#","2","3","4"};
		TreeNode root=buildTree(sa);
		List<Integer> pre=preorderTraversal(root);
		for(int i=0;i<pre.size();i++){
			System.out.println(pre.get(i));
		}
	}
}
