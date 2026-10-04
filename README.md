# Minpro-3-PBO-SistemSewaAlatSnorkeling

**Nama:** Muhammad Farel Awaluddin  
**NIM:** 2509116055  
**Kelas:** B  

# Sistem Manajemen Sewa Alat Snorkeling & Diving

## 1. Deskripsi Singkat

Sistem Manajemen Sewa Alat Snorkeling & Diving merupakan program berbasis Java yang digunakan untuk mengelola data alat, proses penyewaan, dan pengembalian alat snorkeling dan diving.

Program menerapkan konsep Pemrograman Berorientasi Objek seperti encapsulation, inheritance, polymorphism, abstraction, serta menggunakan pola arsitektur MVC. Program juga dilengkapi validasi input dan interface sebagai value-add.

## 2. Struktur Package

```text
src/main/java/
├── main/
│   └── Main.java
├── model/
│   ├── AlatSelam.java
│   ├── AlatSnorkeling.java
│   ├── AlatDiving.java
│   ├── DapatDisewa.java
│   ├── Penyewa.java
│   └── Penyewaan.java
├── view/
│   └── SewaAlatView.java
└── controller/
    └── SewaAlatController.java
```

- **main**: berisi `Main.java` sebagai titik awal program.
- **model**: berisi data dan perilaku objek.
- **view**: menangani tampilan menu serta input dari pengguna.
- **controller**: mengatur alur program dan menghubungkan View dengan Model.

## 3. Alur Program

Program dimulai dari `Main.java`, kemudian membuat objek View dan Controller. Controller menjalankan program melalui menu utama.

```text
Menu Utama
│
├── 1. Kelola Data Alat
│   ├── Tambah
│   ├── Lihat
│   ├── Ubah
│   └── Hapus
│
├── 2. Buat Penyewaan
│
├── 3. Lihat Data Penyewaan
│
├── 4. Pengembalian Alat
│
└── 5. Keluar
```

Program akan terus berjalan sampai pengguna memilih menu **Keluar**.

## 4. Encapsulation

Encapsulation diterapkan dengan menggunakan atribut `private` pada class Model dan menyediakan getter serta setter untuk mengakses dan mengubah data.

Contohnya pada `AlatSelam`:

```java
private String namaAlat;
private double tarifPerHari;
private int jumlahTersedia;
```

Setter juga digunakan sebagai tempat validasi data, seperti memastikan nama alat tidak kosong, tarif lebih dari 0, dan jumlah tersedia tidak negatif.

## 5. Inheritance

Inheritance diterapkan dengan menggunakan `AlatSelam` sebagai superclass dan dua subclass:

```text
             AlatSelam
              /     \
             /       \
AlatSnorkeling     AlatDiving
```

`AlatSnorkeling` dan `AlatDiving` menggunakan keyword `extends` untuk mewarisi atribut dan method dari `AlatSelam`.

`AlatSelam` juga merupakan abstract class sehingga tidak dapat dibuat menjadi objek secara langsung.

## 6. Polymorphism

Polymorphism diterapkan melalui **overriding** dan **overloading**.

### Overriding

Method `tampilkanInfo()` pada `AlatSelam` dibuat sebagai abstract method dan kemudian diimplementasikan kembali oleh:

- `AlatSnorkeling`
- `AlatDiving`

Contoh:

```java
@Override
public void tampilkanInfo() {
    tampilkanDataDasar();
    System.out.println("Jenis Perlengkapan: " + getJenisPerlengkapan());
}
```

### Overloading

Method `tampilkanInfo()` juga memiliki bentuk dengan parameter:

```java
public void tampilkanInfo(boolean ringkas)
```

Sehingga terdapat dua method dengan nama yang sama tetapi parameter berbeda.

Polymorphism juga digunakan pada:

```java
ArrayList<AlatSelam> daftarAlat;
```

ArrayList tersebut dapat menyimpan objek `AlatSnorkeling` dan `AlatDiving`.

## 7. Abstraction

Abstraction diterapkan pada class:

```java
public abstract class AlatSelam
```

Class tersebut memiliki abstract method:

```java
public abstract void tampilkanInfo();
```

Karena merupakan abstract method, setiap subclass harus menyediakan implementasinya sendiri melalui overriding.

Dengan demikian, `AlatSelam` digunakan sebagai kerangka dasar untuk berbagai jenis alat.

## 8. MVC

Program menggunakan pola **Model-View-Controller (MVC)**.

- **Model**: mengelola data dan perilaku objek, seperti `AlatSelam`, `AlatSnorkeling`, `AlatDiving`, `Penyewa`, dan `Penyewaan`.
- **View**: menangani tampilan menu dan input pengguna melalui `SewaAlatView`.
- **Controller**: menghubungkan View dengan Model dan mengatur alur program melalui `SewaAlatController`.

## 9. Value-Add: Interface

Selain konsep wajib, program menerapkan interface `DapatDisewa` sebagai value-add.

```java
public interface DapatDisewa {
    boolean cekKetersediaan(int jumlahUnit);
}
```

Interface tersebut digunakan untuk menentukan kemampuan alat dalam mengecek ketersediaan unit.

`AlatSnorkeling` dan `AlatDiving` mengimplementasikan interface tersebut melalui:

```java
@Override
public boolean cekKetersediaan(int jumlahUnit) {
    return jumlahUnit > 0 && jumlahUnit <= getJumlahTersedia();
}
```

Penggunaan interface terdapat pada package:

```text
model/DapatDisewa.java
```

dan diterapkan pada:

```text
model/AlatSelam.java
model/AlatSnorkeling.java
model/AlatDiving.java
```

## 10. Validasi Input

Program memiliki beberapa validasi untuk mencegah input yang tidak sesuai, antara lain:

- Nama alat tidak boleh kosong.
- Ukuran tidak boleh kosong.
- Tarif per hari harus lebih dari 0.
- Kondisi alat tidak boleh kosong.
- Jumlah tersedia tidak boleh negatif.
- Jenis perlengkapan tidak boleh kosong.
- Kapasitas tabung harus lebih dari 0.
- Jumlah unit penyewaan harus lebih dari 0.
- Durasi penyewaan harus lebih dari 0.
- Jumlah unit yang disewa tidak boleh melebihi stok.

## 11. Dummy Data

Program menyediakan dummy data alat yang langsung dimasukkan ke dalam `ArrayList` ketika program dijalankan.

Contoh dummy data:

```text
ID Alat           : SNK01
Nama Alat         : Set Snorkeling
Ukuran            : M
Tarif Per Hari    : 15000
Kondisi           : Baik
Jumlah Tersedia   : 10
Jenis Perlengkapan: Set Masker dan Snorkel
```

Dummy data digunakan agar fitur lihat data dapat langsung digunakan ketika program pertama kali dijalankan.

## 12. Teknologi

- Java
- Apache NetBeans
- Maven
- ArrayList
- Git
- GitHub
