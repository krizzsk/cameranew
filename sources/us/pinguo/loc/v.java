package us.pinguo.loc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.IOException;
import rx.Subscriber;
import us.pinguo.blockbuster.BlockBuster;
import us.pinguo.blockbuster.Param;
import us.pinguo.loc.EffectLocManager;
import us.pinguo.util.NetworkType;
/* compiled from: LocWorkTask.java */
/* loaded from: classes5.dex */
public class v {

    /* renamed from: e  reason: collision with root package name */
    private static BlockBuster f11552e;

    /* renamed from: f  reason: collision with root package name */
    private static final Runnable f11553f = l.a;
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private p f11554d;

    public v(String str, String str2, String str3, String str4, long j2, p pVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.f11554d = pVar;
    }

    private static void b() {
        Runnable runnable = f11553f;
        us.pinguo.foundation.e.d(runnable);
        us.pinguo.foundation.e.c(runnable, 600000L);
    }

    private us.pinguo.facedetector.c c(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        p pVar = this.f11554d;
        if (pVar != null) {
            return pVar.a(decodeFile);
        }
        return null;
    }

    private Bitmap d() throws IOException {
        BlockBuster blockBuster = f11552e;
        blockBuster.input = this.a;
        blockBuster.output = this.b;
        blockBuster.materialFolder = this.c;
        blockBuster.param = g();
        int make = f11552e.make();
        if (make == 0) {
            Bitmap decodeFile = BitmapFactory.decodeFile(this.b);
            us.pinguo.foundation.r.d.a().b(new o(90));
            return decodeFile;
        } else if (make == 2) {
            throw new EffectLocManager.TaskCancelException();
        } else {
            throw new RuntimeException("大片特效make失败:" + make);
        }
    }

    private void e(File file, File file2, String str) throws IOException {
        if (file.exists() && file2.exists()) {
            return;
        }
        us.pinguo.common.log.a.k("没有缓存，开始底层sdk抠图", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (!file2.exists() && us.pinguo.util.q.b(us.pinguo.util.v.a()).getNetworkType() >= NetworkType.NETWORK_4G.getNetworkType()) {
            byte[] a = r.a(str);
            if (a != null) {
                us.pinguo.util.k.g(file2, a);
                us.pinguo.common.log.a.g("Frisky", "网络做图成功!!", new Object[0]);
            } else {
                us.pinguo.common.log.a.g("Frisky", "网络做图失败!!", new Object[0]);
            }
        }
        f11552e.segmentation(file.getAbsolutePath(), file2.getAbsolutePath());
        us.pinguo.common.log.a.k("抠图成功,耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "ms", new Object[0]);
    }

    private Param g() {
        us.pinguo.facedetector.c c = c(this.a);
        Param param = new Param();
        param.needPreProcess = true;
        us.pinguo.facedetector.b g2 = c.g();
        if (c != null && c.h()) {
            param.landmarks = g2.f();
            param.faceRect = new float[]{g2.g().left, g2.g().top, g2.g().right, g2.g().bottom};
            param.leftEyeX = g2.l(74);
            param.leftEyeY = g2.m(74);
            param.rightEyeX = g2.l(77);
            param.rightEyeY = g2.m(77);
            EffectLocManager.getInstance().i().put(this.b, Boolean.valueOf(c.c() > 1));
            File h2 = h(this.a);
            File j2 = j(this.a);
            try {
                e(h2, j2, this.a);
                param.hairMaskPath = h2.getAbsolutePath();
                param.portraitMaskPath = j2.getAbsolutePath();
                return param;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new EffectLocManager.NoFaceDetectedException();
    }

    private File h(String str) {
        String name = new File(str).getName();
        File i2 = i();
        return new File(i2, "hair_cache_" + name);
    }

    private static File i() {
        File file = new File(us.pinguo.foundation.e.b().getCacheDir(), "loc_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private File j(String str) {
        String name = new File(str).getName();
        File i2 = i();
        return new File(i2, "portrait_cache_" + name);
    }

    private static synchronized void k() {
        synchronized (v.class) {
            t.l(us.pinguo.util.v.a());
            if (f11552e == null) {
                BlockBuster build = new BlockBuster.Builder().build();
                f11552e = build;
                build.activeGlEnv();
                f11552e.init(us.pinguo.foundation.e.b(), t.i(), t.f(), t.k());
            }
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l() {
        synchronized (v.class) {
            BlockBuster blockBuster = f11552e;
            if (blockBuster != null) {
                blockBuster.destroy();
                f11552e.releaseGlEnv();
                f11552e = null;
            }
        }
    }

    public void a(boolean z) {
        BlockBuster blockBuster = f11552e;
        if (blockBuster != null) {
            blockBuster.cancelMake(z);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.Bitmap[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.Bitmap[], java.lang.Object] */
    public void f(Subscriber<? super Bitmap[]> subscriber) throws IOException {
        Bitmap bitmap;
        k();
        File file = new File(this.b);
        if (file.exists()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            bitmap = BitmapFactory.decodeFile(this.a);
            if (decodeFile != null) {
                us.pinguo.foundation.r.d.a().b(new o(100));
                subscriber.onNext(new Bitmap[]{bitmap, decodeFile});
                subscriber.onCompleted();
                return;
            }
        } else {
            bitmap = null;
        }
        Bitmap d2 = d();
        us.pinguo.common.log.a.k("加水印成功", new Object[0]);
        us.pinguo.util.e.t(file.getAbsolutePath(), d2, 100);
        us.pinguo.common.log.a.k("保存图片成功", new Object[0]);
        subscriber.onNext(new Bitmap[]{bitmap, d2});
        subscriber.onCompleted();
    }
}
