package c06;

public enum Day2 {
	MONDAY("월요일", "MONDAY"), TUESDAY("화요일", "TUESDAY"), WENDSDAY("수요일", "WENDSDAY"), THURSDAY("목요일", "THURSDAY"),
	FRIDAY("금요일", "FRIDAY"), SATURDAY("토요일", "SATURDAY"), SUNDAY("일요일", "SUNDAY");

	private final String korean;
	private final String eng;

	Day2(String kor, String eng) {
		this.korean = kor;
		this.eng = eng;
	}

	public String getKorName() {
		return korean;
	}

	public String getEngName() {
		return eng;
	}
}