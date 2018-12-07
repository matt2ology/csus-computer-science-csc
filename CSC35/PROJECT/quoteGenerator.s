#######################################################################################################################
# This file holds all characters and dialogue                                                                         #
#---------------------------------------------------------------------------------------------------------------------#
# %r8 = "bet reg" | %r10 = "Money/Wallet" | %r11 = "Player Die" | %r13 = "House Die"                                  #
#######################################################################################################################
.data                                #Start the data section
ELLIPSIS:                            #ELLIPSIS is an address                                                          #
    .ascii ". . .\n\0"               #Create a buffer of ASCII                                                        #
return:                              #NEWLINE is an address                                                           #
    .ascii "\n\0"                    #Create a buffer of ASCII                                                        #
welcomeStatement:                    #welcomeStatement is an address                                                  #
    .ascii "\n WELCOME \n\0"         #Create a buffer of ASCII                                                        #
goodbyeStatement:                    #goodbyeStatement is an address                                                  #
    .ascii "\n GOOD BYE \n\0"        #Create a buffer of ASCII                                                        #
houseSegmental:                      #house is an address                                                             #
    .ascii "House: \0"               #Create a buffer of ASCII                                                        #
narrationSegmental:                  #house is an address                                                             #
    .ascii "YOU \0"                  #Create a buffer of ASCII                                                        #
#######################################################################################################################
#   Text used for win/lose quote generator                                                                            #
#######################################################################################################################
winQuote1:                                                                 #Message is an address                     #
    .ascii "smirked\0"                                                     #Create a buffer of ASCII                  #
winQuote2:                                                                 #Message is an address                     #
    .ascii "feel a rush of energy\0"                                       #Create a buffer of ASCII                  #
winQuote3:                                                                 #Message is an address                     #
    .ascii "looked up to see that dealer is in full rage\0"                #Create a buffer of ASCII                  #
loseQuote1:                                                                #Message is an address                     #
    .ascii "Don't cry now!\0"                                              #Create a buffer of ASCII                  #
loseQuote2:                                                                #Message is an address                     #
    .ascii "Who said that I was going to play nice?\0"                     #Create a buffer of ASCII                  #
loseQuote3:                                                                #Message is an address                     #
    .ascii "Hey don't give up just yet. Things are just getting started\0" #Create a buffer of ASCII                  #
.text                                #Start the text section                                                          #
.global silence                      #Make silence                    label public                                    #
.global endl                         #Make endl                       label public                                    #
.global newLine                      #Make newLine                    label public                                    #
.global house                       #Make house                     label public                                    #
.global narration                    #Make narration                  label public                                    #
.global loseQuote                    #Make loseQuote                  label public                                    #
.global winQuote                     #Make winQuote                   label public                                    #
.global randomQuoteNumberGenerator   #Make randomQuoteNumberGenerator label public                                    #
.global winQuoteOne                  #Make winQuoteOne                label public                                    #
.global winQuoteTwo                  #Make winQuoteTwo                label public                                    #
.global winQuoteThree                #Make winQuoteThree              label public                                    #
.global loseQuoteOne                 #Make loseQuoteOne               label public                                    #
.global loseQuoteTwo                 #Make loseQuoteTwo               label public                                    #
.global loseQuoteThree               #Make loseQuoteThree             label public                                    #
######################################                                                                                #
# narration()                        #                                                                                #
#====================================#                                                                                #
# Dependencies: PrintCString         #                                                                                #
######################################                                                                                #
silence:                             #
    mov  $ELLIPSIS, %rax             #
    call PrintCString                #
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# endl()                             #                                                                                #
#====================================#                                                                                #
# Dependencies: PrintCString         #                                                                                #
#------------------------------------#                                                                                #
# Returns to next line               #                                                                                #
######################################                                                                                #
endl:                                #
    mov  $return, %rax               #
    call PrintCString                #
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# newLine()                          #                                                                                #
#====================================#                                                                                #
# Dependencies: PrintCString         #                                                                                #
#------------------------------------#                                                                                #
# Returns to next line               #                                                                                #
######################################                                                                                #
newLine:                             #
    mov  $return, %rax               #
    call PrintCString                #
    call PrintCString                #
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# house()                           #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   colorMagenta                     #                                                                                #
#   colorWhite                       #                                                                                #
######################################                                                                                #
house:                              #Subroutine function label status                                                #
    call colorMagenta                #Sets text color to magenta                                                      #
    mov  $houseSegmental, %rax      #Put the address into rax                                                        #
    call PrintCString                #Execute the csc35.o subrutine                                                   #
    call colorWhite                  #Sets text color to white                                                        #
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# narration()                        #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   colorMagenta                     #                                                                                #
#   colorWhite                       #                                                                                #
######################################                                                                                #
narration:                           #Subroutine function label status                                                #
    call colorCyan                   #Sets text color to cyan                                                         #
    mov  $narrationSegmental, %rax   #Put the address into rax                                                        #
    call PrintCString                #Execute the csc35.o subrutine                                                   #
    call colorWhite                  #Sets text color to white                                                        #
    ret                              #Pops the return address off the stack and returns control to that location      #
loseQuote:
    call randomQuoteNumberGenerator
    jl   loseQuoteOne
    jg   loseQuoteTwo
    je   loseQuoteThree
    ret                              #Pops the return address off the stack and returns control to that location      #
winQuote:
    call randomQuoteNumberGenerator
    jl   winQuoteOne
    jg   winQuoteTwo
    je   winQuoteThree
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# randomQuoteNumberGenerator()       #                                                                                #
#====================================#                                                                                #
# Dependencies: NONE                 #                                                                                #
######################################                                                                                #
randomQuoteNumberGenerator:          #Subroutine function label randomQuoteNumberGenerator                            #
    mov  $3, %rax                    #Puts the value of 3 to %rax so that the Random subfunction may create a number  #
    call Random                      #Returns a random integer from 0 to (rax - 1) into %rax                          #
    mov  %al, %r9b                   #Adds the random number generated from subfunction Random and moves it to %r9    #
    cmp  $1, %r9b
    ret                              #Pops the return address off the stack and returns control to that location      #
winQuoteOne:
    call narration
    mov  $winQuote1, %rax            #
    call PrintCString                #
    call newLine
    ret                              #Pops the return address off the stack and returns control to that location      #
winQuoteTwo:
    call narration
    mov  $winQuote2, %rax            #
    call PrintCString                #
    call newLine
    ret                              #Pops the return address off the stack and returns control to that location      #
winQuoteThree:
    call narration
    mov  $winQuote3, %rax            #
    call PrintCString                #
    call newLine
    ret                              #Pops the return address off the stack and returns control to that location      #
loseQuoteOne:
    call house
    mov  $loseQuote1, %rax           #
    call PrintCString                #
    call newLine
    ret                              #Pops the return address off the stack and returns control to that location      #
loseQuoteTwo:
    call house
    mov  $loseQuote2, %rax           #
    call PrintCString                #
    call newLine
    ret                              #Pops the return address off the stack and returns control to that location      #
loseQuoteThree:
    call house
    mov  $loseQuote3, %rax           #
    call PrintCString                #
    call newLine
    ret                              #Pops the return address off the stack and returns control to that location      #
