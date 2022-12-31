package com.pinguo.camera360.gallery.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.a;
import com.pinguo.camera360.gallery.RootActivity;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.util.GalleryDeleteUtil;
import java.util.ArrayList;
import java.util.Iterator;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.bigalbum.entity.Gallery;
import us.pinguo.foundation.utils.p0;
import vStudio.Android.Camera360.R;
/* compiled from: MenuExecutor.java */
/* loaded from: classes3.dex */
public class r {
    private us.pinguo.foundation.ui.mddialog.a a;
    private com.pinguo.album.c<?> b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6623d;

    /* renamed from: e  reason: collision with root package name */
    private final RootActivity f6624e;

    /* renamed from: f  reason: collision with root package name */
    private final o f6625f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f6626g;

    /* renamed from: h  reason: collision with root package name */
    private Toast f6627h;

    /* renamed from: i  reason: collision with root package name */
    private String f6628i;

    /* compiled from: MenuExecutor.java */
    /* loaded from: classes3.dex */
    class a extends com.pinguo.album.g {
        a(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    r.this.A();
                    Object obj = message.obj;
                    if (obj != null) {
                        ((g) obj).a(message.arg1);
                    }
                    r.this.f6625f.f();
                    return;
                case 2:
                    if (r.this.a != null && !r.this.f6623d) {
                        r.this.a.o(message.arg1 + 1);
                    }
                    Object obj2 = message.obj;
                    if (obj2 != null) {
                        ((g) obj2).d(message.arg1);
                        return;
                    }
                    return;
                case 3:
                    Object obj3 = message.obj;
                    if (obj3 != null) {
                        ((g) obj3).b();
                        return;
                    }
                    return;
                case 4:
                    r.this.f6624e.startActivity((Intent) message.obj);
                    return;
                case 5:
                    r.this.f6624e.y0(R.string.video_not_support);
                    return;
                case 6:
                    r.this.f6624e.y0(R.string.add_story_toast);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuExecutor.java */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnDismissListener {
        b(r rVar) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuExecutor.java */
    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnKeyListener {
        c(r rVar) {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            return keyEvent.getKeyCode() == 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuExecutor.java */
    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            if (r.this.b != null) {
                r.this.b.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MenuExecutor.java */
    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        private final int a;
        private final g b;

        public e(int i2, g gVar) {
            this.a = i2;
            this.b = gVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            g gVar = this.b;
            if (gVar != null) {
                gVar.c(false);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            if (i2 == -1) {
                g gVar = this.b;
                if (gVar != null) {
                    gVar.c(true);
                }
                r.this.q(this.a, this.b);
                return;
            }
            g gVar2 = this.b;
            if (gVar2 != null) {
                gVar2.c(false);
            }
            if (r.this.f6625f != null) {
                Iterator<Path> it = r.this.f6625f.g(false).iterator();
                while (it.hasNext()) {
                    r.this.f6625f.e(it.next(), false);
                }
            }
        }
    }

    /* compiled from: MenuExecutor.java */
    /* loaded from: classes3.dex */
    public interface g {
        void a(int i2);

        void b();

        void c(boolean z);

        void d(int i2);

        void e();
    }

    public r(RootActivity rootActivity, o oVar) {
        com.pinguo.album.j.a.c(rootActivity);
        RootActivity rootActivity2 = rootActivity;
        this.f6624e = rootActivity2;
        com.pinguo.album.j.a.c(oVar);
        this.f6625f = oVar;
        this.f6627h = Toast.makeText(rootActivity2, (int) R.string.video_not_support, 0);
        this.f6626g = new a(rootActivity2.E());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.pinguo.album.c<?> cVar = this.b;
        if (cVar != null) {
            if (!this.c) {
                cVar.cancel();
            }
            us.pinguo.foundation.ui.mddialog.a aVar = this.a;
            if (aVar != null && aVar.g()) {
                this.a.f();
            }
            this.a = null;
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.pinguo.camera360.gallery.data.o oVar, a.c cVar, int i2, Path path) {
        System.currentTimeMillis();
        switch (i2) {
            case R.id.action_delete /* 2131296354 */:
            case R.id.action_delete_album /* 2131296355 */:
            case R.id.delete_button /* 2131296784 */:
                oVar.b(path, true);
                break;
            case R.id.action_rename_album /* 2131296366 */:
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", this.f6628i);
                BigAlbumManager.instance().updateGallery(Integer.parseInt(path.f()), contentValues);
                break;
            case R.id.action_set_to_cover /* 2131296368 */:
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(BigAlbumStore.GalleryColumns.COVER_PHOTO_ID, path.f());
                BigAlbumManager.instance().updateGallery(path.b(), contentValues2);
                break;
            case R.id.add_pic_to_new_album /* 2131296388 */:
                Gallery gallery = new Gallery();
                gallery.name = this.f6628i;
                gallery.createDate = System.currentTimeMillis();
                BigAlbumManager.instance().insertGallery(gallery, o(this.f6625f.g(false)));
                break;
            default:
                throw new AssertionError();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(com.pinguo.camera360.gallery.data.o oVar, Path path, int i2, ArrayList<Path> arrayList) {
        System.currentTimeMillis();
        ArrayList<Integer> o = o(arrayList);
        switch (i2) {
            case R.id.action_add /* 2131296340 */:
            case R.id.action_confirm_add_pics /* 2131296350 */:
                com.pinguo.camera360.gallery.data.x d2 = oVar.d(path, "");
                if (o == null || o.size() <= 0) {
                    return true;
                }
                d2.i(o);
                this.f6626g.sendEmptyMessage(6);
                return true;
            case R.id.action_add_album /* 2131296341 */:
                Gallery gallery = new Gallery();
                gallery.name = this.f6628i;
                gallery.createDate = System.currentTimeMillis();
                BigAlbumManager.instance().insertGallery(gallery, o);
                return true;
            default:
                throw new AssertionError();
        }
    }

    private ArrayList<Integer> o(ArrayList<Path> arrayList) {
        ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<Path> it = arrayList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Path next = it.next();
            if (next.h() == 1101) {
                if (this.f6627h != null && !z) {
                    z = true;
                    this.f6626g.sendEmptyMessage(5);
                }
            } else {
                arrayList2.add(Integer.valueOf(next.f()));
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i2, g gVar) {
        r(i2, gVar, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i2, g gVar, int i3) {
        Handler handler = this.f6626g;
        handler.sendMessage(handler.obtainMessage(1, i2, i3, gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(g gVar) {
        Handler handler = this.f6626g;
        handler.sendMessage(handler.obtainMessage(3, gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i2, g gVar) {
        Handler handler = this.f6626g;
        handler.sendMessage(handler.obtainMessage(2, i2, 0, gVar));
    }

    public void p(int i2, int i3, g gVar) {
        if (gVar != null) {
            gVar.e();
        }
        us.pinguo.foundation.utils.w.j(this.f6624e, i3, R.string.pgcommon_ok, R.string.pgcommon_cancel, new e(i2, gVar), R.style.Gallery_MD_Dialog);
    }

    public void r(int i2, g gVar, boolean z, boolean z2) {
        switch (i2) {
            case R.id.action_delete /* 2131296354 */:
            case R.id.action_delete_album /* 2131296355 */:
            case R.id.delete_button /* 2131296784 */:
                v(i2, R.string.common_delete, gVar, z, z2);
                return;
            default:
                return;
        }
    }

    public void v(int i2, int i3, g gVar, boolean z, boolean z2) {
        ArrayList<Path> g2 = this.f6625f.g(false);
        A();
        b bVar = new b(this);
        c cVar = new c(this);
        d dVar = new d();
        if (g2.size() == 1) {
            us.pinguo.foundation.ui.mddialog.a c2 = us.pinguo.foundation.utils.w.c(this.f6624e, 2, false);
            this.a = c2;
            c2.q();
        } else {
            this.a = com.pinguo.camera360.gallery.temps.a.b(this.f6624e, 1, false, dVar, null, bVar, cVar, this.f6625f.c(), 0, 0);
        }
        this.b = this.f6624e.G().b(new f(i2, g2, gVar), null);
        this.c = z;
    }

    public void w(int i2, Path path, ArrayList<Path> arrayList, g gVar) {
        this.a = null;
        this.b = this.f6624e.G().b(new f(this, i2, path, arrayList, gVar), null);
        this.c = false;
    }

    public void x(int i2, ArrayList<Path> arrayList, g gVar, String str) {
        this.a = null;
        this.f6628i = str;
        this.b = this.f6624e.G().b(new f(i2, arrayList, gVar), null);
        this.c = false;
    }

    public void y(int i2, Path path, g gVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(path);
        this.a = null;
        this.b = this.f6624e.G().b(new f(i2, arrayList, gVar), null);
        this.c = false;
    }

    public void z(int i2, Path path, String str, g gVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(path);
        this.f6628i = str;
        this.a = null;
        this.b = this.f6624e.G().b(new f(i2, arrayList, gVar), null);
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MenuExecutor.java */
    /* loaded from: classes3.dex */
    public class f implements a.b<Void> {
        private final ArrayList<Path> a;
        private final int b;
        private final g c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6629d;

        /* renamed from: e  reason: collision with root package name */
        private Path f6630e;

        public f(int i2, ArrayList<Path> arrayList, g gVar) {
            this.f6629d = false;
            this.b = i2;
            this.a = arrayList;
            this.c = gVar;
            this.f6629d = b(i2);
        }

        private boolean b(int i2) {
            switch (i2) {
                case R.id.action_add /* 2131296340 */:
                case R.id.action_add_album /* 2131296341 */:
                case R.id.action_confirm_add_pics /* 2131296350 */:
                    return true;
                default:
                    return false;
            }
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: c */
        public Void a(a.c cVar) {
            com.pinguo.camera360.gallery.data.o P = r.this.f6624e.P();
            int i2 = 1;
            try {
                r.this.t(this.c);
                if (this.f6629d) {
                    if (!r.this.n(P, this.f6630e, this.b, this.a)) {
                        i2 = 2;
                    }
                } else if (p0.b(this) && this.a.size() > 1) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < this.a.size()) {
                        arrayList.add((com.pinguo.camera360.gallery.data.w) P.d(this.a.get(i3), ""));
                        r.this.u(i4, this.c);
                        i3++;
                        i4++;
                    }
                    GalleryDeleteUtil.a.e(arrayList);
                } else {
                    Iterator<Path> it = this.a.iterator();
                    int i5 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Path next = it.next();
                        if (cVar.isCancelled()) {
                            i2 = 3;
                            break;
                        }
                        if (!r.this.m(P, cVar, this.b, next)) {
                            i2 = 2;
                        }
                        int i6 = i5 + 1;
                        r.this.u(i5, this.c);
                        i5 = i6;
                    }
                }
            } finally {
                try {
                    return null;
                } finally {
                }
            }
            return null;
        }

        public f(r rVar, int i2, Path path, ArrayList<Path> arrayList, g gVar) {
            this(i2, arrayList, gVar);
            this.f6630e = path;
        }
    }
}
