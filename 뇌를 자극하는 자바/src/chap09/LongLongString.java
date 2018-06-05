package chap09;

public class LongLongString {

	public static void main(String[] args) {

		StringBuilder stringBuilder = new StringBuilder();

		for (String str : args) {
			stringBuilder.append(str);
		}
		
		System.out.println(stringBuilder);

	}

}
