import java.util.*;

class Borrower {
    String name;
    int key;
    int priority;
    int order; // untuk menjaga urutan input

    public Borrower(String name, int key, int priority, int order) {
        this.name = name;
        this.key = key;
        this.priority = priority;
        this.order = order;
    }
}

public class NOMOR3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // keys (tidak terlalu dipakai, tapi tetap dibaca)
        int[] keys = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = sc.nextInt();
        }

        // queue untuk menyimpan borrower
        Queue<Borrower> queue = new LinkedList<>();

        // input nama dan key
        String[] names = new String[n];
        int[] borrowerKeys = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            borrowerKeys[i] = sc.nextInt();
        }

        // input priority
        int[] priorities = new int[n];
        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }

        // masukkan ke queue
        for (int i = 0; i < n; i++) {
            queue.add(new Borrower(names[i], borrowerKeys[i], priorities[i], i));
        }

        // ubah ke list untuk sorting
        List<Borrower> list = new ArrayList<>(queue);

        // sorting: priority kecil dulu, kalau sama pakai urutan input
        Collections.sort(list, (a, b) -> {
            if (a.priority != b.priority) {
                return a.priority - b.priority;
            }
            return a.order - b.order;
        });

        // stack untuk output
        Stack<Borrower> stack = new Stack<>();

        for (Borrower b : list) {
            stack.push(b);
        }

        // print dari stack (dibalik lagi biar sesuai urutan)
        Stack<Borrower> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        while (!temp.isEmpty()) {
            Borrower b = temp.pop();
            System.out.println(b.name + " | " + b.key);
        }

        sc.close();
    }
}