/**
 * CLASS: Expression (Expression.java)
 * 
 * DESCRIPTION
 * Expression represents an infix expression to be evaluated.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class Expression {
	
	private Queue<Token> mTokenQueue;
	
	public Expression(String pExprStr) {
		/**
		 * Constructor for Expression.
		 */
		
		setTokenQueue(new Queue<Token>());
		Tokenizer tokenizer = new Tokenizer(pExprStr);
		Token prevToken = null;
		Token token = tokenizer.nextToken();
		
		while (token != null) {
			if (token instanceof SubOperator) token = negationCheck(token, prevToken);
			getTokenQueue().enqueue(token);
			prevToken = token;
			token = tokenizer.nextToken();
		}
	}
	
	public Double evaluate() {
		/**
		 * Evaluates the infix expression.
		 */
		
		Stack<Operator> operatorStack = new Stack<Operator>();
		Stack<Operand> operandStack = new Stack<Operand>();
		
		while (!mTokenQueue.isEmpty()) {
			Token token = getTokenQueue().dequeue();
			if (token instanceof Operand) operandStack.push((Operand) token);
			else if (token instanceof LeftParen) operatorStack.push((LeftParen) token);
			else if (token instanceof RightParen) {
				while (!(operatorStack.peek() instanceof LeftParen)) topEval(operatorStack, operandStack);
				operatorStack.pop();
			} else {
				Operator operator = (Operator) token;
				while (keepEvaluating(operatorStack, operator) == true) topEval(operatorStack, operandStack);
				operatorStack.push(operator);
			}
		}
		
		while (!operatorStack.isEmpty()) topEval(operatorStack, operandStack);
		return operandStack.pop().getValue();
	}
	
	protected Queue<Token> getTokenQueue() {
		/**
		 * Accessor for mTokenQueue.
		 */
		
		return mTokenQueue;
	}
	
	private boolean keepEvaluating(Stack<Operator> pOperatorStack, Operator pOperator) {
		/**
		 * Returns if the program should continue evaluating the infix expression.
		 */
		
		if (pOperatorStack.isEmpty()) return false;
		else return pOperatorStack.peek().stackPrecedence() >= pOperator.precedence();
	}
	
	private Token negationCheck(Token pToken, Token pPrevToken) {
		/**
		 * Returns if '-' is a negation or subtraction operator.
		 */
		
		if (pPrevToken == null || pPrevToken instanceof BinaryOperator || pPrevToken instanceof LeftParen) pToken = new NegOperator();
		return pToken;
	}
	
	protected void setTokenQueue(Queue<Token> pTokenQueue) {
		/**
		 * Mutator for mTokenQueue.
		 */
		
		mTokenQueue = pTokenQueue;
	}
	
	private void topEval(Stack<Operator> pOperatorStack, Stack<Operand> pOperandStack) {
		/**
		 * Evaluates the top of the stack.
		 */
		
		Operand right = pOperandStack.pop();
		Operator operator = pOperatorStack.pop();
		
		if (operator instanceof UnaryOperator) pOperandStack.push(((UnaryOperator) operator).evaluate(right));
		else {
			Operand left = pOperandStack.pop();
			if (operator instanceof AddOperator) pOperandStack.push(((BinaryOperator) operator).evaluate(left, right));
			else if (operator instanceof SubOperator) pOperandStack.push(((BinaryOperator) operator).evaluate(left, right));
			else if (operator instanceof MultOperator) pOperandStack.push(((BinaryOperator) operator).evaluate(left, right));
			else pOperandStack.push(((BinaryOperator) operator).evaluate(left, right));
		}
	}
}
