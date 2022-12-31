package com.growingio.android.sdk.ipc;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.utils.LogUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class VariableSharer {
    @VisibleForTesting
    static short MAGIC_NUM = 318;
    private static final String TAG = "GIO.Sharer";
    @VisibleForTesting
    ByteBuffer mByteBuffer;
    private FileChannel mFileChannel;
    int mPid;
    private boolean usingMultiProcess;
    private int totalModCount = -1;
    private int currentVariableIndex = 0;
    private int currentVariableOffset = 0;
    @VisibleForTesting
    List<VariableEntity> entityList = new ArrayList();
    @VisibleForTesting
    int metaBaseAddress = 44;
    @VisibleForTesting
    int variableBaseAddress = -1;
    boolean isFirstInit = true;

    public VariableSharer(File file, boolean z, int i2) {
        this.usingMultiProcess = z;
        this.mPid = i2;
        if (z) {
            try {
                this.mFileChannel = new RandomAccessFile(file, "rw").getChannel();
            } catch (FileNotFoundException e2) {
                LogUtil.e(TAG, "多进程共享初始化失败: ", e2);
                this.usingMultiProcess = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<Integer> getAlivePidWithLock(List<Integer> list, Set<Integer> set) {
        short s = this.mByteBuffer.getShort(2);
        for (int i2 = 0; i2 < s; i2++) {
            int i3 = this.mByteBuffer.getInt((i2 * 4) + 4);
            if (i3 >= 0 && set != null && set.contains(Integer.valueOf(i3))) {
                list.add(Integer.valueOf(i3));
            }
        }
        return list;
    }

    private void prepareMagic() {
        this.mByteBuffer.rewind();
        this.mByteBuffer.putShort(MAGIC_NUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMetaWithLock(final VariableEntity variableEntity) {
        withLockMeta(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.10
            @Override // java.lang.Runnable
            public void run() {
                VariableSharer variableSharer = VariableSharer.this;
                int i2 = variableSharer.mByteBuffer.getInt(variableSharer.metaBaseAddress);
                if (i2 != VariableSharer.this.totalModCount) {
                    VariableSharer.this.checkEntityChanged();
                }
                int index = VariableSharer.this.metaBaseAddress + ((variableEntity.getIndex() + 1) * 4);
                int i3 = VariableSharer.this.mByteBuffer.getInt(index);
                VariableSharer variableSharer2 = VariableSharer.this;
                int i4 = i2 + 1;
                variableSharer2.mByteBuffer.putInt(variableSharer2.metaBaseAddress, i4);
                VariableSharer.this.totalModCount = i4;
                int i5 = i3 + 1;
                VariableSharer.this.mByteBuffer.putInt(index, i5);
                variableEntity.setModCount(i5);
            }
        });
    }

    private void withLockData(Runnable runnable, VariableEntity variableEntity) {
        int start = this.variableBaseAddress + variableEntity.getStart();
        FileLock fileLock = null;
        try {
            try {
                this.mByteBuffer.position(start);
                fileLock = this.mFileChannel.lock(start, variableEntity.getMaxSize(), false);
                runnable.run();
                if (fileLock == null) {
                    return;
                }
            } catch (Throwable th) {
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            LogUtil.e(TAG, "数据区加锁失败: ", e2);
            if (fileLock == null) {
                return;
            }
        }
        try {
            fileLock.release();
        } catch (IOException unused2) {
        }
    }

    private void withLockMeta(Runnable runnable) {
        FileLock fileLock = null;
        try {
            try {
                FileChannel fileChannel = this.mFileChannel;
                int i2 = this.metaBaseAddress;
                fileLock = fileChannel.lock(i2, this.variableBaseAddress - i2, false);
                runnable.run();
                if (fileLock == null) {
                    return;
                }
            } catch (Exception e2) {
                LogUtil.e(TAG, "文件原信息失败", e2);
                if (fileLock == null) {
                    return;
                }
            }
            try {
                fileLock.release();
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    private void withLockProcessArea(Runnable runnable) {
        FileLock fileLock = null;
        try {
            try {
                fileLock = this.mFileChannel.lock(0L, this.metaBaseAddress, false);
                runnable.run();
                if (fileLock == null) {
                    return;
                }
            } catch (Exception e2) {
                LogUtil.e(TAG, "文件进程区加锁失败", e2);
                if (fileLock == null) {
                    return;
                }
            }
            try {
                fileLock.release();
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public int addVariableEntity(@NonNull VariableEntity variableEntity) {
        int i2 = this.currentVariableIndex;
        this.currentVariableIndex = i2 + 1;
        variableEntity.setIndex(i2);
        this.entityList.add(variableEntity);
        variableEntity.setStart(this.currentVariableOffset);
        int maxSize = this.currentVariableOffset + variableEntity.getMaxSize() + variableEntity.getLenSize();
        this.currentVariableOffset = maxSize;
        variableEntity.setEnd(maxSize);
        variableEntity.setChanged(true);
        return variableEntity.getIndex();
    }

    @VisibleForTesting
    void checkEntityChanged() {
        if (this.usingMultiProcess) {
            try {
                synchronized (this) {
                    this.mByteBuffer.position(this.metaBaseAddress);
                    int i2 = this.mByteBuffer.getInt();
                    if (this.totalModCount == i2) {
                        return;
                    }
                    for (VariableEntity variableEntity : this.entityList) {
                        int i3 = this.mByteBuffer.getInt();
                        if (i3 != variableEntity.getModCount()) {
                            variableEntity.setModCount(i3);
                            variableEntity.setChanged(true);
                        }
                    }
                    this.totalModCount = i2;
                }
            } catch (Exception e2) {
                LogUtil.e(TAG, "check changed failed: ", e2);
            }
        }
    }

    @VisibleForTesting
    void checkOrPrepareMagic() {
        this.mByteBuffer.rewind();
        try {
            short s = this.mByteBuffer.getShort();
            if (s == 0) {
                LogUtil.d(TAG, "first init multi process file");
                prepareMagic();
            } else if (s != MAGIC_NUM) {
                LogUtil.e(TAG, "文件校验失败, 多进程共享失败");
                this.usingMultiProcess = false;
            }
        } catch (BufferUnderflowException unused) {
            prepareMagic();
        }
    }

    public boolean compareAndSetIntByIndex(int i2, final int i3, final int i4) {
        final VariableEntity variableEntity = this.entityList.get(i2);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        synchronized (this) {
            if (this.usingMultiProcess) {
                withLockData(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.5
                    @Override // java.lang.Runnable
                    public void run() {
                        VariableSharer variableSharer = VariableSharer.this;
                        if (variableSharer.mByteBuffer.getInt(variableSharer.variableBaseAddress + variableEntity.getStart() + variableEntity.getLenSize()) == i3) {
                            atomicBoolean.set(true);
                            VariableSharer variableSharer2 = VariableSharer.this;
                            variableSharer2.mByteBuffer.putInt(variableSharer2.variableBaseAddress + variableEntity.getStart() + variableEntity.getLenSize(), i4);
                            VariableSharer.this.updateMetaWithLock(variableEntity);
                            return;
                        }
                        atomicBoolean.set(false);
                    }
                }, variableEntity);
            } else if (Integer.valueOf(i3).equals(variableEntity.getObj())) {
                variableEntity.setObj(Integer.valueOf(i4));
                return true;
            }
            return atomicBoolean.get();
        }
    }

    public void completeMetaData(final Set<Integer> set) {
        int i2 = this.metaBaseAddress + (this.currentVariableIndex * 4) + 4;
        this.variableBaseAddress = i2;
        if (this.usingMultiProcess) {
            try {
                this.mByteBuffer = this.mFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, this.currentVariableOffset + i2);
                withLockProcessArea(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VariableSharer.this.checkOrPrepareMagic();
                        VariableSharer.this.repairPid(set);
                    }
                });
            } catch (IOException e2) {
                LogUtil.e(TAG, "多进程映射内存失败: ", e2);
                this.usingMultiProcess = false;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.nio.channels.FileChannel, java.nio.ByteBuffer] */
    public void destroy() {
        FileChannel fileChannel = this.mFileChannel;
        if (fileChannel != null) {
            try {
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                    LogUtil.d(TAG, "close failed");
                }
            } finally {
                this.mFileChannel = null;
                this.mByteBuffer = null;
                this.usingMultiProcess = false;
            }
        }
    }

    public void dumpModCountInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("dumpModCountInfo: \n");
        synchronized (this) {
            this.mByteBuffer.position(this.metaBaseAddress);
            int i2 = this.mByteBuffer.getInt();
            sb.append("modCount=");
            sb.append(i2);
            sb.append("\n");
            for (VariableEntity variableEntity : this.entityList) {
                sb.append(variableEntity.getName());
                sb.append("'s modCount=");
                sb.append(this.mByteBuffer.getInt());
                sb.append("\n");
            }
        }
        sb.append(")");
        LogUtil.d(TAG, sb.toString());
    }

    public List<Integer> getAlivePid(final Set<Integer> set) {
        final ArrayList arrayList = new ArrayList();
        if (this.usingMultiProcess) {
            withLockProcessArea(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.2
                @Override // java.lang.Runnable
                public void run() {
                    VariableSharer.this.getAlivePidWithLock(arrayList, set);
                }
            });
        } else {
            arrayList.add(Integer.valueOf(Process.myPid()));
        }
        return arrayList;
    }

    public byte[] getDataByIndex(int i2) {
        byte[] bArr;
        checkEntityChanged();
        final VariableEntity variableEntity = this.entityList.get(i2);
        synchronized (this) {
            if (this.usingMultiProcess && variableEntity.isChanged()) {
                withLockData(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.9
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] bArr2;
                        int i3 = VariableSharer.this.mByteBuffer.getShort();
                        if (i3 == 0) {
                            bArr2 = null;
                        } else {
                            bArr2 = new byte[i3];
                            VariableSharer.this.mByteBuffer.get(bArr2);
                        }
                        variableEntity.setObj(bArr2);
                        variableEntity.setChanged(false);
                    }
                }, variableEntity);
            }
            bArr = (byte[]) variableEntity.getObj();
        }
        return bArr;
    }

    public int getIntByIndex(int i2) {
        checkEntityChanged();
        final VariableEntity variableEntity = this.entityList.get(i2);
        synchronized (this) {
            if (this.usingMultiProcess && variableEntity.isChanged()) {
                withLockData(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.6
                    @Override // java.lang.Runnable
                    public void run() {
                        VariableSharer variableSharer = VariableSharer.this;
                        variableEntity.setObj(Integer.valueOf(variableSharer.mByteBuffer.getInt(variableSharer.variableBaseAddress + variableEntity.getStart() + variableEntity.getLenSize())));
                        variableEntity.setChanged(false);
                    }
                }, variableEntity);
            }
            int i3 = 0;
            if (variableEntity.getObj() == null) {
                return 0;
            }
            if (variableEntity.getObj() != null) {
                i3 = ((Integer) variableEntity.getObj()).intValue();
            }
            return i3;
        }
    }

    public long getLongByIndex(int i2) {
        long longValue;
        checkEntityChanged();
        final VariableEntity variableEntity = this.entityList.get(i2);
        synchronized (this) {
            if (this.usingMultiProcess && variableEntity.isChanged()) {
                withLockData(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.3
                    @Override // java.lang.Runnable
                    public void run() {
                        VariableSharer variableSharer = VariableSharer.this;
                        variableEntity.setObj(Long.valueOf(variableSharer.mByteBuffer.getLong(variableSharer.variableBaseAddress + variableEntity.getStart() + variableEntity.getLenSize())));
                        variableEntity.setChanged(false);
                    }
                }, variableEntity);
            }
            longValue = variableEntity.getObj() == null ? 0L : ((Long) variableEntity.getObj()).longValue();
        }
        return longValue;
    }

    public String getStringByIndex(int i2) {
        byte[] dataByIndex = getDataByIndex(i2);
        if (dataByIndex == null || dataByIndex.length == 0) {
            return null;
        }
        return new String(dataByIndex);
    }

    public boolean isFirstInit() {
        return this.isFirstInit;
    }

    public boolean isUsingMultiProcess() {
        return this.usingMultiProcess;
    }

    public void putDataByIndex(int i2, @Nullable final byte[] bArr) {
        final VariableEntity variableEntity = this.entityList.get(i2);
        synchronized (this) {
            variableEntity.setObj(bArr);
            if (this.usingMultiProcess) {
                withLockData(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.8
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] bArr2 = bArr;
                        int length = bArr2 == null ? 0 : bArr2.length;
                        if (variableEntity.getLenSize() == 2) {
                            VariableSharer.this.mByteBuffer.putShort((short) length);
                        } else if (variableEntity.getLenSize() == 4) {
                            VariableSharer.this.mByteBuffer.putInt(length);
                        } else {
                            throw new IllegalStateException("String type len must be 2 or 4");
                        }
                        byte[] bArr3 = bArr;
                        if (bArr3 != null) {
                            VariableSharer.this.mByteBuffer.put(bArr3);
                        }
                        VariableSharer.this.updateMetaWithLock(variableEntity);
                    }
                }, variableEntity);
            }
        }
    }

    public void putIntByIndex(int i2, final int i3) {
        final VariableEntity variableEntity = this.entityList.get(i2);
        synchronized (this) {
            variableEntity.setObj(Integer.valueOf(i3));
            if (this.usingMultiProcess) {
                withLockData(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VariableSharer variableSharer = VariableSharer.this;
                        variableSharer.mByteBuffer.putInt(variableSharer.variableBaseAddress + variableEntity.getStart() + variableEntity.getLenSize(), i3);
                        VariableSharer.this.updateMetaWithLock(variableEntity);
                    }
                }, variableEntity);
            }
        }
    }

    public void putLongByIndex(int i2, final long j2) {
        final VariableEntity variableEntity = this.entityList.get(i2);
        synchronized (this) {
            variableEntity.setObj(Long.valueOf(j2));
            if (this.usingMultiProcess) {
                withLockData(new Runnable() { // from class: com.growingio.android.sdk.ipc.VariableSharer.4
                    @Override // java.lang.Runnable
                    public void run() {
                        VariableSharer variableSharer = VariableSharer.this;
                        variableSharer.mByteBuffer.putLong(variableSharer.variableBaseAddress + variableEntity.getStart() + variableEntity.getLenSize(), j2);
                        VariableSharer.this.updateMetaWithLock(variableEntity);
                    }
                }, variableEntity);
            }
        }
    }

    public void putStringByIndex(int i2, @Nullable String str) {
        putDataByIndex(i2, str == null ? null : str.getBytes());
    }

    void repairPid(Set<Integer> set) {
        List<Integer> alivePidWithLock = getAlivePidWithLock(new ArrayList(), set);
        if (alivePidWithLock.size() >= 10) {
            LogUtil.e(TAG, "alivePid num large than 10, failed");
            this.usingMultiProcess = false;
            return;
        }
        if (alivePidWithLock.size() == 0) {
            LogUtil.d(TAG, "find first init process, and reset variable");
            this.isFirstInit = true;
        } else {
            this.isFirstInit = false;
        }
        alivePidWithLock.add(Integer.valueOf(this.mPid));
        this.mByteBuffer.position(2);
        this.mByteBuffer.putShort((short) alivePidWithLock.size());
        for (Integer num : alivePidWithLock) {
            this.mByteBuffer.putInt(num.intValue());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VariableSharer(");
        sb.append("totalModCount=");
        sb.append(this.totalModCount);
        sb.append(", \n");
        for (VariableEntity variableEntity : this.entityList) {
            sb.append(variableEntity.getName());
            sb.append("=");
            sb.append(variableEntity.getObj());
            sb.append("\n");
        }
        sb.append(")");
        return sb.toString();
    }
}
