# lab4.s
# Matthew Mendoza
#
# Assmble : as -o lab4.o lab4.s
# Link    : ld -o a.out lab4.o csc35.o
# Execute : ./a.out

.data                                                                                  #Start the data section
Message:                                                                               #Message is an address
    .ascii "Do you arrive on time for Prof. Oak's Lab (Yes:1 NO:0)\n\0"                #Create a buffer of ASCII
A:                                                                                     #Message is an address
    .ascii "Do you like ELECTRIC type pokemon or WATER types?(ELECTRIC:1 WATER:0)\n\0" #Create a buffer of ASCII
B:                                                                                     #Message is an address
    .ascii "Do you like FIRE type pokemon or GRASS types?(FIRE:1 GRASS:0)\n\0"         #Create a buffer of ASCII
Aa:                                                                                    #Message is an address
    .ascii "You get a Pikachu\n\0"                                                     #Create a buffer of ASCII
Ab:                                                                                    #Message is an address
    .ascii "You get a Squirtle\n\0"                                                    #Create a buffer of ASCII
Ba:                                                                                    #Message is an address
    .ascii "You get a Charmander\n\0"                                                  #Create a buffer of ASCII
Bb:                                                                                    #Message is an address
    .ascii "You get a Bulbasaur\n\0"                                                   #Create a buffer of ASCII
            
.text                           #Start the text section
.global _start                  #Make _start label public
            
_start:                         #UNIX starts here
    mov  $Message, %rax         #Put the address into rax
    call PrintCString           #Execute the csc35.o subrutine

    call ScanInt                #Scans a signed integer and stores it in %RAX
    cmp  $0, %rax
    je   LATE                   #Moves user input from %RAX to %R10
    #TrueBlock

    mov  $A, %rax               #Put the address into rax
    call PrintCString           #Execute the csc35.o subrutine

    call ScanInt                #Scans a signed integer and stores it in %RAX
    cmp  $0, %rax
    je   SelectAb               #Moves user input from %RAX to %R10
    #TrueBlock
    mov  $Aa, %rax              #Put the address into rax
    call PrintCString           #Execute the csc35.o subrutine
    jmp ReturnZero

SelectAb:
    mov  $Ab, %rax              #Put the address into rax
    call PrintCString           #Execute the csc35.o subrutine
    jmp ReturnZero

LATE:
    mov  $B, %rax               #Put the address into rax
    call PrintCString           #Execute the csc35.o subrutine

    call ScanInt                #Scans a signed integer and stores it in %RAX
    cmp  $0, %rax
    je   SelectBb               #Moves user input from %RAX to %R10
    #TrueBlock
    mov  $Ba, %rax              #Put the address into rax
    call PrintCString           #Execute the csc35.o subrutine
    jmp ReturnZero

SelectBb:
    mov  $Bb, %rax              #Put the address into rax
    call PrintCString           #Execute the csc35.o subrutine
    jmp ReturnZero

ReturnZero:          
    call EndProgram             #Execute the csc35.o subrutine


