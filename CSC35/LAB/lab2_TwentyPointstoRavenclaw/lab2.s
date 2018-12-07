#lab2.s
# Matthew Mendoza
##imul dest, src
##mov src, dest
# 1. Assmble : as -o lab2.o lab2.s
# 2. Link    : ld -o a.out lab2.o csc35.o
# 3. Execute : ./a.out
.data                                       #Start the data section
Header1:                                    #Header1 is an address
    .ascii "Clean rooms    :  10 points\n\0"#Create a buffer of ASCII
Header2:                                    #Header2 is an address
    .ascii "Good habits    :  20 points\n\0"#Create a buffer of ASCII
Header3:                                    #Header3 is an address
    .ascii "Lost your map  : -20 points\n\0"#Create a buffer of ASCII
Header4:                                    #Header4 is an address
    .ascii "Improper notes : -10 points\n\0"#Create a buffer of ASCII
QuestionLine:                               #QuestionLine is an address
    .ascii "\nHow many students:\n\0"       #Create a buffer of ASCII
Question1:                                  #Question1 is an address
                                            #Create a buffer of ASCII
    .ascii "Kept their rooms clean?\n\0"
Question2:                                  #Question2 is an address
                                            #Create a buffer of ASCII
    .ascii "Studied 3 hours outside of class for every hour in class?\n\0"  
Question3:                                  #Question3 is an address
                                            #Create a buffer of ASCII
    .ascii "Got lost on campus?\n\0"             
Question4:                                  #Question4 is an address
                                            #Create a buffer of ASCII
    .ascii "Did not use Hogwarts Styled notes?\n\0"             
Drumroll:                                   #Drumroll is an address
    .ascii "Your house got \0"              #Create a buffer of ASCII
Result:                                     #Drumroll is an address
    .ascii " POINTS!\n\0"                   #Create a buffer of ASCII
            
.text                           #Start the text section
.global _start                  #Make the _start label public
        
_start:                         #UNIX starts here
    mov  $10 , %r8              #Stores value  10 to reg r8 
    mov  $20 , %r9              #Stores value  20 to reg r9 
    mov  $-20, %r10             #Stores value -20 to reg r10 
    mov  $-10, %r11             #Stores value -10 to reg r11

    mov  $Header1, %rax         #Copies Header1 address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    mov  $Header2, %rax         #Copies Header2 address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    mov  $Header3, %rax         #Copies Header3 address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    mov  $Header4, %rax         #Copies Header4 address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    
    mov  $QuestionLine, %rax    #Copies QuestionLine address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    
    mov  $Question1, %rax       #Copies Question1 address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    call ScanInt                #Scans a signed integer and stores it in %rax
    imul %r8, %rax              #Multiplies %r8, by %rax then the result is stored in the second argument
    add  %rax, %rcx             #Adds %rax to %rcx then the result is stored in the second argument

    mov  $Question2, %rax       #Copies Question2 address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    call ScanInt                #Scans a signed integer and stores it in %rax
    imul %r9, %rax              #Multiplies %r9, by %rax then the result is stored in the second argument
    add  %rax, %rcx             #Adds %rax to %rcx then the result is stored in the second argument

    mov  $Question3, %rax       #Copies Question3 address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    call ScanInt                #Scans a signed integer and stores it in %rax
    imul %r10, %rax             #Multiplies %r10 by %rax then the result is stored in the second argument
    add  %rax, %rcx             #Adds %rax to %rcx then the result is stored in the second argument

    mov  $Question4, %rax       #Copies Question4 address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    call ScanInt                #Scans a signed integer and stores it in %rax
    imul %r11, %rax             #Multiplies %r11 by %rax then the result is stored in the second argument
    add  %rax, %rcx             #Adds %rax to %rcx then the result is stored in the second argument

    mov  $Drumroll, %rax        #Copies Drumroll address into %rax
    call PrintCString           #Execute the csc35.o subrutine

    mov  %rcx, %rax             #Copies %rcx address into %rax
    call PrintInt               #Execute the csc35.o subrutine

    mov  $Result, %rax          #Copies Result address into %rax
    call PrintCString           #Execute the csc35.o subrutine
    
    call EndProgram             #Execute the csc35.o subrutine
