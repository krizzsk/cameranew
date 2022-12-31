package com.mob.tools.utils;

import android.content.Context;
import android.media.AudioManager;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
/* loaded from: classes3.dex */
public class AudioHelper {
    public static final int ALARM_RING = 4;
    public static final int CALL_RING = 2;
    public static final int MEDIA_RING = 3;
    public static final int SYSTEM_RING = 1;
    private static AudioHelper audioHelper;
    private AudioManager audioManager;
    private Context context;
    private int currentAlarmVoice;
    private int currentCommonVoice;
    private int currentMediaVoice;
    private int currentRingVoice;

    private AudioHelper(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.audioManager = (AudioManager) applicationContext.getSystemService("audio");
    }

    public static AudioHelper getInstance(Context context) {
        if (audioHelper == null) {
            audioHelper = new AudioHelper(context);
        }
        return audioHelper;
    }

    private int getLastVoice(int i2) {
        int i3;
        if (i2 == 1) {
            i3 = this.currentCommonVoice;
        } else if (i2 == 3) {
            i3 = this.currentMediaVoice;
        } else if (i2 == 2) {
            i3 = this.currentRingVoice;
        } else {
            i3 = i2 == 4 ? this.currentAlarmVoice : 0;
        }
        NLog mobLog = MobLog.getInstance();
        mobLog.d("Voice Type:" + i2 + "Last Count:" + i3, new Object[0]);
        return i3;
    }

    private void getVioce() {
        int streamVolume = this.audioManager.getStreamVolume(1);
        if (streamVolume > 0) {
            this.currentCommonVoice = streamVolume;
        }
        int streamVolume2 = this.audioManager.getStreamVolume(2);
        if (streamVolume2 > 0) {
            this.currentRingVoice = streamVolume2;
        }
        int streamVolume3 = this.audioManager.getStreamVolume(3);
        if (streamVolume3 > 0) {
            this.currentMediaVoice = streamVolume3;
        }
        int streamVolume4 = this.audioManager.getStreamVolume(4);
        if (streamVolume4 > 0) {
            this.currentAlarmVoice = streamVolume4;
        }
        NLog mobLog = MobLog.getInstance();
        mobLog.d("System Ring：" + streamVolume + " Call Ring：" + streamVolume2 + " Media Ring：" + streamVolume3 + "Alarm Ring：" + streamVolume4, new Object[0]);
    }

    public void addVoice(int i2, int i3) {
        this.audioManager.adjustStreamVolume(i2, i3, 8);
    }

    public boolean checkMusicActivity() {
        boolean isMusicActive = this.audioManager.isMusicActive();
        NLog mobLog = MobLog.getInstance();
        mobLog.d("Music Action:" + isMusicActive, new Object[0]);
        return isMusicActive;
    }

    public int getAudioMode() {
        try {
            int ringerMode = this.audioManager.getRingerMode();
            if (ringerMode != 0) {
                return ringerMode != 1 ? 2 : 1;
            }
            return 0;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return 2;
        }
    }

    public void recoveryVoice(int i2) {
        this.audioManager.setStreamVolume(i2, getLastVoice(i2), 8);
    }

    public void setQuietMode(int i2) {
        try {
            getVioce();
            if (this.audioManager.getStreamVolume(i2) == 0) {
                return;
            }
            this.audioManager.setStreamVolume(i2, 0, 8);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public void setSilentMode() {
        this.audioManager.setStreamVolume(2, 0, 8);
        this.audioManager.setRingerMode(0);
    }
}
