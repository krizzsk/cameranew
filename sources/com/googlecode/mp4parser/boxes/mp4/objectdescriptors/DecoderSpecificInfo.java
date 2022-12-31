package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.Hex;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
@Descriptor(tags = {5})
/* loaded from: classes2.dex */
public class DecoderSpecificInfo extends BaseDescriptor {
    byte[] bytes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.bytes, ((DecoderSpecificInfo) obj).bytes);
    }

    public int hashCode() {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int i2 = this.sizeOfInstance;
        if (i2 > 0) {
            byte[] bArr = new byte[i2];
            this.bytes = bArr;
            byteBuffer.get(bArr);
        }
    }

    public ByteBuffer serialize() {
        return ByteBuffer.wrap(this.bytes);
    }

    public int serializedSize() {
        return this.bytes.length;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderSpecificInfo");
        sb.append("{bytes=");
        byte[] bArr = this.bytes;
        sb.append(bArr == null ? "null" : Hex.encodeHex(bArr));
        sb.append('}');
        return sb.toString();
    }
}
