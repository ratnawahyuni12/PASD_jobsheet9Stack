import java.util.Scanner;

public class SuratDemo20 {
    public static void main(String[] args) {

        StackSurat20 stack = new StackSurat20(10);

        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu: ");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat                                     : ");
                    String idSurat = scan.nextLine();
                    System.out.print("Nama Mahasiswa                               : ");
                    String nama = scan.nextLine();
                    System.out.print("Kelas                                        : ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S=Sakit / I=Izin Keperluan Lain) : ");
                    char jenisIzin = scan.nextLine().charAt(0);
                    System.out.print("Durasi (hari)                                : ");
                    int durasi = scan.nextInt();
                    scan.nextLine();

                    Surat20 surat = new Surat20(idSurat, nama, kelas, jenisIzin, durasi);
                    stack.push(surat);
                    System.out.println("Surat Izin " + nama + " berhasil diterima.");
                    break;
                case 2:
                    Surat20 diproses = stack.pop();
                    if (diproses != null) {
                        String jenisStr = (diproses.jenisIzin == 'S' || diproses.jenisIzin == 's') ? "Sakit" : "Izin Keperluan Lain";
                        System.out.println("Memproses surat dari : " + diproses.namaMahasiswa);
                        System.out.println("Kelas                : " + diproses.kelas);
                        System.out.println("Jenis Izin           : " + jenisStr);
                        System.out.println("Durasi               : " + diproses.durasi + " hari");
                        System.out.println("Surat berhasil diverifikasi.");
                    }
                    break;
                case 3:
                    Surat20 terakhir = stack.peek();
                    if (terakhir != null) {
                        String jenisStr = (terakhir.jenisIzin == 'S' || terakhir.jenisIzin == 's') ? "Sakit" : "Izin Keperluan Lain";
                        System.out.println("Surat terakhir masuk : ");
                        System.out.println("ID Surat             : " + terakhir.idSurat);
                        System.out.println("Nama Mahasiswa       : " + terakhir.namaMahasiswa);
                        System.out.println("Kelas                : " + terakhir.kelas);
                        System.out.println("Jenis Izin           : " + jenisStr);
                        System.out.println("Durasi               : " + terakhir.durasi + " hari");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String cari = scan.nextLine();
                    stack.cariSurat(cari);
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 5);
        scan.close();
    }
}