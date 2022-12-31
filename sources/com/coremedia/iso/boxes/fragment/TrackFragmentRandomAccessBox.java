package com.coremedia.iso.boxes.fragment;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.growingio.android.sdk.monitor.BuildConfig;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class TrackFragmentRandomAccessBox extends AbstractFullBox {
    public static final String TYPE = "tfra";
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
    private List<Entry> entries;
    private int lengthSizeOfSampleNum;
    private int lengthSizeOfTrafNum;
    private int lengthSizeOfTrunNum;
    private int reserved;
    private long trackId;

    /* loaded from: classes.dex */
    public static class Entry {
        private long moofOffset;
        private long sampleNumber;
        private long time;
        private long trafNumber;
        private long trunNumber;

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
            return this.moofOffset == entry.moofOffset && this.sampleNumber == entry.sampleNumber && this.time == entry.time && this.trafNumber == entry.trafNumber && this.trunNumber == entry.trunNumber;
        }

        public long getMoofOffset() {
            return this.moofOffset;
        }

        public long getSampleNumber() {
            return this.sampleNumber;
        }

        public long getTime() {
            return this.time;
        }

        public long getTrafNumber() {
            return this.trafNumber;
        }

        public long getTrunNumber() {
            return this.trunNumber;
        }

        public int hashCode() {
            long j2 = this.time;
            long j3 = this.moofOffset;
            long j4 = this.trafNumber;
            long j5 = this.trunNumber;
            long j6 = this.sampleNumber;
            return (((((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)));
        }

        public void setMoofOffset(long j2) {
            this.moofOffset = j2;
        }

        public void setSampleNumber(long j2) {
            this.sampleNumber = j2;
        }

        public void setTime(long j2) {
            this.time = j2;
        }

        public void setTrafNumber(long j2) {
            this.trafNumber = j2;
        }

        public void setTrunNumber(long j2) {
            this.trunNumber = j2;
        }

        public String toString() {
            return "Entry{time=" + this.time + ", moofOffset=" + this.moofOffset + ", trafNumber=" + this.trafNumber + ", trunNumber=" + this.trunNumber + ", sampleNumber=" + this.sampleNumber + '}';
        }

        public Entry(long j2, long j3, long j4, long j5, long j6) {
            this.moofOffset = j3;
            this.sampleNumber = j6;
            this.time = j2;
            this.trafNumber = j4;
            this.trunNumber = j5;
        }
    }

    static {
        ajc$preClinit();
    }

    public TrackFragmentRandomAccessBox() {
        super(TYPE);
        this.lengthSizeOfTrafNum = 2;
        this.lengthSizeOfTrunNum = 2;
        this.lengthSizeOfSampleNum = 2;
        this.entries = Collections.emptyList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackFragmentRandomAccessBox.java", TrackFragmentRandomAccessBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", Constants.LONG, "trackId", "", "void"), BuildConfig.VERSION_CODE);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrafNum", "", "void"), 149);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.util.List"), 185);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "java.util.List", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "void"), 189);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.lang.String"), 290);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "setLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrunNum", "", "void"), 153);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfSampleNum", "", "void"), 157);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", Constants.LONG), 161);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "getReserved", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 165);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 169);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "getLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 173);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 177);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "getNumberOfEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", Constants.LONG), 181);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = IsoTypeReader.readUInt32(byteBuffer);
        long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
        this.reserved = (int) (readUInt32 >> 6);
        this.lengthSizeOfTrafNum = (((int) (63 & readUInt32)) >> 4) + 1;
        this.lengthSizeOfTrunNum = (((int) (12 & readUInt32)) >> 2) + 1;
        this.lengthSizeOfSampleNum = ((int) (readUInt32 & 3)) + 1;
        long readUInt322 = IsoTypeReader.readUInt32(byteBuffer);
        this.entries = new ArrayList();
        for (int i2 = 0; i2 < readUInt322; i2++) {
            Entry entry = new Entry();
            if (getVersion() == 1) {
                entry.time = IsoTypeReader.readUInt64(byteBuffer);
                entry.moofOffset = IsoTypeReader.readUInt64(byteBuffer);
            } else {
                entry.time = IsoTypeReader.readUInt32(byteBuffer);
                entry.moofOffset = IsoTypeReader.readUInt32(byteBuffer);
            }
            entry.trafNumber = IsoTypeReaderVariable.read(byteBuffer, this.lengthSizeOfTrafNum);
            entry.trunNumber = IsoTypeReaderVariable.read(byteBuffer, this.lengthSizeOfTrunNum);
            entry.sampleNumber = IsoTypeReaderVariable.read(byteBuffer, this.lengthSizeOfSampleNum);
            this.entries.add(entry);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
        IsoTypeWriter.writeUInt32(byteBuffer, (this.reserved << 6) | (((this.lengthSizeOfTrafNum - 1) & 3) << 4) | (((this.lengthSizeOfTrunNum - 1) & 3) << 2) | ((this.lengthSizeOfSampleNum - 1) & 3));
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            if (getVersion() == 1) {
                IsoTypeWriter.writeUInt64(byteBuffer, entry.time);
                IsoTypeWriter.writeUInt64(byteBuffer, entry.moofOffset);
            } else {
                IsoTypeWriter.writeUInt32(byteBuffer, entry.time);
                IsoTypeWriter.writeUInt32(byteBuffer, entry.moofOffset);
            }
            IsoTypeWriterVariable.write(entry.trafNumber, byteBuffer, this.lengthSizeOfTrafNum);
            IsoTypeWriterVariable.write(entry.trunNumber, byteBuffer, this.lengthSizeOfTrunNum);
            IsoTypeWriterVariable.write(entry.sampleNumber, byteBuffer, this.lengthSizeOfSampleNum);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int size;
        if (getVersion() == 1) {
            size = this.entries.size() * 16;
        } else {
            size = this.entries.size() * 8;
        }
        return 16 + size + (this.lengthSizeOfTrafNum * this.entries.size()) + (this.lengthSizeOfTrunNum * this.entries.size()) + (this.lengthSizeOfSampleNum * this.entries.size());
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return Collections.unmodifiableList(this.entries);
    }

    public int getLengthSizeOfSampleNum() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.lengthSizeOfSampleNum;
    }

    public int getLengthSizeOfTrafNum() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.lengthSizeOfTrafNum;
    }

    public int getLengthSizeOfTrunNum() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return this.lengthSizeOfTrunNum;
    }

    public long getNumberOfEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_9, this, this));
        return this.entries.size();
    }

    public int getReserved() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.reserved;
    }

    public long getTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.trackId;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, list));
        this.entries = list;
    }

    public void setLengthSizeOfSampleNum(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.e(i2)));
        this.lengthSizeOfSampleNum = i2;
    }

    public void setLengthSizeOfTrafNum(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        this.lengthSizeOfTrafNum = i2;
    }

    public void setLengthSizeOfTrunNum(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, h.a.a.a.a.e(i2)));
        this.lengthSizeOfTrunNum = i2;
    }

    public void setTrackId(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_0, this, this, h.a.a.a.a.f(j2)));
        this.trackId = j2;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return "TrackFragmentRandomAccessBox{trackId=" + this.trackId + ", entries=" + this.entries + '}';
    }
}
