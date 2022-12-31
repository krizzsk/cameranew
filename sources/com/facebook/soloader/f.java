package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.m;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;
/* compiled from: ExtractFromZipSoSource.java */
/* loaded from: classes.dex */
public class f extends m {

    /* renamed from: f  reason: collision with root package name */
    protected final File f3281f;

    /* renamed from: g  reason: collision with root package name */
    protected final String f3282g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExtractFromZipSoSource.java */
    /* loaded from: classes.dex */
    public static final class b extends m.b implements Comparable {
        final ZipEntry c;

        /* renamed from: d  reason: collision with root package name */
        final int f3283d;

        b(String str, ZipEntry zipEntry, int i2) {
            super(str, a(zipEntry));
            this.c = zipEntry;
            this.f3283d = i2;
        }

        private static String a(ZipEntry zipEntry) {
            return String.format("pseudo-zip-hash-1-%s-%s-%s-%s", zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc()));
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.a.compareTo(((b) obj).a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: ExtractFromZipSoSource.java */
    /* loaded from: classes.dex */
    public class c extends m.f {
        @Nullable
        private b[] a;
        private final ZipFile b;
        private final m c;

        /* compiled from: ExtractFromZipSoSource.java */
        /* loaded from: classes.dex */
        private final class a extends m.e {
            private int a;

            private a() {
            }

            @Override // com.facebook.soloader.m.e
            public boolean d() {
                c.this.w();
                return this.a < c.this.a.length;
            }

            @Override // com.facebook.soloader.m.e
            public m.d t() throws IOException {
                c.this.w();
                b[] bVarArr = c.this.a;
                int i2 = this.a;
                this.a = i2 + 1;
                b bVar = bVarArr[i2];
                InputStream inputStream = c.this.b.getInputStream(bVar.c);
                try {
                    return new m.d(bVar, inputStream);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(m mVar) throws IOException {
            this.b = new ZipFile(f.this.f3281f);
            this.c = mVar;
        }

        @Override // com.facebook.soloader.m.f, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // com.facebook.soloader.m.f
        protected final m.c d() throws IOException {
            return new m.c(w());
        }

        @Override // com.facebook.soloader.m.f
        protected final m.e t() throws IOException {
            return new a();
        }

        final b[] w() {
            if (this.a == null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashMap hashMap = new HashMap();
                Pattern compile = Pattern.compile(f.this.f3282g);
                String[] h2 = SysUtil.h();
                Enumeration<? extends ZipEntry> entries = this.b.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    Matcher matcher = compile.matcher(nextElement.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        int e2 = SysUtil.e(h2, group);
                        if (e2 >= 0) {
                            linkedHashSet.add(group);
                            b bVar = (b) hashMap.get(group2);
                            if (bVar == null || e2 < bVar.f3283d) {
                                hashMap.put(group2, new b(group2, nextElement, e2));
                            }
                        }
                    }
                }
                this.c.q((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
                b[] bVarArr = (b[]) hashMap.values().toArray(new b[hashMap.size()]);
                Arrays.sort(bVarArr);
                int i2 = 0;
                for (int i3 = 0; i3 < bVarArr.length; i3++) {
                    b bVar2 = bVarArr[i3];
                    if (x(bVar2.c, bVar2.a)) {
                        i2++;
                    } else {
                        bVarArr[i3] = null;
                    }
                }
                b[] bVarArr2 = new b[i2];
                int i4 = 0;
                for (b bVar3 : bVarArr) {
                    if (bVar3 != null) {
                        bVarArr2[i4] = bVar3;
                        i4++;
                    }
                }
                this.a = bVarArr2;
            }
            return this.a;
        }

        protected boolean x(ZipEntry zipEntry, String str) {
            throw null;
        }
    }

    public f(Context context, String str, File file, String str2) {
        super(context, str);
        this.f3281f = file;
        this.f3282g = str2;
    }
}
