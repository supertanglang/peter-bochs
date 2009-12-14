all:
	gcc -g -c a.c
	gcc -g -c b.c
	gcc -g -c dir1/c.c
	gcc a.o b.o c.o -o a.out

clean:
	rm -fr a.out
	rm -fr *.o