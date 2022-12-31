package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
/* compiled from: NativeAppCallAttachmentStore.java */
/* loaded from: classes.dex */
public final class s {
    private static final String a = "com.facebook.internal.s";
    private static File b;

    /* compiled from: NativeAppCallAttachmentStore.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final UUID a;
        private final String b;
        private final String c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap f3079d;

        /* renamed from: e  reason: collision with root package name */
        private Uri f3080e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3081f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f3082g;

        public String g() {
            return this.b;
        }

        public Uri h() {
            return this.f3080e;
        }

        private b(UUID uuid, Bitmap bitmap, Uri uri) {
            String a;
            this.a = uuid;
            this.f3079d = bitmap;
            this.f3080e = uri;
            boolean z = true;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(scheme)) {
                    this.f3081f = true;
                    this.f3082g = (uri.getAuthority() == null || uri.getAuthority().startsWith("media")) ? false : false;
                } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                    this.f3082g = true;
                } else if (!x.U(uri)) {
                    throw new FacebookException("Unsupported scheme for media Uri : " + scheme);
                }
            } else if (bitmap != null) {
                this.f3082g = true;
            } else {
                throw new FacebookException("Cannot share media without a bitmap or Uri set");
            }
            String uuid2 = !this.f3082g ? null : UUID.randomUUID().toString();
            this.c = uuid2;
            if (!this.f3082g) {
                a = this.f3080e.toString();
            } else {
                a = FacebookContentProvider.a(com.facebook.f.g(), uuid, uuid2);
            }
            this.b = a;
        }
    }

    private s() {
    }

    public static void a(Collection<b> collection) {
        if (collection == null || collection.size() == 0) {
            return;
        }
        if (b == null) {
            b();
        }
        f();
        ArrayList<File> arrayList = new ArrayList();
        try {
            for (b bVar : collection) {
                if (bVar.f3082g) {
                    File g2 = g(bVar.a, bVar.c, true);
                    arrayList.add(g2);
                    if (bVar.f3079d != null) {
                        k(bVar.f3079d, g2);
                    } else if (bVar.f3080e != null) {
                        l(bVar.f3080e, bVar.f3081f, g2);
                    }
                }
            }
        } catch (IOException e2) {
            String str = a;
            Log.e(str, "Got unexpected exception:" + e2);
            for (File file : arrayList) {
                try {
                    file.delete();
                } catch (Exception unused) {
                }
            }
            throw new FacebookException(e2);
        }
    }

    public static void b() {
        x.n(h());
    }

    public static void c(UUID uuid) {
        File i2 = i(uuid, false);
        if (i2 != null) {
            x.n(i2);
        }
    }

    public static b d(UUID uuid, Bitmap bitmap) {
        y.l(uuid, "callId");
        y.l(bitmap, "attachmentBitmap");
        return new b(uuid, bitmap, null);
    }

    public static b e(UUID uuid, Uri uri) {
        y.l(uuid, "callId");
        y.l(uri, "attachmentUri");
        return new b(uuid, null, uri);
    }

    static File f() {
        File h2 = h();
        h2.mkdirs();
        return h2;
    }

    static File g(UUID uuid, String str, boolean z) throws IOException {
        File i2 = i(uuid, z);
        if (i2 == null) {
            return null;
        }
        try {
            return new File(i2, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    static synchronized File h() {
        File file;
        synchronized (s.class) {
            if (b == null) {
                b = new File(com.facebook.f.f().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            }
            file = b;
        }
        return file;
    }

    static File i(UUID uuid, boolean z) {
        if (b == null) {
            return null;
        }
        File file = new File(b, uuid.toString());
        if (z && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File j(UUID uuid, String str) throws FileNotFoundException {
        if (!x.S(str) && uuid != null) {
            try {
                return g(uuid, str, false);
            } catch (IOException unused) {
                throw new FileNotFoundException();
            }
        }
        throw new FileNotFoundException();
    }

    private static void k(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            x.h(fileOutputStream);
        }
    }

    private static void l(Uri uri, boolean z, File file) throws IOException {
        InputStream openInputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            if (!z) {
                openInputStream = new FileInputStream(uri.getPath());
            } else {
                openInputStream = com.facebook.f.f().getContentResolver().openInputStream(uri);
            }
            x.m(openInputStream, fileOutputStream);
        } finally {
            x.h(fileOutputStream);
        }
    }
}
