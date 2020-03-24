package com.akgs.algo.familytree.common;

import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Male;
import com.akgs.algo.familytree.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Utils {
    public static Optional<Female> getMother(Optional<Person> person) throws IllegalTraversalException {
        return person.get().getMother();
    }

    public static Optional<Person> getFather(Optional<Person> person) throws IllegalTraversalException{
        if (!person.get().getMother().isPresent()) {
            throw new IllegalTraversalException(Constants.MOTHER_NOT_FOUND);
        }
        Female mother = person.get().getMother().get();
        //Got Father
        return mother.getSpouse();
    }

    public static Collection<Person> getSiblings(Person person) throws IllegalTraversalException{
        List<Person> siblings = new ArrayList<>();
        if (!person.getMother().isPresent()) {
            throw new IllegalTraversalException(Constants.MOTHER_NOT_FOUND);
        }
        Female mother = person.getMother().get();
        for(Person child: mother.getChildren()){
            if(!child.getName().equals(person.getName())){
                siblings.add(child);
            }
        }
        return siblings;
    }

    public static Collection<Male> getBrothers(Person person) throws IllegalTraversalException{
        List<Male> brothers = new ArrayList<>();
        if(!person.getMother().isPresent()){
            throw new IllegalTraversalException(Constants.MOTHER_NOT_FOUND);
        }
        for(Male son: person.getMother().get().getSons()){
            if(!son.getName().equals(person.getName())){
                brothers.add(son);
            }
        }
        return brothers;
    }

    public static Collection<Female> getSisters(Person person) throws IllegalTraversalException{
        List<Female> sisters = new ArrayList<>();
        if(!person.getMother().isPresent()){
            throw new IllegalTraversalException(Constants.MOTHER_NOT_FOUND);
        }
        for(Female daughter: person.getMother().get().getDaughters()){
            if(!daughter.getName().equals(person.getName())){
                sisters.add(daughter);
            }
        }
        return sisters;
    }
}
