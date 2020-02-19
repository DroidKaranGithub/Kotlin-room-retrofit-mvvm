package com.example.kotlintesting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlintesting.R
import com.example.kotlintesting.adapter.UserListAdapter.MyViewHolder
import com.example.kotlintesting.mvvm.model.UserResponseModel
import kotlinx.android.synthetic.main.raw_list_user.view.*

class UserListAdapter(var userList: List<UserResponseModel.User>, var context: Context) :
    RecyclerView.Adapter<MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var txtName = view.txtName
        var txtEmail = view.txtEmail
        var txtId = view.txtId
        var imgAvatar = view.imgAvatar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.raw_list_user,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return userList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var user = userList.get(position)

        holder.txtName.text = user.firstName + " " + user.lastName
        holder.txtEmail.text = user.email
        holder.txtId.text = "ID : ${user.id}"

        Glide
            .with(context)
            .load(user.avatar)
            .centerCrop()
            .into(holder.imgAvatar);

    }

}