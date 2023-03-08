package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.MakeMessage;
import com.kbstar.frame.SearchService;
import com.kbstar.frame.Service;
import com.kbstar.service.ItemService;

public class App2 {

	public static void main(String[] args) {
		Service<Integer, ItemDTO> service = new ItemService(); // Service자체에 Search 메소드를 추가해서 사용할 때!
		SearchService search = new ItemService();
		// ItemService service = new ItemService(); //ItemService에 Search 메소드 추가해서 사용할
		// 때!
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input  Command(q,i,d,u,s)");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("BYEBYE");
				break;
			} else if (cmd.equals("i")) {
				System.out.println("Input ID...");
				int id = Integer.parseInt(sc.next());
				System.out.println("Input name...");
				String name = sc.next();
				System.out.println("Input price...");
				double price = Double.parseDouble(sc.next());
				System.out.println("Input Quantity...");
				int qt = Integer.parseInt(sc.next());
				ItemDTO item = new ItemDTO(id, name, price, qt);
				try {
					service.register(item);
				} catch (Exception e) {
					System.out.println(MakeMessage.makeMessage(e.getMessage()) + e.getMessage());
				}
			} else if (cmd.equals("d")) {
				System.out.println("Input ID...");
				try {
					int id = Integer.parseInt(sc.next());
					service.remove(id);
				} catch (Exception e) {
					System.out.println(MakeMessage.makeMessage(e.getMessage()) + e.getMessage());
				}
			} else if (cmd.equals("u")) {
				System.out.println("Input ID...");
				int id = Integer.parseInt(sc.next());
				System.out.println("Input name...");
				String name = sc.next();
				System.out.println("Input price...");
				double price = Double.parseDouble(sc.next());
				System.out.println("Input Quantity...");
				int qt = Integer.parseInt(sc.next());
				ItemDTO item = new ItemDTO(id, name, price, qt);
				try {
					service.modify(item);
				} catch (Exception e) {
					System.out.println(MakeMessage.makeMessage(e.getMessage()) + e.getMessage());
				}
			} else if (cmd.equals("s")) {
				search.search(); // SearchService Interface를 implements해서 사용할 때!
				// service.search // ItemService에만 search 메소드를 만들 경우 둘 사이의 강한 coupling... 다형성
				// 구현도 약화...
			}
		}
		sc.close();
	}
}
