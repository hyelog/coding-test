package org.example.data.structure.three;

import java.util.LinkedList;
import java.util.Queue;

public class SixQueue {

    public Queue<Species.SPECIES> speciesQueue = new LinkedList<Species.SPECIES>();
    public Queue<Species> catQueues = new LinkedList<Species>();
    public Queue<Species> dogQueues = new LinkedList<Species>();

    public void enQueue(Species species) {
        switch (species.getSpecies())
        {
            case CAT:
                catQueues.add(species);
                break;
            case DOG:
                dogQueues.add(species);
                break;
            default:
                return;
        }
        speciesQueue.add(species.getSpecies());
    }

    public Species dequeueAny() {
        Species species = null;
        try {
            switch (speciesQueue.poll()) {
                case CAT:
                    species = catQueues.poll();
                    break;
                case DOG:
                    species = dogQueues.poll();
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
        return species;
    }

    public Species dequeueDog() {
        speciesQueue.poll();
        return dogQueues.poll();
    }

    public Species dequeueCat() {
        speciesQueue.poll();
        return catQueues.poll();
    }
}
