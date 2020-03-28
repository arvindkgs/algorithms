package com.akgs.algo.familytree.service.relation;

import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Person;

import static com.akgs.algo.familytree.common.Utils.getSiblings;
import static com.akgs.algo.familytree.common.Utils.evalOutput;

public class Siblings implements Relationship {
    @Override
    public String getRelation(Person person) throws IllegalTraversalException {
        StringBuffer sb = new StringBuffer();
        for (Person child : getSiblings(person)) {
            sb.append(child.getName() + " ");
        }
        return evalOutput(sb.toString());
    }
}
