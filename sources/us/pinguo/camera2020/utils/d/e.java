package us.pinguo.camera2020.utils.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.androidsdk.GPUEditor;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.camera2020.view.IVideoPathGeneratorImpl;
import us.pinguo.common.pgdownloader.exception.ErrorCode;
import us.pinguo.foundation.f;
import us.pinguo.repository2020.u;
import us.pinguo.svideo.bean.VideoInfo;
import us.pinguo.svideo.c.g;
import us.pinguo.svideo.c.h;
import us.pinguo.svideo.ending.VideoEnding;
import us.pinguo.svideo.utils.SVideoUtil;
import us.pinguo.util.v;
/* compiled from: VideoRecordManager.kt */
/* loaded from: classes3.dex */
public final class e implements us.pinguo.svideo.c.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f9258f = new a(null);
    private us.pinguo.svideo.c.c a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9259d;

    /* renamed from: e  reason: collision with root package name */
    private u<Boolean> f9260e = new u<>(Boolean.FALSE);

    /* compiled from: VideoRecordManager.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final void a(Context context, String savePath, VideoInfo info) {
            boolean C;
            s.h(context, "context");
            s.h(savePath, "savePath");
            s.h(info, "info");
            if (f.y || us.pinguo.util.c.f12473g) {
                C = StringsKt__StringsKt.C(savePath, "/DCIM/Camera/", false, 2, null);
                if (C) {
                    try {
                        File file = new File(savePath);
                        if (file.exists()) {
                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                            intent.setData(Uri.fromFile(file));
                            context.sendBroadcast(intent);
                            return;
                        }
                        return;
                    } catch (Throwable unused) {
                    }
                }
            }
            us.pinguo.svideo.utils.b.l("addVideoToMediaStore enter", new Object[0]);
            File file2 = new File(savePath);
            Uri parse = Uri.parse("content://media/external/video/media");
            long length = file2.length();
            int videoWidth = info.getVideoWidth();
            int videoHeight = info.getVideoHeight();
            us.pinguo.svideo.utils.b.l(s.q("addVideoToMediaStore length =", Long.valueOf(length)), new Object[0]);
            String name = file2.getName();
            String name2 = file2.getName();
            long currentTimeMillis = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues(7);
            contentValues.put("title", name);
            contentValues.put("_display_name", name2);
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            contentValues.put("mime_type", "video/mp4");
            contentValues.put("_data", savePath);
            StringBuilder sb = new StringBuilder();
            sb.append(videoWidth);
            sb.append('x');
            sb.append(videoHeight);
            contentValues.put("resolution", sb.toString());
            contentValues.put("_size", Long.valueOf(length));
            us.pinguo.image.saver.d.b bVar = new us.pinguo.image.saver.d.b();
            us.pinguo.librouter.b.c.f location = us.pinguo.librouter.b.b.b().getInterface().getLocation();
            bVar.a(14);
            bVar.j(name);
            bVar.c(name2);
            bVar.h(currentTimeMillis);
            bVar.g("video/mp4");
            bVar.d(savePath);
            bVar.k(String.valueOf(videoWidth));
            bVar.e(String.valueOf(videoHeight));
            if (location != null) {
                contentValues.put(BigAlbumStore.PhotoColumns.LATITUDE, Double.valueOf(location.c()));
                contentValues.put(BigAlbumStore.PhotoColumns.LONGITUDE, Double.valueOf(location.d()));
                bVar.b(location);
            }
            bVar.f(length);
            long duration = info.getDuration();
            if (duration > 0) {
                contentValues.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(duration));
                bVar.i(duration);
            }
            try {
                Uri insert = v.a().getContentResolver().insert(parse, contentValues);
                if (SVideoUtil.a) {
                    context.sendBroadcast(new Intent("android.hardware.action.NEW_VIDEO", insert));
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* compiled from: VideoRecordManager.kt */
    /* loaded from: classes3.dex */
    public static final class b implements us.pinguo.svideo.c.e {
        b() {
        }

        @Override // us.pinguo.svideo.c.e
        public void a() {
            e.this.i().setValue(Boolean.FALSE);
        }

        @Override // us.pinguo.svideo.c.e
        public void b(VideoInfo videoInfo) {
            e.this.i().setValue(Boolean.FALSE);
        }

        @Override // us.pinguo.svideo.c.e
        public void c() {
            e.this.i().setValue(Boolean.TRUE);
        }

        @Override // us.pinguo.svideo.c.e
        public void d(Throwable th) {
            e.this.i().setValue(Boolean.FALSE);
        }
    }

    public e() {
        us.pinguo.svideo.utils.b.k(us.pinguo.foundation.d.f10987f);
        VideoEnding.a = false;
        VideoEnding.b = 1;
        us.pinguo.svideo.recorder.d.y = false;
        us.pinguo.svideo.recorder.d.z = true;
    }

    private final void o() {
        us.pinguo.svideo.c.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.f(new b());
    }

    @Override // us.pinguo.svideo.c.a
    public int a() {
        return 0;
    }

    @Override // us.pinguo.svideo.c.a
    public int b() {
        return this.c;
    }

    @Override // us.pinguo.svideo.c.a
    public int c() {
        return this.b;
    }

    @Override // us.pinguo.svideo.c.a
    public void d(g previewSurfaceListener) {
        s.h(previewSurfaceListener, "previewSurfaceListener");
        d.i(null, null);
    }

    @Override // us.pinguo.svideo.c.a
    public void e(g previewSurfaceListener, h surfaceCreatedCallback) {
        s.h(previewSurfaceListener, "previewSurfaceListener");
        s.h(surfaceCreatedCallback, "surfaceCreatedCallback");
        d.i(previewSurfaceListener, surfaceCreatedCallback);
    }

    public final void f(us.pinguo.svideo.c.e onRecordListener) {
        s.h(onRecordListener, "onRecordListener");
        us.pinguo.svideo.c.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.f(onRecordListener);
    }

    public final us.pinguo.svideo.c.c g() {
        us.pinguo.svideo.recorder.b videoRecorder = SVideoUtil.f(v.a(), this, GPUEditor.EFFECT_KEY);
        videoRecorder.i(new IVideoPathGeneratorImpl());
        this.a = videoRecorder;
        o();
        s.g(videoRecorder, "videoRecorder");
        return videoRecorder;
    }

    public final void h() {
        us.pinguo.svideo.c.c cVar = this.a;
        if (cVar != null) {
            cVar.i(null);
        }
        this.a = null;
    }

    public final u<Boolean> i() {
        return this.f9260e;
    }

    public final void j(us.pinguo.svideo.c.e onRecordListener) {
        s.h(onRecordListener, "onRecordListener");
        us.pinguo.svideo.c.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.b(onRecordListener);
    }

    public final void k(int i2, int i3) {
        this.b = i2;
        this.c = i3;
        int i4 = (i2 * i3) / 300000;
        if (i4 < 1) {
            i4 = 1;
        }
        int i5 = i4 * ErrorCode.UNKNOWN_ERROR;
        this.f9259d = i5;
        us.pinguo.svideo.c.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.d(i5);
    }

    public final void l() {
        us.pinguo.svideo.c.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.g();
    }

    public final void m() {
        us.pinguo.svideo.c.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.c();
    }

    public final void n() {
        us.pinguo.svideo.c.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.h();
    }
}
