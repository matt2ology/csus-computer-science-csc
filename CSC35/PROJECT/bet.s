######################################                                                                                #
# functionName()                     #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #
.data                                #Start the data section                                                          #
betHeader:                           #betHeader is an address                                                         #
    .ascii "Enter your bet: \0"      #Create a buffer of ASCII   
invalidHeader:                           #betHeader is an address                                                         #
    .ascii "Invalid input enter positive bet number or enter '0' to quit\n\0"      #Create a buffer of ASCII                                                        #
.text                                #Start the text section                                                          #
.global mainBet                      #Make mainBet      label public                                                   #
.global requestBet                   #Make requestBet  label public                                                   #
.global inputBet                     #Make inputBet    label public                                                   #
.global validateBet                  #Make validateBet label public                                                   #
######################################                                                                                #
# mainBet()                          #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #
mainBet:                             #                                                                                #
    call requestBet                  #                                                                                #
    call inputBet                    #                           #                                                                                #
    call validateBet                 #                                                                                #
    call endl                        #                                                                                #
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# requestBet()                       #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #      
requestBet:                          #                                                                                #
    mov  $betHeader, %rax            #Moves the address into %rax                                                     #
    call PrintCString                #Prints a null-terminated string stored in the address %rax                      #
    ret                              #Pops the return address off the stack and returns control to that location      #
requestValidInput:
    call colorRed                                                                       
    mov  $invalidHeader, %rax            #Moves the address into %rax                                                     #
    call PrintCString                #Prints a null-terminated string stored in the address %rax                      #                             # 
    call colorWhite
    jmp  mainBet
    ret  
######################################                                                                                #
# validateBet()                      #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #    
validateBet:                         #
    cmp  $0, %r8                    #                                                                                #
    jl   requestValidInput           #
    je   smartOut
    ret                              #Pops the return address off the stack and returns control to that location      #
######################################                                                                                #
# inputBet()                         #                                                                                #
#====================================#                                                                                #
# Dependencies:                      #                                                                                #
#   TestOne                          #                                                                                #
#   TestTwo                          #                                                                                #
#------------------------------------#                                                                                #
# AboutTheFunction                   #                                                                                #
######################################                                                                                #  
inputBet:                            #                                                                                #
    call ScanInt                     #Scans a signed integer and stores it in %rax                                    #
    mov  %rax, %r8                    #Moves user's input and stores it in %r8 (the bet register)                      #
    ret
