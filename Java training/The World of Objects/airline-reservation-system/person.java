import java.util.Arrays;

public class person {

    private String name;
    private String nationality;
    private String dateOfBirth;
    private String[] passport;
    private int seatNumber;

    public person(String name, String nationality, String dateOfBirth, int seatNumber) {
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.passport = new String[3];
        this.seatNumber = seatNumber;

    }

    public person(person source) {
        this.name = source.name;
        this.nationality = source.nationality;
        this.dateOfBirth = source.dateOfBirth;
        this.passport = new String[3];
        this.seatNumber = source.seatNumber;
    }

    // getter//

    public String getName() {
        return this.name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String[] getPassport() {
        return Arrays.copyOf(this.passport, this.passport.length);
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    // setter//

    public void setName(String Name) {
        this.name = Name;

    }

    public void setNationality(String Nationality) {
        this.nationality = Nationality;

    }

    public void setDateOfBirth(String DateOfBirth) {
        this.dateOfBirth = DateOfBirth;

    }

    public void setSeatNumber(int SeatNumber) {
        this.seatNumber = SeatNumber;

    }

    public void setPassport() {
        this.passport[0] = this.name;
        this.passport[1] = this.nationality;
        this.passport[2] = this.dateOfBirth;
    }

    public boolean applyForPassport() {
        int num = (int) (Math.random() * 2);

        if (num == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int chooseSeatNUmber() {
        int num = (int) ((Math.random() * 11) + 1);

        return num;
    }

    public String toString() {
        return "Name: " + this.getName() + "\n" +
                "Nationality: " + this.getNationality() + "\n" +
                "Date of Birth: " + this.getDateOfBirth() + "\n" +
                "passport details: " + Arrays.toString(this.getPassport()) + "\n" +
                "Seat Number: " + this.getSeatNumber() + "\n";

    }

}
