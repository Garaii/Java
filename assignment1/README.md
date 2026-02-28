# 🐝 Bee vs Hornets – Java OOP Game

A turn-based strategy game built in **Java** using object-oriented programming principles.
Bees defend their hive against invading hornets along a connected tile path.

## 🎮 Game Overview

* Hornets move from their **nest** toward the **hive**
* Bees defend by attacking, collecting food, or using special abilities
* The game ends when hornets reach the hive or are eliminated

## 🧱 Core Concepts

* **Inheritance & Polymorphism**
* **Abstract classes & method overriding**
* **Encapsulation**
* **Game state management**
* **Tile-based path system**

## 🐝 Units Implemented

### Basic Units

* `HoneyBee`
* `BusyBee` (collects food)
* `AngryBee` (attacks nearby hornets)
* `Hornet`

### Special Units (Step 4)

* 🔥 **FireBee** – Sets tiles on fire, causing ongoing damage
* 🎯 **SniperBee** – Long-range piercing attack (two-turn mechanic)
* 👑 **Hornet Queen** – Acts twice per turn and boosts swarm regeneration

## 🔥 Special Mechanics

* Tiles can be **on fire**
* Fire causes **ongoing damage**
* Queen hornet grants **health regeneration boost**
* Sniper bees alternate between **aiming and shooting**

## 🛠 Technologies

* Java
* OOP design patterns
* Custom game logic (no external libraries)
