package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class SampleDependencyTypeBox extends AbstractFullBox {
    public static final String TYPE = "sdtp";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private List<Entry> entries;

    /* loaded from: classes.dex */
    public static class Entry {
        private int value;

        public Entry(int i2) {
            this.value = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((Entry) obj).value;
        }

        public int getReserved() {
            return (this.value >> 6) & 3;
        }

        public int getSampleDependsOn() {
            return (this.value >> 4) & 3;
        }

        public int getSampleHasRedundancy() {
            return this.value & 3;
        }

        public int getSampleIsDependentOn() {
            return (this.value >> 2) & 3;
        }

        public int hashCode() {
            return this.value;
        }

        public void setReserved(int i2) {
            this.value = ((i2 & 3) << 6) | (this.value & 63);
        }

        public void setSampleDependsOn(int i2) {
            this.value = ((i2 & 3) << 4) | (this.value & 207);
        }

        public void setSampleHasRedundancy(int i2) {
            this.value = (i2 & 3) | (this.value & 252);
        }

        public void setSampleIsDependentOn(int i2) {
            this.value = ((i2 & 3) << 2) | (this.value & 243);
        }

        public String toString() {
            return "Entry{reserved=" + getReserved() + ", sampleDependsOn=" + getSampleDependsOn() + ", sampleIsDependentOn=" + getSampleIsDependentOn() + ", sampleHasRedundancy=" + getSampleHasRedundancy() + '}';
        }
    }

    static {
        ajc$preClinit();
    }

    public SampleDependencyTypeBox() {
        super(TYPE);
        this.entries = new ArrayList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleDependencyTypeBox.java", SampleDependencyTypeBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.util.List"), 139);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "java.util.List", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "void"), 143);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.lang.String"), 148);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        while (byteBuffer.remaining() > 0) {
            this.entries.add(new Entry(IsoTypeReader.readUInt8(byteBuffer)));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (Entry entry : this.entries) {
            IsoTypeWriter.writeUInt8(byteBuffer, entry.value);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.entries.size() + 4;
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
        return "SampleDependencyTypeBox{entries=" + this.entries + '}';
    }
}
