## Validation Assumptions

- A valid triangle contains at least two rows and if row_i has n elements, then row_(i+1) must have n + 1 elements.
- A valid input in Stdin should consist of non-negative Integer values (0 <= value <= Int.MaxValue) and spaces

## Algorithm Assumptions

- An initial solution was done using Bottom-Up Dynamic algorithm with O(n^2) complexity, but it would disregard the history of nodes used on the sum (the exercise.pdf file describes the output as a string containing all nodes), therefore a new approach was required to keep history.
- The approach to keep history makes use of a map that keeps track of vertices and their minimum path child nodes. As bottom-up comparison occurs, the map is cleared from previous childVertice -> minimum path values to make plance to new currentVertice -> childVertice ++ minimumPath.