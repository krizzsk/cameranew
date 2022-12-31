package us.pinguo.repository2020.database.sticker;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
/* compiled from: StickerItemTableDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface b {
    @Insert(onConflict = 1)
    void a(List<StickerItemTable> list);

    @Query("DELETE FROM stickerItem WHERE packageId IN (:pidList)")
    void b(List<String> list);

    @Update
    void c(List<StickerItemTable> list);

    @Query("SELECT * FROM stickerItem WHERE id = :itemId")
    StickerItemTable d(String str);

    @Insert(onConflict = 1)
    void e(StickerItemTable stickerItemTable);

    @Query("DELETE FROM stickerItem WHERE packageId = :pid")
    void f(String str);

    @Query("SELECT * FROM stickerItem")
    List<StickerItemTable> getAll();
}
