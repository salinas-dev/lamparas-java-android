package com.salinas.norasalinasexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.salinas.norasalinasexamen.model.Lampara;


public class MainActivity extends AppCompatActivity {

    Spinner tipoLamparaSpinner;
    EditText cantidadLamparaEditText;
    Button calcularButton;
    Button btnNuevo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tipoLampara[] = {"--SELECCIONE TIPO DE LAMPARA--", "Normal", "Buro", "Decorativa"};

        calcularButton = findViewById(R.id.calcular_button);
        cantidadLamparaEditText = findViewById(R.id.cantidad_lampara);
        tipoLamparaSpinner = findViewById(R.id.tipo_lampara_spinner);
        btnNuevo = findViewById(R.id.buttonNuevo);

        ArrayAdapter<String> adapterTipoLampara = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, tipoLampara);

        tipoLamparaSpinner.setAdapter(adapterTipoLampara);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = tipoLamparaSpinner.getSelectedItem().toString();
                int cantidad = Integer.parseInt(cantidadLamparaEditText.getText().toString());

                Lampara lampara = new Lampara(tipo, cantidad);

                Toast.makeText(getApplicationContext(),
                        "El precio de venta es: " + lampara.getPrecioVenta() +
                                "\nDescuento: " + lampara.calcularDescuento(lampara.getPrecioVenta()) +
                                "\nTotal a pagar: " + lampara.calcularTotalCompra(),
                        Toast.LENGTH_LONG).show();
            }
        });

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Borrar el contenido de los campos de texto

                cantidadLamparaEditText.setText("");

                // Aquí puedes agregar cualquier otro código que desees que se ejecute cuando se haga clic en el botón "Nuevo"
                Toast.makeText(getApplicationContext(), "¡Botón Nuevo clickeado!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void salir(View v){
        finish();
    }
}
