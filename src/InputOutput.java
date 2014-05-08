
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class InputOutput {

	public static void main(String[] args) {
		List<Integer> list = readFromFile("C:/temp/fileinput.txt");
		sortList(list);
		writeToFile("C:/temp/fileoutput.txt", list);

	}

	public static List<Integer> readFromFile(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			List<Integer> res = new ArrayList<Integer>();
			if (line != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					Integer integer = new Integer(token.trim());
					res.add(integer);
				}
			}
			reader.close();
			return res;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static List<Integer> sortList(List<Integer> list) {
		Collections.sort(list);
		return list;
	}

	public static void writeToFile(String fileName, List<Integer> list) {

		try {
			FileWriter f = new FileWriter(new File(fileName));
			f.write(list.toString());
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
