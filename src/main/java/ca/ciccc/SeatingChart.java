package ca.ciccc;

import java.util.List;

public class SeatingChart {

    /**
     * seats[r][c] represents the Student in row r and column c in the classroom.
     */
    private Student[][] seats;

    /**
     * Creates a seating chart with the given number of rows and columns from the
     * students in {@code studentList}. Empty seats in the seating chart are represented
     * by {@code null}.
     * @param studentList the list of students.
     * @param rows the number of rows of seats in the classroom.
     * @param cols the number of columns of seats in the classroom.
     *
     * Pre-condition: rows > 0; cols > 0;
     *               rows * cols >= studentList.size();
     *
     * Post-condition:
     *             - Students appear in the seating chart in the same order as they appear
     *               in {@code studentList}, starting at {@code seats[0][0]}.
     *             - {@code seats} is filled column by column from {@code studentList}, followed by
     *               any empty seats (represented by {@code null}.
     *             - {@code studentList} is unchanged.
     */
    public SeatingChart(List<Student> studentList, int rows, int cols) {
        // TODO: Your code goes here.
        int row = 0;
        int col = 0;
        this.seats = new Student[rows][cols];
        for (int i = 0; i< studentList.size(); i++){
            this.seats[row][col] = studentList.get(i);
//            System.out.printf("[%d]: this.seats[%d][%d] %s%n", i, cntRow, cntCol, studentList.get(i));
            if (row >= rows -1) {
                row = 0;
                col++;
            } else {
                row++;
            }
        }
    }

    /**
     * Removes students who have more than a given number of absences from the seating chart,
     * replacing those entries in the seating chart with {@code null} and returns the number of
     * students removed.
     *
     * @param allowedAbsences an integer >= 0
     * @return the number of students removed from {@code seats}.
     *
     * Pre-condition:
     *   - All students with {@code allowedAbsences} or fewer are in their original positions in
     *     {@code seats}.
     *   - No student in {@code seats} has more than {@code allowedAbsences} absences.
     *   - Entries without students contain {@code null}.
     */
    public int removeAbsentStudents(int allowedAbsences) {
        // TODO: your code goes here.
        int cnt = 0;
        for (int r = 0; r < seats.length; r ++) {
            for (int c = 0; c < seats[r].length; c++) {
                if(seats[r][c] != null && seats[r][c].getAbsenceCount() > allowedAbsences) {
//                    System.out.printf("seats[%d][%d] %s%n", r, c, seats[r][c]);
                    seats[r][c] = null;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        String result = "";
        for(Student[] row: seats) {
            for(Student col: row) {
                result += (col != null) ? col.toString() + " " : "null ";
            }
            result += "\n";
        }
        return result;
    }
}
