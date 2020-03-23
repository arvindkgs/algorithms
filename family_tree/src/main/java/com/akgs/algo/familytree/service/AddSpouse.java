package com.akgs.algo.familytree.service;

import com.akgs.algo.familytree.FamilyTree;
import com.akgs.algo.familytree.common.AddSpouseFailedException;
import com.akgs.algo.familytree.common.Constants;
import com.akgs.algo.familytree.common.PersonNotFoundException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Male;
import com.akgs.algo.familytree.model.Person;

import java.util.Optional;

public class AddSpouse extends Command {
    private String forPerson;
    private String spouseName;
    public AddSpouse(String[] values){
        super(COMMAND_TYPE.ADD_SPOUSE);
        if(values.length != 2)
            throw new IllegalArgumentException("Expected format for ADD_SPOUSE: ADD_SPOUSE person spouse");
        if(values[0].isEmpty() || values[1].isEmpty())
            throw new IllegalArgumentException("Expected format for ADD_SPOUSE: ADD_SPOUSE person spouse");
        forPerson = values[0];
        spouseName = values[1];
    }

    @Override
    public String evaluate(FamilyTree tree) throws PersonNotFoundException, AddSpouseFailedException {
        Optional<Person> person = tree.get(forPerson);
        if(!person.isPresent()){
            throw new PersonNotFoundException();
        }
        else {
            if(person.get().getSpouse().isPresent()){
                throw new AddSpouseFailedException();
            }
            Optional<Person> spouse = tree.get(spouseName);
            if(spouse.isPresent()){
                throw new AddSpouseFailedException();
            }
            if(person.get().getGender() == Person.GENDER.MALE){
                Female spouse1 = new Female(spouseName, null);
                person.get().addSpouse(spouse1);
                tree.add(spouseName, spouse1);
                return Constants.ADD_SPOUSE_SUCCEEDED;
            }
            else{
                Male spouse1 = new Male(spouseName, null);
                person.get().addSpouse(spouse1);
                tree.add(spouseName, spouse1);
                return Constants.ADD_SPOUSE_SUCCEEDED;
            }
        }
    }
}
