package com.ellen.myapplication;

import android.content.Context;
import android.media.MediaPlayer;

public class Som {
    private static MediaPlayer player;
    private static MediaPlayer trilhaPlayer;

    public static void executar(Context context, int somId) {
        if (player != null) {
            player.release();
            player = null;
        }
        player = MediaPlayer.create(context, somId);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Reinicia a trilha de áudio após a conclusão da reprodução do som
                tocarTrilha(context, R.raw.trilha);
            }
        });
    }

    public static void parar() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
        if (trilhaPlayer != null) {
            trilhaPlayer.stop();
            trilhaPlayer.release();
            trilhaPlayer = null;
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
            // Toca música para um amor provavel
            somId = R.raw.oq_e_amor;
        } else {
            // Toca música para um amor real
            somId = R.raw.amor_verdadeiro;
        }
        executar(context, somId);
    }

    public static void tocarTrilha(Context context, int trilhaId) {
        if (trilhaPlayer != null) {
            trilhaPlayer.release();
            trilhaPlayer = null;
        }
        trilhaPlayer = MediaPlayer.create(context, trilhaId);
        trilhaPlayer.setLooping(true);
        trilhaPlayer.start();
    }
}
