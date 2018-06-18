package com.example.android.sunshine.sample

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.graphics.Bitmap
import android.arch.persistence.room.PrimaryKey

// Creates a table named users.
// tableName is the property name, users is the value
@Entity(tableName = "users")
class User {
    @PrimaryKey // Denotes id as the primary key
    var id: Int = 0
    var firstName: String? = null
    var lastName: String? = null

    @Ignore // Tells Room to ignore this field
    var picture: Bitmap? = null
}
