package com.akgs.algo.familytree.service.relation;

import com.akgs.algo.familytree.common.Constants;
import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Person;

import static com.akgs.algo.familytree.common.Utils.evalOutput;

public class Daughter implements Relationship {
    @Override
    public String getRelation(Person person) throws IllegalTraversalException {
        if (person instanceof Female) {
            StringBuffer sb = new StringBuffer();
            for (Female daughter : ((Female) person).getDaughters()) {
                sb.append(daughter.getName() + " ");
            }
            return evalOutput(sb.toString());
        } else {
            if (!person.getSpouse().isPresent()) {
                throw new IllegalTraversalException(Constants.SPOUSE_NOT_FOUND);
            }
            Female mother = (Female) person.getSpouse().get();
            StringBuffer sb = new StringBuffer();
            for (Female daughter : mother.getDaughters()) {
                sb.append(daughter.getName() + " ");
            }
            return evalOutput(sb.toString());
        }
    }
}
