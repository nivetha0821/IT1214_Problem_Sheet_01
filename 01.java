class Student{
	private int studentId;
	private String name;
	private int daysAttended;
	
	
	public Student(int studentId, String name, int daysAttended){
    this.studentId = studentId;
    this.name = name;
    this.daysAttended = daysAttended;
	}
	
	public int getStudentId(){
    return studentId;
	}
	
	public void setStudentId(int studentId){
    this.studentId = studentId;
	}
	
	public String getName(){
    return name;
	}
	
	public void setName(String name){
    this.name = name;
	}
	
	public int getDaysAttended(){
    return daysAttended;
	}
	
	public void setDaysAttended(int daysAttended){
    this.daysAttended = daysAttended;
	}

}


class Classroom{
	Student[] s1=new Student[10]; 
	int studentCount = 0;
	
	public void addStudent(Student student ){
    if (studentCount < 10){
        s1[studentCount] = student;
        studentCount++;
    } 
	else {
        System.out.println("Classroom full");
		}
	}
	
	public void updateAttendance(int studentId, int newDays){
    boolean found = false;
	for (int i = 0; i < studentCount; i++){
        if (s1[i].getStudentId() == studentId){
            s1[i].setDaysAttended(newDays);
            found = true;
		   }
		 }
		   if (!found){
			   System.out.println("Student ID  does not found.");
			   }
			}
	public void displayStudents(){
    for (int i = 0; i < studentCount; i++){
        System.out.println("ID: " + s1[i].getStudentId() +", Name: " + s1[i].getName() +", Days Attended: " + s1[i].getDaysAttended());
		}
	}
	
}

class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();

        
        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));
		classroom.updateAttendance(102, 16);
		classroom.updateAttendance(104, 20);
		classroom.displayStudents();
    }
}
