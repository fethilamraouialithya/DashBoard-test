package com.alithya.expedia.runner;

import java.util.Scanner;

public class CommandReader {
	
	public static void main(String[] args) {
		String command;
		boolean loop = true;
		DashBoardInputControl dashBoardInputControl = new DashBoardInputControl();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Scoring dashBoard!!");
		
		while(loop) {
			try {
				command = keyboard.nextLine();
				if("exit".equalsIgnoreCase(command)){
					loop = false;
					keyboard.close();
				}else {
					dashBoardInputControl.performAction(command);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
