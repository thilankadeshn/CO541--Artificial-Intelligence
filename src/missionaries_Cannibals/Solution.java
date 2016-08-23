package missionaries_Cannibals;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Thilanka Deshan. Date: 22/08/2016
 */
public class Solution {

	public static void main(String[] args) {
		BFS search = new BFS();

		State initialState = new State(Position.L, 0, 3, 0, 3);
		Node initialNode = new Node(initialState, null, 0);

		Node solutionNode = search.execute(initialNode);

		List<State> SolutionPath = new ArrayList<State>();

		if (solutionNode == null) {
			System.out.println("Sorry! No Solution Found");
		} else {
			while (solutionNode.getParent() != null) {
				SolutionPath.add(solutionNode.getState());
				solutionNode = solutionNode.getParent();
			}
		}

		int pathLength = SolutionPath.size();

		// printing the solution
		if (pathLength != 0)
			System.out.println(initialState.toString());
		for (int i = pathLength - 1; i >= 0; i--) {
			System.out.println(SolutionPath.get(i).toString());
		}
	}

}
