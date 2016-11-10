package co.com.jhhmoviles.directorioempresas.Persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class EmpresaBdHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "directorioEmpresas.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_EMPRESA = "empresa";
    public static final String COLUMN_ID = "empresaId";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_URL = "url";
    public static final String COLUMN_TELEFONOCONTACTO = "telefonoContacto";
    public static final String COLUMN_EMAIL = "eMail";
    public static final String COLUMN_PRODUCTOSSERVICIOS= "productosServicios";
    public static final String COLUMN_CLASIFICACION= "clasificacion";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_EMPRESA + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOMBRE + " TEXT, " +
                    COLUMN_URL + " TEXT, " +
                    COLUMN_TELEFONOCONTACTO + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PRODUCTOSSERVICIOS + " TEXT, " +
                    COLUMN_CLASIFICACION + " TEXT " +
                    ")";

    public EmpresaBdHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EMPRESA);
        db.execSQL(TABLE_CREATE);
    }
}
