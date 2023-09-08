
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    LinkedList<Doctor> d;
    public Admin(){
        d=new LinkedList<>();                                                                                           //constructor to create list of doctors
    }

   public void doctorsInitialData(){                                                                                    //adding 5 doctors of different specialities to the list
        Doctor d1=new Doctor(1,"Dr.Kumarr",33,'m',"Surgeon",1000);
        d.add(d1);
        Doctor d2=new Doctor(2,"Dr.Kelkar",77,'m',"Physician",300);
        d.add(d2);
        Doctor d3=new Doctor(3,"Dr.Patill",28,'f',"Orthopedist",400);
        d.add(d3);
        Doctor d4=new Doctor(4,"Dr.Guptay",50,'m',"Dermatologist",500);
        d.add(d4);
        Doctor d5=new Doctor(5,"Dr.Shinde",36,'f',"Neurologist",1500);
        d.add(d5);
    }

    Scanner sc=new Scanner(System.in);
    //view doctor details
    public void viewDoctorsDetails(){
        System.out.println("Enter choice for details of  \n1-All doctors \n2-Specific Doctor");
        System.out.println("---------------------------------------------------------------------------------");
        switch (sc.nextInt()){
            case 1:{                                                                                                    //viewing all doctor's details
                System.out.println("--------------------------------Doctor Information-------------------------------");
                System.out.println("\nID\t\tDoctorName\t\tAge\t\tSex\t\tSpeciality");
                System.out.println("--------------------------------------------------------------------------------");
                for(int i=0;i<d.size();i++){
                    System.out.println(d.get(i).getDoctorID() + "\t\t"+d.get(i).getDoctorName()+"\t\t"+d.get(i).getAge()+"\t\t "+d.get(i).getDoctorSex()+"\t\t"+d.get(i).getDoctorSpeciality());
                }
                System.out.println("---------------------------------------------------------------------------------");
                break;
            }
            case 2:{
                System.out.println("Enter the id of the doctor whose details are to be displayed ");                      //accepting id of a doctor to display details of specific doctor
                int id=sc.nextInt();
                int i=searchDoctor(id);
                if(i>=0){
                    System.out.println("--------------------------------"+d.get(i).getDoctorName()+" Information----------------------------");
                    System.out.println("\nID\t\tDoctorName\t\tAge\t\tSex\t\tSpeciality");
                    System.out.println(d.get(i).getDoctorID() + "\t\t"+d.get(i).getDoctorName()+"\t\t"+d.get(i).getAge()+"\t\t "+d.get(i).getDoctorSex()+"\t\t"+d.get(i).getDoctorSpeciality());
                    System.out.println("---------------------------------------------------------------------------------");
                }else{
                    System.out.println("Doctor ID invalid");
                }
                break;
            }
        }
    }


    //adding doctor
    public void addDoctor(){
        do {
            System.out.println("Enter the Doctor details :- \n ");
            int i = d.get(d.size()-1).getDoctorID() + 1;                                                                //assigning new doctor id at end of the list
            System.out.println("Enter the Doctor Name  ");
            String name = sc.next();
            boolean flag=false;
            int age=24;
            while (!flag){
                try{
                    System.out.println("Enter the Doctor Age  ");
                    age = sc.nextInt();
                    if(age<23 || age>100){
                        throw new Exception();                                                                          //exception is thrown if age isn't appropriate
                    }
                    flag=true;
                }catch (Exception e){
                    System.out.println("Invalid age for this Role");                                                    //printing the exception
                }
            }

            System.out.println("Enter the Doctor Gender  ");
            char gender = sc.next().charAt(0);
            String DoctorType="";
            System.out.println("Enter the Doctor Speciality \n1-Surgeon\n2-Cardiologist\n3-Neurologist\n4-Physician\n5-Dermatologist ");            //asking for doctor speciality for adding doctor
            System.out.println("------------------------------------------------------------");
            switch (sc.nextInt()){
                case 1:
                    DoctorType="Surgeon";
                    break;
                case 2:
                    DoctorType="Cardiologist";
                    break;
                case 3:
                    DoctorType="Neurologist";
                    break;
                case 4:
                    DoctorType="Physician";
                    break;
                case 5:
                    DoctorType="Dermatologist";
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }
            System.out.println("Enter the Check-up fees of doctor");
            double fees=sc.nextDouble();
            Doctor doc = new Doctor(i, name, age, gender, DoctorType,fees);
            d.add(doc);
            System.out.println("Doctor Added Successfully");
            System.out.println("------------------------------------------------------------");
            System.out.println("Do you want to add more doctors, if yes press 1 ");
        }while(sc.nextInt()==1);
    }

    //remove doctor from hospital
    public void removeDoctor(){
        System.out.println("Enter the id of the doctor to be Deleted ");
        int id=sc.nextInt();
        int i=searchDoctor(id);                                                                             //searching doctor to be deleted by id
        if(i>=0) {
            d.remove(i);                                                                                    //removing doctor from list
            System.out.println("Doctor Successfully Deleted");
        }
        else
        {
            System.out.println("Invalid Doctor Id ");                                                       //doctor ID does not exist
        }
    }

    //search doctors by ID
    public int searchDoctor(int id){
        for(int i=0;i<d.size();i++){
            if(id==d.get(i).getDoctorID()){
                return i;
            }
        }
        return -1;                                                                                          //invalid Doctor ID
    }

    //seach doctor by speciality
    public LinkedList<Integer> searchdoctor(String s){
        LinkedList<Integer> docindex=new LinkedList<>();                                                    //List of doctor of a particular speciality
        for(int i=0;i<d.size();i++){
            if(Objects.equals(s, d.get(i).getDoctorSpeciality())){
                docindex.add(i);
            }
        }
        return docindex;                                                                                    //returning all available doctors of particular speciality
    }
}
