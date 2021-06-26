JAVA=java
JAVAC=javac
JFLEX=$(JAVA)  -jar  jflex-1.8.2/lib/jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA)  -jar  $(CUPJAR)
CP=.:$(CUPJAR)

default:  run

.SUFFIXES:  $(SUFFIXES)  .class  .java

.java.class:
		$(JAVAC)  -cp  $(CP)  $*.java
    
FILE= parser.java sym.java \
		TypeCheckerTest.java Program.java Memberdecls.java \
		Fielddecls.java Methoddecls.java Fielddecl.java \
		Optionalexpr.java Methodcall.java Methoddecl.java \
		Optionalsemi.java Type.java Argdecls.java \
		ArgdeclList.java Argdecl.java Stmts.java Stmt.java \
		Whilestmt.java Assign.java IO.java Returnstmt.java \
		Postfix.java Struct.java Ifstmt.java IfEnd.java Name.java \
		Args.java Readlist.java Printlist.java Expr.java \
		Binaryop.java Token.java Proj3Scanner.java VarTable.java MethodTable.java\
		methodEntry.java varEntry.java Checkable.java

dump: parserD.java $(FILE:java=class)
          
run: test1 test2 test3 test4 test5 test6 test7 test8 test9 test10 test11 test12 test13 \
		test14 test15 test16 test17 test18 test19 test20

test1: all
		$(JAVA) -cp $(CP) TypeCheckerTest < redefVarAsMethod.as > redefVarAsMethodOutput.txt
		cat -n redefVarAsMethodOutput.txt

test2: all
		$(JAVA) -cp $(CP) TypeCheckerTest < redefVar.as > redefVarOutput.txt
		cat -n redefVarOutput.txt

test3: all
		$(JAVA) -cp $(CP) TypeCheckerTest < redefMethod.as > redefMethodOutput.txt
		cat -n redefMethodOutput.txt

test4: all
		$(JAVA) -cp $(CP) TypeCheckerTest < reassignFinal.as > reassignFinalOutput.txt
		cat -n reassignFinalOutput.txt

test5: all
		$(JAVA) -cp $(CP) TypeCheckerTest < noReturn.as > noReturnOutput.txt
		cat -n noReturnOutput.txt

test6: all
		$(JAVA) -cp $(CP) TypeCheckerTest < intArrayToBoolArray.as > intArrayToBoolArrayOutput.txt
		cat -n intArrayToBoolArrayOutput.txt

test7: all
		$(JAVA) -cp $(CP) TypeCheckerTest < incompatBinary.as > incompatBinaryOutput.txt
		cat -n incompatBinaryOutput.txt

test8: all
		$(JAVA) -cp $(CP) TypeCheckerTest < fullValidProgramFI.as > fullValidProgramFIOutput.txt
		cat -n fullValidProgramFIOutput.txt

test9: all
		$(JAVA) -cp $(CP) TypeCheckerTest < floatToInt.as > floatToIntOutput.txt
		cat -n floatToIntOutput.txt

test10: all
		$(JAVA) -cp $(CP) TypeCheckerTest < charToInt.as > charToIntOutput.txt
		cat -n charToIntOutput.txt

test11: all
		$(JAVA) -cp $(CP) TypeCheckerTest < charToFloat.as > charToFloatOutput.txt
		cat -n charToFloatOutput.txt

test12: all
		$(JAVA) -cp $(CP) TypeCheckerTest < callNonExistFunc.as > callNonExistFuncOutput.txt
		cat -n callNonExistFuncOutput.txt

test13: all
		$(JAVA) -cp $(CP) TypeCheckerTest < boolToInt.as > boolToIntOutput.txt
		cat -n boolToIntOutput.txt

test14: all
		$(JAVA) -cp $(CP) TypeCheckerTest < boolToFloat.as > boolToFloatOutput.txt
		cat -n boolToFloatOutput.txt

test15: all
		$(JAVA) -cp $(CP) TypeCheckerTest < badTernaryTypes.as > badTernaryTypesOutput.txt
		cat -n badTernaryTypesOutput.txt

test16: all
		$(JAVA) -cp $(CP) TypeCheckerTest < badTernaryCond.as > badTernaryCondOutput.txt
		cat -n badTernaryCondOutput.txt

test17: all
		$(JAVA) -cp $(CP) TypeCheckerTest < badString.as > badStringOutput.txt
		cat -n badStringOutput.txt

test18: all
		$(JAVA) -cp $(CP) TypeCheckerTest < badNegation.as > badNegationOutput.txt
		cat -n badNegationOutput.txt

test19: all
		$(JAVA) -cp $(CP) TypeCheckerTest < badInc.as > badIncOutput.txt
		cat -n badIncOutput.txt

test20: all
		$(JAVA) -cp $(CP) TypeCheckerTest < badDec.as > badDecOutput.txt
		cat -n badDecOutput.txt
    
all: Proj3Scanner.java parser.java $(FILE:java=class)

clean: 
		rm -f *.class *~ *.bak Proj3Scanner.java parser.java sym.java
    
Proj3Scanner.java: proj3grammar.jflex
		$(JFLEX) proj3grammar.jflex
    
parser.java: tokens.cup
		$(CUP) -interface -progress < tokens.cup
    
parserD.java: tokens.cup
		$(CUP) -interface -dump < tokens.cup
    