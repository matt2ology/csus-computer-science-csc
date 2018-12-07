# project#.s
# Matthew Mendoza
#
# Assmble : as -o project#.o project#.s
# Link    : ld -o a.out project#.o csc35.o
# Execute : ./a.out

.data                                            #Start the data section
            
.text                                            #Start the text section
.global mainRollDice
.global rollPlayerDice
.global rollHouseDice

mainRollDice:
    call rollPlayerDice
    call rollHouseDice
    ret
######################################                                                                                #
# rollPlayerDice()                   #                                                                                #
#====================================#                                                                                #
# Dependencies: Random               #                                                                                #
#------------------------------------#                                                                                #
# This function makes you miss       #                                                                                #
# the use of polymorphism;           #                                                                                #
# anyways, it generates a            #                                                                                #
# random number for the payer's      #                                                                                #
# die                                #                                                                                #
######################################                                                                                #
rollPlayerDice:                      #Subroutine function label playerDie                                             #
    call rollPlayerDieA
    call rollPlayerDieB
    ret
rollPlayerDieA:
    mov  $1, %r11
    call dieSize
    call Random
    add  %rax, %r11
    ret
rollPlayerDieB:
    mov  $1, %r12
    call dieSize
    call Random
    add  %rax, %r12
    ret

######################################                                                                                #
# rollHouseDice()                    #                                                                                #
#====================================#                                                                                #
# Dependencies: Random               #                                                                                #
######################################                                                                                #
rollHouseDice:                       #Subroutine function label playerDie                                             #
    call rollHouseDieA
    call rollHouseDieB
    ret

rollHouseDieA:
    mov  $1, %r13
    call dieSize
    call Random
    add  %rax, %r13
    ret
rollHouseDieB:
    mov  $1, %r14
    call dieSize
    call Random
    add  %rax, %r14
    ret
    
    