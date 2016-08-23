/**
 * Author: Thilanka Deshan. Date: 22/08/2016
 */
package missionaries_Cannibals;

enum Position {
	R, L
};

public class State {

	private int missionariesLeft, missionariesRight, cannibalsLeft, cannibalsRight;
	private Position boatPosition;

	public State(Position boatPosition, int cannibalsRight, int cannibalsLeft, int missionariesRight,
			int missionariesLeft) {
		this.boatPosition = boatPosition;
		this.cannibalsRight = cannibalsRight;
		this.cannibalsLeft = cannibalsLeft;
		this.missionariesRight = missionariesRight;
		this.missionariesLeft = missionariesLeft;
	}

	public int getMissionariesLeft() {
		return missionariesLeft;
	}

	public void setMissionariesLeft(int missionariesLeft) {
		this.missionariesLeft = missionariesLeft;
	}

	public int getMissionariesRight() {
		return missionariesRight;
	}

	public void setMissionariesRight(int missionariesRight) {
		this.missionariesRight = missionariesRight;
	}

	public int getCannibalsLeft() {
		return cannibalsLeft;
	}

	public void setCannibalsLeft(int cannibalsLeft) {
		this.cannibalsLeft = cannibalsLeft;
	}

	public int getCannibalsRight() {
		return cannibalsRight;
	}

	public void setCannibalsRight(int cannibalsRight) {
		this.cannibalsRight = cannibalsRight;
	}

	public boolean isBoatOnLeft() {
		return this.boatPosition == Position.L;
	}

	public boolean isBoatOnRight() {
		return this.boatPosition == Position.R;
	}

	public void rideBoatRight() {
		boatPosition = Position.R;
	}

	public void rideBoatLeft() {
		boatPosition = Position.L;
	}

	public boolean goal_test() {
		return (this.cannibalsLeft == 0 && this.missionariesLeft == 0 && this.missionariesRight == 3
				&& this.cannibalsRight == 3);
	}

	public Position getBoatPosition() {
		return boatPosition;
	}

	public void setBoatPosition(Position boatPosition) {
		this.boatPosition = boatPosition;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof State)) {
			return false;
		} else {
			State state2 = (State) obj;

			return (this.cannibalsLeft == state2.getCannibalsLeft() && this.cannibalsRight == state2.getCannibalsRight()
					&& this.missionariesRight == state2.getMissionariesRight()
					&& this.missionariesLeft == state2.getMissionariesLeft()
					&& this.boatPosition == state2.getBoatPosition());
		}
	}

	@Override
	public String toString() {
		if (this.isBoatOnLeft()) {
			return ("[" + this.getMissionariesLeft() + " , " + this.getCannibalsLeft() + "] ------R-----> ["
					+ this.getMissionariesRight() + " , " + this.getCannibalsRight() + "]");
		} else {
			return ("[" + this.getMissionariesLeft() + " , " + this.getCannibalsLeft() + "] <-----L------ ["
					+ this.getMissionariesRight() + " , " + this.getCannibalsRight() + "]");
		}
	}

	// checking a given state against constraints
	public boolean checkState() {
		int ml, cl, mr, cr;

		ml = this.getMissionariesLeft();
		cl = this.getCannibalsLeft();
		mr = this.getMissionariesRight();
		cr = this.getCannibalsRight();

		if (ml > 0 && mr > 0)
			return (ml >= cl && mr >= cr);
		else if (mr == 0 || ml == 0)
			return true;
		else
			return false;
	}
}
