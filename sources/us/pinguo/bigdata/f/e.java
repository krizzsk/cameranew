package us.pinguo.bigdata.f;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
/* compiled from: IOUtil.java */
/* loaded from: classes3.dex */
public class e {
    public static PrintStream a(String str, boolean z) {
        try {
            return new PrintStream(new FileOutputStream(str, z));
        } catch (FileNotFoundException e2) {
            us.pinguo.common.log.a.g("IOUtil", "create stream FileNotFoundException", new Object[0]);
            e2.printStackTrace();
            return null;
        }
    }
}
