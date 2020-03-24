package com.akgs.algo.familytree.common.exception;

import com.akgs.algo.familytree.common.Constants;

public class AddChildFailedException extends Throwable {
    public AddChildFailedException(){
        super(Constants.ADD_CHILD_FAILED);
    }
}
