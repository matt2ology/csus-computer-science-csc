#######################################################################################################################
# This file holds all my color changing functions                                                                     #
#######################################################################################################################
.global bgColorBlack            #Make bgColorBlack   label public                                                     #
.global bgColorRed              #Make bgColorRed     label public                                                     #
.global bgColorGreen            #Make bgColorGreen   label public                                                     #
.global bgColorYellow           #Make bgColorYellow  label public                                                     #
.global bgColorBlue             #Make bgColorBlue    label public                                                     #
.global bgColorMagenta          #Make bgColorMagenta label public                                                     #
.global bgColorCyan             #Make bgColorCyan    label public                                                     #
.global bgColorWhite            #Make bgColorWhite   label public                                                     #
#################################                                                                                     #
# bgColorBlack()                #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetBackColor      #                                                                                     #
#################################                                                                                     #
bgColorBlack:                   #Subroutine function label bgColorBlack                                               #
    mov $0, %rax                #Stores value 0 into rax                                                              #                                       
    call SetBackColor           #Sets the text to the color specified in %rax                                         #                                 
    ret                         #Pops the return address off the stack and returns control to that location           # 
#################################                                                                                     #
# bgColorRed()                  #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetBackColor      #                                                                                     #
#################################                                                                                     #
bgColorRed:                     #Subroutine function label bgColorRed                                                 #
    mov $1, %rax                #Stores value 1 into rax                                                              #
    call SetBackColor           #Sets the text to the color specified in %rax                                         # 
    ret                         #Pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# bgColorGreen()                #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetBackColor      #                                                                                     #
#################################                                                                                     #
bgColorGreen:                   #Subroutine function label bgColorGreen                                               #
    mov $2, %rax                #Stores value 2 into rax                                                              #
    call SetBackColor           #Sets the text to the color specified in %rax                                         # 
    ret                         #Pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# bgColorYellow()               #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetBackColor      #                                                                                     #
#################################                                                                                     #
bgColorYellow:                  #Subroutine function label bgColorYellow                                              #
    mov $3, %rax                #Stores value 3 into rax                                                              #
    call SetBackColor           #Sets the text to the color specified in %rax                                         # 
    ret                         #Pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# bgColorBlue()                 #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetBackColor      #                                                                                     #
#################################                                                                                     #
bgColorBlue:                    #Subroutine function label bgColorBlue                                                #
    mov $4, %rax                #Stores value 4 into rax                                                              #
    call SetBackColor           #Sets the text to the color specified in %rax                                         # 
    ret                         #Pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# bgColorMagenta()              #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetBackColor      #                                                                                     #
#################################                                                                                     #
bgColorMagenta:                  #Subroutine function label bgColorMagent                                              #
    mov $5, %rax                #Stores value 5 into rax                                                              #
    call SetBackColor           #Sets the text to the color specified in %rax                                         #
    ret                         #Pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# bgColorCyan()                 #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetBackColor      #                                                                                     #
#################################                                                                                     #
bgColorCyan:                    #Subroutine function label bgColorCyan                                                #
    mov $6, %rax                #Stores value 6 into rax                                                              #
    call SetBackColor           #Sets the text to the color specified in %rax                                         # 
    ret                         #Pops the return address off the stack and returns control to that location           #
#################################                                                                                     #
# bgColorWhite()                #                                                                                     #
#===============================#                                                                                     #
# Dependency: SetBackColor      #                                                                                     #
#################################                                                                                     #
bgColorWhite:                   #Subroutine function label bgColorWhite                                               #
    mov $7, %rax                #Stores value 7 into rax                                                              #
    call SetBackColor           #Sets the text to the color specified in %rax                                         # 
    ret                         #Pops the return address off the stack and returns control to that location           #
#######################################################################################################################
# "A common fallacy is to assume authors of incomprehensible code will somehow be able to express                     #
#  themselves lucidly and clearly in comments" - Kevlin Henney                                                        #
#######################################################################################################################
