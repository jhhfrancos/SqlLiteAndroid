package co.com.jhhmoviles.directorioempresas;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

import co.com.jhhmoviles.directorioempresas.Model.Empresa;
import co.com.jhhmoviles.directorioempresas.Persistencia.EmpresaCRUD;

public class VerEmpresas extends ListActivity {

    private EmpresaCRUD empresasCrud;
    List<Empresa> empresas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_empresas);
        empresasCrud = new EmpresaCRUD(this);
        empresasCrud.open();
        empresas = empresasCrud.getAllEmpresas();
        empresasCrud.close();
        ArrayAdapter<Empresa> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, empresas);
        setListAdapter(adapter);
    }

}
