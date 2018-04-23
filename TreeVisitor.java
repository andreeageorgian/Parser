/**
 * @author Andreea
 * Interfata vizitatorului
 */
public interface TreeVisitor {
	/**
	 * @param o Operator de adunare
	 * @return Nodul rezultat
	 */
	ASTNode visit(AddOperator o);
	/**
	 * @param o Operator de impartire
	 * @return Nodul rezultat
	 */
	ASTNode visit(DivideOperator o);
	/**
	 * @param o Operand de tip double.
	 * @return Nodul rezultat
	 */
	ASTNode visit(DoubleOperand o);
	/**
	 * @param o Operand de tip intreg
	 * @return Nodul rezultat
	 */
	ASTNode visit(IntOperand o);
	/**
	 * @param o Operator de inmultire
	 * @return Nodul rezultat
	 */
	ASTNode visit(MultiplyOperator o);
	/**
	 * @param o Operand de tip string
	 * @return Nodul rezultat
	 */
	ASTNode visit(StringOperand o);
	/**
	 * @param o Operator de scadere
	 * @return Nodul rezultat
	 */
	ASTNode visit(SubstractOperator o);
	/**
	 * @param o Nod al arborelui
	 * @return Nodul rezultat
	 */
	ASTNode visit(ASTNode o);
}
