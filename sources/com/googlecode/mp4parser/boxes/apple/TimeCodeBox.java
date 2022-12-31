package com.googlecode.mp4parser.boxes.apple;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.sampleentry.SampleEntry;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* loaded from: classes2.dex */
public class TimeCodeBox extends AbstractBox implements SampleEntry {
    public static final String TYPE = "tmcd";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    int dataReferenceIndex;
    long flags;
    int frameDuration;
    int numberOfFrames;
    int reserved1;
    int reserved2;
    byte[] rest;
    int timeScale;

    static {
        ajc$preClinit();
    }

    public TimeCodeBox() {
        super(TYPE);
        this.rest = new byte[0];
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TimeCodeBox.java", TimeCodeBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 81);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "dataReferenceIndex", "", "void"), 85);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "setReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", BigAlbumStore.PhotoColumns.RESERVED1, "", "void"), 130);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "getReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 134);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "setReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", BigAlbumStore.PhotoColumns.RESERVED2, "", "void"), 138);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "getFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", Constants.LONG), 142);
        ajc$tjp_14 = bVar.h("method-execution", bVar.g("1", "setFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", Constants.LONG, "flags", "", "void"), 146);
        ajc$tjp_15 = bVar.h("method-execution", bVar.g("1", "getRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "[B"), 150);
        ajc$tjp_16 = bVar.h("method-execution", bVar.g("1", "setRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "[B", "rest", "", "void"), 154);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.lang.String"), 91);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 102);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "setTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "timeScale", "", "void"), 106);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 110);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "frameDuration", "", "void"), 114);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "getNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 118);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "setNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "numberOfFrames", "", "void"), 122);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "getReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 126);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBuffer);
        this.reserved1 = byteBuffer.getInt();
        this.flags = IsoTypeReader.readUInt32(byteBuffer);
        this.timeScale = byteBuffer.getInt();
        this.frameDuration = byteBuffer.getInt();
        this.numberOfFrames = IsoTypeReader.readUInt8(byteBuffer);
        this.reserved2 = IsoTypeReader.readUInt24(byteBuffer);
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.rest = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(new byte[6]);
        IsoTypeWriter.writeUInt16(byteBuffer, this.dataReferenceIndex);
        byteBuffer.putInt(this.reserved1);
        IsoTypeWriter.writeUInt32(byteBuffer, this.flags);
        byteBuffer.putInt(this.timeScale);
        byteBuffer.putInt(this.frameDuration);
        IsoTypeWriter.writeUInt8(byteBuffer, this.numberOfFrames);
        IsoTypeWriter.writeUInt24(byteBuffer, this.reserved2);
        byteBuffer.put(this.rest);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.rest.length + 28;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.SampleEntry
    public int getDataReferenceIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.dataReferenceIndex;
    }

    public long getFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_13, this, this));
        return this.flags;
    }

    public int getFrameDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.frameDuration;
    }

    public int getNumberOfFrames() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return this.numberOfFrames;
    }

    public int getReserved1() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_9, this, this));
        return this.reserved1;
    }

    public int getReserved2() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_11, this, this));
        return this.reserved2;
    }

    public byte[] getRest() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_15, this, this));
        return this.rest;
    }

    public int getTimeScale() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.timeScale;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.SampleEntry
    public void setDataReferenceIndex(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        this.dataReferenceIndex = i2;
    }

    public void setFlags(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_14, this, this, h.a.a.a.a.f(j2)));
        this.flags = j2;
    }

    public void setFrameDuration(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_6, this, this, h.a.a.a.a.e(i2)));
        this.frameDuration = i2;
    }

    public void setNumberOfFrames(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_8, this, this, h.a.a.a.a.e(i2)));
        this.numberOfFrames = i2;
    }

    public void setReserved1(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, h.a.a.a.a.e(i2)));
        this.reserved1 = i2;
    }

    public void setReserved2(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_12, this, this, h.a.a.a.a.e(i2)));
        this.reserved2 = i2;
    }

    public void setRest(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_16, this, this, bArr));
        this.rest = bArr;
    }

    public void setTimeScale(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, h.a.a.a.a.e(i2)));
        this.timeScale = i2;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "TimeCodeBox{timeScale=" + this.timeScale + ", frameDuration=" + this.frameDuration + ", numberOfFrames=" + this.numberOfFrames + ", reserved1=" + this.reserved1 + ", reserved2=" + this.reserved2 + ", flags=" + this.flags + '}';
    }
}
