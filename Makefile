all:
	make clean compile run

clean:
	rm -f *.class

compile:
	javac Main.java

run:
	java Main