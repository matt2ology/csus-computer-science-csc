#lab1.s
# Matthew Mendoza
#
# 1. Assmble : as -o lab1.o lab1.s
# 2. Link    : ld -o a.out  lab1.o csc35.o
# 3. Execute : a.out

.data                                                 #Start the data section
Message:                                              #Message is an address
    .ascii "Hello, world!\n\0"                        #Create a buffer of ASCII             
Name:                                                 #Name is an address
    .ascii "My name is Matt\n\0"                      #Create a buffer of ASCII
Quote:                                                #Quote is an address
    .ascii "Quote: \"May all your bacon burn\"\n\0"   #Create a buffer of ASCII
StringA:                                              #StringA is an address
    .ascii "I will graduate in \0"                    #Create a buffer of ASCII
Year:                                                 #Year is an address
    .ascii "2020\0"                                   #Create a buffer of ASCII
StringB:                                              #StringB is an address
    .ascii "from Sacramento State!\0"                 #Create a buffer of ASCII



.text                                                 #Start the text section
.global _start                                        #Make the _start label public

_start:                                               #UNIX starts here
    mov $Message, %rax                                #Put the address into rax
    call PrintCString                                 #Execute the csc35.o subrutine
    mov $Name, %rax                                   #Put the address into rax
    call PrintCString                                 #Execute the csc35.o subrutine
    mov $Quote, %rax                                  #Put the address into rax
    call PrintCString                                 #Execute the csc35.o subrutine
    mov $StringA, %rax                                #Put the address into rax
    call PrintCString                                 #Execute the csc35.o subrutine
    mov $Year, %rax                                   #Put the address into rax
    call PrintInt                                     #Execute the csc35.o subrutine
    mov $StringA, %rax                                #Put the address into rax
    call PrintCString                                 #Execute the csc35.o subrutine
        
    call EndProgram                                   #Execute the csc35.o subrutine