# Garage Parking System

An object-oriented **parking garage management system** in Java, built as a software design course project. It covers the full design process, from requirements and design documents to a working console application.

## Features

- **Configurable garage:** set the number of slots and the size of each slot.
- **Vehicle parking with pluggable slot-allocation strategies:**
  - **First-In-First-Served:** takes the first free slot that fits the vehicle.
  - **Best Fit:** takes the smallest free slot that fits the vehicle, in either orientation, to reduce wasted space.
- **Park in and park out** flows, with arrival and departure times tracked.
- **Fee calculation** based on how long the vehicle stayed.
- **Sensors** that track which slots are occupied.
- **Authentication** for garage operators.
- **Edge-case handling** (`CornerSituations`), such as a full garage or invalid input.

## Design

The allocation strategies implement a common `Config` interface (**Strategy pattern**), so a new strategy can be added without touching the rest of the system. Responsibilities are split into focused classes: `Garage`, `Slots`, `Vehicle`, `Sensors`, `FeesCalculation`, `ParkIn`/`ParkOut`, and `ConsolUi`.

The Software Requirements Specification (SRS) and Software Design Specification (SDS) documents are included in the repo.

## Getting started

```bash
javac *.java
java Main
```

## License

[MIT](LICENSE)
