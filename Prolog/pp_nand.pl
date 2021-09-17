dance(nand).

mother_of(nand, aunty).

happy_mother(X, Y) :- mother_of(X, Y), dance(X).

happy_me(X, Y) :- happy_mother(X, Y).
