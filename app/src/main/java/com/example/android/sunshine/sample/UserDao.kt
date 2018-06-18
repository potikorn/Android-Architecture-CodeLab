package com.example.android.sunshine.sample

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao // Required annotation for Dao to be recognized by Room
interface UserDao {
    // Returns a list of all users in the database
    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    // Inserts multiple users
    @Insert
    fun insertAll(vararg users: User)

    // Deletes a single user
    @Delete
    fun delete(user: User)
}