package hw2;

import java.util.Random;

public class World {

    private final static Random rand = new Random();
    private final int initialLifeCount = 100;
    private int robotLifeCount;
    private Location robot = null;
    private final Location start;
    private final Location end;
    private final double holeProbability;
    private final double wallProbability;

    enum CellType {
        Wall,
        Corridor;

        @Override
        public String toString() {
            return this == Wall ? "#" : ".";
        }
        //generates a wall or corridor according to wallprobability given.

        static CellType random(double wallProbability) {
            return (rand.nextDouble() < wallProbability ? Wall : Corridor);
        }
    }

    private final CellType[][] cells;

    World(int width, int height, double holeProbability, double wallProbability, Location start, Location end) {
        this.holeProbability = holeProbability;
        this.wallProbability = wallProbability;
        this.start = start;
        this.end = end;

        cells = new CellType[height][width];

        restartTheWorld();
    }

    void restartTheWorld() {
        createRandomMaze(holeProbability, wallProbability);
        rebootTheRobot();
    }

    void createRandomMaze(double holeProbability, double wallProbability) {
        for (int y = 0; y < cells.length; y++) {
            CellType[] row = cells[y];

            for (int x = 0; x < row.length; x++) {
                if (start.equals(x, y) || end.equals(x, y)) {
                    row[x] = CellType.Corridor;
                } else {
                    if (rand.nextDouble() > holeProbability) {
                        row[x] = CellType.random(wallProbability);
                    } 
                    //else generate hole
                    else {
                        row[x] = null;
                    }
                }
            }
        }
    }

    int getArea() {
        return cells.length * cells[0].length;
    }

    void rebootTheRobot() {
        robotLifeCount = initialLifeCount;

        this.robot = new Location(start);
    }

    boolean isRobotDead() {
        return (robotLifeCount <= 0);
    }

    boolean isRobotAtStart() {
        return !isRobotDead() && robot.equals(start);
    }

    boolean isRobotAtEnd() {
        return !isRobotDead() && robot.equals(end);
    }

    CellType robotAt() {
        return robot == null ? null : cells[robot.getY()][robot.getX()];
    }

    void moveRobotRandomly() {
        int deltaX, deltaY;
        do {
            deltaX = rand.nextInt(-1, 2);
            deltaY = rand.nextInt(-1, 2);
        } while (Math.abs(deltaX) + Math.abs(deltaY) != 1);

        int newX = robot.getX() + deltaX;
        int newY = robot.getY() + deltaY;

        boolean canMove = (newY >= 0 && newY < cells.length
                && newX >= 0 && newX < cells[newY].length
                && cells[newY][newX] != CellType.Wall);
        if (canMove) {
            robot.setX(newX);
            robot.setY(newY);
            //if it is hole:
            if (cells[robot.getY()][robot.getX()] == null) {
                robotLifeCount--;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < cells.length; y++) {
            CellType[] row = cells[y];

            for (int x = 0; x < row.length; x++) {
                if (robot != null && robot.equals(x, y)) {
                    sb.append("*");
                } else {
                    if (row[x] == null) {
                        sb.append("x");
                    } else {
                        if (start.equals(x, y)) {
                            sb.append("S");
                        } else if (end.equals(x, y)) {
                            sb.append("E");
                        } else {
                            sb.append(row[x]);
                        }
                    }
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
