# PASD_jobsheet9Stack

2.1 —— Percobaan 1: Mahasiswa Mengumpulkan Tugas
1. Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi hasil percobaan! Bagian mana yang perlu diperbaiki?
Jawaban: Bug yang perlu diperbaiki ada di MahasiswaDemo20.java case 2 — tambahkan scan.nextLine() setelah scan.nextInt(). Tanpa itu, sisa karakter \n di buffer Scanner menyebabkan input Nama pada case 1 terlewat saat kembali ke menu.
2.	Berapa banyak data tugas mahasiswa yang dapat ditampung di dalam Stack? Tunjukkan potongan kode programnya!
Jawaban: Stack dapat menampung 5 data tugas mahasiswa. Ditunjukkan pada saat instansiasi di MahasiswaDemo20.java :
StackTugasMahasiswa20 stack = new StackTugasMahasiswa20(5);
Dan di konstruktor StackTugasMahasiswa20.java, nilai 5 tersebut digunakan sebagai ukuran array:
public StackTugasMahasiswa20(int size) {
    this.size = size;
    stack = new Mahasiswa20[size]; // array berukuran 5
    top = -1;
}
3.	Mengapa perlu pengecekan kondisi !isFull() pada method push? Kalau kondisi if-else tersebut dihapus, apa dampaknya?
Jawaban: Pengecekan !isFull() diperlukan untuk memastikan Stack tidak melebihi kapasitas array. Jika kondisi if-else tersebut dihapus menjadi seperti ini:
public void push(Mahasiswa20 mhs) {
    top++;
    stack[top] = mhs; // langsung isi tanpa cek
}
Dampaknya adalah ketika sudah terisi 5 data lalu push lagi, top akan menjadi 5 sehingga stack[5] diakses, padahal indeks array hanya sampai 4. Program akan langsung crash dengan error ArrayIndexOutOfBoundsException.
4.	Modifikasi kode program pada class MahasiswaDemo dan StackTugasMahasiswa sehingga pengguna juga dapat melihat mahasiswa yang pertama kali mengumpulkan tugas melalui operasi lihat tugas terbawah!
Jawaban: Karena Stack bersifat LIFO (Last In First Out), data yang pertama kali masuk akan berada di posisi paling bawah, yaitu di indeks 0 pada array. Jadi untuk melihat mahasiswa yang pertama mengumpulkan tugas, cukup kembalikan stack[0] tanpa mengubah nilai top sama sekali — mirip seperti peek() tapi mengintip dari bawah, bukan dari atas.
5.	Tambahkan method untuk dapat menghitung berapa banyak tugas yang sudah dikumpulkan saat ini, serta tambahkan operasi menunya!
Jawaban: Karena nilai top selalu menunjuk ke posisi terakhir data yang masuk, maka jumlah data yang ada di Stack tinggal dihitung dengan top + 1. Ditambah 1 karena top dimulai dari -1 (kosong), jadi saat ada 1 data top bernilai 0, saat ada 2 data top bernilai 1, dan seterusnya. Jadi top + 1 selalu sama dengan jumlah tugas yang sudah dikumpulkan.