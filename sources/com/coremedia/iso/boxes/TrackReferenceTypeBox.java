package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class TrackReferenceTypeBox extends AbstractBox {
    public static final String TYPE1 = "hint";
    public static final String TYPE2 = "cdsc";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private long[] trackIds;

    static {
        ajc$preClinit();
    }

    public TrackReferenceTypeBox(String str) {
        super(str);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackReferenceTypeBox.java", TrackReferenceTypeBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getTrackIds", "com.coremedia.iso.boxes.TrackReferenceTypeBox", "", "", "", "[J"), 40);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.TrackReferenceTypeBox", "", "", "", "java.lang.String"), 65);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining() / 4;
        this.trackIds = new long[remaining];
        for (int i2 = 0; i2 < remaining; i2++) {
            this.trackIds[i2] = IsoTypeReader.readUInt32(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        for (long j2 : this.trackIds) {
            IsoTypeWriter.writeUInt32(byteBuffer, j2);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.trackIds.length * 4;
    }

    public long[] getTrackIds() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.trackIds;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("TrackReferenceTypeBox[type=");
        sb.append(getType());
        for (int i2 = 0; i2 < this.trackIds.length; i2++) {
            sb.append(";trackId");
            sb.append(i2);
            sb.append("=");
            sb.append(this.trackIds[i2]);
        }
        sb.append("]");
        return sb.toString();
    }
}
