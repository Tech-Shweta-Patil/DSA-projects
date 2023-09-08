import java.util.LinkedList;
import java.util.Queue;

//private variables with getter and setter methods
public class Doctor {
    private int DoctorID;
   private String DoctorName;
   private int age;
   private char DoctorSex;
   private String DoctorSpeciality;
   Queue<Patient> p;                                                                            //queue of patients for every doctor

    public int getPatientcount() {
        return patientcount;
    }

    public void setPatientcount(int patientcount) {
        this.patientcount = patientcount;
    }

    private int patientcount;

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    private double amt;//checking fees

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int doctorID) {
        DoctorID = doctorID;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getDoctorSex() {
        return DoctorSex;
    }

    public void setDoctorSex(char doctorSex) {
        DoctorSex = doctorSex;
    }

    public String getDoctorSpeciality() {
        return DoctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        DoctorSpeciality = doctorSpeciality;
    }

   //constructor to set the variables
    public Doctor(int doctorID, String doctorName, int age, char doctorSex, String doctorSpeciality,double fees) {
        DoctorID = doctorID;
        DoctorName = doctorName;
        this.age = age;
        DoctorSex = doctorSex;
        DoctorSpeciality = doctorSpeciality;
        amt=fees;
        p=new LinkedList<>();
        patientcount=p.size();
    }
}
