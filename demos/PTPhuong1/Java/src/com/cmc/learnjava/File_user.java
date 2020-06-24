package com.cmc.learnjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File_user {
	public List<String> Readfile() {
		File file_p = new File(
				"D:\\Automation_Test\\demos\\PTPhuong1\\Java\\account.txt");
		List<String> list_user = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(file_p);
			while (scanner.hasNext()) {
				String result = scanner.nextLine();
				result = result.trim();
				String[] user = result.split(",");
				if (user.length > 1) {
					for (int i = 0; i < user.length; i++) {
						user[i] = user[i].trim();
						list_user.add(user[i]);
					}
				} else {
					list_user.add(result);
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list_user.size(); i++) {
			System.out.println(list_user.get(i));
		}
		return list_user;
	}
}
