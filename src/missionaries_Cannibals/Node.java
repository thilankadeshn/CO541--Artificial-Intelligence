package missionaries_Cannibals;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Thilanka Deshan. Date: 22/08/2016
 */

public class Node {

	private State state;
	private Node parent;
	private int pathCost;

	public Node(State state, Node parent, int pathCost) {
		this.state = state;
		this.parent = parent;
		this.pathCost = pathCost;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getPathCost() {
		return pathCost;
	}

	public void setPathCost(int pathCost) {
		this.pathCost = pathCost;
	}

	// checking whether two nodes are equal or not
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node))
			return false;
		else {
			Node node = (Node) obj;
			return (this.state.equals(node.getState()));
		}

	}

	public List<Node> generateChildNodes() {

		int ml, mr, cl, cr;
		int m, c;
		State tempChildState, parentState;

		parentState = (State) this.getState();

		ml = parentState.getMissionariesLeft();
		mr = parentState.getMissionariesRight();
		cl = parentState.getCannibalsLeft();
		cr = parentState.getCannibalsRight();

		List<Node> childNodes = new ArrayList<Node>();

		// if boat is on Left bank
		if (parentState.isBoatOnLeft()) {
			for (m = parentState.getMissionariesLeft(); 0 < m && m <= 3; m--) {
				for (c = parentState.getCannibalsLeft(); c >= 0 && c <= 3; c--) {
					if ((m + c) <= 2) {
						tempChildState = new State(Position.R, cr + c, cl - c, mr + m, ml - m);
						if (tempChildState.checkState()) {
							Node ChildNode = new Node(tempChildState, this, this.getPathCost() + 1);
							if (!childNodes.contains(ChildNode))
								childNodes.add(ChildNode);
						}
					}

				}
			}
			for (c = parentState.getCannibalsLeft(); c > 0 && c <= 3; c--) {
				for (m = parentState.getMissionariesLeft(); 0 <= m && m <= 3; m--) {
					if ((m + c) <= 2) {
						tempChildState = new State(Position.R, cr + c, cl - c, mr + m, ml - m);
						if (tempChildState.checkState()) {
							Node ChildNode = new Node(tempChildState, this, this.getPathCost() + 1);
							if (!childNodes.contains(ChildNode))
								childNodes.add(ChildNode);
						}
					}

				}
			}
		}
		// if boat is on Right bank
		else {
			for (m = parentState.getMissionariesRight(); 0 < m && m <= 3; m--) {
				for (c = parentState.getCannibalsRight(); c >= 0 && c <= 3; c--) {
					if ((m + c) <= 2) {
						tempChildState = new State(Position.L, cr - c, cl + c, mr - m, ml + m);
						if (tempChildState.checkState()) {
							Node ChildNode = new Node(tempChildState, this, this.getPathCost() + 1);
							if (!childNodes.contains(ChildNode))
								childNodes.add(ChildNode);
						}
					}

				}
			}

			for (c = parentState.getCannibalsRight(); c > 0 && c <= 3; c--) {
				for (m = parentState.getMissionariesRight(); 0 <= m && m <= 3; m--) {
					if ((m + c) <= 2) {
						tempChildState = new State(Position.L, cr - c, cl + c, mr - m, ml + m);
						if (tempChildState.checkState()) {
							Node ChildNode = new Node(tempChildState, this, this.getPathCost() + 1);
							if (!childNodes.contains(ChildNode))
								childNodes.add(ChildNode);
						}
					}

				}
			}
		}
		return childNodes;

	}
}
