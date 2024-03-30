package org.example.jvm;

public class MethodInliningDemo {

    public static final class Point {

        private int x = 0;

        private int y = 0;

        public int getX() {
            return x;
        }

        private void setXInside(int x) {
            this.x = x;
        }

        public void setX(int x) {
            for (int i = 0; i <= x; i++) {
                setXInside(i);
            }
        }

        public int getY() {
            return y;
        }

        private void setYInside(int y) {
            this.y = y;
        }

        public void setY(int y) {
            for (int i = 0; i <= y; i++) {
                setYInside(i);
            }
        }

        @Override
        public String toString() {
            return String.format("%s[x=%d, y=%d]", getClass().getSimpleName(), x, y);
        }
    }

    public static Point run(int limit) {
        Point point = new Point();

        for (int j = 0; j < limit; j++) {
            point.setX(point.getX() + j);
            point.setY(point.getY() + j);
        }

        return point;
    }

    public static void main(String[] args) {

        System.out.printf("Running pid: %d %n", ProcessHandle.current().pid());

        // Warmup
        for (int i = 0; i < 10_000; i++) {
            run(100);
        }

        // Test
        long time = System.nanoTime();
        Point point = new Point();
        for (int i = 0; i < 1; i++) {
            point = run(10_000);
        }
        long duration = System.nanoTime() - time;

        System.out.printf("Elapsed time (ms): %d%n", duration / 1_000_000);
        System.out.println(point);
    }
}
