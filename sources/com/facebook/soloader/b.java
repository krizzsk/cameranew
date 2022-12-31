package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
/* compiled from: ApplicationSoSource.java */
/* loaded from: classes.dex */
public class b extends k {
    private Context a;
    private int b;
    private c c;

    public b(Context context, int i2) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        if (applicationContext == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.a = context;
        }
        this.b = i2;
        this.c = new c(new File(this.a.getApplicationInfo().nativeLibraryDir), i2);
    }

    public static File d(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    @Override // com.facebook.soloader.k
    public int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.c.a(str, i2, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.soloader.k
    public void b(int i2) throws IOException {
        this.c.b(i2);
    }

    public boolean c() throws IOException {
        File file = this.c.a;
        Context e2 = e();
        File d2 = d(e2);
        if (file.equals(d2)) {
            return false;
        }
        Log.d("SoLoader", "Native library directory updated from " + file + " to " + d2);
        int i2 = this.b | 1;
        this.b = i2;
        c cVar = new c(d2, i2);
        this.c = cVar;
        cVar.b(i2);
        this.a = e2;
        return true;
    }

    public Context e() {
        try {
            Context context = this.a;
            return context.createPackageContext(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.facebook.soloader.k
    public String toString() {
        return this.c.toString();
    }
}
