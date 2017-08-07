grammar Agent;

 

agent
	:
	  contextDeclare*
	  bridgeRules*
	  EOF
	;

 
contextDeclare
	: (primitiveContext | customContext) '(' type ')' ':' formulas
	;

primitiveContext
	: (BELIEFS | DESIRES | INTENTIONS | PLANS)
	;

customContext
	:
	'_' + (LCLETTER | UCLETTER) + character*
	;


type
	: 'prop'
	| 'fol'
	;


 

plan
	: 'plan' '(' somethingToBeTrue ',' compoundaction ',' preconditions ',' postconditions ')'
	;

action
	: 'action' '(' (propClause | folClause) ',' preconditions ',' postconditions ')'
	;

somethingToBeTrue
	: (propClause | folClause)
	;

compoundaction
	: ('[' action (',' action)* ']')?;

preconditions
	: (propClause | folClause)
	;

postconditions
	: (propClause | folClause)
	;



formulas
	: ((propClause  | (propClause ':-' propLogExpr ))'.')*
	| ((folClause | (folClause ':-' folLogExpr )) '.')*
	| ((plan  | action )'.') *
	;

bridgeRules
	:
	head ':-' body '.'
	;

head
	:
('!' (primitiveContext | customContext) '(' type ')' ) ('not')? (propClause | folClause)
;

body
	:
(primitiveContext | customContext) '(' type ')' 'not'? (propClause | folClause) (('and'|'or')  (primitiveContext | customContext) '(' type ')' 'not'? (propClause | folClause))*
	;




propClause
	: LCLETTER character*
	;

folClause
	: LCLETTER character* '(' ((LCLETTER | UCLETTER) character*) (','(LCLETTER | UCLETTER) character*)* ')'
	;



propLogExpr
	: propLogExpr ('and' | 'or') propLogExpr
	| propClause
	;


folLogExpr
	: folLogExpr ('and' | 'or') folLogExpr
	| folClause
	;


character
    : LCLETTER | UCLETTER | DIGIT
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
	: 'plans'
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
