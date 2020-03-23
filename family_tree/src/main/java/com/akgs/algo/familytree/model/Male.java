package com.akgs.algo.familytree.model;

public class Male extends Person {
    public Male(String name, Female mother) {
        super(name, GENDER.MALE, mother);
    }
}
