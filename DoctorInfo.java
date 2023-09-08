import java.util.List;

public class DoctorInfo {
    //checking pending appointments of a particular doctor
    public void checkAppointment(Doctor d){
        System.out.println("----------------------------------------------------------------------------");

        if(d.p.isEmpty()){
            System.out.println("****No Appointments Are Present****");                                          //patient queue is empty
        }
        else{
            System.out.println("ID\t\tName\t\tAge\t\tSex");
            List<Patient> P2=d.p.stream().toList();                                                             //converting Queue of patients to linkedlist
            for(int j=0;j<P2.size();j++){
                System.out.println(P2.get(j).getPatientID()+"\t\t"+P2.get(j).getPatientName()+"\t\t"+P2.get(j).getAge()+"\t\t"+P2.get(j).getPatientSex()+"\t\t");   //printing all patient details
            }
        }
        System.out.println("----------------------------------------------------------------------------");

    }

    //deleting appointments of a particular doctor
    public void deleteAppointment(Doctor d){
        if(d.p.isEmpty()){
            System.out.println("****No Appointments were Present****");                                         //patient queue is empty
        }
        else{
            d.p.remove();                                                                                       //removing the first patient from queue
            System.out.println("Patient removed Successfully");                                             
        }
    }

}
