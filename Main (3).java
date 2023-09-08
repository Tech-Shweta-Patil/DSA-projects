/*
Name:Sonakshi Goyal
Roll no:2453
C No.:C22020221454
*/

/*
Problem Statement: To implement Hospital Management System.
Brief description:
DATA STRUCTURES USED-Queue and LinkedList
There are three views-admin,reception and doctor. All these views are password protected. People with specific roles can login and perform the desired operations
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Admin a=new Admin();
        a.doctorsInitialData();
        DoctorInfo di=new DoctorInfo();
        Reception r=new Reception();
        r.patientInitialData(a);
        System.out.println("-------------------------------------------------------------");
        System.out.println("_________________WELCOME TO CITY HOSPITAL____________________");
        System.out.println("-------------------------------------------------------------");
        do{
            System.out.println("WHO ARE YOU ? \n1-ADMIN \n2-RECEPTIONIST \n3-DOCTOR");
            switch (sc.nextInt()){
                case 1:{
                    do{
                        System.out.println("-----------------------------ADMIN----------------------------");
                        System.out.println("Enter the Password : ");
                        String pass=sc.next();
                        if(pass.equals("admin")){                                                                           //checking if the password is correct
                            System.out.println("You have logged in successfully ");                                         //password entered is correct
                            do{
                                System.out.println("Enter your choice \n1-Add Doctor\n2-View Doctor\n3-Remove Doctor");
                                switch (sc.nextInt()){
                                    case 1:{
                                        a.addDoctor();                                                                      //calling add doctor method from class admin
                                        break;
                                    }
                                    case 2:{
                                        a.viewDoctorsDetails();                                                            //calling view doctor details() method from class admin
                                        break;
                                    }
                                    case 3:{
                                        a.removeDoctor();                                                                  //calling remove doctor method of class admin
                                        break;
                                    }
                                }
                                System.out.println("Do you want to continue as a admin, if yes press 1");
                            }while (sc.nextInt()==1);
                        }
                        else{
                            System.out.println("The Password Entered is Incorrect! Please try again");                     //password entered is incorrect,so admin can't access the methods
                        }
                        System.out.println("Do you want to login again as a admin, if yes press 1");
                    }while (sc.nextInt()==1);
                    break;
                }
                case 2:{
                    do{
                        System.out.println("------------------------------RECEPTION----------------------");
                        System.out.println("Enter the Password : ");
                        String pass=sc.next();
                        if(pass.equals("reception")){                                                                       //checking if the password is correct
                            System.out.println("You have logged in successfully");                                          //password entered is correct
                            do{
                                System.out.println("Enter your choice \n1-Register Patient\n2-Show Appointment Details");
                                switch (sc.nextInt()){
                                    case 1:{
                                        r.registerPatient(a);                                                               //calling register patient() method of class reception
                                        break;
                                    }
                                    case 2:{
                                        r.showappointmentDetails(a);                                                        //calling show appointment() method of class reception
                                        break;
                                    }
                                }
                                System.out.println("Do you want to continue as a receptionist, if yes press 1");
                            }while (sc.nextInt()==1);
                        }
                        else{
                            System.out.println("The password entered is incorrect! Please try again");                      //password entered is incorrect,so receptionist can't access the methods
                        }
                        System.out.println("Do you want to login again as a receptionist, if yes press 1");
                    }while (sc.nextInt()==1);
                    break;
                }
                case 3:{
                    do{
                        System.out.println("-----------------------------DOCTOR----------------------------");
                        System.out.println("Enter your Doctor ID :");                                                       //doctor specific login
                        int id=sc.nextInt();
                        int index=a.searchDoctor(id);
                        if(index>=0){
                            System.out.println("Enter the Password : ");
                            String pass=sc.next();
                            if(pass.equals("doctor")){                                                                      //checking if the password is correct
                                System.out.println("You have logged in successfully ");                                     //password entered is correct
                                do{
                                    System.out.println("Enter your choice \n1-Check Appointment\n2-Delete Appointement");
                                    switch (sc.nextInt()){
                                        case 1:{
                                            di.checkAppointment(a.d.get(index));                                            //calling checkAppointment() method of doctorInfo class
                                            break;
                                        }
                                        case 2:{
                                            di.deleteAppointment(a.d.get(index));                                           //calling deleteAppointment() method of doctorInfo class
                                            break;
                                        }
                                    }
                                    System.out.println("Do you want to continue as a doctor, if yes press 1");
                                }while (sc.nextInt()==1);
                            }
                            else{
                                System.out.println("The Password Entered is Incorrect! Please try again");                  //password entered is incorrect,so doctor can't access the methods
                            }
                        }
                        else{
                            System.out.println("Doctor ID invalid");                                                       //if doctorID is not correct
                        }

                        System.out.println("Do you want to login again as a doctor, if yes press 1");
                    }while (sc.nextInt()==1);
                    break;
                }
            }   
            System.out.println("Do you want to Login again in another role, if yes press 1");
        }while (sc.nextInt()==1);

        System.out.println("-----------------------------------THANK YOU----------------------------------");
    }
}

//OUTPUT:
/*
-------------------------------------------------------------
_________________WELCOME TO CITY HOSPITAL____________________
-------------------------------------------------------------
WHO ARE YOU ?
1-ADMIN
2-RECEPTIONIST
3-DOCTOR
1
-----------------------------ADMIN----------------------------
Enter the Password :
admi
The Password Entered is Incorrect! Please try again  
Do you want to login again as a admin, if yes press 1
1 
-----------------------------ADMIN----------------------------
Enter the Password :
admin
You have logged in successfully 
Enter your choice
1-Add Doctor
2-View Doctor
3-Remove Doctor
2
Enter choice for details of
1-All doctors
2-Specific Doctor
---------------------------------------------------------------------------------
1
--------------------------------Doctor Information------------------------------- 

ID              DoctorName              Age             Sex             Speciality
--------------------------------------------------------------------------------  
1               Dr.Kumarr               33               m              Surgeon
2               Dr.Kelkar               77               m              Physician    
3               Dr.Patill               28               f              Orthopedist  
4               Dr.Guptay               50               m              Dermatologist
5               Dr.Shinde               36               f              Neurologist  
---------------------------------------------------------------------------------    
Do you want to continue as a admin, if yes press 1
1
Enter your choice 
1-Add Doctor
2-View Doctor
3-Remove Doctor
2
Enter choice for details of  
1-All doctors
2-Specific Doctor
---------------------------------------------------------------------------------
2
Enter the id of the doctor whose details are to be displayed 
4
--------------------------------Dr.Guptay Information----------------------------

ID              DoctorName              Age             Sex             Speciality
4               Dr.Guptay               50               m              Dermatologist
---------------------------------------------------------------------------------
Do you want to continue as a admin, if yes press 1
1
Enter your choice 
1-Add Doctor
2-View Doctor
3-Remove Doctor
1
Enter the Doctor details :- 

Enter the Doctor Name
Dr.Ruchaa
Enter the Doctor Age  
67
Enter the Doctor Gender  
f
Enter the Doctor Speciality 
1-Surgeon
2-Cardiologist
3-Neurologist
4-Physician
5-Dermatologist
------------------------------------------------------------
4
Enter the Check-up fees of doctor
500
Doctor Added Successfully
------------------------------------------------------------
Do you want to add more doctors, if yes press 1
0
Do you want to continue as a admin, if yes press 1
1
Enter your choice 
1-Add Doctor
2-View Doctor
3-Remove Doctor
2
Enter choice for details of  
1-All doctors
2-Specific Doctor
---------------------------------------------------------------------------------
1
--------------------------------Doctor Information-------------------------------

ID              DoctorName              Age             Sex             Speciality
--------------------------------------------------------------------------------
1               Dr.Kumarr               33               m              Surgeon
2               Dr.Kelkar               77               m              Physician
3               Dr.Patill               28               f              Orthopedist
4               Dr.Guptay               50               m              Dermatologist
5               Dr.Shinde               36               f              Neurologist
6               Dr.Ruchaa               67               f              Physician
---------------------------------------------------------------------------------
Do you want to continue as a admin, if yes press 1
1
Enter your choice 
1-Add Doctor
2-View Doctor
3-Remove Doctor
3
Enter the id of the doctor to be Deleted 
4
Doctor Successfully Deleted
Do you want to continue as a admin, if yes press 1
1
Enter your choice 
1-Add Doctor
2-View Doctor
3-Remove Doctor
2
Enter choice for details of  
1-All doctors
2-Specific Doctor
---------------------------------------------------------------------------------
1
--------------------------------Doctor Information-------------------------------

ID              DoctorName              Age             Sex             Speciality
--------------------------------------------------------------------------------
1               Dr.Kumarr               33               m              Surgeon
2               Dr.Kelkar               77               m              Physician
3               Dr.Patill               28               f              Orthopedist
5               Dr.Shinde               36               f              Neurologist
6               Dr.Ruchaa               67               f              Physician
---------------------------------------------------------------------------------
Do you want to continue as a admin, if yes press 1
1
Enter your choice 
1-Add Doctor
2-View Doctor
3-Remove Doctor
2
Enter choice for details of  
1-All doctors
2-Specific Doctor
---------------------------------------------------------------------------------
2
Enter the id of the doctor whose details are to be displayed 
4
Doctor ID invalid
Do you want to continue as a admin, if yes press 1
0
Do you want to login again as a admin, if yes press 1
0
Do you want to Login again in another role, if yes press 1
1
WHO ARE YOU ? 
1-ADMIN
2-RECEPTIONIST
3-DOCTOR
2
------------------------------RECEPTION----------------------
Enter the Password :
reception
You have logged in successfully
Enter your choice
1-Register Patient
2-Show Appointment Details
2
Enter choice for appointment Details of  
1-All doctors
2-Specific Doctor
----------------------------------------------------------------------------
1
----------------------------------------------------------------------------
Patient details of  : Dr.Kumarr
ID              Name            Age             Sex
100             Shweta          23              f
----------------------------------------------------------------------------
Patient details of  : Dr.Kelkar
ID              Name            Age             Sex
101             Vidhii          19              f
105             Yashwi          10              f
----------------------------------------------------------------------------
Patient details of  : Dr.Patill
ID              Name            Age             Sex
102             Shreya          43              f
----------------------------------------------------------------------------
Patient details of  : Dr.Shinde
ID              Name            Age             Sex
104             Snehal          14              f
----------------------------------------------------------------------------
Patient details of  : Dr.Ruchaa
****No Appointments Scheduled for today****
----------------------------------------------------------------------------
Do you want to continue as a receptionist, if yes press 1
1
Enter your choice 
1-Register Patient
2-Show Appointment Details
1
Enter Patient name:
Sanjay
Enter the Patient Age  
45
Enter Patient Gender:
m
Choose the doctor type:
1:Surgeon
2:Physician
3:Orthopedist
4:Dermatologist
5:Neurologist
2
Ask patient to pay Appointment fees: 300.0
Registration Completed Successfully on ***** 31-12-2021 10:01:21 *****
------------------------------------------------------------------------------
do you want to continue adding patients in the list press 1
1
Enter Patient name:
Sushila
Enter the Patient Age  
56
Enter Patient Gender:
g
Choose the doctor type:
1:Surgeon
2:Physician
3:Orthopedist
4:Dermatologist
5:Neurologist
2
Ask patient to pay Appointment fees: 500.0
Registration Completed Successfully on ***** 31-12-2021 10:01:39 *****
------------------------------------------------------------------------------
do you want to continue adding patients in the list press 1
1
Enter Patient name:
Vishal
Enter the Patient Age  
89
Enter Patient Gender:
m
Choose the doctor type:
1:Surgeon
2:Physician
3:Orthopedist
4:Dermatologist
5:Neurologist
4
Doctor Not available!!
do you want to continue adding patients in the list press 1
1
Enter Patient name:
Vishal
Enter the Patient Age  
89
Enter Patient Gender:
m
Choose the doctor type:
1:Surgeon
2:Physician
3:Orthopedist
4:Dermatologist
5:Neurologist
1
Ask patient to pay Appointment fees: 1000.0
Registration Completed Successfully on ***** 31-12-2021 10:02:10 *****
------------------------------------------------------------------------------
do you want to continue adding patients in the list press 1
0
Do you want to continue as a receptionist, if yes press 1
1
Enter your choice 
1-Register Patient
2-Show Appointment Details
2
Enter choice for appointment Details of  
1-All doctors
2-Specific Doctor
----------------------------------------------------------------------------
1
----------------------------------------------------------------------------
Patient details of  : Dr.Kumarr
ID              Name            Age             Sex
100             Shweta          23              f
109             Vishal          89              m
----------------------------------------------------------------------------
Patient details of  : Dr.Kelkar
ID              Name            Age             Sex
101             Vidhii          19              f
105             Yashwi          10              f
106             Sanjay          45              m
----------------------------------------------------------------------------
Patient details of  : Dr.Patill
ID              Name            Age             Sex
102             Shreya          43              f
----------------------------------------------------------------------------
Patient details of  : Dr.Shinde
ID              Name            Age             Sex
104             Snehal          14              f
----------------------------------------------------------------------------
Patient details of  : Dr.Ruchaa
ID              Name            Age             Sex
107             Sushila         56              g
----------------------------------------------------------------------------
Do you want to continue as a receptionist, if yes press 1
1
Enter your choice 
1-Register Patient
2-Show Appointment Details
2
Enter choice for appointment Details of  
1-All doctors
2-Specific Doctor
----------------------------------------------------------------------------
2
Enter the id of the doctor whose appointment details are to be displayed 
6
-----------------------------Dr.Ruchaa Appointments-------------------------
ID              Name            Age             Sex
107             Sushila         56              g
----------------------------------------------------------------------
Do you want to continue as a receptionist, if yes press 1
0
Do you want to login again as a receptionist, if yes press 1
0
Do you want to Login again in another role, if yes press 1
1
WHO ARE YOU ? 
1-ADMIN
2-RECEPTIONIST
3-DOCTOR
3
-----------------------------DOCTOR----------------------------
Enter your Doctor ID :
2
Enter the Password : 
doctor
You have logged in successfully 
Enter your choice
1-Check Appointment
2-Delete Appointement
1
----------------------------------------------------------------------------
ID              Name            Age             Sex
101             Vidhii          19              f
105             Yashwi          10              f
106             Sanjay          45              m
----------------------------------------------------------------------------
Do you want to continue as a doctor, if yes press 1
1
Enter your choice 
1-Check Appointment
2-Delete Appointement
2
Patient removed Successfully
Do you want to continue as a doctor, if yes press 1
1
Enter your choice 
1-Check Appointment
2-Delete Appointement
2
Patient removed Successfully
Do you want to continue as a doctor, if yes press 1
1
Enter your choice 
1-Check Appointment
2-Delete Appointement
1
----------------------------------------------------------------------------
ID              Name            Age             Sex
106             Sanjay          45              m
----------------------------------------------------------------------------
Do you want to continue as a doctor, if yes press 1
1
Enter your choice 
1-Check Appointment
2-Delete Appointement
2
Patient removed Successfully
Do you want to continue as a doctor, if yes press 1
1
Enter your choice 
1-Check Appointment
2-Delete Appointement
1
----------------------------------------------------------------------------
****No Appointments Are Present****
----------------------------------------------------------------------------
Do you want to continue as a doctor, if yes press 1
0
Do you want to login again as a doctor, if yes press 1
0
Do you want to Login again in another role, if yes press 1
1
WHO ARE YOU ? 
1-ADMIN
2-RECEPTIONIST
3-DOCTOR
2
------------------------------RECEPTION----------------------
Enter the Password :
reception
You have logged in successfully
Enter your choice
1-Register Patient
2-Show Appointment Details
2
Enter choice for appointment Details of  
1-All doctors
2-Specific Doctor
----------------------------------------------------------------------------
2
Enter the id of the doctor whose appointment details are to be displayed 
2
****No Appointments Scheduled for today****
Do you want to continue as a receptionist, if yes press 1
0
Do you want to login again as a receptionist, if yes press 1
0
Do you want to Login again in another role, if yes press 1
0
-----------------------------------THANK YOU----------------------------------
*/