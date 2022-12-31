package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
/* loaded from: classes3.dex */
public class i extends h {
    public static String b(File file) {
        String z0;
        s.h(file, "<this>");
        String name = file.getName();
        s.g(name, "name");
        z0 = StringsKt__StringsKt.z0(name, '.', "");
        return z0;
    }

    public static String c(File file) {
        String G0;
        s.h(file, "<this>");
        String name = file.getName();
        s.g(name, "name");
        G0 = StringsKt__StringsKt.G0(name, ".", null, 2, null);
        return G0;
    }
}
