public class StackSurat20 {
    Surat20[] stack;
    int size;
    int top;

    // konstruktor default
    public StackSurat20() {
    } 

    // konstruktor berparameter
    public StackSurat20(int size) {
        this.size = size;
        stack = new Surat20[size];
        top = -1;
    }

    // cek apakah stack penuh
    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    // cek apakah stack kosong
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    // menambahkan surat ke stack (push) 
    public void push(Surat20 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan surat lagi.");
        }
    }

    // mengeluarkan surat dari stack (pop)
    public Surat20 pop() {
        if (!isEmpty()) {
            Surat20 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    // melihat surat paling atas tanpa mengeluarkan (peek)
    public Surat20 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat yang dikumpulkan.");
            return null;
        }
    }

    // mencari surat berdasarkan nama mahasiswa
    public void cariSurat(String nama) {
        boolean ditemukan = false;
        for (int i = 0; i <= top; i++) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                ditemukan = true;
                String jenisIzinStr = (stack[i].jenisIzin == 'S' || stack[i].jenisIzin == 's') ? "Sakit" : "Izin Keperluan Lain";
                System.out.println("Surat ditemukan!");
                System.out.println("ID Surat       : " + stack[i].idSurat);
                System.out.println("Nama Mahasiswa : " + stack[i].namaMahasiswa);
                System.out.println("Kelas          : " + stack[i].kelas);
                System.out.println("Jenis Izin     : " + jenisIzinStr);
                System.out.println("Durasi         : " + stack[i].durasi + " hari");
            }
        }
        if (!ditemukan) {
            System.out.println("Surat atas nama \"" + nama + "\" tidak ditemukan.");
        }
    }

    // menampilkan semua surat dalam stack
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada surat.");
        } else {
            System.out.printf("%-12s %-20s %-8s %-12s %-8s%n", "ID Surat", "Nama Mahasiswa", "Kelas", "Jenis Izin", "Durasi");
            System.out.println("------------------------------------------------------------------");

            for (int i = top; i >= 0; i--) {
                String jenisIzinStr = (stack[i].jenisIzin == 'S' || stack[i].jenisIzin == 's') ? "Sakit" : "Izin Keperluan Lain";
                System.out.printf("%-12s %-20s %-8s %-12s %-8d hari%n", stack[i].idSurat, stack[i].namaMahasiswa, stack[i].kelas, jenisIzinStr, stack[i].durasi);
            }
            System.out.println();
        }
    }
}