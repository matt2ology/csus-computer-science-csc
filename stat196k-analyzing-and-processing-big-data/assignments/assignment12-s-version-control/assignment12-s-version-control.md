# Assignment12: S - Version Control

- [Assignment12: S - Version Control](#assignment12-s---version-control)
  - [Quiz Instructions](#quiz-instructions)
    - [Question 1: Which of the following are benefits / use cases for version control?](#question-1-which-of-the-following-are-benefits--use-cases-for-version-control)
    - [Question 2: Git and Github are the same thing](#question-2-git-and-github-are-the-same-thing)
    - [Question 3: Which of the following data storage types might work OK with version control, assuming it's not too large?](#question-3-which-of-the-following-data-storage-types-might-work-ok-with-version-control-assuming-its-not-too-large)
    - [Question 4](#question-4)
    - [Question 5: Which flag do you add to the `ssh` command to forward your credentials so that you can push and pull code while you're logged in to a remote machine?](#question-5-which-flag-do-you-add-to-the-ssh-command-to-forward-your-credentials-so-that-you-can-push-and-pull-code-while-youre-logged-in-to-a-remote-machine)

## Quiz Instructions

### Question 1: Which of the following are benefits / use cases for version control?

- ☐ can view the revision history of files
- ☐ backs up files and code against loss
- ☐ allows many developers to collaborate together
- ☐ allows us to easily synchronize code on remote machines
- ☐ stores large amounts of data

> ☑ can view the revision history of files
>
> ☑ backs up files and code against loss
>
> ☑ allows many developers to collaborate together
>
> ☑ allows us to easily synchronize code on remote machines

### Question 2: Git and Github are the same thing

### Question 3: Which of the following data storage types might work OK with version control, assuming it's not too large?

- ☐ csv
- ☐ json
- ☐ xml
- ☐ zip file

> ☑ json

### Question 4

     Suppose you edit your code on your laptop,
     and then you want to put this same code on
     your EC2 instance. From your laptop you
     need to [ BLANK A] the code, and from your
     EC2 instance you need to [ BLANK B] the
     code.

| BLANK A | BLANK B |
| :------ | :------ |
| push    | pull    |
| pull    | push    |
| merge   | meage   |
| rebase  | rebase  |

> BLANK A
> > push
>
> BLANK B
> > pull

### Question 5: Which flag do you add to the `ssh` command to forward your credentials so that you can push and pull code while you're logged in to a remote machine?

- ssh -A
- ssh -B
- ssh -C
- ssh -X

> ssh -A
