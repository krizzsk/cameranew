package com.tencent.stat.a;

import android.content.Context;
import com.tencent.stat.StatConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends e {
    private String a;

    /* renamed from: l  reason: collision with root package name */
    private int f8253l;
    private int m;

    public d(Context context, int i2, int i3, Throwable th) {
        super(context, i2);
        this.m = 100;
        if (th != null) {
            Throwable th2 = new Throwable(th);
            try {
                StackTraceElement[] stackTrace = th2.getStackTrace();
                if (stackTrace != null) {
                    int length = stackTrace.length;
                    int i4 = this.m;
                    if (length > i4) {
                        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i4];
                        for (int i5 = 0; i5 < this.m; i5++) {
                            stackTraceElementArr[i5] = stackTrace[i5];
                        }
                        th2.setStackTrace(stackTraceElementArr);
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th2.printStackTrace(printWriter);
            this.a = stringWriter.toString();
            this.f8253l = i3;
            printWriter.close();
        }
    }

    public d(Context context, int i2, String str, int i3, int i4) {
        super(context, i2);
        this.m = 100;
        if (str != null) {
            i4 = i4 <= 0 ? StatConfig.getMaxReportEventLength() : i4;
            if (str.length() <= i4) {
                this.a = str;
            } else {
                this.a = str.substring(0, i4);
            }
        }
        this.f8253l = i3;
    }

    @Override // com.tencent.stat.a.e
    public f a() {
        return f.ERROR;
    }

    public void a(long j2) {
        this.c = j2;
    }

    @Override // com.tencent.stat.a.e
    public boolean a(JSONObject jSONObject) {
        com.tencent.stat.common.k.a(jSONObject, "er", this.a);
        jSONObject.put("ea", this.f8253l);
        return true;
    }
}
