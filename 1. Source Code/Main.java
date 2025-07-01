import java.util.*;
import java.io.*;
class Doctors
{
String Dr_Name;
String Specialization;
String Degree;
int Dr_Id;
Doctors(String Dr_Name, String Specialization, String Degree, int Dr_Id)
{
this.Dr_Name = Dr_Name;
this.Specialization = Specialization;
this.Degree = Degree;
this.Dr_Id = Dr_Id;
}
void display()
{
System.out.println("Doctor ID: "+Dr_Id);
System.out.println("Name: Dr. "+Dr_Name);
System.out.println("Specialization:"+Specialization);
System.out.println("Degree: "+Degree);
System.out.println("--------------------------------");
}
String toFileString(int sno)
{
return sno + ".\n" +
"Doctor ID       : " + Dr_Id + "\n" +
"Name            : Dr. " + Dr_Name + "\n" +
"Specialization  : " + Specialization + "\n" +
"Degree          : " + Degree + "\n" +
"---------------------------";
}
}
class Patients
{
String Patient_Name;
int age;
char Gender;
String Disease;
int Patient_Id;
Patients(String Patient_Name, int age, char Gender, String Disease, int Patient_Id)
{
this.Patient_Name = Patient_Name;
this.age = age;
this.Gender = Gender;
this.Disease = Disease;
this.Patient_Id = Patient_Id;
}
void display()
{
System.out.println("Patient ID: "+Patient_Id);
System.out.println("Name: "+Patient_Name);
System.out.println("Age: " +age);
System.out.println("Gender: "+Gender);
System.out.println("Disease: "+ Disease);
System.out.println("--------------------------------");
}
String toFileString(int sno)
{
return sno + ".\n" +
"Patient ID  : " + Patient_Id + "\n" +
"Name        : " + Patient_Name + "\n" +
"Age         : " + age + "\n" +
"Gender      : " + Gender + "\n" +
"Disease     : " + Disease + "\n" +
"---------------------------";
}
}
class Appointment
{
int Appointment_id;
int Patient_id;
int Doctor_id;
String Date;
String Time;
Appointment(int Appointment_id, int Patient_id, int Doctor_id, String Date, String Time)
{
this.Appointment_id = Appointment_id;
this.Patient_id = Patient_id;
this.Doctor_id = Doctor_id;
this.Date = Date;
this.Time = Time;
}
void display()
{
System.out.println("Appointment ID: "+ Appointment_id);
System.out.println("Patient ID: "+Patient_id);
System.out.println("Doctor ID: " +Doctor_id);
System.out.println("Date: "+ Date);
System.out.println("Time: "+ Time);
System.out.println("--------------------------------");
}
String toFileString(int sno)
{
return sno + ".\n" +
"Appointment ID : " + Appointment_id + "\n" +
"Patient ID     : " + Patient_id + "\n" +
"Doctor ID      : " + Doctor_id + "\n" +
"Date           : " + Date + "\n" +
"Time           : " + Time + "\n" +
"---------------------------";
}
}
class Hospital_Management
{
ArrayList<Doctors> doctorList = new ArrayList<>();
ArrayList<Patients> patientList = new ArrayList<>();
ArrayList<Appointment> appointmentList = new ArrayList<>();
Hospital_Management()
{
createFile("doctors.txt");
createFile("patients.txt");
createFile("appointments.txt");
}
void createFile(String fileName)
{
try
{
File file = new File(fileName);
if (!file.exists())
{
file.createNewFile();
//System.out.println(fileName + " created successfully.");
}
}
catch (IOException e)
{
System.out.println("Error creating file: " + fileName);
}
}
Scanner sc = new Scanner(System.in);
void addDoctor()
{
int Dr_Id;
while (true)
{
System.out.print("Enter Doctor ID: ");
Dr_Id = sc.nextInt();
sc.nextLine();
boolean exists = false;
for (Doctors d : doctorList)
{
if (d.Dr_Id == Dr_Id)
{
System.out.println("Error: Doctor ID already exists. Please enter a unique ID.");
exists = true;
break;
}
}
if (!exists) break;
}
String Dr_Name;
while(true)
{
System.out.print("Enter Doctor Name: ");
Dr_Name = sc.nextLine();
if (Dr_Name.matches("[a-zA-Z ]+"))
{
break;
}
System.out.println("Not a valid name! Please enter Alphabets only");
}
System.out.print("Enter Specialization: ");
String Specialization = sc.nextLine();
System.out.print("Enter Degree: ");
String Degree = sc.nextLine();
doctorList.add(new Doctors(Dr_Name, Specialization, Degree, Dr_Id));
saveDoctors();
System.out.println("Doctor added successfully.");
System.out.println("--------------------------------");
}
void addPatient()
{
int Patient_Id;
while (true)
{
System.out.print("Enter Patient ID: ");
Patient_Id = sc.nextInt();
sc.nextLine();
boolean exists = false;
for (Patients p : patientList)
{
if (p.Patient_Id == Patient_Id)
{
System.out.println("Error: Patient ID already exists. Please enter a unique ID.");
exists = true;
break;
}
}
if (!exists) break;
}
String Patient_Name;
while (true)
{
System.out.print("Enter Patient Name: ");
Patient_Name = sc.nextLine();
if (Patient_Name.matches("[a-zA-Z ]+"))
{
break;
}
System.out.println("Not a valid name! Please enter Alphabets only.");
}
int age;
while (true)
{
System.out.print("Enter Age: ");
if (sc.hasNextInt())
{
age = sc.nextInt();
sc.nextLine();
break;
}
else
{
System.out.println("Error: Please enter a valid numeric age.");
sc.next();
}
}
char Gender;
while (true)
{
System.out.print("Enter Gender (M/F): ");
String genderInput = sc.next().toUpperCase();
if (genderInput.equals("M") || genderInput.equals("F"))
{
Gender = genderInput.charAt(0);
break;
}
else
{
System.out.println("Error: Please enter 'M' for Male or 'F' for Female.");
}
}
sc.nextLine();
System.out.print("Enter Disease: ");
String Disease = sc.nextLine();
patientList.add(new Patients(Patient_Name, age, Gender, Disease, Patient_Id));
savePatients();
System.out.println("Patient added successfully.");
System.out.println("--------------------------------");
}
void Schedule_Appointment()
{
int Appointment_id;
while (true)
{
System.out.print("Enter Appointment ID: ");
Appointment_id = sc.nextInt();
sc.nextLine();
boolean exists = false;
for (Appointment a : appointmentList)
{
if (a.Appointment_id == Appointment_id)
{
System.out.println("Error: Patient ID already exists. Please enter a unique ID.");
exists = true;
break;
}
}
if (!exists) break;
}
System.out.print("Enter Patient ID: ");
int Patient_id = sc.nextInt();
System.out.print("Enter Doctor ID: ");
int Doctor_id = sc.nextInt();
sc.nextLine();
System.out.print("Enter Date: ");
String Date = sc.nextLine();
System.out.print("Enter Time: ");
String Time = sc.nextLine();
appointmentList.add(new Appointment(Appointment_id, Patient_id, Doctor_id, Date, Time));
saveAppointments();
System.out.println("Appointment scheduled successfully.");
System.out.println("--------------------------------");
}
void Cancel_Appointment()
{
System.out.print("Enter Appointment ID to Cancel: ");
int id = sc.nextInt();
boolean removed = appointmentList.removeIf(a -> a.Appointment_id == id);
if (removed)
System.out.println("Appointment cancelled successfully.");
else
System.out.println("Appointment ID not found.");
}
void Disp_allDoctors()
{
System.out.println("Doctors List:");
System.out.println("--------------------------------");
for (Doctors d : doctorList)
d.display();
}
void Disp_allPatients()
{
System.out.println("Patients List:");
System.out.println("--------------------------------");
for (Patients p : patientList)
p.display();
}
void Disp_allAppointments()
{
if (appointmentList.isEmpty())
{
System.out.println("No appointments found.");
return;
}
System.out.println("Appointments List:");
System.out.println("--------------------------------");
for (Appointment a : appointmentList) 
a.display();
}
void saveDoctors()
{
try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctors.txt")))
{
int sno = 1;
for (Doctors d : doctorList)
{
writer.write(d.toFileString(sno++) + "\n");
}
}
catch (IOException e)
{
System.out.println("Error saving doctors.");
}
}
void savePatients()
{
try (BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt")))
{
int sno = 1;
for (Patients p : patientList)
{
writer.write(p.toFileString(sno++) + "\n");
}
}
catch (IOException e)
{
System.out.println("Error saving patients.");
}
}
void saveAppointments()
{
try (BufferedWriter writer = new BufferedWriter(new FileWriter("appointments.txt")))
{
int sno = 1;
for (Appointment a : appointmentList)
{
writer.write(a.toFileString(sno++) + "\n");
}
}
catch (IOException e)
{
System.out.println("Error saving appointments.");
}
}
}
class Main
{
public static void main(String...args)
{
Hospital_Management ob = new Hospital_Management();
Scanner sc = new Scanner(System.in);
String D_Username = "Batch 04";
String D_Password = "Batch 04";
int attempts = 3;
while (attempts > 0)
{
System.out.print("Enter Username: ");
String username = sc.nextLine();
System.out.print("Enter Password: ");
String password = sc.nextLine();
if (username.equals(D_Username) && password.equals(D_Password))
{
System.out.println("Login Successful! Access Granted");
System.out.println("--------------------------------");
break;
}
else
{
attempts--;
System.out.println("Invalid Credentials! " + attempts+ " Attempts left" );
if (attempts == 0)
{
System.out.println("Too many failed attempts! Exiting...");
return;
}
}
}
ob.doctorList.add(new Doctors("Sujith", "Cardiologist", "MBBS", 101));
ob.doctorList.add(new Doctors("Shanmukh", "Neurologist", "MBBS", 102));
ob.patientList.add(new Patients("Uma", 16, 'F', "Fever", 201));
ob.patientList.add(new Patients("Manoj", 19, 'M', "Migraine", 202));
ob.appointmentList.add(new
Appointment(301, 201, 101, "2025-03-10", "1:00 pm"));
ob.appointmentList.add(new
Appointment(302, 202, 102, "2025-03-12", "3:30 pm"));
ob.saveDoctors();
ob.savePatients();
ob.saveAppointments();
int choice;
do
{
System.out.println("\nMelmaa Multi-Speciality Hospital");
System.out.println("--------------------------------");
System.out.println("1. Add Doctor");
System.out.println("2. Add Patient");
System.out.println("3. Schedule Appointment");
System.out.println("4. Cancel Appointment");
System.out.println("5. Display All Doctors");
System.out.println("6. Display All Patients");
System.out.println("7. Display All Appointments");
System.out.println("8. Exit");
System.out.println("--------------------------------");
System.out.print("Enter your choice: ");
choice = sc.nextInt();
switch (choice)
{
case 1: ob.addDoctor();
break;
case 2: ob.addPatient();
break;
case 3: ob.Schedule_Appointment();
break;
case 4: ob.Cancel_Appointment();
break;
case 5: ob.Disp_allDoctors();
break;
case 6: ob.Disp_allPatients();
break;
case 7: ob.Disp_allAppointments();
break;
case 8: System.out.println("Exiting..."); 
System.out.println("\nThank You...");
break;
default: System.out.println("Invalid choice");
}
}while (choice != 8);
}
}