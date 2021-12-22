class Vehicle {
  int passengers;
  int wheels;
  int maxspeed;
  int burnup;
}

class MoreVehicleDemo {
  public static void main(String[] args) {
    Vehicle car1 = new Vehicle();
    car1.passengers = 2;
    car1.wheels = 6;
    car1.maxspeed = 130;
    car1.burnup = 30;

    Vehicle bus1 = new Vehicle();
    bus1.passengers = 45;
    bus1.wheels = 4;
    bus1.maxspeed = 100;
    bus1.burnup = 45;

    double interval = 1.25;
    double distanceCar = car1.maxspeed * interval;
    double distanceBus = bus1.maxspeed * interval;

    System.out.println("car1 может проехать за 1 час 15 мин. расстояние в ");
    System.out.println(distanceCar + " км с " + car1.passengers);
    System.out.println(" пассажирами");
    System.out.println("bus1 может проехать за 1 час 15 мин. расстояние в ");
    System.out.println(distanceBus + " км с " + bus1.passengers);
    System.out.println(" пассажирами");

    car1 = null;
  }
}
