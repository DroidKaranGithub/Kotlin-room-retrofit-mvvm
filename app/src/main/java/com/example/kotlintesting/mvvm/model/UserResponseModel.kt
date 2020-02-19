package com.example.kotlintesting.mvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class UserResponseModel {

    @SerializedName("page")
    @Expose
    private var page: Int? = null
    @SerializedName("per_page")
    @Expose
    private var perPage: Int? = null
    @SerializedName("total")
    @Expose
    private var total: Int? = null
    @SerializedName("total_pages")
    @Expose
    private var totalPages: Int? = null
    @SerializedName("data")
    @Expose
    private var data: List<User?>? = null

    fun getPage(): Int? {
        return page
    }

    fun setPage(page: Int?) {
        this.page = page
    }

    fun getPerPage(): Int? {
        return perPage
    }

    fun setPerPage(perPage: Int?) {
        this.perPage = perPage
    }

    fun getTotal(): Int? {
        return total
    }

    fun setTotal(total: Int?) {
        this.total = total
    }

    fun getTotalPages(): Int? {
        return totalPages
    }

    fun setTotalPages(totalPages: Int?) {
        this.totalPages = totalPages
    }

    fun getData(): List<User?>? {
        return data
    }

    fun setData(data: List<User?>?) {
        this.data = data
    }


    @Entity
    class User {

        @SerializedName("id")
        @Expose
        @PrimaryKey
        var id: Int? = null
        @SerializedName("email")
        @Expose
        var email: String? = null
        @SerializedName("first_name")
        @Expose
        var firstName: String? = null
        @SerializedName("last_name")
        @Expose
        var lastName: String? = null
        @SerializedName("avatar")
        @Expose
        var avatar: String? = null

    }
}