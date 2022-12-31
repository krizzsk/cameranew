package us.pinguo.repository2020.database.sticker;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
/* compiled from: StickerTableDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface e {
    @Query("DELETE FROM stickerPackage WHERE id = :stickerId")
    void a(String str);

    @Query("DELETE FROM stickerPackage WHERE id IN (:stickerIdList)")
    void b(List<String> list);

    @Insert(onConflict = 1)
    void c(StickerTable stickerTable);

    @Update
    void d(StickerTable stickerTable);

    @Query("SELECT * FROM stickerPackage")
    List<StickerTable> getAll();
}
