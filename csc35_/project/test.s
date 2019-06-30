# Test Values
# mov  $50,%r8
# mov  $100,%r10
# mov  $1,%r11
# mov  $0,%r13

.data                                            #Start the data section
Message:                                         #Message is an address
    .ascii "Hello, world!\n\0"                   #Create a buffer of ASCII
            
.text                                            #Start the text section
.global _start                                   #Make _start label public
            
_start:                                          #UNIX starts here
    call initMoney
    call gameOpening
LOOP:
    call checkWallet
    call mainStatus
    call mainBet
    call mainGamble
    call mainPayout
    jmp  LOOP
######################################                                                                                #
# initMoney()                        #                                                                                #
#====================================#                                                                                #
# Dependencies: NONE                 #                                                                                #
#------------------------------------#                                                                                #
# initialize 100 to be the starting  #                                                                                #
# money amount for the player        #                                                                                # 
######################################                                                                                #                                                                                #
initMoney:                           #Subroutine function label initMoney                                             #
    mov  $100, %r10                  #Moves the value of 100 to %r10 "the players wallet"                             #
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# checkWallet()                      #                                                                                #
#====================================#                                                                                #
# Dependencies: NONE                 #                                                                                #
#------------------------------------#                                                                                #
# WHEN CALLED MUST USE               #                                                                                #
# jg <label> (jump when greater than)#                                                                                #
######################################                                                                                #
checkWallet:                         #Subroutine function label checkWallet                                           #
    cmp  $0, %r10                    #Compares 0 to %r10 "the money reg"  :: %r10 > 0                                 #
    jle  theEND
    ret                              #Pops the return address off the stack and returns control to that location      #

