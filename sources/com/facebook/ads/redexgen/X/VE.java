package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.PrivateCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.TimeSignalCommand;
import java.nio.ByteBuffer;
/* loaded from: assets/audience_network.dex */
public final class VE implements E3 {
    public static String[] A03 = {"TasyJMHsWGEkz863ImR0Q5Lz0Jv5KZRl", "wAvcoPGmhTOD2UdnkI7mjYYyFDdz6tY4", "tIFolEUfJcQQhLLKuuKqSvXZilOQ0d41", "wnba1Mxhk7UAzMMhJxuW", "IqdHVgHf3sWcJ9J53HVfrlZmkyidEDTw", "kUaC4Xj2GLTFGhk3U8FgQLf5h3yptWRi", "yAL9OJMifRSpz7GOwtKlA6RWbWPVLH5t", "1By3yk2Axs3IVYX9txEI"};
    @Nullable
    public C0919Ih A00;
    public final IV A02 = new IV();
    public final IU A01 = new IU();

    @Override // com.facebook.ads.redexgen.X.E3
    public final Metadata A4f(C0775Cp c0775Cp) throws E4 {
        if (this.A00 == null || c0775Cp.A00 != this.A00.A05()) {
            this.A00 = new C0919Ih(((WZ) c0775Cp).A00);
            this.A00.A06(((WZ) c0775Cp).A00 - c0775Cp.A00);
        }
        ByteBuffer byteBuffer = c0775Cp.A01;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.A02.A0b(array, limit);
        this.A01.A0C(array, limit);
        this.A01.A08(39);
        int size = this.A01.A04(1);
        long ptsAdjustment = this.A01.A04(32);
        long j2 = (size << 32) | ptsAdjustment;
        this.A01.A08(20);
        int A04 = this.A01.A04(12);
        int spliceCommandType = this.A01.A04(8);
        SpliceCommand command = null;
        this.A02.A0Z(14);
        if (spliceCommandType == 0) {
            command = new SpliceNullCommand();
        } else if (spliceCommandType == 255) {
            IV iv = this.A02;
            if (A03[1].charAt(6) != 'G') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "IAVDgnOrTVyqUqMF0jCb";
            strArr[7] = "AiSzseiiVBo4zRVGAcCm";
            command = PrivateCommand.A00(iv, A04, j2);
        } else if (spliceCommandType == 4) {
            command = SpliceScheduleCommand.A00(this.A02);
        } else if (spliceCommandType == 5) {
            command = SpliceInsertCommand.A00(this.A02, j2, this.A00);
        } else if (spliceCommandType == 6) {
            command = TimeSignalCommand.A01(this.A02, j2, this.A00);
        }
        return command == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(command);
    }
}
