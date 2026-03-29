import java.util.*;
public class ForbiddenBridge {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int T = sc.nextInt();

        List<Auror> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Auror(sc.nextInt(), i + 1)); // simpan index
        }

        // sort berdasarkan waktu
        list.sort(Comparator.comparingInt(a -> a.time));

        Queue<Auror> queue = new LinkedList<>(list);
        Stack<Auror> stack = new Stack<>();

        int time = 0;

        while (!queue.isEmpty()) {
            if (queue.size() >= 2) {
                Auror a = queue.poll();
                Auror b = queue.poll();

                int cross = Math.max(a.time, b.time);

                if (time + cross > T) {
                    queue.add(a);
                    queue.add(b);
                    break;
                }

                System.out.println(a.index + " " + b.index + " ->");
                time += cross;

                stack.push(a);
                stack.push(b);
            } else {
                Auror a = queue.poll();

                if (time + a.time > T) {
                    queue.add(a);
                    break;
                }

                System.out.println(a.index + " ->");
                time += a.time;
                stack.push(a);
            }

            if (!queue.isEmpty()) {
                Auror back = stack.peek();

                if (time + back.time > T) break;

                stack.pop();
                System.out.println(back.index + " <-");
                time += back.time;
                queue.add(back);
            }
        }

        // NON-SURVIVORS
        if (!queue.isEmpty()) {
            List<Integer> dead = new ArrayList<>();
            while (!queue.isEmpty()) {
                dead.add(queue.poll().index);
            }

            System.out.print("Non-survivors: [");
            for (int i = 0; i < dead.size(); i++) {
                System.out.print(dead.get(i));
                if (i != dead.size() - 1) System.out.print(",");
            }
            System.out.println("]");
        }
    }
}
class Auror {
    int time;
    int index;

    Auror(int time, int index) {
        this.time = time;
        this.index = index;
    }
}