package com.riku.queue;

import java.util.ArrayList;
import java.util.List;

public class CircularQueue {
	private int[] queue;	
	private int pStart, pEnd, len;
	
	public CircularQueue(int k) {
		queue = new int[k];
		len = k;
		pStart = -1;
		pEnd = -1;
	}
	
	public int Front() {
		return queue[pStart];
	}
	
	public int Rear() {
		return queue[pEnd];
	}
	
	public boolean enQueue(int v) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            pStart = 0;
        }
        pEnd = (pEnd + 1) % len;
        queue[pEnd] = v;
        return true;
	}
	
	public boolean deQueue() {
		if(!isEmpty()) {
			pStart = (pStart + 1) % len;
			if (pStart == pEnd) {
				pStart = -1;
				pEnd   = -1;
			}
			return true;
		} 
		return false;
	}

	public boolean isEmpty() {
		return pEnd == -1;
	}
	
	public boolean isFull() {
		return (pEnd + 1) % len == pStart;
	}
	
	public static void main(String[] args) {
		CircularQueue circularQueue = new CircularQueue(3); // 设置长度�? 3
		circularQueue.enQueue(1); // 返回 true
		circularQueue.enQueue(2); // 返回 true
		circularQueue.enQueue(3); // 返回 true
		circularQueue.enQueue(4); // 返回 false，队列已�?
		circularQueue.Rear(); // 返回 3
		circularQueue.isFull(); // 返回 true
		circularQueue.deQueue(); // 返回 true
		circularQueue.enQueue(4); // 返回 true
		circularQueue.Rear(); // 返回 4
	}
}
