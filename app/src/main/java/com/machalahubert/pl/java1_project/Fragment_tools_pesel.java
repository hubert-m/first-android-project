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

public class Fragment_tools_pesel extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools_pesel,container,false);

        final EditText numer_pesel = view.findViewById(R.id.nr_pesel);
        final TextView wynik = view.findViewById(R.id.pesel_wynik);
        final TextView informacje = view.findViewById(R.id.pesel_informacje);


        Button sprawdz_btn = view.findViewById(R.id.check_pesel);

        sprawdz_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numer_pesel.onEditorAction(EditorInfo.IME_ACTION_DONE);
                informacje.setText(null);

                if(numer_pesel.getText().toString().length() == 11) {


                    if (sprawdzPESEL_sumaKontrolna(numer_pesel)) {
                        if(sprawdzPESEL_dataUr(numer_pesel)) {
                            wynik.setTextColor(Color.parseColor("#FFFFFF"));
                            wynik.setBackgroundColor(Color.parseColor("#006400"));
                            wynik.setText("Pesel jest prawidłowy");
                            // data urodzenia , płeć

                            informacje.setText(informacje.getText() + "Data urodzin: " + getDataUrodzin(numer_pesel));
                            informacje.setText(informacje.getText() + "\nPłeć: " + getPlec(numer_pesel));
                            informacje.setText(informacje.getText() + "\nZnak zodiaku: " + getZodiak(numer_pesel));
                        } else {
                            wynik.setTextColor(Color.parseColor("#FFFFFF"));
                            wynik.setBackgroundColor(Color.parseColor("#8b0000"));
                            wynik.setText("Suma kontrolna numeru PESEL jest poprawna, natomiast data urodzenia jest niepoprawnie zakodowana");
                        }


                    } else {
                        wynik.setTextColor(Color.parseColor("#FFFFFF"));
                        wynik.setBackgroundColor(Color.parseColor("#8b0000"));
                        wynik.setText("Pesel jest nieprawidłowy\nSuma kontrolna numeru PESEL jest niepoprawna");
                    }

                } else {
                    wynik.setTextColor(Color.parseColor("#FFFFFF"));
                    wynik.setBackgroundColor(Color.parseColor("#8b0000"));
                    wynik.setText("Wprowadzony ciąg nie ma 11-u znaków");
                }


            }
        });

        return view;
    }

    private boolean sprawdzPESEL_sumaKontrolna(EditText ciagg) {
        String ciag = ciagg.getText().toString();
        int suma_kontrolna = 0;
        int liczba;


        liczba = Character.getNumericValue(ciag.charAt(0));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        liczba = 3 * Character.getNumericValue(ciag.charAt(1));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        liczba = 7 * Character.getNumericValue(ciag.charAt(2));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        liczba = 9 * Character.getNumericValue(ciag.charAt(3));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        liczba = Character.getNumericValue(ciag.charAt(4));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        liczba = 3 * Character.getNumericValue(ciag.charAt(5));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        liczba = 7 * Character.getNumericValue(ciag.charAt(6));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        liczba = 9 * Character.getNumericValue(ciag.charAt(7));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        liczba = Character.getNumericValue(ciag.charAt(8));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        liczba = 3 * Character.getNumericValue(ciag.charAt(9));
        if(liczba >= 10) {
            suma_kontrolna += Character.getNumericValue(String.valueOf(liczba).charAt(1));
        } else {
            suma_kontrolna += liczba;
        }

        int l;

        if(suma_kontrolna >=10) {
            l = Character.getNumericValue(String.valueOf(suma_kontrolna).charAt(1));
        } else {
            l = suma_kontrolna;
        }

        suma_kontrolna = 10 - l;

        int cyfra_kontrolna = Character.getNumericValue(ciag.charAt(10));
        //System.out.println("Suma kontrolna: "+suma_kontrolna);


        return suma_kontrolna == cyfra_kontrolna;

    }

    private boolean sprawdzPESEL_dataUr(EditText ciagg) {
        String ciag = ciagg.getText().toString();
        int day;
        day = 10 * Character.getNumericValue(ciag.charAt(4));
        day += Character.getNumericValue(ciag.charAt(5));

        if(day > 31 || getMiesiacUrodzenia(ciagg) > 12) {
            return false;
        } else {
            return true;
        }

    }

    private int getRokUrodzenia(EditText ciagg) {
        String ciag = ciagg.getText().toString();
        int year;
        int month;
        year = 10 * Character.getNumericValue(ciag.charAt(0));
        year += Character.getNumericValue(ciag.charAt(1));
        month = 10 * Character.getNumericValue(ciag.charAt(2));
        month += Character.getNumericValue(ciag.charAt(3));
        if (month > 80 && month < 93) {
            year += 1800;
        }
        else if (month > 0 && month < 13) {
            year += 1900;
        }
        else if (month > 20 && month < 33) {
            year += 2000;
        }
        else if (month > 40 && month < 53) {
            year += 2100;
        }
        else if (month > 60 && month < 73) {
            year += 2200;
        }
        return year;
    }

    private int getMiesiacUrodzenia(EditText ciagg) {
        String ciag = ciagg.getText().toString();
        int month;
        month = 10 * Character.getNumericValue(ciag.charAt(2));
        month += Character.getNumericValue(ciag.charAt(3));
        if (month > 80 && month < 93) {
            month -= 80;
        }
        else if (month > 20 && month < 33) {
            month -= 20;
        }
        else if (month > 40 && month < 53) {
            month -= 40;
        }
        else if (month > 60 && month < 73) {
            month -= 60;
        }

        return month;
    }

    private int getDzienUrodzenia(EditText ciagg) {
        String ciag = ciagg.getText().toString();
        int day;
        day = 10 * Character.getNumericValue(ciag.charAt(4));
        day += Character.getNumericValue(ciag.charAt(5));
        return day;
    }

    public String getDataUrodzin(EditText ciagg) {
        int day = getDzienUrodzenia(ciagg);

        String dayy;
        if(day < 10) {
            dayy = "0"+day;
        } else {
            dayy = String.valueOf(day);
        }

        String month;
        if(getMiesiacUrodzenia(ciagg) < 10) {
            month = "0"+getMiesiacUrodzenia(ciagg);
        } else {
            month = String.valueOf(getMiesiacUrodzenia(ciagg));
        }
        return dayy+"."+month+"."+getRokUrodzenia(ciagg)+"r.";
    }

    private String getPlec(EditText ciagg) {
        String ciag = ciagg.getText().toString();
        if (Character.getNumericValue(ciag.charAt(9)) % 2 == 1) {
            return "Mężczyzna";
        }
        else {
            return "Kobieta";
        }
    }

    private String getZodiak(EditText ciagg) {
        String zodiak = "";
        int dzien = getDzienUrodzenia(ciagg);
        int miesiac = getMiesiacUrodzenia(ciagg);
        if(miesiac == 1) {
            if(dzien <= 19) {
                zodiak = "Koziorożec";
            } else {
                zodiak = "Wodnik";
            }
        } else if(miesiac == 2) {
            if(dzien <= 18) {
                zodiak = "Wodnik";
            } else {
                zodiak = "Ryby";
            }
        } else if(miesiac == 3) {
            if(dzien <= 20) {
                zodiak = "Ryby";
            } else {
                zodiak = "Baran";
            }
        } else if(miesiac == 4) {
            if(dzien <= 19) {
                zodiak = "Baran";
            } else {
                zodiak = "Byk";
            }
        } else if(miesiac == 5) {
            if(dzien <= 22) {
                zodiak = "Byk";
            } else {
                zodiak = "Bliźnięta";
            }
        } else if(miesiac == 6) {
            if(dzien <= 21) {
                zodiak = "Bliźnięta";
            } else {
                zodiak = "Rak";
            }
        } else if(miesiac == 7) {
            if(dzien <= 22) {
                zodiak = "Rak";
            } else {
                zodiak = "Lew";
            }
        } else if(miesiac == 8) {
            if(dzien <= 23) {
                zodiak = "Lew";
            } else {
                zodiak = "Panna";
            }
        } else if(miesiac == 9) {
            if(dzien <= 22) {
                zodiak = "Panna";
            } else {
                zodiak = "Waga";
            }
        } else if(miesiac == 10) {
            if(dzien <= 22) {
                zodiak = "Waga";
            } else {
                zodiak = "Skorpion";
            }
        } else if(miesiac == 11) {
            if(dzien <= 21) {
                zodiak = "Skorpion";
            } else {
                zodiak = "Strzelec";
            }
        } else if(miesiac == 12) {
            if(dzien <= 21) {
                zodiak = "Strzelec";
            } else {
                zodiak = "Koziorożec";
            }
        } else {
            zodiak = "Nie określiono";
        }


        return zodiak;
    }


}
