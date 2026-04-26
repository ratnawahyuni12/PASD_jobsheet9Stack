public class Surat20 {
    String idSurat;
    String namaMahasiswa;
    String kelas;
    char jenisIzin; // S = sakit, I = izin keperluan lain
    int durasi;

    // konstruktor default
    public Surat20() {
    }

    // konstruktor berparameter
    public Surat20(String idSurat, String namaMahasiswa, String kelas, char jenisIzin, int durasi) {
        this.idSurat = idSurat;
        this.namaMahasiswa = namaMahasiswa;
        this.kelas = kelas;
        this.jenisIzin = jenisIzin;
        this.durasi = durasi;
    }
}