package com.newton.interfaces;

public interface IArrayHeap {
    void insert(Integer element);
    void upHeap(Integer index);
    Integer removeMin();
    void downHeap(Integer index);
    Integer size();
    Boolean isEmpty();
    Integer min();
    void print();
}
