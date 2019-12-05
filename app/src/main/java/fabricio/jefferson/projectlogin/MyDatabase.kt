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
        const val TABLE = "usuario"
        const val ID: String = "ID"
        const val TIMESTAMP: String = "TIMESTAMP"
        const val TEXT: String = "TEXT"
    }

    val DATABASE_CREATE =
        "CREATE TABLE if not exists " + TABLE + " (" +
                "${ID} integer PRIMARY KEY autoincrement," +
                "${TIMESTAMP} integer," +
                "${TEXT} text"+
                ")"

    fun insertLog(text: String) {
        val values = ContentValues()
        values.put(TEXT, text)
        values.put(TIMESTAMP, System.currentTimeMillis())
        writableDatabase.insert(TABLE, null, values);
    }

    fun getLogs(): Cursor {
        return readableDatabase
            .query(TABLE, arrayOf(ID, TIMESTAMP, TEXT), null, null, null, null, null);
    }

    fun getLog(id: Int) : Cursor {
        return getReadableDatabase()
            .query(TABLE, arrayOf(ID, TIMESTAMP, TEXT), "${ID}=${id}", null, null, null, null)
    }

    fun updateLog(id: Int, text: String) {
        val values = ContentValues()
        values.put(TEXT, text)
        values.put(TIMESTAMP, System.currentTimeMillis())

        getWritableDatabase().update(TABLE, values, "${ID}=${id}", null)
    }

    fun removeLog(id: Int): Int {
        return writableDatabase.delete(TABLE, "${ID}=${id}", null)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("MyDatabase", "Creating: $DATABASE_CREATE")
        db?.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE);
        onCreate(db);
    }

}
