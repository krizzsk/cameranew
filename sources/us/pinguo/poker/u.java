package us.pinguo.poker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.util.v;
/* compiled from: TagCache.java */
/* loaded from: classes5.dex */
public class u {
    private List<String> a;
    private String b = us.pinguo.foundation.n.a.b(v.a()).getAbsolutePath() + "/poker/poker.tag";

    private List<String> a() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(this.b));
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
        } catch (IOException unused) {
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!readLine.isEmpty()) {
                        arrayList.add(readLine);
                    }
                } else {
                    us.pinguo.util.f.a(bufferedReader);
                    return arrayList;
                }
            }
        } catch (IOException unused2) {
            bufferedReader2 = bufferedReader;
            ArrayList arrayList2 = new ArrayList();
            us.pinguo.util.f.a(bufferedReader2);
            return arrayList2;
        } catch (Throwable th3) {
            th = th3;
            us.pinguo.util.f.a(bufferedReader);
            throw th;
        }
    }

    private void d() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.a) {
            sb.append(str);
            sb.append('\n');
        }
        try {
            us.pinguo.util.k.i(this.b, sb.toString().getBytes("UTF-8"));
        } catch (Exception unused) {
        }
    }

    public synchronized boolean b(String str) {
        if (this.a == null) {
            this.a = a();
        }
        return this.a.contains(str);
    }

    public synchronized void c(String str) {
        if (this.a == null) {
            this.a = a();
        }
        if (this.a.contains(str)) {
            return;
        }
        if (this.a.size() > 50) {
            this.a.remove(0);
        }
        this.a.add(str);
        d();
    }
}
