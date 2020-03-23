package com.akgs.algo.familytree.common;

public class AddChildFailedException extends Throwable {
    public AddChildFailedException(){
        super(Constants.ADD_CHILD_FAILED);
    }
}
