class Student{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;	
	
	boolean validateMarks(int marks){
			if(marks<=100 && marks>=0){
				return true;
				}
				else{
					return false;
					}
		}
		
	

    public Student(String name, int exam1, int exam2, int exam3)throws Exception{
		this.name = name;
        if (!validateMarks(exam1) || !validateMarks(exam2) || !validateMarks(exam3)) {
            throw new Exception("Exam scores must be between 0 and 100.");
        }
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
    }

    public String getName() {
        return name;
    }

    public int getExam1() {
        return exam1;
    }

    public int getExam2() {
        return exam2;
    }

    public int getExam3() {
        return exam3;
    }

    public double calculateAverage() {
        return (exam1 + exam2 + exam3) / 3.0;
    }
}
class Main{
	public static void main(String[] args){
		try{
			Student s1=new Student("John",75,110,90);
			double avg = s1.calculateAverage();
            System.out.printf("Student: "+ s1.getName()+", Average Score: "+ avg);
			}catch(Exception e){
				
				System.out.println("Exception is: "+e.getMessage());
			}	
		}
}