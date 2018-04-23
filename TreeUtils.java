import java.util.List;
import java.util.Stack;

/**
 * @author Andreea
 * Clasa continand metode statice utile pentru constructia arborelui sintactic.
 */
public class TreeUtils {
	/**
	 * @param s Un token
	 * @return Adevarat daca tokenul primit ca parametru este un operator valid
	 */
	public static boolean isOperator(String s) {
		return s.equals("-") || s.equals("+") || s.equals("/") || s.equals("*");
	}
	/**
	 * @param s Un token
	 * @return Adevarat daca tokenul primit ca parametru este un operator de prioritate mare (* sau /).
	 */
	public static boolean isHighPriorityOperator(String s) {
		return isOperator(s) && (s.equals("*") || s.equals("/"));
	}
	/**
	 * @param s Un token
	 * @return Adevarat daca tokenul primit ca parametru este un operator de prioritate mica (+ sau -).
	 */
	public static boolean isLowPriorityOperator(String s) {
		return isOperator(s) && (s.equals("+") || s.equals("-"));
	}
	/**
	 * @param s1 Un token
	 * @param s2 Alt token
	 * @return Adevarat daca primul token are o prioritate mai mare sau egala decat al doilea token.
	 */
	public static boolean hasBiggerOrEqualPriority(String s1, String s2) {
		return
				(isHighPriorityOperator(s1) && isLowPriorityOperator(s2)) ||
				(isLowPriorityOperator(s1) && isLowPriorityOperator(s2)) || 
				(isHighPriorityOperator(s1) && isHighPriorityOperator(s2));
	}
	/**
	 * @param expression Lista cu tokenii expresiei de parsat
	 * @param variables Variabilele declarate
	 * @return Radacina arborelui sintactic
	 */
	public static ASTNode createAST(List<String> expression, List<ASTNode> variables) {
		Stack<ASTNode> operandStack = new Stack<>();
		Stack<String> operatorStack = new Stack<>();
		for (String token : expression) {
			if (isOperator(token)) {
				while (!operatorStack.empty() && hasBiggerOrEqualPriority(operatorStack.peek(), token)) {
					String operator = operatorStack.pop();
					ASTNode node = NodeFactory.getInstance().createNode(operator, null, null);
					node.setRightChild(operandStack.pop());
					node.setLeftChild(operandStack.pop());
					operandStack.push(node);
				}
				operatorStack.push(token);
			} else if (token.equals("(")) {
				operatorStack.push(token);
			} else if (token.equals(")")) {
				while (!operatorStack.empty() && !operatorStack.peek().equals("(")) {
					String operator = operatorStack.pop();
					ASTNode node = NodeFactory.getInstance().createNode(operator, null, null);
					node.setRightChild(operandStack.pop());
					node.setLeftChild(operandStack.pop());
					operandStack.push(node);
				}
				operatorStack.pop();
			} else {
				for (ASTNode var : variables) {
					if (var.getName().equals(token)) {
						operandStack.push(var);
						break;
					}
				}
			}
		}
		while (!operatorStack.empty()) {
			String operator = operatorStack.pop();
			ASTNode node = NodeFactory.getInstance().createNode(operator, null, null);
			node.setRightChild(operandStack.pop());
			node.setLeftChild(operandStack.pop());
			operandStack.push(node);
		}
		return operandStack.pop();
	}
	
	/**
	 * @param root Radacina arborelui de afisat
	 * @param indentLevel Nivelul de indentare
	 */
	public static void printAST(ASTNode root, int indentLevel) {
		if (root == null) {
			return;
		}
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			System.out.println(root);
			return;
		}
		System.out.print(root + "\n");
		for (int i = 0; i < indentLevel; i++) {
			System.out.print(" ");
		}
		printAST(root.getLeftChild(), indentLevel + 2);
		for (int i = 0; i < indentLevel; i++) {
			System.out.print(" ");
		}
		printAST(root.getRightChild(), indentLevel + 2);
	}
}
