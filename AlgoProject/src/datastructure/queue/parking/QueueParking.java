package datastructure.queue.parking;

import java.util.Scanner;

public class QueueParking {

	public static void main(String[] args) {
		parkingMenu();
	}
	
	public static void parkingMenu() {
		Scanner sc = new Scanner(System.in);
		MyQueue parking = new MyQueue(5);
		
	 MENU:while(true) {
			System.out.print("Select Menu : ");
			System.out.println("0. 주차여부 확인 1. 주차 2. 출차 3. 만차 4. 종료 ");
			String sel = sc.nextLine();
			
			switch(sel) {
			case "0" :
				System.out.println("주차한 차량의 고유값을 입력하세요 : ");
				char carChar = sc.nextLine().charAt(0);
				int num = parking.contains(Character.toLowerCase(carChar));
				if(num < 0) {
					System.out.println("입력하신 차량 정보는 주차 목록에 없습니다");
				}else {
					System.out.println("입력하신 차량은" + (num+1) + "번째 출차 가능합니다");
				}
				break;
			case "1" :
				System.out.println("주차를 진행합니다. 주차할 차량의 고유값을 입력하세요");
				char chr = sc.nextLine().charAt(0);		
				if(parking.contains(Character.toLowerCase(chr))==-1) {
					if(parking.enqueue(Character.toLowerCase(chr))) {
						System.out.println("주차 완료!");
					}else {
						System.out.println("주차 불가!");
					}
					
				}else {
					System.out.println("해당 차량은 이미 주차되어 있습니다");
				}
				break;
			case "2" :
				/*
				 * 0. 출차 고유 값 입력
				 * 1. 바로 출차 가능한지 확인
				 * 2. 출차 불가메시지 
				 * 	 2-1. 주차 시간 1시간 이상인지 여부
				 * 	 2-2. 1시간 미만 : 출차불가
				 *   2-3. 1시간 이상 : 출차 - 선행차량 dequeue 후 다시 enqueue가 모두완료되면
				 *   2-4. 출차 요구 차량 출차(2-3 완료되지 않을 시 출차 불가)
				 */
				System.out.println("출차를 진행합니다. 출차할 차량의 고유값을 입력하세요");
				char chr1 = sc.nextLine().charAt(0);	
				
				char parkChar = parking.peek();
				if(parkChar != 'E') {
					if(Character.toLowerCase(chr1) == parkChar) { //출차진행차량이 맨 앞에 있음
						System.out.println("출차를 진행합니다");
						parking.dequeue();
					}else {
						System.out.println("아직 출차할 수 없습니다 주차시간이 1시간이 지난경우 출차할 수 있습니다 주차시간을 입력하세요 "
								+ "1시간 미만이면 0을 입력하세요");
						int time = sc.nextInt();
						sc.nextLine();
						if(time >= 1) {//선행차량 이동 후 출차
							int num1 = parking.contains(Character.toLowerCase(chr1));
							if(num1 >= 0) {
								for(int i=1; i<=num1; i++) {
									if(parking.isFull()) {
										System.out.println("주차장에 이동 공간이 없어 선행 차량 이동이 불가능하여 미리 출차가 안됩니다 대기하세요");
										continue MENU;
									}else {
										char car = parking.dequeue();
										parking.enqueue(car);
									}
								}
								parking.dequeue();
								System.out.println("선행차량 이동 후 출차 완료 !");
							}else {
								System.out.println("해당 차량이 없습니다");
							}
						}else {
							parking.showQueue();
						}
					}
				} else {
					System.out.println("현재 주차장에 차량이 없습니다.");
				}
				break;
			case "3" :
				if(parking.isFull()) {
					System.out.println("만차! 주차불가");
				}else {
					System.out.println("주차가능");
				}
				break;
			case "4" :
				System.out.println("종료합니다");
				System.exit(0);
				break;
			default :
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
			}
			
		}
	}

}
