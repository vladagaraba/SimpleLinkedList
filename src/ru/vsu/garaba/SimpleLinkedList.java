package ru.vsu.garaba;

import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable<T> {

    private static class ListNode<T> {
        public T value;
        public ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }
        public ListNode(T value) {
            this(value, null);
        }
        public ListNode() {
            this(null);
        }
    }

    private ListNode<T> head = null;
    private ListNode<T> tail = null;

    private int count = 0;

    public void addFirst(T value) {
        head = new ListNode<>(value, head);
        if (count == 0) {
            tail = head;
        }
        count++;
    }

    public void addLast(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        if (count > 0) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        count++;
    }

    private void emptyError() throws Exception {
        if (count == 0) {
            throw new Exception("List is empty");
        }
    }

    public void indexError(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new Exception("Wrong index");
        }
    }

    public T getFirst() throws Exception {
        emptyError();
        return head.value;
    }

    public T getLast() throws Exception {
        emptyError();
        return tail.value;
    }

    public int getCount() {
        return count;
    }

    private ListNode<T> getNode(int index) throws Exception {
        indexError(index);
        ListNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }


    public T get(int index) throws Exception {
        return getNode(index).value;
    }

    public void removeFirst() throws Exception {
        emptyError();
        head = head.next;
        count--;
        if (count == 0) {
            tail = null;
        }
    }

    public void removeLast() throws Exception {
        emptyError();
        count--;
        if (count == 0) {
            head = tail = null;
        } else {
            tail = getNode(count - 1);
            tail.next = null;
        }
    }

    public Object removeByIndex(int index) throws Exception {
        emptyError();
        indexError(index);

        ListNode temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Object removable = temp.next.value;
        temp.next = temp.next.next;
        count--;
        return removable;
    }

    public static void solution(SimpleLinkedList <Integer> list) throws Exception {
        ListNode temp = list.head;
        Integer tempint;
        for (int i = 0; i < list.count; i++) {
            if(temp.next == null) break;
            tempint = (Integer)temp.value + (Integer)temp.next.value;
            temp.value = tempint;
            list.removeByIndex(i + 1);
            temp = temp.next;
        }
    }

    public void clear() {
        head = tail = null;
        count = 0;
    }


    @Override
    public Iterator<T> iterator() {
        class LinkedListIterator implements Iterator<T> {
            ListNode<T> curr;

            public LinkedListIterator(ListNode<T> head) {
                curr = head;
            }

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T result = curr.value;
                curr = curr.next;
                return result;
            }
        }

        return new LinkedListIterator(head);
    }
}
