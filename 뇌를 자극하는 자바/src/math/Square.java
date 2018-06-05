package math;

public class Square extends Rectacgle {
	Square(int sideLength) {
		super(sideLength, sideLength);
	}

	int getSideLength() {
		return (getHeight() + getWidth()) * 2;
	}

}
