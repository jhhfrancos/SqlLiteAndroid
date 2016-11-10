package co.com.jhhmoviles.directorioempresas;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import co.com.jhhmoviles.directorioempresas.Model.Empresa;
import co.com.jhhmoviles.directorioempresas.Persistencia.EmpresaCRUD;

public class AddUpdateEmpresa extends AppCompatActivity {

    private static final String EXTRA_EMP_ID = "empresaId";
    private static final String EXTRA_ADD_UPDATE = "Add";
    private static final String DIALOG_DATE = "DialogDate";
    
    private EditText nombreText;
    private EditText urlText;
    private EditText telefonoContactoText;
    private EditText eMailText;
    private EditText productosServiciosText;
    private EditText clasificacionText;
    private Button addUpdateButton;
    private Empresa newEpresa;
    private Empresa viejaEmpresa;
    private String mode;
    private long empresaId;
    private EmpresaCRUD empresaCRUD;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update_empresa);
        newEpresa = new Empresa();
        viejaEmpresa = new Empresa();
        nombreText = (EditText)findViewById(R.id.edit_text_nombre);
        urlText = (EditText)findViewById(R.id.edit_text_url);
        telefonoContactoText = (EditText) findViewById(R.id.edit_text_telefonoContacto);
        eMailText = (EditText) findViewById(R.id.edit_text_eMail);
        productosServiciosText = (EditText) findViewById(R.id.edit_text_productosServicios);
        clasificacionText = (EditText) findViewById(R.id.edit_text_clasificacion);
        addUpdateButton = (Button)findViewById(R.id.button_add_update_empresa);
        empresaCRUD = new EmpresaCRUD(this);
        empresaCRUD.open();


        mode = EXTRA_ADD_UPDATE;
        if(mode.equals("Update")){

            addUpdateButton.setText("Update Empresa");
            empresaId = getIntent().getLongExtra(EXTRA_EMP_ID,0);

            initializeEmpresa(empresaId);

        }



        addUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mode.equals("Add")) {
                    newEpresa.setNombre(nombreText.getText().toString());
                    newEpresa.setUrl(urlText.getText().toString());
                    newEpresa.setTelefonoContacto(telefonoContactoText.getText().toString());
                    newEpresa.seteMail(eMailText.getText().toString());
                    newEpresa.setProductosServicios(productosServiciosText.getText().toString());
                    newEpresa.setClasificacion(clasificacionText.getText().toString());
                    empresaCRUD.addEmpresa(newEpresa);
                    Toast t = Toast.makeText(AddUpdateEmpresa.this, "Empresa "+ newEpresa.getNombre() + "se ha añadido!", Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(AddUpdateEmpresa.this,MainActivity.class);
                    startActivity(i);
                }else {
                    viejaEmpresa.setNombre(nombreText.getText().toString());
                    viejaEmpresa.setUrl(urlText.getText().toString());
                    viejaEmpresa.setTelefonoContacto(telefonoContactoText.getText().toString());
                    viejaEmpresa.seteMail(eMailText.getText().toString());
                    viejaEmpresa.setProductosServicios(productosServiciosText.getText().toString());
                    viejaEmpresa.setClasificacion(clasificacionText.getText().toString());
                    empresaCRUD.updateEmpresa(viejaEmpresa);
                    Toast t = Toast.makeText(AddUpdateEmpresa.this, "Empresa "+ viejaEmpresa.getNombre() + " Se ha actualizado!", Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(AddUpdateEmpresa.this,MainActivity.class);
                    startActivity(i);

                }


            }
        });


    }

    private void initializeEmpresa(long empId) {
        viejaEmpresa = empresaCRUD.getEmpresa(empId);

        nombreText.setText(viejaEmpresa.getNombre());
        urlText.setText(viejaEmpresa.getUrl());
        telefonoContactoText.setText(viejaEmpresa.getTelefonoContacto());
        eMailText.setText(viejaEmpresa.geteMail());
        productosServiciosText.setText(viejaEmpresa.getProductosServicios());
        clasificacionText.setText(viejaEmpresa.getClasificacion());

    }


}
