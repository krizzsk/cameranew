package com.mp4parser.iso14496.part12;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes3.dex */
public final class BitRateBox extends AbstractBox {
    public static final String TYPE = "btrt";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private long avgBitrate;
    private long bufferSizeDb;
    private long maxBitrate;

    static {
        ajc$preClinit();
    }

    public BitRateBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("BitRateBox.java", BitRateBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getBufferSizeDb", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", Constants.LONG), 74);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setBufferSizeDb", "com.mp4parser.iso14496.part12.BitRateBox", Constants.LONG, "bufferSizeDb", "", "void"), 82);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getMaxBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", Constants.LONG), 90);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setMaxBitrate", "com.mp4parser.iso14496.part12.BitRateBox", Constants.LONG, "maxBitrate", "", "void"), 98);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getAvgBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", Constants.LONG), 106);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setAvgBitrate", "com.mp4parser.iso14496.part12.BitRateBox", Constants.LONG, "avgBitrate", "", "void"), 114);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.bufferSizeDb = IsoTypeReader.readUInt32(byteBuffer);
        this.maxBitrate = IsoTypeReader.readUInt32(byteBuffer);
        this.avgBitrate = IsoTypeReader.readUInt32(byteBuffer);
    }

    public long getAvgBitrate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.avgBitrate;
    }

    public long getBufferSizeDb() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.bufferSizeDb;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt32(byteBuffer, this.bufferSizeDb);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxBitrate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.avgBitrate);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 12L;
    }

    public long getMaxBitrate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.maxBitrate;
    }

    public void setAvgBitrate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.f(j2)));
        this.avgBitrate = j2;
    }

    public void setBufferSizeDb(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.f(j2)));
        this.bufferSizeDb = j2;
    }

    public void setMaxBitrate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.f(j2)));
        this.maxBitrate = j2;
    }
}
