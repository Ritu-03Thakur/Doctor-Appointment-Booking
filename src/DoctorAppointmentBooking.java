import java.util.ArrayList;
import java.util.Scanner;
    class AppointmentBooking{
        Scanner sc = new Scanner(System.in);
        boolean flag = true ;
        ArrayList<String> doctorName = new ArrayList<String>() ;
        ArrayList<String> doctorQualification = new ArrayList<String>() ;
        ArrayList<String> doctorGender = new ArrayList<String>() ;
        ArrayList<String> doctorPassword = new ArrayList<String>() ;
        ArrayList<String> doctorCity = new ArrayList<String>() ;
        ArrayList<Integer> doctorAge = new ArrayList<Integer>() ;
        ArrayList<Long> doctorMobile_number = new ArrayList<Long>() ;


        ArrayList<String> patientName = new ArrayList<String>() ;
        ArrayList<String> patientGender = new ArrayList<String>() ;
        ArrayList<String>patientPassword = new ArrayList<String>() ;
        ArrayList<String> patientConfirmPassword = new ArrayList<String>() ;
        ArrayList<Integer> patientAge = new ArrayList<Integer>() ;
        ArrayList<Long> patientMobile_number = new ArrayList<Long>() ;


        ArrayList<String> patientNameBooking = new ArrayList<String>() ;
        ArrayList<String> patientGenderBooking = new ArrayList<String>() ;
        ArrayList<Integer> patientAgeBooking = new ArrayList<Integer>() ;
        ArrayList<Byte> doctorID = new ArrayList<Byte>() ;

        public void dataAdd(){
            doctorName.add("DR. Ashish Gupta");
            doctorName.add("DR. Priya Katana");
            doctorName.add("DR. Shiva Singh");
            doctorName.add("DR. Shreya Sharma");
            doctorName.add("DR. Prashant Jha");

            doctorGender.add("M");
            doctorGender.add("F");
            doctorGender.add("M");
            doctorGender.add("F");
            doctorGender.add("M");

            doctorQualification.add("MBBS");
            doctorQualification.add("Er , MBBS");
            doctorQualification.add("MBBS , MD");
            doctorQualification.add("BAMS");
            doctorQualification.add("MBBS , MD , Surgeon");

            doctorAge.add(33);
            doctorAge.add(20);
            doctorAge.add(28);
            doctorAge.add(25);
            doctorAge.add(40);

            doctorCity.add("Delhi");
            doctorCity.add("Jaipur");
            doctorCity.add("Patna");
            doctorCity.add("Mumbai");
            doctorCity.add("Chennai");

            doctorPassword.add("Ashish123");
            doctorPassword.add("Priya123");
            doctorPassword.add("Shiva123");
            doctorPassword.add("Shreya123");
            doctorPassword.add("Prashant123");

            doctorMobile_number.add(8784874456L);
            doctorMobile_number.add(7675743456L);
            doctorMobile_number.add(9567424576L);
            doctorMobile_number.add(9876598757L);
            doctorMobile_number.add(8657654345L);
        }


        /* ----------------------------------------------------------------------------
                             1.         DOCTOR
        * -------------------------------------------------------------------------- */
        void doctor () throws Exception {
            boolean flag = true ;
            while (flag) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("****************************************************");
                System.out.println("\t\t WELCOME TO DOCTOR PAGE ! \t\t");
                System.out.println("****************************************************");
                System.out.println("");
                System.out.println("1. Login \t \t 2. Registration ");
                int c = sc.nextInt();
                if (c == 1) {
                    if (doctorMobile_number.isEmpty()) {
                        System.out.println("Register first ......");
                        //    flag = false;
                        doctor();
                        Thread.sleep(500);
                    } else {
                        doctorLogin();

                    }

                } else if (c == 2) {
                    doctorRegistration();
                    flag = false;
                } else {
                    System.out.println("Sorry ! You Entered Wrong Choice .....");
                    flag = true ;
                }
            }
        }
        void doctorLogin () throws Exception {

            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            System.out.println("****************************************************");
            System.out.println("\t\t WELCOME TO DOCTOR's LOGIN PAGE ! \t\t");
            System.out.println("****************************************************");
            System.out.println("Enter Your Username ( Mobile Number ) : ");
            long mobileNumber = sc.nextLong();
            System.out.println("Enter Your Password : ");
            String password = sc.next();
            boolean flag = false , flag22 = true ;
            int i = 0 ;
            for ( i = 0; i < doctorMobile_number.size(); i++) {
                if((doctorMobile_number.get(i)).equals(mobileNumber) && (doctorPassword.get(i)).equals(password)){
                    flag = true ;
                    break ;
                }
            }

            if(flag == true) {
                while (flag22) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("****************************************************");
                    System.out.println("\t\t WELCOME TO DOCTOR " + doctorName.get(i) + "||");
                    System.out.println("****************************************************");
                    System.out.println("\n \n Press 1 to see your Appointment \n");
                    int ch = sc.nextInt();
                    byte j = 0;
                    switch (ch) {
                        case 1:
                            if (!doctorID.isEmpty()) {
                                while (j <= doctorID.size() - 1) {
                                    if (i + 1 == doctorID.get(j)) {
                                        System.out.println("Patient Name : " + patientNameBooking.get(j));
                                        j++;
                                    }
                                }
                                Thread.sleep(4000);
                            } else {
                                System.out.println(" No Appointments ...............");
                                Thread.sleep(3000);
                                flag22 = true;
                            }
                            break;
                    }
                }
            }

            else{
                System.out.println("Login Unsuccessful ...");
                Thread.sleep(800);

            }
        }

        // *************************************************************************************************
        //----------------------  Doctor  Registration  method    ---------------------------------------------
        void doctorRegistration () throws Exception {

            int i = 0;
            boolean flag2 = true , flag = true ;
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("****************************************************");
            System.out.println("\t\t WELCOME TO DOCTOR's REGISTRATION  PAGE ! \t\t");
            System.out.println("****************************************************");

            System.out.println("Enter Your Name :");
            doctorName.add(sc.next());

            System.out.println("Enter Your Mobile Number : ");
            long mobileNumber = sc.nextLong();

            long mno;
            if (doctorMobile_number.isEmpty()) {
                doctorMobile_number.add((mobileNumber));
                System.out.println("Enter Password : ");
                doctorPassword.add(sc.next());
                System.out.println("Registration is Successful.");
                Thread.sleep(1000);
                flag2 = false;
            } else {
                for (i = 0; i <= doctorMobile_number.size() - 1; i++) {
                    mno = doctorMobile_number.get(i);
                    if (mno == mobileNumber) {
                        flag2 = false;
                        break;
                    }
                }

                if (flag2) {
                    doctorMobile_number.add(mobileNumber);
                    System.out.println("Enter Your Age :");
                    doctorAge.add(sc.nextInt());
                    System.out.println("Enter City :");
                    doctorCity.add(sc.next());
                    System.out.println("Enter Password :");
                    doctorPassword.add(sc.next());
                    System.out.println("Registration is Successful.");
                    System.out.println("Details :- \n Name :" + doctorName + "\n Mobile Number : " + doctorMobile_number);
                    Thread.sleep(1000);

                } else {
                    System.out.println("Same Mobile Number is not allowed !!");
                    int index = doctorName.size() - 1;
                    doctorName.remove(index);
                    Thread.sleep(1000);
                }

            }
        }
        /* ----------------------------------------------------------------------------
                                  2.    PATIENT
        * -------------------------------------------------------------------------- */
        void patient() throws Exception {
            Scanner sc = new Scanner(System.in);
            boolean flag = true;
            while (flag) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("****************************************************");
                System.out.println("\t\t WELCOME TO PATIENT PAGE ! \t\t");
                System.out.println("****************************************************");
                System.out.println("");
                System.out.println("1. Login \t \t 2. Registration ");
                int c = sc.nextInt();
                if (c == 1) {
                    if(patientMobile_number.isEmpty()) {
                        System.out.println("First Register Yourself then login ....! ");
                        Thread.sleep(500);
                        break ;
                    }else {
                        patientLogin();
                        flag = false ;
                    }
                    break ;
                } else if (c == 2 ) {
                    patientRegistration();
                    //     flag = false;
                    break;
                }
                else {
                    System.out.println("\n You Entered Wrong Choice .....");
                    flag = true ;
                    Thread.sleep(1000);
                    break ;
                }
            }
        }
        //----------------------   Patient Login  method    ---------------------------------------------
        void patientLogin() throws Exception {

            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            System.out.println("****************************************************");
            System.out.println("\t\t WELCOME TO DOCTOR's LOGIN PAGE ! \t\t");
            System.out.println("****************************************************");
            System.out.println("Enter Your Username (Mobile Number ) : ");
            long mobileNumber = sc.nextLong();
            System.out.println("Enter Your Password : ");
            String password = sc.next();
            boolean flag = true , flag2 = false ;
            int i = 0 ;
            for ( i = 0; i <= patientMobile_number.size() -1 ; i++) {
                if((patientMobile_number.get(i)).equals(mobileNumber) && (patientPassword.get(i)).equals(password)){
                    flag2 = true ;
                    break ;
                }
            }

            if(flag2 == true){

                Thread.sleep(1000);
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("****************************************************");
                System.out.println("\t\t      Book Appointment  \t \t ");
                System.out.println("****************************************************");
                System.out.println("\n Welcome " + patientName.get(i) + ", to book  Appointment , \n Choose Your Doctor : ");
                for (int j = 0; j <= doctorName.size() - 1 ; j++) {
                    System.out.println(i+1 + "." + doctorName.get(i));
                }
                byte choice = sc.nextByte();
                doctorID.add(choice) ;

                while(flag) {
                    Thread.sleep(1000);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("****************************************************");
                    System.out.println("\t\t      Book Appointment  \t \t ");
                    System.out.println("****************************************************");

                    if(choice <= doctorName.size() && choice > 0 ){
                        System.out.println("\n\n Name : \t " + doctorName.get(choice -1 ) + "\n Age : \t " +doctorAge.get(choice -1 )+ "\n Mobile : " + doctorMobile_number.get(choice -1 ));
                        System.out.println("\n Enter Your Name :");
                        sc.nextLine();
                        patientNameBooking.add(sc.nextLine());
                        System.out.println("Enter Your Age : ");
                        patientAgeBooking.add(sc.nextInt());
                        System.out.println("Enter Your Gender : ");
                        patientGenderBooking.add(sc.next()) ;

                        System.out.println("\n Booking Successful ...");
                        Thread.sleep(1000);
                        flag = false ;
                        break;
                    }else{
                        System.out.println("\n\n Enter correct Input ....");
                        flag = true ;
                        Thread.sleep(1000);
                    }


                }


            }
            else {
                System.out.println("Login Unsuccessful ...");
                Thread.sleep(800);
                flag = false ;
            }

        }

        // **********************************************************************************************************

        //----------------------   Patient Registration  method    ---------------------------------------------
        void patientRegistration() throws Exception {
            int i = 0;
            boolean flag2 = true;
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("****************************************************");
            System.out.println("\t\t WELCOME TO PATIENT's REGISTRATION  PAGE ! \t\t");
            System.out.println("**************************************************** \n ");

            System.out.println("Enter Your Name :");
            doctorName.add(sc.nextLine());

            System.out.println("Enter Your Age : ");
            patientAge.add(sc.nextInt());

            System.out.println("Enter Your Mobile Number : ");
            long mobileNumber = sc.nextLong();

            long mno;

            if (patientMobile_number.isEmpty()) {
                patientMobile_number.add((mobileNumber));
                System.out.println("Enter Password : ");
                patientPassword.add(sc.next());
                System.out.println("Registration is Successful.");
                Thread.sleep(1000);
                patient();
                flag2 = false;
            } else {
                for (i = 0; i <= patientMobile_number.size() - 1; i++) {
                    mno = patientMobile_number.get(i);
                    if (mno == mobileNumber) {
                        flag2 = false;
                        break;
                    }
                }

                if (flag2) {
                    patientMobile_number.add(mobileNumber);
                    System.out.println("Enter Password :");
                    patientPassword.add(sc.next());
                    System.out.println("Registration is Successful.");
                    Thread.sleep(1000);

                } else {
                    System.out.println("Same Mobile Number is not allowed !!");
                    Thread.sleep(1000);
                }

            }
        }

        /* ***************************************************************************************/



        /* ----------------------------------------------------------------------------
                                 3.     ADMIN
        * -------------------------------------------------------------------------- */
        void Admin() throws Exception {
            Scanner sc = new Scanner(System.in);
            boolean flag = true ;
            while(flag){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                System.out.println("****************************************************");
                System.out.println("\t\t WELCOME TO ADMIN PAGE ! \t\t");
                System.out.println("****************************************************");
                System.out.println("");
                System.out.println("1. Doctor List \t  2. Registered Patients \t 3. Patients with Appointment \n  ");
                System.out.print("Enter Your Choice : ");
                int c =sc.nextInt();
                if(c == 1 ){

                    for (int i = 0; i < doctorName.size() - 1 ; i++) {
                        System.out.println("Name : \t " + doctorName.get(i));
                    }
                    System.out.println("\n \n 1. Main Menu \t 2. Previous Menu ");
                    byte menuChoice  = sc.nextByte();
                    if(menuChoice == 1){
                        flag = false ; }
                    else{
                        Admin();
                        break ;  }
                    break ;
                }
                else if(c == 2 ) {

                    if(patientName.isEmpty()){
                        System.out.println("No Registered Patients Yet !! ");
                        Thread.sleep(3000) ;
                        break ;
                    }
                    else {

                        for (int i = 0; i < patientName.size() - 1 ; i++) {
                            System.out.println(i + " ." + patientName.get(i));
                        }
                        System.out.println("\n \n 1. Main Menu \t 2. Previous Menu ");
                        byte menuChoice  = sc.nextByte();
                        if(menuChoice == 1){
                            flag = false ;
                        }
                        else{  break ;  }
                        break ;

                    }
                }
                else if (c == 3 ){
                    if(patientNameBooking.isEmpty()){
                        System.out.println("\n No Appointment Yet !!");
                        Thread.sleep(3000);
                        break ;
                    }
                    else{
                        for (int i = 0; i <= patientNameBooking.size() - 1 ; i++) {
                            System.out.println(i + " ." + patientName.get(i));
                        }
                        Thread.sleep(3000);
                        flag = false ;
                    }
                    break ;
                }
                else {
                    System.out.println("Wrong choice .....");
                    Thread.sleep(1000);
                    break ;
                }
            }

        }
    }
    /************************** -------------------------------------********************************/
    public class DoctorAppointmentBooking {
        public static void main(String[] args) throws Exception  {
            Scanner sc = new Scanner(System.in);
            AppointmentBooking appoint = new AppointmentBooking();
            boolean flag = true ;
            while( flag){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                System.out.println("****************************************************");
                System.out.println("\t\t WELCOME TO DOCTOR APPOINTMENT \t\t");
                System.out.println("****************************************************");
                System.out.println("1.Doctor \t 2. Patient \t 3. Admin \t 4. Exit");
                System.out.print("Enter Your Choice : ");
                int choice = sc.nextInt();
                if(choice == 1 ){
                    appoint.doctor();
                    flag = true ;
                }
                else if(choice == 2 ){
                    appoint.patient();
                    flag = true ;
                }
                else if(choice == 3 ){
                    appoint.Admin();
                    flag = true ;
                }
                else {
                    System.exit(0);
                }
            }
        }
    }


