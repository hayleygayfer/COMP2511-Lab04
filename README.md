# Lab 04

### Due: Week 4 Sunday, 5pm

### Value: 2% of course mark

## Aims

* Apply the strategy and state patterns

## Setup

An individual repository for you for this lab has been created for you on the CSE GitLab server. You can find it at this URL (substituting z5555555 for your own zID):

https://gitlab.cse.unsw.edu.au/z5555555/21T2-cs2511-lab04

You will need to log in with your zID and zPass. If you are unable to login please speak to your tutor or lab assistant.

## Lab 04 - Exercise - Hotel Refactor 🏨

Inside `src/refactor`, there is a poorly designed solution for a Hotel Booking System according to the following requirements:

* Hotels have a name and a series of rooms
* Rooms are of size Small, Medium or Large
* Rooms can be booked from a start date to a checkout date
* A user of the system can request a booking by specifying a start date, and end date and a room size. If the room is successfully booked, they receive the booking number. If there is no available room of the given size for those dates, `-1` is returned.

### Refactoring

Refactor the code so that it adheres to design principles taught in lectures. Be prepared to explain your design changes to your lab assistant during marking. 

Things to consider include the Law of Demeter, Single Responsibility Principle, Open-Closed Principle, and using *enums*. An *enum* is a special sort class that represents a group of constants:

```java
enum CodingLevel {
    Greenie,
    Novice,
    Amateur,
    Intermediate,
    Advanced,
    Pro,
    Expert,
    Elite;
}
```

### Test Driven Refactoring

A very basic test is provided for you in `HotelBookingSystemTest.java` which currently passes. You should complete this exercise in the following order:

1. Design a single refactor to the code
2. Write out stubs for any new functions
3. Write JUnit tests for those new functions (they should fail)
4. Implement the functions so that the tests pass
6. Commit your changes with a message explaining the refactor (your lab assistant will check this during marking)
7. Repeat for each refactor!

This might seem slower than just doing it all in one go, but for larger systems, incremental completion is the only way to go about it (everything becomes a huge mess otherwise).

Remember to unit test individual components (`Hotel`, `Booking` classes and their methods) as well as the system working as a whole. You can modify/delete the provided test as you like.

## Lab 04 - Exercise - State Diagram / Table for Quaint

Quaint as explained in the tutorial is a paint application that has the following requirements;

- The ability to 'freehand' draw on a canvas
- The ability to draw rectangles by dragging out a region using my mouse
- The ability to draw ovals by selecting a start point then dragging out to expand the radius
- Hold shift to cause ovals & rectangles to have a 1:1 aspect ratio i.e. width = height (i.e. squares & circles)
- The ability to use a square eraser to remove mistakes
- The ability to change colours using a colour wheel for the stroke freehand, ovals, rectangles
- The ability to change stroke width between 10 and 100 pixels
- The ability to select an optional fill colour for rectangles and ovals
- The ability to save my picture out as a png to a location of my choosing
- Scroll should change the stroke width

More specifically we can build the various states 'selecting region', 'drawing', 'dragging', and so on as various different states.  Specifically the states are as follows;

> In reality you would probably implement some of these states as just booleans (i.e. ConstantAspectRatio) if they truly are that simple.

The below list indicates a transition via `=>` and an action via `:`.  Your task is to represent this as either a state table (as per lectures) or as a state diagram (from 1531 if you find that more convenient).  To help you start the following image shows just a small section of the below requirements.



- SimpleState : Just a normal cursor state, x + y position is shown above the mouse cursor
- PaintingState : A drawing tool was chosen such as freehand that has no drag enabled i.e. 'painting'
  - `Esc` => SimpleState
  - Pressing `Secondary Mouse Button` : Toggles between eraser tool and painting tool.
- CanvasActionState : A specialised drawing state that ends after a single 'action' i.e. placing an image or taking a colour from the canvas
  - `Esc` => SimpleState
  - Pressing `Primary Mouse Button` : Triggers action => SimpleState
- ShapeState : A drawing tool was chosen that enabled dragging over a region to define a shape.
  - `Esc` => SimpleState
  - `Primary Mouse Button` => DraggingState
  - `Shift` + `Primary Mouse Button` => ConstantAspectRatioDraggingState
- DraggingState : Represents a dragging operation with an action to perform after the drag has finished
  - `Shift` => ConstantAspectRatioDraggingState
  - `Esc` => SimpleState
  - If tool = box-select : action => SelectionState
- ConstantAspectRatioDraggingState : Represents a dragging operation where width = height = min(width, height)
  - Abscense of `Shift` (i.e. no longer holding the key down) => DraggingState
  - `Esc` => SimpleState
  - If tool = box-select : action => SelectionState
- SelectionState : A region has been selected and you can move that region around by clicking on it and dragging it around.
  - Clicking outside selection => State prior to this operation (i.e. ShapeState for box-select)
    - Will clear all copy/cut history
  - `Ctrl` + `d` : Clear out selection => State prior to this operation (i.e. ShapeState for box-select)
  - `Ctrl` + `c` : Copy the region
  - `Ctrl` + `x` : Mark region as cut, should not be cleared until region is pasted
  - `Ctrl` + `v` If copied or cut : Paste region (clearing selected region if marked as copied) => SelectionState for new region (forget old region)

> For simplicity the SimpleState `Esc` is implemented within the CanvasController and is external to the State Machine, you should still include it in your table / diagram.

## Lab 04 - Exercise - The Crown's Gambit



### Part 1 - State Pattern

Inside the `gambit` package there is functionality which sets ups a game of chess and has the logic for some of the basic rules of movement of chess pieces. 

Currently, the code uses inheritance to implement pieces, where `Piece` is an abstract class and `King`, `Queen`, `Pawn`, `Bishop`, `Rook`, `Knight` all extend from this superclass. This inheritance makes sense. But what happens when we try to implement a rule such as [Promotion](https://en.wikipedia.org/wiki/Promotion_(chess))? We all know that when a Pawn reaches the end of the board, it can become a Queen (or a Bishop, Rook or Knight). It would be fair to say that the piece changes state. 

Refactor the code to use a **State Pattern** to model pieces in the chess game. That is, at any given point in the game, a piece is a `King`, `Queen`, `Pawn`, `Bishop`, `Rook`, or `Knight`, and this can change.

Implement the rule of Promotion within the `ChessGame` class.

Before you start coding, create a UML Diagram which outlines the new structure of objects and relationships. You do not need getters or setters in this UML.

### Part 2 - Strategy Pattern

We are going to begin building our very own Chess AI!

For this task we are just going to build an AI that can play the **opening** to a chess game. We will use a Strategy Pattern to create a series of strategies which our AI can use, and it will choose one randomly when we create a new `AIPlayer` and start a game.

The Queen's Gambit, as well as being [Netflix's most watched series](https://en.wikipedia.org/wiki/The_Queen%27s_Gambit_(miniseries)), is named after a strategy to the opening of a chess game which we will implement.

The moves are as follows:

White moves the Queen's pawn two spaces forward:

<img src='imgs/gambit1.png' />

Black must respond by moving her own Queen pawn two spaces forward.

<img src='imgs/gambit2.png' />

White replies by bringing her queenside bishop's pawn two spaces forward.

<img src='imgs/gambit3.png' />

#### Starter Code

#### Task

Your task is to implement a Strategy Pattern for the making of moves by the `AIPlayer`, with the following strategies:

1. The Queen's Gambit
2. Another strategy out of the following: 
    * The Sicilian Defence
    * The Italian Game
    * The French Defence
    * The Ruy-Lopez
    * The Slav Defence

Model the pattern in your UML Diagram before writing any code.

### Challenge - The Mechanical Turk

TBA

## Submission

To submit, make a tag to show that your code at the current commit is ready for your submission using the command:

```bash
$ git tag -a submission
```

Or, you can create one via the GitLab website by going to **Repository > Tags > New Tag**. 

We will take the last commit on your `master` branch before the deadline for your submission.
