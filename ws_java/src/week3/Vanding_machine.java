package week3;

import java.util.Scanner;

public class Vanding_machine {
	static Scanner sc = new Scanner(System.in);

	static void give() {// 물건 주는 함수
		System.out.println("상품 구매가 완료되었습니다");
	}

	static void exchange(int price) {// 가격을 받아와서 거스름돈을 계산하는 함수
		if (price == 0) {
			System.out.println("남은 금액이 없습니다");
			give();

		} else if (price >= 800) {
			System.out.print("물건을 추가로 구매하시겠습니까? 1. 예 2. 아니오 >> ");
			int yn = sc.nextInt();
			if (yn == 1) {
				buy(price);
			} else {
				System.out.println(price + "원을 반환합니다");
				give();
			}

		} else {
			System.out.println(price + "원을 반환합니다");
			give();
		}

	}

	static int buy(int price) { // 구매함수
		if (price >= 1000) {
			System.out.println("----------------------");
			System.out.println("1.콜라\t2.사이다\t3.환타");
			System.out.println("1000원\t800원\t900원");
			System.out.println("----------------------");
		} else if (price >= 900) {
			System.out.println("----------------------");
			System.out.println("2.사이다\t3.환타");
			System.out.println("800원\t900원");
			System.out.println("----------------------");
		} else {
			System.out.println("----------------------");
			System.out.println("2.사이다");
			System.out.println("800원");
			System.out.println("----------------------");
		}

		System.out.println("상품을 선택해주세요");
		int item = sc.nextInt();

		if (item == 2) {
			if (price >= 800) {
				exchange(price - 800);
			}
		} else if (item == 1) {
			if (price >= 1000) {
				exchange(price - 1000);
			} else {
				while (true) {
					if (1000 > price) {
						System.out.println((1000 - price) + "만큼 부족합니다. 추가로 넣어주세요");
						price += input();
					} else {
						buy(price);
						break;
					}

				}
			}

		} else {
			if (price > 900) {
				exchange(price - 900);
			} else {
				while (true) {
					if (900 > price) {
						System.out.println((900 - price) + "만큼 부족합니다. 추가로 넣어주세요");
						price += input();
					} else {
						buy(price);
						break;
					}

				}
			}

		}

		return 0;
	}

	static int input() {// 금액 투입 함수

		System.out.print("금액을 입력해주세요>> ");
		int a = sc.nextInt();
		System.out.println("투입된 금액:" + a);
		while (true) {
			if (a < 800) {
				System.out.println("투입된 금액이 " + (800 - a) + "원 만큼 모자랍니다.");
				System.out.print("추가로 투입해주세요 >> ");
				int pls_input = sc.nextInt();
				a += pls_input;
			} else {
				return a;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("----------------------");
		System.out.println("1.콜라\t2.사이다\t3.환타");
		System.out.println("1000원\t800원\t900원");
		System.out.println("----------------------");
		buy(input());

	}

}
