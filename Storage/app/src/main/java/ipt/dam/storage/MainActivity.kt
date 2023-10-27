package ipt.dam.storage

import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.PrintStream
import java.util.Scanner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            val permission = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            requestPermissions(permission, 112)
        }


        val btnWrite1 = findViewById(R.id.button) as Button
        btnWrite1.setOnClickListener {
            write1();
        }

        val btnRead1 = findViewById(R.id.button2) as Button
        btnRead1.setOnClickListener {
            read1();
        }

        val btnWrite2 = findViewById(R.id.button3) as Button
        btnWrite2.setOnClickListener {
            write2();
        }

        val btnRead2 = findViewById(R.id.button4) as Button
        btnRead2.setOnClickListener {
            read2();
        }

        val btnWrite3 = findViewById(R.id.button5) as Button
        btnWrite3.setOnClickListener {
            write3();
        }

        val btnRead3 = findViewById(R.id.button6) as Button
        btnRead3.setOnClickListener {
            read3();
        }

        val btnWrite4 = findViewById(R.id.button7) as Button
        btnWrite4.setOnClickListener {
            write4();
        }

        val btnRead4 = findViewById(R.id.button8) as Button
        btnRead4.setOnClickListener {
            read4();
        }

        val btnWrite5 = findViewById(R.id.button9) as Button
        btnWrite5.setOnClickListener {
            write5();
        }

        val btnRead5 = findViewById(R.id.button10) as Button
        btnRead5.setOnClickListener {
            read5();
        }
    }

    fun write1() {
        // escrita usando o sharedPreference
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("NOME", "Paulo")
        editor.putInt("IDADE", 45)
        editor.commit()
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
    }

    fun read1() {
        // leitura usando o sharedPreferences
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val nome = sharedPreferences.getString("NOME","Sem Nome")
        val idade = sharedPreferences.getInt("IDADE", 0)
        Toast.makeText(this,"Olá " + nome + " de " + idade + " anos.",Toast.LENGTH_LONG).show()
    }

    fun write2() {
        // escrita usando o sharedPreference
        val sharedPreferencesNomes = getSharedPreferences("nomes.dat",MODE_PRIVATE)
        val sharedPreferencesIdades = getSharedPreferences("idades.dat",MODE_PRIVATE)
        val editorNomes: SharedPreferences.Editor = sharedPreferencesNomes.edit()
        val editorIdades: SharedPreferences.Editor = sharedPreferencesIdades.edit()
        editorNomes.putString("NOME", "Paulo")
        editorIdades.putInt("IDADE", 45)
        editorNomes.commit()
        editorIdades.commit()
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
    }

    fun read2() {
        // leitura usando o sharedPreferences
        val sharedPreferencesNomes = getSharedPreferences("nomes.dat",MODE_PRIVATE)
        val sharedPreferencesIdades = getSharedPreferences("idades.dat",MODE_PRIVATE)
        val nome = sharedPreferencesNomes.getString("NOME","Sem Nome")
        val idade = sharedPreferencesIdades.getInt("IDADE", 0)
        Toast.makeText(this,"Olá " + nome + " de " + idade + " anos.",Toast.LENGTH_LONG).show()
    }

    fun write3() {
        // escrita no internal Storage
        val directory: File = getFilesDir()
        val file: File  = File(directory, "dados.txt")
        val fo: FileOutputStream = FileOutputStream(file)
        val ps: PrintStream = PrintStream(fo)
        ps.println("Paulo")
        ps.println("45")
        ps.close()
        fo.close()
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
    }

    fun read3() {
        // leitura do internal Storage
        val directory: File  = getFilesDir()
        val file: File  = File(directory, "dados.txt")
        try {
            val fi: FileInputStream = FileInputStream(file)
            val sc: Scanner = Scanner(fi)
            val nome = sc.nextLine()
            val idade = sc.nextLine()
            sc.close()
            fi.close()
            Toast.makeText(this, "Olá " + nome + " de " + idade + " anos.", Toast.LENGTH_LONG).show()
        } catch (e: FileNotFoundException) {
            Toast.makeText(this, "File not found", Toast.LENGTH_LONG).show()
        }
    }

    fun write4() {
        // escrita no internal Storage
        val directory: File = getExternalFilesDir(Environment.DIRECTORY_DCIM)!!
        val file: File  = File(directory, "dados.txt")
        val fo: FileOutputStream = FileOutputStream(file)
        val ps: PrintStream = PrintStream(fo)
        ps.println("Paulo")
        ps.println("45")
        ps.close()
        fo.close()
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
    }

    fun read4() {
        // leitura do internal Storage
        val directory: File = getExternalFilesDir(Environment.DIRECTORY_DCIM)!!
        val file: File  = File(directory, "dados.txt")
        try {
            val fi: FileInputStream = FileInputStream(file)
            val sc: Scanner = Scanner(fi)
            val nome = sc.nextLine()
            val idade = sc.nextLine()
            sc.close()
            fi.close()
            Toast.makeText(this, "Olá " + nome + " de " + idade + " anos.", Toast.LENGTH_LONG).show()
        } catch (e: FileNotFoundException) {
            Toast.makeText(this, "File not found", Toast.LENGTH_LONG).show()
        }
    }

    fun write5() {
        // escrita no internal Storage
        val directory: File = getCacheDir()
        val file: File  = File(directory, "dados.txt")
        val fo: FileOutputStream = FileOutputStream(file)
        val ps: PrintStream = PrintStream(fo)
        ps.println("Paulo")
        ps.println("45")
        ps.close()
        fo.close()
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
    }

    fun read5() {
        // leitura do internal Storage
        val directory: File = getCacheDir()
        val file: File  = File(directory, "dados.txt")
        try {
            val fi: FileInputStream = FileInputStream(file)
            val sc: Scanner = Scanner(fi)
            val nome = sc.nextLine()
            val idade = sc.nextLine()
            sc.close()
            fi.close()
            Toast.makeText(this, "Olá " + nome + " de " + idade + " anos.", Toast.LENGTH_LONG).show()
        } catch (e: FileNotFoundException) {
            Toast.makeText(this, "File not found", Toast.LENGTH_LONG).show()
        }
    }
}