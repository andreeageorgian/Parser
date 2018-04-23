import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andreea
 */
public class Main {
	/**
	 * @param args Argumentele din linia de comanda
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		List<ASTNode> variables = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader("arbore.in"));
			PrintWriter writer = new PrintWriter("arbore.out", "UTF-8");
			String line;
			while ((line = br.readLine()) != null) {
				// Daca este o linie de evaluare
				if (line.startsWith("eval")) {
					String[] tokens = line.split(" ");
					List<String> expression = new ArrayList<>();
					for (int i = 1; i < tokens.length; i++) {
						if (i == tokens.length - 1) {
							expression.add(tokens[i].substring(0, tokens[i].length() - 1));
						} else {
							expression.add(tokens[i]);
						}
					}
					// Creeaza arborele sintactic
					ASTNode root = TreeUtils.createAST(expression, variables);
					// Evalueaza arborele
					EvaluatorTreeVisitor etv = new EvaluatorTreeVisitor();
					ASTNode finalResult = etv.visit(root);
					// Verifica rezultatul si scrie in fisier
					if (finalResult instanceof IntOperand) {
						IntOperand i1 = (IntOperand) finalResult;
						writer.println(i1.getValue());
					}
					if (finalResult instanceof DoubleOperand) {
						DoubleOperand i1 = (DoubleOperand) finalResult;
						double value = ((double) Math.round(i1.getValue() * 100)) / 100;
						writer.println(value);
					}
					if (finalResult instanceof StringOperand) {
						StringOperand i1 = (StringOperand) finalResult;
						writer.println(i1.getValue());
					}
				} else {
					// Daca linia este de declarare a unei variabile, creeaza
					// variabila
					// si adaug-o in lista variabilelor
					String[] tokens = line.split(" ");
					String variableType = tokens[0];
					String variableName = tokens[1];
					String variableValue = "";
					if (tokens.length > 4) {
						for (int i = 3; i < tokens.length; i++) {
							variableValue += tokens[i] + " ";
						}
						variableValue = variableValue.substring(0, variableValue.length() - 2);
					} else {
						variableValue = tokens[3].substring(0, tokens[3].length() - 1);
					}
					variables.add(NodeFactory.getInstance().createNode(variableType, variableName, variableValue));
				}
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
