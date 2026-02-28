# QuadTree Block Game

## Overview

This project is a visual strategy game built using a quad-tree data structure. The game board is composed of recursively defined square blocks. Each block is either a solid color or subdivided into four equal sub-blocks.

Players manipulate the board by rotating, reflecting, or smashing blocks in order to maximize their score.

This project was adapted from an assignment originally created by Diane Horton and David Liu (University of Toronto).

---

## Data Structure

The board is represented as a quad-tree:

- Each node has either **0 or 4 children**
- The top-level block is at level 0
- Each subdivision increases the level by 1
- The board has a configurable maximum depth
- Child blocks always have half the size of their parent and correctly updated coordinates

Maintaining these structural invariants was a key part of the implementation.

---

## Main Features

### Random Board Generation
Blocks are generated recursively using a probability function based on the block’s level.

### `updateSizeAndPosition(int size, int xCoord, int yCoord)`
Recursively assigns size and coordinates to a block and all of its descendants while preserving invariants.

### `flatten()`
Converts the quad-tree into a 2D `Color[][]` array of unit cells. This simplifies scoring calculations.

### Transformations
- `rotate(int direction)`
- `reflect(int direction)`
- `smash()`

All transformations correctly propagate through the tree and maintain structural consistency.

---

## Scoring System

### Perimeter Goal
Counts unit cells of a target color on the outer border of the board. Corner cells count double.

### Blob Goal
Finds the largest orthogonally connected group of a target color using a recursive flood-fill algorithm.

Large blocks count as the number of unit cells they would contain at maximum depth.

---

## Concepts Practiced

- Recursive data structures (quad-trees)
- Tree traversal and structural updates
- Recursion for transformations and scoring
- 2D array representation of hierarchical data
- Connected component (flood-fill) algorithms
- Maintaining data structure invariants
