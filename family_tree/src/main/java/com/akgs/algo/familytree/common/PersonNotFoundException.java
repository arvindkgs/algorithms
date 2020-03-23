package com.akgs.algo.familytree.common;

public class PersonNotFoundException extends Throwable {
    public PersonNotFoundException(){
        super(Constants.PERSON_NOT_FOUND);
    }
}
