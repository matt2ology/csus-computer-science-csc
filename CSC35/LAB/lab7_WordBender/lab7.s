# lab7.s
# Matthew Mendoza
#
# Assmble : as -o lab7.o lab7.s
# Link    : ld -o a.out lab7.o csc35.o
# Execute : ./a.out

.data                                            #Start the data section
WELCOME:
    .ascii "WELCOME PLEASE ENTER A WORD TO BE BENT!\n\0"
NEXTLINE:
    .ascii "\n\0"
BLANK:
    .ascii " \0"
WORD:
    .space 20
.text                                            #Start the text section
.global _start                                   #Make _start label public
            
_start:                                          #UNIX starts here
    mov  $WELCOME, %rax
    call PrintCString

    mov  $WORD, %rax #Address to write to
    mov  $20,   %rbx #Max bytes to read (so no buffer overflow)
	call ScanCString

    call LengthCString
    mov  $2, %r9
    cqo
    idiv %r9
    mov  %rax, %r8

    call endl

    mov  $0, %rdi
    movb WORD(%rdi), %al
    call PrintChar
    jmp  TopDown

ReturnZero:
    call endl
    call EndProgram                              #Execute the csc35.o subrutine
endl:
    mov  $NEXTLINE, %rax
    call PrintCString
    ret
space:
    mov  $BLANK, %rax
    call PrintCString
    ret
TopDown:
    call endl
    add  $1, %rdi
    movb WORD(%rdi), %al
    call PrintChar
    cmp  %r8, %rdi
    jl   TopDown
    jmp  LeftRight
    ret
LeftRight:
    call space
    add  $1, %rdi
    movb WORD(%rdi), %al
    call PrintChar
    mov  $WORD, %rax #Address to write to
    call LengthCString
    cmp  %rax, %rdi
    jl   LeftRight
    jmp  ReturnZero
    ret
