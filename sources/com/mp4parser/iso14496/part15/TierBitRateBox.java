package com.mp4parser.iso14496.part15;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes3.dex */
public class TierBitRateBox extends AbstractBox {
    public static final String TYPE = "tibr";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    long avgBitRate;
    long baseBitRate;
    long maxBitRate;
    long tierAvgBitRate;
    long tierBaseBitRate;
    long tierMaxBitRate;

    static {
        ajc$preClinit();
    }

    public TierBitRateBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TierBitRateBox.java", TierBitRateBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", Constants.LONG), 52);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", Constants.LONG, "baseBitRate", "", "void"), 56);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "getTierAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", Constants.LONG), 92);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setTierAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", Constants.LONG, "tierAvgBitRate", "", "void"), 96);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", Constants.LONG), 60);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", Constants.LONG, "maxBitRate", "", "void"), 64);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", Constants.LONG), 68);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", Constants.LONG, "avgBitRate", "", "void"), 72);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getTierBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", Constants.LONG), 76);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setTierBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", Constants.LONG, "tierBaseBitRate", "", "void"), 80);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getTierMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", Constants.LONG), 84);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setTierMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", Constants.LONG, "tierMaxBitRate", "", "void"), 88);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.baseBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.maxBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.avgBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.tierBaseBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.tierMaxBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.tierAvgBitRate = IsoTypeReader.readUInt32(byteBuffer);
    }

    public long getAvgBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.avgBitRate;
    }

    public long getBaseBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.baseBitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt32(byteBuffer, this.baseBitRate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxBitRate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.avgBitRate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.tierBaseBitRate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.tierMaxBitRate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.tierAvgBitRate);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 24L;
    }

    public long getMaxBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.maxBitRate;
    }

    public long getTierAvgBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.tierAvgBitRate;
    }

    public long getTierBaseBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.tierBaseBitRate;
    }

    public long getTierMaxBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.tierMaxBitRate;
    }

    public void setAvgBitRate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.f(j2)));
        this.avgBitRate = j2;
    }

    public void setBaseBitRate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.f(j2)));
        this.baseBitRate = j2;
    }

    public void setMaxBitRate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.f(j2)));
        this.maxBitRate = j2;
    }

    public void setTierAvgBitRate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, h.a.a.a.a.f(j2)));
        this.tierAvgBitRate = j2;
    }

    public void setTierBaseBitRate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.f(j2)));
        this.tierBaseBitRate = j2;
    }

    public void setTierMaxBitRate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, h.a.a.a.a.f(j2)));
        this.tierMaxBitRate = j2;
    }
}
