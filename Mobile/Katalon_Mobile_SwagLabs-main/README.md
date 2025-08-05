# Katalon_Mobile_SwagLabs

Ini adalah repositori framework pengujian Mobile App, dibangun dengan Katalon Studio.

## Struktur Folder

- **Test_Cases/**  
  Berisi kumpulan kode pengujian fitur yang dipisahkan sesuai Test Case Suites.

- **Object_Repository/**  
  Berisi kumpulan locator elemen-elemen yang akan dipakai di Test Case, dipisahkan sesuai kelompok yang digunakan oleh test case.

- **Test_Suites/**  
  Berisi file untuk menjalankan Test Suite berdasarkan kelompok test case.

  - **Test_Suites/TSC_SWAG**  
    File untuk menjalankan seluruh test case suite secara langsung.

- **Data_Files/**  
  Berisi file Excel sebagai sumber data untuk pengujian **Data-Driven Testing (DDT)**.

- **Keywords/GridHelper.groovy**  
  Berisi kumpulan Custom Keyword sebagai utility (misalnya login, swipe, scroll).

- **Test_Listeners/BaseSwag**  
  Berisi kode untuk pengaturan awal framework pengujian (setup & teardown).

## Saran Pengembangan

- Membuat Keyword Utility seperti `loginApp()` agar saat record, state aplikasi langsung berada di halaman utama/menu.
- Menstabilkan element locator: **hindari penggunaan `Delay`**, gunakan `WaitForElementPresent` atau `WaitForElementVisible` untuk meningkatkan keandalan.
