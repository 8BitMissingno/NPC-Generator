package enums;

public enum Traits 
{
	/*
	 * Checklist to adding a new Trait:
	 * - Include it in this enum
	 * - Include a file path in the index of the filePaths array that corresponds to the
	 * ID you gave it.
	 * - Add it to the toString() in NPC so the trait is actually displayed
	 */
	
	/**
	 * This character's physical appearance.
	 */
	APPEARANCE(0),
	/**
	 * This character's overall best ability.
	 */
	HIGH_ABILITY(1),
	/**
	 * This character's overall worst ability.
	 */
	LOW_ABILITY(2),
	/**
	 * Something this character can do that is special.
	 */
	TALENT(3),
	/**
	 * Something this character does that is memorable.
	 */
	MANNERISM(4),
	/**
	 * How the character will interact with the party.
	 */
	INTERACTION_TRAIT(5),
	/**
	 * This character's most important ideal.
	 */
	IDEAL(6),
	/**
	 * People, places, or things that are important to this character.
	 */
	BOND(7),
	/**
	 * A flaw or secret that this character holds close to them.
	 */
	FLAW_OR_SECRET(8),
	/**
	 * This character's race.
	 */
	RACE(9),
	/**
	 * This character's gender;
	 */
	GENDER(10),
	/**
	 * Who this person is attracted to.
	 */
	SEXUALITY(11);
	
	/**
	 * Index in the traits array of the NPC class that this info corresponds to.
	 */
	private int traitID;
	
	
	Traits(int traitID)
	{
		this.traitID = traitID;
	}
	
	
	/**
	 * @return Index in the traits array of the NPC class that this info corresponds to.
	 */
	public int getID()
	{
		return traitID;
	}
}
