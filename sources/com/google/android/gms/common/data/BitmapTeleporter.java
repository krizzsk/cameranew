package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new g();
    private final int mType;
    private final int zalk;
    private ParcelFileDescriptor zall;
    private Bitmap zalm = null;
    private boolean zaln = false;
    private File zalo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapTeleporter(int i2, ParcelFileDescriptor parcelFileDescriptor, int i3) {
        this.zalk = i2;
        this.zall = parcelFileDescriptor;
        this.mType = i3;
    }

    private static void R(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("BitmapTeleporter", "Could not close stream", e2);
        }
    }

    private final FileOutputStream S() {
        File file = this.zalo;
        if (file != null) {
            try {
                File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    this.zall = ParcelFileDescriptor.open(createTempFile, PGImageSDK.SDK_STATUS_CREATE);
                    createTempFile.delete();
                    return fileOutputStream;
                } catch (FileNotFoundException unused) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e2) {
                throw new IllegalStateException("Could not create temporary file", e2);
            }
        }
        throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
    }

    public Bitmap Q() {
        if (!this.zaln) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zall));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                    dataInputStream.read(bArr);
                    R(dataInputStream);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                    createBitmap.copyPixelsFromBuffer(wrap);
                    this.zalm = createBitmap;
                    this.zaln = true;
                } catch (IOException e2) {
                    throw new IllegalStateException("Could not read from parcel file descriptor", e2);
                }
            } catch (Throwable th) {
                R(dataInputStream);
                throw th;
            }
        }
        return this.zalm;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (this.zall == null) {
            Bitmap bitmap = this.zalm;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(S()));
            try {
                try {
                    dataOutputStream.writeInt(array.length);
                    dataOutputStream.writeInt(bitmap.getWidth());
                    dataOutputStream.writeInt(bitmap.getHeight());
                    dataOutputStream.writeUTF(bitmap.getConfig().toString());
                    dataOutputStream.write(array);
                } catch (IOException e2) {
                    throw new IllegalStateException("Could not write into unlinked file", e2);
                }
            } finally {
                R(dataOutputStream);
            }
        }
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.zall, i2 | 1, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, this.mType);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
        this.zall = null;
    }
}
