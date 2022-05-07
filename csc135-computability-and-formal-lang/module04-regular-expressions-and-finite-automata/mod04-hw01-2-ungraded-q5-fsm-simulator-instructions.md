# FSM simulator instructions

The simulator at [http://ivanzuzak.info/noam/webapps/fsm\_simulator/](http://ivanzuzak.info/noam/webapps/fsm_simulator/) is useful for visualizing and testing FA. We will also use its text format for quizzes.

To see a sample:

1. Click on "input automaton" tab.
2. Click on "Generate random DFA" button.

The text box gets filled with a randomly generated FA. The `#states` section is a list of state labels. `#initial` is the start state and should have exactly one state label. `#accepting` is a list of zero or more accept states. `#alphabet` should list all the characters in your machine's alphabet. Finally, `#transitions` is a list of all the arrows in your FA. Each arrow should be formatted as `(source state):(character consumed)>(destination state)`.

Clicking the "Create automaton" button will generate a drawing. The drawing usually isn't pretty, but should be correct. You can put a string in the "Simulate automaton" text box and have the simulator step through your string if you wish.

## NFA

You can similarly work with NFA. To see a random NFA click the "Generate random NFA" button. An "eNFA" allows lambda transitions (this website calls them epsilon transitions), whereas the "NFA" at this website do not. The NFA we have been talking about in class would be called eNFA at this website.

For ease of typing, this website uses `$` to represent a lambda transition.

## Example

The first NFA in [the NFA notes](https://krovetz.net/135/module_reg/nfa.html) could be represented as follows.
