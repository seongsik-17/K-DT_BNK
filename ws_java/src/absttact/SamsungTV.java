package absttact;

public class SamsungTV implements TV {
	public void powerON() {
		System.out.println("SamsungTV 전원을 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV 전원을 끈다.");
	}

	public void volumeUp() {
		System.out.println("SamsungTV 볼륨을 올린다.");
	}

	public void volumeDown() {
		System.out.println("SamsungTV 볼륨을 내린다.");
	}

}
