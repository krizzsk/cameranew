package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: classes2.dex */
final class n0 extends com.google.android.play.core.internal.b1 {
    private final File a;
    private final File b;
    private final NavigableMap<Long, File> c = new TreeMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(File file, File file2) throws IOException {
        this.a = file;
        this.b = file2;
        List<File> a = b3.a(file, file2);
        if (a.isEmpty()) {
            throw new bv(String.format("Virtualized slice archive empty for %s, %s", file, file2));
        }
        int size = a.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            File file3 = a.get(i2);
            this.c.put(Long.valueOf(j2), file3);
            j2 += file3.length();
        }
    }

    private final InputStream u(long j2, Long l2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.c.get(l2));
        if (fileInputStream.skip(j2 - l2.longValue()) == j2 - l2.longValue()) {
            return fileInputStream;
        }
        throw new bv(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", l2));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.play.core.internal.b1
    public final long d() {
        Map.Entry<Long, File> lastEntry = this.c.lastEntry();
        return lastEntry.getKey().longValue() + lastEntry.getValue().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.b1
    public final InputStream e(long j2, long j3) throws IOException {
        if (j2 < 0 || j3 < 0) {
            throw new bv(String.format("Invalid input parameters %s, %s", Long.valueOf(j2), Long.valueOf(j3)));
        }
        long j4 = j2 + j3;
        if (j4 <= d()) {
            Long floorKey = this.c.floorKey(Long.valueOf(j2));
            Long floorKey2 = this.c.floorKey(Long.valueOf(j4));
            if (floorKey.equals(floorKey2)) {
                return new m0(u(j2, floorKey), j3);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(u(j2, floorKey));
            Collection<File> values = this.c.subMap(floorKey, false, floorKey2, false).values();
            if (!values.isEmpty()) {
                arrayList.add(new k2(Collections.enumeration(values)));
            }
            arrayList.add(new m0(new FileInputStream((File) this.c.get(floorKey2)), j3 - (floorKey2.longValue() - j2)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new bv(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", Long.valueOf(d()), Long.valueOf(j4)));
    }
}
