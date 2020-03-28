package com.akgs.algo.familytree.service.relation;

import com.akgs.algo.familytree.common.Constants;
import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Male;
import com.akgs.algo.familytree.model.Person;

import static com.akgs.algo.familytree.common.Utils.*;

public class SisterInLaw implements Relationship {
    @Override
    public String getRelation(Person person) throws IllegalTraversalException {
        if (!person.getMother().isPresent()) {
            if (person.getSpouse().isPresent()) {
                StringBuffer sb = new StringBuffer();
                Person spouse = person.getSpouse().get();
                for (Female daughter : getSisters(spouse)) {
                    sb.append(daughter.getName() + " ");
                }
                return evalOutput(sb.toString());
            } else {
                throw new IllegalTraversalException(Constants.SPOUSE_NOT_FOUND);
            }
        } else {
            Female mother = person.getMother().get();
            StringBuffer sb = new StringBuffer();
            for (Male son : mother.getSons()) {
                if (!son.getName().equals(person.getName())) {
                    if (son.getSpouse().isPresent()) {
                        sb.append(son.getSpouse().get().getName() + " ");
                    }
                }
            }
            return evalOutput(sb.toString());
        }
    }
}
