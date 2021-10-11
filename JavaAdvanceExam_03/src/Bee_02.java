import java.util.Scanner;

public class Bee_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        int beeRow = 0;
        int beeCol = 0;

//        FIND POSITION OF BEE
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char currentPosition = matrix[row][col];
                if (currentPosition == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        int  pollinateNeeded = 5;
        int pollinate = 0;
        while (!command.equals("End")) {
            switch (command) {

                case "up":
                    int nextStepUp = beeRow-1;
                    if (isOutOfBound(matrix,nextStepUp,beeCol)){
                        System.out.println("The bee got lost!");
                        matrix[beeRow][beeCol] = '.';
                        if(pollinate<pollinateNeeded){
                            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more",pollinateNeeded-pollinate);
                            System.out.println();
                            printMatrix(matrix);
                        }else {
                            System.out.printf("Great job, the bee manage to pollinate %d flowers!",pollinate);
                            System.out.println();
                            printMatrix(matrix);
                        }
                    }else {
                        if(matrix[nextStepUp][beeCol] == 'f'){
                            matrix[nextStepUp][beeCol] = 'B';
                            pollinate++;
                            matrix[beeRow][beeCol] = '.';
                            beeRow = nextStepUp;
                        }else if(matrix[nextStepUp][beeCol]=='O'){
                            matrix[nextStepUp][beeCol] = '.';
                            nextStepUp-=1;
                            matrix[beeRow][beeCol] = '.';
                            if(matrix[nextStepUp][beeCol]== 'f'){
                                matrix[nextStepUp][beeCol] = 'B';
                                pollinate++;
                                beeRow = nextStepUp;
                            }else {
                                matrix[nextStepUp][beeCol] = 'B';
                                beeRow = nextStepUp;
                            }
                        }else {
                            matrix[nextStepUp][beeCol] = 'B';
                            matrix[beeRow][beeCol]= '.';
                            beeRow = nextStepUp;
                        }
                    }
                    break;
                case "down":
                    int nextStepDown = beeRow+1;
                    if (isOutOfBound(matrix,nextStepDown,beeCol)){
                        System.out.println("The bee got lost!");
                        matrix[beeRow][beeCol] = '.';
                        if(pollinate<pollinateNeeded){
                            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more",pollinateNeeded-pollinate);
                            System.out.println();
                            printMatrix(matrix);
                            return;
                        }else {
                            System.out.printf("Great job, the bee manage to pollinate %d flowers!",pollinate);
                            System.out.println();
                            printMatrix(matrix);
                            return;
                        }
                    }else {
                        if(matrix[nextStepDown][beeCol] == 'f'){
                            matrix[nextStepDown][beeCol] = 'B';
                            pollinate++;
                            matrix[beeRow][beeCol] = '.';
                            beeRow = nextStepDown;
                        }else if(matrix[nextStepDown][beeCol]=='O'){
                            matrix[nextStepDown][beeCol] = '.';
                            nextStepDown+=1;
                            matrix[beeRow][beeCol] = '.';
                            if(matrix[nextStepDown][beeCol]== 'f'){
                                matrix[nextStepDown][beeCol] = 'B';
                                pollinate++;
                                beeRow = nextStepDown;
                            }else {
                                matrix[nextStepDown][beeCol] = 'B';
                                beeRow = nextStepDown;
                            }
                        }else {
                            matrix[nextStepDown][beeCol] = 'B';
                            matrix[beeRow][beeCol]= '.';
                            beeRow = nextStepDown;
                        }
                    }
                    break;
                case "left":
                    int nextStepLeft = beeCol-1;
                    if (isOutOfBound(matrix,beeRow,nextStepLeft)){
                        System.out.println("The bee got lost!");
                        matrix[beeRow][beeCol] = '.';
                        if(pollinate<pollinateNeeded){
                            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more",pollinateNeeded-pollinate);
                            System.out.println();
                            printMatrix(matrix);
                            return;
                        }else {
                            System.out.printf("Great job, the bee manage to pollinate %d flowers!",pollinate);
                            System.out.println();
                            printMatrix(matrix);
                            return;
                        }
                    }else {
                        if(matrix[beeRow][nextStepLeft] == 'f'){
                            matrix[beeRow][nextStepLeft] = 'B';
                            pollinate++;
                            matrix[beeRow][beeCol] = '.';
                            beeCol = nextStepLeft;
                        }else if(matrix[beeRow][nextStepLeft]=='O'){
                            matrix[beeRow][nextStepLeft] = '.';
                            nextStepLeft-=1;
                            matrix[beeRow][beeCol] = '.';
                            if(matrix[beeRow][nextStepLeft]== 'f'){
                                matrix[beeRow][nextStepLeft] = 'B';
                                pollinate++;
                                beeCol = nextStepLeft;
                            }else {
                                matrix[beeRow][nextStepLeft] = 'B';
                                beeCol = nextStepLeft;
                            }
                        }else {
                            matrix[beeRow][nextStepLeft] = 'B';
                            matrix[beeRow][beeCol]= '.';
                            beeCol = nextStepLeft;
                        }
                    }
                    break;
                case "right":
                    int nextStepRight = beeCol+1;
                    if (isOutOfBound(matrix,beeRow,nextStepRight)){
                        System.out.println("The bee got lost!");
                        matrix[beeRow][beeCol] = '.';
                        if(pollinate<pollinateNeeded){
                            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more",pollinateNeeded-pollinate);
                            System.out.println();
                            printMatrix(matrix);
                            return;
                        }else {
                            System.out.printf("Great job, the bee manage to pollinate %d flowers!",pollinate);
                            System.out.println();
                            printMatrix(matrix);
                            return;
                        }
                    }else {
                        if(matrix[beeRow][nextStepRight] == 'f'){
                            matrix[beeRow][nextStepRight] = 'B';
                            pollinate++;
                            matrix[beeRow][beeCol] = '.';
                            beeCol = nextStepRight;
                        }else if(matrix[beeRow][nextStepRight]=='O'){
                            matrix[beeRow][nextStepRight] = '.';
                            nextStepRight+=1;
                            matrix[beeRow][beeCol] = '.';
                            if(matrix[beeRow][nextStepRight]== 'f'){
                                matrix[beeRow][nextStepRight] = 'B';
                                pollinate++;
                                beeCol = nextStepRight;
                            }else {
                                matrix[beeRow][nextStepRight] = 'B';
                                beeCol = nextStepRight;
                            }
                        }else {
                            matrix[beeRow][nextStepRight] = 'B';
                            matrix[beeRow][beeCol]= '.';
                            beeCol = nextStepRight;
                        }
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        if(pollinate<pollinateNeeded){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more",pollinateNeeded-pollinate);
            System.out.println();
            printMatrix(matrix);

        }else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!",pollinate);
            System.out.println();
            printMatrix(matrix);
        }


    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean isOutOfBound(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
