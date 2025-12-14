># Final Project D9

Topik         : Sistem Rekomendasi Teman Berdasarkan Mutual Friends

Tema          : Implementasi Struktur Data Graph, BFS, dan Algoritma Sorting untuk Fitur Rekomendasi di Media Sosial

Kelas         : D

Kelompok      : 9

Anggota       : 

- Maria Elvina Putri Damayanti (5026241012)

- Tavasya Alia Anjani (5026251067)

- Rofifah Zain Nur Alfiyah (5026241131)
  

Mata Kuliah    : Algoritma dan Struktur Data

Dosen Pengampu : Ibu Renny Pradina Kusumawardani
</br>
</br>
</br>

>1. Latar Belakang

Media sosial memanfaatkan jaringan pertemanan untuk menampilkan rekomendasi koneksi baru bagi penggunanya. Salah satu pendekatan yang umum adalah menampilkan calon teman yang memiliki mutual friends. Untuk mensimulasikan proses tersebut, hubungan antar pengguna direpresentasikan menggunakan graph. Dengan BFS, sistem mengekstrak teman level 2 (teman dari teman) untuk calon rekomendasi. Hasil rekomendasi kemudian diurutkan menggunakan algoritma sorting agar tampil lebih terstruktur dan mudah dibaca.
</br> 
</br>

>2. Fitur-Fitur
- Add Connection ⟶ menambahkan hubungan pertemanan antara 2 orang
- People You May Know ⟶ menampilkan rekomendasi teman (level 2) dari teman (level  1)
- Find Connection Path ⟶ menunjukkan jalur pertemanan antara user pertama dan user kedua
- Display All Connection ⟶ menampilkan list teman/koneksi dari seorang user
- Remove Connection ⟶ menghapus koneksi pertemanan antara 2 user
</br>

>3. Algoritma yang digunakan
Solusi dilakukan melalui lima langkah utama:
1. Representasi Data Menggunakan Graph (Adjacency List)

Pada tahap pertama, data pertemanan direpresentasikan menggunakan struktur graph. Setiap individu diperlakukan sebagai sebuah node, sedangkan hubungan pertemanan dihubungkan melalui edge. Implementasi graph dibuat menggunakan adjacency list yang disusun secara hardcoded dengan struktur data HashMap<String, List<String>>. Pendekatan ini dipilih agar struktur data lebih mudah dianalisis dan relevan dengan kebutuhan studi kasus yang bersifat sederhana. Representasi adjacency list memungkinkan akses cepat terhadap daftar teman dari setiap pengguna dengan kompleksitas waktu O(1).

2. Pencarian Teman Level 2 Menggunakan BFS

Tahap kedua adalah mengidentifikasi kandidat teman potensial melalui eksplorasi teman level 2 (teman dari teman) menggunakan algoritma Breadth-First Search (BFS). BFS dipilih karena mampu menelusuri graph secara sistematis berdasarkan level atau jarak dari node awal. Proses ini dimulai dari node pengguna, kemudian mengeksplorasi semua teman langsung (level 1), dan dilanjutkan dengan mengeksplorasi teman dari setiap teman langsung tersebut (level 2). Hasil dari tahap ini adalah daftar calon teman yang belum terhubung langsung dengan pengguna, namun memiliki koneksi melalui teman bersama.

3. Perhitungan dan Identifikasi Mutual Friends

Tahap ketiga adalah menghitung jumlah mutual friends antara pengguna dengan setiap kandidat teman yang ditemukan pada tahap sebelumnya. Proses ini dilakukan dengan mengambil daftar teman dari pengguna dan daftar teman dari kandidat, kemudian mencari irisan (intersection) dari kedua daftar tersebut menggunakan operasi set. Selain menghitung jumlah mutual friends, sistem juga menyimpan informasi detail berupa nama-nama teman bersama tersebut. Informasi ini penting untuk memberikan konteks kepada pengguna mengenai siapa saja yang menghubungkan mereka dengan kandidat teman, sehingga meningkatkan transparansi dan kepercayaan terhadap rekomendasi yang diberikan.

4. Pencarian Jalur Pertemanan (Friendship Path)

Tahap keempat adalah menemukan dan menampilkan jalur pertemanan dari pengguna ke setiap kandidat teman. Jalur pertemanan menunjukkan bagaimana pengguna dapat terhubung dengan kandidat melalui teman-teman mereka yang sudah ada. Implementasi dilakukan dengan memanfaatkan informasi mutual friends yang telah diperoleh pada tahap sebelumnya. Setiap jalur ditampilkan dalam format Pengguna → Mutual Friend → Kandidat, yang memberikan visualisasi sederhana namun informatif mengenai koneksi dalam jaringan pertemanan. Fitur ini membantu pengguna memahami konteks hubungan mereka dengan kandidat teman, serta mempermudah pengambilan keputusan dalam menerima atau menolak rekomendasi.

5. Pengurutan Hasil Rekomendasi Menggunakan Bubble Sort

Tahap terakhir adalah mengurutkan daftar rekomendasi yang telah difilter dan dilengkapi dengan informasi mutual friends serta jalur pertemanan. Pengurutan dilakukan menggunakan algoritma Bubble Sort secara alfabetis berdasarkan nama kandidat. Pemilihan algoritma ini didasarkan pada kesederhanaannya, kemudahan implementasi, serta kecocokannya untuk dataset kecil seperti pada studi kasus ini. Hasil pengurutan membuat daftar rekomendasi tersaji dengan lebih rapi, terstruktur, dan mudah dibaca oleh pengguna melalui tampilan console.

 
>4. Screenshoot tampilan program
   1. Main Menu
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/01972621-c682-4ff4-837a-2f876e4e576a" />


   2. Add Connection
<img width="1913" height="1076" alt="image" src="https://github.com/user-attachments/assets/dfb69834-60eb-4fcb-864c-fa8ccb171854" />


   3. People You May Know
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/f6becda5-fe92-4088-b0da-adf4ee8b7def" />


   4. Find Connection Path
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/0cfa8449-33c2-4065-8409-0923fc6831c8" />

   5. Display All Connection
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/cfd802c8-a1b3-4cb9-a975-b4e7d6750606" />

   6. Remove Connection
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/0d4515e2-fbfd-4172-905c-c2def8ca3123" />


>5. Struktur File Proyek
## 📂 Struktur File

```text
FinalProjectD9/
|
|-- .idea/                         # Konfigurasi IDE (IntelliJ)
|
|-- ASD/                           # Source code utama
|   |
|   |-- Main.java                  # Entry point program
|   |-- Menu.java                  # UI menu berbasis console
|   |-- GraphLogic.java            # Logika graph & mutual friends (BFS)
|   |-- CSVLoader.java             # Loader data dari file CSV
|   |-- input.csv                  # Data relasi pertemanan
|
|-- FINAL PROJECT ASD D9.pdf       # Laporan akhir proyek
|
|-- README.md                      # Dokumentasi proyek
```




