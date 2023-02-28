package oop3;

public class Car {		//속성
	private String name;
	private String color;
	private int size;
	private int fsize;
	private int cfsize;

	
	//생성자. (constructor)
	public Car() {
	}					//default 생성자

	public Car(String name, String color, int size, int fsize) {
		this.name = name;
		this.color = color;
		this.size = size;
		this.fsize = fsize;
	}

	public Car(String name, String color, int size, int fsize, int cfsize) {
		this(name, color, size, fsize);
		this.cfsize = cfsize;				
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", size=" + size + ", fsize=" + fsize + ", cfsize=" + cfsize
				+ "]";
	}
	
	//	기름을 넣는다.
	/*기름통 보다 많이 넣으면 - 다시 주유하세요
	 * 음수 값이 들어가면 - 다시 주유하세요
	 * */

	 public void setCfsize(double size) {
		 cfsize += size;
		 if(cfsize > fsize || cfsize <= 0) {
			 System.out.println("다시 주유하세요!");
		 }
	 }
	//	주행을 한다.
	//	1리터당 10km를 주행 할 수 있다.
	 public void go(int distance) {
		 double remainCfSize = 0.0;
		 System.out.printf("%s  Go ...", this.name);
		if(cfsize < 0) {
			 System.out.println("지금 당장 밥을 넣어라!");
			 return;
		 }else if (distance > (cfsize * 10)) {
			 int more = (distance - (cfsize*10))/10;
			 System.out.printf("가다가 설 것 같아요... 연료를 %dL 만큼 더 주세요", more);
			 return;
		 }else {
			 System.out.println("출바알!!!");
			 remainCfSize = cfsize - ((distance*1.0) / 10);
			 System.out.printf("%s는 주행 완료 후 %4.2fL만큼 기름이 남아용", this.name, remainCfSize );
		 }
	 }
	
	//	멈춘다.'
	  public void stop() {
		 System.out.printf("%s Stop ...", this.name);
//		 if(cfsize == 0) {
//			 System.out.println("밥 좀 주세요 네에...");
//		 }
	 }
	
}
