package secretaryV2;

import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        ArrayList<Integer> candidates = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        ArrayList<Integer> data = new ArrayList<>();
        long encountered = 0L;
        long selected = 0L;
        final int rounds = 1_000_000; // Max is now Integer.MAX_VALUE() 
        
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
                data.add(chosen);
                break;
                }
            }
            candidates.clear();
            sequence.clear();
        }
        
        System.out.print("Average encountered: ");
        System.out.println(((100 * encountered / rounds)) / 100.0);
        System.out.print("Average selected: " );
        System.out.println(((100 * selected / rounds)) / 100.0);
        System.out.print("Winrate: ");
        int won = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == 100) {
                won++;
            }
        }
        double percentage = Math.round(won * 10000.0 / rounds) / 100.0;
        System.out.print(percentage);
        System.out.print("%");
        System.out.println();
        System.out.println("Precise results (for easy export, each number represents selected results, 100 to 1 in descending order");
        for(int i = 100; i >= 1; i--) {
        	int x = 0;
        	for(int j = 0; j < data.size(); j++) {
        		if(data.get(j) == i) {
        			x++;
        		}
        	}
        	System.out.println(x);
        }
    }
}
