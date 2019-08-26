######################################                                                                                #
# functionName()                     #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #

.data                                            #Start the data section
MessageA:                                         #Message is an address
    .ascii "Welcome to the project I had to re-do five\n\0"                   #Create a buffer of ASCII
MessageB:                                         #Message is an address
    .ascii "because I did not implament version control\n\0"                   #Create a buffer of ASCII
MessageC:                                         #Message is an address
    .ascii "I changed something and my code didn't run anymore\n\0"                   #Create a buffer of ASCII
MessageD:                                         #Message is an address
    .ascii "So I stayed up building my code again from scratch\n\0"                   #Create a buffer of ASCII
            
.text                                            #Start the text section
.global gameOpening                                   #Make gameOpening label public
            
gameOpening:                                          #UNIX starts here
    call newLine
    call newLine
    call colorRed
    mov  $MessageA, %rax                           #Put the address into rax
    call PrintCString                            #Execute the csc35.o subrutine
    mov  $MessageB, %rax                           #Put the address into rax
    call PrintCString                            #Execute the csc35.o subrutine
    mov  $MessageC, %rax                           #Put the address into rax
    call PrintCString                            #Execute the csc35.o subrutine
    mov  $MessageD, %rax                           #Put the address into rax
    call PrintCString                            #Execute the csc35.o subrutine
    call colorWhite

