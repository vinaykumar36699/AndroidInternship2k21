package com.example.exampledatabaseoffline.RDB;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {RTable.class},version = 1,exportSchema = false)
public abstract class RDatabase extends RoomDatabase {
    public abstract RDAO rdao();
    public static RDatabase rDatabase;

    public static synchronized RDatabase getrDatabase(Context context){
        if (rDatabase==null){
            rDatabase = Room.databaseBuilder(context,RDatabase.class,"My Room")
                    .allowMainThreadQueries()
                    .build();
        }

        return rDatabase;
    }

}
