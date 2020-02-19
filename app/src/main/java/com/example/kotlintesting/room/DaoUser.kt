package com.example.kotlintesting.room

import androidx.room.*
import com.example.kotlintesting.mvvm.model.UserResponseModel

@Dao
interface DaoUser {

    @Query("Select * from user")
    fun getAllUser():List<UserResponseModel.User>

    @Query("select * from user where id in (:userIds)")
    fun loadAllByIds(userIds: IntArray):List<UserResponseModel.User>

    @Query("select * from user where firstName like :first or lastName like :last")
    fun findByName(first: String, last: String): List<UserResponseModel.User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( user: List<UserResponseModel.User>)

    @Delete
    fun dalete(user: UserResponseModel.User)


}