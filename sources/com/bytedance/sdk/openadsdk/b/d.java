package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.IOException;
import java.util.List;
/* compiled from: TotalSizeLruDiskUsage.java */
/* loaded from: classes.dex */
public class d extends b {
    protected long a = 83886080;

    @Override // com.bytedance.sdk.openadsdk.b.b
    public File a(String str, File file) throws IOException {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(long j2, int i2) {
        return j2 < this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(File file, long j2, int i2) {
        return j2 < this.a / 2;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public void a(List<File> list) {
        long b = b(list);
        o.c("TotalSizeLruDiskUsage", "当前缓存文件的总size：" + ((b / 1024) / 1024) + "MB");
        int size = list.size();
        boolean a = a(b, size);
        if (a) {
            o.c("TotalSizeLruDiskUsage", "不满足删除条件，不执行删除操作(true)" + a);
        } else {
            o.c("TotalSizeLruDiskUsage", "满足删除条件，开始执行删除操作(false)" + a);
        }
        for (File file : list) {
            if (!a) {
                o.c("TotalSizeLruDiskUsage", "满足删除条件开始删除文件......................");
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b -= length;
                    o.c("TotalSizeLruDiskUsage", "删除 一个 Cache file 当前总大小totalSize：" + ((b / 1024) / 1024) + "MB");
                } else {
                    o.e("TotalSizeLruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
                boolean a2 = a(file, b, size);
                if (a2) {
                    o.c("TotalSizeLruDiskUsage", "当前总大小totalSize：" + ((b / 1024) / 1024) + "MB，最大值存储上限maxSize=" + ((this.a / 1024) / 1024) + "MB，当前文件的总大小totalSize已小于等于maxSize一半，停止删除操作：minStopDeleteCondition=" + a2);
                    return;
                }
            }
        }
    }
}
