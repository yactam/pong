package com.next.pong.game.physics;

import com.next.pong.utils.Vector2;

public class Collision {

    public record Boundary(Vector2 center, Vector2 size) {

        public double left() {
            return center.x() - 0.5 * size.x();
        }

        public double right() {
            return center.x() + 0.5 * size.x();
        }

        public double bottom() {
            return center.y() - 0.5 * size.y();
        }

        public double top() {
            return center.y() + 0.5 * size.y();
        }

    }

    public static boolean areColliding(Boundary a, Boundary b) {
        return a.left() <= b.right() &&
                a.right() >= b.left() &&
                a.top() >= b.bottom() &&
                a.bottom() <= b.top();
    }

}
