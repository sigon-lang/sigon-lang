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
	head ':-' body DOT
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

communicationContext:
	COMMUNICATION ':' (sensor | actuator)+
	;

plannerContext
	:
	PLANNER  ':' plansFormulas
	;


logicalContextName
	: primitiveContextName
	| customContextName
	;

primitiveContextName
	: BELIEFS | DESIRES | INTENTIONS
	;

customContextName
	:
	'_'(LCLETTER | UCLETTER)+ character*
	;

plan
	: PLAN LeftParen somethingToBeTrue ',' compoundAction (',' planPreconditions ',' internalOperator? planPostconditions)? (',' cost)? RightParen DOT
	;



somethingToBeTrue
	: term
	;

planPreconditions
	: conditions
	;

planPostconditions
	: conditions
	;

conditions
	: ('_' | term)
	;

action
	: ACTION LeftParen functionInvocation (',' actionPreconditions ',' internalOperator? actionPostconditions)? (',' cost)? RightParen
	;

actionPreconditions
	: conditions
	;

actionPostconditions
	: conditions
	;

functionInvocation
	: functionName LeftParen argumentList? RightParen
	;

functionName
	: LCLETTER + character*
	;

sensor
    : 'sensor' LeftParen  sensorIdentifier  ',' sensorImplementation RightParen'.'
    ;


sensorIdentifier
    : STRING
    ;

sensorImplementation
    : STRING
    ;

actuator
    : 'actuator' LeftParen actuatorIdentifier ',' actuatorImplementation RightParen'.'
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





plansFormulas
	: ((plan  | action )) *
	;


contextName:
	logicalContextName | PLANNER | COMMUNICATION
	;


head
	:
	'!' negation?  contextName (term | negation? variable)
	;

body
	: negation? contextName   ((term | negation? variable) | plan)
((AND | OR) negation?  contextName   ((term | negation? variable) | plan))*
	;




term
	:  negation? constant ( annotation | (LeftParen atom (',' atom )* RightParen) annotation?)? 
	| term (AND | OR) term
	| ('[' term (',' term)* ']')
	| term ':-' term
	;

formulas
	: (term DOT )*
	;




atom
    : (numeral | constant | variable | '_') (operator (numeral | constant | variable | '_') )?
    ;

operator
    : '<' | '=<' | '>' | '>=' | '-' | '+'
    ;

negation
	: 'not ' | '~';

annotation
     : (preAction gradedValue ? ) | gradedValue
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

LeftParen : '(';
RightParen : ')';

STRING
	:
    '"' (~["\\\r\n])* '"';

DOT
	: 
	'.';

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
    : '/*' .*? '*/' -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
;

