package d.e.d.o;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.ironsource.sdk.fileSystem.ISNFile;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
/* compiled from: DownloadManager.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    private static b f8566d;
    private d.e.d.o.a a = new d.e.d.o.a();
    private Thread b;
    private final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadManager.java */
    /* loaded from: classes2.dex */
    public static class a implements Callable<C0300b> {
        private String a;
        private String b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private long f8567d;

        /* renamed from: e  reason: collision with root package name */
        private String f8568e;

        a(String str, String str2, String str3, long j2, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.f8567d = j2;
            this.f8568e = str4;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C0300b call() {
            int i2;
            if (this.f8567d == 0) {
                this.f8567d = 1L;
            }
            C0300b c0300b = null;
            for (int i3 = 0; i3 < this.f8567d && ((i2 = (c0300b = b(this.a, i3)).a) == 1008 || i2 == 1009); i3++) {
            }
            if (c0300b != null && c0300b.b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                String str = File.separator;
                sb.append(str);
                sb.append(this.c);
                String sb2 = sb.toString();
                String str2 = this.f8568e + str + "tmp_" + this.c;
                try {
                    if (e(c0300b.b, str2) == 0) {
                        c0300b.a = 1006;
                    } else if (!d(str2, sb2)) {
                        c0300b.a = PointerIconCompat.TYPE_GRAB;
                    }
                } catch (FileNotFoundException unused) {
                    c0300b.a = PointerIconCompat.TYPE_ZOOM_IN;
                } catch (Error e2) {
                    if (!TextUtils.isEmpty(e2.getMessage())) {
                        com.ironsource.sdk.utils.d.d("DownloadManager", e2.getMessage());
                    }
                    c0300b.a = PointerIconCompat.TYPE_ZOOM_OUT;
                } catch (Exception e3) {
                    if (!TextUtils.isEmpty(e3.getMessage())) {
                        com.ironsource.sdk.utils.d.d("DownloadManager", e3.getMessage());
                    }
                    c0300b.a = 1009;
                }
            }
            return c0300b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:124:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #13 {all -> 0x0076, blocks: (B:17:0x0072, B:21:0x007a), top: B:124:0x0072 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        d.e.d.o.b.C0300b b(java.lang.String r8, int r9) {
            /*
                Method dump skipped, instructions count: 316
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: d.e.d.o.b.a.b(java.lang.String, int):d.e.d.o.b$b");
        }

        byte[] c(InputStream inputStream) throws IOException {
            return b.e(inputStream);
        }

        boolean d(String str, String str2) throws Exception {
            return com.ironsource.sdk.utils.c.x(str, str2);
        }

        int e(byte[] bArr, String str) throws Exception {
            return com.ironsource.sdk.utils.c.y(bArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadManager.java */
    /* renamed from: d.e.d.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0300b {
        int a;
        byte[] b;

        C0300b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadManager.java */
    /* loaded from: classes2.dex */
    public static class c implements Runnable {
        private final String a;
        private Handler b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private String f8569d;

        /* renamed from: e  reason: collision with root package name */
        private String f8570e;

        /* renamed from: f  reason: collision with root package name */
        private long f8571f = 3;

        c(ISNFile iSNFile, String str, Handler handler, String str2) {
            this.c = str;
            this.f8569d = iSNFile.getParent();
            this.f8570e = iSNFile.getName();
            this.b = handler;
            this.a = str2;
        }

        a a(String str, String str2, String str3, long j2, String str4) {
            return new a(str, str2, str3, j2, str4);
        }

        Message b() {
            return new Message();
        }

        String c(String str) {
            return com.ironsource.sdk.utils.c.v(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            ISNFile iSNFile = new ISNFile(this.f8569d, this.f8570e);
            Message b = b();
            b.obj = iSNFile;
            String c = c(iSNFile.getParent());
            if (c == null) {
                b.what = PointerIconCompat.TYPE_GRAB;
                this.b.sendMessage(b);
                return;
            }
            int i2 = a(this.c, c, iSNFile.getName(), this.f8571f, this.a).call().a;
            if (i2 == 200) {
                i2 = PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW;
            }
            b.what = i2;
            this.b.sendMessage(b);
        }
    }

    private b(String str) {
        this.c = str;
        com.ironsource.sdk.utils.c.h(h());
        com.ironsource.sdk.utils.c.v(h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static synchronized b g(String str) {
        b bVar;
        synchronized (b.class) {
            if (f8566d == null) {
                f8566d = new b(str);
            }
            bVar = f8566d;
        }
        return bVar;
    }

    private String h() {
        return com.ironsource.sdk.utils.c.a(this.c, "temp");
    }

    public void b(ISNFile iSNFile, String str) {
        c(iSNFile, str, this.a);
    }

    public void c(ISNFile iSNFile, String str, Handler handler) {
        new Thread(new c(iSNFile, str, handler, h())).start();
    }

    public void d(ISNFile iSNFile, String str) {
        Thread thread = new Thread(new c(iSNFile, str, this.a, h()));
        this.b = thread;
        thread.start();
    }

    public String f() {
        return this.c;
    }

    public boolean i() {
        Thread thread = this.b;
        return thread != null && thread.isAlive();
    }

    public synchronized void j() {
        f8566d = null;
        d.e.d.o.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
            this.a = null;
        }
    }

    public void k(d.e.d.o.c cVar) {
        this.a.b(cVar);
    }
}
