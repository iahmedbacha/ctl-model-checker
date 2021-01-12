# CTL Model Checker
# Overview
A [CTL (Computation Tree Logic)](https://en.wikipedia.org/wiki/Computation_tree_logic "CTL (Computation Tree Logic)") model checker having as input a file containing a textual description of a [Kripke structure](https://en.wikipedia.org/wiki/Kripke_structure_(model_checking) "Kripke Structure") and a file containing a CTL formula.
## Input format
### Kripke structure
- The first line of input contains a single integer, n (the number of states).
- The next line contains n space-separated strings describing the respective designations for states.
- The next line contains a single integer, m (the number of initial states).
- The next line contains m space-separated strings describing the respective designations for initial states.
- The next line contains a single integer, x (the number of transitions).
- Each line i of the x subsequent lines contains two space-separated integers describing the respective designations of source state and destination state for the transition i.
- The next line contains a single integer, y (the number of states that have interpretations).
- Each line j of the y subsequent lines describes interpretations for state j as a space-separated tokens. Each line takes the following form:
    - The first token denotes the designation for state j.
    - The second token, z, denotes the number of propositions for state j.
    - The rest of the line contains z space-separated strings describing the respective designations of propositions for state j.
### CTL formula:
[Check grammar file](./app/src/main/antlr/CTL.g4).
## Output format
A single line that contains space-separated strings describing the respective designations for states that satisfies the CTL formula.
# Usage
## Requirements
- Gradle: for building the jar file.
- Java: for executing the jar file.
## Steps
1- Clone this repository.
```
git clone git@github.com:iahmedbacha/ctl-model-checker.git
```
2- At the root of the project, build the jar file:
```
gradle build
```
3- Find the generated jar file in:
```
./app/build/libs/app-all.jar
```
4- Assuming app-all.jar, kripke.txt and formula.txt are in the same folder, execute:
```
java -jar app-all.jar kripke.txt formula.txt output.txt
```
5- Find the result in output.txt.
## Examples
Find examples of a Kripke structure and CTL formulae [here](./app/src/test/resources). 
# Contributing
Contributions are always welcome!
# TODO
- Add tests.