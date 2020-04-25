package com.jvm.classoom;

import java.util.List;
import java.util.ArrayList;
/**
 * 模拟jvm堆内存溢出
 * 最后输出：java.lang.OutOfMemoryError: Java heap space
 * @author brucexia
 *
 */
public class HeapAreaOOM {
	public static void main(final String[] args) {
		List<HeapAreaOOM> list = new ArrayList<HeapAreaOOM>();
        while (true) {
             list.add(new HeapAreaOOM());
        }
	}
}
