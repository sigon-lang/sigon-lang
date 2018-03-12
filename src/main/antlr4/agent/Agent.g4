grammar Agent;

agent
	:
	  context (context | bridgeRule)*
	  EOF
	;

context
	: 
	logicalContext | functionalContext
	;

bridgeRule
	:
	head ':-' body '.'
	;

logicalContext
	:
	logicalContextName ':' formulas
	;

functionalContext
	:
	COMMUNICATION ':' (sensor | actuator)+
	| PLANNING  ':' plansFormulas
	;	

logicalContextName
	: primitiveContextName 
	| customContextName
;

primitiveContextName
	: (BELIEFS | DESIRES | INTENTIONS)
	;

customContextName
	:
	'_'(LCLETTER | UCLETTER)+ character*
	;
 
//'plan' '(' somethingToBeTrue ',' compoundaction ',' preconditions ',' postconditions ')'
plan
	: 'plan' '(' somethingToBeTrue ',' compoundAction ',' planPreconditions ',' planPostconditions ')'
	;

somethingToBeTrue
	: listOfClauses
	;	

planPreconditions
	: conditions
	;
	
planPostconditions
	: conditions
	;
	
conditions
	: ('_' | listOfClauses)
	;

//'action' '(' functionInvocation ',' preconditions ',' postconditions ')'
action
	: 'action' '(' functionInvocation ',' actionPreconditions ',' actionPostconditions ')'
	;
	
actionPreconditions
	: conditions
	;
	
actionPostconditions
	: conditions
	;

functionInvocation
	: functionName '(' argumentList? ')'
	;

functionName
	: LCLETTER + character*
	;

sensor
    : 'sensor('  sensorIdentifier  ',' sensorImplementation ')' '.'
    ;

sensorIdentifier
    : STRING
    ;

sensorImplementation
    : STRING
    ;

actuator
    : 'actuator(' actuatorIdentifier ',' actuatorImplementation ')' '.'
    ;

actuatorIdentifier
    : STRING
    ;

actuatorImplementation
    : STRING
    ;


argumentList
	:	expression (',' expression)*
;

expression
	: STRING
	;

compoundAction
	: ('[' action (',' action)* ']') |'_' ;
	
listOfClauses
	: (propClause | ('[' propClause (',' propClause)* ']'))
	| (folClause | ('[' folClause (',' folClause)* ']'))
	;

formulas
	: propFormula*
	| folFormula*
	;
	
propFormula
	: ((propClause  | (propClause ':-' propLogExpr ))'.')
	;
	
folFormula
	: ((folClause | (folClause ':-' folLogExpr )) '.')
	;
		
plansFormulas
	: ((plan  | action )'.') *
	;	



head
	:
('!' ('not')? (logicalContextName | PLANNING | COMMUNICATION)  ) ('not')? (propClause | folClause | variable)
;

body
	:
(logicalContextName | PLANNING | COMMUNICATION)   (('not'? (propClause | folClause | variable))
| plan) (('and'|'or')  (logicalContextName | PLANNING | COMMUNICATION)   (('not'? (propClause | folClause | variable)) |plan))*
	;


propClause
	: ('not')? constant (annotation)?
	;

folClause
	: ('not')? constant '(' (numeral | constant | variable | '_') (',' (numeral | constant | variable | '_') )* ')' (annotation)?
	;

annotation
     : (preAction| gradedValue)
     ;

preAction
    : '['constant']'
    ;

gradedValue
    : '->0.' numeral
    ;

numeral
	: DIGIT+
	;

constant
	: LCLETTER character*
	;

variable
	: UCLETTER character*
	;

propLogExpr
	: propLogExpr (AND | OR) propLogExpr
	| propClause
	;


folLogExpr
	: folLogExpr (AND | OR) folLogExpr
	| folClause
	;


character
    : LCLETTER | UCLETTER | DIGIT
    ;

/* 
* TODO: user been able to add a semantic for a context.
*semanticRules
*	: (LCLETTER | UCLETTER) character* '.semantic'
*	;
*/

AND
   : 'and'
   ;

OR
   : 'or'
   ;

STRING
	 : '"' (~[\r\n"] | '""')* '"'
 	 ;

BELIEFS
	: 'beliefs'
	;

DESIRES
	: 'desires'
	;

INTENTIONS
	: 'intentions'
	;
PLANNING
	: 'planning'
	;

COMMUNICATION
	: 'communication'
	;



LCLETTER
    : [a-z_];

UCLETTER
    : [A-Z];

DIGIT
    : [0-9];

WS
   : [ \t\r\n] -> skip
;


BlockComment
    :   '/*' .* '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
;
