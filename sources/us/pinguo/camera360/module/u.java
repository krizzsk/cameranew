package us.pinguo.camera360.module;

import android.app.Application;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.o;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.data.z;
import java.util.ArrayList;
import java.util.Iterator;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import us.pinguo.foundation.domain.PublishMediaItem;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: MediaAlbumImpl.java */
/* loaded from: classes3.dex */
public class u implements us.pinguo.librouter.module.camera.e {
    private z a;
    private Object b = new Object();
    private int c;

    /* compiled from: MediaAlbumImpl.java */
    /* loaded from: classes3.dex */
    class a implements Observable.OnSubscribe<ArrayList<com.pinguo.camera360.gallery.data.w>> {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // rx.functions.Action1
        /* renamed from: a */
        public void call(Subscriber<? super ArrayList<com.pinguo.camera360.gallery.data.w>> subscriber) {
            ArrayList<com.pinguo.camera360.gallery.data.w> q;
            synchronized (u.this.b) {
                q = u.this.a.q(u.this.c, u.this.c + this.a);
                u.e(u.this, q.size());
            }
            subscriber.onNext(q);
            subscriber.onCompleted();
        }
    }

    public u() {
        h();
    }

    static /* synthetic */ int e(u uVar, int i2) {
        int i3 = uVar.c + i2;
        uVar.c = i3;
        return i3;
    }

    private PublishMediaItem g(com.pinguo.camera360.gallery.data.w wVar) {
        boolean z = wVar instanceof com.pinguo.camera360.gallery.data.u;
        PublishMediaItem publishMediaItem = new PublishMediaItem(wVar, wVar.o(), wVar instanceof com.pinguo.camera360.gallery.data.h ? ((com.pinguo.camera360.gallery.data.h) wVar).m : 0L, wVar.w(), wVar.q(), wVar.t(), z);
        if (z) {
            publishMediaItem.setDurationInSec(((com.pinguo.camera360.gallery.data.u) wVar).F());
        }
        publishMediaItem.setDurationStr((String) wVar.e().c(8));
        return publishMediaItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ ArrayList j(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null) {
            return arrayList2;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(g((com.pinguo.camera360.gallery.data.w) it.next()));
        }
        return arrayList2;
    }

    @Override // us.pinguo.librouter.module.camera.e
    public Observable<ArrayList<PublishMediaItem>> a(int i2) {
        return Observable.create(new a(i2)).map(new Func1() { // from class: us.pinguo.camera360.module.e
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return u.this.j((ArrayList) obj);
            }
        });
    }

    @Override // us.pinguo.librouter.module.camera.e
    public void b(Object obj) {
        if (obj instanceof PublishMediaItem) {
            Object obj2 = ((PublishMediaItem) obj).mediaItem;
            if (obj2 instanceof com.pinguo.camera360.gallery.data.w) {
                this.a.I((com.pinguo.camera360.gallery.data.w) obj2);
                return;
            }
        }
        if (obj instanceof com.pinguo.camera360.gallery.data.w) {
            this.a.I((com.pinguo.camera360.gallery.data.w) obj);
        }
    }

    public void h() {
        Application e2 = BaseApplication.e();
        com.pinguo.camera360.gallery.data.f fVar = new com.pinguo.camera360.gallery.data.f(e2, new Path(1202, "path-big-album-def"));
        com.pinguo.camera360.gallery.data.r rVar = new com.pinguo.camera360.gallery.data.r(e2, new Path(1004, ""), "", false);
        z zVar = new z(e2, new Path(1301, ""), new o.a(), new y[]{fVar, rVar});
        this.a = zVar;
        zVar.A();
    }
}
