package com.next.pong.game.ball;

import com.next.pong.game.physics.Collision;
import com.next.pong.game.physics.Kinematic;
import com.next.pong.utils.Vector2;

public class Ball {

    private final double radius;
    private Vector2 position;
    private Vector2 speed;

    public Ball(Vector2 position, Vector2 speed, double radius) {
        this.radius = radius;
        this.position = position;
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public Vector2 getPosition() {
        return position;
    }
    public Vector2 getSpeed() {
        return new Vector2(speed.x(), speed.y());
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setSpeed(double angle) {
        speed = new Vector2(Math.cos(angle), Math.sin(angle)).scalar(speed.norm());
    }

    public double getSpeedAngle() {
        return Math.atan2(speed.y(), speed.x()) + 2 * Math.PI;
    }

    public void flipSpeedX() {
        speed = new Vector2(-speed.x(), speed.y());
    }

    public void flipSpeedY() {
        speed = new Vector2(speed.x(), -speed.y());
    }

    public void integratePosition(double deltaTime) {
        position = Kinematic.integrate(deltaTime, position, speed);
    }

    public Collision.Boundary getBoundary() {
        return new Collision.Boundary(position, new Vector2(radius, radius));
    }

}
