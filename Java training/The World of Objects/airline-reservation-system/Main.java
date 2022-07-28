import java.util.Arrays;

public class Main {

        public static void main(String[] args) {

                // person passenger = new person("Rayan Slim", "Canadian", "01/01/1111", 5);
                // if (passenger.applyForPassport() == true) {
                // passenger.setPassport();

                // }

                // person passenger2 = new person(passenger);

                // passenger2.setName("Jad Slim");
                // passenger2.setSeatNumber(3);

                // if (passenger2.applyForPassport() == true) {
                // passenger2.setPassport();
                // }

                // // System.out.println("Name: " + passenger.getName() + "\n" +
                // // "Nationality: " + passenger.getNationality() + "\n" +
                // // "Date of Birth: " + passenger.getDateOfBirth() + "\n" +
                // // "passport details: " + Arrays.toString(passenger.getPassport()) + "\n" +
                // // "Seat Number: " + passenger.chooseSeatNUmber() + "\n");

                // // System.out.println("seat is already occupied. please select another seat
                // // number. \n");

                // // passenger.setSeatNumber(10);

                // // System.out.println("Name: " + passenger.getName() + "\n" +
                // // "Nationality: " + passenger.getNationality() + "\n" +
                // // "Date of Birth: " + passenger.getDateOfBirth() + "\n" +
                // // "passport details: " + Arrays.toString(passenger.getPassport()) + "\n" +
                // // "Seat Number: " + passenger.chooseSeatNUmber() + "\n");

                // // System.out.println("Name: " + passenger2.getName() + "\n" +
                // // "Nationality: " + passenger2.getNationality() + "\n" +
                // // "Date of Birth: " + passenger2.getDateOfBirth() + "\n" +
                // // "passport details: " + Arrays.toString(passenger2.getPassport()) + "\n" +
                // // "Seat Number: " + passenger2.chooseSeatNUmber() + "\n");

                // System.out.println(passenger);
                // System.out.println(passenger2);

                person[] passengers = new person[] { new person("Cleopatra", "Egypt", "69 BC", 1),
                                new person("Alexander the Great", "Macedon", "356 BC", 2),
                                new person("Julius Caesar", "Rome", "100 BC", 3),
                                new person("Hannibal", "Carthage", "247 BC", 4),
                                new person("Confucius", "China", "551 BC", 5),
                                new person("Pericles", "Greece", "429 BC", 6),
                                new person("Spartacus", "Thrace", "111 BC", 7),
                                new person("Marcus Aurelius", "Rome", "121 AD", 8),
                                new person("Leonidas", "Greece", "540 BC", 9),
                                new person("Sun Tzu", "China", "544 BC", 10),
                                new person("Hammurabi", "Babylon", "1750 BC", 5),
                };
                Airline airline = new Airline();

                for (int i = 0; i < passengers.length; i++) {
                        airline.createReservation(passengers[i]);
                }

                // System.out.println(airline.getPerson(1));
                // System.out.println(airline.getPerson(5));
                // System.out.println(airline.getPerson(10));

                System.out.println(airline);

                System.out.println("****************** RESERVATIONS COMPLETE! ****************** \n");
                System.out.println(" java Airline \n \n ");

        }

}
