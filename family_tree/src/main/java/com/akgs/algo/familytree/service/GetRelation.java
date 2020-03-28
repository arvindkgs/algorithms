package com.akgs.algo.familytree.service;

import com.akgs.algo.familytree.FamilyTree;
import com.akgs.algo.familytree.common.Constants;
import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Person;
import com.akgs.algo.familytree.service.relation.*;

import java.util.Optional;

public class GetRelation extends Command {
    public enum RELATION_TYPE {
        PATERNAL_UNCLE("PATERNAL-UNCLE", new PaternalUncle()),
        MATERNAL_UNCLE("MATERNAL-UNCLE", new MaternalUncle()),
        PATERNAL_AUNT("PATERNAL-AUNT", new PaternalAunt()),
        MATERNAL_AUNT("MATERNAL-AUNT", new MaternalAunt()),
        SISTER_IN_LAW("SISTER-IN-LAW", new SisterInLaw()),
        BROTHER_IN_LAW("BROTHER-IN-LAW", new BrotherInLaw()),
        SON("SON", new Son()),
        DAUGHTER("DAUGHTER", new Daughter()),
        SIBLINGS("SIBLINGS", new Siblings());
        private final String name;
        RELATION_TYPE(String s, Relationship relationship) {
            this.name = s;
            this.relationship = relationship;
        }

        public String getRelationship(Person person) throws IllegalTraversalException {
            return relationship.getRelation(person);
        }

        private Relationship relationship;
        public static RELATION_TYPE valueOfLabel(String label) {
            for (RELATION_TYPE e : values()) {
                if (e.name.equals(label)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("RELATION_TYPE: "+label+" not supported.");
        }

        @Override
        public String toString() {
            return name;
        }
    }
    private String ofPerson;
    private RELATION_TYPE type;
    public GetRelation(String[] values){
        super(COMMAND_TYPE.GET_RELATIONSHIP);
        if(values.length != 2)
            throw new IllegalArgumentException("Expected format for GET_RELATIONSHIP: GET_RELATIONSHIP person relationship");
        if(values[0].isEmpty() || values[1].isEmpty())
            throw new IllegalArgumentException("Expected format for GET_RELATIONSHIP: GET_RELATIONSHIP person relationship");
        this.ofPerson = values[0];
        this.type = GetRelation.RELATION_TYPE.valueOfLabel(values[1].toUpperCase());
    }

    @Override
    public String evaluate(FamilyTree tree) {
        Optional<Person> person = tree.get(ofPerson);
        if(!person.isPresent()){
            return Constants.PERSON_NOT_FOUND;
        }
        else {
            try {
                return type.getRelationship(person.get());
            }
            catch (IllegalTraversalException e){
                return Constants.NONE;
            }
        }
    }

}
