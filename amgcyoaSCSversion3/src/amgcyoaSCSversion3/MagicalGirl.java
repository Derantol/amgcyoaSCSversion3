package amgcyoaSCSversion3;

public class MagicalGirl {
	//The magical girl's name.
	String name;
	
	//There are five primary stats: Strength, Agility, Vitality, Magic, and Luck.
	//Each of these has a current, max, base, and boost value. Max is equal to base+boost.
	//Max HP is derived from max Vitality; max WP is set at 2 by default.
	//Evasion, defense, critical hit rate, critical bonus damage, and spell rating are all secondary stats.
	//These are all derived from the primary stats, except for critical bonus damage, which is by default 50% bonus damage (x1.5)
	int str;
	int agi;
	int vit;
	int mag;
	int luk;
	int strMax;
	int agiMax;
	int vitMax;
	int magMax;
	int lukMax;
	int strBase;
	int agiBase;
	int vitBase;
	int magBase;
	int lukBase;
	int strBoost;
	int agiBoost;
	int vitBoost;
	int magBoost;
	int lukBoost;
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
		setCurrentStats(strMax, agiMax, vitMax, magMax, lukMax, hpMax, wpMax);
	}
	
	//Sets each base stat to a new value, and then recalculates and sets max stats accordingly.
	private void setBaseStats(int newStr, int newAgi, int newVit, int newMag, int newLuk) {
		strBase = newStr;
		agiBase = newAgi;
		vitBase = newVit;
		magBase = newMag;
		lukBase = newLuk;
		setMaxStats();
	}

	//Sets each boost stat to a new value, and then recalculates and sets max stats accordingly.
	private void setBoostStats(int newStr, int newAgi, int newVit, int newMag, int newLuk) {
		strBoost = newStr;
		agiBoost = newAgi;
		vitBoost = newVit;
		magBoost = newMag;
		lukBoost = newLuk;
		setMaxStats();
	}
	
	//Sets each stat maximum to be equal to the stat base plus the stat boost; also calculates max HP.
	private void setMaxStats() {
		strMax = strBase + strBoost;
		agiMax = agiBase + agiBoost;
		vitMax = vitBase + vitBoost;
		magMax = magBase + magBoost;
		lukMax = lukBase + lukBoost;
		hpMax = vitMax * 10;
	}
	
	//Used to set the current stat values to new ones; also recalculates all derived stats.
	public void setCurrentStats(int newStr, int newAgi, int newVit, int newMag, int newLuk, int newHP, int newWP) {
		str = newStr;
		agi = newAgi;
		vit = newVit;
		mag = newMag;
		luk = newLuk;
		hp = newHP;
		wp = newWP;
		
		setEvasion();
		setDefense();
		setCriticalHitRate();
		setCriticalBonusDamage();
		setSpellRating();
	}
	
	private void setEvasion() {
		eva = (int) Math.floor((agi + luk) / 2.0);
	}
	
	private void setDefense() {
		def = (int) Math.floor((str + vit) / 2.0);
	}
	
	private void setCriticalHitRate() {
		critRate = luk * 2;
	}
	
	private void setCriticalBonusDamage() {
		critBonus = 1.5;
	}
	
	private void setSpellRating() {
		int[] stats = {str, agi, vit, mag, luk};
		int highestStat = 0;
		for(int i = 0; i < 5; i++) {
			highestStat = Math.max(highestStat, stats[i]);
		}
		spellRating = mag + highestStat;
	}
	
	//To-do: add getter methods
	//To-do: add methods to change each individual current stat (routed through the main setCurrentStats method to ensure that all derived stats are recalculated)
}
