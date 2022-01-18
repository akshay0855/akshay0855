package HackerRank;

import java.util.List;

public class Collosions {
	
	/*
	 * collision problem:
there are n particles numbered from 0 to n-1 lined up from smallest to largest ID along the x-axis.
the particles are all released simultaneously. once released, each particle travels indefinitely in a straight line along the positive x-axis at a speed.
when two particles collide, the faster particle moves through the slower particles and they both continue moving without changing speed or direction.
write a function that return the number of collision occurring with particle pos.
collision has the following parameters:
speed[speed[0] … speed[n-1]]: an array of speed[i] indication speed of particle i.
pos: index of the particle for which to count collisions.
constraints

1 <= n <= 100000
1 <= speed[i] <= 1000000000
0 <= pos< n
input:
8
6
1
6
3
4
6
8
2

output:
2

explanation:
the particle at pos = 2 will collide with particle 0 and 1 as they pass it from behind.
	 */
	
	public static int collision(List<Integer> speed, int pos) {
        /**
         * (1) Two particles starting at positions x < y will collide iff speed(x) > speed(y).
         * (2) If two particles start at the same position and have the same speed, they
         *     will collide infinite number of times. Otherwise, they will either collide
         *     once or not collide at all.
         * (3) In our case, each particle starts at a unique position, so two particles
         *     can either collide once or not collide at all.
         */

        int count = 0;
        for (int i = 0; i < speed.size(); ++i) {
            count += ((i < pos && speed.get(i) > speed.get(pos)) ||
                        (i > pos && speed.get(i) < speed.get(pos)))
                        ? 1 : 0;
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
