package us.pinguo.inspire.module.MissionDetail;

import android.content.Context;
import us.pinguo.inspire.Inspire;
/* compiled from: TaskCellSize.kt */
/* loaded from: classes9.dex */
public final class TaskCellSize {
    public static final TaskCellSize INSTANCE = new TaskCellSize();
    private static final int photoCellWidth;
    private static final int photoDividerWidth;
    private static final int videoCellHeight;
    private static final int videoCellWidth;
    private static final int videoDividerWidth;

    static {
        int a;
        Context a2 = Inspire.a();
        videoDividerWidth = us.pinguo.foundation.t.b.a.a(a2, 1.5f);
        photoDividerWidth = us.pinguo.foundation.t.b.a.a(a2, 2.5f);
        int j2 = us.pinguo.foundation.t.b.a.j(a2);
        int ceil = (int) Math.ceil((j2 - (a * 2.0f)) / 3.0d);
        videoCellWidth = ceil;
        videoCellHeight = (int) ((ceil * 4.0f) / 3.0f);
        photoCellWidth = j2 / 2;
    }

    private TaskCellSize() {
    }

    public final int getPhotoCellHeight(int i2, int i3) {
        float f2 = i2 / i3;
        if (f2 > 1.3333334f) {
            f2 = 1.3333334f;
        } else if (f2 < 0.75f) {
            f2 = 0.75f;
        }
        return (int) (photoCellWidth / f2);
    }

    public final int getPhotoCellWidth() {
        return photoCellWidth;
    }

    public final int getPhotoDividerWidth() {
        return photoDividerWidth;
    }

    public final int getVideoCellHeight() {
        return videoCellHeight;
    }

    public final int getVideoCellWidth() {
        return videoCellWidth;
    }

    public final int getVideoDividerWidth() {
        return videoDividerWidth;
    }
}
