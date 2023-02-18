package mio68.lab.tryit.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

class PawnMoveTracker {

    public static String[][] movePawns(String[] moves) {
        ChessBoard chessBoard = new ChessBoard();
        for (String moveDescription : moves) {
            if (!chessBoard.move(moveDescription)) {
                return new String[][]{{moveDescription + " is invalid"}};
            }
        }
        return chessBoard.format();
    }

    private static class ChessBoard {
        private final List<Pawn> pawns = new ArrayList<>();
        private Color turnColor = Color.WHITE;

        public ChessBoard() {
            for (char col = 'a'; col <= 'h'; col++) {
                pawns.add(new Pawn(Color.WHITE, new Location(col, '2')));
                pawns.add(new Pawn(Color.BLACK, new Location(col, '7')));
            }
        }

        public String[][] format() {
            String[][] chessBoard = new String[8][8];
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    chessBoard[row][col] = ".";
                }
            }
            pawns.forEach(pawn -> chessBoard['8' - pawn.location.row][pawn.location.col - 'a'] = pawn.getSymbol());
            return chessBoard;
        }

        public boolean move(String mv) {
            boolean result;
            if (mv.contains("x")) {
                Location to = new Location(mv.charAt(2), mv.charAt(3));
                Location from = new Location(mv.charAt(0), turnColor == Color.WHITE ? to.getRowDown() : to.getRowUp());
                result = capture(from, to);
            } else {
                Location to = new Location(mv.charAt(0), mv.charAt(1));
                result = move(to);
            }
            turnColor = turnColor.other();
            return result;
        }

        private boolean move(Location to) {
            Location from = turnColor == Color.WHITE ? to.down() : to.up();
            if (from.isEmpty()) {
                if (turnColor == Color.WHITE && to.row == '4') {
                    from = from.down();
                } else if (turnColor == Color.BLACK && to.row == '5') {
                    from = from.up();
                }
            }
            boolean valid = from.isOccupiedBy(turnColor) && to.isEmpty();
            if (valid) {
                Location location = from;
                pawns.removeIf(pawn -> pawn.location.equals(location));
                pawns.add(new Pawn(turnColor, to));
            }
            return valid;
        }

        private boolean capture(Location from, Location to) {
            boolean valid = from.isOccupiedBy(turnColor) && to.isOccupiedBy(turnColor.other());
            if (valid) {
                pawns.removeIf(pawn -> pawn.location.equals(from) || pawn.location.equals(to));
                pawns.add(new Pawn(turnColor, to));
            }
            return valid;
        }

        private Optional<Pawn> getPawnAt(Location location) {
            return pawns.stream()
                    .filter(pawn -> pawn.location.equals(location))
                    .findAny();
        }

        private class Location {
            final char col; // 'a'-'h'
            final char row; // '1'-'8'

            Location(char col, char row) {
                this.col = col;
                this.row = row;
            }

            boolean isOccupiedBy(Color color) {
                return getPawnAt(this)
                        .map(pawn -> pawn.color == color)
                        .orElse(false);
            }

            boolean isEmpty() {
                return getPawnAt(this).isEmpty();
            }

            Location up() {
                return new Location(col, getRowUp());
            }

            Location down() {
                return new Location(col, getRowDown());
            }

            char getRowUp() {
                return (char) (row + 1);
            }

            char getRowDown() {
                return (char) (row - 1);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Location location = (Location) o;
                return col == location.col && row == location.row;
            }

            @Override
            public int hashCode() {
                return Objects.hash(col, row);
            }
        }

        private static class Pawn {
            private final Color color;
            private final Location location;

            Pawn(Color color, Location location) {
                this.color = color;
                this.location = location;
            }

            String getSymbol() {
                return switch (color) {
                    case WHITE -> "P";
                    case BLACK -> "p";
                };
            }
        }

        private enum Color {
            WHITE, BLACK;

            Color other() {
                return this == WHITE ? BLACK : WHITE;
            }
        }

    }
}
