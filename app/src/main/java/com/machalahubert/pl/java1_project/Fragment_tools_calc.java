package com.machalahubert.pl.java1_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment_tools_calc extends Fragment {
    private TextView wynik,wynik2;
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b_dziel,b_mnoz,b_dodaj,b_odej,b_rownasie,b_czysc;
    private double wartosc1 = Double.NaN;
    private double wartosc2;
    private final char DODAWANIE = '+';
    private final char ODEJMOWANIE = '-';
    private final char MNOZENIE = '*';
    private final char DZIELENIE = '/';
    private final char ROWNASIE = 0;
    private char akcja;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools_calc,container,false);

        setButtons(view);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "8");
            }
        });


        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wynik.getText().toString() + "9");
            }
        });

        b_dziel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wynik.getText().length() > 0) {
                    licz();
                    akcja = DZIELENIE;
                    wynik2.setText(String.valueOf(wartosc1) + " / ");
                    wynik.setText(null);
                }
            }
        });

        b_mnoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wynik.getText().length() > 0) {
                    licz();
                    akcja = MNOZENIE;
                    wynik2.setText(String.valueOf(wartosc1) + " * ");
                    wynik.setText(null);
                }
            }
        });


        b_dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wynik.getText().length() > 0) {
                    licz();
                    akcja = DODAWANIE;
                    wynik2.setText(String.valueOf(wartosc1) + " + ");
                    wynik.setText(null);
                }
            }
        });

        b_odej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wynik.getText().length() > 0) {
                    licz();
                    akcja = ODEJMOWANIE;
                    wynik2.setText(String.valueOf(wartosc1) + " - ");
                    wynik.setText(null);
                }
            }
        });

        b_rownasie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wynik.getText().length() > 0) {
                    licz();
                    akcja = ROWNASIE;
                    wynik2.setText(wynik2.getText().toString() + String.valueOf(wartosc2) + " = " + String.valueOf(wartosc1));
                    wynik.setText(null);
                }
            }
        });

        b_czysc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wynik.getText().length() > 0) {
                    CharSequence tmp = wynik.getText().toString();
                    wynik.setText(tmp.subSequence(0, tmp.length()-1));
                } else {
                    wartosc1 = Double.NaN;
                    wartosc2 = Double.NaN;
                    wynik.setText(null);
                    wynik2.setText(null);
                }
            }
        });




        return view;
    }

    private void setButtons(View v) {
        b0 = v.findViewById(R.id.calc_0);
        b1 = v.findViewById(R.id.calc_1);
        b2 = v.findViewById(R.id.calc_2);
        b3 = v.findViewById(R.id.calc_3);
        b4 = v.findViewById(R.id.calc_4);
        b5 = v.findViewById(R.id.calc_5);
        b6 = v.findViewById(R.id.calc_6);
        b7 = v.findViewById(R.id.calc_7);
        b8 = v.findViewById(R.id.calc_8);
        b9 = v.findViewById(R.id.calc_9);

        b_dziel = v.findViewById(R.id.calc_dziel);
        b_mnoz = v.findViewById(R.id.calc_mnoz);
        b_dodaj = v.findViewById(R.id.calc_dodaj);
        b_odej = v.findViewById(R.id.calc_odej);
        b_rownasie = v.findViewById(R.id.calc_rownasie);
        b_czysc = v.findViewById(R.id.calc_clear);

        wynik = v.findViewById(R.id.wynik);
        wynik2 = v.findViewById(R.id.wynik2);
    }

    private void licz() {
        if(!Double.isNaN(wartosc1)) {
            wartosc2 = Double.parseDouble(wynik.getText().toString());

            switch(akcja) {
                case DODAWANIE:
                    wartosc1 += wartosc2;
                    break;
                case ODEJMOWANIE:
                    wartosc1 -= - wartosc2;
                    break;
                case MNOZENIE:
                    wartosc1 *= wartosc2;
                    break;
                case DZIELENIE:
                    wartosc1 /= wartosc2;
                    break;
                case ROWNASIE:
                    break;
            }

        } else {
            wartosc1 = Double.parseDouble(wynik.getText().toString());

        }
    }
}
