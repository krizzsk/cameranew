package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.util.List;
/* compiled from: TotalCountLruDiskFile.java */
/* loaded from: classes.dex */
public class c extends b {
    private int a;
    private int b;

    public c(int i2, int i3) {
        this.a = 15;
        this.b = 3;
        if (i2 > 0) {
            this.a = i2;
            this.b = i3;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.b.b
    public boolean a(long j2, int i2) {
        return i2 <= this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.b.b
    public boolean a(File file, long j2, int i2) {
        return i2 <= this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected void a(List<File> list) {
        long b = b(list);
        int size = list.size();
        if (a(b, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                b -= length;
                o.c("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
            } else {
                o.c("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
            }
            if (a(file, b, size)) {
                return;
            }
        }
    }
}
