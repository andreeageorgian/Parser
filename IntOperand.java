/**
 * @author Andreea
 * Clasa reponsabila pentru operanzii de tip int.
 */
public class IntOperand extends ASTNode {
	/**
	 * Valoarea variabilei nodului curent.
	 */
	private Integer value;
	
	/**
	 * Constructorul default.
	 */
	IntOperand() {
		super();
	}
	
	/**
	 * @param variableName Numele variabilei
	 * @param value Valoarea variabilei
	 */
	IntOperand(String variableName, int value) {
		this.name = variableName;
		this.value = value;
	}
	
	/**
	 * @return Valoarea variabilei
	 */
	public int getValue() {
		return value.intValue();
	}
	
	public void accept(TreeVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "Int(" + getName() + "," + getValue() + ")";
	}
}
