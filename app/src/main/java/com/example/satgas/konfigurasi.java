package com.example.satgas;

public class konfigurasi {
    //Dibawah ini adalah Pengalamatan tempat terseimpannya Lokasi Skrip CRUD PHP
    //Tutorial Kali ini, kita menggunakan localhost maka untuk alamatnya tertuju ke file PHP
    //dimana PHP file tersebut disimpan
    //Catatan! JANGAN LUPA untuk Mengganti IP SESUAI DENGAN IP KOMPUTER teman - teman DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.0.104/satgas/insert.php";
    public static final String URL_GET_ALL = "http://192.168.43.163/satgas/tampilSemuaPgw.php";
    public static final String URL_GET_GATE = "http://192.168.43.163/satgas/tampilPgw.php?id=";
    public static final String URL_UPDATE_GATE = "http://192.168.43.163/satgas/update_gate.php";
    public static final String URL_DELETE_GATE = "http://192.168.43.163/satgas/hapusPgw.php?id=";

    //Dibawah ini merupakan script atau perintah untuk mengirim permintaan ke dalam Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "nama_area";
    public static final String KEY_EMP_LUAS = "luas_area";
    public static final String KEY_EMP_KEBUTUHAN = "kebutuhan_air";
    public static final String KEY_EMP_MOISTURE = "moisture";
    public static final String KEY_EMP_JENIS = "jenis_tanaman";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "nama_area";
    public static final String TAG_LUAS = "luas_area";
    public static final String TAG_KEBUTUHAN = "kebutuhan_air";
    public static final String TAG_MOISTURE = "moisture";
    public static final String TAG_JENIS = "jenis_tanaman";

    //ID GATE
    public static final String GATE_ID = "gate_id";
}
