# Lab 04

### Due: Week 4 Sunday, 5pm

### Value: 2% of course mark

## Aims

* Apply the strategy and state patterns

## Setup

An individual repository for you for this lab has been created for you on the CSE GitLab server. You can find it at this URL (substituting z5555555 for your own zID):

https://gitlab.cse.unsw.edu.au/z5555555/21T2-cs2511-lab04

You will need to log in with your zID and zPass. If you are unable to login please speak to your tutor or lab assistant.

## Lab 04 - Exercise - The Queen's Gambit

### Part 1 - State Pattern

Inside the `gambit` package there is functionality which sets ups a game of chess and has the logic for some of the basic rules of movement of chess pieces. 

Currently, the code uses inheritance to implement pieces, where `Piece` is an abstract class and `King`, `Queen`, `Pawn`, `Bishop`, `Rook`, `Knight` all extend from this superclass. This inheritance makes sense. But what happens when we try to implement a rule such as [Promotion](https://en.wikipedia.org/wiki/Promotion_(chess))? We all know that when a Pawn reaches the end of the board, it can become a Queen (or a Bishop, Rook or Knight). It would be fair to say that the piece changes state. 

Refactor the code to use a **State Pattern** to model pieces in the chess game. That is, at any given point in the game, a piece is a `King`, `Queen`, `Pawn`, `Bishop`, `Rook`, or `Knight`, and this can change.

Implement the rule of Promotion within the `ChessGame` class.

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


## Submission

To submit, make a tag to show that your code at the current commit is ready for your submission using the command:

```bash
$ git tag -a submission
```

Or, you can create one via the GitLab website by going to **Repository > Tags > New Tag**. 

We will take the last commit on your `master` branch before the deadline for your submission.
