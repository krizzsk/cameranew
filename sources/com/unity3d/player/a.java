package com.unity3d.player;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes3.dex */
final class a {
    private final Context a;
    private final AudioManager b;
    private C0284a c;

    /* renamed from: com.unity3d.player.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0284a extends ContentObserver {
        private final b b;
        private final AudioManager c;

        /* renamed from: d  reason: collision with root package name */
        private final int f8384d;

        /* renamed from: e  reason: collision with root package name */
        private int f8385e;

        public C0284a(Handler handler, AudioManager audioManager, int i2, b bVar) {
            super(handler);
            this.c = audioManager;
            this.f8384d = 3;
            this.b = bVar;
            this.f8385e = audioManager.getStreamVolume(3);
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return super.deliverSelfNotifications();
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z, Uri uri) {
            int streamVolume;
            AudioManager audioManager = this.c;
            if (audioManager == null || this.b == null || (streamVolume = audioManager.getStreamVolume(this.f8384d)) == this.f8385e) {
                return;
            }
            this.f8385e = streamVolume;
            this.b.onAudioVolumeChanged(streamVolume);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onAudioVolumeChanged(int i2);
    }

    public a(Context context) {
        this.a = context;
        this.b = (AudioManager) context.getSystemService("audio");
    }

    public final void a() {
        if (this.c != null) {
            this.a.getContentResolver().unregisterContentObserver(this.c);
            this.c = null;
        }
    }

    public final void a(b bVar) {
        this.c = new C0284a(new Handler(), this.b, 3, bVar);
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.c);
    }
}
