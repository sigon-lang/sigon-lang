grammar Agent;

agent
	:
	communicationContext (context | bridgeRule)*
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
	communicationContext | 
	planningContext	
	;	

planningContext
	:
	PLANNER  ':' plansFormulas
	;
communicationContext:
	COMMUNICATION ':' (sensor | actuator)+
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
	: (propFormula	| folFormula )*
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


contextName: 
	logicalContextName | PLANNER | COMMUNICATION
	;


head
	:
('!' ('not')?  contextName ) ('not')? (propClause | folClause | variable)
;

body
	:
contextName   (('not'? (propClause | folClause | variable))
| plan) (('and'|'or')  contextName   (('not'? (propClause | folClause | variable)) | plan))*
	;


propClause
	: ('not')? constant (annotation)?
	;

folClause
	: ('not')? constant '(' (term) (',' (term) )* ')' (annotation)?
	;

term
    : (numeral | constant | variable | '_') (operator (numeral | constant | variable | '_') )?
    ;

operator
    : '<' | '=<' | '>' | '>=' | '-' | '+'
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
	:
    '"' (~["\\\r\n] | '\"')* '"';



BELIEFS
	: 'beliefs'
	;

DESIRES
	: 'desires'
	;

INTENTIONS
	: 'intentions'
	;
PLANNER
	: 'planner'
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
