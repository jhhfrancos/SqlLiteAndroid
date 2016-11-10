package co.com.jhhmoviles.directorioempresas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import co.com.jhhmoviles.directorioempresas.Persistencia.EmpresaCRUD;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_EMPRESAID = "co.com.jhhmoviles.empresaId";
    private static final String EXTRA_ADD_UPDATE = "co.com.jhhmoviles.add_update";

    private EmpresaCRUD empresaCRUD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_add:
                addEmpresa();
                return true;
            case R.id.action_update:
                getEmpIdAndUpdateEmp();
                return true;
            case R.id.action_delete:
                return true;
            case R.id.action_viewall:
                verEmpresas();
                return true;
        }
        return false;
    }
    private void addEmpresa(){
        Intent i = new Intent(MainActivity.this,AddUpdateEmpresa.class);
        i.putExtra(EXTRA_ADD_UPDATE, "Add");
        startActivity(i);
    }
    public void getEmpIdAndUpdateEmp(){
    }
    private void verEmpresas(){
        Intent i = new Intent(MainActivity.this, VerEmpresas.class);
        startActivity(i);
    }
}
