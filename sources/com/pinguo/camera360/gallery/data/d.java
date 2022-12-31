package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.pinguo.album.a;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.gallery.data.j;
import com.pinguo.camera360.gallery.data.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* compiled from: AlbumSet.java */
/* loaded from: classes3.dex */
public class d extends y implements com.pinguo.album.d<ArrayList<y>> {
    private static final Uri q = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    private static final Uri r = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6342f;

    /* renamed from: g  reason: collision with root package name */
    private com.pinguo.album.c<ArrayList<y>> f6343g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<y> f6344h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f6345i;

    /* renamed from: j  reason: collision with root package name */
    private final l f6346j;

    /* renamed from: k  reason: collision with root package name */
    private final l f6347k;

    /* renamed from: l  reason: collision with root package name */
    private Application f6348l;
    private int m;
    private ArrayList<y> n;
    boolean o;
    private Comparator<y> p;

    /* compiled from: AlbumSet.java */
    /* loaded from: classes3.dex */
    class a implements Comparator<y> {
        a(d dVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(y yVar, y yVar2) {
            return b(yVar2) - b(yVar);
        }

        public int b(y yVar) {
            if (yVar != null) {
                if ("Camera360Cloud".equalsIgnoreCase(yVar.s())) {
                    return RoomDatabase.MAX_BIND_PARAMETER_CNT;
                }
                if ("Camera".equalsIgnoreCase(yVar.s())) {
                    return 998;
                }
                return "DCIM".equalsIgnoreCase(yVar.s()) ? 997 : 0;
            }
            return 0;
        }
    }

    /* compiled from: AlbumSet.java */
    /* loaded from: classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.w();
        }
    }

    /* compiled from: AlbumSet.java */
    /* loaded from: classes3.dex */
    private class c implements a.b<ArrayList<y>> {
        private c() {
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public ArrayList<y> a(a.c cVar) {
            return d.this.C(cVar);
        }

        /* synthetic */ c(d dVar, a aVar) {
            this();
        }
    }

    public d(Application application, Path path) {
        super(path, x.j());
        this.m = -1;
        this.n = new ArrayList<>();
        this.o = false;
        this.p = new a(this);
        this.f6348l = application;
        this.f6346j = new l(this, q, application);
        this.f6347k = new l(this, r, application);
        this.f6345i = new Handler(application.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<y> C(a.c cVar) {
        ArrayList<y> arrayList;
        if (this.o && (arrayList = this.n) != null) {
            this.o = false;
            return arrayList;
        }
        j.b[] a2 = j.a(cVar, this.f6348l.getContentResolver(), 6);
        ArrayList<y> arrayList2 = new ArrayList<>();
        if (a2 != null && a2.length != 0) {
            String r2 = CameraBusinessSettingModel.v().r();
            String substring = (r2 == null || !r2.contains("/")) ? "" : r2.substring(0, r2.lastIndexOf("/"));
            for (j.b bVar : a2) {
                z zVar = new z(this.f6348l, new Path(1303, String.valueOf(bVar.b)), new o.a(), new y[]{new r(this.f6348l, new Path(CloseFrame.NOCODE, String.valueOf(bVar.b)), bVar.a, true), new r(this.f6348l, new Path(1004, String.valueOf(bVar.b)), bVar.a, false)});
                if (!arrayList2.contains(zVar)) {
                    String str = bVar.f6369d;
                    if (!TextUtils.isEmpty(substring) && str != null && str.contains(substring)) {
                        if (zVar.r() > 0) {
                            arrayList2.add(zVar);
                        }
                    } else {
                        arrayList2.add(zVar);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                Collections.sort(arrayList2, this.p);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean D() {
        return this.f6346j.a() || this.f6347k.a();
    }

    @Override // com.pinguo.album.d
    public synchronized void b(com.pinguo.album.c<ArrayList<y>> cVar) {
        if (this.f6343g != cVar) {
            return;
        }
        ArrayList<y> arrayList = cVar.get();
        this.f6344h = arrayList;
        this.f6342f = false;
        if (arrayList == null) {
            this.f6344h = new ArrayList<>();
        }
        this.f6345i.post(new b());
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<m> p(int i2, int i3) {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<w> q(int i2, int i3) {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int r() {
        this.m = 0;
        Iterator<y> it = this.n.iterator();
        while (it.hasNext()) {
            this.m += it.next().r();
        }
        return this.m;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public String s() {
        return "path-set";
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public y t(int i2) {
        if (i2 < 0 || i2 >= this.n.size()) {
            return null;
        }
        return this.n.get(i2);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int u() {
        return this.n.size();
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public synchronized boolean v() {
        return this.f6342f;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public synchronized long x() {
        if (D()) {
            com.pinguo.album.c<ArrayList<y>> cVar = this.f6343g;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f6342f = true;
            this.f6343g = com.pinguo.album.e.e().a().b(new c(this, null), this);
        }
        ArrayList<y> arrayList = this.f6344h;
        if (arrayList != null) {
            this.n = arrayList;
            this.f6344h = null;
            Iterator<y> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().x();
            }
            this.a = x.j();
        }
        return this.a;
    }
}
