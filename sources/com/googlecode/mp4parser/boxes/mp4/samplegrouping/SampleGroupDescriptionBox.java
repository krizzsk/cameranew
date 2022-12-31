package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import com.growingio.android.sdk.monitor.BuildConfig;
import com.mp4parser.iso14496.part15.StepwiseTemporalLayerEntry;
import com.mp4parser.iso14496.part15.SyncSampleEntry;
import com.mp4parser.iso14496.part15.TemporalLayerSampleGroup;
import com.mp4parser.iso14496.part15.TemporalSubLayerSampleGroup;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class SampleGroupDescriptionBox extends AbstractFullBox {
    public static final String TYPE = "sgpd";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private int defaultLength;
    private List<GroupEntry> groupEntries;

    static {
        ajc$preClinit();
    }

    public SampleGroupDescriptionBox() {
        super(TYPE);
        this.groupEntries = new LinkedList();
        setVersion(1);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleGroupDescriptionBox.java", SampleGroupDescriptionBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), BuildConfig.VERSION_CODE);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 149);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), 153);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 157);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "equals", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", "o", "", TypedValues.Custom.S_BOOLEAN), 162);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 183);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 191);
    }

    private GroupEntry parseGroupEntry(ByteBuffer byteBuffer, String str) {
        GroupEntry unknownEntry;
        if (RollRecoveryEntry.TYPE.equals(str)) {
            unknownEntry = new RollRecoveryEntry();
        } else if (RateShareEntry.TYPE.equals(str)) {
            unknownEntry = new RateShareEntry();
        } else if (CencSampleEncryptionInformationGroupEntry.TYPE.equals(str)) {
            unknownEntry = new CencSampleEncryptionInformationGroupEntry();
        } else if (VisualRandomAccessEntry.TYPE.equals(str)) {
            unknownEntry = new VisualRandomAccessEntry();
        } else if (TemporalLevelEntry.TYPE.equals(str)) {
            unknownEntry = new TemporalLevelEntry();
        } else if (SyncSampleEntry.TYPE.equals(str)) {
            unknownEntry = new SyncSampleEntry();
        } else if (TemporalLayerSampleGroup.TYPE.equals(str)) {
            unknownEntry = new TemporalLayerSampleGroup();
        } else if (TemporalSubLayerSampleGroup.TYPE.equals(str)) {
            unknownEntry = new TemporalSubLayerSampleGroup();
        } else if (StepwiseTemporalLayerEntry.TYPE.equals(str)) {
            unknownEntry = new StepwiseTemporalLayerEntry();
        } else {
            unknownEntry = new UnknownEntry(str);
        }
        unknownEntry.parse(byteBuffer);
        return unknownEntry;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            String read4cc = IsoTypeReader.read4cc(byteBuffer);
            if (getVersion() == 1) {
                this.defaultLength = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
            }
            long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
            while (true) {
                long j2 = readUInt32 - 1;
                if (readUInt32 <= 0) {
                    return;
                }
                int i2 = this.defaultLength;
                if (getVersion() == 1) {
                    if (this.defaultLength == 0) {
                        i2 = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
                    }
                    int position = byteBuffer.position() + i2;
                    ByteBuffer slice = byteBuffer.slice();
                    slice.limit(i2);
                    this.groupEntries.add(parseGroupEntry(slice, read4cc));
                    byteBuffer.position(position);
                    readUInt32 = j2;
                } else {
                    throw new RuntimeException("This should be implemented");
                }
            }
        } else {
            throw new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        }
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SampleGroupDescriptionBox sampleGroupDescriptionBox = (SampleGroupDescriptionBox) obj;
        if (this.defaultLength != sampleGroupDescriptionBox.defaultLength) {
            return false;
        }
        List<GroupEntry> list = this.groupEntries;
        List<GroupEntry> list2 = sampleGroupDescriptionBox.groupEntries;
        return list == null ? list2 == null : list.equals(list2);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(IsoFile.fourCCtoBytes(this.groupEntries.get(0).getType()));
        if (getVersion() == 1) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.defaultLength);
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.groupEntries.size());
        for (GroupEntry groupEntry : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                IsoTypeWriter.writeUInt32(byteBuffer, groupEntry.get().limit());
            }
            byteBuffer.put(groupEntry.get());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        long j2 = (getVersion() == 1 ? 12L : 8L) + 4;
        for (GroupEntry groupEntry : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                j2 += 4;
            }
            j2 += groupEntry.size();
        }
        return j2;
    }

    public int getDefaultLength() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.defaultLength;
    }

    public List<GroupEntry> getGroupEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.groupEntries;
    }

    public int hashCode() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        int i2 = (this.defaultLength + 0) * 31;
        List<GroupEntry> list = this.groupEntries;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public void setDefaultLength(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        this.defaultLength = i2;
    }

    public void setGroupEntries(List<GroupEntry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, list));
        this.groupEntries = list;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        StringBuilder sb = new StringBuilder("SampleGroupDescriptionBox{groupingType='");
        sb.append(this.groupEntries.size() > 0 ? this.groupEntries.get(0).getType() : "????");
        sb.append('\'');
        sb.append(", defaultLength=");
        sb.append(this.defaultLength);
        sb.append(", groupEntries=");
        sb.append(this.groupEntries);
        sb.append('}');
        return sb.toString();
    }
}
