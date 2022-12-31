package com.facebook.ads.redexgen.X;

import android.net.Uri;
import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.io.DataInputStream;
import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public class VD extends DownloadAction.Deserializer {
    public VD(String str, int i2) {
        super(str, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.exoplayer2.offline.DownloadAction.Deserializer
    /* renamed from: A00 */
    public final VC A01(int i2, DataInputStream dataInputStream) throws IOException {
        Uri parse = Uri.parse(dataInputStream.readUTF());
        boolean readBoolean = dataInputStream.readBoolean();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        return new VC(parse, readBoolean, bArr, dataInputStream.readBoolean() ? dataInputStream.readUTF() : null);
    }
}
