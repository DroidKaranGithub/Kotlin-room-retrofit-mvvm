package com.example.kotlintesting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintesting.R
import com.example.kotlintesting.mvvm.model.UserResponseModel
import kotlinx.android.synthetic.main.raw_list_user_filter.view.*

class UserListFilterAdapter(
    var userList: List<UserResponseModel.User>,
    var context: Context,
    var onClickListener: View.OnClickListener
) :
    RecyclerView.Adapter<UserListFilterAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var txtName = view.txtName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.raw_list_user_filter,
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
        holder.txtName.setTag(position)
        holder.txtName.setOnClickListener(onClickListener)
    }

}