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
- Struktur Data: Graph (Adjacency List) ⟶
  Node = pengguna, Edge = pertemanan
  Implementasi: HashMap<String, List<String>>

- Algoritma BFS ⟶
  Mengekstrak teman level 2 (teman dari teman)
  Mempermudah perhitungan mutual friends
  
- Algoritma Mutual Friends ⟶ Hitung jumlah teman yang sama dengan user
- Algoritma Sorting (Bubble Sort) ⟶ Mengurutkan daftar rekomendasi alfabetical
 
>4. Screenshoot tampilan program
   1. Main Menu
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/01972621-c682-4ff4-837a-2f876e4e576a" />


   2. Add Connection
<img width="1913" height="1076" alt="image" src="https://github.com/user-attachments/assets/dfb69834-60eb-4fcb-864c-fa8ccb171854" />


   3. People You May Know
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/f6becda5-fe92-4088-b0da-adf4ee8b7def" />


   4. Find Connection Path

   5. Display All Connection
  
   6. Remove Connection 



