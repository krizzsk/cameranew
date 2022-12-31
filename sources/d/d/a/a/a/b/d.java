package d.d.a.a.a.b;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes2.dex */
public final class d extends ContentObserver {
    private final Context a;
    private final AudioManager b;
    private final a c;

    /* renamed from: d  reason: collision with root package name */
    private final c f8512d;

    /* renamed from: e  reason: collision with root package name */
    private float f8513e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.a = context;
        this.b = (AudioManager) context.getSystemService("audio");
        this.c = aVar;
        this.f8512d = cVar;
    }

    private boolean b(float f2) {
        return f2 != this.f8513e;
    }

    private float d() {
        return this.c.a(this.b.getStreamVolume(3), this.b.getStreamMaxVolume(3));
    }

    private void e() {
        this.f8512d.a(this.f8513e);
    }

    public void a() {
        this.f8513e = d();
        e();
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void c() {
        this.a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        float d2 = d();
        if (b(d2)) {
            this.f8513e = d2;
            e();
        }
    }
}
