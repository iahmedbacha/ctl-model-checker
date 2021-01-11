grammar CTL;

formula: TRUE # True
       | FALSE # False
       | PROPOSITION # Proposition
       | '(!' formula ')' # Negation
       | '(' formula '&' formula ')' # And
       | '(' formula '|' formula ')' # Or
       | '(' formula '=>' formula ')' # implication
       | '(' formula '<=>' formula ')' # equivalence
       | 'AX' formula # AX
       | 'EX' formula # EX
       | 'AF' formula # AF
       | 'EF' formula # EF
       | 'AG' formula # AG
       | 'EG' formula # EG
       | 'A[' formula 'U' formula ']' # AU
       | 'E[' formula 'U' formula ']' # EU
       ;

PROPOSITION: [a-z0-9]+ ; // match lowercase letters and digits
TRUE: [+] ; // match boolean true
FALSE: [-] ; // match boolean false
WS : [ \t\r\n]+ -> skip ; // toss out spaces, tabs and newlines
