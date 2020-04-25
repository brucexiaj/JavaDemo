package com.alg.linearlist;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 使用LinkedHashMap实现的LRU机制
 * LeetCode-146：https://leetcode-cn.com/problems/lru-cache/
 * @author brucexia
 * @date 25th, April, 2020
 *
 */

public class LRUCache {
	private int capacity;
	private LinkedHashMap<Integer, Integer> lhm;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		lhm = new LinkedHashMap<Integer, Integer>(2 * capacity, (float)0.75, true);
    }
    
    public int get(int key) {
    	return lhm.get(key) == null ? -1 : lhm.get(key);
    }
    
    public void put(int key, int value) {
    	if(lhm.size() >= capacity) {
    		//取出最久没有使用的元素，并且干掉它
    		/*** 这种遍历方式太复杂，不推荐采用
    		Set<Entry<Integer, Integer>> set = lhm.entrySet();
    		Iterator<Entry<Integer, Integer>> iterator = set.iterator();
            while(iterator.hasNext()) {
                Entry entry = iterator.next();
                lhm.remove((Integer) entry.getKey());
                break;
            }
            ***/
    		for(Integer k:lhm.keySet()) {
    			lhm.remove(k);
    			break;
    		}
            //加入新元素
            lhm.put(key, value);
    	} else {
    		lhm.put(key, value);
    	}
    }
    
    public static void main(String as[]) {
    	LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // 返回  1
    	cache.put(3, 3);    // 该操作会使得密钥 2 作废
    	System.out.println(cache.get(2));       // 返回 -1 (未找到)
    	cache.put(4, 4);    // 该操作会使得密钥 1 作废
    	System.out.println(cache.get(1));       // 返回 -1 (未找到)
    	System.out.println(cache.get(3));       // 返回  3
    	System.out.println(cache.get(4));       // 返回  4

    	
    }
    
    
    
}
