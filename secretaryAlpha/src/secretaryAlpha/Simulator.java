package secretaryAlpha;

import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        ArrayList<Integer> candidates = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        final int rounds = 10;
        for(int j = 1; j <= rounds; j++) {
            for(int i = 1; i <= 100; i++) {
                candidates.add(i);
            }               
            while(candidates.size() != 0) {
                int select = (int)(Math.random() * candidates.size());
                sequence.add(candidates.remove(select));
            }
            int max = 0;
            for(int i = 0; i < 37; i++) { //37 is temporary, it's based on what I heard (verify later)
                if(sequence.get(i) > max) {
                    max = sequence.get(i);
                }
            }
            for(int i = 37; i < 100; i++) {
                int chosen = sequence.get(i);
                if((chosen > max) || (i == 99)) {
                    System.out.print("Highest encountered: " + max + ", Selected: " + chosen);
                    if(chosen == 100) {
                        System.out.print(" (won)");
                    } else {
                        System.out.print(" (lost)");
                    }
                    System.out.println();
                    break;
                }
            }
            candidates.clear();
            sequence.clear();
        }
    }
}
