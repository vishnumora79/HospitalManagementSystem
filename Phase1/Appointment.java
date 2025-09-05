package Phase1;
public class Appointment {
    private int patientId;
    private int doctorId;
    private String Date;

    public int getPatientId() {
        return this.patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return this.doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return this.Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    Appointment(int patientId, int doctorId, String Date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.Date = Date;
    }
}