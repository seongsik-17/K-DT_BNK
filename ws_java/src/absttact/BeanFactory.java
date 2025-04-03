package absttact;

public class BeanFactory {

	TV sam = new SamsungTV();
	TV LG = new LgTV();

	public TV getBean(int num) {
		if (num == 1) {
			return sam;
		} else if (num == 2) {
			return LG;
		} else {
			return null;
		}

	}

}
