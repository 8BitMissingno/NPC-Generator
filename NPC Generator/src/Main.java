import com.NPC;
import com.RandomTraitPicker;

public class Main 
{
	public static void main(String[] args)
	{
		String[] filePaths = {
				"src/text/appearances",
				"src/text/high_abilities",
				"src/text/low_abilities",
				"src/text/talents",
				"src/text/mannerisms",
				"src/text/interaction_traits",
				"src/text/ideals",
				"src/text/bonds",
				"src/text/flaws_and_secrets",
				"src/text/races",
				"src/text/genders",
				"src/text/sexualities"};
		
		RandomTraitPicker rsg = new RandomTraitPicker(filePaths);
		NPC npc = new NPC(rsg);
		System.out.print(npc.toString());
	}
}
