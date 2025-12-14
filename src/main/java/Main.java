import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] a = { 3, 1, 3, 4, 5, 6 };
        int[] b = { 3, 4, 5, 7, 8, 9, 11, 5, 13, 17 };
        int[] c = { 5, 3, 8, 2, 9 };
        Node<Integer> head = build_List(a);
        Node<Integer> h = build_List(b);
        Node<Integer> l = build_List(c);
        // print_list(head);
        // print_list_recursive(head);
        // System.out.println(only_positives());
        // print_evens(head);
        // System.out.println(check_number(head, 5));
        // System.out.println(check_number_tail_recursive(head, 6));
        // System.out.println(deli(head, 1));
        // System.out.println(del(head, 1));
        // System.out.println(all(head, h));
        // ex_9(h, head);
        // System.out.println(ex_10(h, head));
        // System.out.println(ex_11(h, head));
        // System.out.println(ex_1(head, h));
        // Node<Integer> hh = ex_1(head, h);
        // System.out.println(ex_2(head));
        System.out.println(ex_3(l, 8));
        System.out.println(ex_4(l));
        System.out.println(ex_5(h));
    }

    public static Node<Integer> build_List(int[] a) { // ex1
        Node<Integer> p = new Node<>(a[0]);
        Node<Integer> head = p;

        for (int i = 1; i < a.length; i++) {
            Node<Integer> x = new Node<>(a[i]);
            p.setNext(x);
            p = p.getNext();
        }
        return head;
    }

    public static int sum_List(Node<Integer> head) {
        int a = 0;
        Node<Integer> x = head;
        while (x != null) {
            a += x.getValue();
            x = x.getNext();
        }
        return a;
    }

    public static void print_list(Node<Integer> head) { // ex2
        boolean value = true;
        while (value == true) {
            if (head != null) {
                System.out.println(head.getValue());
                head = head.getNext();
            } else
                value = false;

        }
    }

    public static void print_list_recursive(Node<Integer> head) { // ex2
        if (head != null) {
            System.out.println(head.getValue());
            print_list_recursive(head.getNext());
        }
    }

    public static Node<Integer> only_positives() { // ex3
        Node<Integer> head = new Node<>(null);
        Node<Integer> p = head;
        Scanner reader = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("Enter a positive number ");
            int x = reader.nextInt();
            if (x != -1) {
                p.setValue(x);
                p.setNext(new Node<>(null));
                p = p.getNext();
            } else
                b = false;

        }
        reader.close();
        return head;
    }

    public static void print_evens(Node<Integer> head) { // ex4
        while (head != null) {
            if (head.getValue() % 2 == 0)
                System.out.println(head.getValue());
            head = head.getNext();
        }
    }

    public static boolean check_number(Node<Integer> head, int n) { // ex5
        boolean check = false;
        while (head != null) {
            if (head.getValue() == n) {
                check = true;
                return check;
            }
            head = head.getNext();
        }
        return check;
    }

    public static boolean check_number_tail_recursive(Node<Integer> head, int n) { // ex5
        if (head == null)
            return false;
        if (head.getValue() == n)
            return true;
        else
            return check_number_tail_recursive(head.getNext(), n);
    }

    public static <T> Node<T> del(Node<T> p, T x) { // ex6
        Node<T> head = new Node<>(null, p);
        p = head;
        while (p.hasNext()) {
            if (p.getNext().getValue() == x) {
                p.setNext(p.getNext().getNext());
                break;
            } else
                p = p.getNext();
        }
        return head.getNext();
    }

    public static Node<Integer> deli(Node<Integer> p, int x) { // ex7
        if (x <= 0)
            return p;
        int i = 1;
        Node<Integer> h = new Node<>(null, p);
        Node<Integer> cur = h;
        while (cur.getNext() != null && i < x) {
            i++;
            cur = cur.getNext();
        }
        if (cur.getNext() != null)
            cur.setNext(cur.getNext().getNext());
        return h.getNext();
    }

    public static <T> boolean contains(Node<T> head, T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public static <T> boolean all(Node<T> l1, Node<T> l2) { // ex 8
        if (l1 == null)
            return true;
        if (!contains(l2, l1.getValue()))
            return false;
        return all(l1.getNext(), l2);
    }

    public static <T> void ex_9(Node<T> l1, Node<T> l2) {
        while (l1 != null) {
            if (contains(l2, l1.getValue()))
                System.out.println(l1.getValue());
            l1 = l1.getNext();
        }
    }

    public static <T> Node<T> ex_10(Node<T> l1, Node<T> l2) {
        Node<T> l3 = new Node<>(null);
        Node<T> l4 = l3;
        while (l1 != null) {
            if (contains(l2, l1.getValue())) {
                l4.setNext(new Node<>(l1.getValue()));
                l4 = l4.getNext();
            }
            l1 = l1.getNext();
        }
        return l3.getNext();
    }

    public static <T> Node<T> ex_11(Node<T> l1, Node<T> l2) {
        Node<T> l3 = new Node<>(null, l1);
        Node<T> cur = l3;
        while (cur.getNext() != null) {
            if (contains(l2, cur.getNext().getValue())) {
                cur = del(cur, cur.getNext().getValue());
            } else {
                cur = cur.getNext();
            }
        }
        return l3.getNext();
    }

    public static Node<Integer> ex_1(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> l3 = new Node<Integer>(null);
        Node<Integer> l4 = l3;
        while (l1 != null && l2 != null) {
            if (l1.getValue() <= l2.getValue()) {
                l3.setNext(l1);
                l1 = l1.getNext();
                l3 = l3.getNext();
                continue;
            }
            l3.setNext(l2);
            l2 = l2.getNext();
            l3 = l3.getNext();

        }
        if (l1 == null && l2 != null) {
            while (l2 != null) {
                l3.setNext(l2);
                l2 = l2.getNext();
                l3 = l3.getNext();
            }
        }
        if (l2 == null && l1 != null) {
            while (l1 != null) {
                l3.setNext(l1);
                l1 = l1.getNext();
                l3 = l3.getNext();
            }
        }
        return l4.getNext();
    }

    public static Node<Integer> ex_2(Node<Integer> head) {
        Node<Integer> l1 = new Node<>(null);
        Node<Integer> l2 = head;
        while (l2 != null) {
            Integer val = l2.getValue();
            if (val != null && val % 2 != 0) {
                Node<Integer> prev = l1;
                Node<Integer> p = l1.getNext();
                while (p != null && p.getValue() < val) {
                    prev = p;
                    p = p.getNext();
                }
                Node<Integer> node = new Node<>(val);
                prev.setNext(node);
                node.setNext(p);
            }
            l2 = l2.getNext();
        }
        return l1.getNext();
    }

    public static <T> Node<T> swap(Node<T> l1, int x, int y) {
        if (l1 == null || x == y || x <= 0 || y <= 0)
            return l1;
        Node<T> head = l1;
        Node<T> nodeX = null;
        Node<T> nodeY = null;
        int i = 1;
        Node<T> cur = head;
        while (cur != null && (nodeX == null || nodeY == null)) {
            if (i == x)
                nodeX = cur;
            if (i == y)
                nodeY = cur;
            cur = cur.getNext();
            i++;
        }
        if (nodeX != null && nodeY != null) {
            T tmp = nodeX.getValue();
            nodeX.setValue(nodeY.getValue());
            nodeY.setValue(tmp);
        }
        return head;
    }

    public static <T> int ex_3(Node<T> l, T x) { // O(n)
        int i = 0;
        int first = -1;
        int last = -1;
        Node<T> l2 = l;
        while (l2 != null) {
            if (l2.getValue() != null && Objects.equals(l2.getValue(), x)) {
                if (first == -1)
                    first = i;
                last = i;
            }
            i++;
            l2 = l2.getNext();
        }
        i--;
        if (first == -1)
            return 0;
        return i - last + first;
    }

    public static <T> boolean ex_4(Node<T> l) { // O(n²)
        Node<T> l2 = l;
        while (l2 != null) {
            Node<T> l3 = l2.getNext();
            while (l3 != null) {
                if (Objects.equals(l2.getValue(), l3.getValue()))
                    return false;
                l3 = l3.getNext();
            }
            l2 = l2.getNext();
        }
        return true;
    }

    public static <T> Node<T> ex_5(Node<T> l) {
        Node<T> l2 = new Node<T>(null);
        Node<T> l4 = l2;
        Node<T> l3 = l;
        while (l3 != null) {
            if (!contains(l2.getNext(), l3.getValue())) {
                l4.setNext(new Node<T>(l3.getValue()));
                l4 = l4.getNext();
            }
            l3 = l3.getNext();
        }
        return l2.getNext();
    }

}
