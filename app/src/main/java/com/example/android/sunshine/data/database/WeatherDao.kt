package com.example.android.sunshine.data.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import java.util.Date

@Dao
interface WeatherDao {
    /**
    +     * Gets the weather for a single day
    +     *
    +     * @param date The date you want weather for
    +     * @return Weather for a single day
    +     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg weather: WeatherEntry)

    /**
    +     * Inserts a list of {@link WeatherEntry} into the weather table. If there is a conflicting id
    +     * or date the weather entry uses the {@link OnConflictStrategy} of replacing the weather
    +     * forecast. The required uniqueness of these values is defined in the {@link WeatherEntry}.
    +     *
    +     * @param weather A list of weather forecasts to insert
    +     */
    @Query("SELECT * FROM weather WHERE date = :date")
    fun getWeatherByDate(date: Date): LiveData<WeatherEntry>

    /**
    +     * Selects all ids entries after a give date, inclusive. This is for easily seeing
    +     * what entries are in the database without pulling all of the data.
    +     *
    +     * @param date The date to select after (inclusive)
    +     * @return Number of future weather forecasts stored in the database
    +     */
    @Query("SELECT COUNT(id) FROM weather WHERE date >= :date")
    fun countAllFutureWeather(date: Date): Int

    /**
    +     * Deletes any weather data older than the given day
    +     *
    +     * @param date The date to delete all prior weather from (exclusive)
    +     */
    @Query("DELETE FROM weather WHERE date < :date")
    fun deleteOldWeather(date: Date)

    @Query("SELECT id, weatherIconId, date, min, max FROM weather WHERE date >= :today")
    fun getAllWeathers(today: Date): LiveData<MutableList<ListWeatherEntry>>
}