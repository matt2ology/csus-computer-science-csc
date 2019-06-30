# lab6.s
# Matthew Mendoza
#
# Assmble : as -o lab6.o lab6.s
# Link    : ld -o a.out lab6.o csc35.o
# Execute : ./a.out

.data                                            
WELCOME:                                         
    .ascii "Lets create a silly sentence!\0"   
NounPrompt:                                         
    .ascii "Player One, please enter a noun: \0"   
VerbPrompt:                                         
    .ascii "Player Two, please enter a verb: \0"
PrepositionPrompt:                                         
    .ascii "Player One, please enter a preposition: \0"   
SecondNounPrompt:                                         
    .ascii "Player Two, please enter a noun: \0"
OUTPUT:                                         
    .ascii "Look at what you've created: \0"
Noun:
	.space 30 #Input buffer
Verb:
	.space 30 #Input buffer
Preposition:
	.space 30 #Input buffer
SecondNoun:
	.space 30 #Input buffer
endl:
    .ascii "\n\0"
space:
    .ascii " \0"

.text                                            
.global _start                                   

_start:                                          
    call NEWLINE

	mov  $WELCOME, %rax
	call PrintCString

    call NEWLINE

    mov  $NounPrompt, %rax
	call PrintCString
    call readNounInput

    call NEWLINE

    mov  $VerbPrompt, %rax
    call PrintCString
    call readVerbInput

    call NEWLINE

    mov  $PrepositionPrompt, %rax
    call PrintCString
    call readPrepositionInput

    call NEWLINE

    mov  $SecondNounPrompt, %rax
    call PrintCString
    call readSecondNounInput

    call NEWLINE

    call displayRESULT

    call EndProgram      

# my sub-routines
NEWLINE:
    mov  $endl, %rax
	call PrintCString
    call PrintCString
    ret

SPACEBAR:
    mov  $space, %rax
	call PrintCString
    ret

readNounInput:
    mov  $Noun, %rax #Address to write to
    mov  $30,  %rbx #Max bytes to read (so no buffer overflow)
	call ScanCString
    call ClearScreen
    ret
readVerbInput:
    mov  $Verb, %rax #Address to write to
    mov  $30,  %rbx #Max bytes to read (so no buffer overflow)
	call ScanCString
    call ClearScreen
    ret
readPrepositionInput:
    mov  $Preposition, %rax #Address to write to
    mov  $30,  %rbx #Max bytes to read (so no buffer overflow)
	call ScanCString
    call ClearScreen
    ret
readSecondNounInput:
    mov  $SecondNoun, %rax #Address to write to
    mov  $30,  %rbx #Max bytes to read (so no buffer overflow)
	call ScanCString
    call ClearScreen
    ret

displayNounInput:
    mov  $Noun, %rax
	call PrintCString
    ret
displayVerbInput:
    mov  $Verb, %rax
	call PrintCString
    ret
displayPrepositionInput:
    mov  $Preposition, %rax
	call PrintCString
    ret
displaySecondNounInput:
    mov  $SecondNoun, %rax
	call PrintCString
    ret
displayRESULT:
    mov  $OUTPUT, %rax
    call PrintCString
    call NEWLINE
    call displayNounInput
    call SPACEBAR
    call displayVerbInput
    call SPACEBAR
    call displayPrepositionInput
    call SPACEBAR
    call displaySecondNounInput
    call NEWLINE
    ret

