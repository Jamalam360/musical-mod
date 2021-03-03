package com.jamalam360;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;

import static com.jamalam360.util.GeneralUtil.*;

import com.jamalam360.util.StatusTypes;

public class MusicalInitClient implements ClientModInitializer {

    static int currentTrackIndex;
    public boolean isPlaying = false;
    public boolean isLooping;

    @Override
    public void onInitializeClient() {
        KeyBinding trackForwards = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.muscialfabric.track_forwards",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_ADD, "category.musicalfabric.musical"));
        KeyBinding trackBackwards = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.musicalfabric.track_backwards",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_SUBTRACT, "category.musicalfabric.musical"));

        KeyBinding loop = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.musicalfabric.toggle_loop",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_K, "category.musicalfabric.musical"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (trackForwards.wasPressed()) {
                currentTrackIndex += 1;

                client.getMusicTracker().stop();
                client.getMusicTracker().play(createMusicSound(currentTrackIndex));

                sendStatusMessage(StatusTypes.TRACK, currentTrackIndex, client);
                isPlaying = true;
            }

            while (trackBackwards.wasPressed()) {
                currentTrackIndex -= 1;

                client.getMusicTracker().stop();
                client.getMusicTracker().play(createMusicSound(currentTrackIndex));

                sendStatusMessage(StatusTypes.TRACK, currentTrackIndex, client);

                isPlaying = true;
            }

            if (loop.wasPressed()) {
                isLooping = !isLooping;
                sendStatusMessage(StatusTypes.LOOPING, isLooping, client);
            }

            if (isLooping) {
                if (!client.getMusicTracker().isPlayingType(createMusicSound(currentTrackIndex))) {
                    client.getMusicTracker().stop();
                    client.getMusicTracker().play(createMusicSound(currentTrackIndex));
                }
            }
        });
    }

    public static void setTrackIndex(int index) {
        currentTrackIndex = index;
    }
}