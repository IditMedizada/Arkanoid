// 318879293 Idit Medizada
package BasicShapes;

import java.util.List;

/**
 * Line class.
 *
 * @author Idit Medizada iditm9@gmail.com
 * @version 1.2 (current version number of program).
 * @since 2022-03-22 (the version of the package this class was first added to).
 */
public class Line {
    private Point startPoint;
    private Point endPoint;

    /**
     * Constructors- with 2 point.
     *
     * @param start Point
     * @param end   Point
     */
    public Line(Point start, Point end) {
        this.startPoint = start;
        this.endPoint = end;
    }

    /**
     * Constructors- with 4 values.
     * Creates 2 points.
     *
     * @param x1 x value of the first Point
     * @param y1 y value of the first Point
     * @param x2 x value of the second Point
     * @param y2 y value of the second Point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.startPoint = new Point(x1, y1);
        this.endPoint = new Point(x2, y2);
    }

    /**
     * Getter.
     *
     * @return the start point of the line.
     */
    public Point start() {
        return this.startPoint;
    }

    /**
     * Getter.
     *
     * @return the end point of the line
     */
    public Point end() {
        return this.endPoint;
    }

    /**
     * The function calculating the length of the line.
     *
     * @return the length (double)
     */
    public double length() {
        return this.startPoint.distance(this.endPoint);
    }

    /**
     * Calculating the middle point of a line.
     *
     * @return the middle point
     */
    public Point middle() {
        double middleX = (this.startPoint.getX() + this.endPoint.getX()) / 2;
        double middleY = (this.startPoint.getY() + this.endPoint.getY()) / 2;
        return (new Point(middleX, middleY));
    }

    /**
     * checks if two lines are intersections.
     *
     * @param other line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (!checkSlope(this.startPoint, this.endPoint) && !checkSlope(other.startPoint, other.endPoint)) {
            return noSlopeIntersection(other) != null;
        }
        double slopeFirstLine = slope(this.startPoint, this.endPoint);
        double slopeSecondLine = slope(other.startPoint, other.endPoint);
        double bFirstLine = calculationB(this.startPoint, this.endPoint);
        double bSecondLine = calculationB(other.startPoint, other.endPoint);


        /*Checks if there is an intersection point between line with the same slope and free variable.
         */

        if ((slopeFirstLine == slopeSecondLine) && (bFirstLine == bSecondLine)) {

            if (slopeFirstLine == 0 && slopeSecondLine == 0) {
                if (this.startPoint.equals(other.startPoint) || this.startPoint.equals(other.endPoint)) {
                    return true;
                }
                return this.endPoint.equals(other.startPoint) || this.endPoint.equals(other.endPoint);
            }

            if ((this.startPoint.getY() < other.startPoint.getY())
                    && (this.endPoint.getY() < other.startPoint.getY())) {
                return false;
            }
            return (!(this.startPoint.getY() > other.startPoint.getY()))
                    || (!(this.endPoint.getY() > other.startPoint.getY()));
        }
        // return true if there is an intersection point and false otherwise
        return this.intersectionWith(other) != null;
    }

    /**
     * intersections points.
     *
     * @param other line
     * @return the intersection point if the lines intersect and null otherwise.
     */

    public Point intersectionWith(Line other) {
        Point point;
        double xPoint, yPoint;
        //If the lines are equals.
        if (this.equals(other)) {
            return null;
        }
        //Checks whether the lines have a slope
        boolean isSlope1 = checkSlope(this.startPoint, this.endPoint);
        boolean isSlope2 = checkSlope(other.startPoint, other.endPoint);
        //If the two lines have no slope
        if (!isSlope1 && !isSlope2) {
            return noSlopeIntersection(other);
        }
        //If one of the lines do not have a slope
        if ((!isSlope1 && isSlope2) || (isSlope1 && !isSlope2)) {
            return oneSlopeIntersection(other);
            //If both of the lines have slope
        } else {
            double slopeFirstLine = slope(this.startPoint, this.endPoint);
            double slopeSecondLine = slope(other.startPoint, other.endPoint);
            double bFirstLine = calculationB(this.startPoint, this.endPoint);
            double bSecondLine = calculationB(other.startPoint, other.endPoint);
            if (slopeFirstLine == slopeSecondLine && bFirstLine == bSecondLine) {
                if (minXPoint(this) == maxXPoint(other)) {
                    return new Point(minXPoint(this), this.endPoint.getY());
                }
                if (minXPoint(other) == maxXPoint(this)) {
                    return new Point(minXPoint(other), other.endPoint.getY());

                }
                return null;
            }
            // Parallel or equals lines without intersection point
            if (slopeFirstLine == slopeSecondLine) {
                return null;
            }
            xPoint = (bSecondLine - bFirstLine) / (slopeFirstLine - slopeSecondLine);
            yPoint = (slopeFirstLine * xPoint) + bFirstLine;
        }
        point = new Point(xPoint, yPoint);
        //returns null if the intersection point is not on line1 or on line2
        if ((this.middle().distance(point) > this.middle().distance(this.startPoint))
                || (other.middle().distance(point) > other.middle().distance(other.startPoint))) {
            return null;
        }
        return point;
    }

    /**
     * Checks if two lines are equals.
     *
     * @param other line
     * @return return true if the lines are equal, false otherwise
     * Line represented as y=mx+b
     */

    public boolean equals(Line other) {
        if (this.startPoint.equals(other.startPoint) && this.endPoint.equals(other.endPoint)) {
            return true;
        }
        return this.endPoint.equals(other.startPoint) && this.startPoint.equals(other.endPoint);
    }

    /**
     * Calculate the free variable in a straight equation.
     *
     * @param firstP  the start point of a line
     * @param secondP the end point of a line
     *                Line represented as y=mx+b
     * @return the free variable B
     */
    public double calculationB(Point firstP, Point secondP) {
        double slopeLine = slope(firstP, secondP);
        return (firstP.getY() - (slopeLine * firstP.getX()));
    }

    /**
     * Checks if line has slope.
     *
     * @param firstPoint  the start point of a line
     * @param secondPoint the end point of a line
     * @return true if the line has a slope, false otherwise
     */
    public boolean checkSlope(Point firstPoint, Point secondPoint) {
        return firstPoint.getX() - secondPoint.getX() != 0;
    }

    /**
     * Calculating slope.
     *
     * @param firstPoint  the start point of a line
     * @param secondPoint the end point of a line
     * @return slope of the line
     */
    public double slope(Point firstPoint, Point secondPoint) {
        double yTotal = secondPoint.getY() - firstPoint.getY();
        double xTotal = secondPoint.getX() - firstPoint.getX();
        return (yTotal / xTotal);
    }

    /**
     * calculating the intersection point between to lines without slope.
     *
     * @param other line
     * @return point intersection and null otherwise
     */
    public Point noSlopeIntersection(Line other) {
        if (this.startPoint.getX() == other.startPoint.getX()) {
            if (this.startPoint.equals(other.startPoint) || this.startPoint.equals(other.endPoint)) {
                return this.startPoint;
            }
            if (this.endPoint.equals(other.startPoint) || this.endPoint.equals(other.endPoint)) {
                return this.endPoint;
            }
        }
        return null;
    }

    /**
     * The function return the minimum x number between to points.
     *
     * @param other line
     * @return the value of the minimum x point
     */
    public double minXPoint(Line other) {
        return Math.min(other.startPoint.getX(), other.endPoint.getX());
    }

    /**
     * The function return the maximum x number between to points.
     *
     * @param other line
     * @return the value of the maximum x point
     */
    public double maxXPoint(Line other) {
        return Math.max(other.startPoint.getX(), other.endPoint.getX());
    }

    /**
     * The function return the minimum y number between to points.
     *
     * @param other line
     * @return the value of the minimum y point
     */
    public double minYPoint(Line other) {
        return Math.min(other.startPoint.getY(), other.endPoint.getY());
    }

    /**
     * The function return the maximum y number between to points.
     *
     * @param other line
     * @return the value of the maximum y point
     */
    public double maxYPoint(Line other) {
        return Math.max(other.startPoint.getY(), other.endPoint.getY());
    }

    /**
     * calculating the intersection point between line with slope and line without slope.
     *
     * @param other line
     * @return point intersection and null otherwise
     */
    public Point oneSlopeIntersection(Line other) {
        double xPoint, yPoint;
        //If the second line do not have slope, we calculate the intersection point with the first line
        if (checkSlope(this.startPoint, this.endPoint)) {
            double slopeL1 = slope(this.startPoint, this.endPoint);
            double bFirstLine = calculationB(this.startPoint, this.endPoint);
            xPoint = other.startPoint.getX();
            //If the line Parallel to axis y.
            if (slopeL1 == 0) {
                yPoint = bFirstLine;
            } else {
                yPoint = xPoint * slopeL1 + bFirstLine;
            }
            //Checks if the intersection point is on the lines.
            if (xPoint > maxXPoint(this) || xPoint < minXPoint(this)
                    || yPoint > maxYPoint(other) || yPoint < minYPoint(other)) {
                return null;
            }
            //If the first line do not have slope, we calculate the intersection point with the second line
        } else {
            double slopeL2 = slope(other.startPoint, other.endPoint);
            double bSecondLine = calculationB(other.startPoint, other.endPoint);
            xPoint = this.startPoint.getX();
            //If the line Parallel to axis y.
            if (slopeL2 == 0) {
                yPoint = bSecondLine;
            } else {
                yPoint = xPoint * slopeL2 + bSecondLine;
            }
            //Checks if the intersection point is on the lines.
            if (xPoint > maxXPoint(other) || xPoint < minXPoint(other)
                    || yPoint > maxYPoint(this) || yPoint < minYPoint(this)) {
                return null;
            }

        }
        return new Point(xPoint, yPoint);
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect Rectangle object.
     * @return closest intersection to start of line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> pointList = rect.intersectionPoints(this);
        //if the arrayList is empty
        if (pointList.size() == 0) {
            return null;
        }
        //If there is one point in the arrayList
        if (pointList.size() == 1) {
            return pointList.get(0);
        }
        //If there is more than one point in the arrayList
        if (checkSlope(this.startPoint, this.endPoint)) {
            double pointX = this.startPoint.getX();
            if (Math.abs(pointX - pointList.get(0).getX()) <= Math.abs(pointX - pointList.get(1).getX())) {
                return pointList.get(0);
            }
            return pointList.get(1);
        }
        double pointY = this.startPoint.getY();
        if (Math.abs(pointY - pointList.get(0).getY()) <= Math.abs(pointY - pointList.get(1).getY())) {
            return pointList.get(0);
        }
        return pointList.get(1);
    }
}