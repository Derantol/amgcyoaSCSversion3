package amgcyoaSCSversion3;

public class Stat {
	int current = 0;	//Tracks the current value of the stat, in practice should be changing frequently
	int base = 0;		//Base stat, under normal circumstances should be set once and never touched again
	int boost = 0;		//Boost stat, under normal circumstances, should be set once and never touched again
	
	//Generates a stat, establishes base and boost, and calculates and sets the current value
	public Stat(int newBase, int newBoost) {
		base = newBase;
		boost = newBoost;
		current = base + boost;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public int getBase() {
		return base;
	}
	
	public int getBoost() {
		return boost;
	}
	
	public int getMax() {
		return base + boost;
	}
	
	public void setCurrent(int newCurrent) {
		current = newCurrent;
	}
	
	public void setBase(int newBase) {
		base = newBase;
		current = base + boost;
	}
	
	public void setBoost(int newBoost) {
		boost = newBoost;
		current = base + boost;
	}
	
	public void setStat(int newBase, int newBoost) {
		base = newBase;
		boost = newBoost;
		current = base + boost;
	}
	
	//Used when paying for the cost of an ability. Also usable in cases where there is stat loss for any other reason.
	public void pay(int x) {
		current = current - x;
		if(current < 0) {
			current = 0;
		}
	}
	
	//Used for stat recovery - recovery cannot bring a stat above its normal maximum value.
	public void recover(int x) {
		gain(x);
		if(current > base + boost) {
			current = base + boost;
		}
	}
	
	//Used for stat gain - gain CAN bring a stat above its normal maximum value.
	public void gain(int x) {
		current = current + x;
	}
	
	//Used for stat recovery during downtime or reprieve.
	public void fullRestore() {
		current = base + boost;
	}
}
