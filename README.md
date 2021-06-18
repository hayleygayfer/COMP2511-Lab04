# Lab 04

### Due: Week 4 Sunday, 5pm

### Value: 2% of course mark

## Aims

* Apply the strategy and state patterns

## Setup

An individual repository for you for this lab has been created for you on the CSE GitLab server. You can find it at this URL (substituting z5555555 for your own zID):

[https://gitlab.cse.unsw.edu.au/COMP2511/21T2/students/z5555555/21T2-cs2511-lab04](https://gitlab.cse.unsw.edu.au/COMP2511/21T2/students/z5555555/21T2-cs2511-lab04)

**REMEMBER** to replace the zID below with your own.

`git clone gitlab@gitlab.cse.unsw.EDU.AU:COMP2511/21T2/students/z555555/21T2-cs2511-lab04.git`

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

The below list indicates a transition via `=>` and an action via `:`.  Your task is to represent this as either a state table (as per lectures) or as a state diagram (from 1531 if you find that more convenient).  To help you start the following image shows just a small section of the below requirements, you'll want to extend on this to add the rest.

<img src="imgs/SimplifiedStateDiagram.png" height=600 />

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
  - If tool = box-select and `Primary Mouse Button` released => SelectionState
- ConstantAspectRatioDraggingState : Represents a dragging operation where width = height = min(width, height)
  - Abscense of `Shift` (i.e. no longer holding the key down) => DraggingState
  - `Esc` => SimpleState
  - If tool = box-select and `Primary Mouse Button` released => SelectionState
- SelectionState : A region has been selected and you can move that region around by clicking on it and dragging it around.
  - Clicking outside selection => State prior to this operation (i.e. ShapeState for box-select)
    - Will clear all copy/cut history
  - `Ctrl` + `d` : Clear out selection => State prior to this operation (i.e. ShapeState for box-select)
  - `Ctrl` + `c` : Copy the region
  - `Ctrl` + `x` : Mark region as cut, should not be cleared until region is pasted
  - `Ctrl` + `v` If copied or cut : Paste region (clearing selected region if marked as copied) => SelectionState for new region (forget old region)

ASHESH: Should we add an example state table for this too?

> For simplicity the SimpleState `Esc` is implemented within the CanvasController and is external to the State Machine, you should still include it in your table / diagram.

## Lab 04 - Exercise - The Crown's Gambit - Strategy Pattern

Checkers is a classic game with some relatively simple rules.  An example board looks like below

TODO: Img

It's a 2 player game, in our version the pieces are red and white to represent the two different players.  Red goes first.

Each player takes their turn by moving a single piece diagonally forwards (towards the opponent) to the next dark square.

If there is a piece diagonally adjacent to one of your checkers you can 'jump' over that piece to the empty square on the other side.
  - If there isn't an empty square (i.e. 2 of red's pieces are placed diagonally adjacent) then you can't jump over both of them at the same time.
  - However, you can perform multiple jumps in a single turn given that there is an empty space between each piece.

If a piece makes it all the way to the end it 'crowns' gaining a unique symbol and the ability to move in both directions (forwards and backwards).

TODO: Img showing crown + jumps

A player loses once they no longer have any more checkers available.

There are a few additional 'options' that are configurable upon defining a new game, you should add a checkbox to the main menu to represent them;

- `Force Jump` if this is set then the player should be forced to take a jump if it's available.
- `The Quackering` randomly causes half the pieces to develop madness... where they can jump over 2 pieces which are placed diagonally sequential (as per the image below) BUT they can't chain jumps and still require an empty space after the 2 pieces.  These pieces should use the asset `mad-red.png` and `mad-white.png` respectively.

TODO: Img for quackering + force jump

## Lab 04 - Challenge Exercise - Hotel Refactor 🏨

> For extra practice of test driven refactoring.

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

## Submission

To submit, make a tag to show that your code at the current commit is ready for your submission using the command:

```bash
$ git tag -fa submission -m "Submission for Lab-03"
$ git push -f origin submission
```

Or, you can create one via the GitLab website by going to **Repository > Tags > New Tag**. 

We will take the last commit on your `master` branch before the deadline for your submission.
