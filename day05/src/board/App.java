package board;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Service service = new Service();
		while (true) {
			System.out.println("Input cmd(r,u,d,g,q)");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("Bye");
				break;
			} else if (cmd.equals("r")) {
				System.out.println("Input Contents");
				String content = sc.next();
				service.register(content);

			} else if (cmd.equals("g")) {
				System.out.println("Input Number");
				int num = Integer.parseInt(sc.next());
				String result = service .get(num);
				System.out.println(result);
			} else if (cmd.equals("d")) {
				System.out.println("Input Number");
				int num = Integer.parseInt(sc.next());
				service.remove(num);
				System.out.printf("No.%d is removed \n", num);
			} else if (cmd.equals("u")) {
				System.out.println("Input Number");
				int num = Integer.parseInt(sc.next());
				System.out.println("Input modification");
				String modification = sc.next();
				service.modify(num, modification);
				System.out.printf("No.%d is modified/ Contents: %s \n", num, modification);
			}

		}
		sc.close();
	}
}
