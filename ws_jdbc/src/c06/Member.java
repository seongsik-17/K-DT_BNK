package c06;

import lombok.Data;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
public class Member {
	private int mno;
	private String name;
	private String phone;
/**
	@Override//아주 중요함
	public boolean equals(Object obj) {
		
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass() )return false;	
		Member target = (Member)obj;
		
		
		return mno == target.mno && name.equals(target.name) && phone.equals(target.phone);
		
		
	}//중복된 데이터는 받지 않는다. Hash Set
	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(mno,name,phone);
	}
*/
	
	
}
