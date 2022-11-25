public class main {
    public static void main(String[] args) {
//        Bus bus1 = new Bus(50, 100, 1000);
        Taxi taxi1 = new Taxi(6);
        taxi1.get_on_guest(7);
        taxi1.change_speed(30);
        taxi1.end_game();
        taxi1.get_out_guest();
        Taxi taxi2 = new Taxi(2);
    }
}