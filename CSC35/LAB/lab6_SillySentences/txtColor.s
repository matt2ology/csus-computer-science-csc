#######################################################################################################################
# This file holds all my text color changing functions                                                                #
#######################################################################################################################
.global colorBlack              #Make colorBlack   label public                                                       #
.global colorRed                #Make colorRed     label public                                                       #
.global colorGreen              #Make colorGreen   label public                                                       #
.global colorYellow             #Make colorYellow  label public                                                       #
.global colorBlue               #Make colorBlue    label public                                                       #
.global colorMagenta            #Make colorMagenta label public                                                       #
.global colorCyan               #Make colorCyan    label public                                                       #
.global colorWhite              #Make colorWhite   label public                                                       #
#################################                                                                                     #
# colorBlack()                  #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetForeColor      #                                                                                     #
#################################                                                                                     #
colorBlack:                     #Subroutine function label colorBlack                                                 #
    mov  $0, %rax               #Stores value 0 into rax                                                              #
    call SetForeColor           #Sets the text to the color specified in %rax                                         #
    ret                         #pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# colorRed()                    #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetForeColor      #                                                                                     #
#################################                                                                                     #
colorRed:                       #Subroutine function label colorRed                                                   #
    mov  $1, %rax               #Stores value 1 into rax                                                              #
    call SetForeColor           #Sets the text to the color specified in %rax                                         #
    ret                         #pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# colorGreen()                  #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetForeColor      #                                                                                     #
#################################                                                                                     #
colorGreen:                     #Subroutine function label colorGreen                                                 #
    mov  $2, %rax               #Stores value 2 into rax                                                              #
    call SetForeColor           #Sets the text to the color specified in %rax                                         #
    ret                         #pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# colorYellow()                 #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetForeColor      #                                                                                     #
#################################                                                                                     #
colorYellow:                    #Subroutine function label colorYellow                                                #
    mov  $3, %rax               #Stores value 3 into rax                                                              #
    call SetForeColor           #Sets the text to the color specified in %rax                                         #
    ret                         #pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# colorBlue()                   #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetForeColor      #                                                                                     #
#################################                                                                                     #
colorBlue:                      #Subroutine function label colorBlue                                                  #
    mov  $4, %rax               #Stores value 4 into rax                                                              #
    call SetForeColor           #Sets the text to the color specified in %rax                                         #
    ret                         #pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# colorMagenta()                #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetForeColor      #                                                                                     #
#################################                                                                                     #
colorMagenta:                   #Subroutine function label colorMagenta                                               #
    mov  $5, %rax               #Stores value 5 into rax                                                              #
    call SetForeColor           #Sets the text to the color specified in %rax                                         #
    ret                         #pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# colorCyan()                   #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetForeColor      #                                                                                     #
#################################                                                                                     #
colorCyan:                      #Subroutine function label colorCyan                                                  #
    mov  $6, %rax               #Stores value 6 into rax                                                              #
    call SetForeColor           #Sets the text to the color specified in %rax                                         #
    ret                         #pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# colorWhite()                  #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetForeColor      #                                                                                     #
#################################                                                                                     #
colorWhite:                     #Subroutine function label colorWhite                                                 #
    mov  $7, %rax               #Stores value 7 into rax                                                              #
    call SetForeColor           #Sets the text to the color specified in %rax                                         #
    ret                         #pops the return address off the stack and returns control to that location           #
#######################################################################################################################
# "A common fallacy is to assume authors of incomprehensible code will somehow be able to express                     #
#  themselves lucidly and clearly in comments" - Kevlin Henney                                                        #
#######################################################################################################################
