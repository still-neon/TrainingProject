package by.stn.java_exercises.modul_1.ex_24_fixed;

class TurnedOnDevicesPowerCalculator {
    public static void main(String args[]) {
        //System.out.println("The summ power of turned on devices is " + calculate(createDevices()) + " Wt");
    }

/*    private static ArrayList<AbstractElectronicDevice> createDevices() {
        ArrayList<AbstractElectronicDevice> devices = new ArrayList<AbstractElectronicDevice>();

        devices.add(new Headphones(10, "Sony", "black", true, 100, 0, "gamer"));
        devices.add(new Dynamics(1000, "Sony", "black", false, 100, 0, "wood"));
        devices.add(new Camera(1000, "Sony", "black", true, 4, 10, "AAA"));
        devices.add(new Display(700, "Sony", "black", true, 24, 10, 100));
        return devices;
    }

    private static int calculate(ArrayList<AbstractElectronicDevice> devices) {
        int powerSum = 0;
        for(AbstractElectronicDevice device: devices) {
            if(device.isTurnedOn()) {
                powerSum += device.getPower();
            }
        }
        return powerSum;
    }*/
}