public class Airline {

    person[] seats;

    public Airline() {
        this.seats = new person[11];
    }

    public person getPerson(int index) {
        return new person(this.seats[index]);

    }

    public void setPerson(person passenger) {
        this.seats[passenger.getSeatNumber() - 1] = new person(passenger);
    }

    public void createReservation(person passenger) {
        while (seats[passenger.getSeatNumber() - 1] != null) {
            System.out.println(passenger.getName() + ", seat: " + passenger.getSeatNumber()
                    + "is already taken. Please choose another one. \n");
            passenger.setSeatNumber(passenger.chooseSeatNUmber());
        }

        this.setPerson(passenger);

        System.out.println("Tank you " + passenger.getName() + "for flying with Java airlines. Your seat number is "
                + passenger.getSeatNumber() + ". \n");
    }

    public String toString() {
        String temp = "";

        for (int i = 0; i < seats.length; i++) {
            temp += "Seat No.: " + this.getPerson(i).getSeatNumber() + " Passenger Name: " + this.getPerson(i).getName()
                    + " Natioanlaity: " + this.getPerson(i).getNationality() + ". \n \n";
        }

        return temp;

    }
}
