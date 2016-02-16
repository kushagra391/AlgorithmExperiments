package indeed;

import java.io.IOException;

public class Solution3 {

    public static void main(String[] args) throws IOException {

        /*
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("s3_input.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _commands;
        try {
            _commands = in.nextLine();
        } catch (Exception e) {
            _commands = null;
        }

        res = doesCircleExist(_commands);
        bw.write(res);
        bw.newLine();

        bw.close();
        */

        String command = "GRGL";
        System.out.println(doesCircleExist(command));
    }

    private static String doesCircleExist(String commands) {

        String cmd = commands;
        String cmd4 = commands + commands + commands + commands + commands;

        State state1 = new State();
        State set1 = state1.executeCommand(cmd);
        State state5 = new State();
        State set5 = state5.executeCommand(cmd4);

        if (set1.equals(set5))
            return "YES";
        else
            return "NO";
    }

    @SuppressWarnings("Duplicates")
    private static class State {

        public boolean equals(State otherState) {

            State state = this;

            return state.location.x == otherState.location.y && state.location.y == otherState
                    .location.y;
        }


        public State executeCommand(String cmd) {

            State start = this;
            State newState = new State();
            for (char command : cmd.toCharArray()) {
                newState = move(start, command);
                start = newState;
            }

            return newState;
        }

        private State move(State state, char command) {

            Direction currentDirection = state.direction;
            Location currentLocation = state.location;

            State newState = new State();
            switch (command) {
                case 'G':
                    newState.direction = currentDirection;
                    newState.location = moveOneStep(state);
                    break;
                case 'L':
                    newState.location = currentLocation;
                    newState.direction = turnLeft(state);
                    break;
                case 'R':
                    newState.location = currentLocation;
                    newState.direction = turnRight(state);
                    break;
                default:
                    break;
            }

            return newState;
        }

        private Direction turnRight(State state) {
            Direction direction = state.direction;
            Direction newDirection = Direction.NORTH;
            switch (direction) {
                case NORTH:
                    newDirection = Direction.EAST;
                    break;
                case SOUTH:
                    newDirection = Direction.WEST;
                    break;
                case EAST:
                    newDirection = Direction.SOUTH;
                    break;
                case WEST:
                    newDirection = Direction.NORTH;
                    break;
                default:
                    break;
            }

            return newDirection;
        }

        private Direction turnLeft(State state) {

            Direction direction = state.direction;
            Direction newDirection = Direction.NORTH;
            switch (direction) {
                case NORTH:
                    newDirection = Direction.WEST;
                    break;
                case SOUTH:
                    newDirection = Direction.EAST;
                    break;
                case EAST:
                    newDirection = Direction.NORTH;
                    break;
                case WEST:
                    newDirection = Direction.SOUTH;
                    break;
                default:
                    break;
            }

            return newDirection;

        }

        private Location moveOneStep(State state) {

            Direction direction = state.direction;
            Location location = state.location;

            switch (direction) {
                case NORTH:
                    location.y = location.y + 1;
                    break;
                case SOUTH:
                    location.y = location.y - 1;
                    break;
                case EAST:
                    location.x = location.x + 1;
                    break;
                case WEST:
                    location.x = location.x - 1;
                    break;
                default:
                    break;
            }

            return location;
        }

        public enum Direction {
            NORTH, EAST, SOUTH, WEST
        }

        Direction direction;
        Location location;

        State() {
            this.direction = Direction.NORTH;
            this.location = new Location();
        }
    }

    static private class Location {
        int x;
        int y;

        Location() {
            this.x = 0;
            this.y = 0;
        }

        Location(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
