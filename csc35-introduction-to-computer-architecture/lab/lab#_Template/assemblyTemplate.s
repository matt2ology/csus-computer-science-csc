# lab#.s
# Matthew Mendoza
#
# Assmble : as -o lab3.o lab3.s
# Link    : ld -o a.out lab3.o csc35.o
# Execute : ./a.out

.data                                            #Start the data section
Message:                                         #Message is an address
    .ascii "Hello, world!\n\0"                   #Create a buffer of ASCII
            
.text                                            #Start the text section
.global _start                                   #Make _start label public
            
_start:                                          #UNIX starts here
    mov $Message, %rax                           #Put the address into rax
    call PrintCString                            #Execute the csc35.o subrutine
            
    call EndProgram                              #Execute the csc35.o subrutine