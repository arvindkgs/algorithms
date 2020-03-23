package com.akgs.algo.familytree.model;

import java.util.Optional;

public class Person {
    Female mother;
    public Optional<Female> getMother() {
        return Optional.ofNullable(mother);
    }

    public enum GENDER { MALE, FEMALE}
    protected GENDER gender;

    public String getName() {
        return name;
    }

    public Optional<Person> getSpouse() {
        return Optional.ofNullable(spouse);
    }

    private String name;
    private Person spouse;

    protected Person(String name, GENDER gender, Female mother){
        this.name = name;
        this.gender = gender;
        spouse = null;
        this.mother = mother;
    }

    public void addSpouse(Person spouse) {
        if(this.spouse != null && spouse.spouse != null){
            throw new IllegalStateException("Spouse "+spouse.name+" already exists. Cannot add another spouse.");
        }
        this.spouse = spouse;
        spouse.spouse = this;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Person) && ((Person) obj).name.equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public GENDER getGender() {
        return gender;
    }
}
