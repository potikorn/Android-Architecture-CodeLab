package com.example.android.sunshine.sample

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [(User::class)], version = 1) //Entities listed here
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao //Getters for Dao

}