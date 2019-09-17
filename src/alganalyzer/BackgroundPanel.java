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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;

/**
 * Graphics for utility.
 *
 * @author NTropy
 * @since 9/17/2019
 * @version 9.17.2019
 */
final class BackgroundPanel extends Panel {

    /**
     * Array of x-coordinates and y-coordinates to be checked.
     */
    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    private int[] ycoordsAlg, ycoordsCheck;

    /**
     * Number of x-points.
     */
    private int resolution;

    /**
     * Create a regular Panel.
     */
    BackgroundPanel() {
        super();
    }

    /**
     * Handles drawing of graph.
     *
     * @param g graphics of panel
     */
    @Override
    public void paint(final Graphics g) {
        System.out.println("Drawing");
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(2));
        for (int j = 0; j < resolution - 1; j += 2) {
            g2.drawLine(j, ycoordsAlg[j], j + 1, ycoordsAlg[j + 1]);
        }
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));
        for (int j = 0; j < resolution - 1; j += 2) {
            g2.drawLine(j, ycoordsCheck[j], j + 1, ycoordsCheck[j + 1]);
        }
    }

    /**
     * Set coordinates to be graphed.
     *
     * @param x provided x-coordinates
     * @param y1 provided y-coordinates for algorithm
     * @param y2 provided y-coordinates for check function
     */
    public void setCoords(final int x, final int[] y1, final int[] y2) {
        resolution = x;
        ycoordsAlg = y1;
        ycoordsCheck = y2;
    }
}
