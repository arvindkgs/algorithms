package com.akgs.algo.familytree.service.relation;

import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Person;

public interface Relationship {
    String getRelation(Person person) throws IllegalTraversalException;
}
