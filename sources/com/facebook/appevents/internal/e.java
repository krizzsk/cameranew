package com.facebook.appevents.internal;

import android.os.AsyncTask;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
/* compiled from: FileDownloadTask.java */
/* loaded from: classes.dex */
public class e extends AsyncTask<String, Void, Boolean> {
    private a a;
    private File b;
    private String c;

    /* compiled from: FileDownloadTask.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(File file);
    }

    public e(String str, File file, a aVar) {
        this.c = str;
        this.b = file;
        this.a = aVar;
    }

    protected Boolean a(String... strArr) {
        try {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return null;
            }
            try {
                URL url = new URL(this.c);
                int contentLength = url.openConnection().getContentLength();
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                byte[] bArr = new byte[contentLength];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.b));
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    protected void b(Boolean bool) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (bool.booleanValue()) {
                this.a.a(this.b);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Boolean doInBackground(String[] strArr) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return a(strArr);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(Boolean bool) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            b(bool);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }
}
