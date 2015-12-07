fakemake : fakeMakeTarget
	$(RM) *.class

fakeMakeTarget : FakeMakeExecutable.class
	   java FakeMakeExecutable input.txt

FakeMakeExecutable.class : FakeMakeExecutable.java
		 javac FakeMakeExecutable.java
 
