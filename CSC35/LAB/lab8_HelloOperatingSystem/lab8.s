# lab#.s
# Matthew Mendoza
#
# Assmble : as -o lab8.o lab8.s
# Link    : ld -o a.out lab8.o csc35.o
# Execute : ./a.out

.data                                            #Start the data section
requestName:                                     #requestName is an address
    .ascii "Please enter your name.\n\0"         #Create a buffer of ASCII
greeting:
    .ascii "Hello, \0"
message:
    .ascii "After this semester we will learn how to implement version control!\0"
SHRIEK:
    .ascii "!\0"
NEWLINE:
    .ascii "\n\0"
NAME:
    .space 35           
.text                                            #Start the text section
.global _start                                   #Make _start label public
_start:                                          #UNIX starts here
    # Prompts user to input their name
    mov $1, %rax            # Linux command for WRITE
    mov $1, %rdi            # 1 = SCREEN
    mov $requestName, %rsi
    mov $25, %rdx           # How many bytes
    syscall                 # Call Linux

    # Prints a new line
    call endl
    
    # Reads user input for name
    mov $0, %rax            # Linux command for READ
    mov $0, %rdi            # 0 = Keyboard
    mov $NAME, %rsi
    mov $35, %rdx           # Maximum number of bytes to read
    syscall                 # Call Linux

    # Prints a new line
    call endl

    # Writes "Hello, " to screen
    mov $1, %rax            # Linux command for WRITE
    mov $1, %rdi            # 1 = SCREEN
    mov $greeting, %rsi
    mov $7, %rdx            # How many bytes
    syscall                 # Call Linux

    # Writes user's input for name to screen
    mov $1, %rax            # Linux command for WRITE
    mov $1, %rdi            # 1 = SCREEN
    mov $NAME, %rsi
    mov $35, %rdx           # How many bytes
    syscall                 # Call Linux
    # call BANG             # EXCLAMATION POINT <= HOW COME IT DOESNT COME AFTER?!?!?!

    # Prints a new line
    call endl

    # Prints message to screen
    mov $1, %rax        # Linux command for WRITE
    mov $1, %rdi        # 1 = SCREEN
    mov $message, %rsi
    mov $67, %rdx   # How many bytes
    syscall             # Call Linux

    # Prints a new line
    call endl
    # Prints a new line
    call endl

    # ENDS PROGRAM, RETURN ZERO
    call endProgram

##################################
#   PROGRAMMER DEFINED FUNCTIONS #
##################################
BANG:
    mov $1, %rax            # Linux command for WRITE
    mov $1, %rdi            # 1 = SCREEN
    mov $SHRIEK, %rsi
    mov $2, %rdx
    syscall                 # Call Linux
    ret

endl:
    mov $1, %rax            # Linux command for WRITE
    mov $1, %rdi            # 1 = SCREEN
    mov $NEWLINE, %rsi
    mov $2, %rdx
    syscall                 # Call Linux
    ret

endProgram:
    mov $60, %rax           # Linux command for Exit
    mov $0, %rdi            # 0 = all okay
    syscall                 # Call Linux
    ret
    
    # sysWrite:
    #   mov $1, %rax        # Linux command for WRITE
    #   mov $1, %rdi        # 1 = SCREEN
    #   mov $address, %rsi
    #   mov $length, %rdx   # How many bytes
    #   syscall             # Call Linux

    # sysRead:
    #   mov $0, %rax        # Linux command for READ
    #   mov $0, %rdi        # 0 = Keyboard
    #   mov $address, %rsi
    #   mov $maxBytes, %rdx # Maximum number of bytes to read
    #   syscall             # Call Linux

