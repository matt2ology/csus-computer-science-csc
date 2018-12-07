######################################                                                                                #
# functionName()                     #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #

.data                                               #Start the data section
bust:                                               #bust is an address
    .ascii "You lost all of your gold coins.\0"     #Create a buffer of ASCII
gameOver:                                           #gameOver is an address
    .ascii "GAME OVER!\n\0"                         #Create a buffer of ASCII     
goodChoice:                                         #gameOver is an address
    .ascii "Smart! Quit before you lose it all\n\0" #Create a buffer of ASCII            
.text                                               #Start the text section
.global theEND                                      #Make theEND label public
.global smartOut                                    #Make smartOut label public
theEND:                                             #UNIX starts here
    mov  $bust, %rax                                #Put the address into rax
    call PrintCString                               #Execute the csc35.o subrutine
    call colorRed                                   
    mov  $gameOver, %rax                            #Put the address into rax
    call PrintCString                               #Execute the csc35.o subrutine
    call colorWhite
    call EndProgram                                 #Execute the csc35.o subrutine

smartOut:
    call colorGreen                                   
    mov  $gameOver, %rax                            #Put the address into rax
    call PrintCString                               #Execute the csc35.o subrutine
    mov  $goodChoice, %rax                          #Put the address into rax
    call PrintCString                               #Execute the csc35.o subrutine
    call colorWhite
    call EndProgram                                 #Execute the csc35.o subrutine

