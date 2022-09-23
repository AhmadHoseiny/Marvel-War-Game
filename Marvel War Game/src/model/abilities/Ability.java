package model.abilities;

import java.util.ArrayList;

import model.world.AntiHero;
import model.world.Damageable;
import model.world.Hero;

public abstract class Ability {
	private String name;
	private int manaCost;
	private int baseCooldown;
	private int currentCooldown;
	private int castRange;
	private AreaOfEffect castArea;
	private int requiredActionPoints;

	public Ability(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required) {
		this.name = name;
		this.manaCost = cost;
		this.baseCooldown = baseCoolDown;
		this.currentCooldown = 0;
		this.castRange = castRange;
		this.castArea = area;
		this.requiredActionPoints = required;
	}
	public String toString() {
		String res = "";
		res += "Name: "+ this.getName() + "\n";
		String type ; 
		if (this instanceof CrowdControlAbility) {
			type = "CrowdControlAbility" ;
		}
		else {
			if (this instanceof DamagingAbility) {
				type = "DamagingAbility" ;
			}
			else {
				type = "HealingAbility" ;
			}			
		}
		res+= "Type: " + type + "\n" ;
		res+= "AreaOfEffect: " + this.castArea + "\n";
		res+= "CastRange: " + this.castRange+ "\n";
		res+= "mana: " + this.manaCost+ "\n";
		res+= "ActionPoints: " + this.requiredActionPoints+ "\n";
		res+= "Current cooldown: " + this.getCurrentCooldown()+ "\n";
		res+= "base cooldown: " + this.getBaseCooldown()+ "\n";
		if (this instanceof CrowdControlAbility) {
			res+= "EffectName :"+ ((CrowdControlAbility)this).getEffect().getName()+ "\n"+
					"EffectDuration :"+((CrowdControlAbility)this).getEffect().getDuration()+"}" +"\n";
		}
		else {
			if (this instanceof DamagingAbility) {
				 res+= "DamageAmount: "+ ((DamagingAbility)this).getDamageAmount()+"}"+"\n";
			}
			else {
				res+= "HealingAmount"+ ((HealingAbility)this).getHealAmount()+"}"+ "\n" ;
			}	
	}
		return res;
	}

	public int getCurrentCooldown() {
		return currentCooldown;
	}
	public abstract void execute(ArrayList<Damageable> targets) throws CloneNotSupportedException;

	public void setCurrentCooldown(int currentCoolDown) {
		if (currentCoolDown < 0)
			currentCoolDown = 0;
		else if (currentCoolDown > baseCooldown)
			currentCoolDown = baseCooldown;
		this.currentCooldown = currentCoolDown;
	}

	public String getName() {
		return name;
	}

	public int getManaCost() {
		return manaCost;
	}

	public int getBaseCooldown() {
		return baseCooldown;
	}

	public int getCastRange() {
		return castRange;
	}

	public AreaOfEffect getCastArea() {
		return castArea;
	}

	public int getRequiredActionPoints() {
		return requiredActionPoints;
	}

}
