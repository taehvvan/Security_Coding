// 클래스 재활용을 위한 상속

class Point2D {
	private int x;
	private int y;
	
	// 전달인자가 없는 기본생성자가 생략됨
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}	
}

class Point3D extends Point2D {
	private int z;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	
}

public class ExtendTest02 {

	public static void main(String[] args) {
		
		Point3D pt = new Point3D();
		pt.setX(10);	// 부모로부터 상속받아서 사용
		pt.setY(20);	// 부모로부터 상속받아서 사용
		pt.setZ(30);
		
		System.out.println("x 좌표값 : " + pt.getX());	// 상속받아서 사용
		System.out.println("y 좌표값 : " + pt.getY());	// 상속받아서 사용
		System.out.println("z 좌표값 : " + pt.getZ());

	}

}
