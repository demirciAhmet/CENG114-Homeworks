package hw2;

public class RandomMazeSolver {

    //there is a robot tries to reach end by moving randomly. 
    //If it crosses holes, the lifecount decreases,
    //when lifecount reaches 0, it dies.
    //If it reaches end, it succeeds.
    //If it neither dies nor succeeds, it fails.
    RandomMazeSolver() {

    }

    static SolverResult solve(World world, int experimentCount) {
        SolverResult solverResult = new SolverResult();

        int trialFactor = 100;
        int maximumTrialCount = trialFactor * world.getArea();

        for (int i = 0; i < experimentCount; i++) {
            if (i % 256 == 0) {
                //prints a dot on the console every 256 iterations of the for loop to check progress.
                System.out.print(".");
            }

            executeExperiment(world, maximumTrialCount);

            if (world.isRobotDead()) {
                solverResult.incrementDead();
            } else {
                if (world.isRobotAtEnd()) {
                    solverResult.incrementSuccess();
                } else {
                    solverResult.incrementFailure();
                }
            }
            world.restartTheWorld();
        }

        System.out.println("\n");

        return solverResult;
    }

    //gives one of the following results:
    //robot dead
    //robot is at the end
    //robot is somewere else
    static void executeExperiment(World world, int maximumTrialCount) {
        // student code
        while (!world.isRobotDead() && !world.isRobotAtEnd()) {
            world.moveRobotRandomly();
            maximumTrialCount--;
            if (maximumTrialCount <= 0) {
                break;
            }
        }
    }

}
