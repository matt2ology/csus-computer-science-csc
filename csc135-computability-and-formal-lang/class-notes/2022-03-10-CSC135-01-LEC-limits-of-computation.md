---
aliases: [20220310T0859]
publish: false
tags:
- academic/csus/calendar/spring-2022
- academic/csus/csc/135-computing-theory-and-programming-languages/lecture-sec-01
- calendar/2022/03/W10/4-Thursday-10
- notes/fleeting/class
uid: CLS20220310T0859
note_type: class
---

course: [[CSC 135-01 - Computing Theory and Programming Languages]]

instructor: [[Ted Krovetz]]

related_notes: [[2022-03-10]]

# Limits of Computation

W10.4 | Thursday, March 10, 2022 | 08:59 AM

## Notes - Limits of Computation

$\Huge L\:=\:\left\{a^nb^n|n\le \:4\right\}$
$\Huge L\:=\:\left\{a^nb^n|n\le \:40\right\}$
$\Huge L\:=\:\left\{a^nb^n|n\le \:9000\right\}$

DFA proves $L$ is regular

![[IMG20220310095630~2.jpg]]

### $L$ is Not Regular - Proof By Contradiction

**Theorem:** L is not regular

>Proof Sketch
>> For contradiction assume $L$ is regular
>> Let $M$ be a DFA with $P$ states that recognizes $L$
>> Consider the string $a^Pb^P$
>> While consuming $a^P$ $M$ will repeat some state (pigeon hole/musical chair principle)
>> Let $x$ represent the string leading to the first repeated state
>> Let $y$ represent the string leading back to the repeated state
>> Let $z$ represent the rest of the string
>> $xyyz$ will lead to an accept state and so is in $L$
>> But $xyyz$ has more a's than b's and so is not in $L$
>> This contradiction prove $L$ is not regular

$\Large xyz\in L$
$\Large xyyz\in L$

![[IMG20220310101046~2.jpg]]

## Examples RE -> NFA -> DFA: $0(0+1)^{\ast}0$

### RE -> NFA

**$\Huge 0(0+1)^{\ast}0$**

![[IMG20220310090928~2.jpg]]

### NFA -> DFA

| Zero (`0`) |
| ---------- |
| C: CDE      |
| D: CDEF    |
| E: F            |
| F: empty   |

![[IMG20220310092742~2.jpg]]

### NFA -> RE

- Loops do not count for they become stars **$\ast$**
- Number of in arrows times the number of out arrows
- Parallel edges you'd combine them with a plus **$+$**
	```mermaid
	flowchart LR
		leftNode(( )) -- R_1 --> rightNode(( ))
		rightNode -- R_2 --> leftNode
	```
	BECOMES
	```mermaid
	flowchart LR
		leftNode(( )) -- R_1 + R_2 --> rightNode(( ))
	```
	
![[IMG20220310094417~2.jpg]]
