/*
 * Copyright (C) 2019 Ryan Castelli <ryancastelli@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package alganalyzer;

/**
 * Stores functions for analysis.
 *
 * @author NTropy
 * @since 9/17/2019
 * @version 9.17.2019
 */
public class Functions {

    /**
     * Counts how many times algorithm has run.
     */
    private static int algCounter = 0;

    /**
     * Default constructor.
     */
    public Functions() { }

    /**
     * Function to check algorithm against.
     * @param x x-coordinate
     * @return relevant y-coordinate
     */
    public final int compareFxn(final int x) {
        return (int) Math.pow(x, 2);
    }

    /**
     * Test algorithm.
     * @param n relevant input
     */
    public final void algorithm(final int n) {
        int x = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                x++;
                algCounter++;
            }
        }
    }

    /**
     * Query the number of times the algorithm has run.
     * @return number of iterations of algorithm.
     */
    public final int getCount() {
        return algCounter;
    }

    /**
     * Reset algorithm counter for a new test round.
     */
    public final void resetCount() {
        algCounter = 0;
    }
}
