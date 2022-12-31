package us.pinguo.edit2020.utils;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
/* compiled from: ScreenshotObserver.kt */
/* loaded from: classes4.dex */
public final class ScreenshotDetector$start$observer$1 extends ContentObserver {
    private long a;
    private volatile String b;
    private l<? super String, u> c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ContentResolver f10576d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotDetector$start$observer$1(ContentResolver contentResolver) {
        super(null);
        this.f10576d = contentResolver;
        this.a = System.currentTimeMillis();
        this.b = "";
    }

    public final String a() {
        return this.b;
    }

    public final l<String, u> b() {
        return this.c;
    }

    public final void c(String str) {
        s.h(str, "<set-?>");
        this.b = str;
    }

    public final void d(l<? super String, u> lVar) {
        this.c = lVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        if (uri == null) {
            return;
        }
        long j2 = this.a;
        long currentTimeMillis = System.currentTimeMillis();
        this.a = currentTimeMillis;
        if (currentTimeMillis - j2 <= 2000) {
            return;
        }
        us.pinguo.common.log.a.c("selfChange===>" + z + ",  screenshot===>" + uri, new Object[0]);
        kotlinx.coroutines.l.d(n0.a(z0.a()), null, null, new ScreenshotDetector$start$observer$1$onChange$1(this.f10576d, uri, this, null), 3, null);
    }
}
