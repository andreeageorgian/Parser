/**
 * @author Andreea
 * Vizitatorul responsabil de evaluarea AST-ului.
 */
public class EvaluatorTreeVisitor implements TreeVisitor {

	@Override
	public ASTNode visit(AddOperator o) {
		ASTNode left = visit(o.getLeftChild());
		ASTNode right = visit(o.getRightChild());
		ASTNode node = o.add(left, right);
		return node;
	}

	@Override
	public ASTNode visit(DivideOperator o) {
		ASTNode left = visit(o.getLeftChild());
		ASTNode right = visit(o.getRightChild());
		ASTNode node = o.divide(left, right);
		return node;
	}

	@Override
	public ASTNode visit(MultiplyOperator o) {
		ASTNode left = visit(o.getLeftChild());
		ASTNode right = visit(o.getRightChild());
		ASTNode node = o.multiply(left, right);
		return node;
	}
	
	@Override
	public ASTNode visit(SubstractOperator o) {
		ASTNode left = visit(o.getLeftChild());
		ASTNode right = visit(o.getRightChild());
		ASTNode node = o.subtract(left, right);
		return node;
	}
	
	@Override
	public ASTNode visit(DoubleOperand o) {
		return o;
	}

	@Override
	public ASTNode visit(IntOperand o) {
		return o;
	}
	
	@Override
	public ASTNode visit(StringOperand o) {
		return o;
	}

	public ASTNode visit(ASTNode o) {
		if (o instanceof AddOperator) {
			return visit((AddOperator) o);
		}
		else if (o instanceof SubstractOperator) {
			return visit((SubstractOperator) o);		
		}
		else if (o instanceof MultiplyOperator) {
			return visit((MultiplyOperator) o);
		}
		else if (o instanceof DivideOperator) {
			return visit((DivideOperator) o);
		}
		else if (o instanceof IntOperand) {
			return visit((IntOperand) o);
		}
		else if (o instanceof DoubleOperand) {
			return visit((DoubleOperand) o);		
		}
		else if (o instanceof StringOperand) {
			return visit((StringOperand) o);
		}
		return null;
	}
}
