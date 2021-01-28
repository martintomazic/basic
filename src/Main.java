import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int t = scanner.nextInt();
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            data.add(scanner.nextInt());
        }

        switch (t) {
            case 1:
                System.out.println(7);
                break;
            case 2:
                if (data.get(0) > data.get(1)) {
                    System.out.println("Bigger");
                } else if (data.get(0) < data.get(1)) {
                    System.out.println("Smaller");
                } else {
                    System.out.println("Equal");
                }
                break;
            case 3:
                Integer median = data.subList(0, 3).stream().sorted().collect(Collectors.toList()).get(1);
                System.out.println(median);
                break;
            case 4:
                int sum = data.stream().mapToInt(Integer::intValue).sum();
                System.out.println(sum);
                break;
            case 5:
                int sumEven = data.stream().mapToInt(Integer::intValue).filter(x -> x%2 == 0).sum();
                System.out.println(sumEven);
                break;
            case 6:
                String string = data.stream().map(x -> x % 26 + 'a').map(Character::toString).collect(Collectors.joining());
                System.out.println(string);
                break;
            case 7:
                recursion(data, 0, new HashSet<Integer>(), N);
                break;
        }
    }

    private static void recursion(ArrayList<Integer> data, Integer index, Set<Integer> visited, Integer N) {
        if (visited.contains(index)) {
            System.out.println("Cyclic");
        } else if (index >= N) {
            System.out.println("Out");
        } else if (index == N - 1) {
            System.out.println("Done");
        } else {
            visited.add(index);
            index = data.get(index);
            recursion(data, index, visited, N);
        }
    }
}

































