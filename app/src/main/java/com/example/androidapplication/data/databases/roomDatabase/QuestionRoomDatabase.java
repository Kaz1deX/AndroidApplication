package com.example.androidapplication.data.databases.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.androidapplication.data.databases.dao.QuestionDao;
import com.example.androidapplication.data.databases.entity.QuestionEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {QuestionEntity.class}, version = 1, exportSchema = false)
public abstract class QuestionRoomDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();
    private static volatile QuestionRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static QuestionRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuestionRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    QuestionRoomDatabase.class, "question_database")
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
                QuestionDao dao = INSTANCE.questionDao();
                dao.deleteAll();
                QuestionEntity question = new QuestionEntity("Вопрос №1","Легко");
                dao.insert(question);
                question = new QuestionEntity("Вопрос №2","Легко");
                dao.insert(question);
            });
        }
    };
}