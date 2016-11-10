package co.com.jhhmoviles.directorioempresas.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.com.jhhmoviles.directorioempresas.Model.Empresa;


public class EmpresaCRUD {
    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            EmpresaBdHandler.COLUMN_ID,
            EmpresaBdHandler.COLUMN_CLASIFICACION,
            EmpresaBdHandler.COLUMN_EMAIL,
            EmpresaBdHandler.COLUMN_NOMBRE,
            EmpresaBdHandler.COLUMN_PRODUCTOSSERVICIOS,
            EmpresaBdHandler.COLUMN_TELEFONOCONTACTO,
            EmpresaBdHandler.COLUMN_URL,
    };

    public EmpresaCRUD(Context context){
        dbhandler = new EmpresaBdHandler(context);
    }

    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database = dbhandler.getWritableDatabase();


    }
    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }
    public Empresa addEmpresa(Empresa Empresa){
        ContentValues values  = new ContentValues();
        values.put(EmpresaBdHandler.COLUMN_NOMBRE,Empresa.getNombre());
        values.put(EmpresaBdHandler.COLUMN_URL,Empresa.getUrl());
        values.put(EmpresaBdHandler.COLUMN_TELEFONOCONTACTO, Empresa.getTelefonoContacto());
        values.put(EmpresaBdHandler.COLUMN_EMAIL, Empresa.geteMail());
        values.put(EmpresaBdHandler.COLUMN_PRODUCTOSSERVICIOS, Empresa.getProductosServicios());
        long insertid = database.insert(EmpresaBdHandler.TABLE_EMPRESA,null,values);
        Empresa.setEmpresaId(insertid);
        return Empresa;
    }

    // Getting single Empresa
    public Empresa getEmpresa(long id) {

        Cursor cursor = database.query(EmpresaBdHandler.TABLE_EMPRESA,allColumns,EmpresaBdHandler.COLUMN_ID + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Empresa e = new Empresa(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
        // return Empresa
        return e;
    }

    public List<Empresa> getAllEmpresas() {

        Cursor cursor = database.query(EmpresaBdHandler.TABLE_EMPRESA,allColumns,null,null,null, null, null);

        List<Empresa> Empresas = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Empresa Empresa = new Empresa();
                Empresa.setEmpresaId(cursor.getLong(cursor.getColumnIndex(EmpresaBdHandler.COLUMN_ID)));
                Empresa.setNombre(cursor.getString(cursor.getColumnIndex(EmpresaBdHandler.COLUMN_NOMBRE)));
                Empresa.setUrl(cursor.getString(cursor.getColumnIndex(EmpresaBdHandler.COLUMN_URL)));
                Empresa.setTelefonoContacto(cursor.getString(cursor.getColumnIndex(EmpresaBdHandler.COLUMN_TELEFONOCONTACTO)));
                Empresa.seteMail(cursor.getString(cursor.getColumnIndex(EmpresaBdHandler.COLUMN_EMAIL)));
                Empresa.setProductosServicios(cursor.getString(cursor.getColumnIndex(EmpresaBdHandler.COLUMN_PRODUCTOSSERVICIOS)));
                Empresa.setClasificacion(cursor.getString(cursor.getColumnIndex(EmpresaBdHandler.COLUMN_CLASIFICACION)));
                Empresas.add(Empresa);
            }
        }
        // return All Empresas
        return Empresas;
    }




    // Updating Empresa
    public int updateEmpresa(Empresa Empresa) {

        ContentValues values = new ContentValues();
        values.put(EmpresaBdHandler.COLUMN_NOMBRE, Empresa.getNombre());
        values.put(EmpresaBdHandler.COLUMN_URL, Empresa.getUrl());
        values.put(EmpresaBdHandler.COLUMN_TELEFONOCONTACTO, Empresa.getTelefonoContacto());
        values.put(EmpresaBdHandler.COLUMN_EMAIL, Empresa.geteMail());
        values.put(EmpresaBdHandler.COLUMN_PRODUCTOSSERVICIOS, Empresa.getProductosServicios());
        values.put(EmpresaBdHandler.COLUMN_CLASIFICACION, Empresa.getClasificacion());
        // updating row
        return database.update(EmpresaBdHandler.TABLE_EMPRESA, values,
                EmpresaBdHandler.COLUMN_ID + "=?",new String[] { String.valueOf(Empresa.getEmpresaId())});
    }

    // Deleting Empresa
    public void removeEmpresa(Empresa Empresa) {

        database.delete(EmpresaBdHandler.TABLE_EMPRESA, EmpresaBdHandler.COLUMN_ID + "=" + Empresa.getEmpresaId(), null);
    }


}
