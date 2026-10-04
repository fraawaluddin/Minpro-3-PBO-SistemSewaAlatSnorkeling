/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MyBook Z Series
 */
public class AlatSnorkeling extends AlatSelam {

    private String jenisMasker;

    public AlatSnorkeling(String idAlat, String namaAlat, String ukuran,
            double tarifPerHari, String kondisi, int jumlahTersedia,
            String jenisMasker) {

        super(idAlat, namaAlat, ukuran, tarifPerHari, kondisi, jumlahTersedia);
        setJenisMasker(jenisMasker);
    }

    public String getJenisMasker() {
        return jenisMasker;
    }

    public void setJenisMasker(String jenisMasker) {
        if (jenisMasker != null && !jenisMasker.trim().isEmpty()) {
            this.jenisMasker = jenisMasker;
        } else {
            System.out.println("Jenis masker tidak boleh kosong.");
        }
    }

    @Override
    public void tampilkanInfo() {
        tampilkanDataDasar();
        System.out.println("Jenis Masker    : " + getJenisMasker());
    }
    
    @Override
    public boolean cekKetersediaan(int jumlahUnit) {
        return jumlahUnit > 0 && jumlahUnit <= getJumlahTersedia();
    }

}
