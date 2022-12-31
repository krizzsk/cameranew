package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class EditListBox extends AbstractFullBox {
    public static final String TYPE = "elst";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private List<Entry> entries;

    static {
        ajc$preClinit();
    }

    public EditListBox() {
        super(TYPE);
        this.entries = new LinkedList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("EditListBox.java", EditListBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getEntries", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.util.List"), 68);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setEntries", "com.coremedia.iso.boxes.EditListBox", "java.util.List", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "void"), 72);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.lang.String"), 108);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int l2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        this.entries = new LinkedList();
        for (int i2 = 0; i2 < l2i; i2++) {
            this.entries.add(new Entry(this, byteBuffer));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            entry.getContent(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int size;
        if (getVersion() == 1) {
            size = this.entries.size() * 20;
        } else {
            size = this.entries.size() * 12;
        }
        return size + 8;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "EditListBox{entries=" + this.entries + '}';
    }

    /* loaded from: classes.dex */
    public static class Entry {
        EditListBox editListBox;
        private double mediaRate;
        private long mediaTime;
        private long segmentDuration;

        public Entry(EditListBox editListBox, long j2, long j3, double d2) {
            this.segmentDuration = j2;
            this.mediaTime = j3;
            this.mediaRate = d2;
            this.editListBox = editListBox;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.mediaTime == entry.mediaTime && this.segmentDuration == entry.segmentDuration;
        }

        public void getContent(ByteBuffer byteBuffer) {
            if (this.editListBox.getVersion() == 1) {
                IsoTypeWriter.writeUInt64(byteBuffer, this.segmentDuration);
                byteBuffer.putLong(this.mediaTime);
            } else {
                IsoTypeWriter.writeUInt32(byteBuffer, CastUtils.l2i(this.segmentDuration));
                byteBuffer.putInt(CastUtils.l2i(this.mediaTime));
            }
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.mediaRate);
        }

        public double getMediaRate() {
            return this.mediaRate;
        }

        public long getMediaTime() {
            return this.mediaTime;
        }

        public long getSegmentDuration() {
            return this.segmentDuration;
        }

        public int hashCode() {
            long j2 = this.segmentDuration;
            long j3 = this.mediaTime;
            return (((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        public void setMediaRate(double d2) {
            this.mediaRate = d2;
        }

        public void setMediaTime(long j2) {
            this.mediaTime = j2;
        }

        public void setSegmentDuration(long j2) {
            this.segmentDuration = j2;
        }

        public String toString() {
            return "Entry{segmentDuration=" + this.segmentDuration + ", mediaTime=" + this.mediaTime + ", mediaRate=" + this.mediaRate + '}';
        }

        public Entry(EditListBox editListBox, ByteBuffer byteBuffer) {
            if (editListBox.getVersion() == 1) {
                this.segmentDuration = IsoTypeReader.readUInt64(byteBuffer);
                this.mediaTime = byteBuffer.getLong();
                this.mediaRate = IsoTypeReader.readFixedPoint1616(byteBuffer);
            } else {
                this.segmentDuration = IsoTypeReader.readUInt32(byteBuffer);
                this.mediaTime = byteBuffer.getInt();
                this.mediaRate = IsoTypeReader.readFixedPoint1616(byteBuffer);
            }
            this.editListBox = editListBox;
        }
    }
}
