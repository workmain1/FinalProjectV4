package com.example.finalprojectv2;


public class CustomLinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) head = newNode;
        else {
            Node<T> current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
    }

    public boolean remove(T data) {
        if (head == null) return false;
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data))
            current = current.next;
        if (current.next == null) return false;
        current.next = current.next.next;
        return true;
    }

    public Node<T> find(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) return current;
            current = current.next;
        }
        return null;
    }


}

