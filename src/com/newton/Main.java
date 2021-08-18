package com.newton;

import com.newton.resources.ArrayHeap;

public class Main {

    public static void main(String[] args) {
        ArrayHeap heap = new ArrayHeap(10);

        System.out.println("isEmpty? " + heap.isEmpty());
        System.out.println("size " + heap.size());
        System.out.println("min " + heap.min());

        heap.insert(2);
        heap.insert(5);
        heap.insert(6);
        heap.insert(9);
        heap.insert(7);
        heap.insert(8);
        heap.insert(10);
        heap.insert(4);

        heap.print();

        System.out.println("isEmpty? " + heap.isEmpty());
        System.out.println("size " + heap.size());
        System.out.println("min " + heap.min());

        heap.removeMin();
    }
}
