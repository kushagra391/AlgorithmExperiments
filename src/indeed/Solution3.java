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

        String cmd4;
        cmd4 = commands + commands + commands + commands + commands;

        RobotState robotState1;
        robotState1 = new RobotState();
        RobotState set1;
        set1 = robotState1.run(commands);
        RobotState robotState5;
        robotState5 = new RobotState();
        RobotState set5;
        set5 = robotState5.run(cmd4);

        return set1.equals(set5) ? "YES" : "NO";
    }

    private static class RobotState {

        public boolean equals(RobotState otherRobotState) {
            RobotState robotState;
            robotState = this;
            if (otherRobotState.robotPosition.y == robotState.robotPosition.x) if (robotState.robotPosition.y == otherRobotState
                    .robotPosition.y) return true;
            return false;
        }


        public RobotState run(String cmd) {

            RobotState start;
            start = this;
            RobotState newRobotState;
            newRobotState = new RobotState();
            char[] charArray = cmd.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char command = charArray[i];
                newRobotState = move(start, command);
                start = newRobotState;
            }

            return newRobotState;
        }

        private RobotState move(RobotState robotState, char command) {

            Orientation currentOrientation = robotState.orientation;
            RobotPosition currentRobotPosition = robotState.robotPosition;
            RobotState newRobotState = new RobotState();
            if (command == 'G') {
                newRobotState.orientation = currentOrientation;
                newRobotState.robotPosition = moveOneStep(robotState);

            } else if (command == 'L') {
                newRobotState.robotPosition = currentRobotPosition;
                newRobotState.orientation = turnLeft(robotState);

            } else if (command == 'R') {
                newRobotState.robotPosition = currentRobotPosition;
                newRobotState.orientation = turnRight(robotState);

            } else {
            }

            return newRobotState;
        }

        private Orientation turnRight(RobotState robotState) {
            Orientation orientation = robotState.orientation;
            Orientation newOrientation = Orientation.NORTH;
            if (orientation == Orientation.NORTH) {
                newOrientation = Orientation.EAST;

            } else if (orientation == Orientation.SOUTH) {
                newOrientation = Orientation.WEST;

            } else if (orientation == Orientation.EAST) {
                newOrientation = Orientation.SOUTH;

            } else if (orientation == Orientation.WEST) {
                newOrientation = Orientation.NORTH;

            } else {
            }

            return newOrientation;
        }

        private Orientation turnLeft(RobotState robotState) {

            Orientation orientation = robotState.orientation;
            Orientation newOrientation = Orientation.NORTH;
            if (orientation == Orientation.NORTH) {
                newOrientation = Orientation.WEST;

            } else if (orientation == Orientation.SOUTH) {
                newOrientation = Orientation.EAST;

            } else if (orientation == Orientation.EAST) {
                newOrientation = Orientation.NORTH;

            } else if (orientation == Orientation.WEST) {
                newOrientation = Orientation.SOUTH;

            } else {
            }

            return newOrientation;

        }

        private RobotPosition moveOneStep(RobotState robotState) {

            Orientation orientation = robotState.orientation;
            RobotPosition robotPosition = robotState.robotPosition;

            if (orientation == Orientation.NORTH) {
                robotPosition.y = robotPosition.y + 1;

            } else if (orientation == Orientation.SOUTH) {
                robotPosition.y = robotPosition.y - 1;

            } else if (orientation == Orientation.EAST) {
                robotPosition.x = robotPosition.x + 1;

            } else if (orientation == Orientation.WEST) {
                robotPosition.x = robotPosition.x - 1;

            } else {
            }

            return robotPosition;
        }

        public enum Orientation {
            NORTH, EAST, SOUTH, WEST
        }

        Orientation orientation;
        RobotPosition robotPosition;

        RobotState() {
            this.orientation = Orientation.NORTH;
            this.robotPosition = new RobotPosition();
        }
    }

    static private class RobotPosition {
        int x;
        int y;

        RobotPosition() {
            this.x = 0;
            this.y = 0;
        }

        RobotPosition(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
