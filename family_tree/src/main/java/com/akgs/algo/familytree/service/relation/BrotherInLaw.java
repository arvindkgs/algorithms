package com.akgs.algo.familytree.service.relation;

import com.akgs.algo.familytree.common.Constants;
import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Male;
import com.akgs.algo.familytree.model.Person;

import static com.akgs.algo.familytree.common.Utils.*;

public class BrotherInLaw implements Relationship {
    @Override
    public String getRelation(Person person) throws IllegalTraversalException {
        if (!person.getMother().isPresent()) {
            if (person.getSpouse().isPresent()) {
                Person spouse = person.getSpouse().get();
                StringBuffer sb = new StringBuffer();
                for (Male brother : getBrothers(spouse)) {
                    sb.append(brother.getName() + " ");
                }
                return evalOutput(sb.toString());
            }
            else{
                throw new IllegalTraversalException(Constants.SPOUSE_NOT_FOUND);
            }
        } else {
            Female mother = person.getMother().get();
            StringBuffer sb = new StringBuffer();
            for (Female daughter : mother.getDaughters()) {
                if (!daughter.getName().equals(person.getName())) {
                    if (daughter.getSpouse().isPresent()) {
                        sb.append(daughter.getSpouse().get().getName() + " ");
                    }
                }
            }
            return evalOutput(sb.toString());
        }
    }
}
