grammar Agent;

 

agent
	:
	  (context | bridgeRule)*
	  EOF
	;

 
context
	: contextName '(' param? ')' ':' formulas
	| PLANS '(' ('prop' | 'fol')? ')' ':' plansFormulas
	;



param
	: type 
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


type
	: 'prop'
	| 'fol'
	| customType (',' semanticRules)
	;

customType
	: character +
	;

 
//'plan' '(' somethingToBeTrue ',' compoundaction ',' preconditions ',' postconditions ')'
plan
	: 'plan' '(' listOfClauses ',' compoundaction ',' listOfClauses ',' listOfClauses ')'
	;

action
	: 'action' '(' listOfClauses ',' listOfClauses ',' listOfClauses ')'
	;


compoundaction
	: ('[' action (',' action)* ']')?;

listOfClauses
	: (propClause | '[' propClause (',' propClause)* ']')
	| (folClause | '[' folClause (',' folClause)* ']')
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
('!' contextName '(' type ')' ) ('not')? (propClause | folClause)
;

body
	:
contextName '(' type ')' 'not'? (propClause | folClause) (('and'|'or')  contextName '(' type ')' 'not'? (propClause | folClause))*
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

/* Permiter que o usuário descreva a semântica da lógica.
*/

semanticRules
	: character+ '.semantic'
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


BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
;
