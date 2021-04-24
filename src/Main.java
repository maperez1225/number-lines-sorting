import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Main {
	public static int n;
	public static String[] lines;
	public static DecimalFormat df = new DecimalFormat("###.0#");
	public static void main(String[] args) throws IOException{
		df.setRoundingMode(RoundingMode.DOWN);
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.valueOf(br.readLine());
		lines = new String[n];
		for (int i = 0; i < n; i++) {
			lines[i] = br.readLine();
		}
		br.close();
		bubbleSort();
		for (int i = 0; i < n; i++) {
			bw.write(lines[i]);
			bw.newLine();
		}
		bw.close();
	}
	public static void bubbleSort() {
		for (int i = 0; i < n; i++) {
			String[] split = lines[i].split(" ");
			double[] values = new double[split.length];
			for (int j = 0; j < values.length; j++) {
				values[j] = Double.valueOf(split[j]);
			}
			int iterations = 0;
			int changes = 0;
			for (int j = 1; j < values.length; j++) {
				iterations++;
				for (int k = 0; k < values.length - j; k++) {
					if (values[k] > values[k+1]) {
						double temp = values[k];
						values[k] = values[k+1];
						values[k+1] = temp;
						changes++;
					}
				}
			}
			
			lines[i] = df.format((double)changes/(double)iterations)+"-"+values[0];
			for (int j = 1; j < values.length; j++) {
				lines[i] += " "+values[j];
			}
		}
	}
}