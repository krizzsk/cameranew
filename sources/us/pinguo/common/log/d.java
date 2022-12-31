package us.pinguo.common.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogThread.java */
/* loaded from: classes4.dex */
public class d extends Thread {
    private static boolean c = false;
    private String a;
    private String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(String str, String str2) {
        this.a = str;
        this.b = str2;
        setName("Log Thread");
    }

    private static boolean a(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static void b(boolean z) {
        c = z;
    }

    private void c() throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String str = this.b + simpleDateFormat.format(new Date()) + ".log";
        if (a(this.a)) {
            PrintWriter printWriter = null;
            try {
                PrintWriter printWriter2 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.a + File.separator + str, true), "utf-8"));
                while (c) {
                    try {
                        try {
                            b f2 = e.f();
                            printWriter2.println('[' + simpleDateFormat.format(new Date(f2.d())) + ']' + f2.toString());
                            printWriter2.flush();
                        } catch (InterruptedException unused) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        printWriter = printWriter2;
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        throw th;
                    }
                }
                e.a();
                printWriter2.close();
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IOException("Create Folder(" + this.a + ") Failed.");
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            c();
        } catch (IOException e2) {
            PrintStream printStream = System.out;
            printStream.println("Error:" + e2.getMessage());
        }
        super.run();
    }
}
