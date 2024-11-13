package com.example.turmy;

import android.os.Bundle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CardAdapter cardAdapter;
    List<String> titles = new ArrayList<>();
    List<String> schools = new ArrayList<>();
    List<String> dates = new ArrayList<>();
    List<String> situations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adicionando dados fictícios
        titles.add("Wesley Moura");
        titles.add("Nicole");
        titles.add("Luiz Felipe");

        schools.add("9º Ano");
        schools.add("Alfabetização");
        schools.add("3º Ano");

        dates.add("15/02/2024");
        dates.add("15/02/2024");
        dates.add("15/02/2024");

        situations.add("CONFIRMADO");
        situations.add("ATRASADO");
        situations.add("VENCIMENTO");


        // Configurando o Adapter
        cardAdapter = new CardAdapter(titles, schools, dates, situations);
        recyclerView.setAdapter(cardAdapter);
    }
}