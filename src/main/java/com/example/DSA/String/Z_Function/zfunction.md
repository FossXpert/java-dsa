String:

```
s = "abaabaab"
     0 1 2 3 4 5 6 7
```

We use the **inclusive** version (`[L, R]`).

Initial state:

```
Z = [0, ?, ?, ?, ?, ?, ?, ?]
L = 0, R = 0
```

Now step by step:

---

### i = 1

`i > R` → compare from scratch
`b` vs `a` → mismatch

```
Z[1] = 0
L = 0, R = 0
```

---

### i = 2

`i > R` → compare
`a` == `a` → 1 match
next: `a` vs `b` → stop

```
Z[2] = 1
i + Z[i] - 1 = 2
> R → update window
L = 2, R = 2
```

---

### i = 3

`i > R` → compare
Matches: `a b a a b` (5 chars)

```
Z[3] = 5
i + Z[i] - 1 = 7
> R → update window
L = 3, R = 7
```

---

### i = 4

`i <= R` → inside window

```
R - i + 1 = 4
i - L = 1 → Z[1] = 0

Z[4] = min(4, 0) = 0
(no extension)

L = 3, R = 7 (unchanged)
```

---

### i = 5

Inside window:

```
R - i + 1 = 3
i - L = 2 → Z[2] = 1

Z[5] = min(3, 1) = 1
(no extension)

L = 3, R = 7
```

---

### i = 6

Inside window:

```
R - i + 1 = 2
i - L = 3 → Z[3] = 5

Z[6] = min(2, 5) = 2
(no extension)

L = 3, R = 7
```

---

### i = 7

Inside window:

```
R - i + 1 = 1
i - L = 4 → Z[4] = 0

Z[7] = min(1, 0) = 0
```

---

Final result:

```
Index: 0 1 2 3 4 5 6 7
Z:     0 0 1 5 0 1 2 0
```

And the window evolution was:

* After `i=2` → `L=2, R=2`
* After `i=3` → `L=3, R=7`
* From `i=4` to `i=7` → window stays `L=3, R=7`


this part i do no understand why we need to use this line
R - i + 1 = 1

Think of it like this in the most basic, non-algorithm way.

When we say:

> “We must not assume matches beyond what is already proven (R)”

we literally mean:

You have only *checked* and *verified* characters up to position `R`.
Everything after `R` is **unknown** — you have not compared it yet.

So:

* From `L` to `R` → you **know for sure** these characters match the prefix
* After `R` → you **don’t know anything yet**

Now suppose you are at position `i` inside that window.

You know this much is safe:

```
i, i+1, i+2, ..., R
```

How many characters is that?

```
R - i + 1
```

That number simply means:

> “From `i`, this many characters are already confirmed to match.”

Anything beyond that would be a *guess*.

So when we write:

```cpp
z[i] = min(R - i + 1, z[i - L]);
```

it means:

* `z[i - L]` says: “In the prefix, the match can be this long.”
* `R - i + 1` says: “But here, I have only checked up to R.”

We choose the smaller one because:

> We are only allowed to trust what we have already verified.

If we didn’t do this, we would be *pretending* that characters after `R` match — without ever comparing them.

So “not assuming beyond R” simply means:

**Do not believe in matches in positions you have never checked.**
