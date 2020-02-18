package com.machalahubert.pl.java1_project;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_tools_nwd extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools_nwd,container,false);

        final TextView obliczenia = view.findViewById(R.id.nwd_obliczenia);
        final TextView obliczenia_label = view.findViewById(R.id.nwd_obliczenia_label);
        final TextView wynik = view.findViewById(R.id.nwd_wynik);
        final EditText liczba1 =  view.findViewById(R.id.liczba1);
        final EditText liczba2 =  view.findViewById(R.id.liczba2);

        //final Editable a = liczba1.getText();
        //final Editable b = liczba2.getText();


        Button oblicz = view.findViewById(R.id.nwd_oblicz);

        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    // schowanie klawiatury po kliknięciu buttona
                    liczba1.onEditorAction(EditorInfo.IME_ACTION_DONE);
                    liczba2.onEditorAction(EditorInfo.IME_ACTION_DONE);

                    int war1, war2;

                    try {
                        war1 = Integer.parseInt(liczba1.getText().toString());
                        war2 = Integer.parseInt(liczba2.getText().toString());

                        String dzialania = "";
                        int a = war1;
                        int b = war2;
                        int c;
                        while (b != 0) {
                            c = a % b;
                            dzialania += "" + a + " : " + b + " = " + a / b + " reszty " + c;
                            if(c!=0)
                                dzialania += "\n";
                            a = b;
                            b = c;

                        }
                        //dzialania += "NWD = "+a+"\n";

                        String wynik_s = "NWD(" + war1 + "," + war2 + ") = " + a;
                        obliczenia.setText(dzialania);
                        obliczenia.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        obliczenia.setTextColor(Color.parseColor("#000000"));
                        obliczenia.setPadding(0,0,0,0);
                        obliczenia.setTextSize(25);
                        obliczenia_label.setVisibility(View.VISIBLE);



                        wynik.setText(wynik_s);
                        wynik.setVisibility(View.VISIBLE);
                        //wynik.setBackground(Color.valueOf(R.drawable.border1));


                    } catch (NumberFormatException e) {
                        obliczenia.setText(R.string.nwd_error1);
                        obliczenia.setBackgroundColor(Color.parseColor("#FF0000"));
                        obliczenia.setTextColor(Color.parseColor("#FFFFFF"));
                        obliczenia.setPadding(16,16,16,16);
                        obliczenia.setTextSize(20);
                    }



            }
        });


        return view;
    }

}
