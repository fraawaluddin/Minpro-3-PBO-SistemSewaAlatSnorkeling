/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.AlatSelam;
import model.AlatSnorkeling;
import model.AlatDiving;
import model.Penyewa;
import model.Penyewaan;
import view.SewaAlatView;

/**
 *
 * @author MyBook Z Series
 */
public class SewaAlatController {

    private SewaAlatView view;
    private ArrayList<AlatSelam> daftarAlat = new ArrayList<>();
    private ArrayList<Penyewa> daftarPenyewa = new ArrayList<>();
    private ArrayList<Penyewaan> daftarPenyewaan = new ArrayList<>();

    public SewaAlatController(SewaAlatView view) {
        this.view = view;

        daftarAlat.add(new AlatSnorkeling(
                "SNK01",
                "Masker Snorkeling",
                "M",
                5000,
                "Baik",
                10,
                "Full Face"
        ));

        daftarAlat.add(new AlatDiving(
                "DIV01",
                "Tabung Diving",
                "L",
                100000,
                "Baik",
                5,
                12
        ));
    }

    public void jalankanProgram() {
        int pilihan;

        do {
            pilihan = view.tampilkanMenuUtama();

            switch (pilihan) {
                case 1:
                    kelolaDataAlat();
                    break;

                case 2:
                    buatPenyewaan();
                    break;

                case 3:
                    lihatDataPenyewaan();
                    break;

                case 4:
                    pengembalianAlat();
                    break;

                case 5:
                    System.out.println("Program Selesai");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
        } while (pilihan != 5);
    }

    private void kelolaDataAlat() {

        int pilihanAlat;

        do {
            pilihanAlat = view.tampilkanMenuAlat();

            switch (pilihanAlat) {
                case 1:
                    tambahAlat();
                    break;

                case 2:
                    lihatDataAlat();
                    break;

                case 3:
                    ubahAlat();
                    break;

                case 4:
                    hapusAlat();
                    break;

                case 5:
                    System.out.println("Kembali ke menu utama");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }

        } while (pilihanAlat != 5);
    }

    private void lihatDataAlat() {

        System.out.println();
        System.out.println("+------------------------------------------+");
        System.out.println("|               DAFTAR ALAT                |");
        System.out.println("+------------------------------------------+");

        for (AlatSelam alat : daftarAlat) {     
            alat.tampilkanInfo(true);
            System.out.println("+------------------------------------------+");
        }
        
        System.out.println("\n--- DETAIL LENGKAP ALAT ---");

        for (AlatSelam alat : daftarAlat) {
            alat.tampilkanInfo();
            System.out.println("+------------------------------------------+");
        }
    }   

    private boolean idAlatSudahAda(String idAlat) {

        for (AlatSelam alat : daftarAlat) {
            if (alat.getIdAlat().equalsIgnoreCase(idAlat)) {
                return true;
            }
        }

        return false;
    }

    private AlatSelam cariAlat(String idAlat) {

        for (AlatSelam alat : daftarAlat) {
            if (alat.getIdAlat().equalsIgnoreCase(idAlat)) {
                return alat;
            }
        }

        return null;
    }

    private void buatPenyewaan() {
        System.out.println();
        System.out.println("+------------------------------------------+");
        System.out.println("|             BUAT PENYEWAAN               |");
        System.out.println("+------------------------------------------+");

        String namaPenyewa = view.inputNamaPenyewa();
        String noHp = view.inputNoHp();

        String idAlat = view.inputIdAlat();
        AlatSelam alat = cariAlat(idAlat);

        if (alat == null) {
            System.out.println("Alat tidak ditemukan");
            return;
        }

        System.out.println("Alat ditemukan: " + alat.getNamaAlat());

        int jumlahUnit = view.inputJumlahUnit();

        if (jumlahUnit <= 0) {
            System.out.println("Jumlah unit harus lebih dari 0");
            return;
        }

        if (!alat.cekKetersediaan(jumlahUnit)) {
            System.out.println("Jumlah unit melebihi stok yang tersedia");
            return;
        }

        int durasiHari = view.inputDurasiHari();

        if (durasiHari <= 0) {
            System.out.println("Durasi sewa harus lebih dari 0");
            return;
        }

        String idPenyewa = "PNYW0" + (daftarPenyewa.size() + 1);
        String idPenyewaan = "SW0" + (daftarPenyewaan.size() + 1);

        Penyewa penyewaBaru = new Penyewa(
                idPenyewa,
                namaPenyewa,
                noHp
        );

        double totalBiaya = alat.getTarifPerHari() * jumlahUnit * durasiHari;

        Penyewaan penyewaanBaru = new Penyewaan(
                idPenyewaan,
                penyewaBaru,
                alat,
                jumlahUnit,
                durasiHari,
                totalBiaya,
                "AKTIF"
        );

        daftarPenyewa.add(penyewaBaru);
        daftarPenyewaan.add(penyewaanBaru);

        alat.setJumlahTersedia(
                alat.getJumlahTersedia() - jumlahUnit
        );

        System.out.println("Penyewaan berhasil dibuat");
        System.out.println("ID Penyewaan : " + idPenyewaan);
        System.out.println("Total Biaya  : " + totalBiaya);

    }

    private void lihatDataPenyewaan() {
        System.out.println();
        System.out.println("+------------------------------------------+");
        System.out.println("|             DAFTAR PENYEWAAN             |");
        System.out.println("+------------------------------------------+");

        if (daftarPenyewaan.isEmpty()) {
            System.out.println("Belum ada data penyewaan");
            return;
        }

        for (Penyewaan penyewaan : daftarPenyewaan) {
            System.out.println("ID Penyewaan : " + penyewaan.getIdPenyewaan());
            System.out.println("Nama Penyewa : " + penyewaan.getPenyewa().getNamaPenyewa());
            System.out.println("No HP        : " + penyewaan.getPenyewa().getNoHp());
            System.out.println("Nama Alat    : " + penyewaan.getAlat().getNamaAlat());
            System.out.println("Jumlah Unit  : " + penyewaan.getJumlahUnit());
            System.out.println("Durasi       : " + penyewaan.getDurasiHari() + " hari");
            System.out.println("Total Biaya  : " + penyewaan.getTotalBiaya());
            System.out.println("Status       : " + penyewaan.getStatusSewa());
            System.out.println("+------------------------------------------+");
        }
    }

    private void pengembalianAlat() {
        System.out.println();
        System.out.println("+------------------------------------------+");
        System.out.println("|            PENGEMBALIAN ALAT             |");
        System.out.println("+------------------------------------------+");

        String idPenyewaan = view.inputIdPenyewaan();

        for (Penyewaan penyewaan : daftarPenyewaan) {
            if (penyewaan.getIdPenyewaan().equalsIgnoreCase(idPenyewaan)) {

                if (penyewaan.getStatusSewa().equals("DIKEMBALIKAN")) {
                    System.out.println("Alat sudah dikembalikan");
                    return;
                }

                AlatSelam alat = penyewaan.getAlat();

                alat.setJumlahTersedia(
                        alat.getJumlahTersedia() + penyewaan.getJumlahUnit()
                );

                penyewaan.setStatusSewa("DIKEMBALIKAN");

                System.out.println("Alat berhasil dikembalikan");
                return;
            }
        }

        System.out.println("ID Penyewaan tidak ditemukan");
    }

    private void tambahAlat() {
        System.out.println();
        System.out.println("+------------------------------------------+");
        System.out.println("|               TAMBAH ALAT                |");
        System.out.println("+------------------------------------------+");

        String idAlat = view.inputIdAlat();

        if (idAlatSudahAda(idAlat)) {
            System.out.println("ID Alat sudah digunakan");
            return;
        }

        int jenisAlat = view.inputJenisAlat();

        if (jenisAlat != 1 && jenisAlat != 2) {
            System.out.println("Jenis alat tidak tersedia");
            return;
        }

        String namaAlat = view.inputNamaAlat();
        String ukuran = view.inputUkuran();

        double tarifPerHari = view.inputTarifPerHari();

        String kondisi = view.inputKondisi();

        int jumlahTersedia = view.inputJumlahTersedia();

        if (jumlahTersedia < 0) {
            System.out.println("Jumlah tersedia tidak boleh negatif");
            return;
        }

        if (jenisAlat == 1) {
            String jenisMasker = view.inputJenisMasker();

            AlatSnorkeling alatBaru = new AlatSnorkeling(
                    idAlat,
                    namaAlat,
                    ukuran,
                    tarifPerHari,
                    kondisi,
                    jumlahTersedia,
                    jenisMasker
            );

            daftarAlat.add(alatBaru);

        } else {
            int kapasitasTabung = view.inputKapasitasTabung();

            AlatDiving alatBaru = new AlatDiving(
                    idAlat,
                    namaAlat,
                    ukuran,
                    tarifPerHari,
                    kondisi,
                    jumlahTersedia,
                    kapasitasTabung
            );

            daftarAlat.add(alatBaru);
        }

        System.out.println("Alat berhasil ditambahkan");
    }

    private void ubahAlat() {
        System.out.println();
        System.out.println("+------------------------------------------+");
        System.out.println("|                UBAH ALAT                 |");
        System.out.println("+------------------------------------------+");

        String idAlat = view.inputIdAlat();

        for (AlatSelam alat : daftarAlat) {
            if (alat.getIdAlat().equalsIgnoreCase(idAlat)) {

                System.out.println("Alat ditemukan");

                String namaAlat = view.inputNamaAlat();
                String ukuran = view.inputUkuran();

                double tarifPerHari = view.inputTarifPerHari();

                String kondisi = view.inputKondisi();

                int jumlahTersedia = view.inputJumlahTersedia();

                if (jumlahTersedia < 0) {
                    System.out.println("Jumlah tersedia tidak boleh negatif");
                    return;
                }

                String jenisMasker = null;
                int kapasitasTabung = 0;

                if (alat instanceof AlatSnorkeling) {

                    jenisMasker = view.inputJenisMasker();

                } else if (alat instanceof AlatDiving) {

                    kapasitasTabung = view.inputKapasitasTabung();
                    
                }

                alat.setNamaAlat(namaAlat);
                alat.setUkuran(ukuran);
                alat.setTarifPerHari(tarifPerHari);
                alat.setKondisi(kondisi);
                alat.setJumlahTersedia(jumlahTersedia);

                if (alat instanceof AlatSnorkeling) {
                    AlatSnorkeling alatSnorkeling = (AlatSnorkeling) alat;
                    alatSnorkeling.setJenisMasker(jenisMasker);

                } else if (alat instanceof AlatDiving) {
                    AlatDiving alatDiving = (AlatDiving) alat;
                    alatDiving.setKapasitasTabung(kapasitasTabung);
                }

                System.out.println("Alat berhasil diubah");
                return;
            }
        }

        System.out.println("Alat tidak ditemukan");
    }   
        
    private void hapusAlat() {

        String idAlat = view.inputIdAlat();

        for (int i = 0; i < daftarAlat.size(); i++) {

            if (daftarAlat.get(i).getIdAlat().equalsIgnoreCase(idAlat)) {

                daftarAlat.remove(i);

                System.out.println("Alat berhasil dihapus");
                return;
            }
        }

        System.out.println("Alat tidak ditemukan");
    }
}
