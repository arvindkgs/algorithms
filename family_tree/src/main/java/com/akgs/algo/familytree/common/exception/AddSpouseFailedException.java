package com.akgs.algo.familytree.common.exception;

import com.akgs.algo.familytree.common.Constants;

public class AddSpouseFailedException extends Throwable {
    public AddSpouseFailedException(){
        super(Constants.ADD_SPOUSE_FAILED);
    }
}
