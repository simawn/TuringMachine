# Turing Machine

A standard Turing Machine simulator in Java under those assumptions:
- The tape is infinite on both side
- Allowed directions: Left, Right
- Deterministic
- The empty symbol is denoted with '#'
- All the state names are integers

Accepts a file that contains the information about the TM:
- Initial State
- Final State(s)
- Transition functions

Following the format for transition function:
```sh
δ(q1, a) = (q2, b, r)
```
(Current in state 'q1', reading an 'a', go to state 'q2', write 'b', move right)

The input format of the .txt should be:
```sh
<Initial state>
<List of final states>
<Current state> <Read> <Next State> <Write> <Move>
<Current state> <Read> <Next State> <Write> <Move>
<Current state> <Read> <Next State> <Write> <Move>
...
```

Example transition.txt:
```sh
0
0 5
0 a 1 x r
1 a 1 a r
```
