public class Patient {

    //private variables with getter and setter methods
    private int patientID;
    private String patientName;
    private int age;
    private char patientSex;
    private	String DoctorType;
    private float amountForAppointment;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(char patientSex) {
        this.patientSex = patientSex;
    }

    public String getDoctorType() {
        return DoctorType;
    }

    public void setDoctorType(String DoctorType) {
        this.DoctorType = DoctorType;
    }

    public float getAmountForAppointment() {
        return amountForAppointment;
    }

    public void setAmountForAppointment(float amountForAppointment) {
        this.amountForAppointment = amountForAppointment;
    }

    //constructor to set the variables
    public Patient(int patientID, String patientName, int age, char patientSex, String DoctorType)
    {
        this.patientID=patientID;
        this.patientName=patientName;
        this.age=age;
        this.patientSex=patientSex;
        this.DoctorType=DoctorType;
        this.amountForAppointment=amountForAppointment;
    }
}
