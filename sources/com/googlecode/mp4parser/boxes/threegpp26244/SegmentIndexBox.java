package com.googlecode.mp4parser.boxes.threegpp26244;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes2.dex */
public class SegmentIndexBox extends AbstractFullBox {
    public static final String TYPE = "sidx";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    long earliestPresentationTime;
    List<Entry> entries;
    long firstOffset;
    long referenceId;
    int reserved;
    long timeScale;

    /* loaded from: classes2.dex */
    public static class Entry {
        byte referenceType;
        int referencedSize;
        int sapDeltaTime;
        byte sapType;
        byte startsWithSap;
        long subsegmentDuration;

        public Entry() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.referenceType == entry.referenceType && this.referencedSize == entry.referencedSize && this.sapDeltaTime == entry.sapDeltaTime && this.sapType == entry.sapType && this.startsWithSap == entry.startsWithSap && this.subsegmentDuration == entry.subsegmentDuration;
        }

        public byte getReferenceType() {
            return this.referenceType;
        }

        public int getReferencedSize() {
            return this.referencedSize;
        }

        public int getSapDeltaTime() {
            return this.sapDeltaTime;
        }

        public byte getSapType() {
            return this.sapType;
        }

        public byte getStartsWithSap() {
            return this.startsWithSap;
        }

        public long getSubsegmentDuration() {
            return this.subsegmentDuration;
        }

        public int hashCode() {
            long j2 = this.subsegmentDuration;
            return (((((((((this.referenceType * 31) + this.referencedSize) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.startsWithSap) * 31) + this.sapType) * 31) + this.sapDeltaTime;
        }

        public void setReferenceType(byte b) {
            this.referenceType = b;
        }

        public void setReferencedSize(int i2) {
            this.referencedSize = i2;
        }

        public void setSapDeltaTime(int i2) {
            this.sapDeltaTime = i2;
        }

        public void setSapType(byte b) {
            this.sapType = b;
        }

        public void setStartsWithSap(byte b) {
            this.startsWithSap = b;
        }

        public void setSubsegmentDuration(long j2) {
            this.subsegmentDuration = j2;
        }

        public String toString() {
            return "Entry{referenceType=" + ((int) this.referenceType) + ", referencedSize=" + this.referencedSize + ", subsegmentDuration=" + this.subsegmentDuration + ", startsWithSap=" + ((int) this.startsWithSap) + ", sapType=" + ((int) this.sapType) + ", sapDeltaTime=" + this.sapDeltaTime + '}';
        }

        public Entry(int i2, int i3, long j2, boolean z, int i4, int i5) {
            this.referenceType = (byte) i2;
            this.referencedSize = i3;
            this.subsegmentDuration = j2;
            this.startsWithSap = z ? (byte) 1 : (byte) 0;
            this.sapType = (byte) i4;
            this.sapDeltaTime = i5;
        }
    }

    static {
        ajc$preClinit();
    }

    public SegmentIndexBox() {
        super(TYPE);
        this.entries = new ArrayList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SegmentIndexBox.java", SegmentIndexBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.util.List"), 128);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "java.util.List", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "void"), 132);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "getReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "int"), 168);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "int", "reserved", "", "void"), 172);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.lang.String"), 298);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", Constants.LONG), 136);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", Constants.LONG, "referenceId", "", "void"), InspirePublishFragment.MAX_DESC_COUNT);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", Constants.LONG), IjkMediaMeta.FF_PROFILE_H264_HIGH_444);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", Constants.LONG, "timeScale", "", "void"), 148);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", Constants.LONG), 152);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", Constants.LONG, "earliestPresentationTime", "", "void"), 156);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", Constants.LONG), 160);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", Constants.LONG, "firstOffset", "", "void"), 164);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.referenceId = IsoTypeReader.readUInt32(byteBuffer);
        this.timeScale = IsoTypeReader.readUInt32(byteBuffer);
        if (getVersion() == 0) {
            this.earliestPresentationTime = IsoTypeReader.readUInt32(byteBuffer);
            this.firstOffset = IsoTypeReader.readUInt32(byteBuffer);
        } else {
            this.earliestPresentationTime = IsoTypeReader.readUInt64(byteBuffer);
            this.firstOffset = IsoTypeReader.readUInt64(byteBuffer);
        }
        this.reserved = IsoTypeReader.readUInt16(byteBuffer);
        int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
        for (int i2 = 0; i2 < readUInt16; i2++) {
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
            Entry entry = new Entry();
            entry.setReferenceType((byte) bitReaderBuffer.readBits(1));
            entry.setReferencedSize(bitReaderBuffer.readBits(31));
            entry.setSubsegmentDuration(IsoTypeReader.readUInt32(byteBuffer));
            BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
            entry.setStartsWithSap((byte) bitReaderBuffer2.readBits(1));
            entry.setSapType((byte) bitReaderBuffer2.readBits(3));
            entry.setSapDeltaTime(bitReaderBuffer2.readBits(28));
            this.entries.add(entry);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.referenceId);
        IsoTypeWriter.writeUInt32(byteBuffer, this.timeScale);
        if (getVersion() == 0) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.earliestPresentationTime);
            IsoTypeWriter.writeUInt32(byteBuffer, this.firstOffset);
        } else {
            IsoTypeWriter.writeUInt64(byteBuffer, this.earliestPresentationTime);
            IsoTypeWriter.writeUInt64(byteBuffer, this.firstOffset);
        }
        IsoTypeWriter.writeUInt16(byteBuffer, this.reserved);
        IsoTypeWriter.writeUInt16(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer.writeBits(entry.getReferenceType(), 1);
            bitWriterBuffer.writeBits(entry.getReferencedSize(), 31);
            IsoTypeWriter.writeUInt32(byteBuffer, entry.getSubsegmentDuration());
            BitWriterBuffer bitWriterBuffer2 = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer2.writeBits(entry.getStartsWithSap(), 1);
            bitWriterBuffer2.writeBits(entry.getSapType(), 3);
            bitWriterBuffer2.writeBits(entry.getSapDeltaTime(), 28);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 12 + (getVersion() == 0 ? 8 : 16) + 2 + 2 + (this.entries.size() * 12);
    }

    public long getEarliestPresentationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.earliestPresentationTime;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.entries;
    }

    public long getFirstOffset() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.firstOffset;
    }

    public long getReferenceId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.referenceId;
    }

    public int getReserved() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.reserved;
    }

    public long getTimeScale() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.timeScale;
    }

    public void setEarliestPresentationTime(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.f(j2)));
        this.earliestPresentationTime = j2;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    public void setFirstOffset(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, h.a.a.a.a.f(j2)));
        this.firstOffset = j2;
    }

    public void setReferenceId(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.f(j2)));
        this.referenceId = j2;
    }

    public void setReserved(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, h.a.a.a.a.e(i2)));
        this.reserved = i2;
    }

    public void setTimeScale(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.f(j2)));
        this.timeScale = j2;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return "SegmentIndexBox{entries=" + this.entries + ", referenceId=" + this.referenceId + ", timeScale=" + this.timeScale + ", earliestPresentationTime=" + this.earliestPresentationTime + ", firstOffset=" + this.firstOffset + ", reserved=" + this.reserved + '}';
    }
}
