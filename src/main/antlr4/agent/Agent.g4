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

communicationContext:
	'communication' ':' (sensor | actuator)+
	;

plannerContext
	:
	'planner'  ':' plansFormulas
	;


logicalContextName
	: primitiveContextName
	| customContextName
	;

primitiveContextName
	: 'beliefs' | 'desires' | 'intentions'
	;

customContextName
	:
	CUSTOMNAME
	;

CUSTOMNAME :
	'_'  ALPHA CHARACTER*
;
plan
	: 'plan' LeftParen somethingToBeTrue ',' compoundAction (',' planPreconditions ',' internalOperator? planPostconditions)? (',' cost)? RightParen '.'
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
	: 'action' LeftParen functionInvocation (',' actionPreconditions ',' internalOperator? actionPostconditions)? (',' cost)? RightParen
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
	: CONSTANT
	;





sensor
    : 'sensor' LeftParen  sensorIdentifier  ',' sensorImplementation RightParen '.'
    ;


sensorIdentifier
    : STRING
    ;

sensorImplementation
    : STRING
    ;

actuator
    : 'actuator' LeftParen actuatorIdentifier ',' actuatorImplementation RightParen '.'
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
	: CONSTANT | VARIABLE
	;

compoundAction
	: ('[' action (',' action)* ']') |'_' ;





plansFormulas
	: ((plan  | action )) *
	;


contextName:
	logicalContextName | 'planner' | 'communication'
	;


head
	:
	'!' negation?  contextName (term | negation? VARIABLE)
	;

body
	: negation? contextName   ((term | negation? VARIABLE) | plan)
((AND | OR) negation?  contextName   ((term | negation? VARIABLE) | plan))*
	;




term
	:  negation? CONSTANT ( annotation | (LeftParen atom (',' atom )* RightParen) annotation?)? 
	| term (AND | OR) term
	| ('[' term (',' term)* ']')
	| term ':-' term
	;

formulas
	: (term '.' )*
	;




atom
    : (NUMERAL | CONSTANT | VARIABLE | '_') (operator (NUMERAL | CONSTANT | VARIABLE | '_') )?
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
    : '['CONSTANT']'
    ;

gradedValue
    : '->0.' NUMERAL
    ;
cost
    : '0.' NUMERAL
    ;
NUMERAL
	: DIGIT+
	;

CONSTANT
	: LCLETTER CHARACTER*
	;

VARIABLE
	: UCLETTER CHARACTER*
	;



/*
* TODO: user been able to add a semantic for a context.
*semanticRules
*	: (LCLETTER | UCLETTER) CHARACTER* '.semantic'
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
fragment ALPHA:
	LCLETTER | UCLETTER
	;
fragment CHARACTER
    : LCLETTER | UCLETTER | DIGIT
    ;
fragment LCLETTER
    : [a-z_];
fragment UCLETTER
    : [A-Z];
fragment DIGIT
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
    