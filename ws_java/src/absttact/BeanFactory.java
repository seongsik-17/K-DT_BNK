package absttact;

public class BeanFactory {

	TV sam = new SamsungTV();
	TV LG = new LgTV();

	public TV getBean(String tv) {
		if(tv.equals("samsung")) {
			return sam;
		}
		else if(tv.equals("lg")) {
			return LG;
		}
		else {
			return null;
		}

	}

}
