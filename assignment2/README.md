

# 🃏 Solitaire Cipher (Java)

A Java implementation of the **Solitaire Cipher**, built using a circular doubly linked list to simulate a deck of playing cards.

This project demonstrates advanced pointer manipulation, linked list operations, and algorithm implementation.

---

## 🚀 Features

* Circular doubly linked list deck structure
* Deep copy constructor
* Fisher–Yates shuffle (O(n))
* Joker movement
* Triple Cut (O(1))
* Count Cut (O(n))
* Keystream generation
* Message encoding & decoding

---

## 🧠 Concepts Used

* Data Structures (circular doubly linked list)
* Pointer reassignment (`prev` / `next`)
* Modular arithmetic
* Object-Oriented Programming
* Algorithm design

---

## 🔐 Encoding & Decoding

* **Encode:**
  `(message letter + keystream value) mod 26`

* **Decode:**
  `(message letter - keystream value + 26) mod 26`

Non-letter characters are removed and all letters are capitalized.

---

## 🎯 Purpose

Built to strengthen understanding of:

* Low-level pointer manipulation
* Edge case handling in circular structures
* Cryptographic algorithm implementation


