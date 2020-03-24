package com.akgs.algo.familytree.service;

import com.akgs.algo.familytree.FamilyTree;
import com.akgs.algo.familytree.common.Constants;
import com.akgs.algo.familytree.common.exception.IllegalTraversalException;
import com.akgs.algo.familytree.model.Female;
import com.akgs.algo.familytree.model.Male;
import com.akgs.algo.familytree.model.Person;
import java.util.Optional;
import static com.akgs.algo.familytree.common.Utils.*;

public class GetRelation extends Command {
    public enum RELATION_TYPE {
        PATERNAL_UNCLE("PATERNAL-UNCLE"), MATERNAL_UNCLE("MATERNAL-UNCLE"), PATERNAL_AUNT("PATERNAL-AUNT"),
        MATERNAL_AUNT("MATERNAL-AUNT"), SISTER_IN_LAW("SISTER-IN-LAW"), BROTHER_IN_LAW("BROTHER-IN-LAW"), SON("SON"), DAUGHTER("DAUGHTER"), SIBLINGS("SIBLINGS");
        private final String name;
        RELATION_TYPE(String s) {
            this.name = s;
        }
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
                switch (type) {
                    case PATERNAL_AUNT:
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
                    case PATERNAL_UNCLE:
                        //A brothers of one's father.
                        if (getFather(person).isPresent()) {
                            Male father = (Male) getFather(person).get();
                            //Print sisters or sister-in-law
                            StringBuffer sb = new StringBuffer();
                            for (Person child : getSiblings(father)) {
                                if(child instanceof Male){
                                    //brother
                                    sb.append(child.getName() + " ");
                                }
                            }
                            return evalOutput(sb.toString());
                        }
                        else{
                            throw new IllegalTraversalException(Constants.FATHER_NOT_FOUND);
                        }
                    case MATERNAL_AUNT:
                        //The sisters of one's mother.
                        if (getMother(person).isPresent()) {
                            Female mother = getMother(person).get();
                            StringBuffer sb = new StringBuffer();
                            for (Person child : getSiblings(mother)) {
                                if(child instanceof Female){
                                    //Sister
                                    sb.append(child.getName() + " ");
                                }
                            }
                            return evalOutput(sb.toString());
                        }
                        else{
                            throw new IllegalTraversalException(Constants.MOTHER_NOT_FOUND);
                        }
                    case MATERNAL_UNCLE:
                        //The brothers of one’s mother.
                        if (getMother(person).isPresent()) {
                            Female mother = getMother(person).get();
                            StringBuffer sb = new StringBuffer();
                            for (Person child : getSiblings(mother)) {
                                if(child instanceof Male){
                                    //Brother
                                    sb.append(child.getName() + " ");
                                }
                            }
                            return evalOutput(sb.toString());
                        }
                        else{
                            throw new IllegalTraversalException(Constants.MOTHER_NOT_FOUND);
                        }
                    case SISTER_IN_LAW:
                        if (!person.get().getMother().isPresent()) {
                            if (person.get().getSpouse().isPresent()) {
                                StringBuffer sb = new StringBuffer();
                                Person spouse = person.get().getSpouse().get();
                                for (Female daughter : getSisters(spouse)) {
                                    sb.append(daughter.getName() + " ");
                                }
                                return evalOutput(sb.toString());
                            }
                            else {
                                throw new IllegalTraversalException(Constants.SPOUSE_NOT_FOUND);
                            }
                        } else {
                            Female mother = person.get().getMother().get();
                            StringBuffer sb = new StringBuffer();
                            for (Male son : mother.getSons()) {
                                if (!son.getName().equals(person.get().getName())) {
                                    if (son.getSpouse().isPresent()) {
                                        sb.append(son.getSpouse().get().getName() + " ");
                                    }
                                }
                            }
                            return evalOutput(sb.toString());
                        }
                    case BROTHER_IN_LAW:
                        if (!person.get().getMother().isPresent()) {
                            if (person.get().getSpouse().isPresent()) {
                                Person spouse = person.get().getSpouse().get();
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
                            Female mother = person.get().getMother().get();
                            StringBuffer sb = new StringBuffer();
                            for (Female daughter : mother.getDaughters()) {
                                if (!daughter.getName().equals(person.get().getName())) {
                                    if (daughter.getSpouse().isPresent()) {
                                        sb.append(daughter.getSpouse().get().getName() + " ");
                                    }
                                }
                            }
                            return evalOutput(sb.toString());
                        }
                    case SON:
                        if (person.get() instanceof Female) {
                            StringBuffer sb = new StringBuffer();
                            for (Male son : ((Female) person.get()).getSons()) {
                                sb.append(son.getName() + " ");
                            }
                            return evalOutput(sb.toString());
                        } else {
                            if (!person.get().getSpouse().isPresent()) {
                                throw new IllegalTraversalException(Constants.MOTHER_NOT_FOUND);
                            }
                            Female mother = (Female) person.get().getSpouse().get();
                            StringBuffer sb = new StringBuffer();
                            for (Male son : mother.getSons()) {
                                sb.append(son.getName() + " ");
                            }
                            return evalOutput(sb.toString());
                        }
                    case DAUGHTER:
                        if (person.get() instanceof Female) {
                            StringBuffer sb = new StringBuffer();
                            for (Female daughter : ((Female) person.get()).getDaughters()) {
                                sb.append(daughter.getName() + " ");
                            }
                            return evalOutput(sb.toString());
                        } else {
                            if (!person.get().getSpouse().isPresent()) {
                                throw new IllegalTraversalException(Constants.SPOUSE_NOT_FOUND);
                            }
                            Female mother = (Female) person.get().getSpouse().get();
                            StringBuffer sb = new StringBuffer();
                            for (Female daughter : mother.getDaughters()) {
                                sb.append(daughter.getName() + " ");
                            }
                            return evalOutput(sb.toString());
                        }
                    case SIBLINGS:
                        StringBuffer sb = new StringBuffer();
                        for (Person child : getSiblings(person.get())) {
                            sb.append(child.getName() + " ");
                        }
                        return evalOutput(sb.toString());
                    default:
                        throw new IllegalTraversalException("No such command.");
                }
            }
            catch (IllegalTraversalException e){
                return Constants.NONE;
            }
        }
    }

    private String evalOutput(String sb) {
        if (sb.length() > 0) {
            return sb.trim();
        } else {
            return Constants.NONE;
        }
    }
}
