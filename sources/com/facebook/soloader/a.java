package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import com.facebook.soloader.f;
import com.facebook.soloader.m;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
/* compiled from: ApkSoSource.java */
/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: h  reason: collision with root package name */
    private final int f3277h;

    /* compiled from: ApkSoSource.java */
    /* renamed from: com.facebook.soloader.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0123a extends f.c {

        /* renamed from: e  reason: collision with root package name */
        private File f3278e;

        /* renamed from: f  reason: collision with root package name */
        private final int f3279f;

        C0123a(f fVar) throws IOException {
            super(fVar);
            this.f3278e = new File(a.this.c.getApplicationInfo().nativeLibraryDir);
            this.f3279f = a.this.f3277h;
        }

        @Override // com.facebook.soloader.f.c
        protected boolean x(ZipEntry zipEntry, String str) {
            String str2;
            String name = zipEntry.getName();
            boolean z = false;
            if (str.equals(a.this.f3285d)) {
                a.this.f3285d = null;
                str2 = String.format("allowing consideration of corrupted lib %s", str);
            } else if ((this.f3279f & 1) == 0) {
                str2 = "allowing consideration of " + name + ": self-extraction preferred";
            } else {
                File file = new File(this.f3278e, str);
                if (!file.isFile()) {
                    str2 = String.format("allowing considering of %s: %s not in system lib dir", name, str);
                } else {
                    long length = file.length();
                    long size = zipEntry.getSize();
                    if (length != size) {
                        str2 = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                    } else {
                        str2 = "not allowing consideration of " + name + ": deferring to libdir";
                        Log.d("ApkSoSource", str2);
                        return z;
                    }
                }
            }
            z = true;
            Log.d("ApkSoSource", str2);
            return z;
        }
    }

    public a(Context context, File file, String str, int i2) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.f3277h = i2;
    }

    @Override // com.facebook.soloader.m
    protected byte[] j() throws IOException {
        File canonicalFile = this.f3281f.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(SysUtil.g(this.c));
            if ((this.f3277h & 1) == 0) {
                obtain.writeByte((byte) 0);
                return obtain.marshall();
            }
            String str = this.c.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                obtain.writeByte((byte) 1);
                return obtain.marshall();
            }
            File canonicalFile2 = new File(str).getCanonicalFile();
            if (!canonicalFile2.exists()) {
                obtain.writeByte((byte) 1);
                return obtain.marshall();
            }
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile2.getPath());
            obtain.writeLong(canonicalFile2.lastModified());
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    @Override // com.facebook.soloader.m
    protected m.f m() throws IOException {
        return new C0123a(this);
    }
}
