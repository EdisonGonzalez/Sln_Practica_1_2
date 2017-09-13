package com.edisongonzalez.sln_practica_1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String nombre, apellido, correo, tel, sexo, hobbies="", ciudad, pass1, pass2;
    private EditText ename, elastname, ecorreo, etel, epass1, epass2;
    private Button breg;
    private TextView tinfo;
    private RadioButton rmasc, rfem;
    private CheckBox cCine, cDormir, cComer, cBailar;
    private Spinner sCiudades;
    public static EditText eDatePicker;
    public static int dayg, monthg, yearg;
    private byte flag_cv_1=1, flag_cv_2=1, flag_cv_3=1, flag_cv_4=1, flag_cv_5=1, flag_cv_6=1, flag7=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ename = (EditText) findViewById(R.id.ename);
        elastname = (EditText) findViewById(R.id.elastname);
        ecorreo = (EditText) findViewById(R.id.ecorreo);
        etel = (EditText) findViewById(R.id.etel);
        breg = (Button) findViewById(R.id.breg);
        tinfo = (TextView) findViewById(R.id.tinfo);
        rmasc = (RadioButton) findViewById(R.id.rmasculino);
        rfem = (RadioButton) findViewById(R.id.rfemenino);
        cCine = (CheckBox) findViewById(R.id.cCine);
        cDormir = (CheckBox) findViewById(R.id.cDormir);
        cComer = (CheckBox) findViewById(R.id.cComer);
        cBailar = (CheckBox) findViewById(R.id.cBailar);
        sCiudades = (Spinner) findViewById(R.id.ciudades);
        epass1 = (EditText) findViewById(R.id.epass1_id);
        epass2 = (EditText) findViewById(R.id.epass2_id);
        eDatePicker = (EditText) findViewById(R.id.eDatePicker_id);
//------------------------------------------------------
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ciudades, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sCiudades.setAdapter(adapter);
        //-------------------------------------------------

        sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //adapterView recibe el adaptar, el view, la posicion
                ciudad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        breg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Tomando los datos ingresados en los EditText
                hobbies="";
                nombre =  ename.getText().toString();
                apellido = elastname.getText().toString();
                tel = etel.getText().toString();
                pass1 = epass1.getText().toString();
                pass2 = epass2.getText().toString();
                correo = ecorreo.getText().toString();

                //Verificando si hay String vacias, campos no llenados
                if(TextUtils.isEmpty(nombre)){
                    ename.setError("Campo Vacio");
                    flag_cv_1 = 1;
                }
                else{
                    flag_cv_1 = 0;
                    ename.setError(null);
                }
                if(TextUtils.isEmpty(apellido)){
                    elastname.setError("Campo Vacio");
                    flag_cv_2 = 1;
                }
                else{
                    flag_cv_2 = 0;
                    elastname.setError(null);
                }
                if(TextUtils.isEmpty(tel)){
                    etel.setError("Campo Vacio");
                    flag_cv_3 = 1;
                }
                else{
                    flag_cv_3 = 0;
                    etel.setError(null);
                }
                if(TextUtils.isEmpty(pass1)){
                    epass1.setError("Campo Vacio");
                    flag_cv_4 = 1;
                }
                else{
                    flag_cv_4 = 0;
                    epass1.setError(null);
                }
                if(TextUtils.isEmpty(pass2)){
                    epass2.setError("Campo Vacio");
                    flag_cv_5 = 1;
                }
                else{
                    flag_cv_5 = 0;
                    epass2.setError(null);
                }
                if(TextUtils.isEmpty(correo)){
                    ecorreo.setError("Campo Vacio");
                    flag_cv_6 = 1;
                }
                else{
                    flag_cv_6 = 0;
                    ecorreo.setError(null);
                }

                //Indicando si el sexo es masculino o femenino
                if (rmasc.isChecked()){
                    sexo = "Masculino";
                }
                else{
                    sexo = "Femenino";
                }
                /*
                if (cCine.isChecked()){
                    hobbies = hobbies + "Le gusta ir a Cine, ";
                }
                if (cDormir.isChecked()){
                    hobbies = hobbies + "Le gusta Dormir, ";
                }
                if (cComer.isChecked()){
                    hobbies = hobbies + "Le gusta Comer, ";
                }
                if (cBailar.isChecked()){
                    hobbies = hobbies + "Le gusta Bailar, ";
                }
                */
                if (cCine.isChecked()){hobbies+="Le gusta ir a cine, ";}
                if (cDormir.isChecked()){hobbies+="Le gusta dormir, ";}
                if (cComer.isChecked()){hobbies+="Le gusta comer bastante, ";}
                if (cBailar.isChecked()){hobbies+="Le gusta ir a la disco y bailar, ";}

                if((flag_cv_1==0)&&(flag_cv_2==0)&&(flag_cv_3==0)&&(flag_cv_4==0)&&(flag_cv_5==0)&&(flag_cv_6==0)){
                    flag7=1;
                    flag_cv_1=1; flag_cv_2=1; flag_cv_3=1; flag_cv_4=1; flag_cv_5=1; flag_cv_6=1;
                }

                //Si contraseñas coinciden entonces si se vale el registro
                if(pass1.equals(pass2)){
                    if((flag7==1)) {
                        flag7 = 0;
                        tinfo.setText("Nombre: " + nombre + "\nApellido: " + apellido + "\nCorreo: " + correo + "\nTelefono: " + tel + "\nSexo: " + sexo + "\nHobbies: " + hobbies + "\nCiudad: " + ciudad + "\nFecha de Nacimiento (Dia/Mes/Año): " + dayg + "/" + monthg + "/" + yearg + "\nContraseña1: " + pass1 + "\nContraseña2: " + pass2);
                    }
                }
                else{
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Contraseñas no coinciden", Toast.LENGTH_LONG);
                    toast1.setGravity(Gravity.CENTER,0,0);
                    toast1.show();
                    tinfo.setText("Informacion");
                }


            }
        });
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker (ESP: Utilice la fecha actual como fecha predeterminada en el selector)
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it (ESP: Crear una nueva instancia de DatePickerDialog y devolverla)
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user (ESP: Hacer algo con la fecha elegida por el usuario)
            dayg = day;
            monthg = month + 1;
            yearg = year;
            eDatePicker.setText(dayg+"/"+(monthg)+"/"+yearg);
        }
    }

    // Showing the date picker: For example, here's calls a method to show the dialog. when clicked a button, textview or edittext. (ESP: Mostrando el selector de fecha: Por ejemplo, aquí hay una llamada para mostrar el diálogo. cuando se hace clic en un botón, textview o edittext)
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
