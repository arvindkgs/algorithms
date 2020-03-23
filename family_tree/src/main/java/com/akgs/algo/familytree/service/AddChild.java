package com.akgs.algo.familytree.service;

import com.akgs.algo.familytree.FamilyTree;
import com.akgs.algo.familytree.common.AddChildFailedException;
import com.akgs.algo.familytree.common.PersonNotFoundException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Male;
import com.akgs.algo.familytree.model.Person;
import com.akgs.algo.familytree.common.Constants;

import java.util.Optional;

public class AddChild extends Command {
    private String motherName;
    private String childName;
    private Person.GENDER childGender;

    public AddChild(String[] values){
        super(COMMAND_TYPE.ADD_CHILD);
        if(values.length != 3)
            throw new IllegalArgumentException("Expected format for ADD_CHILD: ADD_CHILD mother-name child-name gender");
        if(values[0].isEmpty() || values[1].isEmpty() || values[2].isEmpty())
            throw new IllegalArgumentException("Expected format for ADD_CHILD: ADD_CHILD mother-name child-name gender");
        this.motherName = values[0];
        this.childName = values[1];
        this.childGender = Person.GENDER.valueOf(values[2].toUpperCase());
    }

    @Override
    public String evaluate(FamilyTree tree) throws AddChildFailedException, PersonNotFoundException {
        Optional<Person> person = tree.get(motherName);
        if(!person.isPresent()){
            throw new PersonNotFoundException();
        }
        else if(!(person.get() instanceof Female)){
            throw new AddChildFailedException();
        }
        else {
            Female mother = (Female)person.get();
            if(mother.hasChild(childName)){
                //Mother already has child with same name
                throw new AddChildFailedException();
            }
            if(tree.get(childName).isPresent()){
                //Pre-existing person in family tree
                throw new AddChildFailedException();
            }
            Person newPerson = childGender == Person.GENDER.MALE? new Male(childName, mother): new Female(childName, mother);
            tree.add(childName, newPerson);
            mother.addChild(newPerson);
            return Constants.ADD_CHILD_SUCCEEDED;
        }
    }
}
