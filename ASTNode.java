/**
 * @author Andreea\
 * Clasa abstracta pe care o vor mosteni toate tipurile de
 * noduri: operatori sau operanzi.
 */
public abstract class ASTNode {
	/**
	 * Copilul stang al nodului
	 */
	protected ASTNode left;
	/**
	 * Copilul drept al nodului
	 */
	protected ASTNode right;
	/**
	 * Numele nodului
	 */
	protected String name;

	/**
	 * @return Copilul stanga al nodului
	 */
	public ASTNode getLeftChild() {
		return left;
	}

	/**
	 * @return Copilul dreapta al nodului
	 */
	public ASTNode getRightChild() {
		return right;
	}

	/**
	 * @param left
	 *            Copilul stanga al nodului
	 */
	public void setLeftChild(ASTNode left) {
		this.left = left;
	}

	/**
	 * @param right
	 *            Copilul dreapta al nodului
	 */
	public void setRightChild(ASTNode right) {
		this.right = right;
	}

	/**
	 * @return Numele nodului
	 */
	public String getName() {
		return name;
	}

	public String toString() {
		return getName();
	}

	/**
	 * @param visitor
	 *            Elementul de tip vizitator pe care nodul il accepta.
	 */
	abstract public void accept(TreeVisitor visitor);
}
