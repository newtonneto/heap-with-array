package com.newton.tests;

import com.newton.exceptions.EmptyHeapExceptions;
import com.newton.resources.ArrayHeap;

public class Test {
    public void executeTest() {
        ArrayHeap heap = new ArrayHeap(3);

        System.out.println("isEmpty? " + heap.isEmpty());

        try {
            System.out.println("size " + heap.size());
        } catch (EmptyHeapExceptions e) {
            System.out.println(e);
        }

        try {
            System.out.println("min " + heap.min());
        } catch (EmptyHeapExceptions e) {
            System.out.println(e);
        }

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
        heap.removeMin();
        heap.removeMin();
        heap.removeMin();
        heap.removeMin();
        heap.removeMin();
        heap.removeMin();
        heap.removeMin();
        try {
            heap.removeMin();
        } catch (EmptyHeapExceptions e) {
            System.out.println(e);
        }
    }
}
