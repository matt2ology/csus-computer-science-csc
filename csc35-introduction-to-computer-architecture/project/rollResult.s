# project#.s
# Matthew Mendoza
#
# Assmble : as -o project#.o project#.s
# Link    : ld -o a.out project#.o csc35.o
# Execute : ./a.out

.data                                            #Start the data section
diceHeaderA:                   #Message is an address                                                                 #
    .ascii "rolled a \0"             #Create a buffer of ASCII                                                        #
diceHeaderB:                         #Message is an address                                                           #
    .ascii " and a \0"                #Create a buffer of ASCII                                                       #            
.text                                            #Start the text section
.global mainRollResult                                                             
.global dieSize
.global displayPlayerRollResult
.global displayHouseRollResult

.global getPlayerDieA
.global getPlayerDieB

.global getHouseDieA
.global getHouseDieB
.global playerTotal
.global houseTotal

mainRollResult:                                        
    call displayPlayerRollResult
    call displayHouseRollResult
    call playerTotal
    call houseTotal
    ret
playerTotal:
    add %r12, %r11
    ret
houseTotal:
    add %r14, %r13
    ret
######################################                                                                                #
# dieSize()                          #                                                                                #
#====================================#                                                                                #
# Dependencies: NONE                 #                                                                                #
######################################                                                                                #
dieSize:                             #Subroutine function label dieSize                                               #
    mov  $6, %rax                    #Puts the value of 6 to %rax (for a six sided die)                               #
    ret                              #Pops the return address off the stack and returns control to that location      #
displayPlayerRollResult:
    call endl
    call narration
    mov  $diceHeaderA,%rax
    call PrintCString
    call getPlayerDieA
    mov  $diceHeaderB,%rax
    call PrintCString
    call getPlayerDieB
    call endl
    ret

displayHouseRollResult:
    call endl
    call house
    mov  $diceHeaderA,%rax
    call PrintCString
    call getHouseDieA
    mov  $diceHeaderB,%rax
    call PrintCString
    call getHouseDieB
    call newLine
    ret

getPlayerDieA:
    call colorGreen
    mov  %r11, %rax
    call PrintInt
    call colorWhite
    ret
getPlayerDieB:
    call colorGreen
    mov  %r12, %rax
    call PrintInt
    call colorWhite
    ret

getHouseDieA:
    call colorRed
    mov  %r13, %rax
    call PrintInt
    call colorWhite
    ret
getHouseDieB:
    call colorRed
    mov  %r14, %rax
    call PrintInt
    call colorWhite
    ret
