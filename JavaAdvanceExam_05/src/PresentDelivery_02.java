import java.util.*;

public class PresentDelivery_02 {
    public static int santaPresents;
    public static int giftedPresents;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        santaPresents = scan.nextInt();
        scan.nextLine();
        int size = scan.nextInt();
        scan.nextLine();

        char[][] neighborhood = new char[size][size];
        int rowSanta = -1;
        int colSanta = -1;
        int totalNiceKid = 0;
        int  notNiceKid = 0;

        for (int i = 0; i < size; i++) {
            String dataInput = scan.nextLine().replaceAll(" ", "");
            neighborhood[i] = dataInput.toCharArray();
            if (dataInput.contains("S")) {
                colSanta = dataInput.indexOf('S');
                rowSanta = i;
                neighborhood[rowSanta][colSanta] = '-';
            }

            for (int j = 0; j < dataInput.length(); j++) {
                if (dataInput.charAt(j) == 'V') {
                    totalNiceKid++;
                } else if(dataInput.charAt(j)=='X'){
                    notNiceKid++;
                }
            }
        }
        boolean isOutside = false;
        String comand;
        while (!"Christmas morning".equals(comand = scan.nextLine())) {
            switch (comand) {
                case "up":
                    if (rowSanta - 1 >= 0) {
                        rowSanta--;
                    } else {
                        isOutside = true;
                    }
                    break;
                case "down":
                    if (rowSanta + 1 < size) {
                        rowSanta++;
                    } else {
                        isOutside = true;
                    }
                    break;
                case "right":
                    if (colSanta + 1 < size) {
                        colSanta++;
                    } else {
                        isOutside = true;
                    }
                    break;
                case "left":
                    if (colSanta - 1 >= 0) {
                        colSanta--;
                    } else {
                        isOutside = true;
                    }
                    break;
            }
            if (isOutside) {
                break;
            }

            if (neighborhood[rowSanta][colSanta] == 'V') {
                santaPresents--;
                neighborhood[rowSanta][colSanta] = '-';
                giftedPresents++;
            }

            if (neighborhood[rowSanta][colSanta] == 'C') {
                //Left
                if ("XV".contains("" + neighborhood[rowSanta][colSanta - 1])) {
                    giveGiftsToAll(neighborhood, rowSanta, colSanta - 1);
                }
                //Right
                if (colSanta + 1 < size && "XV".contains("" + neighborhood[rowSanta][colSanta + 1])) {
                    giveGiftsToAll(neighborhood, rowSanta, colSanta + 1);
                }
                //UP
                if (rowSanta - 1 >= 0 && "XV".contains("" + neighborhood[rowSanta - 1][colSanta])) {
                    giveGiftsToAll(neighborhood, rowSanta - 1, colSanta);
                }
                //Down
                if (rowSanta + 1 < size && "XV".contains("" + neighborhood[rowSanta + 1][colSanta])) {
                    giveGiftsToAll(neighborhood, rowSanta + 1, colSanta);
                }
            }

            if (santaPresents <= 0) {
                break;
            }

            if (neighborhood[rowSanta][colSanta] == 'X') {
                neighborhood[rowSanta][colSanta] = '-';
            }
        }
        neighborhood[rowSanta][colSanta] = 'S';

        int niceKidsWithoutPresents = 0;
        for (char[] chars : neighborhood) {
            for (char aChar : chars) {
                if (aChar == 'V') {
                    niceKidsWithoutPresents++;
                }
            }
        }

        if (santaPresents <= 0 && giftedPresents-notNiceKid<totalNiceKid) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(neighborhood);

        if (niceKidsWithoutPresents == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", totalNiceKid);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n", niceKidsWithoutPresents);
        }
    }

    private static void giveGiftsToAll(char[][] neighborhood, int xSanta, int ySanta) {
        if (santaPresents > 0) {
            neighborhood[xSanta][ySanta] = '-';
            santaPresents--;
            giftedPresents++;
        }
    }

    private static void printMatrix(char[][] neighborhood) {
        for (char[] chars : neighborhood) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}