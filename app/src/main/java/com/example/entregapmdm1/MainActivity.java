package com.example.entregapmdm1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    TextView contador;
    Button UpgradeButton;
    ImageView cookieImage;
    BigInteger costoMejora = BigInteger.valueOf(100);
    BigInteger num = BigInteger.ZERO, n = BigInteger.ONE, incrementoAutomatico = BigInteger.ONE;
    int valorclick = 1, incremento = 1, costeBillete = 100;

    private MediaPlayer mediaPlayer;
    private HandlerThread handlerThread;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clickButton = findViewById(R.id.BotonMejora);
        mediaPlayer =  MediaPlayer.create(this,R.raw.click);

        contador = findViewById(R.id.CountText);
        UpgradeButton = findViewById(R.id.BotonMejora);
        cookieImage = findViewById(R.id.imageView);

        segundero();
        UpgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickSound();
                if (comprarMejora()) {
                } else {
                }
            }
        });

    }
    private void playClickSound() {
        mediaPlayer.start();
    }
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    public boolean comprarMejora() {


        if (num.compareTo(costoMejora) >= 0) {
            num = num.subtract(costoMejora);
            valorclick = valorclick * 2;
            añadeTexto();
            costoMejora = costoMejora.multiply(BigInteger.valueOf(2));
            UpgradeButton.setText(costoMejora.toString());

            return true;
        }

        return false;
    }

    public void segundero() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler mainHandler = new Handler(getMainLooper());
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                num = num.add(BigInteger.ONE);

                mainHandler.post(() -> {
                    añadeTexto();
                    contador.setText(num.toString());
                });
            }
        });
    }

    public void irOpciones(View view) {
        Intent intent = new Intent(this, Opciones.class);


        intent.putExtra("num", num.toString());
        intent.putExtra("valorclick", valorclick);
        intent.putExtra("costoBillete", costeBillete);

        startActivity(intent);
    }


    public void Actualizar() {
        contador.setText(num.toString());
    }

    public void sumar(View v) {
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        num = num.add(BigInteger.valueOf(valorclick));
        añadeTexto();
    }

    public String añadeTexto() {
        String text = " ";

        if (num.compareTo(BigInteger.valueOf(1000)) >= 0 && num.compareTo(BigInteger.valueOf(999999)) <= 0) {
            BigInteger kilo = BigInteger.valueOf(1000);
            BigInteger cantidad = num.divide(kilo);
            BigInteger resto = num.mod(kilo);
            if (resto.compareTo(BigInteger.ZERO) > 0) {
                text = cantidad + "." + resto.divide(BigInteger.valueOf(100)) + "mil";
            } else {
                text = cantidad + "mil";
            }
        } else if (num.compareTo(BigInteger.valueOf(1000000)) >= 0 && num.compareTo(BigInteger.valueOf(999999999)) <= 0) {
            BigInteger millon = BigInteger.valueOf(1000000);
            BigInteger cantidad = num.divide(millon);
            BigInteger resto = num.mod(millon);
            if (resto.compareTo(BigInteger.ZERO) > 0) {
                text = cantidad + "." + resto.divide(BigInteger.valueOf(100000)) + "mill";
            } else {
                text = cantidad + "mill";
            }
        } else if (num.compareTo(BigInteger.valueOf(1000000000)) >= 0) {
            BigInteger billon = BigInteger.valueOf(1000000000);
            BigInteger cantidad = num.divide(billon);
            BigInteger resto = num.mod(billon);

            if (resto.compareTo(BigInteger.ZERO) > 0) {
                text = cantidad + "." + resto.divide(BigInteger.valueOf(100000000)) + "bill";
            } else {
                text = cantidad + "bill";
            }
        } else {
            text = num.toString();
        }

        contador.setText(text);
        return text;
    }



}