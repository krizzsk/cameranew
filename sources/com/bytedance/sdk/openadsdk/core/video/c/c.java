package com.bytedance.sdk.openadsdk.core.video.c;

import com.bytedance.sdk.openadsdk.utils.i;
import java.io.File;
import java.util.List;
/* compiled from: TotalCountLruDiskDir.java */
/* loaded from: classes.dex */
public class c extends com.bytedance.sdk.openadsdk.b.c {
    public c(int i2, int i3) {
        super(i2, i3);
    }

    @Override // com.bytedance.sdk.openadsdk.b.c, com.bytedance.sdk.openadsdk.b.b
    protected void a(List<File> list) {
        int size = list.size();
        if (a(0L, size)) {
            return;
        }
        for (File file : list) {
            i.c(file);
            size--;
            if (a(file, 0L, size)) {
                return;
            }
        }
    }
}
