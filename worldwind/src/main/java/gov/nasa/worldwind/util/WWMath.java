/*
 * Copyright (c) 2016 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration. All Rights Reserved.
 */

package gov.nasa.worldwind.util;

/**
 * Collection of static methods for performing common World Wind computations.
 */
public class WWMath {

    /**
     * Restricts an angle to the range [0, 360] degrees, clamping angles outside the range. Angles less than 0 are
     * returned as 0, and angles greater than 360 are returned as 360. Angles within the range are returned unmodified.
     *
     * @param degrees the angle to clamp in degrees
     *
     * @return the specified angle clamped to the range [0, 360] degrees
     */
    public static double clampDegrees(double degrees) {
        return degrees > 360 ? 360 : (degrees < 0 ? 0 : degrees);
    }

    /**
     * Restricts an angle to the range [0, 360] degrees, wrapping angles outside the range. Wrapping takes place as
     * though traversing the edge of a unit circle; angles less than 0 wrap back to 360, while angles greater than 360
     * wrap back to 0.
     *
     * @param degrees the angle to wrap in degrees
     *
     * @return the specified angle wrapped to [0, 360] degrees
     */
    public static double normalizeDegrees(double degrees) {
        double angle = degrees % 360;
        return angle >= 0 ? angle : (angle < 0 ? 360 + angle : 360 - angle);
    }

    /**
     * Indicates whether a specified value is a power of two.
     *
     * @param value the value to test
     *
     * @return true if the specified value is a power of two, false othwerwise
     */
    public static boolean isPowerOfTwo(int value) {
        return value != 0 && (value & (value - 1)) == 0;
    }
}