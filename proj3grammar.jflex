import java_cup.runtime.*;

%%

%cup
%line
%column
%unicode
%class Proj3Scanner

%{

Symbol newSym(int tokenId) 
{
  return new Symbol(tokenId, yyline, yycolumn);
}

Symbol newSym(int tokenId, Object value)
{
  return new Symbol(tokenId, yyline, yycolumn, value);
}

%}

/*
  regular expressions and patterns are here
*/

//*******************
tab          = \\t
newline      = \\n
slash        = \\
singlequote  = \'
doublequote  = \"
letter       = [A-Za-z]
digit        = [0-9]
id           = {letter}({letter}|{digit})*
intlit       = {digit}+
floatlit     = {digit}+\.{digit}+
bannedchar   = [\'\\]
charlit      = {singlequote}([^{bannedchar}]|{tab}|{newline}
		|{doublequote}|{slash}{singlequote}|{slash}{slash}){singlequote}
bannedinstr  = [\n\t\"\\]
allowedinstr = ({tab}|{newline}|{slash}{slash}|{slash}{doublequote})
strchar      = ([^{bannedinstr}]|{allowedinstr})
strlit       = {doublequote}{strchar}*{doublequote}
comment      = {slash}{slash}.*\n
multistart   = {slash}\*
multiend     = \*{slash}
multiallowed = ([^\*]|\*[^\\])
multicomment = {multistart}({multiallowed}|{whitespace})*{multiend}
whitespace   = [ \n\t\r]
//*******************

%%

//Lexing rules

";"           {return newSym(sym.SEMI, ";");}
"="           {return newSym(sym.EQUALS, "=");}
class         {return newSym(sym.CLASS, "class");}
read          {return newSym(sym.READ, "read");}
print         {return newSym(sym.PRINT, "print");}
printline     {return newSym(sym.PRINTLN, "printline");}
return        {return newSym(sym.RETURN, "return");}
"*"           {return newSym(sym.MULT, "*");}
"/"           {return newSym(sym.DIV, "/");}
"+"           {return newSym(sym.PLUS, "+");}
"+"           {return newSym(sym.POS, "+");}
"-"           {return newSym(sym.MINUS, "-");}
"-"           {return newSym(sym.NEGA, "-");}
"<"           {return newSym(sym.LT, "<");}
">"           {return newSym(sym.GT, ">");}
"<="          {return newSym(sym.LTE, "<=");}
">="          {return newSym(sym.GTE, ">=");}
"=="          {return newSym(sym.LOGEQUALS, "==");}
"<>"          {return newSym(sym.NOTEQUAL, "<>");}
"||"          {return newSym(sym.LOGOR, "||");}
"&&"          {return newSym(sym.LOGAND, "&&");}
"("           {return newSym(sym.OPENPAREN, "(");}
")"           {return newSym(sym.CLOSEPAREN, ")");}
"["           {return newSym(sym.OPENSQUARE, "[");}
"]"           {return newSym(sym.CLOSESQUARE, "]");}
"{"           {return newSym(sym.OPENCURLY, "{");}
"}"           {return newSym(sym.CLOSECURLY, "}");}
"~"           {return newSym(sym.TILDE, "~");}
"++"          {return newSym(sym.INCREMENT, "++");}
"--"          {return newSym(sym.DECREMENT, "--");}
"?"           {return newSym(sym.COND1, "?");}
":"           {return newSym(sym.COND2, ":");}
","           {return newSym(sym.COMMA, ",");}
true          {return newSym(sym.TRUE, "true");}
false         {return newSym(sym.FALSE, "false");}
void          {return newSym(sym.VOID, "void");}
int           {return newSym(sym.INT, "int");}
float         {return newSym(sym.FLOAT, "float");}
char          {return newSym(sym.CHAR, "char");}
bool          {return newSym(sym.BOOL, "bool");}
if            {return newSym(sym.IF, "if");}
while         {return newSym(sym.WHILE, "while");}
else          {return newSym(sym.ELSE, "else");}
final	      {return newSym(sym.FINAL, "final");}
fi	      {return newSym(sym.FI, "fi");}
//intlit      
{intlit}      {return newSym(sym.INTLIT, new Integer(yytext()));}
//floatlit    
{floatlit}    {return newSym(sym.FLOATLIT, new Double(yytext()));}
//charlit     
{charlit}     {return newSym(sym.CHARLIT, yytext());}
//strlit     
{strlit}      {return newSym(sym.STRLIT, yytext());}
//id          
{id}          {return newSym(sym.ID, yytext());}
{multicomment} {/* multiline commment */}
{comment}      {/* single-line comment */}
{whitespace}   {/* whitespace */}
. {System.out.println("Illegal character, " + yytext() +
    " line:" + yyline + " col:" + yychar);}

