grammar CTL;

formula: PROPOSITION # Proposition
       | CONSTANT # Constant
       | '!' '(' formula ')' # Negation
       | formula '&' formula # And
       | 'EX' '(' formula ')' # EX
       | 'E' formula 'U' '(' formula ')' # EU
       | 'A' formula 'U' '(' formula ')' # AU
       ;

PROPOSITION: [a-z0-9]+;
CONSTANT: [T|F];
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
