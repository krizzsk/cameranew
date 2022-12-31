package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import java.util.Collection;
import kotlin.jvm.internal.s;
/* compiled from: Path.kt */
/* loaded from: classes.dex */
public final class PathKt {
    @RequiresApi(19)
    public static final Path and(Path path, Path p) {
        s.h(path, "<this>");
        s.h(p, "p");
        Path path2 = new Path();
        path2.op(path, p, Path.Op.INTERSECT);
        return path2;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path path, float f2) {
        s.h(path, "<this>");
        Collection<PathSegment> flatten = PathUtils.flatten(path, f2);
        s.g(flatten, "flatten(this, error)");
        return flatten;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.5f;
        }
        return flatten(path, f2);
    }

    @RequiresApi(19)
    public static final Path minus(Path path, Path p) {
        s.h(path, "<this>");
        s.h(p, "p");
        Path path2 = new Path(path);
        path2.op(p, Path.Op.DIFFERENCE);
        return path2;
    }

    @RequiresApi(19)
    public static final Path or(Path path, Path p) {
        s.h(path, "<this>");
        s.h(p, "p");
        Path path2 = new Path(path);
        path2.op(p, Path.Op.UNION);
        return path2;
    }

    @RequiresApi(19)
    public static final Path plus(Path path, Path p) {
        s.h(path, "<this>");
        s.h(p, "p");
        Path path2 = new Path(path);
        path2.op(p, Path.Op.UNION);
        return path2;
    }

    @RequiresApi(19)
    public static final Path xor(Path path, Path p) {
        s.h(path, "<this>");
        s.h(p, "p");
        Path path2 = new Path(path);
        path2.op(p, Path.Op.XOR);
        return path2;
    }
}
