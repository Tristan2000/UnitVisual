import java.util.Scanner;
import java.io.*;
public class Unit {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Name the file Unit.dat: ");
		File outputFileName = new File(input.nextLine());
		//default attackRange and reloadTime
		double attackRange = 1;
		double reloadTime = 0;
		
		//get health
		System.out.println("Enter unit health");
		double health = input.nextDouble();
		
		//get attack
		System.out.println("Enter unit attack");
		double attack = input.nextDouble();
		
		//get rangedArmor
		System.out.println("Enter unit ranged armor");
		double rangedArmor = input.nextDouble();
		
		//get meleeArmor
		System.out.println("Enter unit melee armor");
		double meleeArmor = input.nextDouble();
		
		//get foodCost
		System.out.println("Enter unit food cost");
		double foodCost = input.nextDouble();
		
		//get woodCost
		System.out.println("Enter unit wood cost");
		double woodCost = input.nextDouble();
		
		//get goldCost
		System.out.println("Enter unit gold cost");
		double goldCost = input.nextDouble();
		
		//get name
		System.out.println("Enter unit name");
		String name = input.next();
		
		//get class
		System.out.println("Enter unit class. 0 for Cavalry, 1 for Infantry, 2 for Ranged, and 3 for Siege");
		int classSelector = input.nextInt();
		while (classSelector <= 0 && classSelector >= 4){
			System.out.println("Incorrect class number. Enter unit class. 0 for Cavalry, 1 for Infantry, 2 for Ranged, and 3 for Siege");
			classSelector = input.nextInt();
		}
		//get attackRange and reloadTime if applicable
		if (classSelector == 2){
			System.out.println("Enter the attack range: ");
			attackRange = input.nextDouble();
			System.out.println("Enter reload time: ");
			reloadTime = input.nextDouble();
		}
		if (classSelector == 3){
			System.out.println("Enter the attack range: ");
			attackRange = input.nextDouble();
			System.out.println("Enter reload time: ");
			reloadTime = input.nextDouble();
		}
		
		//get veteranUpgradeCosts
		System.out.println("Enter the veteran upgrade food cost");
		double veteranUpgradeFoodCost = input.nextDouble();
		System.out.println("Enter the veteran upgrade gold cost");
		double veteranUpgradeGoldCost = input.nextDouble();
		
		//get eliteUpgradeCosts
		System.out.println("Enter the elite upgrade food cost");
		double eliteUpgradeFoodCost = input.nextDouble();
		System.out.println("Enter the elite upgrade gold cost");
		double eliteUpgradeGoldCost = input.nextDouble();
		
		//get both HealthBuffs
		System.out.println("Enter the veteran health value upgrade");
		double veteranUpgradeHealthBuff = input.nextDouble();
		System.out.println("Enter the elite health value upgrade");
		double eliteUpgradeHealthBuff = input.nextDouble();
		
		//get both AttackBuffs
		System.out.println("Enter the veteran attack value upgrade");
		double veteranUpgradeAttackBuff = input.nextDouble();
		System.out.println("Enter the elite attack value upgrade");
		double eliteUpgradeAttackBuff = input.nextDouble();
		
		//get both RangedArmorBuffs
		System.out.println("Enter the veteran ranged armor value upgrade");
		double veteranUpgradeRangedArmorBuff = input.nextDouble();
		System.out.println("Enter the elite ranged armor value upgrade");
		double eliteUpgradeRangedArmorBuff = input.nextDouble();
		
		//get both MeleeArmorBuffs
		System.out.println("Enter the veteran melee armor value upgrade");
		double veteranUpgradeMeleeArmorBuff = input.nextDouble();
		System.out.println("Enter the elite melee armor value upgrade");
		double eliteUpgradeMeleeArmorBuff = input.nextDouble();
		
		TestUnit newUnit = new TestUnit(health, attack, rangedArmor, meleeArmor, foodCost, woodCost, goldCost, name, classSelector, attackRange, reloadTime, veteranUpgradeFoodCost, eliteUpgradeFoodCost, veteranUpgradeGoldCost, eliteUpgradeGoldCost, veteranUpgradeHealthBuff, eliteUpgradeHealthBuff, veteranUpgradeAttackBuff, eliteUpgradeAttackBuff, veteranUpgradeRangedArmorBuff, eliteUpgradeRangedArmorBuff, veteranUpgradeMeleeArmorBuff, eliteUpgradeMeleeArmorBuff);
		
		System.out.println(newUnit.toString());
		
		try (
				ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(outputFileName));
		) {
			objectOutput.writeObject(newUnit);
		} 
		catch (IOException ex) {
			System.out.println("File could not be opened");
		}
		
	}
}

class TestUnit{
	//Unit variables
	protected double health;
	protected double attack;
	protected double rangedArmor;
	protected double meleeArmor;
	protected double foodCost;
	protected double woodCost;
	protected double goldCost;
	protected String name = " ";
	protected int classSelector;
	protected String unitClass = " ";
	protected String[] unitClassArray = {"Cavalry", "Infantry", "Ranged", "Siege"};
	protected double attackRange;
	protected double reloadTime;
	//Upgrade variables
	protected double veteranUpgradeFoodCost;
	protected double eliteUpgradeFoodCost;
	protected double veteranUpgradeGoldCost;
	protected double eliteUpgradeGoldCost;
	protected double veteranUpgradeHealthBuff;
	protected double eliteUpgradeHealthBuff;
	protected double veteranUpgradeAttackBuff;
	protected double eliteUpgradeAttackBuff;
	protected double veteranUpgradeRangedArmorBuff;
	protected double eliteUpgradeRangedArmorBuff;
	protected double veteranUpgradeMeleeArmorBuff;
	protected double eliteUpgradeMeleeArmorBuff;
	//final stats
	protected double finalHealth;
	protected double finalAttack;
	protected double finalRangedArmor;
	protected double finalMeleeArmor;
	
	//Default constructor
	TestUnit(){
		health = 50;
		attack = 5;
		rangedArmor = 2;
		meleeArmor = 5;
		foodCost = 50;
		woodCost = 30;
		goldCost = 0;
		name = "Spearman";
		classSelector = 1;
		unitClass = unitClassArray[classSelector];
		attackRange = 1;
		reloadTime = 3.5;
		//upgrade constructor
		veteranUpgradeFoodCost = 50;
		eliteUpgradeFoodCost = 100;
		veteranUpgradeGoldCost = 150;
		eliteUpgradeGoldCost = 300;
		veteranUpgradeHealthBuff = 10;
		eliteUpgradeHealthBuff = 20;
		veteranUpgradeAttackBuff = 5;
		eliteUpgradeAttackBuff = 10;
		veteranUpgradeRangedArmorBuff = 2;
		eliteUpgradeRangedArmorBuff = 4;
		veteranUpgradeMeleeArmorBuff = 4;
		eliteUpgradeMeleeArmorBuff = 8;
		//final constructors
		finalHealth = veteranUpgradeHealthBuff + eliteUpgradeHealthBuff + health;
		finalAttack = veteranUpgradeAttackBuff + eliteUpgradeAttackBuff + attack;
		finalRangedArmor = veteranUpgradeRangedArmorBuff + eliteUpgradeRangedArmorBuff + rangedArmor;
		finalMeleeArmor = veteranUpgradeMeleeArmorBuff + eliteUpgradeMeleeArmorBuff + meleeArmor;
	}
	//The one we use
	TestUnit(double health, double attack, double rangedArmor, double meleeArmor, double foodCost, double woodCost, double goldCost, String name, int classSelector, double attackRange, double reloadTime, double veteranUpgradeFoodCost, double eliteUpgradeFoodCost, double veteranUpgradeGoldCost, double eliteUpgradeGoldCost, double veteranUpgradeHealthBuff, double eliteUpgradeHealthBuff, double veteranUpgradeAttackBuff, double eliteUpgradeAttackBuff, double veteranUpgradeRangedArmorBuff, double eliteUpgradeRangedArmorBuff, double veteranUpgradeMeleeArmorBuff, double eliteUpgradeMeleeArmorBuff){
		this.health = health;
		this.attack = attack;
		this.rangedArmor = rangedArmor;
		this.meleeArmor = meleeArmor;
		this.foodCost = foodCost;
		this.woodCost = woodCost;
		this.goldCost = goldCost;
		this.name = name;
		this.classSelector = classSelector;
		unitClass = unitClassArray[classSelector];
		this.attackRange = attackRange;
		this.reloadTime = reloadTime;
		this.veteranUpgradeFoodCost = veteranUpgradeFoodCost;
		this.eliteUpgradeFoodCost = eliteUpgradeFoodCost;
		this.veteranUpgradeGoldCost = veteranUpgradeGoldCost;
		this.eliteUpgradeGoldCost = eliteUpgradeGoldCost;
		this.veteranUpgradeHealthBuff = veteranUpgradeHealthBuff;
		this.eliteUpgradeHealthBuff = eliteUpgradeHealthBuff;
		this.veteranUpgradeAttackBuff = veteranUpgradeAttackBuff;
		this.eliteUpgradeAttackBuff = eliteUpgradeAttackBuff;
		this.veteranUpgradeRangedArmorBuff = veteranUpgradeRangedArmorBuff;
		this.eliteUpgradeRangedArmorBuff = eliteUpgradeRangedArmorBuff;
		this.veteranUpgradeMeleeArmorBuff = veteranUpgradeMeleeArmorBuff;
		this.eliteUpgradeMeleeArmorBuff = eliteUpgradeMeleeArmorBuff;
		finalHealth = veteranUpgradeHealthBuff + eliteUpgradeHealthBuff + health;
		finalAttack = veteranUpgradeAttackBuff + eliteUpgradeAttackBuff + attack;
		finalRangedArmor = veteranUpgradeRangedArmorBuff + eliteUpgradeRangedArmorBuff + rangedArmor;
		finalMeleeArmor = veteranUpgradeMeleeArmorBuff + eliteUpgradeMeleeArmorBuff + meleeArmor;
	}
	
	//get and set health
	public double getHealth(){
		return health;
	}
	public void setHealth(double health){
		this.health = health;
	}
	
	//get and set attack
	public double getAttack(){
		return attack;
	}
	public void setAttack(double attack){
		this.attack = attack;
	}
	
	//get and set rangedArmor
	public double getRangedArmor(){
		return rangedArmor;
	}
	public void setRangedArmor(double rangedArmor){
		this.rangedArmor = rangedArmor;
	}
	
	//get and set meleeArmor
	public double getMeleeArmor(){
		return meleeArmor;
	}
	public void setMeleeArmor(double meleeArmor){
		this.meleeArmor = meleeArmor;
	}
	
	//get and set foodCost
	public double getFoodCost(){
		return foodCost;
	}
	public void setFoodCost(double foodCost){
		this.foodCost = foodCost;
	}
	
	//get and set woodCost
	public double getWoodCost(){
		return woodCost;
	}
	public void setWoodCost(double woodCost){
		this.woodCost = woodCost;
	}
	
	//get and set goldCost
	public double getGoldCost(){
		return goldCost;
	}
	public void setGoldCost(double goldCost){
		this.goldCost = goldCost;
	}
	
	//get and set name
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	//get and set attack range
	public double getAttackRange(){
		return attackRange;
	}
	public void setAttackRange(double attackRange){
		this.attackRange = attackRange;
	}
	
	//get and set reloadTime
	public double getReloadTime(){
		return reloadTime;
	}
	public void setReloadTime(double reloadTime){
		this.reloadTime = reloadTime;
	}
	
	//get and set veteran upgrade cost
	public double getVeteranUpgradeFoodCost(){
		return veteranUpgradeFoodCost;
	}
	public void setVeteranUpgradeFoodCost(double veteranUpgradeFoodCost){
		this.veteranUpgradeFoodCost = veteranUpgradeFoodCost;
	}
	public double getVeteranUpgradeGoldCost(){
		return veteranUpgradeGoldCost;
	}
	public void setVeteranUpgradeGoldCost(double veteranUpgradeGoldCost){
		this.veteranUpgradeGoldCost = veteranUpgradeGoldCost;
	}
	
	//get and set elite upgrade cost
	public double getEliteUpgradeFoodCost(){
		return eliteUpgradeFoodCost;
	}
	public void setEliteUpgradeFoodCost(double eliteUpgradeFoodCost){
		this.eliteUpgradeFoodCost = eliteUpgradeFoodCost;
	}
	public double getEliteUpgradeGoldCost(){
		return eliteUpgradeGoldCost;
	}
	public void setEliteUpgradeGoldCost(double eliteUpgradeGoldCost){
		this.eliteUpgradeGoldCost = eliteUpgradeGoldCost;
	}
	
	//get and set health upgrades
	public double getVeteranUpgradeHealthBuff(){
		return veteranUpgradeHealthBuff;
	}
	public void setVeteranUpgradeHealthBuff(double veteranUpgradeHealthBuff){
		this.veteranUpgradeHealthBuff = veteranUpgradeHealthBuff;
	}
	public double getEliteUpgradeHealthBuff(){
		return eliteUpgradeHealthBuff;
	}
	public void setEliteUpgradeHealthBuff(double eliteUpgradeHealthBuff){
		this.eliteUpgradeHealthBuff = eliteUpgradeHealthBuff;
	}
	
	//get and set attack upgrades
	public double getVeteranUpgradeAttackBuff(){
		return veteranUpgradeAttackBuff;
	}
	public void setVeteranUpgradeAttackBuff(double veteranUpgradeAttackBuff){
		this.veteranUpgradeAttackBuff = veteranUpgradeAttackBuff;
	}
	public double getEliteUpgradeAttackBuff(){
		return eliteUpgradeAttackBuff;
	}
	public void setEliteUpgradeAttackBuff(double eliteUpgradeAttackBuff){
		this.eliteUpgradeAttackBuff = eliteUpgradeAttackBuff;
	}
	
	//get and set rangedArmor upgrades
	public double getVeteranUpgradeRangedArmorBuff(){
		return veteranUpgradeRangedArmorBuff;
	}
	public void setVeteranUpgradeRangedArmorBuff(double veteranUpgradeRangedArmorBuff){
		this.veteranUpgradeRangedArmorBuff = veteranUpgradeRangedArmorBuff;
	}
	public double getEliteUpgradeRangedArmorBuff(){
		return eliteUpgradeRangedArmorBuff;
	}
	public void setEliteUpgradeRangedArmorBuff(double eliteUpgradeRangedArmorBuff){
		this.eliteUpgradeRangedArmorBuff = eliteUpgradeRangedArmorBuff;
	}
	
	//get and set meleeArmor upgrades
	public double getVeteranUpgradeMeleeArmorBuff(){
		return veteranUpgradeMeleeArmorBuff;
	}
	public void setVeteranUpgradeMeleeArmorBuff(double veteranUpgradeMeleeArmorBuff){
		this.veteranUpgradeMeleeArmorBuff = veteranUpgradeMeleeArmorBuff;
	}
	public double getEliteUpgradeMeleeArmorBuff(){
		return eliteUpgradeMeleeArmorBuff;
	}
	public void setEliteUpgradeMeleeArmorBuff(double eliteUpgradeMeleeArmorBuff){
		this.eliteUpgradeMeleeArmorBuff = eliteUpgradeMeleeArmorBuff;
	}
	
	public String toString(){
		return "Health: " + health + ", Attack: " + attack + ", Ranged Armor: " + rangedArmor + ", Melee Armor: " + meleeArmor + ", Food Cost: " + foodCost + ", Wood Cost: " + woodCost + ", Gold Cost: " + goldCost + ", Name: " + name + ", Class: " + unitClass + ", Attack Range: " + attackRange + ", Reload Time: " + reloadTime + ", Veteran Upgrade Food Cost: " + veteranUpgradeFoodCost + ", Veteran Upgrade Gold Cost: " + veteranUpgradeGoldCost + ", Elite Upgrade Food Cost: " + eliteUpgradeFoodCost + ", Elite Upgrade Gold Cost: " + eliteUpgradeGoldCost + ", Veteran Health Upgrade: " + veteranUpgradeHealthBuff + ", Elite Health Upgrade: " + eliteUpgradeHealthBuff + ", Veteran Attack Upgrade: " + veteranUpgradeAttackBuff + ", Elite Attack Upgrade: " + eliteUpgradeAttackBuff + ", Veteran Ranged Armor Upgrade: " + veteranUpgradeRangedArmorBuff + ", Elite Ranged Armor Upgrade: " + eliteUpgradeRangedArmorBuff + ", Veteran Melee Armor Upgrade: " + veteranUpgradeMeleeArmorBuff + ", Elite Melee Armor Upgrade: " + eliteUpgradeMeleeArmorBuff + ", Final Health: " + finalHealth + ", Final Attack: " + finalAttack + ", Final Ranged Armor: " + finalRangedArmor + ", Final Melee Armor: " + finalMeleeArmor;
	}
}