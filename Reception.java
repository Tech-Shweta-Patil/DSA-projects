import java.time.*;
import java.time.format.DateTimeFormatter;                                          //package to display time of registration of patient
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Reception
{
    Scanner sc=new Scanner(System.in);
    int patientID=100;

    public void patientInitialData(Admin a){                                       //adding 6 patients of to patient queue of each doctor
        Patient p2=new Patient(patientID++,"Shweta",23,'f',"Surgeon");
        a.d.get(0).p.add(p2);
        Patient p1=new Patient(patientID++,"Vidhii",19,'f',"Physician");
        a.d.get(1).p.add(p1);
        Patient p3=new Patient(patientID++,"Shreya",43,'f',"Orthopedist");
        a.d.get(2).p.add(p3);
        Patient p4=new Patient(patientID++,"Aditya",69,'m',"Dermatologist");
        a.d.get(3).p.add(p4);
        Patient p5=new Patient(patientID++,"Snehal",14,'f',"Neurologist");
        a.d.get(4).p.add(p5);
        Patient p6=new Patient(patientID++,"Yashwi",10,'f',"Physician");
        a.d.get(1).p.add(p6);
    }
    public void registerPatient(Admin a1)
    {
        do{
            System.out.println("Enter Patient name:");
            String pname=sc.next();
            boolean flag=false;
            int age=0;
            while (!flag){
                try{                                                                //exception is thrown if age isn't appropriate
                    System.out.println("Enter the Patient Age  ");
                    age = sc.nextInt();
                    if(age<0 || age>100){
                        throw new Exception();
                    }
                    flag=true;
                }catch (Exception e){
                    System.out.println("INVALID AGE");                               //printing the exception
                }
            }
            System.out.println("Enter Patient Gender:");
            char patientGender=sc.next().charAt(0);
            String DoctorType = "";
            System.out.println("Choose the doctor type:");                           //asking for doctor type for adding patient 
            System.out.println("1:Surgeon");
            System.out.println("2:Physician");
            System.out.println("3:Orthopedist");
            System.out.println("4:Dermatologist");
            System.out.println("5:Neurologist");
            int ch=sc.nextInt();
            switch (ch) {
                case 1:
                    DoctorType="Surgeon";
                    break;
                case 2:
                    DoctorType="Physician";
                    break;
                case 3:
                    DoctorType="Orthopedist";
                    break;
                case 4:
                    DoctorType="Dermatologist";
                    break;
                case 5:
                    DoctorType="Neurologist";
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    DoctorType=null;
                    break;
            }
            Patient p1=new Patient(patientID++,pname,age,patientGender,DoctorType);                     //passing the values to constructor

            LinkedList<Integer> doctorspecilist =a1.searchdoctor(p1.getDoctorType());                   //list of all doctors of a particular speciality
            int i=0;
            if(doctorspecilist.size()>0){
                for(i=0;i<doctorspecilist.size();i++){
                    a1.d.get(doctorspecilist.get(i)).setPatientcount(a1.d.get(doctorspecilist.get(i)).p.size());
                    if(a1.d.get(doctorspecilist.get(i)).getPatientcount()<3){                           //if pending appointments of a particular doctor is less than 3, only then the patient is added to the queue of that doctor
                        a1.d.get(doctorspecilist.get(i)).p.add(p1);
                        break;
                    }
                }
                System.out.println("Ask patient to pay Appointment fees: "+a1.d.get(doctorspecilist.get(i)).getAmt());
                LocalDateTime myDate=LocalDateTime.now();                                              //creating object to get the time of appointment registration
                DateTimeFormatter myformatobj=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String fdat=myDate.format(myformatobj);
                System.out.println("Registration Completed Successfully on ***** "+fdat+" *****");
                System.out.println("------------------------------------------------------------------------------");
            }
            else{
                System.out.println("Doctor Not available!!");                                           
            }
            System.out.println("do you want to continue adding patients in the list press 1");
        }while (sc.nextInt()==1);
    }
    public void showappointmentDetails(Admin a1)
    {
        System.out.println("Enter choice for appointment Details of  \n1-All doctors \n2-Specific Doctor");
        System.out.println("----------------------------------------------------------------------------");
        switch (sc.nextInt()){
            case 1:{                                                                            //viewing patient queue of all doctors
                System.out.println("----------------------------------------------------------------------------");
                for(int i=0;i<a1.d.size();i++){
                    System.out.println("Patient details of  : "+a1.d.get(i).getDoctorName());
                    if(a1.d.get(i).p.isEmpty()){
                        System.out.println("****No Appointments Scheduled for today****");
                    }
                    else{
                        System.out.println("ID\t\tName\t\tAge\t\tSex");
                        List<Patient> P2=a1.d.get(i).p.stream().toList();
                        for(int j=0;j<P2.size();j++){
                            System.out.println(P2.get(j).getPatientID()+"\t\t"+P2.get(j).getPatientName()+"\t\t"+P2.get(j).getAge()+"\t\t"+P2.get(j).getPatientSex()+"\t\t");
                        }
                    }
                    System.out.println("----------------------------------------------------------------------------");
                }
                break;
            }
            case 2:{                                                                          //viewing patient queue of a particular doctor
                System.out.println("Enter the id of the doctor whose appointment details are to be displayed ");
                int id=sc.nextInt();
                int i=a1.searchDoctor(id);
                if(i>=0){
                    if(a1.d.get(i).p.isEmpty()){
                        System.out.println("****No Appointments Scheduled for today****");
                    }
                    else{
                        System.out.println("-----------------------------"+a1.d.get(i).getDoctorName()+" Appointments-------------------------");
                        System.out.println("ID\t\tName\t\tAge\t\tSex");
                        List<Patient> P2=a1.d.get(i).p.stream().toList();
                        for(int j=0;j<P2.size();j++){
                            System.out.println(P2.get(j).getPatientID()+"\t\t"+P2.get(j).getPatientName()+"\t\t"+P2.get(j).getAge()+"\t\t"+P2.get(j).getPatientSex()+"\t\t");
                        } System.out.println("----------------------------------------------------------------------");
                    }
                }else{
                    System.out.println("Doctor ID invalid");
                }
                break;
            }
        }
    }
}

