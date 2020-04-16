package com.akgs.algo.familytree.service;

import com.akgs.algo.familytree.FamilyTree;
import com.akgs.algo.familytree.common.Constants;
import com.akgs.algo.familytree.common.exception.AddSpouseFailedException;
import com.akgs.algo.familytree.common.exception.CommandFailedException;
import com.akgs.algo.familytree.common.exception.PersonNotFoundException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Male;
import com.akgs.algo.familytree.model.Person;

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
    public String evaluate(FamilyTree tree) throws CommandFailedException {
        Person person = tree.get(forPerson);
        if(person == null){
            throw new CommandFailedException(new PersonNotFoundException());
        }
        else {
            if(person.getSpouse().isPresent()){
                throw new CommandFailedException(new AddSpouseFailedException());
            }
            Person spouse = tree.get(spouseName);
            if(spouse != null){
                throw new CommandFailedException(new AddSpouseFailedException());
            }
            if(person.getGender() == Person.GENDER.MALE){
                Female spouse1 = new Female(spouseName, null);
                person.addSpouse(spouse1);
                tree.add(spouseName, spouse1);
                return Constants.ADD_SPOUSE_SUCCEEDED;
            }
            else{
                Male spouse1 = new Male(spouseName, null);
                person.addSpouse(spouse1);
                tree.add(spouseName, spouse1);
                return Constants.ADD_SPOUSE_SUCCEEDED;
            }
        }
    }
}
