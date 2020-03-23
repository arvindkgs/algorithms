package com.akgs.algo.familytree.service;

import com.akgs.algo.familytree.FamilyTree;
import com.akgs.algo.familytree.common.AddChildFailedException;
import com.akgs.algo.familytree.common.AddSpouseFailedException;
import com.akgs.algo.familytree.common.PersonNotFoundException;

import java.util.Arrays;

public abstract class Command {
    public enum COMMAND_TYPE { ADD_KING, ADD_QUEEN, ADD_CHILD, GET_RELATIONSHIP, ADD_SPOUSE }
    protected COMMAND_TYPE type;
    Command(COMMAND_TYPE type){
        this.type = type;
    }

    public static Command parse(String line){
        line = line.trim();
        if (line.isEmpty()) {
            throw new IllegalArgumentException("Empty line not allowed. One command expected per line.");
        }
        String[] words = line.split(" ");
        if(words.length<0){
            throw new IllegalArgumentException("Expected format for command: COMMAND-TYPE VALUES");
        }
        Command.COMMAND_TYPE type = Command.COMMAND_TYPE.valueOf(words[0]);
        String[] values = Arrays.copyOfRange(words, 1, words.length);
        switch (type){
            case ADD_CHILD: return new AddChild(values);
            case GET_RELATIONSHIP: return new GetRelation(values);
            case ADD_SPOUSE: return new AddSpouse(values);
            default:
                return null;
        }
    }
    public abstract String evaluate(FamilyTree tree) throws AddChildFailedException, PersonNotFoundException, AddSpouseFailedException;
}
