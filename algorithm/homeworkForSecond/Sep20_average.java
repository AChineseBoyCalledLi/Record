package homeworkForSecond;

public class Sep20_average {
	public static void main(String[] args) {
		double[] a = new double[] { 2, 3, 4, 2, -67, 21, -4, 0 };
		System.out.println(AverageIter(a));
		System.out.println(AverageRec(a, a.length));
	}

	public static double AverageIter(double[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum / a.length;
	}

	public static double AverageRec(double[] a, int n) {
		if (n == 1) {
			return a[0];
		}
		return (AverageRec(a, n - 1) * (n - 1) + a[n - 1]) / n;
	}

}