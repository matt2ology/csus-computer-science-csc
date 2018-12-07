# project#.s
# Matthew Mendoza
#
# Assmble : as -o project#.o project#.s
# Link    : ld -o a.out project#.o csc35.o
# Execute : ./a.out

.data                                            #Start the data section
            
.text                                            #Start the text section
.global mainGamble                                   #Make mainGamble label public
            
mainGamble:                                          #UNIX starts here
    call mainRollDice
    call mainRollResult
    ret

