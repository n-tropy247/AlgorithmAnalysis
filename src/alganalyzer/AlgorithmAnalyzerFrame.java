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

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Provides a visual to verify asymptotic analysis of algorithms.
 *
 * @author NTropy
 * @since 9/17/2019
 * @version 9.17.2019
 */
final class AlgorithmAnalyzerFrame extends JPanel {

    /**
     * Window dimensions.
     */
    private static final int WIN_WIDTH = 1000, WIN_HEIGHT = 800;

    /**
     * Graph resolution.
     */
    private static final int RES = 1000;

    /**
     * Graphics container.
     */
    private static final BackgroundPanel BGP = new BackgroundPanel();

    /**
     * Visual frame of analysis utility.
     */
    AlgorithmAnalyzerFrame() {
        init();
    }

    /**
     * Initialize frame settings.
     */
    private void init() {
        setFocusable(true);
        setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        BGP.setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        add(BGP);
        graph();
    }

    /**
     * Produce coordinates for each graph piece.
     */
    private void graph() {
        System.out.println("Computing...");
        int[] yComp = new int[RES];
        int[] yAlg = new int[RES];
        Functions analysisFxn = new Functions();
        for (int j = 0; j < RES; j++) {
            yComp[j] = -Math.abs(analysisFxn.compareFxn(j));
            analysisFxn.resetCount();
            analysisFxn.algorithm(j);
            yAlg[j] = -Math.abs(analysisFxn.getCount());
        }
        int firstYAlg = yAlg[0];
        int firstYComp = yComp[0];
        for (int j = 0; j < RES; j++) {
            yAlg[j] -= firstYAlg;
            yAlg[j] += WIN_HEIGHT;
            yComp[j] -= firstYComp;
            yComp[j] += WIN_HEIGHT;
        }
        BGP.setCoords(RES, yAlg, yComp);
        BGP.repaint();
        System.out.println("Computation Complete.");
    }
}
