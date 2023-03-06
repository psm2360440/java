package db;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		DAO dao = new MariaDBDAO();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input  Command(q,i,d,u)");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("BYEBYE");
				break;
			}else if (cmd.equals("i")) {
				System.out.println("Input ID...");
				String id = sc.next();
				System.out.println("Input PWD...");
				String pwd = sc.next();
				System.out.println("Input NAME...");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pwd, name);
				dao.insert(user);
			}else if (cmd.equals("d")) {
				System.out.println("Input ID...");
				String id = sc.next();
				dao.delete(id);
			}else if (cmd.equals("u")) {
				System.out.println("Input ID...");
				String id = sc.next();
				System.out.println("Input PWD...");
				String pwd = sc.next();
				System.out.println("Input NAME...");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pwd, name);
				dao.update(user);
				
			}
		}
		sc.close();
	}

}
