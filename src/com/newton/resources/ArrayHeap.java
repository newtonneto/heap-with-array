package com.newton.resources;

import com.newton.exceptions.EmptyHeapExceptions;
import com.newton.interfaces.IArrayHeap;

public class ArrayHeap implements IArrayHeap {
    private Integer capacity;
    private Integer[] heap;
    private Integer next_space;

    public ArrayHeap(Integer capacity) {
        this.capacity = capacity;
        this.heap = new Integer[this.capacity];
        this.next_space = 1;
    }

    @Override
    public void insert(Integer element) {
        if (this.next_space >= this.capacity) {
            System.out.println("Allocating more space...");
            this.resize();
        } {
            this.heap[this.next_space] = element;
            // Verifica se o elemento inserido precisa ser realocado
            upHeap(this.next_space);
            this.next_space++;
        }
    }

    @Override
    public void upHeap(Integer index) {
        // O pai do elemente inserido sempre será seu indice dividido por 2, caso o resultado seja
        // fracionado, considerar apenas a parte inteira
        Integer father_index = index / 2;

        // O indice do pai tem que ser maior que zero, pois a raiz é o indice 1
        if (father_index > 0 ) {
            //Se o valor do index for menor que o valor do seu pai, realizar troca
            if (this.heap[index] < this.heap[father_index]) {
                Integer temporary_storage = this.heap[father_index];
                this.heap[father_index] = this.heap[index];
                this.heap[index] = temporary_storage;

                upHeap(father_index);
            }
        }
    }

    @Override
    public Integer removeMin() throws EmptyHeapExceptions {
        if (this.isEmpty()) {
            throw new EmptyHeapExceptions("removeMin(): Empty Heap");
        }

        System.out.println("Estado atual da heap: ");
        this.print();

        Integer min = this.min();
        // Substitui o primeiro elemento pelo ultimo
        this.heap[1] = this.heap[this.next_space - 1];
        // Remove o conteudo do ultimo indice utilizado
        this.heap[this.next_space - 1] = null;
        // O indice limpo será o proximo espaço vago
        this.next_space--;

        System.out.println("Primeira remoção: ");
        this.print();

        // Reordena a heap
        downHeap(1);

        return min;
    }

    @Override
    public void downHeap(Integer index) {
        // Verica se o indice passado é valido
        if ((2 * index) < this.next_space && (2 * index + 1) < this.next_space) {
            // Verifica qual o menor dos dois filhos
            if (this.heap[2 * index] < this.heap[2 * index + 1]) { // O filho esquerdo é menor
                // Verifica se o indice atual é maior que o seu filho esquerdo
                if (this.heap[index] > this.heap[2 * index]) {
                    Integer temporary_storage = this.heap[index];
                    this.heap[index] = this.heap[2 * index];
                    this.heap[2 * index] = temporary_storage;

                    System.out.println("Down Heap: ");
                    this.print();

                    downHeap(2 * index);
                }
            } else { // O filho direito é menor
                // Verifica se o indice atual é maior que o seu filho direito
                if (this.heap[index] > this.heap[2 * index + 1]) {
                    Integer temporary_storage = this.heap[index];
                    this.heap[index] = this.heap[2 * index + 1];
                    this.heap[2 * index + 1] = temporary_storage;

                    System.out.println("Down Heap: ");
                    this.print();

                    downHeap(2 * index + 1);
                }
            }
        }
    }

    @Override
    public Integer size() {
        return this.next_space - 1;
    }

    @Override
    public Boolean isEmpty() {
        return (this.heap[1] == null);
    }

    @Override
    public Integer min() throws EmptyHeapExceptions {
        if (this.isEmpty()) {
            throw new EmptyHeapExceptions("min(): Empty Heap");
        }

        return this.heap[1];
    }

    @Override
    public void print() {
        for (int index = 1; index < this.next_space; index++) {
            System.out.print(this.heap[index] + " ");
        }
        System.out.println("");
    }

    @Override
    public void resize() {
        Integer[] resized_heap = new Integer[this.capacity * 2];

        for (Integer index = 1; index < this.next_space; index++) {
            resized_heap[index] = this.heap[index];
        }

        this.capacity = this.capacity * 2;
        this.heap = resized_heap;
    }


}
