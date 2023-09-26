package org.example.data.structure.three;

public class Species {
    public enum SPECIES { DOG, CAT };
    public SPECIES species;
    public int age;

    public Species(SPECIES species, int age) {
        this.species = species;
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public SPECIES getSpecies() {
        return species;
    }

    public void print() {
        if (species == null) {
            System.out.println("all out");
            return;
        }
        System.out.println("Species: " + (SPECIES.DOG.equals(species)?"DOG":"CAT")
                        + ", " + "Age: " + getAge());
    }
}
