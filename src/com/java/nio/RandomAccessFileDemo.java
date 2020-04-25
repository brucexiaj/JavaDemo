package com.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



public class RandomAccessFileDemo {
	public static void main(String args[]) {
		String txtPath = System.getProperty("user.dir") + "/src/com/java/nio/rc.txt";
		try {
			RandomAccessFile rcf = new RandomAccessFile(txtPath, "rw");
			//创建通道
			FileChannel fileChannel = rcf.getChannel();
			//存放读入内容的变量
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			//读取内容
			int bytesCount = fileChannel.read(byteBuffer);
			//bytesCount = fileChannel.read(byteBuffer);
			while(-1 != bytesCount) {
				byteBuffer.flip(); //position回到0
				while(byteBuffer.hasRemaining()) {
					System.out.println((char)byteBuffer.get());
				}
				byteBuffer.compact(); //将从position开始的byte拷贝到初始位置
				bytesCount = fileChannel.read(byteBuffer);
			}
			//System.out.println(byteBuffer.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
