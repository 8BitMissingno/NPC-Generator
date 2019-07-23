package com;

import enums.Traits;

public class NPC 
{
	/**
	 * Represents various different traits of this NPC, each index represents a different 
	 * constant in Traits.
	 */
	private String[] traits;
	
	
	/**
	 * Creates a new NPC with random traits.
	 * @param rtp Random trait picker.
	 */
	public NPC(RandomTraitPicker rsg)
	{
		traits = new String[Traits.values().length];
		
		pickRandomTraits(rsg);
	}
	
	
	/**
	 * Picks a random trait for each constant in Traits.
	 * @param rsg Random String generator.
	 */
	private void pickRandomTraits(RandomTraitPicker rsg)
	{
		// Get a random trait for each type of Trait.
		for (int trait_i = 0; trait_i < Traits.values().length; trait_i++)
		{
			traits[trait_i] = rsg.getRandomTrait(Traits.values()[trait_i].getID());
		}
		// Ensure that the two ability Traits are not the same atribute. Compare the 
		// first word of both Trait Strings.
		while (traits[Traits.LOW_ABILITY.getID()].split(" ", 2)[0].equals(
				traits[Traits.HIGH_ABILITY.getID()].split(" ", 2)[0]))
		{
			traits[Traits.LOW_ABILITY.getID()] = 
					rsg.getRandomTrait(Traits.LOW_ABILITY.getID());
		}
	}
	
	
	public String toString()
	{
		StringBuilder strBld = new StringBuilder();
		strBld.append("||              Race: " + traits[Traits.RACE.getID()] + "\n");
		strBld.append("||            Gender: " + traits[Traits.GENDER.getID()] + "\n");
		strBld.append("||         Sexuality: " + traits[Traits.SEXUALITY.getID()] + "\n");
		strBld.append("||        Appearance: " + traits[Traits.APPEARANCE.getID()] + "\n");
		strBld.append("||      High Ability: " + traits[Traits.HIGH_ABILITY.getID()] + "\n");
		strBld.append("||       Low Ability: " + traits[Traits.LOW_ABILITY.getID()] + "\n");
		strBld.append("||            Talent: " + traits[Traits.TALENT.getID()] + "\n");
		strBld.append("||         Mannerism: " + traits[Traits.MANNERISM.getID()] + "\n");
		strBld.append("|| Interaction Trait: " + traits[Traits.INTERACTION_TRAIT.getID()] + "\n");
		strBld.append("||             Ideal: " + traits[Traits.IDEAL.getID()] + "\n");
		strBld.append("||              Bond: " + traits[Traits.BOND.getID()] + "\n");
		strBld.append("||    Flaw or Secret: " + traits[Traits.FLAW_OR_SECRET.getID()] + "\n");
		return strBld.toString();
	}
}
