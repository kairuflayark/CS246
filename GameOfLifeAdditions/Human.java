package macbeth;

import java.awt.*;
import java.util.Random;

/**
 * Defines a Human which is a creature that is aggresive, is aware of its surroundings, can move
 * can spawn, and can grow things.
 *
 * @author Chad Macbeth (CS246 Prove-02-Stretch)
 */
public class Human extends Creature implements Aggressor, Aware, Movable, Spawner, Grower {
    private Direction direction;
    private Random random;

    /**
     * Create a Human moving up with initial health.
     */
    public Human() {

        random = new Random();

        direction = Direction.Up;

        _health = 10; // Initial Health
    }

    /**
     * Humans are circles.
     *
     * @return {$Link Shape} of humans
     */
    public Shape getShape() {
        return Shape.Circle;
    }

    /**
     * Humans are orange.
     *
     * @return {$Link Color} of humans.
     */
    public Color getColor() {
        return Color.orange;
    }

    /**
     * Get health status of the human.
     * Humans are only alive when their health is positive.
     *
     * @return alive
     */
    public Boolean isAlive() {
        return (_health > 0);
    }

    /**
     * Human will move one square at a time based on their
     * current preferred direction.
     */
    public void move() {
        if (direction == Direction.Up) {
            _location.y--;
        } else if (direction == Direction.Right) {
            _location.x++;
        } else if (direction == Direction.Down) {
            _location.y++;
        } else if (direction == Direction.Left) {
            _location.x--;
        }
    }

    /**
     * If an animal or wolf is sensed, then the human will move in that direction.
     * If nothing is found, then the human will randomly select a direction to search.
     *
     * @param above The {@link Creature} directly above us.
     * @param below The {@link Creature} directly below us.
     * @param left The {@link Creature} directly to the left of us.
     * @param right The {@link Creature} directly to the right of us.
     */
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        if (above instanceof Animal || above instanceof Wolf) {
            direction = Direction.Up;
        } else if (right instanceof Animal || right instanceof Wolf) {
            direction = Direction.Right;
        } else if (below instanceof Animal || below instanceof Wolf) {
            direction = Direction.Down;
        } else if (left instanceof Animal || left instanceof Wolf) {
            direction = Direction.Left;
        } else {
            switch (random.nextInt(4)) {
                case 0:
                    _location.x++;
                    break;
                case 1:
                    _location.x--;
                    break;
                case 2:
                    _location.y++;
                    break;
                case 3:
                    _location.y--;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Attempt to kill any animal or wolf that is found and Increase health by 10 points.
     * Killing an animal or wolf will only work 50% of the time.
     * Failure to kill will result in loss of 10 points
     *
     * Kill completely any plant that is found and increase health by 2 point.
     *
     * @param target The {@link Creature} we've encounterd.
     */
    public void attack(Creature target) {
        if (target instanceof Animal || target instanceof Wolf) {
            if (random.nextInt(2) != 0) {
                target.takeDamage(target._health);
                _health += 10;
            } else {
                _health -= 10;
            }
        }
        if (target instanceof Plant) {
            target.takeDamage(target._health);
            _health += 2;
        }
    }

    /**
     * If the health of the human > 40, then spawn a new human 20% of the time.
     * The new baby will be to the left.  The health of the human will go back to 10.
     * If no new human, then will return null.
     *
     * @return new {$Link Creature}
     */
    public Creature spawnNewCreature() {
        if (random.nextInt(5) == 0 && _health > 20) {
            Human spawn = new Human();
            spawn.setLocation(new Point(_location.x - 1, _location.y));
            _health = 10;
            return spawn;
        }
        return null;
    }

    /**
     * The human will successfully plant 10% of the time.
     * The new plant will be to the left.
     * If no new plant, then will return null.
     *
     * @return new {$Link Creature}
     */
    public Creature plant() {
        if (random.nextInt(10) == 0)
        {
            Plant plant = new Plant();
            plant.setLocation(new Point(_location.x - 1, _location.y));
            return plant;
        }
        return null;
    }
}
