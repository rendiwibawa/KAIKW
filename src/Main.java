import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        
        do {
            clearScreen();
            System.out.println("       SELAMAT DATANG DI KAIKW ");
            LocalDate Date = LocalDate.now(); // Create a date object
            LocalTime Time = LocalTime.now(); // Create a date object

            System.out.println("====================================");
            System.out.println("| Date Now : " + Date +" | "+ Time.getHour()+":"+Time.getMinute()+ " WIB |");
            System.out.println("====================================");
            System.out.println("1. Cek jadwal kereta"); // ngeprint
            System.out.println("2. Pemesanan tiket"); // Pesen
            System.out.println("3. Cetak tiket"); 
            System.out.println("4. Exit");
            System.out.print(">> ");
            menu = scan.nextInt();

            switch(menu){
                case 1:
                    Load_Animate.animate(5);
                    System.out.println();
                    Jadwal jadwal = new Jadwal(null, null);

                    jadwal.inisialData();
                    jadwal.lihatJadwal();

                    promptEnterKey();
                    break;
                case 2:
                    System.out.println("PESAN TIKET");
                    promptEnterKey();
                    break;
                case 3:
                    System.out.println("CETAK TIKET");
                    promptEnterKey();
                    break;

            }
                 
        } while (menu != 4);
        System.out.println("Thanks :3");
        
        scan.close();
    }

    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        
        scanner.close();
     }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}


class Load_Animate
{
    static byte anime;
    static void animate(int i)
    {
        try
        {
            for(int j = 0 ; j<=100 ; j++)
            {
                switch(anime)
                {
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
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    } 
}


