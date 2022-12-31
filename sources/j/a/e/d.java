package j.a.e;

import android.app.Application;
import android.content.SharedPreferences;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.f;
import com.pinguo.camera360.gallery.data.o;
import com.pinguo.camera360.gallery.data.w;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.data.z;
import java.util.ArrayList;
import java.util.Iterator;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import us.pinguo.foundation.domain.DetectPicsEvent;
import us.pinguo.foundation.domain.PublishMediaItem;
import us.pinguo.foundation.e;
import us.pinguo.foundation.statistics.l;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: PublishDetector.java */
/* loaded from: classes5.dex */
public class d {
    private static long a;
    private static long b;

    public static void a() {
        if (!d()) {
            us.pinguo.common.log.a.k("未配置参数或者参数为0，不检测", new Object[0]);
            return;
        }
        long j2 = c().getLong("pre_detect_time", 0L);
        final long currentTimeMillis = System.currentTimeMillis();
        long j3 = a;
        if (currentTimeMillis - j2 < j3) {
            us.pinguo.common.log.a.k("时间间隔未到，暂不检测", new Object[0]);
            return;
        }
        final long j4 = currentTimeMillis - j3;
        Observable.create(new Observable.OnSubscribe() { // from class: j.a.e.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                d.f(j4, currentTimeMillis, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).subscribe(c.a, a.a);
    }

    private static ArrayList<w> b(long j2, long j3) {
        Application e2 = BaseApplication.e();
        f fVar = new f(e2, new Path(CloseFrame.NOCODE, ""));
        boolean z = true;
        z zVar = new z(e2, new Path(1004, ""), new o.a(), new y[]{fVar});
        zVar.B(j2, j3);
        ArrayList<w> q = zVar.q(0, 9);
        Iterator<w> it = q.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (!it.next().l()) {
                break;
            }
        }
        us.pinguo.common.log.a.k("hasDeleted:" + z, new Object[0]);
        if (z) {
            ArrayList<w> q2 = zVar.q(0, zVar.r());
            q.clear();
            Iterator<w> it2 = q2.iterator();
            while (it2.hasNext()) {
                w next = it2.next();
                if (next.l()) {
                    q.add(next);
                    if (q2.size() == 9) {
                        break;
                    }
                }
            }
        }
        if (q == null || q.size() < b) {
            return null;
        }
        return q;
    }

    private static SharedPreferences c() {
        return e.b().getSharedPreferences("inspire_share_pref", 0);
    }

    private static boolean d() {
        SharedPreferences c = c();
        a = c.getInt("detect_interval", -1) * 1000;
        b = c.getInt("detect_photo_count_min", -1);
        us.pinguo.common.log.a.k("detectInterval:" + a + " detectMinPhotoCount:" + b, new Object[0]);
        return a > 0 && b > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(long j2, long j3, Subscriber subscriber) {
        subscriber.onNext(b(j2, j3));
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Throwable th) {
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(ArrayList<w> arrayList) {
        if (arrayList == null) {
            us.pinguo.foundation.r.d.a().b(new DetectPicsEvent(null));
            return;
        }
        l.onEvent(BaseApplication.d(), "community_latestphoto_page");
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator<w> it = arrayList.iterator();
        while (it.hasNext()) {
            w next = it.next();
            arrayList2.add(new PublishMediaItem(next, next.o(), next.n(), next.w(), next.q(), next.t(), next.y()));
        }
        us.pinguo.foundation.r.d.a().b(new DetectPicsEvent(arrayList2));
    }

    public static void j() {
        c().edit().putLong("pre_detect_time", System.currentTimeMillis()).apply();
    }
}
