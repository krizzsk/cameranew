package com.coremedia.iso.boxes.fragment;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class TrackFragmentBaseMediaDecodeTimeBox extends AbstractFullBox {
    public static final String TYPE = "tfdt";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private long baseMediaDecodeTime;

    static {
        ajc$preClinit();
    }

    public TrackFragmentBaseMediaDecodeTimeBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackFragmentBaseMediaDecodeTimeBox.java", TrackFragmentBaseMediaDecodeTimeBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getBaseMediaDecodeTime", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", Constants.LONG), 65);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setBaseMediaDecodeTime", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", Constants.LONG, "baseMediaDecodeTime", "", "void"), 69);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "java.lang.String"), 74);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.baseMediaDecodeTime = IsoTypeReader.readUInt64(byteBuffer);
        } else {
            this.baseMediaDecodeTime = IsoTypeReader.readUInt32(byteBuffer);
        }
    }

    public long getBaseMediaDecodeTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.baseMediaDecodeTime;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            IsoTypeWriter.writeUInt64(byteBuffer, this.baseMediaDecodeTime);
        } else {
            IsoTypeWriter.writeUInt32(byteBuffer, this.baseMediaDecodeTime);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return getVersion() == 0 ? 8 : 12;
    }

    public void setBaseMediaDecodeTime(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.f(j2)));
        this.baseMediaDecodeTime = j2;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "TrackFragmentBaseMediaDecodeTimeBox{baseMediaDecodeTime=" + this.baseMediaDecodeTime + '}';
    }
}
