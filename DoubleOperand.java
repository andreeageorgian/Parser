/**
 * @author Andreea
 * Clasa reponsabila pentru operanzii de tip double.
 */
public class DoubleOperand extends ASTNode {
	/**
	 * Valoarea variabilei din nodul curent.
	 */
	private Double value;
	
	/**
	 * Constructorul default
	 */
	DoubleOperand() {
		super();
	}
	
	/**
	 * @param variableName Numele variabilei
	 * @param value Valoarea variabilei
	 */
	DoubleOperand(String variableName, double value) {
		this.name = variableName;
		this.value = value;
	}
	
	/**
	 * @return Valoarea nodului
	 */
	public double getValue() {
		return value.doubleValue();
	}
	
	public void accept(TreeVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "Double(" + getName() + "," + getValue() + ")";
	}
}
