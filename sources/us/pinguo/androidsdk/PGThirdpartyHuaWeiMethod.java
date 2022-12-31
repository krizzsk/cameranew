package us.pinguo.androidsdk;
/* loaded from: classes3.dex */
public class PGThirdpartyHuaWeiMethod {

    /* loaded from: classes3.dex */
    public class PGThirdpartyHuaWeiStruct {
        private byte[] dc_buf;
        private byte[] edof_buf;
        private boolean splite;
        private byte[] sr_buf;

        public PGThirdpartyHuaWeiStruct(boolean z, int i2, int i3, int i4) {
            this.splite = z;
            this.sr_buf = new byte[i2];
            this.edof_buf = new byte[i3];
            this.dc_buf = new byte[i4];
        }

        public byte[] getDCBuffer() {
            return this.dc_buf;
        }

        public byte[] getEDOFBuffer() {
            return this.edof_buf;
        }

        public byte[] getSRBuffer() {
            return this.sr_buf;
        }

        public boolean getSplite() {
            return this.splite;
        }
    }

    public static void combineHuaWeiJpeg(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        PGNativeMethod.combineHuaWeiJpegToFile(bArr, bArr2, bArr3, str);
    }

    public static PGThirdpartyHuaWeiStruct spliteHuaWeiJpeg(String str) {
        return PGNativeMethod.spliteHuaWeiJpegFromFile(str);
    }

    public static PGThirdpartyHuaWeiStruct spliteHuaWeiJpeg(byte[] bArr) {
        return PGNativeMethod.spliteHuaWeiJpegFromBuffer(bArr);
    }
}
