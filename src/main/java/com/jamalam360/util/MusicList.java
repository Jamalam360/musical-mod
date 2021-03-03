package com.jamalam360.util;

import com.jamalam360.MusicalInitClient;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class MusicList {
    public static final SoundEvent MUSIC_DISC_11 = SoundEvents.MUSIC_DISC_11;
    public static final SoundEvent MUSIC_DISC_13 = SoundEvents.MUSIC_DISC_13;
    public static final SoundEvent MUSIC_DISC_BLOCKS = SoundEvents.MUSIC_DISC_BLOCKS;
    public static final SoundEvent MUSIC_DISC_CAT = SoundEvents.MUSIC_DISC_CAT;
    public static final SoundEvent MUSIC_DISC_CHIRP = SoundEvents.MUSIC_DISC_CHIRP;
    public static final SoundEvent MUSIC_DISC_FAR = SoundEvents.MUSIC_DISC_FAR;
    public static final SoundEvent MUSIC_DISC_MALL = SoundEvents.MUSIC_DISC_MALL;
    public static final SoundEvent MUSIC_DISC_MELLOHI = SoundEvents.MUSIC_DISC_MELLOHI;
    public static final SoundEvent MUSIC_DISC_PIGSTEP = SoundEvents.MUSIC_DISC_PIGSTEP;
    public static final SoundEvent MUSIC_DISC_STAL = SoundEvents.MUSIC_DISC_STAL;
    public static final SoundEvent MUSIC_DISC_STRAD = SoundEvents.MUSIC_DISC_STRAD;
    public static final SoundEvent MUSIC_DISC_WAIT = SoundEvents.MUSIC_DISC_WAIT;
    public static final SoundEvent MUSIC_DISC_WARD = SoundEvents.MUSIC_DISC_WARD;
    public static final SoundEvent MUSIC_GAME = SoundEvents.MUSIC_GAME;

    public static final Item MUSIC_DISC_13_ITEM = Items.MUSIC_DISC_13;
    public static final Item MUSIC_DISC_CAT_ITEM = Items.MUSIC_DISC_CAT;
    public static final Item MUSIC_DISC_BLOCKS_ITEM = Items.MUSIC_DISC_BLOCKS;
    public static final Item MUSIC_DISC_CHIRP_ITEM = Items.MUSIC_DISC_CHIRP;
    public static final Item MUSIC_DISC_FAR_ITEM = Items.MUSIC_DISC_FAR;
    public static final Item MUSIC_DISC_MALL_ITEM = Items.MUSIC_DISC_MALL;
    public static final Item MUSIC_DISC_MELLOHI_ITEM = Items.MUSIC_DISC_MELLOHI;
    public static final Item MUSIC_DISC_STAL_ITEM = Items.MUSIC_DISC_STAL;
    public static final Item MUSIC_DISC_STRAD_ITEM = Items.MUSIC_DISC_STRAD;
    public static final Item MUSIC_DISC_WARD_ITEM = Items.MUSIC_DISC_WARD;
    public static final Item MUSIC_DISC_11_ITEM = Items.MUSIC_DISC_11;
    public static final Item MUSIC_DISC_WAIT_ITEM = Items.MUSIC_DISC_WAIT;
    public static final Item MUSIC_DISC_PIGSTEP_ITEM = Items.MUSIC_DISC_PIGSTEP;

    public static SoundEvent[] soundEvents = { MUSIC_DISC_11, MUSIC_DISC_13, MUSIC_DISC_BLOCKS, MUSIC_DISC_CAT,
            MUSIC_DISC_CHIRP, MUSIC_DISC_FAR, MUSIC_DISC_MALL, MUSIC_DISC_MELLOHI, MUSIC_DISC_PIGSTEP, MUSIC_DISC_STAL,
            MUSIC_DISC_STRAD, MUSIC_DISC_WAIT, MUSIC_DISC_WARD, MUSIC_GAME };

    public static Item[] musicItems = { MUSIC_DISC_11_ITEM, MUSIC_DISC_13_ITEM, MUSIC_DISC_BLOCKS_ITEM,
            MUSIC_DISC_CAT_ITEM, MUSIC_DISC_CHIRP_ITEM, MUSIC_DISC_FAR_ITEM, MUSIC_DISC_MALL_ITEM,
            MUSIC_DISC_MELLOHI_ITEM, MUSIC_DISC_PIGSTEP_ITEM, MUSIC_DISC_STAL_ITEM, MUSIC_DISC_STRAD_ITEM,
            MUSIC_DISC_WAIT_ITEM, MUSIC_DISC_WARD_ITEM };

    public static SoundEvent getTrack(int index) {
        if (index < 0) {
            index = soundEvents.length - 1;
        }

        if (index > soundEvents.length - 1) {
            index = 0;
        }

        com.jamalam360.MusicalInitClient.setTrackIndex(index);

        SoundEvent soundEvent = soundEvents[index];
        return soundEvent;
    }

    public static String getTrackName(int index) {
        if (index < 0) {
            index = musicItems.length - 1;
        }

        if (index > musicItems.length - 1) {
            if (index == musicItems.length) {
                String string = "default game music";
                return string;
            }
            index = 0;
        }

        MusicalInitClient.setTrackIndex(index);

        String string = ((MusicDiscItem) musicItems[index]).getDescription().getString();
        return string;
    }
}
