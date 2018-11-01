a: lab5.o compute.o
	gcc lab5.o compute.o -o a.out -lm

lab5.o:
	gcc -c lab5.c -o lab5.o

compute.o: lab5.h compute.c
	gcc -c compute.c -o compute.o

clean:
	rm -r *.o
