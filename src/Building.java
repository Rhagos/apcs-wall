
public class Building extends Entity{

	public Building(String image, int x, int y, int w, int h) {
		super(image, x, y, w, h);
	}
	public void damage(double dmg){
		setHP(getHP() - dmg);
	}
}
