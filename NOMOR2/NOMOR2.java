import java.util.*;
public class NOMOR2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        String[] first = sc.nextLine().split(" ");
        for (String s : first){
            stack.push(Integer.parseInt(s));
        }
        Queue<String> queue = new LinkedList<>();
        String[] second = sc.nextLine().split(" ");
        queue.addAll(Arrays.asList(second));

        while (!queue.isEmpty()) {
            String op = queue.poll();

            int b = stack.pop();
            int a = stack.pop();
            int result = 0;

            switch (op) {
                case "+" -> result = a + b;
                case "-" -> result = a - b;
                case "*" -> result = a * b;
                case "/" -> result = a / b;
            }
            stack.push(result);
        }
        System.out.println(stack.pop());

    }

}
