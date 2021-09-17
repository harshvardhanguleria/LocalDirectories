male(eddard).
male(robb).
male(brandon).
male(rickon).

female(catelyn).
female(sansa).
female(arya).

parent_of(robb, eddard).
parent_of(sansa, eddard).
parent_of(arya, eddard).
parent_of(brandon, eddard).
parent_of(rickon, eddard).
parent_of(robb, catelyn).
parent_of(sansa, catelyn).
parent_of(arya, catelyn).
parent_of(brandon, catelyn).
parent_of(rickon, catelyn).

father_of(C, F) :- male(F),
                   parent_of(C, F).
mother_of(C, M) :- female(M),
                   parent_of(C, M).
brother_of(S, Bro) :- male(Bro),
                      father_of(S, F),
                      father_of(Bro, F),
                      S \= Bro.
sister_of(S, Sis) :- female(Sis),
                     mother_of(S, M),
                     mother_of(Sis, M),
                     S \= Sis.
