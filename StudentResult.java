package crtjava;
class Student1
{
	String name;
	String course;
	int fee;
	public int maths;
	public int science;
	public int english;
	public Student1(String name, String course, int fee, int maths, int science, int english) {
		super();
		this.name = name;
		this.course = course;
		this.fee = fee;
		this.maths = maths;
		this.science = science;
		this.english = english;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", course=" + course + ", fee=" + fee + ", maths=" + maths + ", science="
				+ science + ", english=" + english + "]";
	}
	
}
public class StudentResult {
	
	static Student1[] students= new Student1[10];
	static int Fee_Max = 75000;
	
static void prepareStudentData() {
		
		String[] courseNames = {"IT","CSE","CIVIL","Mechanical"};
		
		
		for(int i=0;i<=9;i++) {
			int max=100,min=0,feeMax=75000,feeMin=5000;
			String course =  	courseNames[(int)(Math.random() * (3 - 0 + 1) +min)];
			int fee = (int)(Math.random() * (feeMax - feeMin + 1) + min); 
			int maths = (int)(Math.random() * (max - min + 1) + min); 
			int science = (int)(Math.random() * (max - min + 1) + min); 
			int english = (int)(Math.random() * (max - min + 1) + min); 
			
			students[i]= new Student1("students"+(i+1),course,fee,maths,science,english);
			
		System.out.println(students[i]);	
		}
}


	public static void main(String[] args) {
		prepareStudentData();
		System.out.println("Total Due Amount.....");
		processFee(Fee_Max);
		System.out.println("Total Due Amount.....");
		int amt =10000;
		System.out.println("Student Paid Less than "+amt+ "List");
		
		processFee(10000);
		processFeeForfail("fail");
		
		processFeeForPass("Pass");
		fail("maths","science","english");
	}
	private static void processFeeForPass(String presult) {
		
		long dueAmount =0;
		
		for(int i=0;i<students.length;i++) {
			if(students[i].fee < Fee_Max) {
				if ( (students[i].maths > 35)&& (students[i].science > 35)&& (students[i].english > 35)) {
					dueAmount = dueAmount + students[i].fee;
					System.out.println(students[i]);
				}//if
			}// if
		}// loop
		
		System.out.println("total due Amount For"+presult+" --->"+dueAmount);
	}
	
private static void processFeeForfail(String fresult) {
		
		long dueAmount =0;
		
		for(int i=0;i<students.length;i++) {
			if(students[i].fee < Fee_Max) {
				if ( (students[i].maths < 35)
					|| (students[i].science < 35)
					|| (students[i].english < 35)
					) {
					dueAmount = dueAmount + students[i].fee;
					System.out.println(students[i]);
				}//if
			}// if
		}// loop
		
		System.out.println("total due Amount For"+fresult+" --->"+dueAmount);
	} 

private static void fail(String math,String science ,String english) {
	

	for(int i=0;i<students.length;i++) {
			if ( (students[i].maths < 35))
				{
				System.out.println("maths failed students list");
				System.out.println(students[i]);
			}//if
			if((students[i].science < 35)) {
				System.out.println("science failed students list");
				System.out.println(students[i]);
			}// if
			if((students[i].english < 35)) {
				System.out.println("english failed students list");
				System.out.println(students[i]);
			}// if
	}// loop
	
	
}
	private static void processFee(int amt) {
			
			long dueAmount =0;
			
			for(int i=0;i<students.length;i++) {
				if(students[i].fee < amt) {
					if(amt != Fee_Max) {
						System.out.println(students[i]);
					}
					dueAmount = dueAmount + students[i].fee;
				}//if
			}// loop
			
			System.out.println("total due Amount--->"+dueAmount);

}
}
