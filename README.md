# Notice
I had developed this code when I hadn't had known that Github was the industry standard to document progression in code. Therefore, it will appear that all the code was developed at the same time, although I had developed the code on Eclipse.
# secretaryAlpha (mid-August 2026)
This was an early version of the code where I would run small batch tests (10 to 20), and get each simulation result printed to see if the code was functioning correctly according to the rules of the Secretary Problem.
# secretaryBeta (late-August 2026)
I made the code in a way that it is easy to adjust the transition index, or, when the program stops denying every candidate and starts looking for a candidate that beats every other candidate, to see if 37% was correct. It was. 
# v1 (completed August 31, 2026)
I decided to make the code report what the average candidate was selected ("Average selected") and the average value of the highest candidate ever encountered before the transition index ("Average encountered").
# v2 (completed September 4, 2026)
I decided to make the code print the exact distribution of final results. It now shows how many times a candidate was chosen as the final result, from 100 to 1. With it I created a frequency distribution of the data.
# v3 (completed September 7, 2026)
This time I decided to improve the runtime, and this was largely achieved by replacing ArrayLists with standard Arrays and dropping the use of Math.random(). In the end I got an improvement of around 3x (678s -> 203s for 100m simulations).
# v4 (completed September 11, 2026)
This version is largely the same as v3 and shouldn't have significant differences. It was developed to investigate how a different transition index would affect selection probabilities of non-best candidates.
# Declaration
Generative AI tools were used strictly for debugging and to receive guidance on how optimize runtime. While building the code, it was not used for any other purpose.
