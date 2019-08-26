# Assmble : as -o project#.o project#.s
# Link    : ld -o a.out project#.o csc35.o

final: test.o status.o payout.o bet.o gamble.o dice.o colors.o quoteGenerator.o
	ld -o a.out test.o status.o payout.o bet.o gamble.o dice.o colors.o quoteGenerator.o csc35.o

test.o: test.s 
	as -o test.o test.s 

bet.o: bet.s ending.s opening.s
	as -o bet.o bet.s ending.s opening.s

gamble.o: gamble.s 
	as -o gamble.o gamble.s 


payout.o: payout.s 
	as -o payout.o payout.s 

status.o: status.s
	as -o status.o status.s

dice.o: rollDice.s rollResult.s
	as -o dice.o rollDice.s rollResult.s

colors.o: txtColor.s bgColor.s
	as -o colors.o txtColor.s bgColor.s

quoteGenerator.o: quoteGenerator.s
	as -o quoteGenerator.o quoteGenerator.s

