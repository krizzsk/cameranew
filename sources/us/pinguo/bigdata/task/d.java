package us.pinguo.bigdata.task;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import us.pinguo.bigdata.config.BDConfigManager;
import us.pinguo.bigdata.f.e;
import us.pinguo.bigdata.f.f;
import us.pinguo.bigdata.task.basic.IBDTask;
/* compiled from: WriteLogFileTask.java */
/* loaded from: classes3.dex */
public class d implements IBDTask {
    private final us.pinguo.bigdata.task.e.a a;
    private final Context b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final File f9128d;

    /* renamed from: e  reason: collision with root package name */
    private final File f9129e;

    /* renamed from: f  reason: collision with root package name */
    private PrintStream f9130f;

    /* renamed from: h  reason: collision with root package name */
    private long f9132h;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9131g = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9133i = false;

    public d(Context context, us.pinguo.bigdata.task.e.a aVar) {
        this.a = aVar;
        this.b = context;
        File file = new File(f.b(context));
        this.f9128d = file;
        this.f9129e = new File(f.a(context));
        this.f9132h = file.length();
        us.pinguo.common.log.a.m("uploadtask", "read file length:" + this.f9132h, new Object[0]);
        this.c = System.getProperty("line.separator").getBytes().length;
    }

    private void a(String str) {
        if (((float) g(str)) > BDConfigManager.instance().getServerConfig().getNum() * 1024.0f) {
            c(true);
        }
    }

    private void b() {
        PrintStream printStream = this.f9130f;
        if (printStream != null) {
            printStream.close();
            this.f9130f = null;
            us.pinguo.common.log.a.m("WriteLogFileTask", "stream closed", new Object[0]);
        }
    }

    private void c(boolean z) {
        b();
        String d2 = d();
        k();
        us.pinguo.bigdata.task.e.a aVar = this.a;
        if (aVar != null && z) {
            aVar.b(d2);
        }
        f(false);
    }

    private String d() {
        if (!this.f9129e.exists() && !this.f9129e.mkdirs()) {
            us.pinguo.common.log.a.g("WriteLogFileTask", "create complete folder failed", new Object[0]);
        }
        try {
            if (this.f9128d.length() > 0) {
                File createTempFile = File.createTempFile("log_", null, this.f9129e);
                if (this.f9128d.renameTo(createTempFile)) {
                    return createTempFile.getAbsolutePath();
                }
                us.pinguo.common.log.a.g("WriteLogFileTask", "rename current file to complete folder failed", new Object[0]);
            }
            return null;
        } catch (IOException e2) {
            us.pinguo.common.log.a.g("WriteLogFileTask", "copyToComplete current file to complete folder failed", new Object[0]);
            e2.printStackTrace();
            return null;
        }
    }

    private boolean e(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        us.pinguo.common.log.a.g("WriteLogFileTask", "Create log folder failed", new Object[0]);
        return false;
    }

    private void f(boolean z) {
        this.f9130f = e.a(this.f9128d.getAbsolutePath(), z);
    }

    private long g(String str) {
        long length = this.f9132h + str.getBytes().length;
        this.f9132h = length;
        long j2 = length + this.c;
        this.f9132h = j2;
        return j2;
    }

    private void h() {
        if (e(f.d(this.b))) {
            f(true);
        } else {
            us.pinguo.common.log.a.e("WriteLogFileTask", "create log folder failed");
        }
    }

    private void i() {
        b();
        String d2 = d();
        k();
        us.pinguo.bigdata.task.e.a aVar = this.a;
        if (aVar != null) {
            aVar.a(d2);
        }
        f(false);
    }

    private void k() {
        this.f9132h = 0L;
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void destroy() {
        this.f9131g = true;
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void execute() {
        try {
            try {
                if (this.f9130f == null) {
                    h();
                }
                while (!this.f9131g) {
                    String str = null;
                    try {
                        str = us.pinguo.bigdata.e.a.a().d();
                    } catch (Exception unused) {
                    }
                    PrintStream printStream = this.f9130f;
                    if (!TextUtils.isEmpty(str) && printStream != null) {
                        if ("UPLOAD".equals(str)) {
                            i();
                            if (us.pinguo.bigdata.a.c) {
                                Log.e("C360_STAT", "UPLOAD");
                            }
                            this.f9133i = false;
                        } else if ("FLUSH".equals(str)) {
                            if (this.f9133i) {
                                printStream.flush();
                                this.f9133i = false;
                                if (us.pinguo.bigdata.a.c) {
                                    Log.e("C360_STAT", "FLUSH");
                                }
                            }
                        } else {
                            a(str);
                            printStream.println(str);
                            if (us.pinguo.bigdata.a.c) {
                                Log.e("C360_STAT", "write msg:" + str);
                            }
                            us.pinguo.bigdata.task.e.a aVar = this.a;
                            if (aVar != null) {
                                aVar.c(this);
                            }
                            this.f9133i = true;
                        }
                    } else {
                        SystemClock.sleep(30L);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            b();
        }
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public Object getOrigin() {
        return null;
    }

    public void j() {
        us.pinguo.bigdata.e.a.a().b("FLUSH");
    }

    public void l() {
        us.pinguo.bigdata.e.a.a().b("UPLOAD");
    }
}
