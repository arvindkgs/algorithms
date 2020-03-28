package com.akgs.algo.familytree.service.relation;

import com.akgs.algo.familytree.common.Constants;
import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Male;
import com.akgs.algo.familytree.model.Person;

import static com.akgs.algo.familytree.common.Utils.getMother;
import static com.akgs.algo.familytree.common.Utils.getSiblings;
import static com.akgs.algo.familytree.common.Utils.evalOutput;

public class MaternalUncle implements Relationship {
    @Override
    public String getRelation(Person person) throws IllegalTraversalException {
        //The brothers of one’s mother.
        if (getMother(person).isPresent()) {
            Female mother = getMother(person).get();
            StringBuffer sb = new StringBuffer();
            for (Person child : getSiblings(mother)) {
                if(child instanceof Male){
                    //Brother
                    sb.append(child.getName() + " ");
                }
            }
            return evalOutput(sb.toString());
        }
        else{
            throw new IllegalTraversalException(Constants.MOTHER_NOT_FOUND);
        }
    }
}
