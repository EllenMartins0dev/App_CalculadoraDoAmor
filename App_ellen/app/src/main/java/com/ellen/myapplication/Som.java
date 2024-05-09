package com.ellen.myapplication;

import android.content.Context;
import android.media.MediaPlayer;

public class Som {
    private static MediaPlayer player;

    public static void executar(Context context, int somId) {
        player = MediaPlayer.create(context, somId);
        player.start();
        player.setLooping(true);
    }

    public static void parar() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }

    public static void tocarMusica(Context context, double porcentagem) {
        int somId;
        if (porcentagem >= 0 && porcentagem < 30) {
            // Toca música para um amor impossível
            somId = R.raw.falha;
        } else if (porcentagem >= 30 && porcentagem < 50) {
            // Toca música para um amor possível
            somId = R.raw.depression;
        } else if (porcentagem >= 50 && porcentagem < 80) {
            // Toca música fpara um amor provavel
            somId = R.raw.oq_e_amor;
        } else {
            // Toca música para um amor real
            somId = R.raw.amor_verdadeiro;
        }
        executar(context, somId);
    }
}
