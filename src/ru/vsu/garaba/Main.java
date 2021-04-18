package ru.vsu.garaba;

public class Main {

    public static void main(String[] args) throws Exception {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);

        SimpleLinkedList.solution(list);

        for (int i = 0; i < list.getCount(); i++) {
            System.out.println(list.get(i));
        }
//        SimpleLinkedList<String> list = new SimpleLinkedList<>();
//        list.addFirst("two");
//        list.addLast("three");
//        list.addFirst("one");
//
//        System.out.printf("first: %s%n", list.getFirst());
//        System.out.printf("last: %s%n", list.getLast());
//        System.out.printf("[1]: %s%n", list.get(1));
//        System.out.printf("count: %d%n", list.getCount());
//
//        System.out.println("--------------");
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        list.removeLast();
//        System.out.println("--------------");
//        for (String s : list) {
//            System.out.println(s);
//        }
    }
}
