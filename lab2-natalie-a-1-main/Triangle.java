
public class Triangle {
	
	private double sideA;
	private double sideB;
	private double sideC;
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1;
	
	public double getSideA() {
		return sideA;
	}

	public boolean setSideA(double sideA) {
		boolean is_Tri = false;
		if (isTriangle(sideA, sideB, sideC) == true) {
			this.sideA = sideA;
			is_Tri = true;
		}
		return is_Tri;
	}

	public double getSideB() {
		return sideB;
	}

	public boolean setSideB(double sideB) {
		boolean is_Tri = false;
		if (isTriangle(sideA, sideB, sideC) == true) {
			this.sideB = sideB;
			is_Tri = true;
		}
		return is_Tri;
	}

	public double getSideC() {
		return sideC;
	}

	public boolean setSideC(double sideC) {
		boolean is_Tri = false;
		if (isTriangle(sideA, sideB, sideC) == true) {
			this.sideC = sideC;
			is_Tri = true;
		}
		return is_Tri;
	}
	
	public boolean setSides(double[] sides) {
		boolean is_Tri = false;
		if (isTriangle(sides) == true) {
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
			is_Tri = true;
		}
		return is_Tri;
	}
	
	public double[] getSides() {
		double[] sides = {sideA, sideB, sideC};
		return sides;
	}
	
	public double[] getAngles() {
		double [] angles = {getAngleA(), getAngleB(), getAngleC()};
		return angles;
	}
	
	public double getAngleA() {
		return lawOfCosines(sideC, sideB, sideA);
	}
	
	public double getAngleB() {
		return lawOfCosines(sideA, sideC, sideB);
	}
	
	public double getAngleC() {
		return lawOfCosines(sideA, sideB, sideC);
	}
	public Triangle() {
		this.sideA = this.sideB = this.sideC = DEFAULT_SIDE;
	}
	
	public Triangle(double a, double b, double c) {
		if (isTriangle(a, b, c) == true) {
			this.sideA = a;
			this.sideB = b;
			this.sideC = c;
		} else {
			sideA = sideB = sideC = DEFAULT_SIDE;

		}
	}
	
	public Triangle(double[] sides) {
		if (isTriangle(sides) == false) {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		} else {
			sideA = sides[0];
			sideB = sides[1];
			sideC = sides[2];
		}
	}
	
	public Triangle(Triangle triangle) {
		if (triangle == null) {
			sideA = sideB = sideC = DEFAULT_SIDE;
		} else {
			this.sideA = triangle.getSideA();
			this.sideB = triangle.getSideB();
			this.sideC = triangle.getSideC();
		}
	}
	
	public static boolean isTriangle(double a, double b, double c) {
		boolean is_Tri = false;
		if (a + b > c && a + c > b && b + c > a) {
			is_Tri = true;
		}
		
		double[] temp = new double[3];
		temp[0] = a;
		temp[1] = b;
		temp[2] = c;
		
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] <= 0) {
				is_Tri = false;
			}
		}
		return is_Tri;
	}
	
	public static boolean isTriangle(double[] sides) {
		boolean is_Tri = false;
		if (sides == null || sides.length < 3 || sides.length > 3) {
			is_Tri = false; 
		} else if (isTriangle(sides[0], sides[1], sides[2])) {
			is_Tri = true;
		}
	return is_Tri;
}
	
	public static double lawOfCosines(double a, double b, double c) {
		double newV = (((a * a) + (b * b) - (c * c)) / (2 * a * b));
		double beta = Math.acos(newV);
		double degrees = ((beta * 180)/Math.PI);
		return degrees;
	}
	@Override
	public String toString() {
		return POLYGONSHAPE + "(" + String.format("%.2f", sideA) + ", " + String.format("%.2f", sideB)  + ", " + String.format("%.2f", sideC)  + ")";
	}

}
