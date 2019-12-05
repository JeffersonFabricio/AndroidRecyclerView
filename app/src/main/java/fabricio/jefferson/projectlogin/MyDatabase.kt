package fabricio.jefferson.projectlogin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class MyDatabase(context: Context) : SQLiteOpenHelper(context, "aula.db", null, 1) {
    companion object {

        const val TAG = "MyDatabase"
        const val TABLE_USUARIO: String = "USUARIO"
        const val TABLE_ATIVIDADE: String = "ATIVIDADE"
        const val ID_USUARIO: String = "ID"
        const val ID_ATIVIDADE: String = "ID"
        const val CPF: String = "CPF"
        const val EMAIL: String = "EMAIL"
        const val LOGIN: String = "LOGIN"
        const val PASSWORD: String = "PASSWORD"
        const val ATIVIDADE: String = "ATIVIDADE"
        const val DIA: String = "DIA"
    }

    val DATABASE_CREATE_USUARIO =
        "CREATE TABLE if not exists " + TABLE_USUARIO + " (" +
                "${ID_USUARIO} integer PRIMARY KEY autoincrement," +
                "${CPF} integer," +
                "${EMAIL} text"+
                "${LOGIN} text"+
                "${PASSWORD} text"+
                ")"

    val DATABASE_CREATE_ATIVIDADE =
        "CREATE TABLE if not exists " + TABLE_ATIVIDADE + " (" +
                "${ID_ATIVIDADE} integer PRIMARY KEY autoincrement," +
                "${ATIVIDADE} text," +
                "${DIA} text" +
                "FOREIGN KEY (${ID_USUARIO}) REFERENCES ${TABLE_USUARIO}" +
                "(${ID_USUARIO})" +
                ")"

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("MyDatabase", "Creating: $DATABASE_CREATE_USUARIO")
        Log.d("MyDatabase", "Creating: $DATABASE_CREATE_ATIVIDADE")
        db?.execSQL(DATABASE_CREATE_USUARIO)
        db?.execSQL(DATABASE_CREATE_ATIVIDADE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_USUARIO)
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_ATIVIDADE)
        onCreate(db)
    }

    fun insertLog(text: String) {
        val valuesUsuario = ContentValues()
        valuesUsuario.put(CPF, text)
        valuesUsuario.put(EMAIL, text)
        valuesUsuario.put(LOGIN, text)
        valuesUsuario.put(PASSWORD, text)
        writableDatabase.insert(TABLE_USUARIO, null, valuesUsuario)

        val valuesActivity = ContentValues()
        valuesActivity.put(ATIVIDADE, text)
        valuesActivity.put(DIA, text)
        writableDatabase.insert(TABLE_ATIVIDADE, null, valuesActivity)
    }

    fun getLogsUsuarios(): Cursor {
        return readableDatabase
            .query(TABLE_USUARIO, arrayOf(ID_USUARIO, CPF, EMAIL, LOGIN, PASSWORD),
                null, null, null, null, null)
    }

    fun getLogUsuario(id: Int) : Cursor {
        return getReadableDatabase()
            .query(TABLE_USUARIO, arrayOf(ID_USUARIO, CPF, EMAIL, LOGIN, PASSWORD),
                "${ID_USUARIO}=${id}", null, null, null, null)
    }

    fun getLogsAtividades(): Cursor {
        return readableDatabase
            .query(TABLE_ATIVIDADE, arrayOf(ID_ATIVIDADE, ATIVIDADE, DIA),
                null, null, null, null, null)
    }

    fun getLogAtividade(id: Int) : Cursor {
        return getReadableDatabase()
            .query(TABLE_ATIVIDADE, arrayOf(ID_ATIVIDADE, ATIVIDADE, DIA),
                "${ID_USUARIO}=${id}", null, null, null, null)
    }

    fun updateLogUsuario(id: Int, text: String) {
        val values = ContentValues()
        values.put(CPF, text)
        values.put(EMAIL, text)
        values.put(LOGIN, text)
        values.put(PASSWORD, text)

        getWritableDatabase().update(TABLE_USUARIO, values, "${ID_USUARIO}=${id}", null)
    }

    fun removeLogUsuario(id: Int): Int {
        return writableDatabase.delete(TABLE_ATIVIDADE, "${ID_ATIVIDADE}=${id}", null)
        return writableDatabase.delete(TABLE_USUARIO, "${ID_USUARIO}=${id}", null)
    }

    fun updateLogAtividade(id: Int, text: String) {
        val values = ContentValues()
        values.put(ATIVIDADE, text)
        values.put(DIA, text)

        getWritableDatabase().update(TABLE_ATIVIDADE, values, "${ID_ATIVIDADE}=${id}", null)
    }

    fun removeLogAtividade(id: Int): Int {
        return writableDatabase.delete(TABLE_ATIVIDADE, "${ID_ATIVIDADE}=${id}", null)
    }

}
