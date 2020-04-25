package com.java.temp;

import java.util.Scanner;

public class Main {
	public static int c(int t,int d,int x,int n,int res[],int i,int timeadd) {	
		int currentfish = (d+timeadd) / t;//已经考好的鱼
		 if(currentfish >=n) {
			 res[i] = 2*d+x * (i+1);
		 }else {//没考好
				//是等所有的，还是回去吃部分？
				int min = Integer.MAX_VALUE;
				//等几条鱼好了？？
				//t = 20, d=61, x = 1, n = 4
				//123
				//124
				//125
				//80+61+4=145
				//61+61+3+
				
				for(int dengfish = currentfish;dengfish <=n;dengfish++) {
					int times=0;
					if (dengfish == currentfish) {
						int xiao = d < dengfish * t ? d : dengfish * t;
						times = xiao + d + x * dengfish + res[n-dengfish-1];
					} else {
						int a = t * dengfish + d + x * dengfish;
						times = a + c(t, d, x, n, res, n-dengfish-1, a-dengfish*t);
					}
					
					min = times< min?times:min;
				}
				res[i] = min;
				
			}
		 return res[i];
		
	}
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int d = scanner.nextInt();
		int x = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.close();
//		System.out.println(t);
//		System.out.println(d);
//		System.out.println(x);
//		System.out.println(n);
		
		int res[] = new int[n];
		c(t, d, x, n, res, n-1, 0);
		
		for(int i =0;i<n-1;i++) {
			System.out.println(res[i]);
		}
		System.out.print(res[n-1]);
	}
}
