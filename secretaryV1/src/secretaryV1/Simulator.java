package secretaryV1;

import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        ArrayList<Integer> candidates = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        int encountered = 0;
        int selected = 0;
        int won = 0;
        final int rounds = Integer.MAX_VALUE / 10000; //DO NOT ENTER MORE THAN 214_748 ROUNDS 

        for(int j = 1; j <= rounds; j++) {
            for(int i = 1; i <= 100; i++) {
                candidates.add(i);
            }               
            while(candidates.size() != 0) {
                int select = (int)(Math.random() * candidates.size());
                sequence.add(candidates.remove(select));
            }
            int max = 0;
            for(int i = 0; i < 37; i++) {
                if(sequence.get(i) > max) {
                    max = sequence.get(i);
                }
            }
            for(int i = 37; i < 100; i++) {
                int chosen = sequence.get(i);
                if((chosen > max) || (i == 99)) {
                    encountered += max;
                    selected += chosen;
                    if(chosen == 100) {
                        won++;
                    }
                    break;
                }
            }
            candidates.clear();
            sequence.clear();
        }
        System.out.print("Average encountered: ");
        System.out.println((int)(100 * encountered / rounds)/100.0);
        System.out.print("Average selected: " );
        System.out.println((int)(100 * selected / rounds)/100.0);
        System.out.print("Winrate: ");
        System.out.print((int)(10000 * won / rounds)/100.0);
        System.out.println("%");
    }
}
