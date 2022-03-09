# Formal Languages

In computer science theory, an _alphabet_ is a set of characters and a _formal language_ (or just _language_) is a set of strings that is only allowed to use characters from the alphabet. Typically _A_ is used to represent the alphabet and _L_ is used to represent the language.

_Example:_ _L_\={00,01,10,11} is a language over alphabet _A_\={0,1}. All four elements of _L_ are strings using _A_.

Since a string of length zero is legal but hard to see on paper, *λ* (a greek lambda) is used to represent it. (Some books use greek epsilon _ε_ instead, so you may sometimes see that.)

In CSC 28 we looked at two tools for specifying languages: the regular expressions (RE) and finite automata (FA). Here is a quick review of the two.

## Regular expressions

The _syntax_ of a RE is the rules for assembling a legal one.

- If _x_ is in alphabet _A_, then _x_ is a RE.
- ( ) and λ are REs.
- If _R_ is a RE, then _R\*_ and (_R_) are both REs.
- If _R1_ and _R2_ are REs then _R1R2_ and _R1_+_R2_ are both REs.

Nothing else is a RE. In other words, every RE using alphabet _A_ can be built up by repeatedly applying these rules.

The _semantics_ of a RE is the meaning of the RE. The key idea here is that every RE represents a set of strings.

- If _x_ is in alphabet _A_, then RE _x_ represents the set {_x_} (ie, a set with one string of length 1).
- ( ) represents a set with no strings in it { }.
- λ represents a set with one length 0 string in it {λ}.
- If _R_ is a RE representing the set of strings _X_, then (_R_) represents _X_ too. Parentheses around REs are used only for clarity and/or changing the order of evaluation.
- If _R_ is a RE representing the set of strings _X_, then _R\*_ represents the set of all strings you can make by taking zero or more copies of strings from _X_ and concatenating them together. (This is called the Kleene star operation.)
- If _R1_ and _R2_ are REs representing sets of strings _X_ and _Y_, respectively, then _R1R2_ represents the set of strings you could create by starting with any string from _X_ and following it with any string from _Y_. (This is called the concatenation operation.)
- If _R1_ and _R2_ are REs representing sets of strings _X_ and _Y_, respectively, then _R1_+_R2_ represents the set of strings _X_ ∪ *Y*. (This is called the union operation.)

The order of evaluation is handled similarly to the PEMDAS you learned for algebra. Parenthesis can be used to make it clear or change what order the operations should be applied, but if parentheses are not used, Kleene star has highest precedence (like exponentiation would in standard algebra), concatenation is next (like multiplication would come next in algebra), and union has lowest (like addition would in algebra).

Note! If you have some experience using regular expressions in computer applications, you will notice that this module is not quite the same. REs for computer applications have lots of extra convenience features and slightly different notation. For this module you are restricted to just use the features described above.

## Examples

It is fairly simple to take a RE and figure out what set of strings it represents. Just follow these steps.

1. Turn all of the "atomic" REs into the sets they represent (ie, _x_, ( ), and λ to {_x_}, { }, and {λ}).
2. Apply the Kleene star to the sets its attached to.
3. Apply concatenation to pairs of adjacent sets.
4. Union sets that have a + between them.
5. Do these operations in a different order if parenthesis say so.

_Example:_ ba\* becomes {b}{a}\* after turning a and b into their sets. {b}{a}\* becomes {b}{λ,a,aa,aaa,...} after applying the Kleene star. {b}{λ,a,aa,aaa,...} becomes {b,ba,baa,baaa,...} after concatenating. So, the RE ba\* represents the set of all strings that are 1 b followed by any number of a's (including zero a's).

_Example:_ (a+b)\* becomes ({a}+{b})\* becomes {a,b}\* becomes {λ,a,b,aa,ab,ba,bb,aaa,aab,aba,abb,...}. So, (a+b)\* represents the set of all strings of all lengths you can make using a and b.

_Example:_ a(a+b)\*a+b(a+b)\*b becomes {a}({a}+{b})\*{a}+{b}({a}+{b})\*{b} which becomes {a}{a,b}\*{a}+{b}{a,b}\*{b} which becomes {a}{λ,a,b,aa,ab,ba,bb,...}{a}+{b}{λ,a,b,aa,ab,ba,bb,...}{b} which becomes {a,aa,ab,aaa,aab,aba,abb,...}{a}+{b,ba,bb,baa,bab,bba,bbb,...}{b} which becomes {aa,aaa,aba,aaaa,aaba,abaa,abba,...}+{bb,bab,bbb,baab,babb,bbab,bbbb,...} which becomes {aa,bb,aaa,aba,bab,bbb,aaaa,aaba,abaa,abba,...,baab,babb,bbab,bbbb,...}. So a(a+b)\*a+b(a+b)\*b represents the set of all strings of length 2 or more that begin and end in the same letter.

Two things I want you to notice in these examples. Kleene star always includes λ because you are allowed to take zero items from the set, and by convention this means the empty string. Also, I'm listing my sets in length order: shorter strings are listed first and same length strings are listed in sorted order (I will ask you to do this on quizzes too).

## Finite Automata

The formal definition of a finite automata (sometimes called a deterministic finite automata and abbreviated FA or DFA) has five parts.

_A_, and alphabet _S_, a finite set of state labels _si_, a start state that must be an element of _S_ _Y_, a set if final or "accept" states that must be a subset of _S_ _F_ : _S_ x _A_ → _S_, a function that maps a state and an alphabet character to a state

The way a FA works is that it's presented with a string over the alphabet as input and the FA outputs "accept" or "reject" according to the following algorithm.

The way a FA specifies a language is that we say "the language of the FA" is the set of strings for which it outputs "accept". If _M_ is a FA and _M_(_s_) represents the output of _M_ when given _s_ as input, then the language defined by _M_, is expressed using set notation as _L_(_M_) = { s | _M_(_s_) == "accept" }.

The definition above, where FA _M_ is defined as a five-tuple (_A_, _S_, _s_i, \_Y_, _F_) is quite abstract and mathematical. That's how it needs to be if you want to, for example, have a computer simulate the FA. But humans do better with graphical representations of FA, which you will see in other videos and documents in this module.

## Generators and Recognizers

In a way you can think of a RE as a "generator" of a language because our algorithm for determining the meaning of a RE starts with a compact notation and generates a sometimes much larger set of strings.

On the other hand, a FA doesn't generate anything. But an FA does have the ability to recognize strings by outputting "accept". In this sense it "recognizes" a particular language.

Something you will look at more closely in CSC 135, is the fact that REs and FAs have the same expressive power. For every language that a RE can generate, there is a FA that recognizes it, and vice versa.

## Notation

When talking about strings and sets of strings, the following notations are sometimes used.

An _alphabet_ is a set of arbitrary symbols. It's usually alphanumeric, so above I called the contents characters. But, technically they could be any symbols, like _A_ = {♣,♠,♥,♦}. To keep the problem size small, alphabets used for teaching tend to be small, like {0,1}, {a,b}, or {a,b,c}, but in real life they are often quite large like the Unicode character set which contains thousands of characters, symbols and emojis.

A _string_ is a sequence of symbols from the alphabet. I use λ to represent the length 0 string. Don't confuse λ, { }, and {λ}. You can differentiate them in your mind based on their type and/or size. λ is a string, { } is a set with 0 elements, {λ} is a set with 1 element.

If _s_ and _t_ are strings, then _st_ is their concatenation. So if _s_ = abc and _t_ = def, then _st_ = abcdef.

If _s_ is a string or symbol, _sn_ is _s_ repeated _n_ times. So, a3 = aaa and (ab)3 = ababab.

If _S_ and _T_ are sets of strings, then _ST_ = { _st_ | _s_ ∈ *S* and _t_ ∈ *T* } (ie, all strings that can be made from one element of _S_ followed by one element of _T_). For example, {ab,bc}{a,b} = {aba, abb, bca, bcb}.

If _S_ is a set of strings or symbols, _S_\* = {λ} ∪ { _s_ | _s_ ∈ _S_ } ∪ { _st_ | _s,t_ ∈ _S_ } ∪ { _stu_ | _s,t,u_ ∈ _S_ } ∪ ... (ie, _S_\* is the set of strings that can be made by copying zero or more elements of _S_ and concatenating them). For example {a,b}\* = {λ, a, b, aa, ab, ba, bb, aaa, ...} and {a,ab}\* = {λ, a, aa, ab, aaa, aab, aba, aaaa, ...}. Sometimes you see this notation to assert that a string _s_ is over a particular alphabet, _s_ ∈ _A_\*.

If _M_ is a recognizer (such as a DFA) then _L_(_M_) is the set of strings accepted by _M_. If _R_ is a generator (such as a regular expression) then _L_(_R_) is the set of strings that can be generated by _R_.
