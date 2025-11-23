# Higher or Lower – Card Game (Java CLI)

## Overview
This project is an implementation of a command-line *Higher or Lower* card game written in Java.  
It models a standard 52-card deck, allows the player to guess whether the next card will be higher or lower, tracks lives and scores, and maintains a persistent leaderboard stored on disk.

The codebase follows industry best practices with an emphasis on:

- Clean architecture
- High cohesion and low coupling
- Test-driven development (TDD)
- Single Responsibility Principle (SRP)
- Readability and maintainability
- Professional testing practices using JUnit 5 and Maven

---

## Project Goals
The aim was to build a clear, extensible system that demonstrates:

- Strong foundational understanding of object-oriented programming
- Sensible separation of concerns
- Confidence with Java collections, file I/O, unit testing and refactoring
- Incremental, agile-style development
- Ability to structure a project using Maven
- Use of enumerations for stable, type-safe domain concepts

---

# Design Decisions

## 1. Use of Enums for Suits and Ranks
Enums were used to represent `Suit` and `Rank` because:

- They provide *type safety* compared with raw integers or strings
- They reduce coupling by preventing invalid values
- They support behaviour (e.g., `getValue()`, `getSymbol()`) leading to high cohesion
- They eliminate magic numbers and string duplication
- They express domain concepts explicitly

This follows the principle that **important domain ideas should be modelled explicitly in the type system**.

---

## 2. Single Responsibility Principle (SRP)
Each class has one clear responsibility:

| Class | Responsibility |
|-------|----------------|
| **Card** | Represents a single playing card |
| **Deck** | Creates, stores, shuffles and draws from the deck |
| **Player** | Stores player name, lives and score |
| **GameEngine** | Runs the main game loop and user interaction |
| **Leaderboard** | Loads, saves and sorts high scores |
| **LeaderboardEntry** | Represents an entry in the leaderboard |

This improves maintainability, reduces bugs, and makes future extension straightforward.

---

## 3. Low Coupling
The system is designed so components depend on clear, minimal interfaces:

- `GameEngine` only interacts with `Deck` through its public methods
- `Leaderboard` manages all file I/O internally
- Enums encapsulate card characteristics
- Models/classes do not depend on implementation details of others

Low coupling increases flexibility and supports easy refactoring or feature additions such as Jokers, a GUI or alternative game modes.

---

## 4. Maven Project Structure
The project uses Maven to provide:

- Dependency management (JUnit 5, Surefire plugin)
- Standardised folder layout
- Easy test discovery
- Compatibility with CI tools
- Simpler project setup for both development and evaluation

---

# Test-Driven Development (TDD)

A TDD workflow was used for all pure-logic components:

1. **Write a failing test** describing expected behaviour
2. **Implement the minimum code required to pass the test**
3. **Refactor** while keeping the tests green

This approach ensured a robust and well-structured codebase.

TDD was applied particularly to:

- `Deck`
- `Card`
- `Player`
- `Rank`
- `Suit`
- `LeaderboardEntry`

As a result, these classes have **high, often complete test coverage**.

---

# Testing Strategy

## ✔ Fully Tested Components
- Deck
- Card
- Player
- Rank
- Suit
- LeaderboardEntry

These classes contain deterministic, side-effect-free logic and are ideal for unit testing.

---

## ⚠ Partially Tested Components

### Leaderboard
The `Leaderboard` class handles file I/O, sorting and persistence.

Unit tests cover:

- Adding entries
- Sorting entries
- Saving and loading entries using a **temporary file**
- Persistence of data between program executions

To make this testable, a second constructor was added allowing the test suite to inject its own temporary file (a standard dependency-injection technique).

### Methods intentionally not tested:

#### `printLeaderboard()`
Not tested because:

- It only prints to `System.out`
- Contains no business logic
- Capturing console output is brittle and not necessary

#### Exception catch blocks
These only log messages; there is no meaningful logic to assert.

Testing these would require mocking file failures, which is unnecessary for this project and does not reflect real-world value.

---

# Agile / Iterative Development

The project was developed iteratively, taking inspiration from agile values:

1. **Start with a minimal playable game**
2. Add features incrementally, including:
    - Lives
    - Input validation
    - Replay system
    - Leaderboard
    - Persistent storage
    - Unit tests
3. **Refactor continually** to improve cohesion and readability
4. **Run the tests after each change**

This mirrors professional software workflows and demonstrates adaptability and incremental delivery.

---

# Gameplay Summary

- The player begins with 3 lives
- A card is displayed
- The player guesses whether the next card will be higher or lower
- Correct guesses increase the score
- Incorrect guesses cost a life
- Equal cards incur no penalty
- The game ends when the deck is empty or the player runs out of lives
- The final score is recorded to the leaderboard

---

# Leaderboard Persistence

Scores are saved in `leaderboard.txt` and loaded on startup.

The leaderboard:

- Stores player name and final score
- Sorts entries in descending order
- Writes updated results to file after each game

This ensures the history of plays persists between sessions.

---

# Future Improvements

Possible extensions include:

- Adding Jokers
- Multiple game modes (e.g., “Snap”, “Higher/Lower Streak”)
- A graphical user interface using JavaFX
- Online or networked leaderboard
- Custom game settings (lives, deck size, difficulty)
- Robust logging using a logging framework
- More advanced statistics or analytics

---

# Conclusion

This project demonstrates:

- Careful object-oriented design
- Strong separation of concerns
- Thoughtful use of enums and data modelling
- Clean, maintainable architecture
- Effective use of Maven and JUnit
- Agile-inspired iterative development
- Test-driven development for core components
- Understanding of what is and is not valuable to unit test

It reflects a professional mindset and a commitment to producing high-quality, reliable software.

