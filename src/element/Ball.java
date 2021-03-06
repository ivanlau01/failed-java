package element;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 * Created by filippo on 04/09/16...
 *
 */
abstract public class Ball {

    private final Point2D center;
    private Shape ballFace;

    public Point2D up;
    public Point2D down;
    public Point2D left;
    public Point2D right;

    private final Color border;
    private final Color inner;

    private int speedX;
    private int speedY;

    public Ball(Point2D center, float radiusA, float radiusB, Color inner, Color border) {
        this.center = center;

        setUp(new Point2D.Double());
        setDown(new Point2D.Double());
        setLeft(new Point2D.Double());
        setRight(new Point2D.Double());

        getUp().setLocation(center.getX(), center.getY() - (radiusB / 2));
        getDown().setLocation(center.getX(), center.getY() + (radiusB / 2));

        getLeft().setLocation(center.getX() - (radiusA / 2), center.getY());
        getRight().setLocation(center.getX() + (radiusA / 2), center.getY());


        ballFace = makeBall(center, radiusA, radiusB);
        this.border = border;
        this.inner = inner;
        speedX = 0;
        speedY = 0;
    }

    protected abstract Shape makeBall(Point2D center, float radiusA, float radiusB);

    public void move() {
        RectangularShape tmp = (RectangularShape) ballFace;
        center.setLocation((center.getX() + speedX), (center.getY() + speedY));
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() - (w / 2)), (center.getY() - (h / 2)), w, h);
        setPoints(w, h);


        ballFace = tmp;
    }

    public void setSpeed(int x, int y) {
        speedX = x;
        speedY = y;
    }

    public void setXSpeed(int s) {
        speedX = s;
    }

    public void setYSpeed(int s) {
        speedY = s;
    }

    public void reverseX() {
        speedX *= -1;
    }

    public void reverseY() {
        speedY *= -1;
    }

    public Color getBorderColor() {
        return border;
    }

    public Color getInnerColor() {
        return inner;
    }

    public Point2D getPosition() {
        return center;
    }

    public Shape getBallFace() {
        return ballFace;
    }

    public void moveTo(Point p) {
        center.setLocation(p);

        RectangularShape tmp = (RectangularShape) ballFace;
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() - (w / 2)), (center.getY() - (h / 2)), w, h);
        ballFace = tmp;
    }

    private void setPoints(double width, double height) {
        getUp().setLocation(center.getX(), center.getY() - (height / 2));
        getDown().setLocation(center.getX(), center.getY() + (height / 2));

        left.setLocation(center.getX() - (width / 2), center.getY());
        right.setLocation(center.getX() + (width / 2), center.getY());
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public Point2D getUp() {
        return up;
    }

    public void setUp(Point2D up) {
        this.up = up;
    }

    public Point2D getDown() {
        return down;
    }

    public void setDown(Point2D down) {
        this.down = down;
    }

    public Point2D getLeft() {
        return left;
    }

    public void setLeft(Point2D left) {
        this.left = left;
    }

    public Point2D getRight() {
        return right;
    }

    public void setRight(Point2D right) {
        this.right = right;
    }
}

