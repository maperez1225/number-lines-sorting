import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

public class Main {
	public static int n;
	public static String[] lines;
	public static int iterations;
	public static int changes;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.valueOf(br.readLine());
		lines = new String[n];
		for (int i = 0; i < n; i++) {
			lines[i]=br.readLine();
		}
		br.close();
		bubbleSort();
	}
	public static void bubbleSort() {
		for (int i = 0; i < n; i++) {
			int numbers = 1;
			int index = 0;
			while (index != -1) {
				index = lines[i].indexOf(" ", index);
				numbers++;
			}
			double[] values = new double[numbers];
			for (int j = 0; j < numbers; j++) {
				index = 0;
				while (index != -1) {
					int prevIndex = index;
					index = lines[i].indexOf(" ", index);
					if (index != -1) {
						values[j] = Double.parseDouble(lines[i].substring(prevIndex, index));
					}
					else {
						values[j] = Double.parseDouble(lines[i].substring(prevIndex));
					}
				}
			}
		}
	}
}