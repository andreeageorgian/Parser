/**
 * @author Andreea
 * Clasa reponsabila pentru operatorul de scadere (-).
 */
public class SubstractOperator extends ASTNode {
	
	/**
	 * In constructorul default, se seteaza numele nodului
	 * la simbolul -.
	 */
	public SubstractOperator() {
		this.name = "-";
	}
	
	public void accept(TreeVisitor visitor) {
		visitor.visit(this);
	}
	
	/**
	 * @param o1 Parametrul stanga al operatiei
	 * @param o2 Parametrul dreapta al operatiei
	 * @return Rezultatul operatiei
	 * 
	 * Scade doua noduri ale AST-ului si returneaza rezultatul 
	 * caracteristic (de tip Int, Double sau String). In cazul NaN,
	 * se returneaza un nod de tip String cu valoarea setata pe
	 * sirul "NaN".
	 */
	public ASTNode subtract(ASTNode o1, ASTNode o2) {
		if (o1 instanceof IntOperand && o2 instanceof IntOperand) {
			IntOperand i1 = (IntOperand) o1;
			IntOperand i2 = (IntOperand) o2;
			return new IntOperand("", i1.getValue() - i2.getValue());
		}
		if (o1 instanceof IntOperand && o2 instanceof DoubleOperand) {
			IntOperand i1 = (IntOperand) o1;
			DoubleOperand i2 = (DoubleOperand) o2;
			return new DoubleOperand("", i1.getValue() - i2.getValue());
		}
		if (o1 instanceof IntOperand && o2 instanceof StringOperand) {
			IntOperand i1 = (IntOperand) o1;
			StringOperand i2 = (StringOperand) o2;
			if (i2.getValue().equals("NaN")) {
				return i2;
			}
			return new IntOperand("", i1.getValue() - i2.getValue().length());
		}
		if (o1 instanceof DoubleOperand && o2 instanceof IntOperand) {
			DoubleOperand i1 = (DoubleOperand) o1;
			IntOperand i2 = (IntOperand) o2;
			return new DoubleOperand("", i1.getValue() - i2.getValue());
		}
		if (o1 instanceof DoubleOperand && o2 instanceof DoubleOperand) {
			DoubleOperand i1 = (DoubleOperand) o1;
			DoubleOperand i2 = (DoubleOperand) o2;
			return new DoubleOperand("", i1.getValue() - i2.getValue());
		}
		if (o1 instanceof DoubleOperand && o2 instanceof StringOperand) {
			DoubleOperand i1 = (DoubleOperand) o1;
			StringOperand i2 = (StringOperand) o2;
			if (i2.getValue().equals("NaN")) {
				return i2;
			}
			return new DoubleOperand("", i1.getValue() - i2.getValue().length());
		}
		if (o1 instanceof StringOperand && o2 instanceof IntOperand) {
			StringOperand i1 = (StringOperand) o1;
			IntOperand i2 = (IntOperand) o2;
			if (i1.getValue().equals("NaN")) {
				return i1;
			}
			if (i2.getValue() > i1.getValue().length()) {
				return new StringOperand("", "");
			}
			if (i2.getValue() < 0) {
				int value = -i2.getValue();
				String result = i1.getValue();
				for (int i = 0; i < value; i++) {
					result += "#";
				}
				return new StringOperand("", result);
			}
			return new StringOperand("", i1.getValue().substring(0, i1.getValue().length() - i2.getValue()));
		}
		if (o1 instanceof StringOperand && o2 instanceof DoubleOperand) {
			StringOperand i1 = (StringOperand) o1;
			DoubleOperand i2 = (DoubleOperand) o2;
			if (i1.getValue().equals("NaN")) {
				return i1;
			}
			return new DoubleOperand("", i1.getValue().length() - i2.getValue());
		}
		if (o1 instanceof StringOperand && o2 instanceof StringOperand) {
			StringOperand i1 = (StringOperand) o1;
			StringOperand i2 = (StringOperand) o2;
			if (i1.getValue().equals("NaN") || i2.getValue().equals("NaN")) {
				return new StringOperand("", "NaN");
			}
			return new IntOperand("", i1.getValue().length() - i2.getValue().length());
		}
		TreeUtils.printAST(o1, 2);
		TreeUtils.printAST(o2, 2);
		return null;
	}
}
