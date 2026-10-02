package secretaryV4;

import java.util.ArrayList;
import java.util.Random;

public class Simulator {
    public static void main(String[] args) {
    	Random rand = new Random();
        ArrayList<Integer> candidates = new ArrayList<>();
        int[] sequence = new int[100];
        int[] data = new int[100]; //Note that index 0 corresponds to 1, and index 99 corresponds to 100
        long encountered = 0L;
        long selected = 0L;
        final long rounds = 1_000_000L; 
        final int investigate = 65; //Change this value to change the transition index
        
        for(long j = 1L; j <= rounds; j++) {
            for(int i = 1; i <= 100; i++) {
                candidates.add(i);
            }    
            for(int i = 0; i < 100; i++) {
                int select = rand.nextInt(candidates.size()); //This is essentially (int)(Math.random() * candidates.size())
                int chosen = candidates.get(select); 
                int last = candidates.size() - 1;
                candidates.set(select, candidates.get(last));
                candidates.remove(last);
                sequence[i] = chosen;
            }  
            int max = 0;
            for(int i = 0; i < investigate; i++) {
                if(sequence[i] > max) {
                    max = sequence[i];
                }
            }
            for(int i = investigate; i < 100; i++) {
                int chosen = sequence[i];
                if((chosen > max) || (i == 99)) {
                encountered += max;
                selected += chosen;
                data[chosen - 1]++;
                break;
                }
            }
            candidates.clear();
        }
        
        System.out.print("Average encountered: ");
        System.out.println((double) encountered/rounds);
        System.out.print("Average selected: " );
        System.out.println((double) selected/rounds);
        System.out.print("Winrate: ");
        double percentage = (data[99] * 100.0 / rounds);
        System.out.print(percentage);
        System.out.print("%");
        System.out.println();
        System.out.println("Precise results (100 to 1 in descending order)");
        for(int i = 99; i >= 0; i--) {
        	System.out.println(data[i]);
        }
    }
}
