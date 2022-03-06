package amgcyoaSCSversion3;

public class MagicalGirl {
	//The magical girl's name.
	String name;
	
	//There are five primary stats: Strength, Agility, Vitality, Magic, and Luck.
	//Each of these has a current, max, base, and boost value. Max is equal to base+boost.
	//Max HP is derived from max Vitality; max WP is set at 2 by default.
	//Evasion, defense, critical hit rate, critical bonus damage, and spell rating are all secondary stats.
	//These are all derived from the primary stats, except for critical bonus damage, which is by default 50% bonus damage (x1.5)
	Stat str;
	Stat agi;
	Stat vit;
	Stat mag;
	Stat luk;
	int hp;
	int hpMax;
	int wp;
	int wpMax;
	int eva;
	int def;
	int critRate;
	double critBonus;
	int spellRating;
	
	//Creates a new magical girl, and generates a blank character slate for them.
	public MagicalGirl(String newName) {
		name = newName;
		blankCharacter();
	}
	
	//Sets all stats to default values, without consideration for any CYOA results.
	private void blankCharacter() {
		setBaseStats(3, 3, 3, 3, 3);
		setBoostStats(1, 1, 1, 1, 1);
		wpMax = 2;
		setCurrentStats(str.getMax(), agi.getMax(), vit.getMax(), mag.getMax(), luk.getMax(), hpMax, wpMax);
	}
	
	//Sets each base stat to a new value, and then recalculates and sets max stats accordingly.
	private void setBaseStats(int newStr, int newAgi, int newVit, int newMag, int newLuk) {
		str.setBase(newStr);
		agi.setBase(newAgi);
		vit.setBase(newVit);
		mag.setBase(newMag);
		luk.setBase(newLuk);
		hpMax = vit.getMax() * 10;
	}

	//Sets each boost stat to a new value, and then recalculates and sets max stats accordingly.
	private void setBoostStats(int newStr, int newAgi, int newVit, int newMag, int newLuk) {
		str.setBoost(newStr);
		agi.setBoost(newAgi);
		vit.setBoost(newVit);
		mag.setBoost(newMag);
		luk.setBoost(newLuk);
		hpMax = vit.getMax() * 10;

	}
		
	//Used to set the current stat values to new ones; also recalculates all derived stats.
	public void setCurrentStats(int newStr, int newAgi, int newVit, int newMag, int newLuk, int newHP, int newWP) {
		str.setCurrent(newStr);
		agi.setCurrent(newAgi);
		vit.setCurrent(newVit);
		mag.setCurrent(newMag);
		luk.setCurrent(newLuk);
		hp = newHP;
		wp = newWP;
		
		setEvasion();
		setDefense();
		setCriticalHitRate();
		setCriticalBonusDamage();
		setSpellRating();
	}
	
	private void setEvasion() {
		eva = (int) Math.floor((agi.getCurrent() + luk.getCurrent()) / 2.0);
	}
	
	private void setDefense() {
		def = (int) Math.floor((str.getCurrent() + vit.getCurrent()) / 2.0);
	}
	
	private void setCriticalHitRate() {
		critRate = luk.getCurrent() * 2;
	}
	
	private void setCriticalBonusDamage() {
		critBonus = 1.5;
	}
	
	private void setSpellRating() {
		int[] stats = {str.getCurrent(), agi.getCurrent(), vit.getCurrent(), mag.getCurrent(), luk.getCurrent()};
		int highestStat = 0;
		for(int i = 0; i < 5; i++) {
			highestStat = Math.max(highestStat, stats[i]);
		}
		spellRating = mag.getCurrent() + highestStat;
	}
	
	//To-do: add getter methods
	//To-do: add methods to change each individual current stat (routed through the main setCurrentStats method to ensure that all derived stats are recalculated)
}
