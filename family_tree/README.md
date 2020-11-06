# Family com.akgs.algo.tree.Tree

## Introduction
This algorithm is used to create and traverse the family tree. This family tree is initialized to the following structure.

                           [Shan] ---- {Anga}
                                       |
                                       |
    -------------------------------------------------------------------------------------- 
    |                   |               |                       |                        |
    |                   |               |                       |                        |
    [Chit]--{Amba}     [Ish]            [Vich]--{Lika}          [Aras]--{Chitra}         {Satya}-[Vyan]
                 |                                  |                   |                |
                 |                                  |                   |                |
    -----------------------------         -----------       ---------------------        ---------------------------------------
    |                  |        |         |         |       |                   |        |                  |                  |
    |                  |        |         |         |       |                   |        |                  |                  |
    {Dritha}--[Jaya]   {Tritha} [Vritha]  {Vila}{Chika}     {Jnki}--[Arit]  [Ahit]       [Asva]--{Satvy}    [Vyas]--{Krpi}     {Atya}
    |                                                       |                                    |                  |
    |                                                       |                                    |                  |
    [Yodhan]                                                ----------------                     [Vasa]    ---------------         
                                                            |              |                               |             |
                                                            |              |                               |             |
                                                            {Lavanya} [Laki]                               {Krithi}      [Kriya]
NOTE: 
* In above tree, [] - Male, {} - Female
* Only Female can have children

Example: 
 ```
 ADD_CHILD Chitra Aria Female
 GET_RELATIONSHIP Lavnya Maternal-Aunt
 GET_RELATIONSHIP Aria Siblings
```
This should print
```$xslt
CHILD_ADDITION_SUCCEEDED
Aria
Jnki Ahit
```

Another example, 
```
 ADD_CHILD Chitra Aria Female
 GET_RELATIONSHIP Aria Paternal-Aunt
 GET_RELATIONSHIP Lavnya Maternal-Uncle
```
This should print
```$xslt
CHILD_ADDITION_SUCCEEDED
Satya
Ahit
```
## Build
1.Build and test
```shell script
gradle build
```
2.Test
   ```shell script
   gradle test -i
   ```
3.Create Jar
```shell script
gradle jar
```
'geektrust.jar' JAR will be created in `build/libs` folder

## Run
`java -jar geektrust.jar <file-name>`

`<file-name>` is the name of the file containing below commands.

## Commands
Below are the supported commands that can be added to input file.
* ADD_CHILD, format: ADD_CHILD <name> <child-name> <Male|Female>
* ADD_SPOUSE, format: ADD_SPOUSE <name> <spouse-name>
* GET_RELATIONSHIP, format: GET_RELATIONSHIP <name> <relationship-type>
 <p>Allowed relationship-type:
 <ul>
 <li>PATERNAL-UNCLE: Father's Brothers</li>
 <li>MATERNAL-UNCLE: Mother's Brothers</li>
 <li>PATERNAL-AUNT: Father's Sisters</li>
 <li>MATERNAL-AUNT: Mother's Sisters</li>
 <li>SISTER-IN-LAW</li>
 <li>BROTHER-IN-LAW</li>
 <li>SON</li>
 <li>DAUGHTER</li>
 <li>SIBLINGS</li>
 </ul>
 </p>