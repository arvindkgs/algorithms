package com.akgs.algo.familytree.common.exception;

import com.akgs.algo.familytree.common.Constants;

public class PersonNotFoundException extends Throwable {
    public PersonNotFoundException(){
        super(Constants.PERSON_NOT_FOUND);
    }
}
