# lab6.s
# Matthew Mendoza
.data
PUNCTUATIONPrintComma:
	.ascii ",\0"
PUNCTUATIONPrintPeriod:
	.ascii ".\0"
DOUBLEMARKS:
	.ascii "\"\0"
BLANK:
	.ascii " \0"
ENDL:
	.ascii "\n\0"
A:
	.ascii "We’ve gathered here today to celebrate the Class of\0"
ARTICLEa:
	.ascii "a\0"
B1:
	.ascii "group of\0"
B2:
	.ascii "students hailing from\0"
C1:
	.ascii "states and\0"
C2:
	.ascii "countries to create a\0"
D:
	.ascii "community like nowhere else. Since\0"
E1:
	.ascii "founded in the school\0"
E2:
	.ascii "it’s produced students like\0"
CONJUNCTIONand:
	.ascii "and\0"
F:
	.ascii "people who understand what our motto means when it tells us to\0"
ARTICLEthe:
	.ascii "the\0"
G1:
	.ascii "We know you will do the same, because even if you go on to be\0"
CONJUNCTIONor:
	.ascii "or\0"
G2:
	.ascii "you all share one thing in common:\0"
LAST:
	.ascii "from this fine institution\0"
####################################
WELCOME:                                         
    .ascii "Lets create a silly commencement speech!\0"
OUTPUT:                                         
    .ascii "Look at what you've created: \0"
PromptYEAR:
	.ascii "Player One, please enter a year: \0"
PromptADJ:
	.ascii "Player Two, please enter an adjective: \0"
PromptVERB:
	.ascii "Player One, please enter a verb: \0"
PromptNOUN:
	.ascii "Player Two, please enter a noun: \0"
PromptOCCUPATION:
	.ascii "Player One, please enter an occupation: \0"
PromptHistoricalFigure:
	.ascii "Player Two, please enter a historical figure: \0"
PromptRandomName:
 	.ascii "Player One, please enter a random name: \0"
PromptBelovedCelebrity:
	.ascii "Player Two, please enter a beloved celebrity: \0"
PromptNUMBER:
	.ascii "Player One, please enter a number: \0"
PromptNUMBERbelow51:
	.ascii "Player Two, please enter a number below 51: \0"
PromptNUMBERbelow196:
	.ascii "Player One and Player Two please agree on and enter a number below 196: \0"
#####################################
YEAR:
	.space 30
YEARtwo:
	.space 30
ADJone:
	.space 30
ADJtwo:
	.space 30
ADJthree:
	.space 30
VERB:
	.space 30
NOUN:
	.space 30
NOUNtwo:
	.space 30
OCCUPATIONone:
	.space 30
OCCUPATIONtwo:
	.space 30
HistoricalFigure:
	.space 30
RandomName:
	.space 30
BelovedCelebrity:
	.space 30
NUMBER:
	.space 30
NUMBERbelow51:
	.space 30
NUMBERbelow196:
	.space 30

.text                                            
.global _start                                   
_start:
    call DisplayHeader_Welcome

    call SET_AllInputs

    call DisplayHeader_Output

    call ShowResult

    call EndProgram
# my sub-routines
PrintQUOTE: 
    mov     $DOUBLEMARKS, %rax
	call    PrintCString
	ret
PrintCOMMA: 
    mov     $PUNCTUATIONPrintComma, %rax
	call    PrintCString
	ret
PrintPERIOD: 
    mov     $PUNCTUATIONPrintPeriod, %rax
	call    PrintCString
	ret
PrintA: 
    mov     $ARTICLEa, %rax
	call    PrintCString
	ret
PrintTHE: 
    mov     $ARTICLEthe, %rax
	call    PrintCString
	ret
PrintAND: 
    mov     $CONJUNCTIONand, %rax
	call    PrintCString
	ret
PrintOR: 
    mov     $CONJUNCTIONor, %rax
	call    PrintCString
	ret
SPACEBAR:
    mov     $BLANK, %rax
	call    PrintCString
	ret
NEWLINE: 
    mov     $ENDL, %rax
	call    PrintCString
	ret
LineSegmentA:
    mov     $A, %rax
	call    PrintCString
	ret
LineSegmentB1:
    mov     $B1, %rax
	call    PrintCString
	ret
LineSegmentB2:
    mov     $B2, %rax
	call    PrintCString
	ret
LineSegmentC1:
    mov     $C1, %rax
	call    PrintCString
	ret
LineSegmentC2:
    mov     $C2, %rax
	call    PrintCString
	ret
LineSegmentD: 
    mov     $D, %rax
	call    PrintCString
	ret
LineSegmentE1: 
    mov     $E1, %rax
	call    PrintCString
	ret
LineSegmentE2: 
    mov     $E2, %rax
	call    PrintCString
	ret
LineSegmentF: 
    mov     $F, %rax
	call    PrintCString
	ret
LineSegmentG1: 
    mov     $G1, %rax
	call    PrintCString
	ret
LineSegmentG2: 
    mov     $G2, %rax
	call    PrintCString
	ret
LineSegmentLAST: 
    mov     $LAST, %rax
	call    PrintCString
	ret
###################
DisplayHeader_Welcome:
    call NEWLINE
    call colorWhite
	mov  $WELCOME, %rax
	call PrintCString
    ret
DisplayHeader_Output:
    call NEWLINE
    call colorWhite
	mov  $OUTPUT, %rax
	call PrintCString
    call NEWLINE
    call NEWLINE
    ret
DisplayPrompt_YEAR:
	mov     $PromptYEAR, %rax
    call    PrintCString
    ret
DisplayPrompt_ADJ:
	mov     $PromptADJ, %rax
    call    PrintCString
    ret
DisplayPrompt_VERB:
	mov     $PromptVERB, %rax
    call    PrintCString
    ret
DisplayPrompt_NOUN:
	mov     $PromptNOUN, %rax
    call    PrintCString
    ret
DisplayPrompt_OCCUPATION:
	mov     $PromptOCCUPATION, %rax
    call    PrintCString
    ret
DisplayPrompt_HistoricalFigure:
	mov     $PromptHistoricalFigure, %rax
    call    PrintCString
    ret
DisplayPrompt_RandomName:
 	mov     $PromptRandomName, %rax
    call    PrintCString
    ret
DisplayPrompt_BelovedCelebrity:
	mov     $PromptBelovedCelebrity, %rax
    call    PrintCString
    ret
DisplayPrompt_NUMBER:
	mov     $PromptNUMBER, %rax
    call    PrintCString
    ret
DisplayPrompt_NUMBERbelow51:
	mov     $PromptNUMBERbelow51, %rax
    call    PrintCString
    ret
DisplayPrompt_NUMBERbelow196:
	mov     $PromptNUMBERbelow196, %rax
    call    PrintCString
    ret
##################################
SCAN_YEAR:
    call    colorYellow
    mov     $YEAR, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_YEARtwo:
    call    colorYellow
    mov     $YEARtwo, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_ADJone:
    call    colorYellow
    mov     $ADJone, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_ADJtwo:
    call    colorYellow
    mov     $ADJtwo, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_ADJthree:
    call    colorYellow
    mov     $ADJthree, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_VERB:
    call    colorYellow
    mov     $VERB, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_NOUN:
    call    colorYellow
    mov     $NOUN, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_NOUNtwo:
    call    colorYellow
    mov     $NOUNtwo, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_OCCUPATIONone:
    call    colorYellow
    mov     $OCCUPATIONone, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_OCCUPATIONtwo:
    call    colorYellow
    mov     $OCCUPATIONtwo, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_HistoricalFigure:
    call    colorYellow
    mov     $HistoricalFigure, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_RandomName:
    call    colorYellow
    mov     $RandomName, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_BelovedCelebrity:
    call    colorYellow
    mov     $BelovedCelebrity, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_NUMBER:
    call    colorYellow
    mov     $NUMBER, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_NUMBERbelow51:
    call    colorYellow
    mov     $NUMBERbelow51, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
SCAN_NUMBERbelow196:
    call    colorYellow
    mov     $NUMBERbelow196, %rax #Address to write to
    mov     $30, %rbx #Max bytes to read, so no buffer 
    call    ScanCString
    call    ClearScreen
    call    colorWhite
    ret
#######################################################
SET_AllInputs:                        
    call SET_YEAR
    call SET_ADJone
    call SET_NUMBER
    call SET_NUMBERbelow51
    call SET_NUMBERbelow196
    call SET_ADJtwo
    call SET_HistoricalFigure
    call SET_YEARtwo
    call SET_RandomName
    call SET_BelovedCelebrity
    call SET_VERB
    call SET_NOUN
    call SET_OCCUPATIONone
    call SET_OCCUPATIONtwo
    call SET_NOUNtwo
    ret
SET_YEAR:
    call NEWLINE
    call DisplayPrompt_YEAR
    call SCAN_YEAR
    ret
SET_YEARtwo:
    call NEWLINE
    call DisplayPrompt_YEAR
    call SCAN_YEARtwo
    ret
SET_ADJone:
    call NEWLINE
    call DisplayPrompt_ADJ
    call SCAN_ADJone
    ret
SET_ADJtwo:
    call NEWLINE
    call DisplayPrompt_ADJ
    call SCAN_ADJtwo
    ret
SET_ADJthree:
    call NEWLINE
    call DisplayPrompt_ADJ
    call SCAN_ADJthree
    ret
SET_VERB:
    call NEWLINE
    call DisplayPrompt_VERB
    call SCAN_VERB
    ret
SET_NOUN:
    call NEWLINE
    call DisplayPrompt_NOUN
    call SCAN_NOUN
    ret
SET_NOUNtwo:
    call NEWLINE
    call DisplayPrompt_NOUN
    call SCAN_NOUNtwo
    ret
SET_OCCUPATIONone:
    call NEWLINE
    call DisplayPrompt_OCCUPATION
    call SCAN_OCCUPATIONone
    ret
SET_OCCUPATIONtwo:
    call NEWLINE
    call DisplayPrompt_OCCUPATION
    call SCAN_OCCUPATIONtwo
    ret
SET_HistoricalFigure:
    call NEWLINE
    call DisplayPrompt_HistoricalFigure
    call SCAN_HistoricalFigure
    ret
SET_RandomName:
    call NEWLINE
    call DisplayPrompt_RandomName
    call SCAN_RandomName
    ret
SET_BelovedCelebrity:
    call NEWLINE
    call DisplayPrompt_BelovedCelebrity
    call SCAN_BelovedCelebrity
    ret
SET_NUMBER:
    call NEWLINE
    call DisplayPrompt_NUMBER
    call SCAN_NUMBER
    ret
SET_NUMBERbelow51:
    call NEWLINE
    call DisplayPrompt_NUMBERbelow51
    call SCAN_NUMBERbelow51
    ret
SET_NUMBERbelow196:
    call NEWLINE
    call DisplayPrompt_NUMBERbelow196
    call SCAN_NUMBERbelow196
    ret
#########################
GET_YEAR:
    call colorYellow
    mov  $YEAR, %rax
    call PrintCString
    call colorWhite
    ret
GET_YEARtwo:
    call colorYellow
    mov  $YEARtwo, %rax
    call PrintCString
    call colorWhite
    ret
GET_ADJone:
    call colorYellow
    mov  $ADJone, %rax
    call PrintCString
    call colorWhite
    ret
GET_ADJtwo:
    call colorYellow
    mov  $ADJtwo, %rax
    call PrintCString
    call colorWhite
    ret
GET_ADJthree:
    call colorYellow
    mov  $ADJthree, %rax
    call PrintCString
    call colorWhite
    ret
GET_VERB:
    call colorYellow
    mov  $VERB, %rax
    call PrintCString
    call colorWhite
    ret
GET_NOUN:
    call colorYellow
    mov  $NOUN, %rax
    call PrintCString
    call colorWhite
    ret
GET_NOUNtwo:
    call colorYellow
    mov  $NOUNtwo, %rax
    call PrintCString
    call colorWhite
    ret
GET_OCCUPATIONone:
    call colorYellow
    mov  $OCCUPATIONone, %rax
    call PrintCString
    call colorWhite
    ret
GET_OCCUPATIONtwo:
    call colorYellow
    mov  $OCCUPATIONtwo, %rax
    call PrintCString
    call colorWhite
    ret
GET_HistoricalFigure:
    call colorYellow
    mov  $HistoricalFigure, %rax
    call PrintCString
    call colorWhite
    ret
GET_RandomName:
    call colorYellow
    mov  $RandomName, %rax
    call PrintCString
    call colorWhite
    ret
GET_BelovedCelebrity:
    call colorYellow
    mov  $BelovedCelebrity, %rax
    call PrintCString
    call colorWhite
    ret
GET_NUMBER:
    call colorYellow
    mov  $NUMBER, %rax
    call PrintCString
    call colorWhite
    ret
GET_NUMBERbelow51:
    call colorYellow
    mov  $NUMBERbelow51, %rax
    call PrintCString
    call colorWhite
    ret
GET_NUMBERbelow196:
    call colorYellow
    mov  $NUMBERbelow196, %rax
    call PrintCString
    call colorWhite
    ret
ShowResult:
    call LineSegmentA
    call SPACEBAR
    call GET_YEAR
    call PrintCOMMA
    call SPACEBAR
    call PrintA
    call SPACEBAR
    call GET_ADJone
    call SPACEBAR
    call LineSegmentB1
    call SPACEBAR
    call LineSegmentB2
    call NEWLINE

    call GET_NUMBERbelow51
    call SPACEBAR
    call LineSegmentC1
    call SPACEBAR
    call GET_NUMBERbelow196
    call LineSegmentC2
    call SPACEBAR
    call GET_ADJtwo
    call LineSegmentD
    call GET_HistoricalFigure
    call NEWLINE

    call LineSegmentE1
    call SPACEBAR
    call GET_YEARtwo
    call PrintCOMMA
    call SPACEBAR
    call LineSegmentE2
    call NEWLINE

    call GET_RandomName
    call SPACEBAR
    call PrintAND
    call SPACEBAR
    call GET_BelovedCelebrity
    call PrintCOMMA
    call NEWLINE

    call LineSegmentF
    call SPACEBAR
    call PrintQUOTE
    call GET_VERB
    call SPACEBAR
    call PrintTHE
    call SPACEBAR
    call GET_NOUNtwo
    call SPACEBAR
    call GET_ADJthree
    call PrintPERIOD
    call PrintQUOTE
    call NEWLINE

    call LineSegmentG1
    call SPACEBAR
    call PrintA
    call SPACEBAR
    call GET_OCCUPATIONone
    call SPACEBAR
    call PrintOR
    call SPACEBAR
    call PrintCOMMA
    call NEWLINE

    call LineSegmentG2
    call SPACEBAR
    call PrintA
    call SPACEBAR
    call GET_NOUNtwo
    call SPACEBAR
    call LineSegmentLAST
    call PrintPERIOD
    call NEWLINE 
    call NEWLINE 
    ret

