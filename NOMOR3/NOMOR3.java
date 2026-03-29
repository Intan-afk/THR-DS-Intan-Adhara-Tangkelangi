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
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] keys = new int[n];
            for (int i = 0; i < n; i++) {
                keys[i] = sc.nextInt();
            }
      
            Queue<Borrower> queue = new LinkedList<>();

            String[] names = new String[n];
            int[] borrowerKeys = new int[n];
            
            for (int i = 0; i < n; i++) {
                names[i] = sc.next();
                borrowerKeys[i] = sc.nextInt();
            }

            int[] priorities = new int[n];
            for (int i = 0; i < n; i++) {
                priorities[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                queue.add(new Borrower(names[i], borrowerKeys[i], priorities[i], i));
            }

            List<Borrower> list = new ArrayList<>(queue);

            Collections.sort(list, (a, b) -> {
                if (a.priority != b.priority) {
                    return a.priority - b.priority;
                }
                return a.order - b.order;
            });
            Stack<Borrower> stack = new Stack<>();
            
            for (Borrower b : list) {
                stack.push(b);
            }
            
            Stack<Borrower> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            
            while (!temp.isEmpty()) {
                Borrower b = temp.pop();
                System.out.println(b.name + " | " + b.key);
            }
        }
    }
}