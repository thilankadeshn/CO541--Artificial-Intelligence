package missionaries_Cannibals;
import java.util.*;

/**
 * Author: Thilanka Deshan. Date: 22/08/2016 implemented based on the BFS pseudo
 * Code in "Artifitial intelligence a modern appproch 3rd edition"
 */
public class BFS {

	// providing the initial node to the execute method
	public Node execute(Node initialNode) {
		if (initialNode.getState().goal_test()) {
			return initialNode;
		}

		Queue<Node> frontier = new LinkedList<Node>();
		Set<Node> explored = new HashSet<Node>();

		frontier.add(initialNode);

		while (true) {
			if (frontier.isEmpty())
				return null;
			Node node = frontier.poll();

			explored.add(node);
			List<Node> ChildNodes = node.generateChildNodes();

			for (Node childNode : ChildNodes) {
				// to void loops or revisiting nodes which already visited.
				if (!(frontier.contains(childNode) || explored.contains(childNode))) {
					if (childNode.getState().goal_test())
						return childNode;
					else
						frontier.add(childNode);
				}
			}
		}

	}
}
