# Test Values
# mov  $50,%r8
# mov  $100,%r10
# mov  $1,%r11
# mov  $0,%r13

.data                                            #Start the data section        
.text                                            #Start the text section
.global mainPayout 
.global checkPlay   
.global playerWon  
.global houseWon  
            
mainPayout:                                          #UNIX starts here
    call checkPlay
    ret                              #Pops the return address off the stack and returns control to that location      #
checkPlay:
    cmp  %r13, %r11
    jg   playerWon
    call houseWon
    ret                              #Pops the return address off the stack and returns control to that location      #
playerWon:
    add  %r8,%r10
    call winQuote
    ret                              #Pops the return address off the stack and returns control to that location      #
houseWon:
    sub  %r8,%r10
    call loseQuote
    ret                              #Pops the return address off the stack and returns control to that location      #            
