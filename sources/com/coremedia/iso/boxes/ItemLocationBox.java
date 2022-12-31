package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class ItemLocationBox extends AbstractFullBox {
    public static final String TYPE = "iloc";
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
    public int baseOffsetSize;
    public int indexSize;
    public List<Item> items;
    public int lengthSize;
    public int offsetSize;

    static {
        ajc$preClinit();
    }

    public ItemLocationBox() {
        super(TYPE);
        this.offsetSize = 8;
        this.lengthSize = 8;
        this.baseOffsetSize = 8;
        this.indexSize = 0;
        this.items = new LinkedList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ItemLocationBox.java", ItemLocationBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 119);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "offsetSize", "", "void"), 123);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "createItem", "com.coremedia.iso.boxes.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "com.coremedia.iso.boxes.ItemLocationBox$Item"), 160);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "createExtent", "com.coremedia.iso.boxes.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "com.coremedia.iso.boxes.ItemLocationBox$Extent"), 285);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 127);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "lengthSize", "", "void"), 131);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 135);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "baseOffsetSize", "", "void"), 139);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 143);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "indexSize", "", "void"), 147);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getItems", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "java.util.List"), 151);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setItems", "com.coremedia.iso.boxes.ItemLocationBox", "java.util.List", FirebaseAnalytics.Param.ITEMS, "", "void"), 155);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.offsetSize = readUInt8 >>> 4;
        this.lengthSize = readUInt8 & 15;
        int readUInt82 = IsoTypeReader.readUInt8(byteBuffer);
        this.baseOffsetSize = readUInt82 >>> 4;
        if (getVersion() == 1) {
            this.indexSize = readUInt82 & 15;
        }
        int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
        for (int i2 = 0; i2 < readUInt16; i2++) {
            this.items.add(new Item(byteBuffer));
        }
    }

    public Extent createExtent(long j2, long j3, long j4) {
        RequiresParseDetailAspect.aspectOf().before(b.f(ajc$tjp_11, this, this, new Object[]{h.a.a.a.a.f(j2), h.a.a.a.a.f(j3), h.a.a.a.a.f(j4)}));
        return new Extent(j2, j3, j4);
    }

    public Item createItem(int i2, int i3, int i4, long j2, List<Extent> list) {
        RequiresParseDetailAspect.aspectOf().before(b.f(ajc$tjp_10, this, this, new Object[]{h.a.a.a.a.e(i2), h.a.a.a.a.e(i3), h.a.a.a.a.e(i4), h.a.a.a.a.f(j2), list}));
        return new Item(i2, i3, i4, j2, list);
    }

    public int getBaseOffsetSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.baseOffsetSize;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt8(byteBuffer, (this.offsetSize << 4) | this.lengthSize);
        if (getVersion() == 1) {
            IsoTypeWriter.writeUInt8(byteBuffer, (this.baseOffsetSize << 4) | this.indexSize);
        } else {
            IsoTypeWriter.writeUInt8(byteBuffer, this.baseOffsetSize << 4);
        }
        IsoTypeWriter.writeUInt16(byteBuffer, this.items.size());
        for (Item item : this.items) {
            item.getContent(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        long j2 = 8;
        for (Item item : this.items) {
            j2 += item.getSize();
        }
        return j2;
    }

    public int getIndexSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.indexSize;
    }

    public List<Item> getItems() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.items;
    }

    public int getLengthSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.lengthSize;
    }

    public int getOffsetSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.offsetSize;
    }

    public void setBaseOffsetSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.e(i2)));
        this.baseOffsetSize = i2;
    }

    public void setIndexSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.e(i2)));
        this.indexSize = i2;
    }

    public void setItems(List<Item> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, list));
        this.items = list;
    }

    public void setLengthSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.e(i2)));
        this.lengthSize = i2;
    }

    public void setOffsetSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        this.offsetSize = i2;
    }

    Extent createExtent(ByteBuffer byteBuffer) {
        return new Extent(byteBuffer);
    }

    Item createItem(ByteBuffer byteBuffer) {
        return new Item(byteBuffer);
    }

    /* loaded from: classes.dex */
    public class Extent {
        public long extentIndex;
        public long extentLength;
        public long extentOffset;

        public Extent(long j2, long j3, long j4) {
            this.extentOffset = j2;
            this.extentLength = j3;
            this.extentIndex = j4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Extent extent = (Extent) obj;
            return this.extentIndex == extent.extentIndex && this.extentLength == extent.extentLength && this.extentOffset == extent.extentOffset;
        }

        public void getContent(ByteBuffer byteBuffer) {
            int i2;
            if (ItemLocationBox.this.getVersion() == 1 && (i2 = ItemLocationBox.this.indexSize) > 0) {
                IsoTypeWriterVariable.write(this.extentIndex, byteBuffer, i2);
            }
            IsoTypeWriterVariable.write(this.extentOffset, byteBuffer, ItemLocationBox.this.offsetSize);
            IsoTypeWriterVariable.write(this.extentLength, byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public int getSize() {
            ItemLocationBox itemLocationBox = ItemLocationBox.this;
            int i2 = itemLocationBox.indexSize;
            if (i2 <= 0) {
                i2 = 0;
            }
            return i2 + itemLocationBox.offsetSize + itemLocationBox.lengthSize;
        }

        public int hashCode() {
            long j2 = this.extentOffset;
            long j3 = this.extentLength;
            long j4 = this.extentIndex;
            return (((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)));
        }

        public String toString() {
            return "Extent{extentOffset=" + this.extentOffset + ", extentLength=" + this.extentLength + ", extentIndex=" + this.extentIndex + '}';
        }

        public Extent(ByteBuffer byteBuffer) {
            int i2;
            if (ItemLocationBox.this.getVersion() == 1 && (i2 = ItemLocationBox.this.indexSize) > 0) {
                this.extentIndex = IsoTypeReaderVariable.read(byteBuffer, i2);
            }
            this.extentOffset = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.offsetSize);
            this.extentLength = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.lengthSize);
        }
    }

    /* loaded from: classes.dex */
    public class Item {
        public long baseOffset;
        public int constructionMethod;
        public int dataReferenceIndex;
        public List<Extent> extents;
        public int itemId;

        public Item(ByteBuffer byteBuffer) {
            this.extents = new LinkedList();
            this.itemId = IsoTypeReader.readUInt16(byteBuffer);
            if (ItemLocationBox.this.getVersion() == 1) {
                this.constructionMethod = IsoTypeReader.readUInt16(byteBuffer) & 15;
            }
            this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBuffer);
            int i2 = ItemLocationBox.this.baseOffsetSize;
            if (i2 > 0) {
                this.baseOffset = IsoTypeReaderVariable.read(byteBuffer, i2);
            } else {
                this.baseOffset = 0L;
            }
            int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
            for (int i3 = 0; i3 < readUInt16; i3++) {
                this.extents.add(new Extent(byteBuffer));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Item item = (Item) obj;
            if (this.baseOffset == item.baseOffset && this.constructionMethod == item.constructionMethod && this.dataReferenceIndex == item.dataReferenceIndex && this.itemId == item.itemId) {
                List<Extent> list = this.extents;
                List<Extent> list2 = item.extents;
                return list == null ? list2 == null : list.equals(list2);
            }
            return false;
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.writeUInt16(byteBuffer, this.itemId);
            if (ItemLocationBox.this.getVersion() == 1) {
                IsoTypeWriter.writeUInt16(byteBuffer, this.constructionMethod);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.dataReferenceIndex);
            int i2 = ItemLocationBox.this.baseOffsetSize;
            if (i2 > 0) {
                IsoTypeWriterVariable.write(this.baseOffset, byteBuffer, i2);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.extents.size());
            for (Extent extent : this.extents) {
                extent.getContent(byteBuffer);
            }
        }

        public int getSize() {
            int i2 = (ItemLocationBox.this.getVersion() == 1 ? 4 : 2) + 2 + ItemLocationBox.this.baseOffsetSize + 2;
            for (Extent extent : this.extents) {
                i2 += extent.getSize();
            }
            return i2;
        }

        public int hashCode() {
            long j2 = this.baseOffset;
            int i2 = ((((((this.itemId * 31) + this.constructionMethod) * 31) + this.dataReferenceIndex) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            List<Extent> list = this.extents;
            return i2 + (list != null ? list.hashCode() : 0);
        }

        public void setBaseOffset(long j2) {
            this.baseOffset = j2;
        }

        public String toString() {
            return "Item{baseOffset=" + this.baseOffset + ", itemId=" + this.itemId + ", constructionMethod=" + this.constructionMethod + ", dataReferenceIndex=" + this.dataReferenceIndex + ", extents=" + this.extents + '}';
        }

        public Item(int i2, int i3, int i4, long j2, List<Extent> list) {
            this.extents = new LinkedList();
            this.itemId = i2;
            this.constructionMethod = i3;
            this.dataReferenceIndex = i4;
            this.baseOffset = j2;
            this.extents = list;
        }
    }
}
