List ADT

Ordered: Items have a specific position within the list
        and that position is zero-indexed
Dynamic Size: Lists can grow or shrink as items are added or removed
Item Type: Items in a list can be of any data type

Common Operations on a List ADT
get(i): Returns the item at position i, i is zero indexed.
set(i, x): Sets the item at position i to item x, i is zero indexed.
insert(i, x): Inserts item x at position i, shifiting subsequent items, i is zero indexed.
remove(i): Removes the item at position i, shifiting subsequent items, i is zero indexed.
remove(x): Removes the first occurence of item x.
add(x): Adds item x to the end of the list.
size(): Returns the number of items in the list.
isEmpty(): returns true if the list is empty, false otherwise.
find(x): Returns the index of the first occurence of item x.
toString(): Returns a string representation of the list.