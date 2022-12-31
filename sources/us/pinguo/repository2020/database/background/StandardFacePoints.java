package us.pinguo.repository2020.database.background;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDisplay.kt */
/* loaded from: classes6.dex */
public final class StandardFacePoints implements NoProguard {
    private final Float[] points;

    public StandardFacePoints(Float[] points) {
        s.h(points, "points");
        this.points = points;
    }

    public static /* synthetic */ StandardFacePoints copy$default(StandardFacePoints standardFacePoints, Float[] fArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fArr = standardFacePoints.points;
        }
        return standardFacePoints.copy(fArr);
    }

    public final Float[] component1() {
        return this.points;
    }

    public final StandardFacePoints copy(Float[] points) {
        s.h(points, "points");
        return new StandardFacePoints(points);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StandardFacePoints.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.background.StandardFacePoints");
            return Arrays.equals(this.points, ((StandardFacePoints) obj).points);
        }
        return false;
    }

    public final Float[] getPoints() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public String toString() {
        return "StandardFacePoints(points=" + Arrays.toString(this.points) + ')';
    }
}
