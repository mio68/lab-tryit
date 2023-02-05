package mio68.lab.tryit.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// codewars https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7/train/java
public class BattleField {

    public static boolean fieldValidator(int[][] field) {
        Field f = new Field(field);
        Map<Ship, Integer> counterByShip = new HashMap<>();
        // scan
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                if (f.isDiagonalCollisionAt(row, col)) {
                    return false;
                }

                if (f.isLineStartFrom(row, col)) {
                    Optional<Ship> ship = Ship.getShipByLength(f.getLineLengthFrom(row, col));
                    if (ship.isEmpty()) {
                        return false; // length doesn't match any ship
                    }
                    // count the ship
                    counterByShip.compute(ship.get(),
                            (ship1, count) -> count == null ? 1 : count + 1);
                    if (isQuotaExceeded(counterByShip)) {
                        return false;
                    }

                }
            }
        }
        return isQuotaUsedCorrectly(counterByShip);
    }

    private static boolean isQuotaUsedCorrectly(Map<Ship, Integer> counterByShip) {
        return counterByShip.size() == Ship.values().length &&
                counterByShip.entrySet()
                        .stream()
                        .allMatch(entry -> entry.getValue() == entry.getKey().quota);
    }

    private static boolean isQuotaExceeded(Map<Ship, Integer> counterByShip) {
        return counterByShip.entrySet()
                .stream()
                .anyMatch(entry -> entry.getValue() > entry.getKey().quota);
    }

    private enum Ship {
        SUBMARINE(1, 4),
        DESTROYER(2, 3),
        CRUISER(3, 2),
        BATTLESHIP(4, 1);

        private final int length;
        private final int quota;

        Ship(int length, int quota) {
            this.length = length;
            this.quota = quota;
        }

        static Optional<Ship> getShipByLength(int len) {
            return Arrays.stream(Ship.values())
                    .filter(ship -> ship.length == len)
                    .findAny();
        }
    }

    private static class Field {
        private final int[][] field;
        private final int size;

        Field(int[][] field) {
            this.field = field;
            this.size = field.length;
        }

        int getLineLengthFrom(int row, int col) {
            boolean horizontalDirection = isHorizontalLineStartFrom(row, col);
            int len = 0;
            if (horizontalDirection) {
                while (isOccupied(row, col++)) len++;
            } else {
                while (isOccupied(row++, col)) len++;
            }
            return len;
        }

        boolean isLineStartFrom(int row, int col) {
            return isHorizontalLineStartFrom(row, col) || isVerticalLineStartFrom(row, col);
        }

        boolean isHorizontalLineStartFrom(int row, int col) {
            return isEmpty(row, col - 1) && isOccupied(row, col)
                    && isEmpty(row - 1, col) && isEmpty(row + 1, col);
        }

        boolean isVerticalLineStartFrom(int row, int col) {
            return isEmpty(row - 1, col) && isOccupied(row, col)
                    && isEmpty(row, col - 1) && isEmpty(row, col + 1);
        }

        boolean isDiagonalCollisionAt(int row, int col) {
            return isOccupied(row, col)
                    && (isOccupied(row + 1, col - 1) || isOccupied(row + 1, col + 1));
        }

        boolean isOccupied(int row, int col) {
            return !isEmpty(row, col);
        }

        boolean isEmpty(int row, int col) {
            if (row >= 0 && row < size && col >= 0 && col < size) {
                return field[row][col] == 0;
            }
            return true;
        }
    }
}