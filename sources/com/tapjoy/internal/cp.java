package com.tapjoy.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
/* loaded from: classes3.dex */
public final class cp extends ContentObserver {
    public final Context a;
    public float b;
    private final AudioManager c;

    /* renamed from: d  reason: collision with root package name */
    private final cm f7345d;

    /* renamed from: e  reason: collision with root package name */
    private final co f7346e;

    public cp(Handler handler, Context context, cm cmVar, co coVar) {
        super(handler);
        this.a = context;
        this.c = (AudioManager) context.getSystemService("audio");
        this.f7345d = cmVar;
        this.f7346e = coVar;
    }

    public final float a() {
        int streamVolume = this.c.getStreamVolume(3);
        int streamMaxVolume = this.c.getStreamMaxVolume(3);
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f2 = streamVolume / streamMaxVolume;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public final void b() {
        this.f7346e.a(this.b);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        float a = a();
        if (a != this.b) {
            this.b = a;
            b();
        }
    }
}
