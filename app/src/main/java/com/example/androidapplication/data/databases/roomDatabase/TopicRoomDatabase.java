package com.example.androidapplication.data.databases.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.androidapplication.data.databases.dao.TopicDao;
import com.example.androidapplication.data.databases.entity.TopicEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TopicEntity.class}, version = 1, exportSchema = false)
public abstract class TopicRoomDatabase extends RoomDatabase {
    public abstract TopicDao topicDao();
    private static volatile TopicRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static TopicRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TopicRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TopicRoomDatabase.class, "topic_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                TopicDao dao = INSTANCE.topicDao();
                dao.deleteAll();
                TopicEntity topic = new TopicEntity("Тема №1", 5);
                dao.insert(topic);
                topic = new TopicEntity("Тема №2", 10);
                dao.insert(topic);
            });
        }
    };
}