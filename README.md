# Project:Structures - Hash table

## Story

An _associative array_ (also called as a _map_ or a _dictionary_) is an
abstract data type (ADT) that holds key-value pairs. Keys are unique in
associative arrays, but multiple keys can hold the same value.

A _hash table_ or _hash map_ is a _data structure_ that implements
an associative array by utilizing _hash functions_ to make the lookup
(finding the value for a key) effective. On the average, a
well-implemented and properly used hash table has the following
time complexity characteristics:

- _get_ a value by key: `O(1)`
- _insert_ a new key-value pair: `O(1)`
- _remove_ an element by key: `O(1)`

This very impressive behavior is better than other associative array
implementations, but unfortunately it easily can get much worse. This
is one of the reasons why it is important to understand what's happening under the hood in a hash table.

