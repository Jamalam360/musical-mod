package com.jamalam360.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.TranslatableText;

public class GeneralUtil {
    public static MusicSound createMusicSound(SoundEvent soundEvent) {
        return new MusicSound(soundEvent, 0, 0, true);
    }

    public static MusicSound createMusicSound(int currentTrackIndex) {
        return new MusicSound(MusicList.getTrack(currentTrackIndex), 0, 0, true);
    }

    public static void sendStatusMessage(StatusTypes type, Integer intArg, MinecraftClient client) {
        try {
            if(type != StatusTypes.TRACK){
                client.inGameHud.getChatHud().clear(false);
            }

            if (type == StatusTypes.TRACK) {
                client.player.sendMessage(new TranslatableText("Now playing " + MusicList.getTrackName(intArg)), true);
            } else if (type == StatusTypes.VOLUME) {
                client.player.sendMessage(new TranslatableText("Set volume to " + intArg), false);
            }
        } catch (NullPointerException ignored) {
        }
    }

    public static void sendStatusMessage(StatusTypes type, Boolean bool, MinecraftClient client) {
        try {
            client.inGameHud.getChatHud().clear(false);

            if (type == StatusTypes.LOOPING) {
                client.player.sendMessage(new TranslatableText("Looping now set to " + bool), false);
            }
        } catch (NullPointerException ignored) {
        }
    }

    public static boolean isPlaying(MusicSound type, MinecraftClient client) {
        try {
            return client.getSoundManager().isPlaying(PositionedSoundInstance.music(type.getSound()));
        } catch (Exception e) {
            return false;
        }
    }
}
