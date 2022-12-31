package us.pinguo.picker.image.gallery;

import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.pinguo.album.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import us.pinguo.picker.image.gallery.c;
/* compiled from: AlbumImageSet.java */
/* loaded from: classes5.dex */
public class b extends o implements com.pinguo.album.d<ArrayList<o>> {
    private static final Uri o = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11686e;

    /* renamed from: f  reason: collision with root package name */
    private com.pinguo.album.c<ArrayList<o>> f11687f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<o> f11688g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f11689h;

    /* renamed from: i  reason: collision with root package name */
    private final d f11690i;

    /* renamed from: j  reason: collision with root package name */
    private Application f11691j;

    /* renamed from: k  reason: collision with root package name */
    private int f11692k;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<o> f11693l;
    boolean m;
    private Comparator<o> n;

    /* compiled from: AlbumImageSet.java */
    /* loaded from: classes5.dex */
    class a implements Comparator<o> {
        a(b bVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(o oVar, o oVar2) {
            return b(oVar2) - b(oVar);
        }

        public int b(o oVar) {
            if (oVar != null) {
                if ("Camera360Cloud".equalsIgnoreCase(oVar.i())) {
                    return RoomDatabase.MAX_BIND_PARAMETER_CNT;
                }
                if ("Camera".equalsIgnoreCase(oVar.i())) {
                    return 998;
                }
                return "DCIM".equalsIgnoreCase(oVar.i()) ? 997 : 0;
            }
            return 0;
        }
    }

    /* compiled from: AlbumImageSet.java */
    /* renamed from: us.pinguo.picker.image.gallery.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class RunnableC0430b implements Runnable {
        RunnableC0430b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.m();
        }
    }

    /* compiled from: AlbumImageSet.java */
    /* loaded from: classes5.dex */
    private class c implements a.b<ArrayList<o>> {
        private c() {
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public ArrayList<o> a(a.c cVar) {
            return b.this.p(cVar);
        }

        /* synthetic */ c(b bVar, a aVar) {
            this();
        }
    }

    public b(Application application, Path path) {
        super(path, n.d());
        this.f11692k = -1;
        this.f11693l = new ArrayList<>();
        this.m = false;
        this.n = new a(this);
        this.f11691j = application;
        this.f11690i = new d(this, o, application);
        this.f11689h = new Handler(application.getMainLooper());
    }

    @Override // com.pinguo.album.d
    public synchronized void b(com.pinguo.album.c<ArrayList<o>> cVar) {
        if (this.f11687f != cVar) {
            return;
        }
        ArrayList<o> arrayList = cVar.get();
        this.f11688g = arrayList;
        this.f11686e = false;
        if (arrayList == null) {
            this.f11688g = new ArrayList<>();
        }
        this.f11689h.post(new RunnableC0430b());
    }

    @Override // us.pinguo.picker.image.gallery.o
    public ArrayList<m> g(int i2, int i3) {
        return null;
    }

    @Override // us.pinguo.picker.image.gallery.o
    public int h() {
        this.f11692k = 0;
        Iterator<o> it = this.f11693l.iterator();
        while (it.hasNext()) {
            this.f11692k += it.next().h();
        }
        return this.f11692k;
    }

    @Override // us.pinguo.picker.image.gallery.o
    public String i() {
        return "path-set";
    }

    @Override // us.pinguo.picker.image.gallery.o
    public o j(int i2) {
        if (i2 < 0 || i2 >= this.f11693l.size()) {
            return null;
        }
        return this.f11693l.get(i2);
    }

    @Override // us.pinguo.picker.image.gallery.o
    public int k() {
        return this.f11693l.size();
    }

    @Override // us.pinguo.picker.image.gallery.o
    public synchronized boolean l() {
        return this.f11686e;
    }

    @Override // us.pinguo.picker.image.gallery.o
    public synchronized long n() {
        if (q()) {
            com.pinguo.album.c<ArrayList<o>> cVar = this.f11687f;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f11686e = true;
            this.f11687f = com.pinguo.album.e.e().a().b(new c(this, null), this);
        }
        ArrayList<o> arrayList = this.f11688g;
        if (arrayList != null) {
            this.f11693l = arrayList;
            this.f11688g = null;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
            this.a = n.d();
        }
        return this.a;
    }

    protected ArrayList<o> p(a.c cVar) {
        ArrayList<o> arrayList;
        if (this.m && (arrayList = this.f11693l) != null) {
            this.m = false;
            return arrayList;
        }
        c.b[] a2 = us.pinguo.picker.image.gallery.c.a(cVar, this.f11691j.getContentResolver(), 6);
        ArrayList<o> arrayList2 = new ArrayList<>();
        if (a2 != null && a2.length != 0) {
            String k2 = us.pinguo.foundation.j.e().k("pref_camera_save_path_key", us.pinguo.foundation.f.b());
            String substring = (k2 == null || !k2.contains("/")) ? "" : k2.substring(0, k2.lastIndexOf("/"));
            for (c.b bVar : a2) {
                i iVar = new i(this.f11691j, new Path(CloseFrame.NOCODE, String.valueOf(bVar.b)), bVar.a, true);
                if (!arrayList2.contains(iVar)) {
                    String str = bVar.f11694d;
                    if (!TextUtils.isEmpty(substring) && str != null && str.contains(substring)) {
                        if (iVar.h() > 0) {
                            arrayList2.add(iVar);
                        }
                    } else {
                        arrayList2.add(iVar);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                Collections.sort(arrayList2, this.n);
            }
        }
        return arrayList2;
    }

    protected boolean q() {
        return this.f11690i.a();
    }
}
