package us.pinguo.picker.image.gallery;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import java.util.ArrayList;
/* compiled from: LocalAlbum.java */
/* loaded from: classes5.dex */
public class i extends a {
    private static final String[] n = {"bucket_id"};

    /* renamed from: f  reason: collision with root package name */
    private final String f11701f;

    /* renamed from: g  reason: collision with root package name */
    private final Uri f11702g;

    /* renamed from: h  reason: collision with root package name */
    private final String[] f11703h;

    /* renamed from: i  reason: collision with root package name */
    private final ContentResolver f11704i;

    /* renamed from: j  reason: collision with root package name */
    private final String f11705j;

    /* renamed from: k  reason: collision with root package name */
    private final d f11706k;

    /* renamed from: l  reason: collision with root package name */
    private int f11707l;
    private final boolean m;

    public i(Application application, Path path, String str, boolean z) {
        super(application, path, n.d());
        this.f11707l = -1;
        this.f11704i = application.getContentResolver();
        this.f11705j = str;
        this.m = z;
        if (z) {
            this.f11701f = "datetaken DESC, _id DESC";
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            this.f11702g = uri;
            this.f11703h = j.p;
            this.f11706k = new d(this, uri, application);
            return;
        }
        this.f11701f = "datetaken DESC, _id DESC";
        Uri uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        this.f11702g = uri2;
        this.f11703h = l.n;
        this.f11706k = new d(this, uri2, application);
    }

    @Override // us.pinguo.picker.image.gallery.o
    public ArrayList<m> g(int i2, int i3) {
        m lVar;
        Uri.Builder buildUpon = this.f11702g.buildUpon();
        Uri build = buildUpon.appendQueryParameter("limit", i2 + "," + i3).build();
        ArrayList<m> arrayList = new ArrayList<>();
        com.pinguo.album.j.c.a();
        Cursor query = this.f11704i.query(build, this.f11703h, q(), p(), this.f11701f);
        if (query == null) {
            us.pinguo.common.log.a.s("query fail: " + build, new Object[0]);
            return arrayList;
        }
        while (query.moveToNext()) {
            try {
                if (this.m) {
                    Application application = this.f11685e;
                    Path path = new Path(CloseFrame.NOCODE, query.getString(8));
                    path.h(query.getLong(5));
                    lVar = new j(application, path, query);
                } else {
                    Application application2 = this.f11685e;
                    Path path2 = new Path(1101, query.getString(8));
                    path2.h(query.getLong(5));
                    lVar = new l(application2, path2, query);
                }
                arrayList.add(lVar);
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    @Override // us.pinguo.picker.image.gallery.o
    public int h() {
        if (this.f11707l == -1) {
            Cursor query = this.f11704i.query(this.f11702g, n, q(), p(), null);
            if (query == null) {
                us.pinguo.common.log.a.s("query fail", new Object[0]);
                return 0;
            }
            try {
                this.f11707l = query.getCount();
            } finally {
                query.close();
            }
        }
        return this.f11707l;
    }

    @Override // us.pinguo.picker.image.gallery.o
    public String i() {
        return this.f11705j;
    }

    @Override // us.pinguo.picker.image.gallery.o
    public long n() {
        if (this.f11706k.a()) {
            this.a = n.d();
            this.f11707l = -1;
        }
        return this.a;
    }

    protected String[] p() {
        return TextUtils.isEmpty(this.b.b()) ? new String[0] : new String[]{String.valueOf(this.b.b())};
    }

    protected String q() {
        boolean z = this.m;
        return TextUtils.isEmpty(this.b.b()) ? "1 = 1" : "bucket_id = ?";
    }
}
