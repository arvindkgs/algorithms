package com.akgs.algo.familytree.service.relation;

import com.akgs.algo.familytree.common.Constants;
import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Male;
import com.akgs.algo.familytree.model.Person;

import static com.akgs.algo.familytree.common.Utils.getFather;
import static com.akgs.algo.familytree.common.Utils.getSiblings;
import static com.akgs.algo.familytree.common.Utils.evalOutput;

public class PaternalAunt implements Relationship {
    @Override
    public String getRelation(Person person) throws IllegalTraversalException {
        //sisters of one's father.
        if (getFather(person).isPresent()) {
            Male father = (Male) getFather(person).get();
            StringBuffer sb = new StringBuffer();
            for (Person child : getSiblings(father)) {
                if(child instanceof Female){
                    //Sister
                    sb.append(child.getName() + " ");
                }
            }
            return evalOutput(sb.toString());
        }
        else{
            throw new IllegalTraversalException(Constants.FATHER_NOT_FOUND);
        }
    }
}
