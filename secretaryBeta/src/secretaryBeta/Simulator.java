package secretaryBeta;

import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        ArrayList<Integer> candidates = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        int[] results = new int[100];
        final int roundsPerIndex = 100_000;
        
        int x = 1;
        while(x < 100) {
        	for(int y = 0; y < roundsPerIndex; y++) {
        		for(int i = 1; i <= 100; i++) {
        			candidates.add(i);
        		}
        		while(candidates.size() != 0) {
                    int select = (int)(Math.random() * candidates.size());
                    sequence.add(candidates.remove(select));
                }
                int max = 0;
                for(int i = 0; i < x; i++) {
                    if(sequence.get(i) > max) {
                        max = sequence.get(i);
                    }
        		}
                for(int i = x; i < 100; i++) {
                	int chosen = sequence.get(i);
                    if((chosen > max) || (i == 99)) {
                    	if(chosen == 100) {
                    	results[x]++;	
                    	}
                        break;
                    }
                }
                candidates.clear();
                sequence.clear();
        	}
        	x++;
        }
        int bestIndex = 1;
        int indexScore = 0;
        for(int i = 1; i < 100; i++) {
        	System.out.println(results[i]);
        	if(results[i] > indexScore) {
        		indexScore = results[i];
        		bestIndex = i;
        	}
        }
        System.out.println("The optimal index is " + bestIndex + " with a score of " + indexScore + " out of " + roundsPerIndex);
    }
}
