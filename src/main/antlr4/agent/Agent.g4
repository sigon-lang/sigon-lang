grammar Agent;

agent
	:
	  (context | bridgeRule)*
	  EOF
	;

context
	: contextName ':' formulas
	| communicationContext
	| PLANS  ':' plansFormulas
	;

communicationContext
    : 'communication' ':' (sensors)? (actuators)?
    ;

contextName
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


conditions
	: ('_' | listOfClauses)
	;
 
 
//'plan' '(' somethingToBeTrue ',' compoundaction ',' preconditions ',' postconditions ')'
plan
	: 'plan' '(' somethingToBeTrue ',' ('_' |compoundaction )',' planPreconditions ',' planPostconditions ')'
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

sensors
    : (sensor)*
    ;

sensor
    : 'sensor(' + sensorIdentifier+  ',' sensorImplementation ')' '.'
    ;

sensorIdentifier
    : STRING
    ;

sensorImplementation
    : STRING
    ;

actuators
    : (actuator)*
    ;

actuator
    : 'actuator(' + actuatorIdentifier+  ',' actuatorImplementation ')' '.'
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

compoundaction
	: ('[' action (',' action)* ']')?;
	
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

bridgeRule
	:
	head ':-' body '.'
	;

head
	:
('!' ('not')? (contextName | PLANS)  ) ('not')? (propClause | folClause | variable)
;

body
	:
(contextName | PLANS)   (('not'? (propClause | folClause | variable))
| plan) (('and'|'or')  (contextName | PLANS)   (('not'? (propClause | folClause | variable)) |plan))*
	;




propClause
	: ('not')? constant* (annotation)?
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
    : '->0' '.'numeral
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

/* Permiter que o usuÃ¡rio descreva a semÃ¢ntica da lÃ³gica.
*/

semanticRules
	: (LCLETTER | UCLETTER) character* '.semantic'
	;

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
PLANS
	: 'planning'
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
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
;

