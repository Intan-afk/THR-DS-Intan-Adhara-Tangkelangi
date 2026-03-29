import java.util.*;

class Card {
    int value;
    int priority;

    public Card(int v, int p) {
        value = v;
        priority = p;
    }

    @Override
    public String toString() {
        return value + "," + priority;
    }
}

public class NOMOR4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] tokens = input.split(" ");

        List<List<Card>> stacks = new ArrayList<>();
        List<Set<Integer>> used = new ArrayList<>();

        for (String t : tokens) {
            String[] parts = t.split(",");
            int val = Integer.parseInt(parts[0]);
            int pr = Integer.parseInt(parts[1]);

            Card card = new Card(val, pr);

            boolean placed = false;

            for (int i = 0; i < stacks.size(); i++) {
                if (!used.get(i).contains(val)) {
                    stacks.get(i).add(card);
                    used.get(i).add(val);
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                List<Card> newStack = new ArrayList<>();
                Set<Integer> newSet = new HashSet<>();

                newStack.add(card);
                newSet.add(val);

                stacks.add(newStack);
                used.add(newSet);
            }
        }

        // OUTPUT
        for (List<Card> stack : stacks) {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i));
                if (i < stack.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}