.data                                #Start the data section
statusHeader:                        #statusHeader is an address                                                      #
    .ascii "have $\0"            #Create a buffer of ASCII                                                        #
.text                                #Start the text section
.global mainStatus              #Make mainStatus label public
.global getStatus                    #Make getStatus       label public
.global getCash                      #Make getCash         label public
######################################                                                                                #
# functionName()                     #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #
mainStatus:
    call endl
    call narration
    call getStatus
    call getCash  
    call newLine
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# functionName()                     #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #
getStatus:
    mov  $statusHeader, %rax         #Moves the address into %rax                                                     #
    call PrintCString                #Prints a null-terminated string stored in the address %rax                      #
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# functionName()                     #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #
getCash:
    mov  %r10, %rax                  #Moves value stored in %10 "the players wallet" into %rax for PrintInt to read   #                     
    call PrintInt                    #Prints a signed integer stored in %rax                                          #
    ret                              #Pops the return address off the stack and returns control to that location      #
