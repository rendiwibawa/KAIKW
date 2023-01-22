package Animation;

import java.util.Scanner;

public class Animation {
    public byte anime;

    public void animate(int i) {
        try {
            for (int j = 0; j <= 100; j++) {
                switch (anime) {
                    case 1:
                        System.out.print("\r[ \\ ] :" + j + "%");
                        break;
                    case 2:
                        System.out.print("\r[ | ] :" + j + "%");
                        break;
                    case 3:
                        System.out.print("\r[ / ] :" + j + "%");
                        break;
                    default:
                        anime = 0;
                        System.out.print("\r[ - ] :" + j + "%");
                }
                anime++;
                Thread.sleep(i);
            }
            System.out.println(" Success");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // scanner.close();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
