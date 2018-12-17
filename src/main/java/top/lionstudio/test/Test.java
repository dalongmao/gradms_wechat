package top.lionstudio.test;

public class Test {

	public static void main(String[] args) {
		int nums[]= {3,1,2,0,4,4,5};
		int cur=0;
		for(int i=0;i<=5;i++) 
			cur=cur^i;
		for(int c:nums) 
			cur=cur^c;
		System.out.println(cur);

	}

}
