package com.akgs.algo.familytree.model;

import java.util.*;

public class Female extends Person {
    private Map<String, Person> children;
    public Female(String name, Female mother) {
        super(name, GENDER.FEMALE, mother);
        children = new LinkedHashMap<>();
    }

    public void addChild(Person child) {
        if(children.get(child.getName()) != null){
            throw new IllegalStateException("Child "+child.getName()+" already exists. Cannot add another child bearing same name.");
        }
        children.put(child.getName(), child);
    }

    public boolean hasChild(String childName) {
        return children.get(childName)!=null;
    }

    public Collection<Person> getChildren() {
        return children.values();
    }

    public List<Male> getSons() {
        List<Male> sons = new ArrayList<>();
        Collection<Person> children = getChildren();
        for(Person child: children){
            if(child.getGender() == GENDER.MALE)
                sons.add((Male)child);
        }
        return sons;
    }

    public List<Female> getDaughters() {
        List<Female> daughters = new ArrayList<>();
        Collection<Person> children = getChildren();
        for(Person child: children){
            if(child.getGender() == GENDER.FEMALE)
                daughters.add((Female)child);
        }
        return daughters;
    }
}
