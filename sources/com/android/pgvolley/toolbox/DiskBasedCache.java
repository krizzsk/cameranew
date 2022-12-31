package com.android.pgvolley.toolbox;

import android.os.SystemClock;
import com.android.pgvolley.Cache;
import com.android.pgvolley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    private static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CacheHeader {
        public String etag;
        public String key;
        public long lastModified;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        private CacheHeader() {
        }

        public static CacheHeader readHeader(InputStream inputStream) throws IOException {
            CacheHeader cacheHeader = new CacheHeader();
            if (DiskBasedCache.readInt(inputStream) == DiskBasedCache.CACHE_MAGIC) {
                cacheHeader.key = DiskBasedCache.readString(inputStream);
                String readString = DiskBasedCache.readString(inputStream);
                cacheHeader.etag = readString;
                if (readString.equals("")) {
                    cacheHeader.etag = null;
                }
                cacheHeader.serverDate = DiskBasedCache.readLong(inputStream);
                cacheHeader.lastModified = DiskBasedCache.readLong(inputStream);
                cacheHeader.ttl = DiskBasedCache.readLong(inputStream);
                cacheHeader.softTtl = DiskBasedCache.readLong(inputStream);
                cacheHeader.responseHeaders = DiskBasedCache.readStringStringMap(inputStream);
                return cacheHeader;
            }
            throw new IOException();
        }

        public Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.lastModified = this.lastModified;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            return entry;
        }

        public boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, DiskBasedCache.CACHE_MAGIC);
                DiskBasedCache.writeString(outputStream, this.key);
                String str = this.etag;
                if (str == null) {
                    str = "";
                }
                DiskBasedCache.writeString(outputStream, str);
                DiskBasedCache.writeLong(outputStream, this.serverDate);
                DiskBasedCache.writeLong(outputStream, this.lastModified);
                DiskBasedCache.writeLong(outputStream, this.ttl);
                DiskBasedCache.writeLong(outputStream, this.softTtl);
                DiskBasedCache.writeStringStringMap(this.responseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                VolleyLog.d("%s", e2.toString());
                return false;
            }
        }

        public CacheHeader(String str, Cache.Entry entry) {
            this.key = str;
            this.size = entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.lastModified = entry.lastModified;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CountingInputStream extends FilterInputStream {
        private int bytesRead;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.bytesRead++;
            }
            return read;
        }

        private CountingInputStream(InputStream inputStream) {
            super(inputStream);
            this.bytesRead = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = super.read(bArr, i2, i3);
            if (read != -1) {
                this.bytesRead += read;
            }
            return read;
        }
    }

    public DiskBasedCache(File file, int i2) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectory = file;
        this.mMaxCacheSizeInBytes = i2;
    }

    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    private void pruneIfNeeded(int i2) {
        long j2;
        long j3 = i2;
        if (this.mTotalSize + j3 < this.mMaxCacheSizeInBytes) {
            return;
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("Pruning old cache entries.", new Object[0]);
        }
        long j4 = this.mTotalSize;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, CacheHeader>> it = this.mEntries.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            CacheHeader value = it.next().getValue();
            if (getFileForKey(value.key).delete()) {
                j2 = j3;
                this.mTotalSize -= value.size;
            } else {
                j2 = j3;
                String str = value.key;
                VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
            }
            it.remove();
            i3++;
            if (((float) (this.mTotalSize + j2)) < this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR) {
                break;
            }
            j3 = j2;
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.mTotalSize - j4), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void putEntry(String str, CacheHeader cacheHeader) {
        if (!this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.size;
        } else {
            this.mTotalSize += cacheHeader.size - this.mEntries.get(str).size;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private static int read(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static int readInt(InputStream inputStream) throws IOException {
        return (read(inputStream) << 24) | (read(inputStream) << 0) | 0 | (read(inputStream) << 8) | (read(inputStream) << 16);
    }

    static long readLong(InputStream inputStream) throws IOException {
        return ((read(inputStream) & 255) << 0) | 0 | ((read(inputStream) & 255) << 8) | ((read(inputStream) & 255) << 16) | ((read(inputStream) & 255) << 24) | ((read(inputStream) & 255) << 32) | ((read(inputStream) & 255) << 40) | ((read(inputStream) & 255) << 48) | ((255 & read(inputStream)) << 56);
    }

    static String readString(InputStream inputStream) throws IOException {
        return new String(streamToBytes(inputStream, (int) readLong(inputStream)), "UTF-8");
    }

    static Map<String, String> readStringStringMap(InputStream inputStream) throws IOException {
        Map<String, String> hashMap;
        int readInt = readInt(inputStream);
        if (readInt == 0) {
            hashMap = Collections.emptyMap();
        } else {
            hashMap = new HashMap<>(readInt);
        }
        for (int i2 = 0; i2 < readInt; i2++) {
            hashMap.put(readString(inputStream).intern(), readString(inputStream).intern());
        }
        return hashMap;
    }

    private void removeEntry(String str) {
        CacheHeader cacheHeader = this.mEntries.get(str);
        if (cacheHeader != null) {
            this.mTotalSize -= cacheHeader.size;
            this.mEntries.remove(str);
        }
    }

    private static byte[] streamToBytes(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        if (i3 == i2) {
            return bArr;
        }
        throw new IOException("Expected " + i2 + " bytes, read " + i3 + " bytes");
    }

    static void writeInt(OutputStream outputStream, int i2) throws IOException {
        outputStream.write((i2 >> 0) & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write((i2 >> 24) & 255);
    }

    static void writeLong(OutputStream outputStream, long j2) throws IOException {
        outputStream.write((byte) (j2 >>> 0));
        outputStream.write((byte) (j2 >>> 8));
        outputStream.write((byte) (j2 >>> 16));
        outputStream.write((byte) (j2 >>> 24));
        outputStream.write((byte) (j2 >>> 32));
        outputStream.write((byte) (j2 >>> 40));
        outputStream.write((byte) (j2 >>> 48));
        outputStream.write((byte) (j2 >>> 56));
    }

    static void writeString(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeLong(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static void writeStringStringMap(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            writeInt(outputStream, map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writeString(outputStream, entry.getKey());
                writeString(outputStream, entry.getValue());
            }
            return;
        }
        writeInt(outputStream, 0);
    }

    @Override // com.android.pgvolley.Cache
    public synchronized void clear() {
        File[] listFiles = this.mRootDirectory.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        this.mEntries.clear();
        this.mTotalSize = 0L;
        VolleyLog.d("Cache cleared.", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.android.pgvolley.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.android.pgvolley.Cache.Entry get(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.Map<java.lang.String, com.android.pgvolley.toolbox.DiskBasedCache$CacheHeader> r0 = r11.mEntries     // Catch: java.lang.Throwable -> L96
            java.lang.Object r0 = r0.get(r12)     // Catch: java.lang.Throwable -> L96
            com.android.pgvolley.toolbox.DiskBasedCache$CacheHeader r0 = (com.android.pgvolley.toolbox.DiskBasedCache.CacheHeader) r0     // Catch: java.lang.Throwable -> L96
            r1 = 0
            if (r0 != 0) goto Le
            monitor-exit(r11)
            return r1
        Le:
            java.io.File r2 = r11.getFileForKey(r12)     // Catch: java.lang.Throwable -> L96
            r3 = 1
            r4 = 0
            r5 = 2
            com.android.pgvolley.toolbox.DiskBasedCache$CountingInputStream r6 = new com.android.pgvolley.toolbox.DiskBasedCache$CountingInputStream     // Catch: java.lang.Throwable -> L45 java.lang.NegativeArraySizeException -> L48 java.io.IOException -> L6a
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L45 java.lang.NegativeArraySizeException -> L48 java.io.IOException -> L6a
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L45 java.lang.NegativeArraySizeException -> L48 java.io.IOException -> L6a
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L45 java.lang.NegativeArraySizeException -> L48 java.io.IOException -> L6a
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L45 java.lang.NegativeArraySizeException -> L48 java.io.IOException -> L6a
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L45 java.lang.NegativeArraySizeException -> L48 java.io.IOException -> L6a
            com.android.pgvolley.toolbox.DiskBasedCache.CacheHeader.readHeader(r6)     // Catch: java.lang.NegativeArraySizeException -> L41 java.io.IOException -> L43 java.lang.Throwable -> L8c
            long r7 = r2.length()     // Catch: java.lang.NegativeArraySizeException -> L41 java.io.IOException -> L43 java.lang.Throwable -> L8c
            int r9 = com.android.pgvolley.toolbox.DiskBasedCache.CountingInputStream.access$100(r6)     // Catch: java.lang.NegativeArraySizeException -> L41 java.io.IOException -> L43 java.lang.Throwable -> L8c
            long r9 = (long) r9     // Catch: java.lang.NegativeArraySizeException -> L41 java.io.IOException -> L43 java.lang.Throwable -> L8c
            long r7 = r7 - r9
            int r8 = (int) r7     // Catch: java.lang.NegativeArraySizeException -> L41 java.io.IOException -> L43 java.lang.Throwable -> L8c
            byte[] r7 = streamToBytes(r6, r8)     // Catch: java.lang.NegativeArraySizeException -> L41 java.io.IOException -> L43 java.lang.Throwable -> L8c
            com.android.pgvolley.Cache$Entry r12 = r0.toCacheEntry(r7)     // Catch: java.lang.NegativeArraySizeException -> L41 java.io.IOException -> L43 java.lang.Throwable -> L8c
            r6.close()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L96
            monitor-exit(r11)
            return r12
        L3f:
            monitor-exit(r11)
            return r1
        L41:
            r0 = move-exception
            goto L4a
        L43:
            r0 = move-exception
            goto L6c
        L45:
            r12 = move-exception
            r6 = r1
            goto L8d
        L48:
            r0 = move-exception
            r6 = r1
        L4a:
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L8c
            r5[r4] = r2     // Catch: java.lang.Throwable -> L8c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L8c
            r5[r3] = r0     // Catch: java.lang.Throwable -> L8c
            com.android.pgvolley.VolleyLog.d(r7, r5)     // Catch: java.lang.Throwable -> L8c
            r11.remove(r12)     // Catch: java.lang.Throwable -> L8c
            if (r6 == 0) goto L68
            r6.close()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L96
            goto L68
        L66:
            monitor-exit(r11)
            return r1
        L68:
            monitor-exit(r11)
            return r1
        L6a:
            r0 = move-exception
            r6 = r1
        L6c:
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L8c
            r5[r4] = r2     // Catch: java.lang.Throwable -> L8c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L8c
            r5[r3] = r0     // Catch: java.lang.Throwable -> L8c
            com.android.pgvolley.VolleyLog.d(r7, r5)     // Catch: java.lang.Throwable -> L8c
            r11.remove(r12)     // Catch: java.lang.Throwable -> L8c
            if (r6 == 0) goto L8a
            r6.close()     // Catch: java.io.IOException -> L88 java.lang.Throwable -> L96
            goto L8a
        L88:
            monitor-exit(r11)
            return r1
        L8a:
            monitor-exit(r11)
            return r1
        L8c:
            r12 = move-exception
        L8d:
            if (r6 == 0) goto L95
            r6.close()     // Catch: java.io.IOException -> L93 java.lang.Throwable -> L96
            goto L95
        L93:
            monitor-exit(r11)
            return r1
        L95:
            throw r12     // Catch: java.lang.Throwable -> L96
        L96:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.pgvolley.toolbox.DiskBasedCache.get(java.lang.String):com.android.pgvolley.Cache$Entry");
    }

    public File getFileForKey(String str) {
        return new File(this.mRootDirectory, getFilenameForKey(str));
    }

    @Override // com.android.pgvolley.Cache
    public synchronized void initialize() {
        BufferedInputStream bufferedInputStream;
        if (!this.mRootDirectory.exists()) {
            if (!this.mRootDirectory.mkdirs()) {
                VolleyLog.e("Unable to create cache dir %s", this.mRootDirectory.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.mRootDirectory.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                CacheHeader readHeader = CacheHeader.readHeader(bufferedInputStream);
                readHeader.size = file.length();
                putEntry(readHeader.key, readHeader);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
            } catch (IOException unused3) {
                bufferedInputStream2 = bufferedInputStream;
                if (file != null) {
                    file.delete();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.android.pgvolley.Cache
    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0L;
            if (z) {
                entry.ttl = 0L;
            }
            put(str, entry);
        }
    }

    @Override // com.android.pgvolley.Cache
    public synchronized void put(String str, Cache.Entry entry) {
        pruneIfNeeded(entry.data.length);
        File fileForKey = getFileForKey(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileForKey));
            CacheHeader cacheHeader = new CacheHeader(str, entry);
            if (cacheHeader.writeHeader(bufferedOutputStream)) {
                bufferedOutputStream.write(entry.data);
                bufferedOutputStream.close();
                putEntry(str, cacheHeader);
            } else {
                bufferedOutputStream.close();
                VolleyLog.d("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException unused) {
            if (fileForKey.delete()) {
                return;
            }
            VolleyLog.d("Could not clean up file %s", fileForKey.getAbsolutePath());
        }
    }

    @Override // com.android.pgvolley.Cache
    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        removeEntry(str);
        if (!delete) {
            VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }

    public DiskBasedCache(File file) {
        this(file, DEFAULT_DISK_USAGE_BYTES);
    }
}
