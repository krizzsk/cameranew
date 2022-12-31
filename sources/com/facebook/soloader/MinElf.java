package com.facebook.soloader;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
/* loaded from: classes.dex */
public final class MinElf {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ElfError extends RuntimeException {
        ElfError(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public enum ISA {
        NOT_SO("not_so"),
        X86("x86"),
        ARM("armeabi-v7a"),
        X86_64("x86_64"),
        AARCH64("arm64-v8a"),
        OTHERS("others");
        
        private final String value;

        ISA(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0 <= 3) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        java.lang.Thread.interrupted();
        android.util.Log.e("MinElf", "retrying extract_DT_NEEDED due to ClosedByInterruptException", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        r2 = move-exception;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] a(java.io.File r5) throws java.io.IOException {
        /*
            r0 = 0
        L1:
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r5)
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: java.lang.Throwable -> L12 java.nio.channels.ClosedByInterruptException -> L14
            java.lang.String[] r5 = b(r2)     // Catch: java.lang.Throwable -> L12 java.nio.channels.ClosedByInterruptException -> L14
            r1.close()
            return r5
        L12:
            r5 = move-exception
            goto L29
        L14:
            r2 = move-exception
            int r0 = r0 + 1
            r3 = 3
            if (r0 > r3) goto L28
            java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L12
            java.lang.String r3 = "MinElf"
            java.lang.String r4 = "retrying extract_DT_NEEDED due to ClosedByInterruptException"
            android.util.Log.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L12
            r1.close()
            goto L1
        L28:
            throw r2     // Catch: java.lang.Throwable -> L12
        L29:
            r1.close()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.MinElf.a(java.io.File):java.lang.String[]");
    }

    public static String[] b(FileChannel fileChannel) throws IOException {
        long f2;
        long j2;
        long j3;
        long j4;
        long f3;
        long j5;
        long c;
        long c2;
        long c3;
        long f4;
        long f5;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (f(fileChannel, allocate, 0L) == 1179403647) {
            boolean z = g(fileChannel, allocate, 4L) == 1;
            if (g(fileChannel, allocate, 5L) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            long f6 = z ? f(fileChannel, allocate, 28L) : c(fileChannel, allocate, 32L);
            long e2 = z ? e(fileChannel, allocate, 44L) : e(fileChannel, allocate, 56L);
            int e3 = e(fileChannel, allocate, z ? 42L : 54L);
            if (e2 == 65535) {
                long f7 = z ? f(fileChannel, allocate, 32L) : c(fileChannel, allocate, 40L);
                if (z) {
                    f5 = f(fileChannel, allocate, f7 + 28);
                } else {
                    f5 = f(fileChannel, allocate, f7 + 44);
                }
                e2 = f5;
            }
            long j6 = f6;
            long j7 = 0;
            while (true) {
                if (j7 >= e2) {
                    j2 = 0;
                    break;
                }
                if (z) {
                    f4 = f(fileChannel, allocate, j6 + 0);
                } else {
                    f4 = f(fileChannel, allocate, j6 + 0);
                }
                if (f4 != 2) {
                    j6 += e3;
                    j7++;
                } else if (z) {
                    j2 = f(fileChannel, allocate, j6 + 4);
                } else {
                    j2 = c(fileChannel, allocate, j6 + 8);
                }
            }
            long j8 = 0;
            if (j2 == 0) {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
            long j9 = j2;
            long j10 = 0;
            int i2 = 0;
            while (true) {
                boolean z2 = z;
                long f8 = z ? f(fileChannel, allocate, j9 + j8) : c(fileChannel, allocate, j9 + j8);
                if (f8 == 1) {
                    j3 = j2;
                    if (i2 == Integer.MAX_VALUE) {
                        throw new ElfError("malformed DT_NEEDED section");
                    }
                    i2++;
                } else {
                    j3 = j2;
                    if (f8 == 5) {
                        j10 = z2 ? f(fileChannel, allocate, j9 + 4) : c(fileChannel, allocate, j9 + 8);
                    }
                }
                long j11 = 16;
                j9 += z2 ? 8L : 16L;
                j8 = 0;
                if (f8 != 0) {
                    z = z2;
                    j2 = j3;
                } else if (j10 == 0) {
                    throw new ElfError("Dynamic section string-table not found");
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= e2) {
                            j4 = 0;
                            break;
                        }
                        if (z2) {
                            f3 = f(fileChannel, allocate, f6 + j8);
                        } else {
                            f3 = f(fileChannel, allocate, f6 + j8);
                        }
                        if (f3 == 1) {
                            if (z2) {
                                c = f(fileChannel, allocate, f6 + 8);
                            } else {
                                c = c(fileChannel, allocate, f6 + j11);
                            }
                            if (z2) {
                                j5 = e2;
                                c2 = f(fileChannel, allocate, f6 + 20);
                            } else {
                                j5 = e2;
                                c2 = c(fileChannel, allocate, f6 + 40);
                            }
                            if (c <= j10 && j10 < c2 + c) {
                                if (z2) {
                                    c3 = f(fileChannel, allocate, f6 + 4);
                                } else {
                                    c3 = c(fileChannel, allocate, f6 + 8);
                                }
                                j4 = c3 + (j10 - c);
                            }
                        } else {
                            j5 = e2;
                        }
                        f6 += e3;
                        i3++;
                        e2 = j5;
                        j11 = 16;
                        j8 = 0;
                    }
                    long j12 = 0;
                    if (j4 != 0) {
                        String[] strArr = new String[i2];
                        int i4 = 0;
                        while (true) {
                            long j13 = j3 + j12;
                            long f9 = z2 ? f(fileChannel, allocate, j13) : c(fileChannel, allocate, j13);
                            if (f9 == 1) {
                                strArr[i4] = d(fileChannel, allocate, (z2 ? f(fileChannel, allocate, j3 + 4) : c(fileChannel, allocate, j3 + 8)) + j4);
                                if (i4 == Integer.MAX_VALUE) {
                                    throw new ElfError("malformed DT_NEEDED section");
                                }
                                i4++;
                            }
                            j3 += z2 ? 8L : 16L;
                            if (f9 == 0) {
                                if (i4 == i2) {
                                    return strArr;
                                }
                                throw new ElfError("malformed DT_NEEDED section");
                            }
                            j12 = 0;
                        }
                    } else {
                        throw new ElfError("did not find file offset of DT_STRTAB table");
                    }
                }
            }
        } else {
            throw new ElfError("file is not ELF: 0x" + Long.toHexString(f2));
        }
    }

    private static long c(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        h(fileChannel, byteBuffer, 8, j2);
        return byteBuffer.getLong();
    }

    private static String d(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j3 = 1 + j2;
            short g2 = g(fileChannel, byteBuffer, j2);
            if (g2 != 0) {
                sb.append((char) g2);
                j2 = j3;
            } else {
                return sb.toString();
            }
        }
    }

    private static int e(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        h(fileChannel, byteBuffer, 2, j2);
        return byteBuffer.getShort() & 65535;
    }

    private static long f(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        h(fileChannel, byteBuffer, 4, j2);
        return byteBuffer.getInt() & 4294967295L;
    }

    private static short g(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        h(fileChannel, byteBuffer, 1, j2);
        return (short) (byteBuffer.get() & Draft_75.END_OF_FRAME);
    }

    private static void h(FileChannel fileChannel, ByteBuffer byteBuffer, int i2, long j2) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i2);
        while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j2)) != -1) {
            j2 += read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new ElfError("ELF file truncated");
    }
}
