package com.newton.interfaces;

import com.newton.exceptions.EmptyHeapExceptions;

public interface IArrayHeap {
    void insert(Integer element);
    void upHeap(Integer index);
    Integer removeMin() throws EmptyHeapExceptions;
    void downHeap(Integer index);
    Integer size();
    Boolean isEmpty();
    Integer min() throws EmptyHeapExceptions;
    void print();
    void resize();
}
