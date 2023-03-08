package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MakeMessage;
import com.kbstar.frame.Service;
import com.kbstar.service.UserService;

public class App {

	public static void main(String[] args) {
		Service<String, UserDTO> service = new UserService();
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
				try {
					service.register(user);
				} catch (Exception e) {
					System.out.println(MakeMessage.makeMessage(e.getMessage()) + e.getMessage());
				}
			}else if (cmd.equals("d")) {
				System.out.println("Input ID...");
				String id = sc.next();
				try {
					service.remove(id);
				} catch (Exception e) {
					System.out.println(MakeMessage.makeMessage(e.getMessage()) + e.getMessage());
				}
			}else if (cmd.equals("u")) {
				System.out.println("Input ID...");
				String id = sc.next();
				System.out.println("Input PWD...");
				String pwd = sc.next();
				System.out.println("Input NAME...");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pwd, name);
				try {
					service.modify(user);
				} catch (Exception e) {
					System.out.println(MakeMessage.makeMessage(e.getMessage()) + e.getMessage());
				}
			}
		}
		sc.close();
	}

}
