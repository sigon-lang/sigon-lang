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
	plannerContext	
	;	

plannerContext
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
 
//'plan' '(' somethingToBeTrue ',' compoundaction ',' preconditions ',' postconditions ',' cost ')'
plan
	: PLAN '(' somethingToBeTrue ',' compoundAction (',' planPreconditions ',' internalOperator? planPostconditions)? (',' cost)? ')'
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
	: ACTION '(' functionInvocation (',' actionPreconditions ',' internalOperator? actionPostconditions)? (',' cost)? ')'
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
    : SENSOR '('  sensorIdentifier  ',' sensorImplementation ')' '.'
    ;


sensorIdentifier
    : STRING
    ;

sensorImplementation
    : STRING
    ;

actuator
    : ACTUATOR '(' actuatorIdentifier ',' actuatorImplementation ')' '.'
    ;


actuatorIdentifier
    : STRING
    ;

actuatorImplementation
    : STRING
    ;

internalOperator
	: beliefAdition | beliefRemotion | desireAdition | desireAdition
	;

beliefAdition
	: '+'
	;
beliefRemotion
	: '-'
	;

desireAdition
	: '+!'
	;
desireRemotion
	: '-!'
	;
argumentList
	:	expression (',' expression)*
;

expression
	: constant | variable
	;

compoundAction
	: ('[' action (',' action)* ']') |'_' ;
	
clause
	: propClause | folClause
	;

listOfClauses
	: clause
	| ('[' clause (',' clause)* ']') 
	;

formulas
	: (propFormula	| folFormula )*
	;
	
propFormula
	: (propClause  (':-' propLogExpr )?)'.'
	;
	
folFormula
	: (folClause ( ':-' folLogExpr )?) '.'
	;
		
plansFormulas
	: ((plan  | action )'.') *
	;	


contextName: 
	logicalContextName | PLANNER | COMMUNICATION
	;


head
	:
('!' negation?  contextName )  (clause | negation? variable)
;

body
	: negation? contextName   ((clause | negation? variable) | plan)
((AND | OR) negation?  contextName   ((clause | negation? variable) | plan))*
	;


propClause
	: negation? constant (annotation)?
	;

folClause
	: negation? constant '(' (term) (',' (term) )* ')' (annotation)?
	;

term
    : (numeral | constant | variable | '_') (operator (numeral | constant | variable | '_') )?
    ;

operator
    : '<' | '=<' | '>' | '>=' | '-' | '+'
    ;

negation
	: 'not' | '~';

annotation
     : (preAction| gradedValue)
     ;

preAction
    : '['constant']'
    ;

gradedValue
    : '->0.' numeral
    ;
cost
    : '0.' numeral
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
	:  propClause propLogExprL
	;
	
propLogExprL
	: (AND | OR) propClause propLogExprL |
	;


folLogExpr
	:  folClause folLogExprL
	;
folLogExprL
	: (AND | OR) folClause folLogExprL |
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
   : '&'
   ;

OR
   : '|'
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
SENSOR
	: 'sensor'
	;
ACTUATOR
	: 'actuator'
	;
PLAN
	: 'plan'
	;
ACTION
	: 'action'
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
