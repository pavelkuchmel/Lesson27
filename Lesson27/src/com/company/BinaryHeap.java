package com.company;
import java.util.*;

public class BinaryHeap<T extends Comparable<T>> {
        public BinaryHeap(){
            elements = new ArrayList<>();
        }
        public BinaryHeap(T[] array){
            elements = new ArrayList<>(Arrays.asList(array)); //через утилитный класс Arrays преобразуем массив в коллекцию
            for (int i = elements.size() / 2 - 1; i >= 0; --i){
                siftDown(i);
            }
        }
        public List<T> getElements(){
            return new ArrayList<>(elements);
        }
        public T extractMax(){
            if (!isEmpty()) {
                T result = elements.get(0);
                Collections.swap(elements, 0, elements.size());
                elements.remove(elements.size() - 1);
                if (elements.size() > 1) {
                    siftDown(0);
                }
                return result;
            }
            return null;
        }
        public void add(User element){
            elements.add((T) element);
            siftUp(elements.size() - 1);
        }
        public boolean isEmpty(){ return elements.size() == 0; }
        private void siftUp(int num){
            while (num > 0) {
                int parent = (num - 1) / 2;
                if (elements.get(num).compareTo(elements.get(parent)) < 0){
                    return;
                }
                Collections.swap(elements, num, parent);
                num = parent;
            }
        }
        private void siftDown(int num){
            int left = 2 * num + 1;
            int right = 2 * num + 2;

            int largest = num;
            if (left < elements.size() && elements.get(left).compareTo(elements.get(num)) > 0){
                largest = left;
            }
            if (left < elements.size() && elements.get(right).compareTo(elements.get(largest)) > 0){
                largest = right;
            }
            if (largest != num){
                Collections.swap(elements, num, largest);
                siftDown(largest);
            }
        }
        private ArrayList<T> elements;
    }

