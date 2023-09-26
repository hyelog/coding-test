package org.example.data.structure.three;

import static org.example.data.structure.three.Species.SPECIES.CAT;
import static org.example.data.structure.three.Species.SPECIES.DOG;

public class MainSixth {
    public static void main(String[] args) {
        SixQueue sixQueue = new SixQueue();

        for (int i=0; i<10; i++) {
            if (i%3==0) {
                sixQueue.enQueue(new Species(CAT, i));
            } else {
                sixQueue.enQueue(new Species(DOG, i));
            }
        }

        Species species = sixQueue.dequeueAny(); // cat - 0
        species.print();
        species = sixQueue.dequeueAny(); // dog - 1
        species.print();
        sixQueue.enQueue(new Species(CAT, 10));
        species = sixQueue.dequeueCat(); // cat, 3
        species.print();
        species = sixQueue.dequeueDog(); // dog, 2
        species.print();
        species = sixQueue.dequeueAny(); // dog, 4
        species.print();
        species = sixQueue.dequeueAny(); // dog, 5
        species.print();
        species = sixQueue.dequeueAny(); // cat, 6
        species.print();
        species = sixQueue.dequeueAny(); // dog, 7
        species.print();
        species = sixQueue.dequeueAny(); // dog, 8
        species.print();
        species = sixQueue.dequeueAny(); // cat, 9
        species.print();
        species = sixQueue.dequeueAny(); // cat, 10
        species.print();
    }
}