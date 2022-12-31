package us.pinguo.camera360.shop.data.install;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import us.pinguo.camera360.shop.download.BaseDownloader;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.o0;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.repository2020.database.EffectDbManager;
import us.pinguo.repository2020.manager.FilterRepository;
/* compiled from: BaseInstallTask.java */
/* loaded from: classes3.dex */
public abstract class e extends AsyncTask<String, Integer, q> {
    protected final p a;
    protected final k b;

    public e(k kVar, p pVar) {
        this.a = pVar;
        this.b = kVar;
    }

    private void c() {
        String m = m();
        String n = n();
        us.pinguo.util.l.j(m);
        us.pinguo.util.l.j(n);
        EffectDbManager a = us.pinguo.repository2020.database.a.a();
        a.x().e(this.b.b());
        us.pinguo.repository2020.database.filter.a w = a.w();
        w.c(w.d(this.b.b()));
        us.pinguo.repository2020.database.filter.e y = a.y();
        y.c(y.d(this.b.b()));
    }

    private void d(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    private q e(BaseDownloader baseDownloader, String str, String str2, Object obj, boolean z) throws IOException {
        File file = new File(str2 + ".tmp");
        long length = (z && file.exists()) ? file.length() : 0L;
        InputStream b = baseDownloader.b(str, null, length);
        if (b != null) {
            t(str, b, str2, b instanceof com.pinguo.album.data.download.a ? b.available() : 2147483647L, obj, length);
            if (isCancelled()) {
                return new q(this.b.b(), false, 3, null);
            }
            if (!new File(str2).exists()) {
                return new q(this.b.b(), false, 5, null);
            }
            return new q(this.b.b(), true, 0, null);
        }
        return new q(this.b.b(), false, 5, null);
    }

    private static byte[] j(String str) {
        try {
            HttpRequest httpRequest = HttpRequest.get(str + "?_=" + System.currentTimeMillis());
            httpRequest.trustAllCerts();
            httpRequest.followRedirects(true);
            httpRequest.connectTimeout(5000);
            httpRequest.readTimeout(10000);
            int code = httpRequest.code();
            if (code == 200) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                httpRequest.receive(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } else if (code == 404) {
                return null;
            } else {
                throw new IOException("Http connect error,status code =" + code);
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public boolean a() {
        return true;
    }

    protected boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return 31457280 <= o0.d(BaseApplication.d()).a(new File(str).getParent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.utils.AsyncTask
    /* renamed from: f */
    public q doInBackground(String... strArr) {
        if (!s()) {
            return new q(this.b.b(), false, 4, null);
        }
        q g2 = g();
        if (g2.d()) {
            if (!a()) {
                return new q(this.b.b(), false, 4, null);
            }
            q o = o();
            if (o.d()) {
                us.pinguo.camera360.shop.data.i.e().s();
                FilterRepository.a.J(false);
                l();
            }
            return o;
        }
        return g2;
    }

    public abstract q g();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public q h(String str, String str2, Object obj) {
        return i(str, str2, obj, true);
    }

    protected q i(String str, String str2, Object obj, boolean z) {
        if (new File(str2).exists()) {
            return new q(this.b.b(), true, 0, null);
        }
        if (z && !us.pinguo.util.q.f(BaseApplication.d())) {
            return new q(this.b.b(), false, 2, null);
        }
        if (!b(str2)) {
            return new q(this.b.b(), false, 1, null);
        }
        us.pinguo.util.l.f(new File(str2).getParent());
        BaseDownloader baseDownloader = new BaseDownloader(BaseApplication.d());
        try {
            return e(baseDownloader, str, str2, obj, z);
        } catch (IOException e2) {
            try {
                Thread.sleep(3000L);
                return e(baseDownloader, str, str2, obj, z);
            } catch (IOException e3) {
                e3.printStackTrace();
                return new q(this.b.b(), false, 5, e2);
            } catch (InterruptedException e4) {
                e4.printStackTrace();
                return new q(this.b.b(), false, 5, e2);
            }
        }
    }

    protected void k(String str, float f2, Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
    }

    protected String m() {
        return null;
    }

    protected String n() {
        return null;
    }

    public abstract q o();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.utils.AsyncTask
    public void onPreExecute() {
        p pVar = this.a;
        if (pVar != null) {
            pVar.b(this.b.b());
        }
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str) {
        String a = this.b.a();
        if (a != null) {
            String str2 = t.b + str + "/icon_online";
            if (a.startsWith("assets://")) {
                try {
                    us.pinguo.foundation.utils.e.a(BaseApplication.d(), a.substring(9), new File(str2));
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            byte[] j2 = j(a);
            if (j2 != null) {
                us.pinguo.util.k.i(str2, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.utils.AsyncTask
    /* renamed from: q */
    public void onPostExecute(q qVar) {
        super.onPostExecute(qVar);
        if (!qVar.d()) {
            c();
        }
        p pVar = this.a;
        if (pVar != null) {
            pVar.a(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.utils.AsyncTask
    /* renamed from: r */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        us.pinguo.common.log.a.c("newShop,progress update:" + numArr[0], new Object[0]);
        p pVar = this.a;
        if (pVar != null) {
            pVar.c(this.b.b(), numArr[0].intValue());
        }
    }

    public boolean s() {
        return true;
    }

    protected void t(String str, InputStream inputStream, String str2, long j2, Object obj, long j3) throws IOException {
        Throwable th;
        long j4 = j2 + j3;
        String str3 = str2 + ".tmp";
        FileOutputStream fileOutputStream = null;
        try {
            int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
            FileOutputStream fileOutputStream2 = new FileOutputStream(str3, i2 > 0);
            try {
                byte[] bArr = new byte[8192];
                long j5 = i2 > 0 ? j3 : 0L;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1 && !isCancelled()) {
                        try {
                            fileOutputStream2.write(bArr, 0, read);
                            j5 += read;
                            k(str, (((float) j5) * 1.0f) / ((float) j4), obj);
                        } catch (IOException e2) {
                            if (i2 > 0) {
                                d(str3);
                            }
                            throw e2;
                        }
                    } else {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        if (!isCancelled() && !new File(str3).renameTo(new File(str2))) {
                            throw new IOException("can't rename file");
                        }
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
