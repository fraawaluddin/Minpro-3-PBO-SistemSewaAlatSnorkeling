# Minpro 3 PBO - Sistem Manajemen Sewa Alat Snorkeling & Diving

**Nama**  : Muhammad Farel Awaluddin

**NIM**   : 2509116055

**Kelas** : B

---

## Deskripsi Singkat Program

Program ini merupakan Sistem Manajemen Sewa Alat Snorkeling & Diving berbasis Java yang dijalankan melalui console/CLI. Program ini merupakan pengembangan dari Minpro 2 dengan menerapkan konsep **Polymorphism**, **Abstraction**, **MVC**, serta pengembangan validasi input. Program juga menggunakan **Interface** sebagai nilai tambah.

Pengguna dapat melakukan beberapa proses, yaitu:

- Menambahkan data alat snorkeling dan diving.
- Menampilkan seluruh data alat.
- Mengubah data alat.
- Menghapus data alat.
- Membuat penyewaan alat.
- Menampilkan data penyewaan.
- Melakukan pengembalian alat.
- Mengakhiri program melalui menu keluar.

Program menyimpan data alat dan data penyewaan sementara selama program berjalan menggunakan `ArrayList`. Saat program pertama kali dijalankan, `ArrayList` data alat sudah berisi **dummy data** sehingga fitur menampilkan data dapat langsung digunakan tanpa harus menambahkan data terlebih dahulu.

Program juga menerapkan konsep **Object-Oriented Programming (OOP)** berupa Encapsulation, Inheritance, Polymorphism, dan Abstraction serta menggunakan pola **Model-View-Controller (MVC)** untuk memisahkan pengelolaan data, tampilan, dan alur program.

## Struktur Folder

Project disusun menggunakan beberapa package untuk memisahkan fungsi utama program. Struktur ini juga mendukung penerapan pola MVC dengan memisahkan bagian model, tampilan, dan pengendali program.

```text
SistemSewaAlatSnorkeling-Minpro3
└── Source Packages
    ├── controller
    │   └── SewaAlatController.java
    ├── main
    │   └── Main.java
    ├── model
    │   ├── AlatSelam.java
    │   ├── AlatSnorkeling.java
    │   ├── AlatDiving.java
    │   ├── DapatDisewa.java
    │   ├── Penyewa.java
    │   └── Penyewaan.java
    └── view
        └── SewaAlatView.java
```

<img width="301" height="342" alt="image" src="https://github.com/user-attachments/assets/cdb3ee65-efde-4e1c-9931-0b20f1e57615" />

Gambar tersebut menunjukkan struktur project yang dipisahkan ke dalam package `main`, `model`, `view`, dan `controller`. Pemisahan ini digunakan untuk mendukung penerapan pola MVC serta membuat setiap bagian program memiliki tanggung jawab yang berbeda.

### Pembagian Package

| Package | Class | Fungsi |
|---|---|---|
| `main` | `Main` | Menjadi titik awal untuk menjalankan aplikasi. |
| `model` | `AlatSelam` | Menjadi abstract class yang menyediakan struktur dasar alat selam. |
| `model` | `AlatSnorkeling` | Merepresentasikan alat snorkeling dan menambahkan karakteristik khusus perlengkapannya. |
| `model` | `AlatDiving` | Merepresentasikan alat diving dan menyimpan informasi kapasitas tabung. |
| `model` | `DapatDisewa` | Menentukan kontrak untuk pengecekan ketersediaan alat. |
| `model` | `Penyewa` | Menyimpan informasi pengguna yang melakukan penyewaan. |
| `model` | `Penyewaan` | Menyimpan informasi transaksi penyewaan dan perhitungan biaya. |
| `view` | `SewaAlatView` | Menangani tampilan menu serta proses penerimaan input dari pengguna. |
| `controller` | `SewaAlatController` | Mengatur proses program dan menghubungkan View dengan Model. |

## Struktur Kelas

Program menggunakan `AlatSelam` sebagai dasar untuk membentuk dua jenis alat, yaitu `AlatSnorkeling` dan `AlatDiving`. Selain itu, class `Penyewa` digunakan untuk menyimpan data penyewa, sedangkan `Penyewaan` menangani data transaksi penyewaan.

| Kelas | Peran |
|---|---|
| `AlatSelam` | Abstract class yang menjadi dasar untuk berbagai jenis alat selam serta menyediakan atribut, getter/setter, dan method umum. |
| `AlatSnorkeling` | Subclass dari `AlatSelam` yang menyimpan informasi khusus berupa jenis perlengkapan snorkeling. |
| `AlatDiving` | Subclass dari `AlatSelam` yang menyimpan informasi khusus berupa kapasitas tabung diving. |
| `DapatDisewa` | Interface yang menyediakan kontrak untuk melakukan pengecekan ketersediaan alat. |
| `Penyewa` | Menyimpan informasi mengenai pihak yang melakukan penyewaan alat. |
| `Penyewaan` | Menyimpan informasi transaksi penyewaan, termasuk alat, penyewa, durasi, jumlah unit, dan total biaya. |
| `SewaAlatView` | Menangani menu program dan menerima input dari pengguna. |
| `SewaAlatController` | Mengatur proses program, mengelola data dalam `ArrayList`, serta menghubungkan View dengan Model. |
| `Main` | Menjadi titik awal program dengan membuat objek View dan Controller. |

## Alur Program

Program dijalankan melalui `Main.java` yang membuat objek `SewaAlatView` dan `SewaAlatController`. Setelah program dijalankan, pengguna berinteraksi dengan sistem melalui menu yang tersedia.

Data alat dan data transaksi disimpan menggunakan `ArrayList` selama program berjalan. Program juga menyediakan dummy data alat agar informasi awal dapat langsung ditampilkan ketika aplikasi dijalankan.

### Menu Utama

Menu utama digunakan sebagai pusat pilihan pengguna untuk mengakses berbagai fungsi dalam sistem.

| Pilihan | Fitur | Keterangan |
|---|---|---|
| 1 | **Kelola Data Alat** | Mengelola data alat melalui proses tambah, lihat, ubah, dan hapus. |
| 2 | **Buat Penyewaan** | Membuat transaksi penyewaan alat. |
| 3 | **Lihat Data Penyewaan** | Menampilkan transaksi penyewaan yang telah tersimpan. |
| 4 | **Pengembalian Alat** | Memproses pengembalian alat dari transaksi yang masih aktif. |
| 5 | **Keluar** | Menghentikan program. |

### Tampilan Awal Program

Berikut merupakan tampilan ketika program pertama kali dijalankan:

<img width="330" height="165" alt="image" src="https://github.com/user-attachments/assets/ab9b5914-c13e-4644-b031-b72ebfdd61d5" />

Tampilan tersebut menunjukkan kondisi awal program ketika pertama kali dijalankan. Menu utama menyediakan pilihan untuk mengelola data alat, membuat penyewaan, melihat data penyewaan, melakukan pengembalian, dan keluar dari program.

### Pengelolaan Data Alat

Fitur ini digunakan untuk mengatur seluruh data alat yang tersedia. Pengguna dapat melakukan penambahan, melihat, mengubah, maupun menghapus data alat.

#### Menambahkan Alat

Pengguna mengisi data sesuai jenis alat yang dipilih. Data umum meliputi ID alat, nama alat, ukuran, tarif per hari, kondisi, dan jumlah tersedia.

Untuk alat snorkeling terdapat input jenis perlengkapan, sedangkan alat diving memiliki input kapasitas tabung.

**Tahapan proses:**

1. Memilih jenis alat.
2. Mengisi informasi alat.
3. Sistem memeriksa validitas setiap input.
4. Data yang valid dibuat menjadi objek.
5. Objek dimasukkan ke dalam `ArrayList`.
6. Sistem menampilkan hasil penambahan.

**Input alat:**

<img width="437" height="555" alt="image" src="https://github.com/user-attachments/assets/7684395d-5e57-4ddd-9f68-aa39b1896406" />

Screenshot tersebut menunjukkan proses pengisian data alat snorkeling. Pengguna memasukkan data umum alat serta jenis perlengkapan yang menjadi atribut khusus untuk alat snorkeling.

**Hasil penambahan:**

<img width="288" height="743" alt="image" src="https://github.com/user-attachments/assets/ee17e923-6334-451b-ab2c-6db9f19f4374" />

Screenshot tersebut menunjukkan data alat yang berhasil ditambahkan ke dalam sistem setelah seluruh input dinyatakan valid.

Program juga melakukan validasi terhadap input yang diberikan pengguna. Validasi dilakukan untuk memastikan data yang dimasukkan sesuai dengan ketentuan sebelum diproses oleh sistem.

#### Menampilkan Alat

Fitur lihat alat digunakan untuk menampilkan data alat yang sudah tersimpan di dalam sistem. Data yang ditampilkan mencakup informasi umum alat serta informasi tambahan sesuai dengan jenis alatnya.
Pada fitur ini, pengguna dapat melihat seluruh data alat yang tersedia tanpa perlu memasukkan data baru.

<img width="282" height="716" alt="image" src="https://github.com/user-attachments/assets/d1823037-4153-41f6-bbbf-5a428307ed52" />

Screenshot tersebut menunjukkan seluruh data alat yang tersimpan di dalam sistem, termasuk informasi umum serta informasi khusus berdasarkan jenis alat.

#### Mengubah Alat

Fitur ubah alat digunakan untuk memperbarui data alat yang sudah tersimpan. Pengguna memasukkan ID alat yang ingin diubah, kemudian mengisi informasi baru untuk alat tersebut.
Sistem akan melakukan validasi terhadap data yang dimasukkan sebelum perubahan disimpan. Jika proses berhasil, data lama akan diperbarui dengan data baru.

**Sebelum diubah:**

<img width="266" height="101" alt="image" src="https://github.com/user-attachments/assets/20adecd1-9951-454b-a5fc-c8ca8543d0f1" />

Screenshot tersebut menunjukkan kondisi data alat sebelum dilakukan perubahan.

**Proses memilih alat:**

<img width="281" height="225" alt="image" src="https://github.com/user-attachments/assets/f5fc9ea3-db6c-4619-a64f-44efe62a6fd9" />

Screenshot tersebut menunjukkan pengguna memilih data alat berdasarkan ID yang akan diperbarui.

**Input perubahan data:**

<img width="511" height="83" alt="image" src="https://github.com/user-attachments/assets/383458aa-9dc9-42fc-86a0-876f8790c4f3" />

Screenshot tersebut menunjukkan pengguna memasukkan data baru untuk memperbarui informasi alat yang telah dipilih.

**Hasil perubahan data:**

<img width="317" height="98" alt="image" src="https://github.com/user-attachments/assets/ddaef616-8d4c-4925-a6e3-bd4207fa2ef3" />

Screenshot tersebut menunjukkan data alat setelah proses perubahan berhasil dilakukan.

#### Menghapus Alat

Fitur hapus alat digunakan untuk menghapus data alat yang sudah tidak diperlukan dari sistem. Pengguna memilih data alat berdasarkan ID, kemudian sistem meminta konfirmasi sebelum data tersebut dihapus.
Jika pengguna memberikan konfirmasi, data alat akan dihapus dari ArrayList. Jika tidak dikonfirmasi, data tetap tersimpan.

Data alat dapat dihapus berdasarkan ID. Sistem meminta konfirmasi sebelum menghapus data dari `ArrayList`.

**Sebelum dihapus:**

<img width="322" height="571" alt="image" src="https://github.com/user-attachments/assets/7206b7de-7904-4046-b51a-93ea8ed75e2d" />

Screenshot tersebut menunjukkan data alat yang masih tersimpan sebelum proses penghapusan dilakukan.

**Proses penghapusan:**

<img width="278" height="173" alt="image" src="https://github.com/user-attachments/assets/a10ee094-4986-47f2-be7c-7d624254f2ef" />

Screenshot tersebut menunjukkan proses pengguna memilih alat berdasarkan ID dan melakukan konfirmasi untuk menghapus data.

**Hasil setelah penghapusan:**

<img width="280" height="407" alt="image" src="https://github.com/user-attachments/assets/5a2b7600-188f-41e1-b3cb-6db61adc1bd9" />

Screenshot tersebut menunjukkan kondisi data setelah alat berhasil dihapus dari sistem.

### Kembali

Pilihan kembali digunakan untuk keluar dari menu **Kelola Data Alat** dan kembali ke **Menu Utama**. Pilihan ini tidak mengubah data yang sudah tersimpan.

**Tampilan setelah memilih kembali:**

<img width="281" height="301" alt="image" src="https://github.com/user-attachments/assets/06360a37-7194-4c14-8bb5-8b08d351aab0" />

Screenshot tersebut menunjukkan bahwa setelah pengguna memilih kembali, sistem keluar dari menu pengelolaan data alat dan kembali ke menu utama.

### Buat Penyewaan

Fitur buat penyewaan digunakan untuk mencatat transaksi ketika penyewa ingin menyewa alat snorkeling atau diving. Pengguna memasukkan data penyewa, memilih alat yang ingin disewa, menentukan jumlah unit, dan menentukan durasi penyewaan.

Sistem akan memeriksa ketersediaan alat sebelum transaksi dibuat. Jika jumlah unit yang diminta masih tersedia, transaksi akan disimpan dan jumlah stok alat akan berkurang sesuai dengan jumlah unit yang disewa.

**Data alat sebelum penyewaan:**

<img width="268" height="118" alt="image" src="https://github.com/user-attachments/assets/d65c4572-fd54-44b2-aa20-8770c1c0ff09" />

Screenshot tersebut menunjukkan kondisi stok alat sebelum transaksi penyewaan dilakukan. Data ini digunakan sebagai pembanding untuk melihat perubahan stok setelah penyewaan.

**Input data penyewaan:**

<img width="275" height="322" alt="image" src="https://github.com/user-attachments/assets/5b297cb1-ec14-4e0c-86d2-17fea9b2b441" />

Screenshot tersebut menunjukkan proses pengguna memasukkan data yang diperlukan untuk membuat transaksi penyewaan.

**Hasil penyewaan:**

<img width="282" height="175" alt="image" src="https://github.com/user-attachments/assets/f627edfd-e520-4ddc-a9a6-5d351fb06bb2" />

Screenshot tersebut menunjukkan transaksi penyewaan yang berhasil dibuat setelah seluruh input dinyatakan valid.

**Stok alat setelah penyewaan:**

<img width="268" height="113" alt="image" src="https://github.com/user-attachments/assets/11096ffb-cbec-43c2-b270-d6d182567a04" />

Screenshot tersebut menunjukkan perubahan jumlah stok alat setelah transaksi berhasil dilakukan. Jumlah stok berkurang sesuai dengan jumlah unit yang disewa.

### Lihat Data Penyewaan

Fitur lihat data penyewaan digunakan untuk menampilkan seluruh transaksi penyewaan yang sudah tersimpan selama program berjalan. Informasi yang ditampilkan meliputi ID penyewaan, data penyewa, alat yang disewa, jumlah unit, durasi penyewaan, total biaya, dan status penyewaan.

Data transaksi dapat dilihat setelah pengguna membuat penyewaan. Fitur ini membantu pengguna mengetahui transaksi yang masih berlangsung maupun transaksi yang sudah dikembalikan.

**Tampilan data penyewaan:**

<img width="270" height="325" alt="image" src="https://github.com/user-attachments/assets/6684bb62-e016-43ed-a0ee-020ee48ae22d" />

Screenshot tersebut menunjukkan daftar transaksi penyewaan yang telah tersimpan, termasuk ID penyewaan, data penyewa, alat yang disewa, jumlah unit, durasi, total biaya, dan status transaksi.

### Pengembalian Alat

Fitur pengembalian alat digunakan untuk memproses alat yang sudah selesai disewa. Pengguna memasukkan ID penyewaan yang ingin dikembalikan, kemudian sistem akan mencari transaksi tersebut dan memeriksa status penyewaannya.

Jika transaksi masih berstatus aktif, sistem akan mengubah status menjadi `DIKEMBALIKAN` dan menambahkan kembali jumlah alat yang disewa ke stok alat.

**Data transaksi sebelum pengembalian:**

<img width="281" height="178" alt="image" src="https://github.com/user-attachments/assets/ff65770c-99d8-49cd-9593-6e16ff5368f1" />

Screenshot tersebut menunjukkan data transaksi penyewaan sebelum proses pengembalian dilakukan.

**Stok alat sebelum pengembalian:**

<img width="267" height="116" alt="image" src="https://github.com/user-attachments/assets/395cb14e-ebda-4f5d-ad76-9fa10db2dd00" />

Screenshot tersebut menunjukkan jumlah stok alat sebelum proses pengembalian dilakukan sebagai kondisi awal pembanding.

**Proses pengembalian:**

<img width="273" height="227" alt="image" src="https://github.com/user-attachments/assets/89180811-eb13-4b9e-bf41-223181a89885" />

Screenshot tersebut menunjukkan pengguna memasukkan ID penyewaan untuk memproses pengembalian alat.

**Data transaksi setelah pengembalian:**

<img width="271" height="168" alt="image" src="https://github.com/user-attachments/assets/116fa251-148b-465a-abd8-552a2532d92d" />

Screenshot tersebut menunjukkan transaksi setelah proses pengembalian berhasil dilakukan dan status penyewaan berubah menjadi `DIKEMBALIKAN`.

**Stok alat setelah pengembalian:**

<img width="268" height="107" alt="image" src="https://github.com/user-attachments/assets/fa5a3696-fcbb-4f2a-bcd8-7d12e21ab2d8" />

Screenshot tersebut menunjukkan jumlah stok alat setelah pengembalian. Stok kembali bertambah sesuai dengan jumlah alat yang sebelumnya disewa.

### Keluar

Pilihan keluar digunakan untuk mengakhiri program setelah pengguna selesai menggunakan seluruh fitur yang tersedia. Ketika pilihan ini dipilih, program akan menghentikan proses dan menampilkan pesan bahwa program telah selesai.

**Tampilan saat keluar dari program:**

<img width="437" height="247" alt="image" src="https://github.com/user-attachments/assets/08fed2ff-d27a-410f-bc26-d988102e00bb" />

Screenshot tersebut menunjukkan ketika pengguna memilih menu keluar. Program menghentikan proses dan menampilkan pesan bahwa program telah selesai.

## Validasi Input

Program menyediakan validasi input untuk mencegah data yang tidak sesuai diproses oleh sistem.

### 1. Validasi Menu

<img width="152" height="35" alt="image" src="https://github.com/user-attachments/assets/c5be0310-001e-4d03-8484-c07943cf0672" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan pilihan menu `99`, sedangkan pilihan yang tersedia hanya menu yang telah ditentukan. Sistem menolak input tersebut dan menampilkan pesan `Pilihan tidak tersedia`.

### 2. Validasi Data Alat

#### Validasi Jenis Alat

<img width="292" height="130" alt="image" src="https://github.com/user-attachments/assets/7572c625-3d8a-4600-ab30-8b2fbe210130" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan pilihan jenis alat yang tidak tersedia. Sistem menolak pilihan tersebut dan meminta pengguna memilih jenis alat yang sesuai.

#### Validasi Input Kosong

<img width="282" height="147" alt="image" src="https://github.com/user-attachments/assets/e30a7f0c-0ecf-4e8b-8080-820cc6f5bce3" />

Screenshot tersebut menunjukkan ketika pengguna tidak mengisi input yang wajib diisi. Sistem mendeteksi input kosong, menampilkan pesan kesalahan, dan meminta pengguna memasukkan data kembali.

#### Validasi Tarif Per Hari

<img width="221" height="75" alt="image" src="https://github.com/user-attachments/assets/4ee4929c-385c-4cfa-8714-45c810d256af" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan tarif per hari dengan nilai `0`. Sistem menolak nilai tersebut karena tarif harus lebih dari `0`.

#### Validasi Jumlah Tersedia

<img width="222" height="40" alt="image" src="https://github.com/user-attachments/assets/e6700b12-5fc5-4614-89ce-111396d65d54" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan jumlah tersedia dengan nilai yang tidak diperbolehkan. Sistem menolak jumlah negatif karena stok alat tidak boleh bernilai kurang dari `0`.

#### Validasi Kondisi

<img width="197" height="41" alt="image" src="https://github.com/user-attachments/assets/b346aedb-70da-4bba-bfab-bae139248938" />

Screenshot tersebut menunjukkan input kondisi alat dengan contoh format yang diberikan kepada pengguna. Sistem juga memastikan bahwa kondisi tidak boleh dikosongkan.

#### Validasi ID Alat saat Mengubah

<img width="141" height="32" alt="image" src="https://github.com/user-attachments/assets/5add4371-f8cc-48c5-b32b-ce56777fce90" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan ID alat yang tidak terdapat dalam data. Sistem menampilkan pesan `Alat tidak ditemukan` dan tidak melanjutkan proses perubahan.

#### Validasi ID Alat saat Menghapus

<img width="152" height="56" alt="image" src="https://github.com/user-attachments/assets/bb36f1f9-c604-4b20-83f8-d6ec15ad9063" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan ID alat yang tidak ditemukan. Sistem menolak proses penghapusan dan menampilkan pesan `Alat tidak ditemukan`.

### 3. Validasi Data Penyewaan

#### Validasi Nama Penyewa

<img width="197" height="42" alt="image" src="https://github.com/user-attachments/assets/2218c93b-277a-49fa-b143-c6306a2daf02" />

Screenshot tersebut menunjukkan ketika nama penyewa dikosongkan. Sistem menolak input tersebut karena nama penyewa wajib diisi dan meminta pengguna memasukkan nama kembali.

#### Validasi ID Alat

<img width="131" height="27" alt="image" src="https://github.com/user-attachments/assets/b32a462c-6150-4c6a-be43-93f187de0082" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan ID alat yang tidak terdapat dalam data. Sistem menampilkan pesan `Alat tidak ditemukan` dan menghentikan proses penyewaan.

#### Validasi Jumlah Unit

<img width="195" height="56" alt="image" src="https://github.com/user-attachments/assets/c8289c9b-de88-4c1f-b6a2-07abc042603e" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan jumlah unit `0`. Sistem menolak input tersebut karena jumlah unit yang disewa harus lebih dari `0`.

#### Validasi Durasi Sewa

<img width="232" height="45" alt="image" src="https://github.com/user-attachments/assets/0699ab2b-ec84-41ac-939a-e25b3aa2bc47" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan durasi penyewaan `0` hari. Sistem menolak input tersebut karena durasi penyewaan harus lebih dari `0` hari.

### 4. Validasi Ketersediaan Alat

Sebelum transaksi penyewaan dibuat, sistem akan memeriksa jumlah alat yang tersedia. Jika jumlah unit yang diminta melebihi stok, transaksi tidak dapat dilanjutkan.

Pada contoh berikut, alat `SNK01` memiliki jumlah stok yang tersedia sebanyak 8 unit, sedangkan jumlah unit yang ingin disewa adalah 9 unit. Sistem kemudian menolak proses penyewaan karena jumlah yang diminta melebihi stok.

#### Percobaan Penyewaan Melebihi Stok

<img width="277" height="147" alt="image" src="https://github.com/user-attachments/assets/bff9d3eb-137e-4207-9c08-3470ed0e8bca" />

Screenshot tersebut menunjukkan ketika pengguna mencoba menyewa alat melebihi jumlah stok yang tersedia. Sistem menolak transaksi karena jumlah unit yang diminta lebih besar daripada stok alat.

### 5. Validasi Pengembalian

<img width="255" height="78" alt="image" src="https://github.com/user-attachments/assets/4c9d7cc1-71dd-4810-a348-ef5beccd14a8" />

Screenshot tersebut menunjukkan ketika pengguna memasukkan ID penyewaan yang tidak terdapat dalam data transaksi. Sistem menampilkan pesan `ID Penyewaan tidak ditemukan` dan tidak melanjutkan proses pengembalian.

## Penerapan Konsep OOP

Program menerapkan beberapa konsep Object-Oriented Programming (OOP) yang menjadi bagian utama dalam pengembangan sistem. Konsep yang digunakan meliputi Encapsulation, Inheritance, Polymorphism, dan Abstraction.

Selain konsep OOP tersebut, program juga menggunakan pola MVC untuk memisahkan bagian data, tampilan, dan pengendalian program. Interface `DapatDisewa` digunakan sebagai nilai tambah untuk menentukan kemampuan pengecekan ketersediaan alat.

### 1. Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut class `AlatSelam`. Atribut tersebut tidak dapat diakses secara langsung dari class lain sehingga akses terhadap data dilakukan melalui getter dan setter.

Contoh atribut pada `AlatSelam`:

<img width="585" height="181" alt="image" src="https://github.com/user-attachments/assets/130f3595-2333-407e-8dd4-bf475ae1ae1b" />

Screenshot tersebut menunjukkan atribut pada `AlatSelam` menggunakan access modifier `private`. Penggunaan `private` membatasi akses langsung terhadap atribut dari class lain.

Contoh getter dan setter:

**Getter:**

<img width="320" height="78" alt="image" src="https://github.com/user-attachments/assets/28e25f41-73b9-4367-98ba-f1855dc2f817" />

Screenshot tersebut menunjukkan method getter yang digunakan untuk mengambil nilai atribut private melalui method yang telah disediakan oleh class.

**Setter dan validasi:**

<img width="630" height="168" alt="image" src="https://github.com/user-attachments/assets/a9ac1793-4ed7-4950-a3f6-2324bdf43bca" />

Screenshot tersebut menunjukkan method setter yang digunakan untuk mengubah nilai atribut sekaligus melakukan validasi terhadap data yang diberikan.

### 2. Inheritance

Inheritance diterapkan dengan menggunakan `AlatSelam` sebagai superclass yang menjadi dasar bagi dua subclass, yaitu `AlatSnorkeling` dan `AlatDiving`.

Hubungan antar class dapat digambarkan sebagai berikut:

```text
AlatSelam (Superclass)
|-- AlatSnorkeling (Subclass)
|-- AlatDiving (Subclass)
```

AlatSnorkeling dan AlatDiving menggunakan keyword extends untuk mewarisi atribut dan method dari AlatSelam. Kedua subclass juga memiliki data tambahan yang berbeda sesuai dengan jenis alatnya

**Superclass AlatSelam:**

<img width="605" height="181" alt="image" src="https://github.com/user-attachments/assets/da63c084-0ca4-47e8-bd6e-4442b0dd592a" />

Screenshot tersebut menunjukkan `AlatSelam` sebagai superclass yang menyediakan atribut dan method umum untuk class turunannya.

**Subclass AlatSnorkeling:**

<img width="800" height="252" alt="image" src="https://github.com/user-attachments/assets/90165098-c27f-46b7-95d9-be2c7cda14b4" />

Screenshot tersebut menunjukkan `AlatSnorkeling` menggunakan keyword `extends` untuk mewarisi struktur dari `AlatSelam` serta memiliki atribut khusus berupa jenis perlengkapan.

**Subclass AlatDiving:**

<img width="802" height="251" alt="image" src="https://github.com/user-attachments/assets/1be64152-7dfd-4320-b1ab-e8b5bf782bd1" />

Screenshot tersebut menunjukkan `AlatDiving` menggunakan keyword `extends` untuk mewarisi struktur dari `AlatSelam` serta memiliki atribut khusus berupa kapasitas tabung.

Dengan inheritance, bagian yang sama dari alat dapat ditempatkan pada AlatSelam, sedangkan informasi khusus untuk masing-masing jenis alat ditambahkan pada subclass.

### 3. Polymorphism

Polymorphism diterapkan pada program melalui **overriding** dan **overloading**. Kedua bentuk tersebut digunakan pada method `tampilkanInfo()` untuk memberikan perilaku yang berbeda sesuai kebutuhan program.

#### Overriding

Overriding diterapkan pada method `tampilkanInfo()` yang dideklarasikan sebagai abstract pada `AlatSelam`. Method tersebut kemudian dibuat ulang pada `AlatSnorkeling` dan `AlatDiving` menggunakan annotation `@Override`.

Pada `AlatSnorkeling`, method `tampilkanInfo()` digunakan untuk menampilkan informasi tambahan berupa jenis perlengkapan snorkeling.

**Overriding pada `AlatSnorkeling`:**

<img width="745" height="111" alt="image" src="https://github.com/user-attachments/assets/f6f6e1fd-75a4-4733-9d37-1a0642b4628f" />

Screenshot tersebut menunjukkan method `tampilkanInfo()` pada `AlatSnorkeling` melakukan overriding terhadap method abstract yang dideklarasikan pada `AlatSelam`.

**Overriding pada `AlatDiving`:**

<img width="786" height="111" alt="image" src="https://github.com/user-attachments/assets/c860906b-1730-4a96-83a8-f639d47493d5" />

Screenshot tersebut menunjukkan method `tampilkanInfo()` pada `AlatDiving` melakukan overriding dengan memberikan implementasi yang sesuai dengan karakteristik alat diving.

#### Overloading

Overloading diterapkan pada class `AlatSelam` dengan menggunakan dua method bernama `tampilkanInfo()` yang memiliki parameter berbeda.

Method pertama tidak memiliki parameter, sedangkan method kedua memiliki satu parameter bertipe `boolean`.

**Overloading pada `AlatSelam`:**

<img width="401" height="40" alt="image" src="https://github.com/user-attachments/assets/c01d2a42-dbeb-4a56-94d5-bad3007add2b" />

Screenshot tersebut menunjukkan salah satu bentuk method `tampilkanInfo()` pada `AlatSelam` yang tidak menggunakan parameter.

<img width="702" height="207" alt="image" src="https://github.com/user-attachments/assets/58d18d46-17c2-446d-9194-3ebfd1bf9a24" />

Screenshot tersebut menunjukkan bentuk lain dari method `tampilkanInfo()` yang menggunakan parameter `boolean`. Perbedaan parameter tersebut menjadi pembeda antara kedua method dan menunjukkan penerapan overloading.

#### Polymorphism pada ArrayList

Polymorphism juga diterapkan pada penyimpanan data alat menggunakan `ArrayList<AlatSelam>`. Object dari `AlatSnorkeling` dan `AlatDiving` dapat disimpan dalam `ArrayList` tersebut karena keduanya merupakan turunan dari `AlatSelam`.

**Penggunaan `ArrayList<AlatSelam>`:**

<img width="763" height="278" alt="image" src="https://github.com/user-attachments/assets/bcdb4f02-ec27-4902-9b73-ba683529cc58" />

Screenshot tersebut menunjukkan penggunaan `ArrayList<AlatSelam>` yang dapat menyimpan object `AlatSnorkeling` dan `AlatDiving` karena kedua class tersebut merupakan turunan dari `AlatSelam`.

### 4. Abstraction

Abstraction diterapkan dengan menjadikan `AlatSelam` sebagai abstract class yang menjadi dasar untuk `AlatSnorkeling` dan `AlatDiving`. Class ini berisi struktur umum yang digunakan oleh kedua subclass.

Selain itu, `AlatSelam` memiliki abstract method `tampilkanInfo()` yang harus diimplementasikan oleh subclass. Dengan demikian, bagian umum dapat ditempatkan pada `AlatSelam`, sedangkan implementasi `tampilkanInfo()` ditentukan oleh masing-masing subclass.

**Abstract class `AlatSelam`:**

<img width="587" height="32" alt="image" src="https://github.com/user-attachments/assets/f7890785-34cd-4cd0-95fe-c00339785af8" />

Screenshot tersebut menunjukkan deklarasi `AlatSelam` sebagai abstract class. Class ini digunakan sebagai dasar bagi `AlatSnorkeling` dan `AlatDiving` dan tidak digunakan sebagai object langsung.

**Abstract method `tampilkanInfo()`:**

<img width="401" height="32" alt="image" src="https://github.com/user-attachments/assets/32edd5d4-fc42-4b5d-9539-fa626303ef1c" />

Screenshot tersebut menunjukkan method `tampilkanInfo()` yang dideklarasikan sebagai abstract. Method tersebut tidak memiliki implementasi pada `AlatSelam` dan harus diimplementasikan oleh subclass.

**Method `tampilkanDataDasar()`:**

<img width="677" height="180" alt="image" src="https://github.com/user-attachments/assets/ac411282-f50a-4fb0-8d87-69ccd7cc51d0" />

Screenshot tersebut menunjukkan method konkret `tampilkanDataDasar()` pada `AlatSelam` yang digunakan untuk menampilkan informasi umum alat dan dapat digunakan oleh subclass.

### 5. Interface sebagai Value Add

Interface `DapatDisewa` digunakan sebagai nilai tambah pada program. Interface ini berfungsi sebagai kontrak yang mendefinisikan kemampuan pengecekan ketersediaan alat sebelum proses penyewaan dilakukan.

#### Interface `DapatDisewa`

Interface `DapatDisewa` memiliki method `cekKetersediaan()` yang digunakan untuk mengecek apakah jumlah alat yang ingin disewa tersedia.

**Interface `DapatDisewa`:**

<img width="456" height="90" alt="image" src="https://github.com/user-attachments/assets/8fa520e2-90cb-4655-b835-4f3dabcb0566" />

Screenshot tersebut menunjukkan interface `DapatDisewa` yang mendefinisikan method `cekKetersediaan()` sebagai kontrak untuk pengecekan ketersediaan alat.

**Implementasi Interface pada `AlatSelam`:**

<img width="576" height="25" alt="image" src="https://github.com/user-attachments/assets/e8fe597a-5500-4ee3-b700-2ad105d61adc" />

Screenshot tersebut menunjukkan `AlatSelam` menggunakan keyword `implements DapatDisewa`, sehingga class tersebut terhubung dengan kontrak yang ditentukan oleh interface.

**Implementasi `cekKetersediaan()` pada subclass:**

<img width="582" height="82" alt="image" src="https://github.com/user-attachments/assets/cc37f16c-af57-4999-aadc-ed1a02355554" />

Screenshot tersebut menunjukkan implementasi method `cekKetersediaan()` pada subclass alat. Method tersebut digunakan untuk menentukan apakah jumlah unit yang ingin disewa masih tersedia.

### 6. MVC (Model-View-Controller)

Program menggunakan pola arsitektur MVC untuk memisahkan pengelolaan data, tampilan, dan alur program ke dalam bagian yang berbeda.

#### Model

Package `model` berisi class yang mewakili data dan objek dalam sistem, yaitu `AlatSelam`, `AlatSnorkeling`, `AlatDiving`, `Penyewa`, dan `Penyewaan`.

**Struktur package Model:**

<img width="188" height="160" alt="image" src="https://github.com/user-attachments/assets/65f144ac-620f-4ebb-92ae-5a7cc4af95a2" />

Screenshot tersebut menunjukkan package `model` yang berisi class-class yang merepresentasikan data dan objek dalam sistem.

#### View

Package `view` berisi `SewaAlatView` yang menangani tampilan menu dan input dari pengguna.

**Class `SewaAlatView`:**

<img width="525" height="247" alt="image" src="https://github.com/user-attachments/assets/a3d0f25e-718d-4098-b0e5-55d67fc5a4ec" />

Screenshot tersebut menunjukkan class `SewaAlatView` yang menangani tampilan menu dan penerimaan input dari pengguna.

#### Controller

Package `controller` berisi `SewaAlatController` yang mengatur proses program dan menghubungkan View dengan Model.

**Class `SewaAlatController`:**

<img width="347" height="375" alt="image" src="https://github.com/user-attachments/assets/38becd41-5f45-4427-9f46-ba75f73db245" />

Screenshot tersebut menunjukkan class `SewaAlatController` yang menangani alur proses program serta menghubungkan View dengan Model.

#### Hubungan MVC

Alur MVC pada program dimulai ketika `SewaAlatView` menerima input dari pengguna. Input tersebut diteruskan melalui `SewaAlatController` untuk diproses menggunakan data dari Model, kemudian hasilnya ditampilkan kembali melalui View.

Dengan pembagian tersebut, setiap bagian program memiliki tanggung jawab yang berbeda sehingga struktur project menjadi lebih terorganisir.

