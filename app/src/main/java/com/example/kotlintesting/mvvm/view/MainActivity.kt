package com.example.kotlintesting.mvvm.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintesting.R
import com.example.kotlintesting.adapter.UserListAdapter
import com.example.kotlintesting.adapter.UserListFilterAdapter
import com.example.kotlintesting.mvvm.model.UserResponseModel
import com.example.kotlintesting.mvvm.viewModel.MainViewModel
import com.example.kotlintesting.room.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var viewModel: MainViewModel
    lateinit var layoutManager: LinearLayoutManager
    lateinit var horizontallayoutManager: LinearLayoutManager
    lateinit var adapter: UserListAdapter
    lateinit var hotizontalAdapter: UserListFilterAdapter
    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        layoutManager = LinearLayoutManager(this)
        horizontallayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerViewUserList.layoutManager = layoutManager
        recyclerViewTop.layoutManager = horizontallayoutManager
        appDatabase = AppDatabase.getDatabase(this)


//        if (isOnline())
        viewModel.requestGetUser("2")
//        else
//            appDatabase.userDao().getAllUser().let { appDatabase.userDao().getAllUser() }

        setObserver()
    }

    private fun setObserver() {

        viewModel.responseGetUser().observe(this, Observer { response ->
            if (response != null) {
                response.getData()?.let {
                    appDatabase.userDao()
                        .insertAll(response.getData() as List<UserResponseModel.User>)
                }
                response.getData()?.let { setData(it) }
            }
            setData(appDatabase.userDao().getAllUser().let { appDatabase.userDao().getAllUser() })
        })
    }

    private fun setData(list: Any) {
        adapter = UserListAdapter(
            list as List<UserResponseModel.User>,
            this
        )
        recyclerViewUserList.adapter = adapter




        hotizontalAdapter = UserListFilterAdapter(list, this, this)
        recyclerViewTop.adapter = hotizontalAdapter
    }

    override fun onClick(view: View) {
        when (view.id) {

            R.id.txtName -> {

                var lastpos = view.getTag()

//                println("last pos " + appDatabase.userDao().getAllUser().let {
//                    appDatabase.userDao().findByName(
//                        hotizontalAdapter.userList.get(lastpos as Int).firstName!!,
//                        hotizontalAdapter.userList.get(lastpos).lastName!!
//                    )
//                })

                adapter = UserListAdapter(appDatabase.userDao().getAllUser().let {
                    appDatabase.userDao().findByName(
                        hotizontalAdapter.userList.get(lastpos as Int).firstName!!,
                        hotizontalAdapter.userList.get(lastpos).lastName!!
                    )
                }, this)
                recyclerViewUserList.adapter = adapter

            }
        }
    }


}
