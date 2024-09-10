package com.example.buttondaridatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.buttondaridatabase.data.Product
import com.example.buttondaridatabase.data.RectParams
import kotlinx.coroutines.flow.Flow

@Dao
interface MsButton {
    @Query("SELECT * FROM MsButtonAndroid")
    fun getAllCategory(): List<RectParams>

}

//package com.example.buttondaridatabase.dao
//
//import androidx.room.Dao
//import androidx.room.Query
//
//@Dao
//interface MsButton {
//    @Query("SELECT * FROM msbtnlocation")
//    fun getAllCategory(): List<User>
//}
//
////@Dao
////interface UserDao {
////    @Query("SELECT * FROM User")
////    fun getAllUsers(): List<User>
////
////    @Insert
////    fun insert(user: User)
////
////    @Delete
////    fun delete(user:User)
////}
