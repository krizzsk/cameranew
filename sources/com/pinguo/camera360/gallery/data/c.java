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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* compiled from: AlbumImageSet.java */
/* loaded from: classes3.dex */
public class c extends y implements com.pinguo.album.d<ArrayList<y>> {
    private static final Uri o = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6335f;

    /* renamed from: g  reason: collision with root package name */
    private com.pinguo.album.c<ArrayList<y>> f6336g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<y> f6337h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f6338i;

    /* renamed from: j  reason: collision with root package name */
    private final l f6339j;

    /* renamed from: k  reason: collision with root package name */
    private Application f6340k;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<y> f6341l;
    boolean m;
    private Comparator<y> n;

    /* compiled from: AlbumImageSet.java */
    /* loaded from: classes3.dex */
    class a implements Comparator<y> {
        a(c cVar) {
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

    /* compiled from: AlbumImageSet.java */
    /* loaded from: classes3.dex */
    private class b implements a.b<ArrayList<y>> {
        private b() {
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public ArrayList<y> a(a.c cVar) {
            return c.this.C(cVar);
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    public c(Application application, Path path) {
        super(path, x.j());
        this.f6341l = new ArrayList<>();
        this.m = false;
        this.n = new a(this);
        this.f6340k = application;
        this.f6339j = new l(this, o, application);
        this.f6338i = new Handler(application.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F() {
        w();
    }

    protected ArrayList<y> C(a.c cVar) {
        ArrayList<y> arrayList;
        if (this.m && (arrayList = this.f6341l) != null) {
            this.m = false;
            return arrayList;
        }
        j.b[] a2 = j.a(cVar, this.f6340k.getContentResolver(), 6);
        ArrayList<y> arrayList2 = new ArrayList<>();
        if (a2 != null && a2.length != 0) {
            String r = CameraBusinessSettingModel.v().r();
            String substring = (r == null || !r.contains("/")) ? "" : r.substring(0, r.lastIndexOf("/"));
            for (j.b bVar : a2) {
                r rVar = new r(this.f6340k, new Path(CloseFrame.NOCODE, String.valueOf(bVar.b)), bVar.a, true);
                if (!arrayList2.contains(rVar)) {
                    String str = bVar.f6369d;
                    if (!TextUtils.isEmpty(substring) && str != null && str.contains(substring)) {
                        if (rVar.r() > 0) {
                            arrayList2.add(rVar);
                        }
                    } else {
                        arrayList2.add(rVar);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                Collections.sort(arrayList2, this.n);
            }
        }
        return arrayList2;
    }

    protected boolean D() {
        return this.f6339j.a();
    }

    @Override // com.pinguo.album.d
    public synchronized void b(com.pinguo.album.c<ArrayList<y>> cVar) {
        if (this.f6336g != cVar) {
            return;
        }
        ArrayList<y> arrayList = cVar.get();
        this.f6337h = arrayList;
        this.f6335f = false;
        if (arrayList == null) {
            this.f6337h = new ArrayList<>();
        }
        this.f6338i.post(new Runnable() { // from class: com.pinguo.camera360.gallery.data.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.F();
            }
        });
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
        Iterator<y> it = this.f6341l.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += it.next().r();
        }
        return i2;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public String s() {
        return "path-set";
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public y t(int i2) {
        if (i2 < 0 || i2 >= this.f6341l.size()) {
            return null;
        }
        return this.f6341l.get(i2);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int u() {
        return this.f6341l.size();
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public synchronized boolean v() {
        return this.f6335f;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public synchronized long x() {
        if (D()) {
            com.pinguo.album.c<ArrayList<y>> cVar = this.f6336g;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f6335f = true;
            this.f6336g = com.pinguo.album.e.e().a().b(new b(this, null), this);
        }
        ArrayList<y> arrayList = this.f6337h;
        if (arrayList != null) {
            this.f6341l = arrayList;
            this.f6337h = null;
            Iterator<y> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().x();
            }
            this.a = x.j();
        }
        return this.a;
    }
}
