# S - Shell Pipelines

- [S - Shell Pipelines](#s---shell-pipelines)
  - [Resources Used](#resources-used)
    - [Hint for shell pipeline skill homework](#hint-for-shell-pipeline-skill-homework)
  - [Setup](#setup)
  - [Exercise](#exercise)
    - [1. Use `grep` to find all the rows in `presidents.csv` beginning with `D`. Hint: you shouldn’t find `R,Donald`](#1-use-grep-to-find-all-the-rows-in-presidentscsv-beginning-with-d-hint-you-shouldnt-find-rdonald)
      - [1.1 Commands](#11-commands)
      - [1.2 Output](#12-output)
    - [2. Write a simple pipeline with `gzip` followed by `gunzip`. This is called a “round trip”, with data first being compressed, and then uncompressed. Can pipes handle binary data, in addition to text?](#2-write-a-simple-pipeline-with-gzip-followed-by-gunzip-this-is-called-a-round-trip-with-data-first-being-compressed-and-then-uncompressed-can-pipes-handle-binary-data-in-addition-to-text)
      - [2.1 Commands](#21-commands)
      - [2.2 Output](#22-output)
    - [3. Use `sed` to transform `presidents.csv` into the output below. Hint: an easy way to do this is to use `sed` twice in a pipeline](#3-use-sed-to-transform-presidentscsv-into-the-output-below-hint-an-easy-way-to-do-this-is-to-use-sed-twice-in-a-pipeline)
      - [3.1 Commands](#31-commands)
      - [3.2 Output](#32-output)

## Resources Used

- [Gzip Command in Linux](https://linuxize.com/post/gzip-command-in-linux/)
- [How to replace multiple lines using the sed command](https://linuxhint.com/use-sed-replace-multiple-lines/)
- [Piping in Unix or Linux](https://www.geeksforgeeks.org/piping-in-unix-or-linux/)
- [Sed - An Introduction and Tutorial by Bruce Barnett](https://www.grymoire.com/Unix/Sed.html)
- [Sed Command Examples](https://www.oakton.edu/user/2/rjtaylor/cis218/Handouts/sed.txt)
- [Zipping and Unzipping Files in UNIX](https://www.hostingmanual.net/zipping-unzipping-files-unix/)

### Hint for shell pipeline skill homework

    echo "first,last
    Brian,Kernighan
    Grace,Hopper
    Ken,Thompson" > programmers.csv

    grep "K" programmers.csv

    # ^ matches the beginning of a line.
    grep "^K" programmers.csv

## Setup

    echo "D,bill
    R,George
    D,Barack
    R,Donald
    D,Joe" > presidents.csv

## Exercise

**Submit your commands together with the output.**

---

### 1. Use `grep` to find all the rows in `presidents.csv` beginning with `D`. Hint: you shouldn’t find `R,Donald`

#### 1.1 Commands

> $ grep "^D" presidents.csv

#### 1.2 Output

    D,bill
    D,Barack
    D,Joe

### 2. Write a simple pipeline with `gzip` followed by `gunzip`. This is called a “round trip”, with data first being compressed, and then uncompressed. Can pipes handle binary data, in addition to text?

> **gzip `-c` or `--stdout` or `--to-stdout`**
>
> > Write output on standard output; keep original files unchanged.
> > If there are several input files, the output consists of a sequence of independently compressed members.
> > To obtain better compression, concatenate all input files before compressing them.

Yes. Pipes can handle both binary data and text.

#### 2.1 Commands

> cat presidents.csv | gzip -c | gunzip > decrypted.txt

#### 2.2 Output

    $ cat presidents.csv | gzip -c | gunzip > decrypted.txt
    $ cat decrypted.txt

    D,bill
    R,George
    D,Barack
    R,Donald
    D,Joe

### 3. Use `sed` to transform `presidents.csv` into the output below. Hint: an easy way to do this is to use `sed` twice in a pipeline

    Desiered output
        DEM,bill
        REP,George
        DEM,Barack
        REP,Donald
        DEM,Joe

#### 3.1 Commands

> $ sed 's/^D/DEM/; s/R/REP/' presidents.csv

**OR** You can run multiple `sed` commands by piping the output of one `sed` command as input to another `sed` command.

> $ sed 's/^D/DEM/' presidents.csv | sed 's/R/REP/'

#### 3.2 Output

    DEM,bill
    REP,George
    DEM,Barack
    REP,Donald
    DEM,Joe
