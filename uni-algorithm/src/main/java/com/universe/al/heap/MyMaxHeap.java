package com.universe.al.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 */
public class MyMaxHeap {

    /** 用数组实现堆，list不用处理扩容*/
    private List<Integer> maxHeap;

    public MyMaxHeap(int capacity, List<Integer> vals) {
        maxHeap = new ArrayList<>(capacity);
        vals.forEach(this::push);
    }

    public MyMaxHeap(List<Integer> vals) {
        maxHeap = new ArrayList<>();
        for (int i = parent(size()-1); i >= 0; i--) {
            siftDown(i);
        }
    }



    /**给定索引 i ，
     * 其左子节点索引为 2i + 1 ，
     * 右子节点索引为 2i + 2 ，
     * 父节点索引为 (i - 1) / 2（向下取整）。
     * 当索引越界时，表示空节点或节点不存在。*/

    /** 左子节点索引 */
    private int left(int i) {
        return 2 * i + 1;
    }

    /** 右子节点索引 */
    private int right(int i) {
        return 2 * i + 2;
    }

    /** 父节点索引 */
    private int parent(int i) {
        return (i -1) / 2;
    }

    /** 栈顶元素 */
    public int peek() {
        return maxHeap.get(0);
    }

    public int size() {
        return maxHeap.size();
    }

    /**堆化：新元素到堆底，循环与父元素对比，交换位置；至栈顶，或小于父元素停止*/
    /** 入堆 */
    public void push(int val) {
        maxHeap.add(val);

        siftUp(size() - 1 );
    }

    private void siftUp(int i) {
        while (true) {
            int parent = parent(i);
            if (parent < 0 || maxHeap.get(i) <= maxHeap.get(parent)) {
                break;
            }
            swap(i,parent);
            i = parent;
        }
    }

    private void swap(int i, int parent) {
        int temp = maxHeap.get(i);
        maxHeap.set(i,maxHeap.get(parent));
        maxHeap.set(parent,temp);
    }

    /** 交互堆顶 与 堆底最右元素；删除堆底（原堆顶）；从顶至底堆化（循环对比，交换）*/
    public int pop(){
        if (maxHeap.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        swap(0,size() - 1);
        Integer top = maxHeap.remove(size() - 1);
        siftDown(0);
        return top;
    }

    /**从顶至底堆化：对比左右节点，最大的为父节点，与其交互位置；*/
    private void siftDown(int i) {
        while (true) {
            int left = left(i);
            int right = right(i);
            int max = i;
            /** 对比左右子节点找最大 */
            if (left < size() && maxHeap.get(left) > maxHeap.get(max)) {
                max = left;
            }
            if (right < size() && maxHeap.get(right) > maxHeap.get(max)) {
                max = right;
            }
            /**自己最大，结束*/
            if (max == i) {
                break;
            }
            /**自己和最大的交互*/
            swap(i,max);
            /** 给自己赋值，交换后的索引位置，继续循环*/
            i = max;
        }
    }


    public static void main(String[] args) {

    }
}
