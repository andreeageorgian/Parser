/**
 * @author Andreea
 * Factory-ul responsabil de instantierea nodurilor arborelui sintactic.
 */
public class NodeFactory {
	/**
	 * Instanta singleton-ului.
	 */
	private static NodeFactory instance = null;
	
	/**
	 * Constructorul default privat.
	 */
	private NodeFactory() {}
	
	/**
	 * @return Instanta singleton-ului.
	 */
	public static NodeFactory getInstance() {
		if(instance == null) {
			instance = new NodeFactory();
		}
		return instance;
	}
	
	/**
	 * @param variableType Tipul variabilei
	 * @param variableName Numele variabilei 
	 * @param variableValue Valoarea variabilei
	 * @return Un nod al arborelui sintactic continand informatiile variabilei
	 */
	private ASTNode createOperand(String variableType, String variableName, String variableValue) {
		switch(variableType) {
			case "int": {
				return new IntOperand(variableName, Integer.parseInt(variableValue));
			}
			case "double": {
				return new DoubleOperand(variableName, Double.parseDouble(variableValue));
			}
			case "string": {
				return new StringOperand(variableName, variableValue.substring(1, variableValue.length() - 1));
			}
			default: {
				return null;
			}
		}
	}
	
	/**
	 * @param operatorType Tipul operatorului
	 * @return Un nod al arborelui sintactic continand informatiile operatorului
	 */
	private ASTNode createOperator(String operatorType) {
		switch(operatorType) {
			case "*": {
				return new MultiplyOperator();
			}
			case "/": {
				return new DivideOperator();
			}
			case "+": {
				return new AddOperator();
			}
			case "-": {
				return new SubstractOperator();
			}
			default: {
				return null;
			}
		}
	}
	
	/**
	 * @param type Tipul variabilei sau operatorului
	 * @param name Numele variabilei sau null in cazul operatorilor
	 * @param value Valoarea variabilei sau null in cazul operatorilor
	 * @return Un nod al arborelui sintactic
	 */
	public ASTNode createNode(String type, String name, String value) {
		if (name == null && value == null) {
			return createOperator(type);
		}
		else {
			return createOperand(type, name, value);
		}
	}
}
