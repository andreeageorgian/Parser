JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AddOperator.java \
	ASTNode.java \
	DivideOperator.java \
	DoubleOperand.java \
	EvaluatorTreeVisitor.java \
	IntOperand.java \
	Main.java \
	MultiplyOperator.java \
	NodeFactory.java \
	StringOperand.java \
	TreeUtils.java \
	TreeVisitor.java

default: classes

build: classes

run:
	java Main

classes: $(CLASSES:.java=.class)

clean:
	rm *.class
