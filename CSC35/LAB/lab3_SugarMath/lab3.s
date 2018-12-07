#lab3.s
# Matthew Mendoza
# 1. Assmble : as -o lab3.o lab3.s
# 2. Link    : ld -o a.out lab3.o csc35.o
# 3. Execute : ./a.out

.data                                                        #Start the data section
NEWLINE:                                                     #Message is an address
    .ascii "\n\0"                                            #Create a buffer of ASCII

Question1:                                                   #Message is an address
    .ascii "How many daily units does the patient take?\n\0" #Create a buffer of ASCII

ICFResult:                                                   #Message is an address
    .ascii "The patient's ICF is: \0"                        #Create a buffer of ASCII

Question2:                                                   #Message is an address
    .ascii "What is the patient's blood sugar level?\n\0"    #Create a buffer of ASCII

DrumRollPlease:                                              #Message is an address
    .ascii "The patient needs \0"                            #Create a buffer of ASCII

UnitResult:                                                  #Message is an address
    .ascii " units\n\0"                                      #Create a buffer of ASCII

.text                                                        #Start the text section
.global _start                                               #Make the _start label public
            
_start:                                                      #UNIX starts here
    #Moving constants to these registers
    mov  $1800 , %r8                                         #Stores value 1800 to %R8
    mov  $150  , %r9                                         #Stores value 150  to %R9
    #cout << endl;
    mov  $NEWLINE, %rax                                      #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    #Display request for TOTAL DAILY DOSE
    mov  $Question1, %rax                                     #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    #Read user input: TOTAL DAILY DOSE
    call ScanInt                                             #Scans a signed integer and stores it in %RAX
    mov  %rax, %r10                                          #Moves user input from %RAX to %R10
    #ICF = (1800 / TOTAL DAILY DOSE)
    cqo                                                      #Sign-extend %RAX into %RDX
    mov  %r8, %rax                                           #Moves constant from %R8 to %RAX
    idiv %r10                                                #Value stored in %RAX is divided by value stored in this reg
    mov  %rax, %r12                                          #Moves quotient value to %R12
    #cout << endl;
    mov  $NEWLINE, %rax                                      #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    #Display ICF result
    mov  $ICFResult, %rax                                    #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    mov  %r12, %rax                                          #Moves constant from %R12 to %RAX
    call PrintInt                                            #Scans a signed integer and stores it in %RAX
    #cout << endl;
    mov  $NEWLINE, %rax                                      #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    #cout << endl;
    mov  $NEWLINE, %rax                                      #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    #Display request for Blood Sugar Level
    mov  $Question2, %rax                                    #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    #Read user input: Blood Sugar Level
    call ScanInt                                             #Scans a signed integer and stores it in %RAX
    mov  %rax, %r11                                          #Moves user input to %R11
    #DOSE = [(Blood Sugar Level – 150) / ICF]
    sub  %r9,  %r11                                          #Argument2 -= Argument1
    mov  %r11, %rax                                          #Moves constant from %R11 to %RAX
    cqo                                                      #Sign-extend %RAX into %RDX
    idiv %r12                                                #Value stored in %RAX is divided by value stored in this reg
    mov  %rax, %r13                                          #Moves quotient value to %R13
    #cout << endl;
    mov  $NEWLINE, %rax                                      #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    #Display result prompt
    mov  $DrumRollPlease, %rax                               #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    mov  %r13, %rax                                          #Moves constant from %R13 to %RAX
    call PrintInt                                            #Scans a signed integer and stores it in %RAX
    mov  $UnitResult, %rax                                   #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine
    #cout << endl;
    mov  $NEWLINE, %rax                                      #Moves the address into %RAX
    call PrintCString                                        #Execute the csc35.o subrutine    
    #Return 0;
    call EndProgram                                          #Execute the csc35.o subrutine
    