QuadTree Block Game
Overview

This project is a visual strategy game built using a quad-tree data structure. The game board is made of recursively defined square blocks. Each block is either a solid color or subdivided into four smaller blocks.

Players can modify the board by rotating, reflecting, or smashing blocks in order to maximize their score.

The project was adapted from an assignment originally created by Diane Horton and David Liu (University of Toronto).

Data Structure

The board is represented as a quad-tree:

Each node has either 0 or 4 children.

The top-level block is at level 0.

Each subdivision increases the level by 1.

The board has a maximum depth.

Child blocks always have half the size of their parent and correct updated coordinates.

Maintaining these invariants was an important part of the implementation.

Main Features
Board Generation

Blocks are generated recursively using a random process. A block may subdivide depending on its level and a probability function.

updateSizeAndPosition

Recursively assigns size and coordinates to a block and all of its children while ensuring the structure remains valid.

flatten

Converts the quad-tree into a 2D Color[][] array representing unit cells. This makes scoring much easier.

Transformations

rotate

reflect

smash

All transformations correctly propagate through the tree and maintain structural consistency.

Scoring

Two scoring goals are implemented:

Perimeter Goal: Counts unit cells of a target color on the border (corners count double).

Blob Goal: Finds the largest orthogonally connected group of a target color using a recursive flood-fill approach.

Large blocks count as the number of unit cells they would contain at maximum depth.

What I Learned

Implementing and maintaining recursive data structures

Applying recursion for traversal and transformations

Converting tree structures into 2D representations

Designing algorithms for connected components

Debugging complex recursive behavior
