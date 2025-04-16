package abstract_parctice;

public class Seongsik extends Jump implements Fly,Run,Sit {
	String name;
	
	
	

	@Override
	public void fSit() {
		System.out.println("앉기");
		
	}

	@Override
	public void fRun() {
		System.out.println("달리기");
		
	}

	@Override
	public void fFly() {
		System.out.println("날기");
		
	}
	

}
