# lab#.s
# Matthew Mendoza
#
# Assmble : as -o lab5.o lab5.s
# Link    : ld -o a.out lab5.o csc35.o
# OR USE MAKEFILE!
# Execute : ./a.out
                                                  
.data                                                             #Start the data section
                                                  
MessageA:                                                         #MessageA is an address
    .ascii "I am your delicious Hogwarts Alphabet Soup.\n\0"      #Create a buffer of ASCII
MessageB:                                                         #MessageB is an address
    .ascii "Before you can eat me, you must guess my letter!\n\0" #Create a buffer of ASCII
guessSegmental:   	                                              #MessageB is an address
    .ascii "Guess: \0" 				                              #Create a buffer of ASCII
NEWLINE:                                                          #MessageB is an address
    .ascii "\n\0"                                                 #Create a buffer of ASCII
                                                                  
HIGH:                                         	                  #HIGH is an address
    .ascii "You are too high!\n\0"      	                      #Create a buffer of ASCII
LOW:                                         	                  #LOW is an address
    .ascii "You are too low!\n\0" 		                          #Create a buffer of ASCII
CORRECT:                                                          #CORRECT is an address
    .ascii "Correct! You may now eat me!\n\0" 	                  #Create a buffer of ASCII
                                                                  
.text                                                             #Start the text section
.global _start                                                    #Make _start label public
                                                                  
_start:                                                           #UNIX starts here                                                     
    call PrintMessageA     
    call PrintMessageB 
    call randomLetter
LOOP:                                            
    call showGuessPrompt
    call readUserInput
    call testInput                         
############################                      
# colorCyan()              #                      
#==========================#                      
# Dependency: SetForeColor #                      
############################                      
colorCyan:                                         
    mov  $6, %rax      #Stores value 6 into rax
    call SetForeColor #Sets the text to the color specified in %rax. 
    ret               #pops the return address off the stack and returns control to that location.
############################                      
# colorWhite()             #
#==========================#                      
# Dependency: SetForeColor #
############################                      
colorWhite:   
    mov $7, %rax      #Stores value 7 into rax
    call SetForeColor #Sets the text to the color specified in %rax. 
    ret               #pops the return address off the stack and returns control to that location.
endl:
    mov  $NEWLINE, %rax                                           #Put the address into rax
    call PrintCString                                             #Execute the csc35.o subrutine
    ret
PrintMessageA:
    mov  $MessageA, %rax                                          #Put the address into rax
    call PrintCString                                             #Execute the csc35.o subrutine
    ret
PrintMessageB:
    mov  $MessageB, %rax                                          #Put the address into rax
    call PrintCString                                             #Execute the csc35.o subrutine
    ret
showGuessPrompt:
    mov  $guessSegmental, %rax
    call  PrintCString
    ret
randomLetter:
    mov  $26, %rax    #random number from 0 to 26
    call Random       #Returns a random integer from 0 to (rax - 1) into %rax
    mov  %al, %dl                      
    add  $97, %dl
    ret
readUserInput:
    call colorCyan
    call ScanChar
    mov  %al, %cl
    call colorWhite
    ret 

testInput:
    call ifUpperCase
    cmp %cl ,%dl
    jl resultLOW
    jg resultHigh
    je resultCORRECT
    ret
ifUpperCase:
    cmp $97, %cl
    jl  makeLowerCase
    ret
makeLowerCase:
    add $32, %cl
    ret
resultLOW:
    call endl
    mov $HIGH, %rax
    call PrintCString
    jmp LOOP
    ret
resultHigh:
    call endl
    mov $LOW, %rax
    call PrintCString
    jmp LOOP
    ret
resultCORRECT:
    call endl
    mov $CORRECT, %rax
    call PrintCString
    jmp returnZERO
    ret

returnZERO:
    call EndProgram

