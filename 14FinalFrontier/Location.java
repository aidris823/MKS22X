public class Location{
    //Coordinates
    private int x, y;
    private Location previous;

    public Location (int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public void setX(int x){
	this.x = x;
    }
    public void setY(int y){
	this.y = y;
    }

}
