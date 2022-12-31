package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.s;
/* compiled from: Uri.kt */
/* loaded from: classes.dex */
public final class UriKt {
    public static final File toFile(Uri uri) {
        s.h(uri, "<this>");
        if (s.c(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(s.q("Uri path is null: ", uri).toString());
        }
        throw new IllegalArgumentException(s.q("Uri lacks 'file' scheme: ", uri).toString());
    }

    public static final Uri toUri(String str) {
        s.h(str, "<this>");
        Uri parse = Uri.parse(str);
        s.g(parse, "parse(this)");
        return parse;
    }

    public static final Uri toUri(File file) {
        s.h(file, "<this>");
        Uri fromFile = Uri.fromFile(file);
        s.g(fromFile, "fromFile(this)");
        return fromFile;
    }
}
