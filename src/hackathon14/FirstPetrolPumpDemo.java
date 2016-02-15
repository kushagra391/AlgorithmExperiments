package hackathon14;/* Authored by Kushagra on 2/14/2016. */

public class FirstPetrolPumpDemo {

    public static void main(String[] args) {
        Pump p1 = new Pump(6, 4);
        Pump p2 = new Pump(3, 6);
        Pump p3 = new Pump(7, 3);

        Pump[] pumps = {p1, p2, p3};
        System.out.println(FirstPetrolPump(pumps));


    }

    private static int FirstPetrolPump(Pump[] pumps) {

        int sum = 0;
        for (Pump p : pumps) {
            int diff = p.petrol - p.distance;
            sum = sum + diff;
        }

        for (int i=0; i<pumps.length; i++) {
            Pump p = pumps[i];
            int diff = p.petrol - p.distance;
            if (diff > sum)
                return i;
        }

        return -1;
    }

    static class Pump {
        int petrol;
        int distance;

        Pump(int p, int d) {
            this.petrol = p;
            this.distance = d;
        }
    }

}
