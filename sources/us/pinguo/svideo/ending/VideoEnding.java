package us.pinguo.svideo.ending;

import android.content.Context;
import java.util.Locale;
import us.pinguo.svideo.b.g;
/* loaded from: classes6.dex */
public class VideoEnding {
    public static boolean a = true;
    public static int b = 1;

    /* loaded from: classes6.dex */
    public static class VideoEndingFailException extends Exception {
        public VideoEndingFailException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        final /* synthetic */ b a;
        final /* synthetic */ c b;
        final /* synthetic */ d c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f12030d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f12031e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f12032f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f12033g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ e f12034h;

        a(b bVar, c cVar, d dVar, Context context, String str, int i2, int i3, e eVar) {
            this.a = bVar;
            this.b = cVar;
            this.c = dVar;
            this.f12030d = context;
            this.f12031e = str;
            this.f12032f = i2;
            this.f12033g = i3;
            this.f12034h = eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00ee A[LOOP:0: B:33:0x00ec->B:34:0x00ee, LOOP_END] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 349
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.svideo.ending.VideoEnding.a.run():void");
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onComplete(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface d {
        g a();
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(byte[] bArr, long j2);
    }

    public static void a(Context context, String str, int i2, int i3, d dVar, c cVar, b bVar, e eVar) {
        b(context, str, i2, i3, dVar, cVar, bVar, eVar);
    }

    public static void b(Context context, String str, int i2, int i3, d dVar, c cVar, b bVar, e eVar) {
        new Thread(new a(bVar, cVar, dVar, context, str, i2, i3, eVar), "VideoEndingThread").start();
    }

    public static final boolean c() {
        Locale locale = Locale.getDefault();
        return locale.equals(Locale.CHINA) || locale.equals(Locale.CHINESE) || locale.equals(Locale.SIMPLIFIED_CHINESE);
    }
}
