package com.wiseman.paul.androidroomtypeconverter.ui

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.wiseman.paul.androidroomtypeconverter.databinding.ActivityMainBinding
import com.wiseman.paul.androidroomtypeconverter.model.Person
import com.wiseman.paul.androidroomtypeconverter.viewmodel.MyViewModel
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { MyAdapter() }
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val person = Person("John", "Doe", getBitmap())
            myViewModel.insertPerson(person)
        }

        myViewModel.readPerson.observe(this, {
            adapter.setData(it)
        })


    }
    private suspend fun getBitmap(): Bitmap{
        val loading = ImageLoader(this)
        val request = ImageRequest.Builder(this)
            .data("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png")
            .build()
        val  result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }
}