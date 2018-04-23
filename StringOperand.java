/**
 * @author Andreea
 * Clasa reponsabila pentru operanzii de tip string.
 */
public class StringOperand extends ASTNode {
	/**
	 * Valoarea variabilei nodului curent
	 */
	private String value;
	
	/**
	 * Constructorul default
	 */
	StringOperand() {
		super();
	}
	
	/**
	 * @param variableName Numele variabilei
	 * @param value Valoarea variabilei
	 */
	StringOperand(String variableName, String value) {
		this.name = variableName;
		this.value = value;
	}
	
	/**
	 * @return Valoarea variabilei
	 */
	String getValue() {
		return value;
	}
	
	public void accept(TreeVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "String(" + getName() + "," + getValue() + ")";
	}
}
