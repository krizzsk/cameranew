package com.coremedia.iso.boxes.apple;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public final class AppleLosslessSpecificBox extends AbstractFullBox {
    public static final String TYPE = "alac";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_20 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_21 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    private long bitRate;
    private int channels;
    private int historyMult;
    private int initialHistory;
    private int kModifier;
    private long maxCodedFrameSize;
    private long maxSamplePerFrame;
    private long sampleRate;
    private int sampleSize;
    private int unknown1;
    private int unknown2;

    static {
        ajc$preClinit();
    }

    public AppleLosslessSpecificBox() {
        super("alac");
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AppleLosslessSpecificBox.java", AppleLosslessSpecificBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getMaxSamplePerFrame", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", Constants.LONG), 34);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setMaxSamplePerFrame", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "maxSamplePerFrame", "", "void"), 38);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "getKModifier", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 74);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setKModifier", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "kModifier", "", "void"), 78);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "getChannels", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 82);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "setChannels", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "channels", "", "void"), 86);
        ajc$tjp_14 = bVar.h("method-execution", bVar.g("1", "getUnknown2", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 90);
        ajc$tjp_15 = bVar.h("method-execution", bVar.g("1", "setUnknown2", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "unknown2", "", "void"), 94);
        ajc$tjp_16 = bVar.h("method-execution", bVar.g("1", "getMaxCodedFrameSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", Constants.LONG), 98);
        ajc$tjp_17 = bVar.h("method-execution", bVar.g("1", "setMaxCodedFrameSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "maxCodedFrameSize", "", "void"), 102);
        ajc$tjp_18 = bVar.h("method-execution", bVar.g("1", "getBitRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", Constants.LONG), 106);
        ajc$tjp_19 = bVar.h("method-execution", bVar.g("1", "setBitRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "bitRate", "", "void"), 110);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getUnknown1", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 42);
        ajc$tjp_20 = bVar.h("method-execution", bVar.g("1", "getSampleRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", Constants.LONG), 114);
        ajc$tjp_21 = bVar.h("method-execution", bVar.g("1", "setSampleRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "sampleRate", "", "void"), 118);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setUnknown1", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "unknown1", "", "void"), 46);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getSampleSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 50);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setSampleSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "sampleSize", "", "void"), 54);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getHistoryMult", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 58);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setHistoryMult", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "historyMult", "", "void"), 62);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getInitialHistory", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 66);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setInitialHistory", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "initialHistory", "", "void"), 70);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.maxSamplePerFrame = IsoTypeReader.readUInt32(byteBuffer);
        this.unknown1 = IsoTypeReader.readUInt8(byteBuffer);
        this.sampleSize = IsoTypeReader.readUInt8(byteBuffer);
        this.historyMult = IsoTypeReader.readUInt8(byteBuffer);
        this.initialHistory = IsoTypeReader.readUInt8(byteBuffer);
        this.kModifier = IsoTypeReader.readUInt8(byteBuffer);
        this.channels = IsoTypeReader.readUInt8(byteBuffer);
        this.unknown2 = IsoTypeReader.readUInt16(byteBuffer);
        this.maxCodedFrameSize = IsoTypeReader.readUInt32(byteBuffer);
        this.bitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.sampleRate = IsoTypeReader.readUInt32(byteBuffer);
    }

    public long getBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_18, this, this));
        return this.bitRate;
    }

    public int getChannels() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return this.channels;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxSamplePerFrame);
        IsoTypeWriter.writeUInt8(byteBuffer, this.unknown1);
        IsoTypeWriter.writeUInt8(byteBuffer, this.sampleSize);
        IsoTypeWriter.writeUInt8(byteBuffer, this.historyMult);
        IsoTypeWriter.writeUInt8(byteBuffer, this.initialHistory);
        IsoTypeWriter.writeUInt8(byteBuffer, this.kModifier);
        IsoTypeWriter.writeUInt8(byteBuffer, this.channels);
        IsoTypeWriter.writeUInt16(byteBuffer, this.unknown2);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxCodedFrameSize);
        IsoTypeWriter.writeUInt32(byteBuffer, this.bitRate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.sampleRate);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 28L;
    }

    public int getHistoryMult() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.historyMult;
    }

    public int getInitialHistory() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.initialHistory;
    }

    public int getKModifier() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.kModifier;
    }

    public long getMaxCodedFrameSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_16, this, this));
        return this.maxCodedFrameSize;
    }

    public long getMaxSamplePerFrame() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.maxSamplePerFrame;
    }

    public long getSampleRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_20, this, this));
        return this.sampleRate;
    }

    public int getSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.sampleSize;
    }

    public int getUnknown1() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.unknown1;
    }

    public int getUnknown2() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_14, this, this));
        return this.unknown2;
    }

    public void setBitRate(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_19, this, this, h.a.a.a.a.e(i2)));
        this.bitRate = i2;
    }

    public void setChannels(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, h.a.a.a.a.e(i2)));
        this.channels = i2;
    }

    public void setHistoryMult(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.e(i2)));
        this.historyMult = i2;
    }

    public void setInitialHistory(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, h.a.a.a.a.e(i2)));
        this.initialHistory = i2;
    }

    public void setKModifier(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, h.a.a.a.a.e(i2)));
        this.kModifier = i2;
    }

    public void setMaxCodedFrameSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_17, this, this, h.a.a.a.a.e(i2)));
        this.maxCodedFrameSize = i2;
    }

    public void setMaxSamplePerFrame(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        this.maxSamplePerFrame = i2;
    }

    public void setSampleRate(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_21, this, this, h.a.a.a.a.e(i2)));
        this.sampleRate = i2;
    }

    public void setSampleSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.e(i2)));
        this.sampleSize = i2;
    }

    public void setUnknown1(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.e(i2)));
        this.unknown1 = i2;
    }

    public void setUnknown2(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, h.a.a.a.a.e(i2)));
        this.unknown2 = i2;
    }
}
