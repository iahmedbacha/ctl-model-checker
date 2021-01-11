grammar CTL;

formula: PROPOSITION # Proposition
       | CONSTANT # Constant
       | '!' '(' formula ')' # Negation
       | formula '&' formula # And
       | 'E' 'X' '(' formula ')' # EX
       | 'E' formula 'U' '(' formula ')' # EU
       | 'A' formula 'U' '(' formula ')' # AU
       ;

PROPOSITION: [a-z0-9]+ ; // match lowercase letters and digits
CONSTANT: [T|F] ; // match boolean true or false
WS : [ \t\r\n]+ -> skip ; // toss out spaces, tabs and newlines
