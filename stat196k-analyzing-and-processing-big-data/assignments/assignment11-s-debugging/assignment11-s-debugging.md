# Assignment11: S - Debugging

Resources:

<http://webpages.csus.edu/fitzgerald/julia-debugger-tutorial/>

<https://github.com/clarkfitzg/stat196K/blob/main/990.jl>

The questions refer to this example:

```julia
julia> function f(x, a = 1, b = 0)
       a*x + b
       end
f (generic function with 3 methods)

julia> using Debugger
```

## Quiz

### Question 1: Why use a debugger?

- Professor wants you to
- improve your mental model and understanding of the language
- save time
- impress potential romantic partners

> improve your mental model and understanding of the language

and

> save time

### Question 2: If we run these lines from the REPL then we will enter the debugger

```julia
julia> break_on(:error)

julia> @run f(50)
```

- True
- False

> False
>> Julia> `@enter` f(50)

### Question 3: What is the value of the variable `a` here?

```julia
1|debug> fr
[1] f(x, a, b) at REPL[1]:1
  | x::Int64 = 10
  | a::Int64 = 2
  | b::Int64 = 0
```

> 2

### Question 4: Suppose you're in the debug prompt and you've forgotten all the debugger commands. What can you press to access the builtin help?

```julia
1|debug>
```

> ?

### Question 5: What is the next expression from our original function g that will be evaluated in the debugger?

```julia
julia> g = function(a, x, b)
       axpb = a*x + b
       sin(axpb)
       end
#3 (generic function with 1 method)

julia> @enter g(5, 4, 1)
In #3(a, x, b) at REPL[10]:1
>1  1 ─ %1 = (*)(a, x)
 2  │        axpb = (+)(%1, b)
 3  │   %3 = (sin)(axpb)
 4  └──      return %3

About to run: (*)(5, 4)
1|debug> n
In #3(a, x, b) at REPL[10]:1
 1  1 ─ %1 = (*)(a, x)
 2  │        axpb = (+)(%1, b)
>3  │   %3 = (sin)(axpb)
 4  └──      return %3

About to run: (sin)(21)
```

- (*)(5, 4)
- sin(axpb)
- a*x + b
- return %3

> sin(axpb)
