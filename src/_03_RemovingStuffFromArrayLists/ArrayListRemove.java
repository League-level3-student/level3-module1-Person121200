package _03_RemovingStuffFromArrayLists;

import java.util.ArrayList;

public class ArrayListRemove {

	class Stuff {
		public String type;
	}

	class Worm extends Stuff {
		public Worm() {
			type = "worm";
		}
	}

	class Dirt extends Stuff {
		public Dirt() {
			type = "dirt";
		}

		// 1. Write a method that removes the dirt in the yard and returns the
		// ArrayList

		
	}
public static ArrayList<Stuff> cleanOutTheYard(ArrayList<Stuff> yard) {
			for (int i = yard.size()-1; i >= 0; i--) {
				if (yard.get(i).type.equals("dirt")) {
					yard.remove(i);
			}
			
			}
			return yard;

		}

public static ArrayList<Character> removeHashTags(ArrayList<Character> truth) {
	for(int i = truth.size()-1; i>=0; i--) {
		if(truth.get(i).equals('#')) {
			truth.remove(i);
		}
	}
		return truth;
}
}

